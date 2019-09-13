<!DOCTYPE html>
<html lang="en">
<head>

    <title>index page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<body>

<div class="jumbotron jumbotron-fluid ">
    <div class="container-fluid">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link active" href="#">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">sign in</a>
            </li>
        </ul>
    </div>

    <div class="container">
        <h1 class="display-3">Drinkopedia</h1>
        <p class="lead">Read, mix, enjoy...</p>
    </div>
</div>

<div class="container">

    <div class="col-sm-12-md-6" id="search-container">
        <ul class="nav nav-tabs nav-justified " style="margin: 0px" id="navTab" role="tablist">
            <li class="nav-item"><a class="col-md text-sm-center nav-link active" id="name-tab"
                                    data-target="#panel_a_name"
                                    data-secondary="#panel_a_name" href="#panel_a_name" data-toggle="tab" role="tab"
                                    aria-controls="name" aria-selected="true"><h4><strong>Recipe Name</strong></h4></a></li>
            <li class="nav-item"><a class="col-md text-sm-center nav-link" id="ingredient-tab"
                                    data-target="#panel_a_ingredient" data-secondary="#panel_a_ingredient"
                                    href="#panel_a_ingredient" data-toggle="tab" role="tab" aria-controls="ingredient"
                                    aria-selected="false"><h4><strong>Ingredient</strong></h4></a></li>
        </ul>

        <div class="tab-content col-sm-12 " id="navTabA">

            <div class="tab-pane active" id="panel_a_name" role="tabpanel" aria-labelledby="name-tab">
                <form id="form-name">
                    <input type="text" id="input-name" class="form-control" placeholder="search by name">
                </form>
            </div>

            <div class="tab-pane" id="panel_a_ingredient" role="tabpanel" aria-labelledby="ingredient-tab">
                <form id="form-ingredient">
                    <input type="text" id="input-ingredient" class="form-control"
                           placeholder="search by ingredient">
                </form>
            </div>
        </div>

    </div>
    <div class="container" id="list-ingredient">
        <#--list ingredient fm template-->
        <#include "list-ingredient.ftlh">
    </div>
    <div class="row">
        <div class="card col-sm-3">
            <#--list category fm template-->
            <#include "list-category.ftlh">
        </div>
        <div class="card col-sm-6">
            <#--content fm templates-->
            <#include "content.ftlh">
        </div>
        <div class="card col-sm-3" style="margin-top: 20%">
            <#--list-options fm templates-->
            <#include "list-options.ftlh">
        </div>
    </div>
</div>

<script src="js/index.js"></script>
<#include "javascripts.ftlh">


</body>
</html>