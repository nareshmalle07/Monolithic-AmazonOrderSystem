package com.amazon.Order.service;

import org.springframework.stereotype.Service;

import com.amazon.Order.Exception.InsufficientInventoryException;
import com.amazon.Order.entity.Inventory;
import com.amazon.Order.repository.InventoryRepository;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	public void ValidateAndReserveInventory(Long productId, Long requestedQunatity) {
		System.out.println("Inventory Service ,Hey Naresh Malle!! -- Product_Id is " + productId
				+ " and requested Quantity is " + requestedQunatity);
		Inventory inventory = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new InsufficientInventoryException("hey Naresh Malle, Inventory not found "));

		if (inventory.getAvailable_Quantity() < requestedQunatity) {
			throw new InsufficientInventoryException("Insufficient Inventory");
		}

		inventory.setAvailable_Quantity(inventory.getAvailable_Quantity() - requestedQunatity);

		inventoryRepository.save(inventory);
	}
}
