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
    <script type="text/javascript" src="static/js/model/${domain}.js"></script>
</head>
<body>

    <%--datagrid--%>
    <table id="${domain}Datagrid"></table>

    <%--数据表格工具栏--%>
    <div id="${domain}DatagridToolbar">
        <a data-cmd="${domain}Add" href="javascript:;" class="easyui-linkbutton c1" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a data-cmd="${domain}Edit" href="javascript:;" class="easyui-linkbutton c2" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <a data-cmd="${domain}Remove" href="javascript:;" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a data-cmd="${domain}Refresh" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>

    <%--添加修改模态框--%>
    <div id="${domain}Dialog">
        <form id="${domain}DialogForm">
            <table style="margin:auto;margin-top:20px;font-size: 13px;">
                #foreach( $vo in $vos)
                <tr>
                    <td>$vo.title:</td>
                    <td>
                        <input name="$vo.filed" class="easyui-textbox" style="width:200px">
                    </td>
                </tr>
                #end
            </table>
        </form>
    </div>

    <%--添加修改模态框的工具栏--%>
    <div id="${domain}DialogToolbar">
        <a data-cmd="${domain}Save" href="javascript:;" class="easyui-linkbutton c4" data-options="iconCls:'icon-save',plain:true">保存</a>
        <a data-cmd="${domain}Cancel" href="javascript:;" class="easyui-linkbutton c5" data-options="iconCls:'icon-cancel',plain:true">取消</a>
    </div>

</body>
</html>
