<!DOCTYPE html>
<html lang="en">
<head>

    <title>home page</title>
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
    <#include "login.ftlh">
    <div class="container">
        <h1 class="display-3">Drinkopedia</h1>
        <p class="lead">Read, mix, enjoy...</p>
    </div>
    <#include "unauthorizeAttempt.ftlh">
</div>

    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <button class="btn btn-primary" id="new-drink2" type="button" title="Create a new recipe!"
                            value="new-drink" style="padding-left:14%; margin:auto" onclick="window.location.href='/add-recipe-view'">
                        <img src="https://img.icons8.com/dotty/100/000000/cocktail.png" style="width:75%">
                    </button>
                </div>

                <div class="col-sm-6" id="search-container">
                    <ul class="nav nav-tabs nav-justified " style="margin: 0px" id="navTab" role="tablist">
                        <li class="nav-item"><a
                                    <#if isActive?? && isActive == "ingredient"> class="col-md text-sm-center nav-link "
                                    <#else>
                                        class="col-md text-sm-center nav-link active"
                                    </#if>
                                    id="name-tab"
                                    data-target="#panel_a_name"
                                    data-secondary="#panel_a_name" href="#panel_a_name" data-toggle="tab" role="tab"
                                    aria-controls="name" aria-selected="true"><h4><strong>Recipe Name</strong></h4></a>
                        </li>
                        <li class="nav-item"><a
                                    <#if isActive?? && isActive == "ingredient">
                                        class="col-md text-sm-center nav-link active"
                                    <#else>
                                        class="col-md text-sm-center nav-link"
                                    </#if>
                                    id="ingredient-tab"
                                    data-target="#panel_a_ingredient" data-secondary="#panel_a_ingredient"
                                    href="#panel_a_ingredient" data-toggle="tab" role="tab" aria-controls="ingredient"
                                    aria-selected="false"><h4><strong>Ingredient</strong></h4></a></li>
                    </ul>

                    <div class="tab-content col-sm-12 " id="navTabA">

                        <div <#if isActive?? && isActive == "ingredient"> class="tab-pane pane"
                        <#else> class="tab-pane active"
                        </#if>
                                id="panel_a_name" role="tabpanel" aria-labelledby="name-tab">
                            <form id="form-name">
                                <input type="text" id="input-name" class="form-control" placeholder="search by name">
                            </form>
                        </div>

                        <div <#if isActive?? && isActive == "ingredient"> class="tab-pane active"
                        <#else> class="tab-pane"
                        </#if>
                                id="panel_a_ingredient" role="tabpanel" aria-labelledby="ingredient-tab">
                            <form id="form-ingredient">
                                <input type="text" id="input-ingredient" class="form-control"
                                       placeholder="search by ingredient">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="list-ingredient">
            <#include "list-ingredient.ftlh">
        </div>
        <div class="row">
            <div class="card col-sm-3">
                <#include "list-category.ftlh">
            </div>
            <div class="card col-sm-6">
                <#include "userContent.ftlh">
            </div>
            <div class="card col-sm-3" style="margin-top: 10%">
                <#include "list-options.ftlh">
                <#include "list-type.ftlh">
            </div>
        </div>
    </div>
    <script src="/js/index.js"></script>
</body>
</html>