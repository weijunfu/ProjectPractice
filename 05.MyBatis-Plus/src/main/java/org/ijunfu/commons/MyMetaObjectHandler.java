package org.ijunfu.commons;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/03 17:32
 * @version 1.0.0
 *
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasSetter("createTime"))
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());

        if(metaObject.hasSetter("lastUpdateTime"))
            this.strictInsertFill(metaObject, "lastUpdateTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(null == getFieldValByName("", metaObject))
            if(metaObject.hasSetter("lastUpdateTime"))
                this.strictUpdateFill(metaObject, "lastUpdateTime", Date.class, new Date());
    }
}
