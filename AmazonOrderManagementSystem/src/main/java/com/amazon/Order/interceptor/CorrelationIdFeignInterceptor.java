package com.amazon.Order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class CorrelationIdFeignInterceptor implements RequestInterceptor {

    private static final String CORRELATION_ID ="X-Correlation-ID";

    @Override
    public void apply(RequestTemplate template) {
        String correlationId= MDC.get("correlationId");

        System.out.println("========== FEIGN REQUEST ==========");
        System.out.println("Correlation ID = " + correlationId);
        System.out.println("Trace ID       = " + MDC.get("trace_id"));
        System.out.println("Span ID        = " + MDC.get("span_id"));
        System.out.println("Traceparent    = " + template.headers().get("traceparent"));
        System.out.println("===================================");

        if(correlationId!=null&& !correlationId.isEmpty()){
            template.header("correlationId",correlationId);

            template.header(CORRELATION_ID,correlationId);
        }

    }
}
