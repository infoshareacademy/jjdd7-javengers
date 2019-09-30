const $formName = $('#form-name');

let listOfNames = [];


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
    //wyslij request
    $.ajax({
        url: '/api/recipes/nameChars/' + substring,
        type: 'GET',
        success: function (data) {
            console.log(data);
            listOfNames = data;
            let result = data.map(r => r.name);
            $("#input-name").autocomplete({
                source: result,
                /*minLength: 3*/
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