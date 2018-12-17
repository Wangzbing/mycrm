
$(function () {
    var employeeForm,employeeDlg,employeeDatagrid,dataLinkbutton,employeeDlgButtons;
    employeeForm=$("#employee-form");
    employeeDlg =$("#employee-dlg");
    employeeDatagrid=$("#employeeDatagrid");
    dataLinkbutton=$("#dataLinkbutton");
    employeeDlgButtons=$("#employeeDlgButtons");
    var cmdObj ={
        employeeOpen:function () {
            // 清空表单
            employeeForm.form("clear");
            // 修改对话框的名称
            employeeDlg.dialog("setTitle", "新增员工");
            // 打开对话框
            employeeDlg.dialog("open");
        },
        employeeEdit:function () {
            //修改
            //获取选中行
            var row =employeeDatagrid.datagrid("getSelected");
            if(!row){

                $.messager.alert("温馨提示","请选择所需要操作的行","info");
                return;
            }
            // 清空表单
            employeeForm.form("clear");
            //隐藏密码
            //employeeForm["input"].attr("name=password").hide();
            // 修改对话框的名称
            employeeDlg.dialog("setTitle", "修改员工");
            if (row.department) {
                row["department.id"] = row.department.id;
            }
            //数据回显
            employeeForm.form("load",row);
            // 打开对话框
            employeeDlg.dialog("open");
        },
        employeeLeft:function () {
            //离职
            var row =employeeDatagrid.datagrid("getSelected");
            if(!row){
                $.messager.alert("温馨提示","请选择离职的员工","info");
                return;
            }

            $.messager.confirm("温馨提示","确认对员工["+row.realname+"]进行离职操作?",function (yes) {
                if(yes){
                    $.get("/employee/leftAndRe",{"id":row.id},function (result) {
                        if (result.success) {
                            $.messager.alert("操作提示", "<h4 style= 'color:#ffb3b3;'>"
                                + result.msg + "</h4>", "info", function () {
                                employeeDatagrid.datagrid("reload");
                            });
                        }else{
                            $.messager.alert("操作异常", "<h4 style= 'color:red;'>"
                                + result.msg + "</h4>", 'error')
                        }
                    },"json");
                }
            });

        },
        employeeRework:function () {

            var row = employeeDatagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择复职的员工", "info");
                return;
            }
            $.messager.confirm("温馨提示", "确认对员工[" + row.realname + "]进行复职操作?", function (yes) {
                if (yes) {
                    $.get("/employee/leftAndRe", {"id": row.id}, function (result) {
                        if (result.success) {
                            $.messager.alert("操作提示", "<h4 style= 'color:#ffb3b3;'>"
                                + result.msg + "</h4>", "info", function () {
                                employeeDatagrid.datagrid("reload");
                            });
                        } else {
                            $.messager.alert("操作异常", "<h4 style= 'color:#b52b27;'>"
                                + result.msg + "</h4>", 'error')
                        }
                    }, "json");
                }
            });
        },
            employeeReload:function(){
            //刷新
            employeeDatagrid.datagrid("reload",{});
        },
        employeeSave:function () {
            //保存
            employeeForm.form("submit",{
                url:"/employee/save",
                //提交之前
                onSubmit:function (value) {
                    return employeeForm.form("validate");
                },
                //成功的回调函数
                success:function (date) {
                    date=$.parseJSON(date);
                    console.debug(date);
                    if (date.success) {
                        // 关闭对话框
                        employeeDlg.dialog("close");
                        // 提示
                        $.messager.alert("温馨提示", date.msg, "info",
                            function() {
                                // 刷新
                                employeeDatagrid.datagrid("reload");
                            });
                    } else {
                        $.messager.alert("操作异常", "<h4 style= 'color:red;'>"
                            + date.msg + "</h4>", 'error')
                    }
                }
            });
        },
        employeeCancel:function () {
            //取消
            //关闭对话框
            employeeDlg.dialog("close");
        }
    };

    $("a[data-cmd]").on("click", function() {
        // 获取命令信息
        var cmd = $(this).data("cmd");
        if (cmd&&!$(this).hasClass('l-btn-disabled')) {
            // 根据cmd命令值，调用方法
            cmdObj[cmd]();
        }
    });
    employeeDatagrid.datagrid({
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        url:"/employee/page",
        columns:[[
            {field:'id',title:'员工id',width:100,hidden:true},
            {field:'username',title:'用户名',width:100},
            {field:'realname',title:'真实姓名',width:100},
            {field:'password',title:'密码',width:100},
            {field:'email',title:'电子邮件',width:100},
            {field:'inputtime',title:'入职时间',width:100},
            {field:'status',title:'状态',width:100,formatter:statusFormatter},
            {field:'department',title:'部门',width:100,formatter:objectFormatter}
        ]],
        toolbar:dataLinkbutton,
        onClickRow:function (index,row) {
            if(row.status=-1){
                $('#leftBtn').linkbutton('disable');
                $('#reworkBtn').linkbutton('enable');
            }else{
                $('#leftBtn').linkbutton('enable');
                $('#reworkBtn').linkbutton('disable');
            }
        }
    });
    employeeDlg.dialog({
        width: 500,
        height: 400,
        closed: true,
        modal: true,
        buttons: employeeDlgButtons
    });
});
