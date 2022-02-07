// 表单校验
layui.form.verify({
    username: function(value, item){ //value：表单的值、item：表单的DOM对象
        if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
            return '用户名不能有特殊字符';
        }
        if(/(^\_)|(\__)|(\_+$)/.test(value)){
            return '用户名首尾不能出现下划线\'_\'';
        }
        if(/^\d+\d+\d$/.test(value)){
            return '用户名不能全为数字';
        }

        let url = '/account/' + value;

        let accountId = $("input[name='accountId']").val();
        if(typeof (accountId) != 'undefined') {
            url += '/' + accountId;
        }

        let error = null;
        $.ajax({
            url,
            async: false,
            type: 'GET',
            success: function (res) {
                console.log(res)
                if(res.code == 0) {
                    if(res.data > 0) {
                        error = '用户名已存在';
                    }
                } else {
                    error = '用户名检测出错'
                }
            },
            error: function (){
                error = '用户名检测出错'
            }
        });

        if(error != null) return error;
    }
});