<script>

    
    $(document).ready(function () {
        $("#input-ingredient").autocomplete( {

            source: [
                <#list ingredientList as ingredient>
                <#if ingredientListChecked?seq_contains("${ingredient}") == false>
                '${ingredient}'<#if ingredient_has_next>,</#if>
                </#if>
                </#list>
            ],
            minLength: 3
        });
    });

</script>