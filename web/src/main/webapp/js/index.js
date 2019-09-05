/**
 *  HTML ELEMENTS
 *  ____________________________________________
 */
const $formName = $('#form-name');
const $formIngredient = $('#form-ingredient');
const $input = $('#input-new-todo');
const $todoList = $('#list-todo');

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
    const newTodo = makeTodoHtml(message);
    $todoList.prepend(newTodo);

    radiobtn = document.getElementById(message);
    radiobtn.checked = true;
    selectIngredient();

    $input.val('');
    return false;
});


$(document).on('click', '#list-todo label', function (event) {
    const element = $(event.target).parents('.form-group');
    element.remove();
});


function makeTodoHtml(message) {
    return `
    <label class="btn btn-primary btn-sm form-group">
     <input class="x-ingredient" id="${message}" type="checkbox" name="myradio" value="${message}" onclick="selectIngredient()">
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


/**
 *  MANAGING SENDING DATA TO SERVLET
 *  ____________________________________________
 */

let selectedCategories = []
let selectedListOptions = []
let selectedIngredients = []

function selectCategory () {
    const categories = $('.x-category')
    if (categories && categories.length) {
        selectedCategories = []
        categories.each(function(i) {
            const input = this
            if (input.checked) {
                selectedCategories.push(input.value)
            }
        })
    }
    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients

    })

    fetch('http://localhost:8080/drinks?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    /*window.location = 'http://localhost:8080/drinks?' + queryParams;*/

}


function selectListOption () {
    const listOptions = $('.x-list-options')
    if (listOptions && listOptions.length) {
        selectedListOptions = []
        listOptions.each(function(i) {
            const input = this
            if (input.checked) {
                selectedListOptions.push(input.value)
            }
        })
    }
    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients
    })

    fetch('http://localhost:8080/drinks?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
    /*window.location = 'http://localhost:8080/drinks?' + queryParams;*/


}

function selectIngredient () {
    const ingredients = $('.x-ingredient')
    if (ingredients && ingredients.length) {
        selectedIngredients = []
        ingredients.each(function(i) {
            const input = this
            if (input.checked) {
                selectedIngredients.push(input.value)
            }
        })
    }
    const queryParams = $.param({
        categories: selectedCategories,
        listOptions: selectedListOptions,
        ingredients: selectedIngredients

    })

    fetch('http://localhost:8080/drinks?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })

    /*window.location = 'http://localhost:8080/drinks?' + queryParams;*/

}