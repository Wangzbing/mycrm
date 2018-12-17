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
    <script type="text/javascript" src="static/js/model/systemMenu.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="systemMenuDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="systemMenuDatagridToolbar">
        <a data-cmd="systemMenuAdd" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a data-cmd="systemMenuEdit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a data-cmd="systemMenuRemove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="systemMenuRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="systemMenuDialog">
        <form id="systemMenuDialogForm">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                                <tr>
                    <td>菜单编号:</td>
                    <td>
                        <input name="id" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>菜单名称:</td>
                    <td>
                        <input name="name" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>菜单资源:</td>
                    <td>
                        <input name="url" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>菜单简介:</td>
                    <td>
                        <input name="sn" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>菜单图标:</td>
                    <td>
                        <input name="icon" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>菜单介绍:</td>
                    <td>
                        <input name="intro" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                                <tr>
                    <td>父级菜单:</td>
                    <td>
                        <input name="parentId" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                            </table>
        </form>
    </div>

    <%--添加修改模态框的工具栏--%>
    <div id="systemMenuDialogToolbar">
        <a data-cmd="systemMenuSave" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-save',plain:true">保存</a>
        <a data-cmd="systemMenuCancel" href="javascript:;" class="easyui-linkbutton c5" data-options="iconCls:'icon-cancel',plain:true">取消</a>
    </div>

</body>
</html>
