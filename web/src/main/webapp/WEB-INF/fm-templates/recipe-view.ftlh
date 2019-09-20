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
    <!--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
            crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>-->


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
                                    aria-controls="name" aria-selected="true"><h4><strong>Recipe Name</strong></h4></a>
            </li>
            <li class="nav-item"><a class="col-md text-sm-center nav-link" id="ingredient-tab"
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

    <div class="col-sm-6" STYLE="margin: auto; padding-top: 24px; padding-bottom: 24px;">
        <h2 class="card-title" style="color: olivedrab">${responseRecipeId.name}</h2>
    </div>

    <div class="row" style="margin:0;">

        <div id="left" class=" col-sm-1">
            <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>left</button>
        </div>

        <div class="col-sm-10">

            <div class="row ">
                <div class="col-md-6" ; style="margin:0px">
                    <#if responseRecipeId.imageUrl??>
                        <img src="${responseRecipeId.imageUrl}" style="max-width: 100%;" class="card-img" alt="...">
                    <#else>
                        <img src="http://placekitten.com/g/700/700" style="max-width: 100%;" class="card-img"
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
                                            <li>${ingredient.measure}</li>
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
                            <small class="text-muted">Date of modification: ${responseRecipeId.modificationDate}</small>
                        </p>
                        <br/>
                    </div>
                </div>
            </div>

        </div>

        <div id="right" class="col-sm-1">
            <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>right</button>
        </div>

    </div>
    <div class="col-sm-6" id="edit-buttons-single-view">
        <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>FAVS</button>
        <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>EDIT</button>
        <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>DELETE</button>
        <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>RANDOM</button>
    </div>
</div>


<script src="js/index.js"></script>


</body>
</html>