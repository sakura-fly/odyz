

if(!sessionStorage['loginName']){
   $('.modal').css("display",'block'); //未登录的话跳转到登录页
}

var loginName = sessionStorage['loginName'];
console.log(loginName);
$('.base span:first-child').html('你好，'+loginName);

var now=new Date();

    switch (now.getDay()) {
        case 0:val="星期天";break
        case 1:val="星期一";break
        case 2:val="星期二";break
        case 3:val="星期三";break
        case 4:val="星期四";break
        case 5:val="星期五";break
        case 6:val="星期六";break
    }

$('.base .date').html(
    1900+now.getYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+"&nbsp;&nbsp;&nbsp;&nbsp;"+val
);

//登录
$("#btn-login").click(function(){
    var loginData = $('#login-form').serialize();
    $.ajax({
        type: 'POST',
        url: 'admin/login',
        data:loginData,
        success: function(txt, msg, xhr){
            if(txt=='ok'){  //登录成功
                $('.modal').fadeOut(300);
                location.reload();
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
$('section .title').on('click','.product',function(){
    location.href='product.html';
});
//用户信息
$('section .title').on('click','.user',function(){
    $(this).addClass("curr");
    $('.title ul li ol').toggle();
    //location.href='user.html';
});
//举报信息
$('section .title').on('click','.report',function(){
    location.href='report.html';
});
//学生认证
$('section .title').on('click','.stuvalidate',function(){
    location.href='stuvalidate.html';
});
//管理员信息
$('section .title').on('click','.manager',function(){
    location.href='manager.html';
});
//所有用户信息
$('section .title').on('click','.all',function(){
    $(this).parents().addClass("curr");
    location.href='user.html';
});
//正常用户信息
$('section .title').on('click','.normal',function(){
    $(this).parents().addClass("curr");
    location.href='user2.html';
});
//禁止发布用户信息
$('section .title').on('click','.ban',function(){
    $(this).parents().addClass("curr");
    location.href='user1.html';
});
//封号用户信息
$('section .title').on('click','.delete',function(){
    $(this).parents().addClass("curr");
    location.href='user0.html';
});

$('section .base').on('click','.exit',function(){
    sessionStorage['loginName']="";
    location.href='index.html';
    console.log(sessionStorage['loginName']);
});
$('section .base').on('click','.reload',function(){
    location.reload();
});
$('section .base').on('click','.last',function(){
    history.go(-1);
});
$('section .base').on('click','.index',function(){
    location.href='index.html';
});
//修改密码
//$('div#main .myApp').on('click','.changePwd a',function(){
//    location.href='../html/changePwd.html?loginName='+loginName;
//    $('#top_box span').html(sessionStorage['loginName']);
//});
