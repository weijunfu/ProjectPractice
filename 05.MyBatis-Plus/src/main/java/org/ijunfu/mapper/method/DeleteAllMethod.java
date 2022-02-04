package org.ijunfu.mapper.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/04 18:39
 * @version 1.0.0
 *
 */

public class DeleteAllMethod extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        // 删除表数据
        String sql = "delete from " + tableInfo.getTableName();

        // Mapper接口 方法名
        String methodName = "deleteAll";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        return addDeleteMappedStatement(mapperClass, methodName, sqlSource);
    }
}
