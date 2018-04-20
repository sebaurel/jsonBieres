<%--
  Created by IntelliJ IDEA.
  User: SeB
  Date: 20/04/2018
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>


<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Yours Beers</h1>
    </div>
</div>
<div class="row mb-2">

<c:forEach var="biere" items="${bieres}" >

    <div class="col-md-6">
        <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
                <strong class="d-inline-block mb-2 text-primary">${name} ${type} ${ingredient} ${quantite}</strong>
                <h3 class="mb-0">
                    <a class="text-dark" href="#">${biere.name}</a>
                </h3>
                <div class="mb-1 text-muted">${biere.firstBrewed}</div>
                <p class="card-text mb-auto">${biere.description}</p>
                <a href="beer?id=${biere.id}">Continue reading</a>
            </div>
            <img class="card-img-right flex-auto d-none d-md-block" src="${biere.image_url}" alt="beer image" height="300px">
        </div>
    </div>
</c:forEach>
</div>

<%@include file="footer.jsp"%>