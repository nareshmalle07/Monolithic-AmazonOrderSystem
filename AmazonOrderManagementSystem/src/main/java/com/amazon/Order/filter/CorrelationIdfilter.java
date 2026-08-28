package com.amazon.Order.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class CorrelationIdfilter extends OncePerRequestFilter {

    private static final String CORRELATION_ID ="X-Correlation-ID";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterchain)
        throws IOException, ServletException
    {
        // 1. Read the Correlation ID sent by API Gateway
        String CorrelationId =  request.getHeader(CORRELATION_ID);

        if(CorrelationId!=null && !CorrelationId.isEmpty()){
            MDC.put("correlationId",CorrelationId);
        }

        try {
            filterchain.doFilter(request,response);
        }finally {
            MDC.clear();
        }

    }


}
