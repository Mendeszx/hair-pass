package com.api.hairpass.configurations.securityConfig;

import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.configurations.securityConfig.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    TokenFilter tokenFilter;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.POST,"/api/v1/auth/login")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/cadastro/usuario")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/cadastro/servico")
                        .hasRole("USUARIO_EMPRESA")
                        .requestMatchers(HttpMethod.POST,"/api/v1/cadastro/funcionario-salao")
                        .hasRole("USUARIO_EMPRESA")
                        .requestMatchers(HttpMethod.POST,"/api/v1/cadastro/servico-funcionario")
                        .hasRole("USUARIO_EMPRESA")
                        .requestMatchers(HttpMethod.GET,"/api/v1/health/check")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement((sessionManagement) -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
