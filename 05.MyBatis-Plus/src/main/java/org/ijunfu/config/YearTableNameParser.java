package org.ijunfu.config;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @Title          分表处理
 * @Description    按年分表
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/04 16:51
 * @version 1.0.0
 *
 */

public class YearTableNameParser implements TableNameHandler {

    @Override
    public String dynamicTableName(String sql, String tableName) {
        return tableName + '_' + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));
    }
}
