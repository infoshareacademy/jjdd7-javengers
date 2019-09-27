<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <title>adminMode</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css"
        rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">

  <script src="https://apis.google.com/js/platform.js" async defer></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet"
        href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
          integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
          crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
          integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
          crossorigin="anonymous"></script>
  <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
        crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="/css/admin.css">
</head>
<body>

<div class="container-fluid">
  <div class="row">
    <h2 class=" display-3">Admin Panel</h2>
  </div>
</div>
<div class="row">
  <div class="col-sm-2 gray">
    <div class="links">
      <a href="#" onclick="window.location.href = '/home';">
        Main Page </a><br/>
    </div>
    <div class="links">
      <a href="#" onclick="window.location.href = '/superHero/upload-data';">
        Data Upload </a><br/>
    </div>
    <div class="links">
      <a href="#" onclick="window.location.href = '/superHero/recipes';">
        Recipes </a><br/>
    </div>
    <div class="links">
      <a href="#" onclick="window.location.href = '/superHero/users';">
        Statistics </a><br/>
    </div>
    <div class="links">
      <a href="#" onclick="window.location.href = '/superHero/statistics';">
        Statistics </a><br/>

      <div class="col-sm-10 white">
          <#list usersPerPage>
          <#items as user>
        <div class="row" Style="border: white solid; border-radius: .5rem; margin-bottom: 5px;">
          <div class="col-sm-3" style="padding: 0px">
            <h4 class="card-title">${user.name}</h4>
          </div>
          <div class="col-sm-3" style="padding: 0px; padding-top:4% ">
            <h4 class="card-title">${user.surname}</h4>
          </div>
          <div class="col-sm-3" style="padding: 0px; padding-top:4% ">
            <h4 class="card-title">${user.email}</h4>
          </div>
          <div class="col-sm-3" style="padding: 0px; padding-top:4% ">
            <h4 class="card-title">${user.userType}</h4>
          </div>
          <div class="col-sm-4" style="padding: 0px; padding-top: 7%">
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" data-id="${user.id}" class="btn btn-outline-success give">
                GIVE ADMIN PERMISSIONS
              </button>
              <button type="button" data-id="${user.id}" class="btn btn-outline-danger revoke">
                GIVE ADMIN PERMISSIONS
              </button>
            </div>
            <div class="col-sm-3" style="padding: 0px; padding-top:4% ">
              <button type="button" data-id="${user.id}" class="btn btn-outline-danger delete">DELETE
              </button>
            </div>
              </#items>
              </#list>
            <div class="row paginator">
              <div class="col-sm-3 paginator">
                <button class="favorite btn btn-primary btn-sm" type="button" value="1">First(1)
                </button>
                <button class="favorite btn btn-primary btn-sm" type="button"
                        <#if pageNumber gt 1> value="${pageNumber-1}" <#else> value="1" </#if>>
                  &leftarrow;
                </button>
              </div>
              <div class="col-sm-6 paginator">
                  <#if pageNumber gte 3>
                    ...
                    <button class="favorite btn btn-primary btn-sm" type="button"
                            value='${pageNumber-2}'>${pageNumber-2}</button>
                  </#if>
                  <#if pageNumber gte 2>
                    <button class="favorite btn btn-primary btn-sm" type="button"
                            value='${pageNumber-1}'>${pageNumber-1}</button>
                  </#if>
                <button class="favorite btn btn-light btn-sm" type="button" value='${pageNumber}'>
                  <strong>${pageNumber}</strong>
                </button>
                  <#if  (lastPageNumber-1) gte pageNumber>
                    <button class="favorite btn btn-primary btn-sm" type="button"
                            value='${pageNumber+1}'>${pageNumber+1}</button>
                  </#if>
                  <#if (lastPageNumber-2) gte pageNumber>
                    <button class="favorite btn btn-primary btn-sm" type="button"
                            value='${pageNumber+2}'>${pageNumber+2}</button>
                    ...
                  </#if>
              </div>
              <div class="col-sm-3 paginator">
                <button class="favorite btn btn-primary btn-sm" type="button"
                        <#if (lastPageNumber-1) gte pageNumber> value="${pageNumber+1}" <#else>
                  value="${lastPageNumber}" </#if>>
                  &rightarrow;
                </button>
                <button class="favorite btn btn-primary btn-sm" type="button"
                        value="${lastPageNumber}">
                  Last(${lastPageNumber})
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="/js/admin.js"></script>
</body>
</html>
