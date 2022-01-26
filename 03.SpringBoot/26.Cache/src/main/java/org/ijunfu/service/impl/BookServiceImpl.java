package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ijunfu.domain.Book;
import org.ijunfu.mapper.BookMapper;
import org.ijunfu.service.BookService;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/26 19:07
 * @version 1.0.0
 *
 */

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
