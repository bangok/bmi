package com.maamcare.bmi.component;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录拦截器，使用sessionId存储
 *
 * */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

//        Object user = request.getSession().getAttribute("loginUser");
//        if(user == null){
//            //用户未登录
//            try {
//                response.sendRedirect(request.getContextPath()+"/user/noLogin");
//            }catch (Exception e){
//                System.out.println(e);
//            }
//            return false;
//        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
