if (!sessionStorage['loginName']) {
    $('.modal').css("display", 'block'); //未登录的话跳转到登录页
}

var loginName = sessionStorage['loginName'];
console.log(loginName);
$('.base span:first-child').html('你好，' + loginName);

//登录
$("#btn-login").click(function() {
    var loginData = $('#login-form').serialize();
    console.log("loginData:" + loginData);

    


    $.ajax({
        type: 'POST',
        url: 'admin/login',
        data:loginData,
        success: function(txt, msg, xhr){
            console.log(txt)
            if(txt=='ok'){  //登录成功
                $('.modal').fadeOut(300);
                var loginName=$("[name='uname']").val();
                sessionStorage['loginName']=loginName;
                console.log(sessionStorage['loginName']);

            }else { //登录失败
                $('.modal .alert').html('登录失败！错误消息为：'+txt);
            }
        }
    });
});
//左侧点击事件
//商品信息
$('section .title').on('click', '.product', function() {
    location.href = 'product.html';
});
//用户信息
$('section .title').on('click', '.user', function() {
    location.href = 'user.html';
});
//用户信息
$('section .title').on('click', '.report', function() {
    location.href = 'report.html';
});
//学生认证
$('section .title').on('click', '.stuvalidate', function() {
    location.href = 'stuvalidate.html';
});
//管理员信息
$('section .title').on('click', '.manager', function() {
    location.href = 'manager.html';
});
//修改密码
//$('div#main .myApp').on('click','.changePwd a',function(){
//    location.href='../html/changePwd.html?loginName='+loginName;
//    $('#top_box span').html(sessionStorage['loginName']);
//});