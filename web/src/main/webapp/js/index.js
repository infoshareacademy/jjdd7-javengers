/**
 *  HTML ELEMENTS
 *  ____________________________________________
 */
const $formName = $('#form-name');
const $formIngredient = $('#form-ingredient');
const $ingredientList = $('#list-ingredient');

/**
 *  FORM SUBMISSIONS
 *  ____________________________________________
 */

$formName.on('submit', () => {
    const $input = $("#input-name");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    $input.val('');
    return false;
});

//filter names
/*const searchBar = document.forms['form-name'].querySelector('input');
searchBar.addEventListener('keyup',function(e)
{

    const term = e.target.value.toLowerCase();
    const drinks = list.getElementsByTagName("li");
    Array.from(drinks).forEach(function (drink) {
        const name = drink.firstElementChild.textContent;
        if (name.toLowerCase().indexOf(term) != -1) {
            drink.style.display = 'block';
        }
    })
else
    {
        drink.style.display = 'none';
    }
}
);*/

/**
 *  INGRIDIENTS FORM AND MANAGING INGREDIENT BUTTONS
 *  ____________________________________________
 */

$formIngredient.on('submit', () => {
    const $input = $("#input-ingredient");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    const newIngredient = makeIngredientListHtml(message);
    $ingredientList.prepend(newIngredient);

    radiobtn = document.getElementById(message);
    radiobtn.checked = true;
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
    if (ingredientList.filter(ingredient => ingredient.name.match(message))) {
        console.log("mamy to")
        return `
    <label class="btn btn-primary btn-sm form-group">
     <input class="x-ingredient" id="${message}" type="checkbox" name="myradio" value="${message}" onclick="selectIngredient()">
     <span class="form-check-label">${message}</span>
    </label>   
`
    } else {
        console.log("nie mamy")
    }
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


/**
 *  MANAGING SENDING DATA TO SERVLET
 *  ____________________________________________
 */

let selectedCategories = [];
let selectedListOptions = [];
let selectedIngredients = [];

function checkFilters() {
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
    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients

    });

    /*do JSowych rozwiazan

    fetch('http://localhost:8080/drink?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })*/
    window.location = 'http://localhost:8080/drinks?' + queryParams;
}

$('#input-ingredient').keyup(function () {
    var substring = $(this).val();
    let filteredData = ingredientList.filter(ingredient => ingredient.name.toLowerCase().includes(substring.toLowerCase()));
    console.log(filteredData);

});


/* select odpimpiony
$(document).ready(function() {
    $('.js-example-basic-single').select2();
});*/
