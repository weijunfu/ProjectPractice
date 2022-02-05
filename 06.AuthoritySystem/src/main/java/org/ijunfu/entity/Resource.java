package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @Title          <h2>实体类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:01
 * @version        1.0.0
 *
 */

@Data
@TableName("TB_RESOURCE")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RESOURCE_ID", type = IdType.ASSIGN_ID)
    private Long resourceId;        // 主键

    private Long parentId;        // 父级ID

    private String resourceName;        // 资源名称

    private Integer resourceType;        // 资源类型：0 目录，1 菜单，2 按钮

    private String url;        // 访问路径

    private String code;        // 代码

    private Integer sort;        // 排序编号


}
