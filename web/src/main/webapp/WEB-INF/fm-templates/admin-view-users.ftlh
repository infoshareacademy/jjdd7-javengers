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
    <h2 class="display-3">Admin Panel</h2>
  </div>
</div>
<div class="row">
    <#include "admin-options.ftlh">
  <div class="col-sm-10 white">
    <table class="table white ">
      <thead>
      <tr>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">User Type</th>
        <th scope="col">Admin privileges</th>
        <th scope="col">Delete</th>
      </tr>
      </thead>
      <tbody>
      <#list  usersPerPage as user>
        <tr>
          <td>${user.name}</td>
          <td>${user.email}</td>
          <td>${user.userType}</td>
            <#if user.id != 1>

              <td>
                <div class="btn-group" role="group" aria-label="Basic example">
                  <button type="button" data-id="${user.id}" class="btn btn-success give">
                    GIVE
                  </button>
                  <button type="button" data-id="${user.id}"
                          class="btn btn-danger revoke">
                    REVOKE
                  </button>
                </div>
              </td>
              <td>
                <div>
                  <button type="button" data-id="${user.id}" class=" btn btn-delete delete">
                    DELETE
                  </button>
                </div>
              </td>
            </#if>
        </tr>
      </#list>
      </tbody>
    </table>
    <div class="row white">
      <div class="col-sm-3">
        <button class="btn btn-dark" type="button" value="1">First(1)
        </button>
        <button class="btn btn-dark" type="button"
                <#if pageNumber gt 1> value="${pageNumber-1}" <#else> value="1" </#if>>
          &leftarrow;
        </button>
      </div>
      <div class="col-sm-6">
          <#if pageNumber gte 3>
            ...
            <button class="btn btn-secondary" type="button"
                    value='${pageNumber-2}'>${pageNumber-2}</button>
          </#if>
          <#if pageNumber gte 2>
            <button class="btn btn-secondary" type="button"
                    value='${pageNumber-1}'>${pageNumber-1}</button>
          </#if>
        <button class="btn btn-light" type="button" value='${pageNumber}'>
          <strong>${pageNumber}</strong>
        </button>
          <#if  (lastPageNumber-1) gte pageNumber>
            <button class="btn btn-dark" type="button"
                    value='${pageNumber+1}'>${pageNumber+1}</button>
          </#if>
          <#if (lastPageNumber-2) gte pageNumber>
            <button class="btn btn-dark" type="button"
                    value='${pageNumber+2}'>${pageNumber+2}</button>
            ...
          </#if>
      </div>
      <div class="col-sm-3">
        <button class="btn btn-dark" type="button"
                <#if (lastPageNumber-1) gte pageNumber> value="${pageNumber+1}" <#else>
          value="${lastPageNumber}" </#if>>
          &rightarrow;
        </button>
        <button class=" btn btn-dark" type="button"
                value="${lastPageNumber}">
          Last(${lastPageNumber})
        </button>
      </div>
    </div>
</div>
</div>
<script src="/js/admin.js"></script>
</body>
</html>
