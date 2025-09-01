package com.itsqmet.proyecto_bd2.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfiguration {
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        org.springframework.web.cors.CorsConfiguration configuracion=new org.springframework.web.cors.CorsConfiguration();
        //peticiones desde el origen angular
        configuracion.setAllowedOrigins(List.of("http://localhost:5173"));
        //permitir todos los metodos http
        configuracion.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        //PERMITE cabecera en la solicitud
        configuracion.setAllowedHeaders(List.of("*"));
        //aplicar esta configuracio na todas las rutas del back
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuracion);
        return source;

    }
}
