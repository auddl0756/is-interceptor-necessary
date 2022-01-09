package org.roon.carrier.web;

import org.roon.carrier.web.interceptor.LogInterceptor;
import org.roon.carrier.web.interceptor.MeasureInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final List<String> URL_PATTERNS = Arrays.asList("/sample/**");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor())
                .addPathPatterns(URL_PATTERNS);

        registry.addInterceptor(measureInterceptor())
                .addPathPatterns(URL_PATTERNS);
    }

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Bean
    public MeasureInterceptor measureInterceptor() {
        return new MeasureInterceptor();
    }
}
