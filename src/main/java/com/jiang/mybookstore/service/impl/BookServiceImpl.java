package com.jiang.mybookstore.service.impl;

import com.jiang.mybookstore.bean.Book;
import com.jiang.mybookstore.mapper.BookMapper;
import com.jiang.mybookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-21-9:28 上午
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookMapper.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookMapper.queryBooks();
    }

    @Override
    public List<Book> queryBooksByPrice(Integer min, Integer max) {
        return bookMapper.queryBooksByPrice(min,max);
    }


}
