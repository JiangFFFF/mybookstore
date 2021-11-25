package com.jiang.mybookstore.interceptor;

import com.jiang.mybookstore.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录检查与静态资源放行
 * @author jiang
 * @create 2021-11-25-4:49 下午
 */
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        //如果用户已登录则放行
        if(loginUser!=null){
            //放行
            return true;
        }

        //如果用户未登录，拦截请求，跳转登录页
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    /**
     * 目标方法完成执行之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
