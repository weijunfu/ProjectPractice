
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

// 新增客户
function to_add() {

    openLayer('/role/toAdd', '新增角色');

    showTree('/role/resources', 'resource')

    mySubmit('addSubmit', 'POST', addIds);
}

let addIds = function (field){
    let checkedData = layui.tree.getChecked('resource');

    field.resourceIds = getIds(checkedData, []);
}

function getIds(checkedData, arr) {
    for(let i in checkedData) {
        arr.push(checkedData[i].id);

        arr = getIds(checkedData[i].children, arr);
    }

    return arr;
}

//触发事件
//工具条事件
table.on('tool(roleList)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"

    /**
     * data 获得当前行数据
     * event 获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
     * tr获得当前行 tr 的 DOM 对象（如果有的话）
     */
    let {data, event, tr} = obj;

    console.log(obj)

    let { roleId } = data

    switch (event) {
        case 'detail':
            openLayer("/role/toDetail/"+roleId, "查看角色详情");
            break;
        case 'edit':    // 编辑
            openLayer("/role/toUpdate/"+roleId, "修改角色");

            showTree('/role/resources/' + roleId, 'resource')

            mySubmit('updateSubmit', 'PUT', addIds)
            break;
        case 'del':

            myDelete('/customer/' + customerId);

            break;
    }
});