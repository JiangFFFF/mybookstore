package com.jiang.mybookstore.mapper;

import com.jiang.mybookstore.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiang
 * @create 2021-11-20-10:49 下午
 */
@Mapper
public interface BookMapper {

    /**
     * 插入图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 根据id查询图书信息
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
     * 根据价格区间查询图书
     * @return
     */
    public List<Book> queryBooksByPrice(@Param("min") Integer min,
                                        @Param("max") Integer max);




}
