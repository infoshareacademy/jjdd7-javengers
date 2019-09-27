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


var wasClicked = false;


    $("#fav").click(function () {
        if (!wasClicked) 
            wasClicked = true;
            /*return;*/
        }
        if ($(this).attr("src") == "https://img.icons8.com/metro/80/000000/like.png") {
            $(this).attr("src", "https://img.icons8.com/metro/80/000000/hearts.png");
            $("#fav-input").attr("title", "dupa cyce")
        } else {
            $(this).attr("src", "https://img.icons8.com/metro/80/000000/like.png");
            $("#fav-input").attr("title", " dupa dupa")
        }
    });

    /*var favToBeChangedId =
    $.ajax({
        url: '/api/favourites/idToBeChanged/' + favToBeChangedId,
        type: 'GET',
        success: function () {
            Console.out("dsffg");
        }


*/


    /*

    let image_tracker = document.getElementById('fav');
    image_tracker.param(')

    $('.x-favourite').onclick(function () {
        var favToBeChangedId = $(this).param("value");
        Console.out(favToBeChangedId);

        var image = document.getElementById(('fav'));
        if (image_tracker === 'https://img.icons8.com/dotty/80/000000/hearts.png') {
            image.src = 'https://img.icons8.com/dotty/80/000000/like.png';
            image_tracker = 'https://img.icons8.com/dotty/80/000000/like.png';
        } else {
            image.src = 'https://img.icons8.com/dotty/80/000000/hearts.png';
            image_tracker = 'https://img.icons8.com/dotty/80/000000/hearts.png';
        }
    */

    /*
        //wyslij request
        $.ajax({
            url: '/api/favourites/idToBeChanged/' + favToBeChangedId,
            type: 'GET',
            success: function () {
                Console.out("dsffg");
            }

        });*/
