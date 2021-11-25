package com.jiang.mybookstore.interceptor;

import com.jiang.mybookstore.bean.Manager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 管理员登录检查
 * @author jiang
 * @create 2021-11-25-5:25 下午
 */
public class ManagerLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Manager loginManager = (Manager) session.getAttribute("loginManager");
        if(loginManager!=null){
            //如果管理员已登录则放行
            return true;
        }
        //如果管理员未登录，则拦截请求，请求转发至管理员登录界面
        request.getRequestDispatcher("/managerLogin").forward(request,response);
        return false;
    }
}
