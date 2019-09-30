<#list ingredientList>
    <#items as ingredient>
        <#if ingredientListChecked?seq_contains("${ingredient}")>
            <label class="btn btn-primary btn-sm form-group">
                <input class="x-ingredient" id="${ingredient}" type="checkbox" name="myradio" value="${ingredient}"
                       onclick="checkFilters()" checked>
                <span class="form-check-label">${ingredient}</span>
            </label>
        </#if>
    </#items>
</#list>

