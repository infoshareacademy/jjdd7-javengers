<!DOCTYPE html>
<html lang="en">
<head>

    <title>Add Recipe Form</title>
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
    <link rel="stylesheet" type="text/css" href="css/add-recipe-view.css">

</head>
<body>
<div class="jumbotron jumbotron-fluid ">
    <#include "login.ftlh">
    <div class="container">
        <h1 class="display-3">Drinkopedia</h1>
        <p class="lead">Read, mix, enjoy...</p>
    </div>

    <div class="modal fade" id="success" tabindex="-1" role="dialog"
         aria-labelledby="success" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <h3>Your Recipe was sent to the Admin for authorization</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </div>

</div>

<div class="container">
    <div class="container">
        <div class="row">
            <div class="col-sm-6" id="search-container" style="margin: auto">
                <ul class="nav nav-tabs nav-justified " style="margin: 0px" id="navTab" role="tablist">
                    <li class="nav-item"><a class="col-md text-sm-center nav-link active" id="name-tab"
                                            data-target="#panel_a_name"
                                            data-secondary="#panel_a_name" href="#panel_a_name" data-toggle="tab"
                                            role="tab"
                                            aria-controls="name" aria-selected="true"><h4><strong>Add Recipe
                                    Form</strong></h4></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <form class="add-recipe-form" method="POST" action="#" enctype="multipart/form-data">
        <#--<form class="add-recipe-form" method="POST" action="#" enctype="form-data">-->
        <div class="row">
            <div class="card col-sm-3">
                <header class="card-header"><h4 class="title">Category</h4></header>
                <div class="btn-group-vertical">
                    <#list categoryList>
                        <#items as category>
                            <label class="btn btn-outline-light ">
                                <input class="x-category" type="radio" name="category" value="${category.name}"
                                       required>
                                <span class="form-check-label">${category.name}</span>
                            </label>
                        </#items>
                    </#list>
                </div>
            </div>
            <div class="card col-sm-6">
                <header class="card-header"><h4 class="title">Name of Drink</h4></header>
                <div class="container">
                    <!--<label for="textInput">name</label>-->
                    <input type="text" id="name" class="input" placeholder="input name" name="name" required
                           maxlength="30">
                </div>
                <header class="card-header"><h4 class="title">Ingredients</h4></header>
                <div class="container">
                    <div class="container row" style="margin: auto; align-content: center">
                        <div id="field1" style="margin: auto">
                            <input autocomplete="off" class="input" id="fielda1" name="ingredient" type="text"
                                   placeholder="input ingredient" data-items="8" required/>
                            <input autocomplete="off" class="finput" id="fieldb1" name="measure" type="text"
                                   placeholder="input measure" data-items="8" required/>
                        </div>
                        <button id="b1" class="btn btn-sm add-more" type="button">+</button>
                    </div>
                </div>
                <header class="card-header"><h4 class="title">Type of Glass</h4></header>
                <div class="container">
                    <input type="text" id="glass" class="input" placeholder="type of glass" name="glass" required
                           maxlength="30">
                </div>

                <header class="card-header"><h4 class="title">Instructions</h4></header>
                <div class="container">
                    <input type="text" id="instructions" class="input" placeholder="input instructions"
                           name="instructions" required maxlength="1000">
                </div>
            </div>
            <div class="card col-sm-3" style="margin-top: 30%">
                <header class="card-header"><h4 class="title">Type</h4></header>
                <div class="btn-group-vertical">
                    <#list typeList>
                        <#items as type>
                            <label class="btn btn-outline-light ">
                                <input class="x-type" type="radio" name="type" value="${type}" required>
                                <span class="form-check-label">${type}</span>
                            </label>
                        </#items>
                    </#list>
                </div>
                <header class="card-header"><h4 class="title">Image</h4></header>
                <input type="file" name="image" style="margin: auto"/>
            </div>
        </div>
        <button class="btn btn-primary btn-lg" id="sub" type="submit" style="text-align:left">Add Recipe</button>
    </form>
</div>
<script src="/js/add-recipe-view.js"></script>
</body>
</html>