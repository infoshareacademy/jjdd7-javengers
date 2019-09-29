const $formName = $('#form-name');
const $formIngredient = $('#form-ingredient');
const $ingredientListButtons = $('#list-ingredient');
let selectedCategories = [];
let selectedListOptions = [];
let selectedIngredients = [];
let selectedTypes = [];

let listOfNames = [];
let ingredientList = [];
let paramActive;

$(function () {
    $(document).ready(function () {
        console.log("test")
        $('#unauthorizedAccess').modal('show');
    })
});

$(document).ready(function(){
    var next = 1;
    $(".add-more").click(function(e){
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;
        var newIn =

            '<div id="field' + next + '" style="margin: auto">' +
            '<input autocomplete="off" class="input" id="ingredient' + next + '" name="ingredient" type="text" placeholder="input ingredient" data-items="8" required maxlength="30"/> ' +
            '<input autocomplete="off" class="input" id="measure' + next + '" name="measure" type="text" placeholder="input measure" data-items="8" required maxlength="30"/> ' +
            '</div>';

            /*'<input autocomplete="off" class="input form-control" id="field' + next + '" name="field' + next + '" type="text">';*/
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-primary btn-sm remove-me" >-</button></div>';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#field" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);

        $('.remove-me').click(function(e){
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length-1);
            var fieldID = "#field" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        });
    });



});



$formIngredient.on('submit', () => {
    console.log("wlazlo")
    const $input = $("#input-ingredient");
    message = $input.val();

    if (message.length === 0) {
        return false;
    }

    /*if (ingredientList.some(ingredient => ingredient.toLowerCase() === message.toLowerCase())) {

        let messageIngredient = ingredientList.filter(ingredient => ingredient.toLowerCase() === message.toLowerCase())
        listSelectedIngredients();
        if (selectedIngredients.some(ingredient => ingredient === messageIngredient)) {
            console.log("already existing")
        } else {
            const newIngredient = makeIngredientListHtml(messageIngredient);
            $ingredientListButtons.prepend(newIngredient);
        }
    }*/
    const newIngredient = makeIngredientListHtml(messageIngredient);
    $ingredientListButtons.prepend(newIngredient);
    $input.val('');
    return false;
});

/*$('#input-ingredient').keyup(function () {
    if (this.value.length < 3) return;
    var substring = $(this).val();
    //wyslij request
    $.ajax({
        url: '/api/ingredients/nameChars/' + substring,
        type: 'GET',
        success: function (dataIngredient) {
            console.log(dataIngredient);
            ingredientList = dataIngredient.map(r => r.name);
            let result = dataIngredient.map(r => r.name);
            $("#input-ingredient").autocomplete({
                source: result,
                /!*minLength: 3*!/
            });
        }

    });
});*/

$(document).on('click', '#list-ingredient label', function (event) {
    const element = $(event.target).parents('.form-group');
    element.remove();
});


function makeIngredientListHtml(message) {
    /*tutaj value jest do zmiany na nr id z listy dostepnych drinkow*/
    return `
    <label class="btn btn-primary btn-sm form-group">
     <input class="x-ingredient" id="${message}" type="checkbox" name="ingredient" value="${message}" checked>
     <span class="form-check-label">${message}</span>
    </label>   
`
}

/*

function checkFilters() {

    listSelectedCategories();
    listSelectedOptions();
    listSelectedIngredients();
    listSelectedTypes();
    whatIsActive();

    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients,
        types: selectedTypes,
        active: paramActive
    });

    /!*do JSowych rozwiazan*!/

    /!*fetch('http://localhost:8080/home?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })*!/

    /!* do przeladowania strony*!/
    window.location = '/home?' + queryParams;
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

function listSelectedTypes() {
    const types = $('.x-type');
    if (types && types.length) {
        selectedTypes = [];
        types.each(function (i) {
            const input = this;
            if (input.checked) {
                selectedTypes.push(input.value)
            }
        })
    }
}

function whatIsActive() {
    if ($('#name-tab').hasClass('active')) {
        paramActive = 'name'
    } else {
        paramActive = 'ingredient'

    }
}


$(".favorite").click(function () {
    var fired_button = $(this).val();
    console.log(fired_button);

    listSelectedCategories();
    listSelectedOptions();
    listSelectedIngredients();
    listSelectedTypes();
    whatIsActive();

    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients,
        types: selectedTypes,
        page: fired_button,
        active: paramActive
    });

    window.location = '/home?' + queryParams;
});

$(".edition").click(function () {
    var edit_button = $(this).val();
    console.log(edit_button);

    listSelectedCategories();
    listSelectedOptions();
    listSelectedIngredients();
    listSelectedTypes();
    whatIsActive();

    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients,
        types: selectedTypes,
        edition: edit_button,
        active: paramActive
    });
    window.location = '/home?' + queryParams;
});
*/


