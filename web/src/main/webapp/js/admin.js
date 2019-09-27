$(function () {
  $(document).ready(function () {

    $(".give").click(function () {

      $.ajax({
        url: '/api/superHero/addAdminPermissions' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function (result) {
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
        url: '/api/superHero/revokeAdminPermissions' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function (result) {
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
        url: '/api/superHero/deleteUser' + $(this).attr('data-id'),
        type: 'DELETE',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});
