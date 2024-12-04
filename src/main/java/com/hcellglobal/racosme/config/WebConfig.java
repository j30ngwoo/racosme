package com.hcellglobal.racosme.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 모든 도메인 허용
                .allowedMethods("*") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true); // 쿠키, 인증정보 허용
    }
}