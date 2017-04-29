console.log("searchBtn");
$("#user .form1").on('click','#search-btn',function(){
    console.log("searchBtn.........");
    var kw = $('#txtSearch').val();
    console.log(kw);
    searchLoad(1,kw);

    $('#user .pager').on('click','a',function(event){
        event.preventDefault(); //阻止跳转行为
        //获取要跳转的页号
        var pageNum = $(this).attr('href');
        searchLoad(pageNum,kw)
    });
});
//功能点五 用户点击分页条号时实现异步加载
/**功能点5：用户点击分页条中的页号时，实现数据的异步加载**/

function searchLoad(pageNum,kw){
    $.ajax({
        url:"data/userSearch2.php?pageNum="+pageNum+"&kw="+kw,
        data: {mname: sessionStorage['loginName']},
        success:function(pager){
            var html='';
            $.each(pager.data,function(i,d){
                html+=`
                <tr>
                  <td>${d.uid}</td>
                  <td>${d.uname}</td>
                  <td>${d.otherCode}</td>
                  <td>${d.integral}</td>
                  <td>${d.memberLevel}</td>
                  <td>
                    <button class="${d.uid}" id="del">封号</button>
                     <button class="${d.uid}" id="ban">禁止发布</button>
                  </td>
                </tr>
                `;
            });
            $("#user table tbody").html(html);
            //根据返回的响应数据动态创建分页条
            var html = '';
            //html += `<a href="${pager.pageNum-pager.pageNum+1}">首页</a> `;
            if(pager.pageNum-2>0){
                html += `<a href="${pager.pageNum-2}">${pager.pageNum-2}</a> `;
            }
            if(pager.pageNum-1>0){
                html += `<a href="${pager.pageNum-1}">${pager.pageNum-1}</a> `;
            }
            html += `<a href="#" class="curr">${pager.pageNum}</a> `;
            if(pager.pageNum+1<=pager.pageCount){
                html += `<a href="${pager.pageNum+1}">${pager.pageNum+1}</a> `;
            }
            if(pager.pageNum+2<=pager.pageCount){
                html += `<a href="${pager.pageNum+2}">${pager.pageNum+2}</a> `;
            }
            //html += `<a href="${pager.pageNum}">尾页</a> `;
            $('#user .pager').html(html);


            //循环遍历状态
            var trList = $("#user tbody").children("tr")
            console.log(trList.length);
            for (var i=0;i<trList.length;i++) {
                var tdArr = trList.eq(i).find("td");
                if(tdArr.eq(4).html()==="2"){
                    tdArr.eq(4).html("正常");
                    console.log("正常");
                    tdArr.eq(5).find('button#del').html("封号");
                    tdArr.eq(5).find('button#ban').html("禁止发布");
                }
            }

            //封号
            $('#user tbody').on('click','#del',function(event){
                event.preventDefault();
                var uid = $(this).attr('class');
                //发起异步请求
                $.ajax({
                    type: 'POST',
                    url: 'data/deleteUser.php',
                    data: {mname: sessionStorage['loginName'],uid:uid},
                    success: function(obj){
                        alert("成功封号");
                        location.reload();
                    }
                });
            });
            //禁止发布
            $('#user tbody').on('click','#ban',function(event){
                event.preventDefault();
                var uid = $(this).attr('class');
                //发起异步请求
                $.ajax({
                    type: 'POST',
                    url: 'data/banUser.php',
                    data: {mname: sessionStorage['loginName'],uid:uid},
                    success: function(obj){
                        alert("禁止发布成功");
                        location.reload();
                    }
                });
            });

        }
    });
}

