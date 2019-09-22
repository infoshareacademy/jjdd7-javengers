<#if email??>
  <li class="nav-item">
    <a class="nav-link active" href="#" onclick="window.location.href = '/user';">Main</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="#" onclick="window.location.href = '/logout';" >Log out</a>
  </li>

<#else>
  <li class="nav-item">
    <a class="nav-link active" href="#" onclick="window.location.href = '/home';">Main</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="#"  onclick="window.location.href = '/login';" >Log in</a>
  </li>
</#if>

