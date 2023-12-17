package com.onlineShoppingAPI.apiGateway.config;

import jdk.jfr.Enabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
//        serverHttpSecurity.csrf((csrf) -> csrf.disable())
//                .authorizeExchange(exchange -> exchange.pathMatchers("/api/orders").permitAll().anyExchange().authenticated())
//                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
//        return ServerHttpSecurity.http().build();
//    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        return serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange.pathMatchers("/api/orders")
                        .permitAll()
                        .anyExchange().authenticated()
                ).oauth2ResourceServer((oauth) -> oauth
                        .jwt(Customizer.withDefaults()))
                .build();
    }
}
