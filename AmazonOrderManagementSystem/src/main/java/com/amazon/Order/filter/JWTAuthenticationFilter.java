//package com.amazon.Order.filter;
//
//import com.amazon.Order.service.JWTService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//    private final JWTService jwtService;
//
//    public JWTAuthenticationFilter(JWTService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//// Step 1: Get Authorization header
//        String  authorizationHeader = request.getHeader("Authorization");
//
//// Step 2: Check whether Authorization header contains Bearer token
//
//        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//// Step 3: Extract actual JWT token
//        String token = authorizationHeader.substring(7);
//// Step 4: Validate the token
//        if(jwtService.validateToken(token)){
//            // Step 5: Extract username and role from JWT
//            String username = jwtService.extractUsername(token);
//            String role = jwtService.extractRole(token);
//
//            // Step 6: Create Spring Security Authentication object
//            UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(
//                            username,
//                            null,
//                            List.of(
//                                    new SimpleGrantedAuthority(role)
//                            )
//                    );
//
//            // Step 7: Store authenticated user in SecurityContext
//            SecurityContextHolder
//                    .getContext()
//                    .setAuthentication(authentication);
//        }
//
//        // Step 8: Continue the request through the filter chain
//        filterChain.doFilter(request, response);
//
//    }
//}
