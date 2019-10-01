const $formName = $('#form-name');

let listOfNames = [];

$(function () {
    $(document).ready(function () {
        console.log("test")
        $('#isOfAge').modal('show');
    })
});

$("#yes").click(function () {
    const d = new Date();
    d.setTime(d.getTime() + (24 * 60 * 60 * 1000));
    const expires = "expires=" + d.toUTCString();
    document.cookie = "isAdult=true" + ";" + expires + ";path=/";
    console.log("yes")
    location.reload()
});

$("#no").click(function () {
    const d = new Date();
    d.setTime(d.getTime() + (1000));
    const expires = "expires=" + d.toUTCString();
    document.cookie = "isAdult=false" + ";" + expires + ";path=/";
    console.log("no")
    window.location = document.referrer
});

$formName.on('submit', () => {
    const $input = $("#input-name");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    if (listOfNames.some(recipe => recipe.name === $input.val())) {
        let recipeIDs = listOfNames.filter(recipe => recipe.name === $input.val());
        window.location = '/recipe-view?recipeId=' + recipeIDs[0].id;
    }
    $input.val('');
    return false;
});

$('#input-name').keyup(function () {
    if (this.value.length < 3) return;
    var substring = $(this).val();
    $.ajax({
        url: '/api/recipes/nameChars/' + substring,
        type: 'GET',
        success: function (data) {
            console.log(data);
            listOfNames = data;
            let result = data.map(r => r.name);
            $("#input-name").autocomplete({
                source: result,
            });
        }

    });
});

$("#fav").click(function () {

    if ($(this).attr("src") == "https://img.icons8.com/metro/80/000000/like.png") {
        $(this).attr("src", "https://img.icons8.com/metro/80/000000/hearts.png");
        $("#fav-description").attr('title', "remove from favourites")
    } else {
        $(this).attr("src", "https://img.icons8.com/metro/80/000000/like.png");
        $("#fav-description").attr('title', "add to favourites")
    }

    var favToBeChangedId = $('.x-favourite').val();
    console.log(favToBeChangedId);

    $.ajax({
        url: '/api/favourites/' + favToBeChangedId,
        type: 'GET',
        success: function () {
            console.log("favourites changed");
        }

    })
});

$("#del-description").click(function () {
    var favToBeChangedId = $('.x-delete').val();
    console.log(favToBeChangedId);

    $.ajax({
        url: '/api/superHero/recipes/deleteRecipe/' + favToBeChangedId,
        type: 'DELETE',
        success: function () {
            window.location = document.referrer;
        }
    })
});