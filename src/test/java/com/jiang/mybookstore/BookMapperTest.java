package com.jiang.mybookstore;

import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiang
 * @create 2021-11-21-9:08 上午
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void testQueryBookById(){
        Book book = bookMapper.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void testQueryBooks(){
        List<Book> books = bookMapper.queryBooks();
        for(Book b:books){
            System.out.println(b);
        }
    }

    @Test
    public void testaddBook(){
        int i = bookMapper.addBook(new Book(null, "计算机网络", "谢希仁", new BigDecimal(32), 123, 232, "img/test1.jpg"));
        System.out.println("成功的数目:"+i);
    }

    @Test
    public void testDelete(){
        bookMapper.deleteBookById(21);
        bookMapper.deleteBookById(22);
    }

    @Test
    public void testqueryBooksByPrice(){
        List<Book> books = bookMapper.queryBooksByPrice(10, 20);
        for(Book b:books){
            System.out.println(b);
        }
    }

}
