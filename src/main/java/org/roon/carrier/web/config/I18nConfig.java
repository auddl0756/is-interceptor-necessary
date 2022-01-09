package org.roon.carrier.web.config;

import org.roon.carrier.web.interceptor.MeasureInterceptor;
import org.roon.carrier.web.interceptor.locale.CustomLocaleChangeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18nConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor())
                .addPathPatterns("/sample/**");
    }

//    @Bean
//    public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver(){
//        return new AcceptHeaderLocaleResolver();
//    }
//
//    @Bean
//    public SessionLocaleResolver sessionLocaleResolver(){
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("en","US"));
//        return localeResolver;
//    }

//
//    @Bean
//    public CookieLocaleResolver cookieLocaleResolver(){
//        return new CookieLocaleResolver();
//    }
//

//    @Bean
//    public CookieLocaleResolver localeResolver(int a){
//        return new CookieLocaleResolver();
//    }

    @Bean
//    public CookieLocaleResolver customCookieLocaleResolver(){
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("language");
        localeResolver.setCookieMaxAge(60*60);
        localeResolver.setDefaultLocale(new Locale("en"));

        return localeResolver;
    }
//
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor interceptor = new CustomLocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }
}
