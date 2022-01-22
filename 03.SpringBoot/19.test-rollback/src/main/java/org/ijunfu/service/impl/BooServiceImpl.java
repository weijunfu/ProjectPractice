package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ijunfu.domain.Book;
import org.ijunfu.service.BookService;
import org.ijunfu.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          Book Service实现类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/22 12:40
 * @version 1.0.0
 *
 */

@Service
public class BooServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
