<!DOCTYPE html>
<html lang="en">
<head>

    <title>index page</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="google-signin-client_id"
          content="1037530492027-j033lgm76kc63lrkqpaus0sn25q00vj2.apps.googleusercontent.com">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet"/>

    <script src="https://apis.google.com/js/platform.js" async defer></script>
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

    <style>
        .card {
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
                <#include "login.ftlh">
            </li>
        </ul>
    </div>

    <div class="container">
        <h1 class="display-3">Drinkopedia</h1>
        <p class="lead">Read, mix, enjoy...</p>
    </div>
</div>

<div class="container">


    <div class="row">

        <header class="card-header" style="margin: auto">
            <h3 class="title">Welcome to the most impressive Encyclopedia</h3>
            <h3 class="title"> of drink recipies</h3>
            <h3 class="title">in the World Wide Web</h3>
        </header>

    </div>
    <div class="row" style="padding-top: 0%">
        <div class="card col-sm-5" style="padding-top: 0%">
            <header class="card-header"><h4 class="title">References:</h4></header>
            <br/>
            <img class="rounded" src="/img/kwachuMeme.jpeg" alt="kwachu" style="width: 100%">
            <br/>
            <br/>
            <img class="rounded" src="/img/bondMeme.jpg" alt="bond" style="width: 100%">

        </div>

        <div class="card col-sm-7">

            <p style="font-size: 30px; padding-top: 18%"> If you are ready to explore...</p>

            <button class="btn btn-primary" type="button" value='edit' style="width: 50%;
            height: 200%; font-size: x-large; text-align: center; padding-left:2%; margin: auto"
                    onclick="window.location.href = '/home';">Push the button
            </button>


            <div class="card" style="padding-left: 55%; margin: 5%">
                <br/>
                <h4 class="title" style="text-align: left;"> by javengers</h4>
                <p style="text-align: left; font-size: larger; padding-top: 10%">
                    Daria Lubobska <br/>
                    Klaudia Zarychta <br/>
                    Andrzej Szypulski <br/>
                </p>
            </div>

        </div>

    </div>

</div>

<script src="js/index.js"></script>


</body>
</html>