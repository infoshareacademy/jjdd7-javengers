<#list ingredientList>
    <#items as ingredient>
        <#if ingredientListChecked?seq_contains("${ingredient.id}")>
            <label class="btn btn-primary btn-sm form-group">
                <input class="x-ingredient" id="${ingredient.name}" type="checkbox" name="myradio" value="${ingredient.id}"
                       onclick="checkFilters()" checked>
                <span class="form-check-label">${ingredient.name}</span>
            </label>
        </#if>
    </#items>
</#list>