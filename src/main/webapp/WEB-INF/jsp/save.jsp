<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加秒杀单</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>添加秒杀单</h1>
        </div>

        <div class="modal-body">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <form  id="formKey" action="/seckill/saveSeckill" method="post">
                        <input type="text" name="name" id="name"
                               placeholder="秒杀单名称" class="form-control">
                        <input type="text" name="number" id="number"
                               placeholder="秒杀商品库存" class="form-control">
                        <input type="text" name="startTime" id="startTime"
                               placeholder="开始时间yyyy-MM-dd HH:mm:ss" class="form-control">
                        <input type="text" name="endTime" id="endTime"
                               placeholder="结束时间yyyy-MM-dd HH:mm:ss" class="form-control">
                        <div class="modal-footer">
                            <%--验证信息--%>
                            <span id="killPhoneMessage" class="glyphicon"></span>
                            <button type="button" id="addSeckillBtn" class="btn btn-success">
                                    Submit
                            </button>
                            <%--<button type="submit" id="addSeckillBtn" class="btn btn-default">提交</button>--%>
                        </div>
                    </form>

                </div>
            </div>
        </div>


    </div>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="/resources/script/saveSeckill.js"></script>

<script>
    /*交互逻辑*/

    $(function () {
        saveSeckill.detail.init();
    })
</script>
</html>
