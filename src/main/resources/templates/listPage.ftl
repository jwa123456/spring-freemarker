<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <script type="text/javascript" src="../static/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <link href="../static/bootstrap.min.css" rel="stylesheet"/>
    <title>测试系统</title>
    <style>
        .contentDiv {
            padding: 20px 60px;
        }
    </style>
</head>
<body>
<div class="contentDiv">
    <form class="form-inline" role="form" id="op-query" method="get">
        <div class="form-group">
            <span style="white-space: nowrap;">
            <label for="name">省份列表</label>
            <select name="province" id="province" class="form-control">
                <option value="">请选择</option>
                        <#if parent_region?? && parent_region?size gt 0>
                            <#list parent_region as region>
                                <option value="${region.id?c}"
                                <#if (((province_id)!0) == region.id)>selected="selected"</#if>>${region.regionName!''}</option>
                            </#list>
                        <#else>
                                <option value="">暂无数据</option>
                        </#if>
            </select>
            </span>
            <span style="white-space: nowrap;">
                <label for="name">城市列表</label>
            <select name="city" id="city" class="form-control">
                <option value="">请选择</option>
            </select>
            </span>
            <span style="white-space: nowrap;">
                <label for="name">县区列表</label>
            <select name="region" id="region" class="form-control">
                <option value="">请选择</option>
            </select>
            </span>
        </div>
        <button class="btn btn-primary" type="button" id="searchBtn">查询</button>
    </form>
</div>
<table class="table table-hover table-condensed">
    <legend>
        <strong>用户列表</strong>
    </legend>
    <thead>
    <tr>
        <th>用户Id</th>
        <th>用户名</th>
        <th>管理</th>
    </tr>
    </thead>
    <tbody>
        <#if user_list?? && user_list?size gt 0>
            <#list user_list as  user>
                <tr>
                    <td>${user.id!''}</td>
                    <td>${user.userName!''}</td>
                    <td>
                        <input type="button" name="detail" class="btn btn-primary" value="详情" data-id="${user.id!''}"/>
                    </td>
                </tr>
            </#list>
        <#else >
                <tr>
                    <td colspan="7" style="text-align: center">暂无数据</td>
                </tr>
        </#if>
    </tbody>
</table>
<script type="text/javascript">
    $(function () {
        $("#province").on('change', function () {
            var provinceId = $(this).val();
            var currentTemplateId = 0;
            $.ajax({
                url: 'city_list',
                type: 'GET',
                data: {provinceId: provinceId},
                success: function (data) {
                    console.log(JSON.stringify(data));
                    var temp_html = "<option value=''>请选择</option>";
                    $.each(data, function (i, template) {
                        if (template === currentTemplateId) {
                            temp_html += "<option value='" + template.id + "' selected='selected'>" + template.regionName + "</option>";
                        } else {
                            temp_html += "<option value='" + template.id + "'>" + template.regionName + "</option>";
                        }
                    });
                    $("#city").html(temp_html);
                }
            });
        });

        $("#city").on('change', function () {
            var provinceId = $(this).val();
            var currentTemplateId = 0;
            $.ajax({
                url: 'city_list',
                type: 'GET',
                data: {provinceId: provinceId},
                success: function (data) {
                    console.log(JSON.stringify(data));
                    var temp_html = "<option value=''>请选择</option>";
                    $.each(data, function (i, template) {
                        if (template === currentTemplateId) {
                            temp_html += "<option value='" + template.id + "' selected='selected'>" + template.regionName + "</option>";
                        } else {
                            temp_html += "<option value='" + template.id + "'>" + template.regionName + "</option>";
                        }
                    });
                    $("#region").html(temp_html);
                }
            });
        });

        $("input[name='detail']").on('click', function () {
            var userId = $(this).data("id");
            var url = "user_info?id=" + userId;
            window.open(url);
        });

        $("#searchBtn").on('click', function () {
            // $("#pageNum").val(1);
            $("#op-query").submit();
        });
    })
</script>
</body>
</html>