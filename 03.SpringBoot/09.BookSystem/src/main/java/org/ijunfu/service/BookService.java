package org.ijunfu.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
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

public interface BookService extends IService<Book> {

    public IPage<Book> page(Integer page, Integer pageSize, Book book);
}
