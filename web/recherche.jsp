<%--
  Created by IntelliJ IDEA.
  User: SeB
  Date: 20/04/2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Find Beers</h1>
    </div>
</div>

<div class="card flex-md-row mb-4 box-shadow h-md-250">
    <div class="card-body d-flex flex-column align-items-start">
        <h3 class="mb-0">Search by name</h3>
        <div class="row mb-2">
            <div class="col-md-6">
                <form method="post" action="/beers">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Name Pattern" id="name" name="name">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Research</button>
                </form>
            </div>
        </div>
    </div>
    <div class="card-body d-flex flex-column align-items-start">
        <h3 class="mb-0">Search by ingredients</h3>
        <div class="row mb-2">
            <div class="col-md-6">
                <form method="post" action="/beers">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Type" id="type" name="type">
                        <input class="form-control" type="text" placeholder="Name" id="ingredient" name="ingredient">
                        <input class="form-control" type="text" placeholder="Volume" id="quantite" name="quantite">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Research</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
