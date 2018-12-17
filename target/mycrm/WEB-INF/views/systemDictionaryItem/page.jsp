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
    <script type="text/javascript" src="static/js/model/systemDictionaryItem.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="systemDictionaryItemDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="systemDictionaryItemDatagridToolbar">
        <a data-cmd="systemDictionaryItemAdd" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a data-cmd="systemDictionaryItemEdit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a data-cmd="systemDictionaryItemRemove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="systemDictionaryItemRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="systemDictionaryItemDialog">
        <form id="systemDictionaryItemDialogForm">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                                <tr>
                    <td>明细id:</td>
                    <td>
                        <input name="id" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>明细名称:</td>
                    <td>
                        <input name="name" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>明细序列号:</td>
                    <td>
                        <input name="sequence" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>明细状态:</td>
                    <td>
                        <input name="status" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>明细简介:</td>
                    <td>
                        <input name="intro" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>明细类型:</td>
                    <td>
                        <input name="type" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <%--添加修改模态框的工具栏--%>
    <div id="systemDictionaryItemDialogToolbar">
        <a data-cmd="systemDictionaryItemSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-save',plain:true">保存</a>
        <a data-cmd="systemDictionaryItemCancel" href="javascript:;" class="easyui-linkbutton c5" data-options="iconCls:'icon-cancel',plain:true">取消</a>
    </div>

</body>
</html>
