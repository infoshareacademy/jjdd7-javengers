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
  <link rel="stylesheet" href="../../css/index.css"/>
</head>
<body>
<header class="header">
  <div class="container-fluid">
    <div class="navbar-holder d-flex align-items-center justify-content-between">
      <!-- Navbar Header-->
      <div class="navbar-header">
        <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
          <div class="brand-text d-none d-lg-inline-block"><span>Bootstrap </span><strong>Admin
              Panel</strong></div>
          <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
        </a>
        <!-- Toggle Button--><a id="toggle-btn" href="#"
                                class="menu-btn active"><span></span><span></span><span></span></a>
      </div>
    </div>
  </div>
</header>

<div><a class="btn btn-secondary btn-lg active" href="#" onclick="window.location.href = '/home';">
    Main Page </a></div>

<div class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">
  <form id="form-upload" action="/superHero/upload-data" method="post"enctype="multipart/form-data">
    <input type ="file" name="drinks">
    <button type="submit" cla="btn btn-secondary">Upload</button>
  </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

