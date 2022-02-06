
function showTab(url, name, id) {
    console.log(url, name, id)
    let len = $('li[lay-id='+id+']').length;
    let element = layui.element;

    if(len == 0) {
        url = '/' + url;
        let height = $(window).height() - 185;
        let content = '<iframe src='+url+' frameborder="0" scrolling="no" style="width: 100%;height: '+height+'px"></iframe>'

        element.tabAdd('menu', {
            title: name,
            content: content,
            id: id
        })
    }

    element.tabChange('menu', id);
}