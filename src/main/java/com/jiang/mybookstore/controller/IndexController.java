package com.jiang.mybookstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-16-9:55 下午
 */
@Controller
public class IndexController {

    @Autowired
    BookService bookService;

    /**
     * 首页
     * @return
     */
    @GetMapping(value={"/"})
    public String indexPage(){
        return "forward:/index";
    }

    /**
     * 分页跳转书城首页
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String getBookList(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                              Model model,
                              @RequestParam(value = "min",required = false,defaultValue = "0") Integer min,
                              @RequestParam(value = "max",required = false,defaultValue = "500") Integer max){
        //引入pageHelper分页插件
        //在查询之前只需要调用PageHelper.startPage,传入页码，以及每页的大小
        PageHelper.startPage(pn,4);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Book> books=bookService.queryBooksByPrice(min,max);
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面即可
        //封装了详细的分页信息，包括有查询出来的数据,传入连续显示的页数
        PageInfo<Book> page = new PageInfo<>(books);
        model.addAttribute("pageInfo",page);
        model.addAttribute("min",min);
        model.addAttribute("max",max);
        return "index";
    }





    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @GetMapping("/regist")
    public String registPage(){
        return "user/regist";
    }

    /**
     * 跳转购物车页面
     * @return
     */
    @GetMapping("/cart")
    public String cartPage(){
        return "cart/cart";
    }



//    /**
//     * 跳转我的订单页面
//     * @return
//     */
//    @GetMapping("/order")
//    public String orderPage(){
//        return "order/order";
//    }




}
