package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *       
 * @Title          <Title>
 * @Description    <TODO>
 * 
 * @author         weijunfu<ijunfu@qq.com>
 * @date           2022/02/05 15:18
 * @version        1.0.0
 * 
 */

@Data
public class BaseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;                         // 创建人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateTime;           // 最后更新时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long lastUpdatedBy;                     // 最后修改人

    @TableLogic
    private Integer deleted;                        // 逻辑删除标识：0 未删除 1 已删除
}
