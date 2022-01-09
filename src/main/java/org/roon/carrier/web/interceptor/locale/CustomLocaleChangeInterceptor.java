package org.roon.carrier.web.interceptor.locale;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        logger.info("original locale : " + request.getLocale());

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            logger.info("cookie info : " + cookie.getName() + " " + cookie.getValue() + " " + cookie.getMaxAge());
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
}
