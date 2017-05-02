/**
 * Created by haedu on 2017/3/23.
 */
$(function() {
    loadReportByPage(1);
});

/**功能点5：用户点击分页条中的页号时，实现数据的异步加载**/
$('#report .pager').on('click', 'a', function(event) {
    event.preventDefault(); //阻止跳转行为
    //获取要跳转的页号
    var pageNum = $(this).attr('href');
    loadReportByPage(pageNum);
});

function loadReportByPage(pageNum) {
    $.ajax({
        // url:"data/loadreport.php?pageNum="+pageNum,
        url: "admin/reportlist?pageNum=" + pageNum,
        type: "POST",
        dataType: 'json',
        data: {
            mname: sessionStorage['loginName']
        },
        success: function(pager) {
            var html = '';
            $.each(pager.data, function(i, d) {
                html += `
                <tr>
                  <td>${d.rid}</td>
                  <td>${d.uname}</td>
                  <td>${d.tipName}</td>
                  <td>${d.pname}</td>
                  <td>${d.reason}</td>
                  <td>${d.tipStatus}</td>
                  <td><input style="height: 26px" type="text" name="cancel" value="${d.cancel}" placeholder="请输入处理结果"/></td>
                  <td>
                     <a href="${d.tipName}" class="${d.rid}" id="del">封号</a>
                     <a href="${d.tipName}" class="${d.rid}" id="ban">禁止发布</a>
                    <button class="${d.rid}" style="color: #2AA9DD" id="cancelReport">处理举报</button>
                  </td>
                </tr>
                `;
            });
            $("#report table tbody").html(html);
            //根据返回的响应数据动态创建分页条
            var html = '';
            //html += `<a href="${pager.pageNum-pager.pageNum+1}">首页</a> `;
            if (pager.pageNum - 2 > 0) {
                html += `<a href="${pager.pageNum-2}">${pager.pageNum-2}</a> `;
            }
            if (pager.pageNum - 1 > 0) {
                html += `<a href="${pager.pageNum-1}">${pager.pageNum-1}</a> `;
            }
            html += `<a href="#" class="curr">${pager.pageNum}</a> `;
            if (pager.pageNum + 1 <= pager.pageCount) {
                html += `<a href="${pager.pageNum+1}">${pager.pageNum+1}</a> `;
            }
            if (pager.pageNum + 2 <= pager.pageCount) {
                html += `<a href="${pager.pageNum+2}">${pager.pageNum+2}</a> `;
            }
            //html += `<a href="${pager.pageNum}">尾页</a> `;
            $('#report .pager').html(html);

            //循环遍历状态
            var trList = $("#report tbody").children("tr")
            console.log(trList.length);
            for (var i = 0; i < trList.length; i++) {
                var tdArr = trList.eq(i).find("td");
                if (tdArr.eq(5).html() === "1") {
                    tdArr.eq(5).html("未处理");
                    console.log("未处理");
                } else if (tdArr.eq(5).html() === "0") {
                    tdArr.eq(5).html("已处理");
                }
            }



            //封号
            $('#report tbody').on('click', '#del', function(event) {
                event.preventDefault();
                var rid = $(this).attr('class');
                //$("[name='pid']").attr("value",pid);
                var cancel = $("[name='cancel']").val();
                var uname = $(this).attr('href');
                console.log('cancel=' + cancel);
                console.log('uname=' + uname);

                $.ajax({
                    type: 'POST',
                    // url: 'data/cancelReport.php',
                    url: "admin/reportres",
                    data: {
                        mname: sessionStorage['loginName'],
                        rid: rid,
                        cancel: cancel
                    },
                    success: function(obj) {
                        //alert("成功封号");
                        //发起异步请求
                        $.ajax({
                            type: 'POST',
                            // url: 'data/deleteUser.php',
                           url: "admin/closeuser",
                            data: {
                                mname: sessionStorage['loginName'],
                                uname: uname
                            },
                            success: function(obj) {
                                alert("成功封号");
                                location.reload();
                                if ($("[name='cancel']") == "") {
                                    $("[name='cancel']").css("background-color", "#fff");
                                } else {
                                    $("[name='cancel']").css("background-color", "transparent");
                                }
                            }

                        });
                    }
                });
            });
            //禁止发布
            $('#report tbody').on('click', '#ban', function(event) {
                event.preventDefault();
                var rid = $(this).attr('class');
                //$("[name='pid']").attr("value",pid);
                var cancel = $("[name='cancel']").val();
                var uname = $(this).attr('href');
                console.log(cancel);
                console.log(uname);
                $.ajax({
                    type: 'POST',
                    // url: 'data/cancelReport.php',
                    url: "admin/reportres",
                    data: {
                        mname: sessionStorage['loginName'],
                        rid: rid,
                        cancel: cancel
                    },
                    success: function(obj) {
                        //alert("成功封号");
                        //发起异步请求
                        $.ajax({
                            type: 'POST',
                            // url: 'data/banUser.php',
                             url: "admin/closesay",
                            data: {
                                mname: sessionStorage['loginName'],
                                uname: uname
                            },
                            success: function(obj) {
                                alert("禁止发布成功");
                                location.reload();
                                if ($("[name='cancel']") == "") {
                                    $("[name='cancel']").css("background-color", "#fff");
                                } else {
                                    $("[name='cancel']").css("background-color", "transparent");
                                }
                            }
                        });
                    }
                });
            });
        }
    });
}