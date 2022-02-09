
// 删除
function myDelete(url) {
    layer.confirm('您真的要删除吗？', (index)=>{
        $.ajax({
            url,
            async: false,
            type: 'DELETE',
            contentType: 'application/json;charset=utf-8',
            success: function (res) {
                console.log(res)
                if(res.code == 0) {
                    query();
                } else {
                    layer.alert(res.msg, {icon:2});
                }
            }
        });

        layer.close(index);
    });
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
function mySubmit(filter, type, resultHandler) {
    layui.form.on('submit('+filter+')', function (data){
        // console.log(data.elem);         // 被执行事件的元素DOM对象，一般为button对象
        // console.log(data.form);         // 被执行提交的form对象，一般存在form时才会返回
        // console.log(data.field);        // 当前容器的全部表单字段，

        if(typeof resultHandler != 'undefined') {
            resultHandler(data.field)
        }

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
        });

        return false;       // 阻止跳转
    });
}