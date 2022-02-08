
let table = layui.table;

let tableIns = table.render({
    elem: '#roleList',
    url: '/role/list',          // 数据接口
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
        {field: 'roleName', title:'角色'},
        {field: 'remarks', title: '备注'},
        {field: 'createTime', title: '创建时间'},
        {title: '操作', toolbar:'#barDemo'}
    ]]
});

// 按条件查询
function query() {
    tableIns.reload({
        where:{
            roleName: $('#roleName').val()
        },
        page:{
            curr: 1
        }
    })
}