
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

// 新增客户
function to_add() {

    openLayer('/customer/toAdd', '客户');

    layui.form.render();

    mySubmit('addSubmit', 'POST');
}

// 公共弹出层
function openLayer(url, title) {
    $.ajaxSettings.async = false;

    $.get(url, function (res){
        layer.open({
            type: 1,
            title: title,
            area: ['800px', '450px'],
            content: res
        });
    });

    $.ajaxSettings.async = true;
}

// 表单提交
function mySubmit(filter, type) {
    layui.form.on('submit('+filter+')', function (data){
        console.log(data.elem);         // 被执行事件的元素DOM对象，一般为button对象
        console.log(data.form);         // 被执行提交的form对象，一般存在form时才会返回
        console.log(data.field);        // 当前容器的全部表单字段，

        $.ajax({
            url: data.form.action,
            async: false,
            type: type,
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data.field),
            success: function (res) {
                console.log(res)
                if(res.code == 0) {
                    layer.closeAll();
                    query();
                } else {
                    layer.alert(res.msg, {icon:2});
                }
            }
        })

        return false;       // 阻止跳转
    });
}