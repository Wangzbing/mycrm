<%--
  Created by IntelliJ IDEA.
  User: 半个文化人
  Date: 2018/12/2
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <%@include file="/WEB-INF/views/common/common.jsp" %>
    <%--main轮播图开始--%>
    <script type="text/javascript" src="/static/js/plugins/main/main.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/js/plugins/main/main.css">
    <link rel="stylesheet" type="text/css" href="/static/js/plugins/main/css/styles.csscss">
    <link rel="stylesheet" type="text/css" href="/static/js/plugins/main/css/default.css">
    <link rel="stylesheet" type="text/css" href="/static/js/plugins/main/css/normalize.css">



    <%--main轮播图结束--%>
    <style type="text/css">
        .layout-panel-west{ border-right: 1px solid #c5c5c5; }
    </style>
</head>

<body>
<div id="master-layout">
    <div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
    <div class="theme-navigate">
        <div class="left">
            <a href="#" class="easyui-menubutton theme-navigate-user-button" data-options="menu:'.theme-navigate-user-panel'">${sessionScope.loginUser.realname}</a>
            <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">消息<span class="badge color-default">15</span></a>
            <select id="cc1" class="easyui-combobox theme-navigate-combobox" name="dept" style="width:120px;">
                <option>选择样式</option>
                <option>Insdep</option>
                <option>Bootstrap</option>
                <option>Gray</option>
                <option>Metro</option>
                <option>Material</option>
            </select>

            <div id="mm3" class="theme-navigate-menu-panel" style="width:180px;">
                <div>产品消息<span class="badge color-success">5</span></div>
                <div>安全消息<span class="badge color-important">10</span></div>
                <div>服务消息</div>
                <div class="menu-sep"></div>
                <div>查看历史消息</div>
                <div class="menu-sep"></div>
                <div>清除消息提示</div>
            </div>


            <div class="theme-navigate-user-panel">
                <dl>
                    <dd>
                        <img src="/static/js/plugins/easyui/themes/images/portrait86x86.png" width="86" height="86">
                        <b class="badge-prompt">${sessionScope.loginUser.realname}<i class="badge color-important">10</i></b>
                        <span>${sessionScope.loginUser.email}</span>
                        <p>电话：<i class="text-success">${sessionScope.loginUser.tel}</i></p>
                    </dd>
                    <dt>
                        <a class="theme-navigate-user-modify" href="/employee/index">修改资料</a>
                        <a class="theme-navigate-user-logout" href="/logout">注销</a>
                    </dt>
                </dl>
            </div>
        </div>

        <div class="right">
            <select id="cc2" class="easyui-combobox theme-navigate-combobox" name="dept" style="width:180px;">
                <option>Choose a language</option>
                <option>Chinese</option>
                <option>English</option>
                <option>Korean</option>
                <option>Japanese</option>
                <option>Arabic</option>
            </select>
            <input class="easyui-searchbox theme-navigate-search" data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
            <a href="#" class="easyui-menubutton theme-navigate-more-button" data-options="menu:'#more',hasDownArrow:false"></a>
            <div id="more" class="theme-navigate-more-panel">
                <ul class="easyui-tree" id="MenuTree" style="width: 240px">
                </ul>
            </div>
            <div id="mm" class="theme-navigate-menu-panel">
                <div data-options="name:'all'">全部内容</div>
                <div data-options="name:'sports'">标题</div>
                <div data-options="name:'sports'">作者</div>
                <div data-options="name:'sports'">内容</div>
            </div>
        </div>
    </div>
</div>

    <div data-options="region:'center',border:false">
        <div class="easyui-tabs" data-options="tabHeight:32" id="tabs" style=" background:#fff;" >
            <div title="首页">
                <div class="trent-slider" style="margin-left: 50px;margin-right: 50px;margin-top: 80px">

                </div>
                <%--轮播图--%>
            </div>

        </div>
    </div>

    </div>



<script>
    $(function(){
            $("#MenuTree").tree({

                url:"/systemMenu/findMenuTree",
                onClick:function(node){
                    console.debug(node);
                    //判断是否是一级菜单，如果是不做事情 没有儿子菜单
                    if(node.url){
                        //跳转到对应页面的URL
                        var url = node.url;
                        var text = node.text;
                        var icon = node.icon;
                        //同一个菜单，可以多次点击，创建相同的页面。期望效果，没有就创建，有就选中
                        if($("#tabs").tabs("exists",text)){
                            //有就选中 select
                            $("#tabs").tabs("select",text)
                        }else{
                            //创建内容区域的一个页面
                            $("#tabs").tabs("add",{
                                title:text,
                                iconCls:icon,
                                closable:true,
                                //页面里面远程加载数据。。。。。只加载body部分，头部没有。在头部实现的功能没有了
                                content:'  <iframe frameborder="no" src="'+url+'"  width="100%" height="100%"></iframe>'
                            });
                        }
                    }
                }
            });

        /*布局部分*/
        $('#master-layout').layout({
            fit:true/*布局框架全屏*/
        });

        $(".theme-navigate-user-modify").on("click",function(){
            $('.theme-navigate-user-panel').menu('hide');
            $.insdep.window({id:"personal-set-window",href:"user.html",title:"修改资料"});
        });
        //$.insdep.control("list.html");



        var cc1=$('#cc1').combo('panel');
        cc1.panel({cls:"theme-navigate-combobox-panel"});
        var cc2=$('#cc2').combo('panel');
        cc2.panel({cls:"theme-navigate-combobox-panel"});




        /*$("#open-layout").on("click",function(){
                var option = {
                    "region":"west",
                    "split":true,
                    "title":"title",
                    "width":180
                };
                $('#master-layout').layout('add', option);

        });*/


    });
    function doSearch(value,name){
        alert('You input: ' + value+'('+name+')');
    }

</script>
<canvas id="glCanvas" width="450px" height="500px" style="position:fixed;left:0px;bottom:-10px;">
</canvas>
<script>
    SampleApp1();
</script>
</body>
</html>
