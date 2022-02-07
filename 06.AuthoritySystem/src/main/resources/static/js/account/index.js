// 账户管理js

// 渲染时间
layui.laydate.render({
    elem: '#createTimeRange',
    range: true
})

let table = layui.table;

let tableIns = table.render({
    elem: '#accountList',
    url: '/account/list',          // 数据接口
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
        {field: 'username', title:'用户名'},
        {field: 'realName', title:'真实姓名'},
        {field: 'roleName', title: '角色'},
        {field: 'sex', title: '性别'},
        {field: 'email', title: '邮箱'},
        {field: 'createTime', title: '创建时间'},
        {title: '操作', toolbar:'#barDemo'}
    ]]
});


// 按条件查询
function query() {
    tableIns.reload({
        where:{
            name: $('#realName').val(),
            email: $('#email').val(),
            createTime: $('#createTimeRange').val()
        },
        page:{
            curr: 1
        }
    })
}

// 新增客户
function to_add() {

    openLayer('/account/toAdd', '新增账号');

    layui.form.render();

    mySubmit('addSubmit', 'POST');
}

//触发事件
//工具条事件
table.on('tool(accountList)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"

    /**
     * data 获得当前行数据
     * event 获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
     * tr获得当前行 tr 的 DOM 对象（如果有的话）
     */
    let {data, event, tr} = obj;

    console.log(obj)

    let { accountId } = data

    switch (event) {
        case 'detail':
            openLayer("/account/toDetail/"+accountId, "查看客户详情");
            break;
        case 'edit':    // 编辑
            openLayer("/account/toUpdate/"+accountId, "修改客户");

            layui.form.render();

            mySubmit('updateSubmit', 'PUT')
            break;
        case 'del':

            myDelete('/account/' + accountId);

            break;
    }
});