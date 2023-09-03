package com.josheytee.niheapp.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static com.josheytee.niheapp.user.Permission.*;
import static com.josheytee.niheapp.user.Role.ADMIN;
import static com.josheytee.niheapp.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .anonymous(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                mvc.pattern("/api/v1/auth/**")
//                                mvc.pattern("/v2/api-docs"),
//                                mvc.pattern("/v3/api-docs"),
//                                mvc.pattern("/v3/api-docs/**"),
//                                mvc.pattern("/swagger-resources"),
//                                mvc.pattern("/swagger-resources/**"),
//                                mvc.pattern("/configuration/ui"),
//                                mvc.pattern("/configuration/security"),
//                                mvc.pattern("/swagger-ui/**"),
//                                mvc.pattern("/webjars/**"),
//                                mvc.pattern("/swagger-ui.html")
                        ).permitAll())
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(mvc.pattern("/api/v1/stories/**")).authenticated()
                                .requestMatchers(mvc.pattern("/api/v1/users/**")).authenticated()
                                .requestMatchers(mvc.pattern("/api/v1/management/**")).hasAnyRole(ADMIN.name(), MANAGER.name())
                                .requestMatchers(mvc.pattern(GET, "/api/v1/management/**")).hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                                .requestMatchers(mvc.pattern(POST, "/api/v1/management/**")).hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                                .requestMatchers(mvc.pattern(PUT, "/api/v1/management/**")).hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                                .requestMatchers(mvc.pattern(DELETE, "/api/v1/management/**")).hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
                                .requestMatchers(mvc.pattern("/api/v1/admin/**")).hasRole(ADMIN.name())
                                .requestMatchers(mvc.pattern(GET, "/api/v1/admin/**")).hasAuthority(ADMIN_READ.name())
                                .requestMatchers(mvc.pattern(POST, "/api/v1/admin/**")).hasAuthority(ADMIN_CREATE.name())
                                .requestMatchers(mvc.pattern(PUT, "/api/v1/admin/**")).hasAuthority(ADMIN_UPDATE.name())
                                .requestMatchers(mvc.pattern(DELETE, "/api/v1/admin/**")).hasAuthority(ADMIN_DELETE.name())
                                .anyRequest()
                                .authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout.
                        logoutUrl("/api/v1/auth/logout").addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );
        return http.build();
    }

    @Scope("prototype")
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}