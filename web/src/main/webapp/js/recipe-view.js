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


$(".x-favourite").click(function () {
    const favToChangeId = this;
    /*if (favToChangeId.checked) {
        console.log(favToChangeId.value);
    }*/
    console.log(favToChangeId.value);

    const queryParams = $.param({
        favToChangeId: favToChangeId.value,
    });

    window.location = '/recipe-view?' + queryParams;

});
