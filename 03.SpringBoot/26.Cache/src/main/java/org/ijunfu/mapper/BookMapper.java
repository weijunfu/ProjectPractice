package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ijunfu.domain.Book;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/25 19:02
 * @version 1.0.0
 *
 */

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
