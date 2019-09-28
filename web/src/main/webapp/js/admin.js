$(function () {
  $(document).ready(function () {

    $(".give").click(function () {

      $.ajax({
        url: '/api/superHero/addAdminPermissions/' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function () {
          location.reload();
        }
      });
    });

  });
});

$(function () {
  $(document).ready(function () {

    $(".revoke").click(function () {

      $.ajax({
        url: '/api/superHero/revokeAdminPermissions/'+ $(this).attr('data-id'),
        type: 'PATCH',
        success: function () {
          location.reload();
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {

    $(".delete").click(function () {
      $.ajax({
        url: '/api/superHero/users/deleteUser/' + $(this).attr('data-id'),
        type: 'DELETE',
        success: function () {
          location.reload();
        }
      });
    });
  });
});
