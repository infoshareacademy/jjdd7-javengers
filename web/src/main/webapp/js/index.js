
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


$('#input-name').keyup(function () {
    if( this.value.length < 3 ) return;
    var substring = $(this).val();
    //wyslij request
    $.ajax({
        url: '/drinks?nameChars=' + substring,
        type: 'GET',
        success: function(data) {

            // MOCKED SERVER
            var nameList= ['mojito', 'Huricane', 'Sex on the beach', 'Mai Tai', 'Cuba Libre', 'caipirinha', 'caipiroshca'];

                $("#input-name").autocomplete( {
                        source: nameList,
                minLength: 3
            });

            /*let filteredData = nameList.filter(ingredient => ingredient.toLowerCase().includes(substring.toLowerCase()));
            // HANDLING RETURN

            console.log("parametr  nameChars sent: " + substring, data);
            /*nameList = response;*/
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