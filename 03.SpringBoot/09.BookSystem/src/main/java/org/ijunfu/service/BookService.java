package org.ijunfu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.ijunfu.domain.Book;

/**
 *
 * @Title          图书 Service接口
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 23:29
 * @version 1.0.0
 *
 */

public interface BookService {

    /**
     *
     * @Title       save
     * @Description 新增图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/16 23:37
     * @version     1.0.0
     * @param 		book
     * @Return      boolean
     */
    boolean save(Book book);

    /**
     *
     * @Title       update
     * @Description 修改图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/16 23:37
     * @version     1.0.0
     * @param 		book
     * @Return      boolean
     */
    boolean update(Book book);

    /**
     *
     * @Title       delete
     * @Description 删除图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/16 23:37
     * @version     1.0.0
     * @param 		id
     * @Return      boolean
     */
    boolean delete(Integer id);

    /**
     *
     * @Title       getById
     * @Description 获取指定图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/16 23:38
     * @version     1.0.0
     * @param 		id  图书ID
     * @Return      org.ijunfu.domain.Book
     */
    Book getById(Integer id);

    /**
     *
     * @Title       getPage
     * @Description 分页查询图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/16 23:38
     * @version     1.0.0
     * @param 		page
     * @param 		queryWrapper
     * @Return      com.baomidou.mybatisplus.core.metadata.IPage<org.ijunfu.domain.Book>
     */
    IPage<Book> getPage(IPage<Book> page, QueryWrapper<Book> queryWrapper);
}
