package org.roon.carrier.web.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class MeasureInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());

        //인터셉터가 요청을 응답하지 않고 처리를 다음 단계로 계속 진행하려면 true를 리턴해야 함.
        return true;
        //return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long handlingTime = System.currentTimeMillis() - (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        log.info("handling time = " + handlingTime);

        if (modelAndView != null) {
            modelAndView.addObject("handlingTime", handlingTime);
        }
    }
}
