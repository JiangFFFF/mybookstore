package com.jiang.mybookstore.controller;

import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.bean.Cart;
import com.jiang.mybookstore.bean.CartItem;
import com.jiang.mybookstore.bean.Msg;
import com.jiang.mybookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 * @create 2021-11-23-9:20 下午
 */
@Controller
public class CartController {

    @Autowired
    BookService bookService;

    @RequestMapping("/addItem")
    @ResponseBody
    public Map ajaxAddItem(@RequestParam("id") Integer id, HttpSession session) {
        //调用bookService.queryBookById（）查询图书信息
        Book book = bookService.queryBookById(id);
        //将图书信息转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("items",cart.getItems());
        }
        cart.add(cartItem);
        //最后一个添加的商品名称
        session.setAttribute("lastName", cartItem.getName());

        //返回购物车总的商品数量和最后一个添加的商品名称
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        return resultMap;
    }

    /**
     * 删除商品项
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteItem")
    public String deleteItem(@RequestParam("id") Integer id, HttpSession session) {
        //获取购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            //删除对应商品项
            cart.deleteItem(id);
        }
        return "redirect:/cart";
    }

    /**
     * 清空购物车
     *
     * @return
     */
    @RequestMapping("/clearCart")
    public String clearCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            //清空购物车
            cart.clear();
        }
        return "redirect:/cart";
    }


    /**
     * 更新商品数量
     * @param id
     * @param count
     * @param session
     * @return
     */
    @RequestMapping("/updateCount")
    public String updateCount(@RequestParam("id") Integer id,
                              @RequestParam("count") Integer count,
                              HttpSession session) {
        //获得Cart购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            //修改商品数量
            cart.updateCount(id, count);
        }
        return "redirect:/cart";

    }

}
