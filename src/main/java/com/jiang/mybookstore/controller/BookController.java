package com.jiang.mybookstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.bean.Msg;
import com.jiang.mybookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-21-10:16 上午
 */
@Controller
public class BookController {

    @Autowired
    BookService bookService;

//    /**
//     * 跳往图书管理界面
//     * @param model
//     * @return
//     */
//    @GetMapping("/bookManager")
//    public String bookManagerPage(Model model){
//        List<Book> books = bookService.queryBooks();
//        model.addAttribute("books",books);
//        return "manager/book_manager";
//    }


    /**
     * 分页跳转图书管理界面
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/bookPage")
    public String getBookList(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        //引入pageHelper分页插件
        //在查询之前只需要调用PageHelper.startPage,传入页码，以及每页的大小
        PageHelper.startPage(pn,4);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Book> emps=bookService.queryBooks();
        //使用pageInfo包装查询后的结果,只需要将pageInfo交给页面即可
        //封装了详细的分页信息，包括有查询出来的数据,传入连续显示的页数
        PageInfo<Book> page = new PageInfo<>(emps, 5);
        model.addAttribute("pageInfo",page);
        return "manager/book_manager";
    }



    /**
     * 跳往图书新增和修改界面
     * @return
     */
    @GetMapping("/bookEdit")
    public String bookEdit(@RequestParam("pn")Integer pn,
                           Model model,
                           @RequestParam(value = "bookId",required = false)Integer bookId){
        model.addAttribute("pn",pn);
        if(bookId!=null){
            model.addAttribute("bookId",bookId);
            Book book = bookService.queryBookById(bookId);
            model.addAttribute("book",book);
        }
        return "manager/book_edit";
    }


    /**
     * 新增图书以及图书信息修改
     * @param book
     * @return
     */
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(@RequestParam("pn")Integer pn,
                          Book book,
                          RedirectAttributes ra,
                          @RequestParam(value = "bookId",required = false)Integer bookId){
        if(bookId!=null){
            bookService.updateBook(new Book(bookId,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath()));
        }else {
            bookService.addBook(book);
        }
        ra.addAttribute("pn", pn);
        return "redirect:/bookPage";
    }

    /**
     * 图书删除
     * @param bookId
     * @return
     */
    @RequestMapping(value="/book/{bookId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteBook(@PathVariable("bookId") Integer bookId){
        bookService.deleteBookById(bookId);
        return Msg.success();
    }






}
