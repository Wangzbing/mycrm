//1 声明变量用来缓存组件对象
var systemDictionaryTypeDatagrid,systemDictionaryTypeDialog,systemDictionaryTypeDialogForm;
$(function(){
    //2 使用声明的变量来缓存组件
    systemDictionaryTypeDatagrid = $('#systemDictionaryTypeDatagrid');
    systemDictionaryTypeDialog = $('#systemDictionaryTypeDialog');
    systemDictionaryTypeDialogForm = $('#systemDictionaryTypeDialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    cmdObj2 = {
        systemDictionaryTypeAdd : function(){
            //清空form表单
            systemDictionaryTypeDialogForm.form('reset');
            //打开模态框，设置标题，居中
            systemDictionaryTypeDialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        systemDictionaryTypeEdit : function(){
            //获取选中行
            var row = systemDictionaryTypeDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            systemDictionaryTypeDialogForm.form('reset');
            //回显form表单
            systemDictionaryTypeDialogForm.form('load',row);
            //打开模态框，设置标题，居中
            systemDictionaryTypeDialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        systemDictionaryTypeRefresh : function(){
            systemDictionaryTypeDatagrid.datagrid('reload');
        },
        //保存
        systemDictionaryTypeSave : function(){
            //发送ajax请求,调用form组件的submit方法
            systemDictionaryTypeDialogForm.form('submit', {
                url:'systemDictionaryType/save',
                onSubmit: function(){
                    return systemDictionaryTypeDialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = $.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        systemDictionaryTypeDialog.dialog('close');
                        //给出提示
                        $.messager.alert('温馨提示',result.msg,'info');
                        //刷新表格数据
                        systemDictionaryTypeDatagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        $.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                    }
                }
        });


        },
        //取消保存
        systemDictionaryTypeCancel : function(){
            systemDictionaryTypeDialog.dialog('close');
        },
        //删除
        systemDictionaryTypeRemove : function(){
            //获取选中行
            var row = systemDictionaryTypeDatagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                $.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            $.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    $.get('systemDictionaryType/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            $.messager.alert('温馨提示',result.message,'info');
                            //刷新表格数据
                            systemDictionaryTypeDatagrid.datagrid('reload');
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
    systemDictionaryTypeDatagrid.datagrid({
        title:'',
        url:'systemDictionaryType/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        columns:[[
                        {field:'id',title:'类型id',width:100,hidden:true},
                        {field:'name',title:'类型名称',width:100},
                        {field:'sn',title:'类型简称',width:100},
                        {field:'intro',title:'类型说明',width:100},
                    ]],
        toolbar:'#systemDictionaryTypeDatagridToolbar',
        onClickRow:function (index,row) {
            if(row){
                systemDictionaryItemDatagrid.datagrid("reload",{type:row.id})
            }
        }

    });
    //4.2 初始化添加修改模态框
    systemDictionaryTypeDialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#systemDictionaryTypeDialogToolbar'
    });
    //5 为页面上的所有的a标签注册点击事件
});