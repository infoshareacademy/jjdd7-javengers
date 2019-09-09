<script>
    var ingredientList = [
        <#list ingredientList as ingredient>
        {id: '${ingredient.id}', name: '${ingredient.name}'}<#sep>, </#sep>
        </#list>
    ];
    
    $(document).ready(function () {
        $("#input-ingredient").autocomplete({
            source: [
                <#list ingredientList as ingredient>
                <#if ingredientListChecked?seq_contains("${ingredient.id}") == false>
                '${ingredient.name}'<#if ingredient_has_next>,</#if>
                </#if>
                </#list>
            ]
        });
    });

</script>