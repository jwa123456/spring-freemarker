<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script type="text/javascript" src="../static/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <link href="../static/bootstrap.min.css" rel="stylesheet"/>
    <title>用户详情</title>
    <style>
        .contentDiv {
            padding: 20px 60px;
        }
    </style>
</head>

<body>
<div class="contentDiv">

    <legend>
        <strong>用户详情</strong>
    </legend>

    <form action="/" method="post" class="form-horizontal">

        <input type="hidden" name="id" value="${user.id!''}"/>

        <div class="form-group">
            <label for="book_name" class="col-sm-2 control-label">用户名:</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="userName" name="userName" value="${user.userName!''}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="book_writer" class="col-sm-2 control-label">邮箱:</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="email" name="email" value="${user.email!''}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="book_writer" class="col-sm-2 control-label">年龄:</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="age" name="age" value="${user.age!''}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="book_writer" class="col-sm-2 control-label">地区:</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="region" name="region" value="${region!''}" readonly/>
                <input type="hidden" name="regionId" value="${user.regionId?c}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="book_introduction" class="col-sm-2 control-label">简介:</label>
            <div class="col-xs-4">
                <textarea class="form-control" id="comment" rows="3" name="comment">${user.comment!''}</textarea>
            </div>
        </div>
        <input type="hidden" name="createTime" value="${user.createTime!''}"/>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-primary" type="button" value="提交" id="submit"/>&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("#submit").on('click', function () {
            $.ajax({
                type: 'post',
                url: 'save_user',
                data: $("form").serialize(),
                success: function (data) {
                    if (data) {
                        alert("保存成功");
                        location.href = 'list_page';
                    }
                }
            });
        })
    })
</script>
</html>