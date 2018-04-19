<%--
  Created by IntelliJ IDEA.
  User: SeB
  Date: 19/04/2018
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">De la bonne biere</h1>
            <p> Have you ever wanted to search through Brewdog's expansive back catalogue of beer in a programmatic way? Maybe build a tool that pairs beer with food, or search beers with an abv of more than 4%? Well now your prayers have been answered!<br>
                <br>
                The Punk API takes Brewdog's DIY Dog and turns it into a searchable, filterable API that's completely free and open source.</p>
            <p><a class="btn btn-primary btn-lg" href="https://punkapi.com/" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="row mb-2">
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">Beer</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">${bierea.name}</a>
                    </h3>
                    <div class="mb-1 text-muted">${bierea.firstBrewed}</div>
                    <p class="card-text mb-auto">${bierea.description}</p>
                    <a href="beer?id=${biere.id}">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="${bierea.image_url}" alt="beer image cap" height="300px">
            </div>
        </div>
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Beer</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">${biereb.name}</a>
                    </h3>
                    <div class="mb-1 text-muted">${biereb.firstBrewed}</div>
                    <p class="card-text mb-auto">${biereb.description}</p>
                    <a href="beer?id=${biereb.id}">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="${biereb.image_url}" alt="beer image cap" height="300px">
            </div>
        </div>
    </div>
    </div>

</main>
<h1></h1>


<%@include file="footer.jsp"%>