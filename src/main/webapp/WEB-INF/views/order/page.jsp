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
    <script type="text/javascript" src="static/js/model/order.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="orderDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="orderDatagridToolbar">
        <a data-cmd="orderAdd" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a data-cmd="orderEdit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a data-cmd="orderRemove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="orderRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="orderDialog">
        <form id="orderDialogForm">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                            </table>
        </form>
    </div>

    <%--添加修改模态框的工具栏--%>
    <div id="orderDialogToolbar">
        <a data-cmd="orderSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-save',plain:true">保存</a>
        <a data-cmd="orderCancel" href="javascript:;" class="easyui-linkbutton c5" data-options="iconCls:'icon-cancel',plain:true">取消</a>
    </div>

</body>
</html>
