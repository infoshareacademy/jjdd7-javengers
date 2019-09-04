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

$formIngredient.on('submit', () => {
    const $input = $("#input-ingredient");
    message = $input.val();
    if (message.length === 0) {
        return false;
    }
    const newTodo = makeTodoHtml(message);
    $todoList.prepend(newTodo);

    $input.val('');
    return false;
});

/**
 *  CHECKBOX HANDLING
 *  -------------------------------------------
 */

$(document).on('click', '#list-todo label', function (event) {
    const element = $(event.target).parents('.form-group');
    element.remove();
});

/**
 *  UTILITY FUNCTIONS
 *  ____________________________________________
 */

function makeTodoHtml(message) {
    return `
    <label class="btn btn-primary form-group">
     <input class="" type="checkbox" name="myradio" value="">
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

let selectedCategories = []
let asdasd= []

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
        drugiParam: ['s', 'sss']
    })

    fetch('http://localhost:63342/drinks?' + queryParams, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
}