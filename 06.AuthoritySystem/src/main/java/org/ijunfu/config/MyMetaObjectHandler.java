package org.ijunfu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.ijunfu.dto.AccountDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;

/**
 *
 * @Title          自动填充类
 * @Description    数据库字段自动填充
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/07 18:10
 * @version 1.0.0
 *
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasSetter("createTime")) {
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        }

        if(metaObject.hasSetter("lastUpdateTime")) {
            this.strictInsertFill(metaObject, "lastUpdateTime", LocalDateTime.class, LocalDateTime.now());
        }

        AccountDTO account = (AccountDTO) RequestContextHolder
                                            .getRequestAttributes()
                                            .getAttribute("account", RequestAttributes.SCOPE_SESSION);

        if(null != account) {
            if(metaObject.hasSetter("createdBy")) {
                this.strictInsertFill(metaObject, "createdBy", Long.class, account.getAccountId());
            }

            if(metaObject.hasSetter("lastUpdatedBy")) {
                this.strictInsertFill(metaObject, "lastUpdatedBy", Long.class, account.getAccountId());
            }
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasSetter("lastUpdateTime")) {
            this.strictUpdateFill(metaObject, "lastUpdateTime", LocalDateTime.class, LocalDateTime.now());
        }

        AccountDTO account = (AccountDTO) RequestContextHolder
                .getRequestAttributes()
                .getAttribute("account", RequestAttributes.SCOPE_SESSION);

        if(null != account) {
            if(metaObject.hasSetter("lastUpdatedBy")) {
                this.strictInsertFill(metaObject, "lastUpdatedBy", Long.class, account.getAccountId());
            }
        }
    }
}
