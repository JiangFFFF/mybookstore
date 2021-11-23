package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiang
 * @create 2021-11-21-9:31 上午
 */
@SpringBootTest
@Slf4j
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void testAddBook(){
        bookService.addBook(new Book(null,"Rt_thread","XXX",new BigDecimal(123),12,22,"img/"));
    }

    @Test
    public void testUpdate(){
        bookService.updateBook(new Book(21,"Java","XXX",new BigDecimal(100),20,22,"img/ok.jpg"));
    }

    @Test
    public void testDelete(){
        bookService.deleteBookById(21);
    }

    @Test
    public void testQueryBookById(){
        Book book = bookService.queryBookById(20);
        log.info("数据为:{}",book);
    }

    @Test
    public void testQueryBooks(){
        List<Book> books = bookService.queryBooks();
        for(Book b:books){
            System.out.println(b);
        }
    }

    @Test
    public void testQueryBookSByPrice(){
        List<Book> books = bookService.queryBooksByPrice(40, 100);
        for(Book book:books){
            System.out.println(book);
        }
    }

}
