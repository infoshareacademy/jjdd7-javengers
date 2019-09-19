<#if UserEmail??>
  <div class="g-signin2" data-onsuccess="onSignIn"></div>
<#else>
  <a href="#" onclick="signOut();">Sign out</a>
</#if>

<script>
  function onSignIn(googleUser) {
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/authentication');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function () {
      console.log('Signed in as: ' + xhr.responseText);
    };
    xhr.send("idToken=" + id_token);

  }

  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }
</script>