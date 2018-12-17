<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"/>
    <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript" src="/static/js/model/systemLog.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="systemLogDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="systemLogDatagridToolbar">
        <a data-cmd="systemLogRefactory" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">处理日志</a>
        <a data-cmd="systemLogRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>
</body>
</html>
