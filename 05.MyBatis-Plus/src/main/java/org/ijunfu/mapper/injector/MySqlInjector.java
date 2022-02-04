package org.ijunfu.mapper.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.ijunfu.mapper.method.DeleteAllMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/04 18:49
 * @version 1.0.0
 *
 */

@Component
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);

        // 添加自定义方法
        methodList.add(new DeleteAllMethod());

        return methodList;
    }
}
