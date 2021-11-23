package com.jiang.mybookstore.service;

import com.jiang.mybookstore.bean.Book;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-21-9:23 上午
 */
public interface BookService {

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 根据价格区间查询图书信息
     * @param min
     * @param max
     * @return
     */
    public List<Book> queryBooksByPrice(Integer min,Integer max);

}
