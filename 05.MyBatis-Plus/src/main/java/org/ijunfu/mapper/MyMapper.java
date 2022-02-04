package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/04 19:00
 * @version 1.0.0
 *
 */

public interface MyMapper<T> extends BaseMapper<T> {

    int deleteAll();
}
