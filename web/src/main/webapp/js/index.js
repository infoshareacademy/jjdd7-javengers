
const $formName = $('#form-name');
const $formIngredient = $('#form-ingredient');
const $ingredientListButtons = $('#list-ingredient');
let selectedCategories = [];
let selectedListOptions = [];
let selectedIngredients = [];


$formName.on('submit', () => {
    const $input = $("#input-name");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    $input.val('');
    return false;
});

$formIngredient.on('submit', () => {
    const $input = $("#input-ingredient");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }

    if (ingredientList.some(ingredient => ingredient.name.toLowerCase() === message.toLowerCase())) {

        let messageIngredient = ingredientList.filter(ingredient => ingredient.name.toLowerCase() === message.toLowerCase())
        listSelectedIngredients();
        if (selectedIngredients.some(ingredient => ingredient === messageIngredient[0].id)) {
            console.log("already existing")
        } else {
            const newIngredient = makeIngredientListHtml(messageIngredient[0]);
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
     <input class="x-ingredient" id="${message.name}" type="checkbox" name="myradio" value="${message.id}" onclick="checkFilters()" checked>
     <span class="form-check-label">${message.name}</span>
    </label>   
`
}


/* Skrypt do obslugi 2 zmieniajacych sie divow na stronie
<script>
$(document).on('click', '#navTab a', function () {
    otherTabs = $(this).attr('data-secondary').split(',');
    for (i = 0; i < otherTabs.length; i++) {
        nav = $('<ul class="nav d-none" id="tmpNav"></ul>');
        nav.append('<li class="nav-item"><a href="#" data-toggle="tab" data-target="' + otherTabs[i] + '">nav</a></li>"');
        nav.find('a').tab('show');
    }
});
</script>*/

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

    fetch('http://localhost:8080/drink?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })

    /*do przeladowania strony*/
    /*window.location = 'http://localhost:8080/drinks?' + queryParams;*/
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


function goToPage() {
    var page = this.value();
    console.log(page);
    /*checkFilters();*/
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

    fetch('http://localhost:8080/drink?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
});