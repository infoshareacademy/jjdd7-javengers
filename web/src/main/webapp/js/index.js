
const $formName = $('#form-name');
const $formIngredient = $('#form-ingredient');
const $ingredientListButtons = $('#list-ingredient');
let selectedCategories = [];
let selectedListOptions = [];
let selectedIngredients = [];

let listOfNames =[];


$formName.on('submit', () => {
    const $input = $("#input-name");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    if(listOfNames.some(recipe=>recipe.name===$input.val())){
        let recipeIDs = listOfNames.filter(recipe=>recipe.name===$input.val());
        window.location = 'http://localhost:8080/recipe-view?recipeId=' + recipeIDs[0].id;
    }
    $input.val('');
    return false;
});


$('#input-name').keyup(function () {
    if( this.value.length < 3 ) return;
    var substring = $(this).val();
    //wyslij request
    $.ajax({
        url: '/api/recipes/nameChars/' + substring,
        type: 'GET',
        success: function(data) {
            console.log(data);
            // MOCKED SERVER
            //var nameList= ['mojito', 'Huricane', 'Sex on the beach', 'Mai Tai', 'Cuba Libre', 'caipirinha', 'caipiroshca'];
            listOfNames = data;
            let result = data.map(r => r.name);
            $("#input-name").autocomplete( {
                source: result,
                minLength: 3
            });
        }

    });
});


$formIngredient.on('submit', () => {
    const $input = $("#input-ingredient");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }

    if (ingredientList.some(ingredient => ingredient.toLowerCase() === message.toLowerCase())) {

        let messageIngredient = ingredientList.filter(ingredient => ingredient.toLowerCase() === message.toLowerCase())
        listSelectedIngredients();
        if (selectedIngredients.some(ingredient => ingredient === messageIngredient)) {
            console.log("already existing")
        } else {
            const newIngredient = makeIngredientListHtml(messageIngredient);
            $ingredientListButtons.prepend(newIngredient);
        }
    }
    checkFilters();
    $input.val('');
    return false;
});


$(document).on('click', '#list-ingredient label', function (event) {
    const element = $(event.target).parents('.form-group');
    element.remove();
});


function makeIngredientListHtml(message) {
    /*tutaj value jest do zmiany na nr id z listy dostepnych drinkow*/
    return `
    <label class="btn btn-primary btn-sm form-group">
     <input class="x-ingredient" id="${message}" type="checkbox" name="myradio" value="${message}" onclick="checkFilters()" checked>
     <span class="form-check-label">${message}</span>
    </label>   
`
}



function checkFilters() {

    listSelectedCategories();
    listSelectedOptions();
    listSelectedIngredients();

    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients
    });

    /*do JSowych rozwiazan*/

    /*fetch('http://localhost:8080/home?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })*/

   /* do przeladowania strony*/
    window.location = 'http://localhost:8080/home?' + queryParams;
}

function listSelectedCategories() {
    const categories = $('.x-category');
    if (categories && categories.length) {
        selectedCategories = [];
        categories.each(function (i) {
            const input = this;
            if (input.checked) {
                selectedCategories.push(input.value)
            }
        })
    }
}

function listSelectedIngredients() {
    const ingredients = $('.x-ingredient');
    if (ingredients && ingredients.length) {
        selectedIngredients = [];
        ingredients.each(function (i) {
            const input = this;
            if (input.checked) {
                selectedIngredients.push(input.value)
            }
        })
    }
}

function listSelectedOptions() {
    const listOptions = $('.x-list-options');
    if (listOptions && listOptions.length) {
        selectedListOptions = [];
        listOptions.each(function (i) {
            const input = this;
            if (input.checked) {
                selectedListOptions.push(input.value)
            }
        })
    }
}




$(".favorite").click(function() {
    var fired_button = $(this).val();
    console.log(fired_button);

    listSelectedCategories();
    listSelectedOptions();
    listSelectedIngredients();

    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients,
        page: fired_button
    });

    /*do JSowych rozwiazan*/

   /* fetch('http://localhost:8080/home?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })*/

    window.location = 'http://localhost:8080/home?' + queryParams;
});