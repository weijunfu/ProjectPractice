
let table = layui.table;

let tableIns = table.render({
    elem: '#customerList',
    url: '/customer/list',          // 数据接口
    page: true,                     // 开启分页
    parseData: function (res){      // 返回数据格式，用于处理layui所要求格式与后台接口格式不一致
        let data = {
            "code": 0,       // 接口状态码
            "msg": res.msg,         // 接口提示文本
            "count": res.data.count,    // 数据条数
            "data": res.data.records,   // 数据列表
        };
        console.log(data)
        return data;
    },
    cols: [[                            // 表头
        {field: 'realName', title:'姓名'},
        {field: 'sex', title: '性别'},
        {field: 'email', title: '邮箱'},
        {field: 'phone', title: '手机号码'},
        {field: 'createTime', title: '创建时间'},
        {title: '操作', toolbar:'#barDemo'}
    ]]
});

// 按条件查询
function query() {
    tableIns.reload({
        where:{
            name: $('#realName').val(),
            phone: $('#phone').val()
        },
        page:{
            curr: 1
        }
    })
}