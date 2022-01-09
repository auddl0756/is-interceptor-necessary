package org.roon.carrier.web.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

@Log4j2
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 적용 시점
            // handler mapping이 어떤 hanlder를 통해 요청을 처리할 지 결정한 후
            // 하지만 hanlder adapter가 요청을 실제로 처리하기는 전

        log.info("auth type? : " + request.getAuthType());

        log.info("servlet mapping ? : " + request.getHttpServletMapping());

        // return
            // true -> 실행 체인의 다음 인터셉터로 진행
            // false -> 이 인터셉터에서 응답을 처리했다고 dispatcher servlet에게 알림
            //          http error를 리턴하거나, custom response를 쓴다.(printWriter였던가?)

        //return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("이 메소드가 처리했음 : " + handlerMethod.getShortLogMessage());

        if(modelAndView != null){
            Map<String,Object> modelAttributes = modelAndView.getModel();
            modelAttributes.put("returnTime",LocalDateTime.now());
        }
    }
}
