$(function(){
    //1 声明变量用来缓存组件对象
    var systemLogDatagrid,systemLogDialog,systemLogDialogForm;
    //2 使用声明的变量来缓存组件
    systemLogDatagrid = $('#systemLogDatagrid');
    systemLogDialog = $('#systemLogDialog');
    systemLogDialogForm = $('#systemLogDialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    var cmdObj = {
        systemLogAdd : function(){
            //清空form表单
            systemLogDialogForm.form('clear');
            //打开模态框，设置标题，居中
            systemLogDialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        systemLogEdit : function(){
            //获取选中行
            var row = systemLogDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            systemLogDialogForm.form('clear');
            //回显form表单
            systemLogDialogForm.form('load',row);
            //打开模态框，设置标题，居中
            systemLogDialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        systemLogRefresh : function(){
            systemLogDatagrid.datagrid('reload');
        },
        //保存
        systemLogSave : function(){
            //发送ajax请求,调用form组件的submit方法
            systemLogDialogForm.form('submit', {
                url:'systemLog/save',
                onSubmit: function(){
                    return systemLogDialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = $.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        systemLogDialog.dialog('close');
                        //给出提示
                        $.messager.alert('温馨提示',result.msg,'info');
                        //刷新表格数据
                        systemLogDatagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        $.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                    }
                }
        });


        },
        //取消保存
        systemLogCancel : function(){
            systemLogDialog.dialog('close');
        },
        //删除
        systemLogRemove : function(){
            //获取选中行
            var row = systemLogDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            $.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    $.get('systemLog/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            $.messager.alert('温馨提示',result.msg,'info');
                            //刷新表格数据
                            systemLogDatagrid.datagrid('reload');
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
    systemLogDatagrid.datagrid({
        title:'',
        url:'systemLog/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        columns:[[
                        {field:'id',title:'日志id',width:100},
                        {field:'opuserId',title:'操作人id',width:100},
                        {field:'optime',title:'操作时间',width:100},
                        {field:'opip',title:'操作ip',width:100},
                        {field:'function',title:'操作方法',width:100},
                    ]],
        toolbar:'#systemLogDatagridToolbar'

    });
    //4.2 初始化添加修改模态框
    systemLogDialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#systemLogDialogToolbar'
    });
    //5 为页面上的所有的a标签注册点击事件
    $('a').on('click',function(){
        //获取标签的data-cmd的属性值
        //对属性值进行判断
        var cmd = $(this).data('cmd');
        if(cmd){
            cmdObj[cmd]();
        }
    });
});