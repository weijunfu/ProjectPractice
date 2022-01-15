package org.ijunfu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.ijunfu.domain.Book;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/15 23:00
 * @version 1.0.0
 *
 */

@Mapper
public interface BookDao {

    /**
     *
     * @Title       getBookById
     * @Description 查询指定图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:28
     * @version     1.0.0
     * @param 		id
     * @Return      org.ijunfu.domain.Book
     */
    @Select("select * from tb_book where id=#{id}")
    public Book getBookById(Integer id);

    /**
     *
     * @Title       save
     * @Description 新增图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:29
     * @version     1.0.0
     * @param 		book
     * @Return      void
     */
    @Insert("insert into tb_book(type, name, remarks) values(#{type}, #{name}, #{remarks})")
    public void save(Book book);

    /**
     *
     * @Title       insert
     * @Description 新增图书，并返回其ID
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:29
     * @version     1.0.0
     * @param 		book
     * @Return      void
     */
    @Insert("insert into tb_book(type, name, remarks) values(#{type}, #{name}, #{remarks})")
    @Options(useGeneratedKeys=true, keyProperty = "id", keyColumn = "id")
    public void insert(Book book);
}
