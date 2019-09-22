<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <title>adminMode</title>

  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
        crossorigin="anonymous">
  <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>

<div class="jumbotron jumbotron-fluid ">
    <h3 class="display-3">Admin Panel</h3>
</div>
<div><a class="btn btn-secondary btn-lg active" href="#" onclick="window.location.href = '/user';">
    Main Page </a></div>
<div class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">
  <form id="form-upload" action="/upload-data" method="post"enctype="multipart/form-data">
    <input type ="file" name="drinks">
    <button type="submit" class="btn btn-secondary">Upload</button>
  </form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

