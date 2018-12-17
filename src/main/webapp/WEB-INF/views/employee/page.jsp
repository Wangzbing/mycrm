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
<body>
<%--对话框--%>
<div id="employee-dlg" class="easyui-dialog">
    <form id="employee-form" method="post" novalidate style=" max-width:400px;padding:30px 60px;">
        <input type="hidden" name="id">
        <input type="hidden" name="password">
        <input type="hidden" name="inputtime">
        <input type="hidden" name="status">
        <div style="margin-bottom:20px">
            <input validType="username" required="true" style="width:100%" name="username" class="easyui-textbox" data-options="label:'用户名',prompt:'Enter something here...'">
        </div>
        <div style="margin-bottom:20px">
            <input validType="chinese" required="true" style="width:100% " name="realname" class="easyui-textbox" data-options="label:'真实姓名',prompt:'Enter something here...'">
        </div>
        <div style="margin-bottom:20px">
            <input validType="tel" required="true" name="tel" style="width:100%" class="easyui-textbox" data-options="label:'用户电话',prompt:'Enter something here...'">
        </div>
        <div style="margin-bottom:20px">
            <input validType="email" required="true" style="width:100%" name="email" class="easyui-textbox" data-options="label:'用户邮箱',prompt:'Enter something here...'">
        </div>
        <div style="margin-bottom:20px">
            <input  style="width:100%" required="true" name="department.id" class="easyui-combotree" data-options="label:'用户邮箱'
            ,prompt:'Enter something here...'
            ,url:'/department/findDeptTree'
            ,method:'get'
            ,panelHeight:'auto'
             ">
        </div>

           <%-- <tr>
                <td>用户角色：</td>
                <td><input id="roleArr" name="roleArr" class="easyui-combobox"
                           data-options="
							url:'/role/getAll.do',
							method:'get',
							valueField:'id',
							textField:'name',
							multiple:true,
							panelHeight:'auto'
							"></td>
            </tr>--%>
    </form>
</div>
<!-- 添加/编辑对话框按钮 -->
<div id="employeeDlgButtons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6"
       iconCls="icon-save" style="width: 90px" data-cmd="employeeSave">保存</a> <a
        href="javascript:void(0)" class="easyui-linkbutton"
        iconCls="icon-cancel" style="width: 90px" data-cmd="employeeCancel">取消</a>
</div>
<%--定义工具栏--%>
<div id="dataLinkbutton">

    <a href="javascript:void(0);" data-cmd="employeeOpen" class="easyui-linkbutton c5" data-options="iconCls:'icon-add',plain:true">新增</a>
    &emsp;
    <a href="javascript:void(0);" data-cmd="employeeEdit" class="easyui-linkbutton c6" data-options="iconCls:'icon-edit',plain:true">修改</a>
    &emsp;
    <a href="javascript:void(0);" data-cmd="employeeLeft" id="leftBtn" class="easyui-linkbutton c7" data-options="iconCls:'icon-remove',plain:true">离职</a>
    &emsp;
    <a href="javascript:void(0);" data-cmd="employeeRework" id="reworkBtn" class="easyui-linkbutton c3" data-options="iconCls:'icon-remove',plain:true">复职</a>
    &emsp;
    <a href="javascript:void(0);" data-cmd="employeeReload" class="easyui-linkbutton c4" data-options="iconCls:'icon-edit',plain:true">刷新</a>
    &emsp;
   <%-- <table>
        <form id="search_form">
            <tr>
                <td>用户名<input class="easyui-textbox"></td>
                <td>公司名称<input id="search_Company" class="easyui-combobox" name="company.id"  data-options="
                         url:'/company/findAll',
                         method:'post',
                         valueField:'companyId',
                         textField:'companyName',
                         panelHeight:'auto'"></td>
                <td>部门名称<input id="seach_Deptment" class="easyui-combobox" name="department.id"  data-options="
                         url:'/department/findAll',
                         method:'post',
                         valueField:'departmentId',
                         textField:'departmentName',
                         iconCls:'icon-search',
                         panelHeight:'auto'"></td>
            </tr>
        </form>
    </table>--%>
</div>
<table id="employeeDatagrid" title="用户列表" />
</body>
</html>
