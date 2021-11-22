package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.Msg;
import com.jiang.mybookstore.bean.User;
import com.jiang.mybookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author jiang
 * @create 2021-11-17-12:15 上午
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录请求
     * @param user
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(User user,Model model, HttpSession session){
        User login = userService.login(new User(null,user.getUsername(),user.getPassword(),null));
        if(login!=null){
            //登录成功重定向回login_success.html；重定向防止表单重复提交
            //把登录成功后的用户保存起来
            session.removeAttribute("username");
            session.setAttribute("loginUser",login);
            return "redirect:/loginSuccess";
        }else{
            model.addAttribute("msg","账号密码错误");
            model.addAttribute("username",user.getUsername());
            return "user/login";
        }
    }

    /**
     * 去登录成功页面
     * @return
     */
    @GetMapping("/loginSuccess")
    public String loginSuccess(){
        return "user/login_success";
    }

    /**
     * 去注册成功页面
     * @return
     */
    @GetMapping("/registSuccess")
    public String registSuccess(){
        return "user/regist_success";
    }


    /**
     * 定义员工保存
     *
     * @return
     */
    @PostMapping("/registUser")
    public String saveUser(User user,
                           HttpSession session,
                           Model model,
                           @RequestParam("code") String code){
        //获取Session中的验证码
        String token=(String)session.getAttribute("code");
        //删除Session中的验证码
        session.removeAttribute("code");
        if(code.equalsIgnoreCase(token)){
            //说明验证码输入正确
//
            if(userService.existsUsername(user.getUsername())){
                //用户名不可用

                model.addAttribute("msg","用户名已存在！");
                model.addAttribute("username",user.getUsername());
                model.addAttribute("email",user.getEmail());
                return "user/regist";
            }else{
                //用户名可用
                userService.saveUser(user);
                session.removeAttribute("username");
                session.setAttribute("loginUser",user);
                return "redirect:/registSuccess";
            }
        }else{
            //验证码错误
            model.addAttribute("msg","验证码错误！");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            return "user/regist";
        }

    }


    /**
     *检查用户名是否可用
     * @param username
     * @return
     */
    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkuser(@RequestParam("username") String username){
        //先判断用户名是否是合法的表达式
//        String regx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        String regx="(^\\w{5,12}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!username.matches(regx)){
            return Msg.fail().add("va_msg","用户名为6-16位字符组合或2-5位中文!");
        }

        //数据库用户名重复校验
        boolean b=userService.existsUsername(username);
        if(!b){
            return Msg.success();
        }else{
            return Msg.fail().add("vg_msg","用户名不可用");
        }
    }


    /**
     * 用户注销登出
     * @return
     */
    @GetMapping("/logout")
    public String louout(HttpSession session){
        session.invalidate();
        return "/index";
    }








}
