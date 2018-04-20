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
        <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
                <div class="mb-1 text-muted">${biere.firstBrewed}</div>
                <c:forEach var="entry" items="${biere.ingredients}" >
                    ${entry.key} :<br>
                    <ul>
                    <c:forEach var="ingredient" items="${entry.value}" >
                        <li>
                            ${ingredient.name}
                                <c:choose>
                                    <c:when test="${empty ingredient.amount}">
                                        <br/>
                                    </c:when>
                                    <c:otherwise>
                                        : ${ingredient.amount.value} ${ingredient.amount.unit}<br/>
                                    </c:otherwise>
                                </c:choose>

                                <%--${ingredient.amout.unit} <br>--%>
                        </li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
            <img class="card-img-right flex-auto d-none d-md-block" src="${biere.image_url}" alt="beer image cap">
        </div>
    </div>
<main>
    <%@include file="footer.jsp" %>
