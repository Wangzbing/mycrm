<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //跳转
    //response.sendRedirect("main");
    request.getRequestDispatcher("/main").forward(request, response);
%>
