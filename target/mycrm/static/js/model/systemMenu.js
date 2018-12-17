$(function(){
    //1 声明变量用来缓存组件对象
    var systemMenuDatagrid,systemMenuDialog,systemMenuDialogForm;
    //2 使用声明的变量来缓存组件
    systemMenuDatagrid = $('#systemMenuDatagrid');
    systemMenuDialog = $('#systemMenuDialog');
    systemMenuDialogForm = $('#systemMenuDialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    var cmdObj = {
        systemMenuAdd : function(){
            //清空form表单
            systemMenuDialogForm.form('clear');
            //打开模态框，设置标题，居中
            systemMenuDialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        systemMenuEdit : function(){
            //获取选中行
            var row = systemMenuDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            systemMenuDialogForm.form('clear');
            //回显form表单
            systemMenuDialogForm.form('load',row);
            //打开模态框，设置标题，居中
            systemMenuDialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        systemMenuRefresh : function(){
            systemMenuDatagrid.datagrid('reload');
        },
        //保存
        systemMenuSave : function(){
            //发送ajax请求,调用form组件的submit方法
            systemMenuDialogForm.form('submit', {
                url:'systemMenu/save',
                onSubmit: function(){
                    return systemMenuDialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = $.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        systemMenuDialog.dialog('close');
                        //给出提示
                        $.messager.alert('温馨提示',result.msg,'info');
                        //刷新表格数据
                        systemMenuDatagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        $.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                    }
                }
        });


        },
        //取消保存
        systemMenuCancel : function(){
            systemMenuDialog.dialog('close');
        },
        //删除
        systemMenuRemove : function(){
            //获取选中行
            var row = systemMenuDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            $.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    $.get('systemMenu/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            $.messager.alert('温馨提示',result.msg,'info');
                            //刷新表格数据
                            systemMenuDatagrid.datagrid('reload');
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
    systemMenuDatagrid.datagrid({
        title:'',
        url:'systemMenu/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        columns:[[
                        {field:'id',title:'菜单编号',width:100},
                        {field:'name',title:'菜单名称',width:100},
                        {field:'url',title:'菜单资源',width:100},
                        {field:'sn',title:'菜单简介',width:100},
                        {field:'icon',title:'菜单图标',width:100},
                        {field:'intro',title:'菜单介绍',width:100},
                        {field:'parentId',title:'父级菜单',width:100},
                    ]],
        toolbar:'#systemMenuDatagridToolbar'

    });
    //4.2 初始化添加修改模态框
    systemMenuDialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#systemMenuDialogToolbar'
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