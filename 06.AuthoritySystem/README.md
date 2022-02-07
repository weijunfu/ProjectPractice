# 权限管理系统

## 1. 技术架构


## 2. 数据库架构


## 3. 扩展

### 3.1 layui表格数据code问题

在layui中，当`code=0`时，才认为请求成功。因此当`code!=0`时，仅显示`msg`字段内容。

### 3.2 Long类型ID传值时，精度损失问题

解决方案：
1. `Long`类型回传时，强制转为`String`
2. 通过`@JsonSerialize`实现转换 :sparkles:
```
@Data
@TableName("TB_CUSTOMER")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "CUSTOMER_ID", type = IdType.ASSIGN_ID)
    private Long customerId;        // 主键
    
}
```

### 3.3 `lay-verify`：自定义校验规则不生效的问题，书写格式错误

错误：
```
lay-verify="required | username"
```

正确：
```
lay-verify="required|username"
```