<div class="container-fluid">
  <ul class="nav">
    <li class="nav-item">
      <a class="nav-link active" href="#" onclick="window.location.href = '/home';">Main</a>
    </li>
      <#if email??>
        <li class="nav-item">
          <a class="nav-link " href="#" onclick="window.location.href = '/logout';">Log out</a>
        </li>
          <#if userType=="admin">
            <li class="nav-item">
              <a class="nav-link active" href="#" onclick="window.location.href = '/admin-view';">Admin
                Panel</a>
            </li>
          </#if>
      <#else>
        <li class="nav-item">
          <a class="nav-link " href="#" onclick="window.location.href = '/login';">Log in</a>
        </li>
      </#if>
  </ul>
</div>
