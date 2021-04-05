$(document).ready(function () {
    //id选择器  失去焦点事件
    $("#admin_Phone").blur(checkAdmin_Phone);
    $("#admin_Pwd").blur(checkAdmin_Pwd);

    $("#mytab").submit(function () {
        if (!checkAdmin_Phone() || !checkAdmin_Pwd()) {
            return false;
        } else {
            // alert("修改成功");
            return true;
        }
    });
});



function checkAdmin_Phone () {
    var adminPhone = $("#admin_Phone").val();
    if (adminPhone == null || adminPhone == "") {
        alert("账号不能为空");
        return false;
    }
    return true;
}

function checkAdmin_Pwd () {
    var adminPwd = $("#admin_Pwd").val();
    if (adminPwd == null || adminPwd == "") {
        alert("密码不能为空");
        return false;
    }
    return true;
}

