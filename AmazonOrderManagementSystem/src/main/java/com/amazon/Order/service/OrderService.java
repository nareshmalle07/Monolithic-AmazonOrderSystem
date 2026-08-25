package com.amazon.Order.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.amazon.Order.client.ProductFeignClient;
import com.amazon.Order.dto.*;
import org.springframework.stereotype.Service;

import com.amazon.Order.Exception.InvalidQuantityException;
import com.amazon.Order.entity.Order;
import com.amazon.Order.entity.OrderItems;
import com.amazon.Order.entity.Product;
import com.amazon.Order.enums.NotificationType;
import com.amazon.Order.enums.OrderStatus;
import com.amazon.Order.enums.StateMachine.OrderStateMachine;
import com.amazon.Order.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PricingService pricingService;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private final OrderStateMachine orderStateMachine;
    private final ShipmentService shipmentService;
    private final NotificationService notificationService;
    private final ProductFeignClient productFeignClient;

    public OrderService(OrderRepository orderRepository,
                         PricingService pricingService, PaymentService paymentService,
                        InventoryService inventoryService, OrderStateMachine orderStateMachine, ShipmentService shipmentService,
                        NotificationService notificationService, ProductFeignClient productFeignClient) {
        this.orderRepository = orderRepository;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
        this.orderStateMachine = orderStateMachine;
        this.shipmentService = shipmentService;
        this.notificationService = notificationService;
        this.productFeignClient = productFeignClient;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrderRquest request) {
        System.out.println("Inside Order service - createOrder");
        OrderResponse response = new OrderResponse();
        Order order = new Order();

        validateRequest(request);

        System.out.println("Inside Order service - Request Validation done");

        order.setCustomerId(request.getCustomerId());
        order.setOrderStatus(OrderStatus.ORDER_PENDING);
        order.setCreatedAt(LocalDateTime.now());
        order.setTotalAmount(BigDecimal.ZERO);

        BigDecimal totalAmount = BigDecimal.ZERO;

        List<OrderItems> orderItems = new ArrayList<>();

        int i = 1;

        for (OrderItemRequest item : request.getItems()) {

//			Product product = productService.findById(item.getProductId());
            System.out.println("Inside order Service -Calling Product Feign client ");
            ProductResponse product = productFeignClient.findById(item.getProductId());

            System.out.println("Inside order Service -product validation done");

            ValidateQuantity(item.getQuantity());
            System.out.println("Inside Order Service -Quality validation done ");

            System.out.println("Inside Order-Service ValidateAndReserveInventory Started");

            inventoryService.ValidateAndReserveInventory(item.getProductId(), item.getQuantity());

            System.out.println("Inside Order-Service ValidateAndReserveInventory Completed ");

            System.out.println("Inside Order-Service " + order.getOrderStatus());
            orderStateMachine.transition(order, OrderStatus.INVENTORY_RESERVED);

            BigDecimal TotalPrice = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalAmount = totalAmount.add(TotalPrice);

            System.out.println("Inside Order Service - item " + i + " : product total price is: " + totalAmount);

            OrderItems orderItem = new OrderItems();
            orderItem.setCreatedAt(LocalDateTime.now());
            System.out.println("Inside Order-Service customer_id is :" + request.getCustomerId());
            orderItem.setCustomerId(request.getCustomerId());

            orderItem.setPrice(totalAmount);
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());

            System.out.println("before adding the " + i + " order Item into order items tables");
            orderItems.add(orderItem);
            System.out.println("after adding the " + i + "order Item into order items tables");
            i++;
        }

        System.out.println("Inside Order-Service, Setting the order items into Oders" + orderItems);

        order.setItems(orderItems);

        PriceCalculationResponse priceResponse = pricingService.calculatePrice(totalAmount);

        System.out.println("Inside Order-Service , Price calculation is done");

        order.setTotalAmount(priceResponse.getFinalAmount());

        System.out.println("Inside Order-Service , order.setTotalAmount(priceResponse.getFinalAmount()) ---done ");

        PaymentRequest paymentRequest = new PaymentRequest();

        Order savedOrder = orderRepository.save(order);
        System.out.println("Inside Order-Service , Order savedOrder = orderRepository.save(order); ---done ");

        paymentRequest.setOrderId(order.getId());
        paymentRequest.setAmount(order.getTotalAmount());
        paymentRequest.setPaymentType(request.getPaymentType());

        System.out.println(
                "Inside Order-Service, User requested for ----- " + paymentRequest.getPaymentType() + "----- Payment");

        PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);

        if (!"SUCCESS".equals(paymentResponse.getStatus())) {
            throw new RuntimeException("Hey Naresh, Payment Failed ");
        } else {
//            orderStateMachine.transition(savedOrder, OrderStatus.PAYMENT_COMPLETED);
        }

        ShipmentRequest shipmentRequest = new ShipmentRequest();
        shipmentRequest.setOrderId(savedOrder.getId());
//        orderStateMachine.transition(savedOrder, OrderStatus.PRODUCT_SHIPPED);

        orderRepository.save(order);

        System.out.println("Inside Order-Service, Order is SAVED in to repository");

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setOrderId(savedOrder.getId());
        notificationRequest.setNotificationType(NotificationType.EMAIL);
        notificationRequest.setMessage("Hey " + request.getCustomerId() + " , your Order Created and product Shipped....Happy Shopping ");
        NotificationResponse notificationResponse = notificationService.sendNotification(notificationRequest);

        System.out.println("notificationResponse is " + notificationResponse.getNotificationStatus());
        System.out.println(savedOrder);
        System.out.println("Saved ID = " + savedOrder.getId());
        System.out.println("Customer ID = " + savedOrder.getCustomerId());
        System.out.println("Total Orders = " + orderRepository.count());
        response.setOrderId(savedOrder.getId());
        response.setStatus(savedOrder.getOrderStatus().name());

        return response;
    }

    private void ValidateQuantity(Long quantity) {
        if (quantity == null || quantity < 0) {
            throw new InvalidQuantityException("Qunatity must be possitive integer and should be more than 0");
        }
    }

    private void validateRequest(CreateOrderRquest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request not found/can't be null ");
        }
        if (request.getCustomerId() == null) {
            throw new IllegalArgumentException("customer id cant be null");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("order items cant be null");
        }

    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}