/**
 * Created by wicker on 2017/7/20.
 */
function doLogin() {
    $.ajax({
        url:"/easyuiLayout/pageChange/login.do",
        type:"get",
        data:{},
        success:function(data){
            alert(data)
        }
    });
}