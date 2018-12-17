//1 声明变量用来缓存组件对象
var systemDictionaryItemDatagrid,systemDictionaryItemDialog,systemDictionaryItemDialogForm;
$(function(){
    //2 使用声明的变量来缓存组件
    systemDictionaryItemDatagrid = $('#systemDictionaryItemDatagrid');
    systemDictionaryItemDialog = $('#systemDictionaryItemDialog');
    systemDictionaryItemDialogForm = $('#systemDictionaryItemDialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    cmdObj1 = {
        systemDictionaryItemAdd : function(){
            //清空form表单
            systemDictionaryItemDialogForm.form('clear');
            //打开模态框，设置标题，居中
            systemDictionaryItemDialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        systemDictionaryItemEdit : function(){
            //获取选中行
            var row = systemDictionaryItemDatagrid.datagrid('getSelected');

            //判断是否选中
            if(!row&&rowType.id!=null){
                $.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            systemDictionaryItemDialogForm.form('clear');
            //回显form表单
            systemDictionaryItemDialogForm.form('load',row);
            //打开模态框，设置标题，居中
            systemDictionaryItemDialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        systemDictionaryItemLeft:function(){
            //离职
            var row =systemDictionaryItemDatagrid.datagrid("getSelected");
            if(!row){
                $.messager.alert("温馨提示","请选择停用的数据字典","info");
                return;
            }
            if(row.length>1){
                $.messager.alert("温馨提示", "请逐一选择启用的数据字典明细", "info");
                return;
            }
            $.messager.confirm("温馨提示","确认对该数据明细["+row.name+"]进行停用?",function (yes) {
                if (yes) {
                    $.get("/systemDictionaryItem/leftAndRe", {"id": row.id}, function (result) {
                        if (result.success) {
                            $.messager.alert("操作提示", "<h4 style= 'color:#ffb3b3;'>"
                                + result.msg + "</h4>", "info", function () {
                                systemDictionaryItemDatagrid.datagrid("reload");
                            });
                        } else {
                            $.messager.alert("操作异常", "<h4 style= 'color:red;'>"
                                + result.msg + "</h4>", 'error')
                        }
                    }, "json");
                }
            });
        },
        systemDictionaryItemRework:function () {

            var row = systemDictionaryItemDatagrid.datagrid("getSelected");
            if (!row) {
                $.messager.alert("温馨提示", "请选择启用的数据字典明细", "info");
                return;
            }
            if(row.length>1){
                $.messager.alert("温馨提示", "请逐一选择启用的数据字典明细", "info");
                return;
            }
            $.messager.confirm("温馨提示", "确认对该明细[" + row.name + "]进行启用?", function (yes) {
                if (yes) {
                    $.get("/systemDictionaryItem/leftAndRe", {"id": row.id}, function (result) {
                        if (result.success) {
                            $.messager.alert("操作提示", "<h4 style= 'color:#ffb3b3;'>"
                                + result.msg + "</h4>", "info", function () {
                                systemDictionaryItemDatagrid.datagrid("reload");
                            });
                        } else {
                            $.messager.alert("操作异常", "<h4 style= 'color:#b52b27;'>"
                                + result.msg + "</h4>", 'error')
                        }
                    }, "json");
                }
            });
        },
        systemDictionaryItemRefresh : function(){
            systemDictionaryItemDatagrid.datagrid('reload');
        },
        //保存
        systemDictionaryItemSave : function(){
            //发送ajax请求,调用form组件的submit方法
            systemDictionaryItemDialogForm.form('submit', {
                url:'systemDictionaryItem/save',
                onSubmit: function(parma){
                    var rowType = systemDictionaryTypeDatagrid.datagrid('getSelected');
                    console.debug(rowType);
                    if(rowType){
                        parma["type.id"]=rowType.id;
                    }
                    return systemDictionaryItemDialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = $.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        systemDictionaryItemDialog.dialog('close');
                        //给出提示
                        $.messager.alert('温馨提示',result.msg,'info');
                        //刷新表格数据
                        systemDictionaryItemDatagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        $.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                    }
                }
        });


        },
        //取消保存
        systemDictionaryItemCancel : function(){
            systemDictionaryItemDialog.dialog('close');
        },
        //删除
        systemDictionaryItemRemove : function(){
            //获取选中行
            var row = systemDictionaryItemDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            $.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    $.get('systemDictionaryItem/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            $.messager.alert('温馨提示',result.msg,'info');
                            //刷新表格数据
                            systemDictionaryItemDatagrid.datagrid('reload');
                        }else{
                            //给出失败的提示
                            $.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                        }
                    },'json');
                }
            });
        }
    };
    //4 初始化组件
    //4.1 初始化数据表格
    systemDictionaryItemDatagrid.datagrid({
        title:'',
        url:'systemDictionaryItem/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        pageSize:20,
        pageList:[10,20,30,50],
        fitColumns:true,//列宽度
        columns:[[
                        {field:'id',title:'明细id',width:100,hidden:true},
                        {field:'name',title:'明细名称',width:100},
                        {field:'sequence',title:'明细序列号',width:100},
                        {field:'status',title:'明细状态',width:100,formatter:statusFormatterItem},
                        {field:'intro',title:'明细简介',width:100},
                        {field:'type',title:'明细类型',width:100,formatter:objectFormatter}
                    ]],
        toolbar:'#systemDictionaryItemDatagridToolbar',
        onClickRow:function (index,row) {

            if(row.status === -1){
                $('#leftBtn').linkbutton('disable');
                $('#reworkBtn').linkbutton('enable');
            }else{
                $('#leftBtn').linkbutton('enable');
                $('#reworkBtn').linkbutton('disable');
            }
        }
    });
    //4.2 初始化添加修改模态框
    systemDictionaryItemDialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#systemDictionaryItemDialogToolbar'
    });
    //5 为页面上的所有的a标签注册点击事件
    $('a').on('click',function(){
        //获取标签的data-cmd的属性值
        //对属性值进行判断
        var cmd = $(this).data("cmd");
        if (cmd&&!$(this).hasClass('l-btn-disabled')) {
            // 根据cmd命令值，调用方法
            cmdObj[cmd]();
        }
    });
});