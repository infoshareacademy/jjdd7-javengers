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


$('#sub').on('submit', function () {
    console.log("test")
    $('#success').modal('show');
    alert("your recipe has been sent to the admin for authorization");
})



