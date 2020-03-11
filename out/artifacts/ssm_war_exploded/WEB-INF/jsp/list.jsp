<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-4.4.1/dist/css/bootstrap.min.css"/>
    <script src="${APP_PATH}/static/bootstrap-4.4.1/dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/js/jquery.min.js" type="application/javascript"></script>
</head>
<body>
    <!--搭建显示页码-->
    <div class="container">
        <!-- 标题-->
        <div class="row">
            <div class="col-md-12">
                <h1>
                    SSM-CRUD
                </h1>
            </div>
        </div>

        <!-- 按钮-->
        <div class="row">
            <div class="col-md-4 col-lg-offset-8">
                <button class="btn btn-success btn-sm">新增</button>
                <button class="btn btn-danger btn-sm">删除</button>
            </div>
        </div>

        <!-- 显示表格数据-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptment</th>
                    <th>操作</th>
                </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <th>${emp.empId}</th>
                        <th>${emp.empName}</th>
                        <th>${emp.gender=="M"?"男":"女"}</th>
                        <th>${emp.email}</th>
                        <th>${emp.department}</th>
                        <th>
                            <button class="btn btn-info btn-sm" >
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true">
                                </span>修改</button>
                           &nbsp;|
                            <button class="btn btn-danger btn-sm" >
                                <span class="glyphicon glyphicon-trash" aria-hidden="true">
                                </span>删除</button>
                        </th>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- 显示分页信息-->
        <div class="row">
            <!--分页文字信息-->
            <div class="col-md-6">
                当前${pageInfo.pageNum}页，总${pageInfo.pages}页，共${pageInfo.total}
            </div>

            <!--分页条信息-->
            <div class="col-md-6">
                <nav aria-label="Page navigation" >
                    <ul class="pagination">

                        <li><a href="${APP_PATH}/emps?pn=${pageInfo.firstPage}">首页</a></li>
                        <li>
                            <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${APP_PATH}/emps?pn=${page_Num-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                            </c:if>
                        </li>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${pageInfo.pageNum==page_Num}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum!=page_Num}">
                                <li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                     </c:forEach>
                        <c:if test="${pageInfo.hasNextPage}">
                        <li>
      <a href="${APP_PATH}/emps?pn=${page_Num+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        </c:if>
                        <li><a href="${APP_PATH}/emps?pn=${pageInfo.total}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
