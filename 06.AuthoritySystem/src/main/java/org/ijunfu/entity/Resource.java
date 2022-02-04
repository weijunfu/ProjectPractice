package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:36
 */
@TableName("TB_RESOURCE")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long resourceId;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源类型：0 目录，1 菜单，2 按钮
     */
    private Integer resourceType;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 代码
     */
    private String code;

    /**
     * 排序编号
     */
    private Integer sort;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Resource{" +
            "resourceId=" + resourceId +
            ", parentId=" + parentId +
            ", resourceName=" + resourceName +
            ", resourceType=" + resourceType +
            ", url=" + url +
            ", code=" + code +
            ", sort=" + sort +
        "}";
    }
}
