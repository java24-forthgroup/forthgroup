<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>员工显示</title>
</head>
<body>
<h3>员工显示</h3>

    <table>
        <thead>
        <th>序号</th>
        <th>员工姓名</th>
        </thead>
        <tbody>
        <c:forEach items="${empList}" var="emp" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${emp.ename}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>


</body>
</html>
