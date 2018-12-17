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
    <script type="text/javascript" src="static/js/model/systemDictionaryType.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="systemDictionaryTypeDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="systemDictionaryTypeDatagridToolbar">
        <a data-cmd="systemDictionaryTypeAdd" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a data-cmd="systemDictionaryTypeEdit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a data-cmd="systemDictionaryTypeRemove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="systemDictionaryTypeRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="systemDictionaryTypeDialog">
        <form id="systemDictionaryTypeDialogForm">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                                <tr>
                    <td>类型id:</td>
                    <td>
                        <input name="id" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>类型名称:</td>
                    <td>
                        <input name="name" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>类型简称:</td>
                    <td>
                        <input name="sn" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>类型说明:</td>
                    <td>
                        <input name="intro" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                            </table>
        </form>
    </div>

    <%--添加修改模态框的工具栏--%>
    <div id="systemDictionaryTypeDialogToolbar">
        <a data-cmd="systemDictionaryTypeSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-save',plain:true">保存</a>
        <a data-cmd="systemDictionaryTypeCancel" href="javascript:;" class="easyui-linkbutton c5" data-options="iconCls:'icon-cancel',plain:true">取消</a>
    </div>

</body>
</html>
