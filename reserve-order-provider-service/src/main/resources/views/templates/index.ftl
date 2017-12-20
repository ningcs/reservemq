<!DOCTYPE html>
<html lang="en">
<head>
    <script src="/js/jquery.js"></script>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>

<form id="form">
    <div class="form-group">
        <label for="name">名称：</label>
        <input type="text" id="productName" disabled value="${product.productName}">
    </div>
    <div class="form-group">
        <label for="count">购买数量：</label>
        <input type="number" id="count"  value="1">
    </div>
    <div class="form-group">
        <label for="count">单价：</label>
        <p class="form-control-static" id="price">${product.productPrice}</p>
    </div>
    <div class="form-group">
        <label for="count">库存：</label>
        <p class="form-control-static" id="total">${total}</p>
    </div>
    <div class="form-group">
        <a href="javascript:void(0);" id="sub">购买</a>
    </div>
</form>


<script>
$('#sub').click(function () {
    $.ajax({
        url: '/rabbit/createOrder',
        type: 'post',
        data: {
            productId: ${product.id},
            count: $('#count').val(),
            userId: ${userId}
        },
        dataType: 'json',
        cache: false,
        success: function (json) {
            if(json.code==0){
        window.location.reload();
            }else {
                alert(json.msg);
            }

        },
        error: function () {
            alert('出错');

        }
    });
    return false;
});

</script>
</body>
</html>