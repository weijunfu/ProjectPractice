package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.ijunfu.domain.Book;
import org.ijunfu.mapper.BookMapper;
import org.ijunfu.service.BookService;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          图书 Service实现类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 23:32
 * @version 1.0.0
 *
 */

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public IPage<Book> page(Integer page, Integer pageSize, Book book) {
        IPage<Book> bookPage = new Page<>(page, pageSize);

        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getAuthor()), Book::getAuthor, book.getAuthor());
        queryWrapper.like(Strings.isNotEmpty(book.getPublisher()), Book::getPublisher, book.getPublisher());
        queryWrapper.like(Strings.isNotEmpty(book.getRemarks()), Book::getRemarks, book.getRemarks());

        return page(bookPage, queryWrapper);
    }
}
