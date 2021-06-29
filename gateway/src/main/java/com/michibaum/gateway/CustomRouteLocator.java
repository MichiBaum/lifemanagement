package com.michibaum.gateway;

import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRouteLocator {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, AddRequestHeaderGatewayFilterFactory throttle) {

        return builder.routes()
                .route(
                        r -> r.path("/zipkin**")
                        .uri("http://zipkin")
                ).build();

    }

}
