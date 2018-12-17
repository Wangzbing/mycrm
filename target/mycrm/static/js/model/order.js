$(function(){
    //1 声明变量用来缓存组件对象
    var orderDatagrid,orderDialog,orderDialogForm;
    //2 使用声明的变量来缓存组件
    orderDatagrid = $('#orderDatagrid');
    orderDialog = $('#orderDialog');
    orderDialogForm = $('#orderDialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    var cmdObj = {
        orderAdd : function(){
            //清空form表单
            orderDialogForm.form('reset');
            //打开模态框，设置标题，居中
            orderDialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        orderEdit : function(){
            //获取选中行
            var row = orderDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            orderDialogForm.form('reset');
            //回显form表单
            orderDialogForm.form('load',row);
            //打开模态框，设置标题，居中
            orderDialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        orderRefresh : function(){
            orderDatagrid.datagrid('reload');
        },
        //保存
        orderSave : function(){
            //发送ajax请求,调用form组件的submit方法
            orderDialogForm.form('submit', {
                url:'order/save',
                onSubmit: function(){
                    return orderDialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = $.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        orderDialog.dialog('close');
                        //给出提示
                        $.messager.alert('温馨提示',result.message,'info');
                        //刷新表格数据
                        orderDatagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        $.messager.alert('温馨提示',result.errorCode+'-'+result.message,'error');
                    }
                }
        });


        },
        //取消保存
        orderCancel : function(){
            orderDialog.dialog('close');
        },
        //删除
        orderRemove : function(){
            //获取选中行
            var row = orderDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            $.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    $.get('order/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            $.messager.alert('温馨提示',result.message,'info');
                            //刷新表格数据
                            orderDatagrid.datagrid('reload');
                        }else{
                            //给出失败的提示
                            $.messager.alert('温馨提示',result.errorCode+'-'+result.message,'error');
                        }
                    },'json');
                }
            });
        }
    };
    //4 初始化组件
    //4.1 初始化数据表格
    orderDatagrid.datagrid({
        title:'',
        url:'order/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        columns:[[
                    ]],
        toolbar:'#orderDatagridToolbar'


    });
    //4.2 初始化添加修改模态框
    orderDialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#orderDialogToolbar'
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