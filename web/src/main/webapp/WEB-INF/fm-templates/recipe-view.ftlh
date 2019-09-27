<!DOCTYPE html>
<html lang="en">
<head>

    <title>single view page</title>
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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/index.css">

    <style>

        #left {
            margin-top: 20%;

        }

        #right {
            margin-top: 20%;
        }

        .container {
            color: white;
        }

    </style>
</head>
<body>no bo to było

<div class="jumbotron jumbotron-fluid ">
    <div class="jumbotron jumbotron-fluid ">
        <#include "navbar.ftlh">

        <div class="container">
            <h1 class="display-3">Drinkopedia</h1>
            <p class="lead">Read, mix, enjoy...</p>
        </div>
    </div>

    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <button class="btn btn-primary btn-sm" id="new-drink2" type="button" title="Go back to home view"
                            value="new-drink" style="padding-left:5%; margin:auto"
                            onclick="window.location.href='www.google.com'">
                        <img src="https://img.icons8.com/dotty/80/000000/return.png">
                    </button>

                    <label class="btn btn-primary btn-sm" title="add to favourites">
                        <input class="x-favourite" type="checkbox" value="${responseRecipeId.id?c}">
                        <span class="form-check-label" style="padding-left: 2px"><img id="fav"
                                    src="https://img.icons8.com/dotty/80/000000/hearts.png"></span>
                    </label>

                </div>

                <div class="col-sm-6" id="search-container">
                    <ul class="nav nav-tabs nav-justified " style="margin: 0px" id="navTab" role="tablist">
                        <li class="nav-item"><a class="col-md text-sm-center nav-link active" id="name-tab"
                                                data-target="#panel_a_name"
                                                data-secondary="#panel_a_name" href="#panel_a_name" data-toggle="tab"
                                                role="tab"
                                                aria-controls="name" aria-selected="true"><h4><strong>Recipe
                                        Name</strong></h4></a>
                        </li>
                        <li class="nav-item"><a class="col-md text-sm-center nav-link" id="back-button"
                                    <#if pU??>
                                                href="${pU}"
                                    <#else >
                                                href="/home">
                                </#if>
                                <h4><strong>Back to list</strong></h4></a></li>
                    </ul>

                    <div class="tab-content col-sm-12 " id="navTabA">

                        <div class="tab-pane active" id="panel_a_name" role="tabpanel" aria-labelledby="name-tab">
                            <form id="form-name">
                                <input type="text" id="input-name" class="form-control" placeholder="search by name">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-sm-6" STYLE="margin: auto; padding-top: 24px; padding-bottom: 24px;">
            <h2 class="card-title" style="color: olivedrab">${responseRecipeId.name}</h2>
        </div>


        <div class="col-sm-10">

            <div class="row ">
                <div class="col-md-6" ; style="margin:0px">
                    <#if responseRecipeId.imageUrl??>
                        <img src="${responseRecipeId.imageUrl}" style="max-width: 100%;" class="card-img"
                             alt="...">
                    <#else>
                        <img src="http://placekitten.com/g/700/700" style="max-width: 100%;"
                             class="card-img"
                             alt="...">
                    </#if>
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title">Ingredients</h5>
                        <div class="row ">
                            <div class="col-md-6">
                                <ul>
                                    <#list responseRecipeId.ingredients>
                                        <#items as ingredient>
                                            <li>${ingredient.name}:</li>
                                        </#items>
                                    </#list>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <ul>
                                    <#list responseRecipeId.ingredients>
                                        <#items as ingredient>
                                            <li>
                                                <#if ingredient.measure != "">
                                                    ${ingredient.measure}
                                                <#else>
                                                    -
                                                </#if>
                                            </li>
                                        </#items>
                                    </#list>
                                </ul>
                            </div>
                        </div>
                        <br/>
                        <h5 class="card-title">Instructions</h5>
                        <p class="card-text">${responseRecipeId.instruction}</p>
                        <br/>
                        <div class="row ">
                            <div class="col-md-4">
                                <h5 class="card-title">Category</h5>
                                <p class="card-text">${responseRecipeId.category.name}</p>
                            </div>
                            <div class="col-md-4">
                                <h5 class="card-title">strAlcoholic</h5>
                                <p class="card-text">${responseRecipeId.drinkType}</p>
                            </div>
                            <div class="col-md-4">
                                <h5 class="card-title">Glass</h5>
                                <p class="card-text">${responseRecipeId.glassType}</p>
                            </div>
                        </div>
                        <br/>
                        <p class="card-text">
                            <small class="text-muted">Date of
                                modification: ${responseRecipeId.modificationDate}</small>
                        </p>
                        <br/>
                    </div>
                </div>
            </div>

        </div>


    </div>


    <script src="js/recipe-view.js"></script>


</body>
</html>