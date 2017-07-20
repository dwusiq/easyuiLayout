$(function(){

});
/*页面加载的时候执行*/
function onLoad() {
    loadCatalogTree()
}

/*加载目录树*/
function loadCatalogTree() {
    $.ajax({
        type: 'GET',
        url: '/easyuiLayout/catalogManage/queryCatalogTreeList.json',
        success: function (result) {
        //    var myJson = eval('(' + result + ')');
            $('#catalogTree').tree({
                data: result
            });
        }
    });

/*
    $('#catalogTree').tree({
        url : '/easyuiLayout/catalogManage/queryCatalogTreeList.json',
    });*/
}