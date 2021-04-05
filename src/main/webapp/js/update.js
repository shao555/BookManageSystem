$(document).ready(function () {
    //id选择器  失去焦点事件
    $("#book_Name").blur(checkBookName);
    $("#book_Author").blur(checkAuthor);
    $("#book_Publisher").blur(checkPublisher);

    $("#mytab").submit(function () {
        if (!checkBookName() || !checkAuthor() || !checkPublisher()) {
            return false;
        } else {
            alert("修改成功");
            return true;
        }
    });
});



function checkAuthor () {
    var bookAuthor = $("#book_Author").val();
    if (bookAuthor == null || bookAuthor == "") {
        alert("作者不能为空");
        return false;
    }
    return true;
}

function checkBookName () {
    var bookName = $("#book_Name").val();
    if (bookName == null || bookName == "") {
        alert("书名不能为空");
        return false;
    }
    return true;
}

function checkPublisher() {
    var bookPublisher = $("#book_Publisher").val();
    if (bookPublisher == null || bookPublisher == "") {
        alert("出版社不能为空")
        return false;
    }
    return true;
}
