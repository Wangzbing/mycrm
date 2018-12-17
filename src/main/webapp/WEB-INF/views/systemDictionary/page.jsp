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
    <title>数据字典管理</title>
    <base href="<%=basePath%>"/>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript" src="/static/js/model/systemDictionaryItem.js"></script>
    <script type="text/javascript" src="/static/js/model/systemDictionaryType.js"></script>
    <script type="text/javascript">
        $(function () {
            var systemDictionaryLayout;
            systemDictionaryLayout=$('#easyui-layout');
            //初始化数据字典
            systemDictionaryLayout.layout({
                collapsible:false,
            });
            //创建一个对象，继承两个命令对象cmdObj_1  cmdObj_2
            cmdObj = {};
            $.extend(cmdObj,cmdObj1,cmdObj2);
        })
    </script>

</head>

<body class="easyui-layout" id="systemDictionaryLayout">
<div data-options="region:'west',title:'数据字典类型管理'" style="width:50%;">
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
        <form id="systemDictionaryTypeDialogForm" method="post">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                <input name="id" hidden="hidden">
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

</div>

<div data-options="region:'center',title:'数据字典明细管理'" style="width: 50%">
    <%--datagrid--%>
    <table id="systemDictionaryItemDatagrid"></table>

    <%--数据表格工具栏--%>
    <div id="systemDictionaryItemDatagridToolbar">
        <a data-cmd="systemDictionaryItemAdd" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>

        <a data-cmd="systemDictionaryItemEdit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>

        <a data-cmd="systemDictionaryItemRemove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="systemDictionaryItemLeft" href="javascript:;" class="easyui-linkbutton c3" id="leftBtn"
           data-options="iconCls:'icon-remove',plain:true">停用</a>
        <a data-cmd="systemDictionaryItemRework" id="reworkBtn"
           href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-ok',plain:true">复用</a>
        <a data-cmd="systemDictionaryItemRefresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="systemDictionaryItemDialog">
        <form id="systemDictionaryItemDialogForm" method="post">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                <input name="id" hidden="hidden">
                <input name="status" hidden="hidden" value="1">
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
                    <td>明细简介:</td>
                    <td>
                        <input name="intro" class="easyui-textbox" style="width:200px">
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
</div>
</body>
</html>

