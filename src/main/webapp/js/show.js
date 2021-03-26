
$(document).ready(function () {

    // var path = $("#path").val();
    $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
    $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
    $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素


    // $(".querys").click(function () {
    //     var obj=$(this);
    //     alert(path);
    //     alert("asdfad");
    //     var id=obj.attr("newsid");
    //     alert(id);
    //     $.ajax({
    //         url:path+"/query.do",
    //         data:{id:id},
    //         dataType:"json",
    //         success:function (data) {
    //             alert(data);
    //         }
    //     })
    // });
});


function delBook() {
    var flag = confirm("确定删除?")
    // if (flag == true) {
    //     // location.href="UserServlet?id="+idd+"&comm=del";
    //     location.href="/delBook.do?book_ID=bookID";
    // }
}

$(document).ready(function () {

    // var path = $("#path").val();
    // $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
    // $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
    // $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素

    // $.get({url:"cate",dataType:'json',success:cate});
    $.get({url:"show",dataType:'json',success:information});

    $("#submit").click(function () {
        select = $("#select").val();
        title = $("#title").val();
        $.get({url:"findByTitle",async: true,data:{'select':select,'title':title},dataType:'json',success:information});
    });

    function information(data1) {
        var $mytab = $("#mytab");
        if ($("#mytab tr").length>2){
            while ($("#mytab tr").length>2){
                $("#mytab tr").eq(2).remove();
            }
        }
        for (var i = 0; i < data1.length; i++) {
            var link = '${pageContext.request.contextPath}/update?id='+data1[i].id;
            $mytab.append("<tr><td>"+data1[i].id+"</td><td>"+data1[i].title+"</td><td>"+
                data1[i].summary+"</td><td>"+data1[i].author+"</td><td>"+data1[i].createDate+"</td><td><a href='"+link+"'>"+'修改'+"</a>")
        }
    }

    // function cate(data2) {
    //     var $select = $("#select");
    //     for (var i = 0; i <data2.length ; i++) {
    //         $select.append("<option value='"+data2[i].id+"'>"+data2[i].name+"</option>");
    //     }
    // }
});


