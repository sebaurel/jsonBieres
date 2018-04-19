<%--
  Created by IntelliJ IDEA.
  User: sebastien
  Date: 19/04/2018
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">${biere.name}</h1>
            <p> ${biere.description}</p>
        </div>
    </div>
<main>
    <%@include file="footer.jsp" %>
