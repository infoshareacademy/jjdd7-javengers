<script>

    let ingredientList = [
        <#list ingredientList as ingredient>
        <#if ingredientListChecked?seq_contains("${ingredient}") == false>
        '${ingredient}'<#if ingredient_has_next>,</#if>
        </#if>
        </#list>
    ];
    
    $(document).ready(function () {
        $("#input-ingredient").autocomplete( {

            source: ingredientList,
            minLength: 3
        });
    });

</script>