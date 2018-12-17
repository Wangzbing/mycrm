#set($D = '$')
${D}(function(){
    //1 声明变量用来缓存组件对象
    var ${domain}Datagrid,${domain}Dialog,${domain}DialogForm;
    //2 使用声明的变量来缓存组件
    ${domain}Datagrid = ${D}('#${domain}Datagrid');
    ${domain}Dialog = ${D}('#${domain}Dialog');
    ${domain}DialogForm = ${D}('#${domain}DialogForm');
    //3 创建一个命令对象，存放所有的按钮的点击事件的回调
    var cmdObj = {
        ${domain}Add : function(){
            //清空form表单
            ${domain}DialogForm.form('clear');
            //打开模态框，设置标题，居中
            ${domain}Dialog.dialog('open').dialog('setTitle','添加').dialog('center');
        },
        ${domain}Edit : function(){
            //获取选中行
            var row = ${domain}Datagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                ${D}.messager.alert('温馨提示','请选中一行进行修改!','info');
                return;
            }
            //清空form表单
            ${domain}DialogForm.form('clear');
            //回显form表单
            ${domain}DialogForm.form('load',row);
            //打开模态框，设置标题，居中
            ${domain}Dialog.dialog('open').dialog('setTitle','修改').dialog('center');
        },
        ${domain}Refresh : function(){
            ${domain}Datagrid.datagrid('reload');
        },
        //保存
        ${domain}Save : function(){
            //发送ajax请求,调用form组件的submit方法
            ${domain}DialogForm.form('submit', {
                url:'${domain}/save',
                onSubmit: function(){
                    return ${domain}DialogForm.form('validate');
                },
                success:function(data){
                    //data是一个json格式的字符串
                    var result = ${D}.parseJSON(data);
                    if(result.success){
                        //成功
                        //关闭模态框
                        ${domain}Dialog.dialog('close');
                        //给出提示
                        ${D}.messager.alert('温馨提示',result.msg,'info');
                        //刷新表格数据
                        ${domain}Datagrid.datagrid('reload');
                    }else{
                        //给出失败的提示
                        ${D}.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                    }
                }
        });


        },
        //取消保存
        ${domain}Cancel : function(){
            ${domain}Dialog.dialog('close');
        },
        //删除
        ${domain}Remove : function(){
            //获取选中行
            var row = ${domain}Datagrid.datagrid('getSelected');
            //判断是否选中
            if(!row){
                ${D}.messager.alert('温馨提示','请选中一行进行删除!','info');
                return;
            }
            //提示是否删除
            ${D}.messager.confirm('温馨提示','确定删除吗?',function(r){
                if(r){
                    //发送ajax请求进行删除
                    ${D}.get('${domain}/delete',{id:row.id},function(result){
                        if(result.success){
                            //成功
                            //给出提示
                            ${D}.messager.alert('温馨提示',result.msg,'info');
                            //刷新表格数据
                            ${domain}Datagrid.datagrid('reload');
                        }else{
                            //给出失败的提示
                            ${D}.messager.alert('温馨提示',result.errorCode+'-'+result.msg,'error');
                        }
                    },'json');
                }
            });
        }
    };
    //4 初始化组件
    //4.1 初始化数据表格
    ${domain}Datagrid.datagrid({
        title:'',
        url:'${domain}/page',
        pagination:true,
        rownumbers:true,
        singleSelect:true,
        fit:true,
        fitColumns:true,//列宽度
        columns:[[
            #foreach( $vo in $vos)
            {field:'$vo.filed',title:'$vo.title',width:100},
            #end
        ]],
        toolbar:'#${domain}DatagridToolbar'

    });
    //4.2 初始化添加修改模态框
    ${domain}Dialog.dialog({
        width: 400,
        height: 300,
        closed: true,
        modal: true,
        buttons: '#${domain}DialogToolbar'
    });
    //5 为页面上的所有的a标签注册点击事件
    ${D}('a').on('click',function(){
        //获取标签的data-cmd的属性值
        //对属性值进行判断
        var cmd = ${D}(this).data('cmd');
        if(cmd){
            cmdObj[cmd]();
        }
    });
});