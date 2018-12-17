<%--
  Created by IntelliJ IDEA.
  User: 半个文化人
  Date: 2018/11/29
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>员工管理</title>
    <base href="<%=basePath%>"/>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript" src="/static/js/model/employee.js">
    </script>
</head>
<body class="theme-login-layout">
<div class="theme-login-header"></div>
<div id="theme-login-form">
    <div align="center"><h1 style="margin-bottom: 50px;">客户管理系统CRM</h1></div>
    <div class="QRcode"></div>
    <div class="QRcode-layout hide">
        <div class="QRcode-layout-close"></div>
        <div class="QRcode-header">
            <b>微信登录</b>
            <span>请使用最新版微信进行扫码登录</span>
        </div>
        <div class="QRcode-content"><img src="/static/js/plugins/easyui/themes/images/QRcode-demo.png" width="215"></div>
    </div>

    <form id="form" class="theme-login-form" method="post">
        <dl>

            <dd style="margin-bottom: 20px"><input id="username" name="username" class="theme-login-text"  style="width:100%;"/></dd>
            <dd style="margin-bottom: 20px"><input id="password" name="password" class="theme-login-text"  style="width:100%;"/></dd>

            <dd >
                <span style="float: left">
                    <a class="submit easyui-linkbutton" href="javascript:void(0)" onclick="submitForm()">登&nbsp;&nbsp;&nbsp;录</a>
                </span>
                <span style="float: right">
                    <span class="button easyui-linkbutton">失&nbsp;&nbsp;智?</span>
                </span>
            </dd>

        </dl>
    </form>
</div>

<div class="theme-login-footer" align="center">
    <dl >
        <dt><a>免费加入</a> | <a id="ok">产品优势</a> | <a>系列产品</a> | <a>应用下载</a> | <a>帮助手册</a> | <a>联系我们</a></dt>
        <dd>&copy 2007 - <script>var year = new Date();document.write(year.getFullYear());</script> Amin.版权所有</dd>
    </dl>
</div>

<script>

    $(function() {

        $(".QRcode").on("click", function () {
            $(".QRcode-layout").removeClass("hide");

        });
        $(".QRcode-layout-close").on("click", function () {
            $(".QRcode-layout").addClass("hide");
        });

        $.extend($.fn.validatebox.defaults.tipOptions, {
            onShow: function () {
                $(this).tooltip("tip").css({backgroundColor: "#ff7e00", border: "none", color: "#fff"});

            }
        })

        /*布局部分*/
        $('#theme-login-layout').layout({
            fit: true/*布局框架全屏*/
        });


        $('#username').textbox({
            prompt: 'Account or number',
            required: true,
            missingMessage: "请输入用户名"
        });
        $('#password').textbox({
            type: "password",
            prompt: 'Password',
            required: true,
            missingMessage: "请输入密码"
        });
        /*$('#code').textbox({
            prompt:'Code',
            required:true,
            missingMessage:"请输入验证码"
        })

        $('#smscode').textbox({
            required:true,
            missingMessage:"请输入短信验证码",
            buttonText:'获取短信验证码',
            prompt:'短信验证码'
        });*/

        $(document.documentElement).on("keyup", function (event) {
            var keyCode = event.keyCode;
            if (keyCode === 13) { // 捕获回车
                submitForm(); // 提交表单
            }
        });
        /*验证码tooltip*/
});
    function submitForm() {
        $('#form').form('submit',{
            url: "/login",
            success: function (data) {
                data=$.parseJSON(data);

                if (!data.success) {
                    $.messager.alert('提示', data.msg, 'error', function () {
                        $('#username,#password').textbox('clear');
                    });
                } else {
                    $.messager.alert("操作异常", "<h4 style= 'color:red;'>"
                        + data.msg + "</h4>", 'error');
                    location.href = "/main";
                }
            }
        });
    }

</script>
<%--live2d--%>
<canvas id="glCanvas" width="450px" height="500px" style="position:fixed;right:0px;bottom:-10px;">
</canvas>
<script>
    SampleApp1();
</script>
</body>
</html>
