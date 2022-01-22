package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ijunfu.domain.Book;

/**
 *
 * @Title          Book Mapper接口
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/22 12:37
 * @version 1.0.0
 *
 */

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
