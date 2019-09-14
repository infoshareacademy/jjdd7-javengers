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

<#--

<#list ingredientListChecked>
    <#items as ingredient>
        &lt;#&ndash;<#if ingredientListChecked?seq_contains("${ingredient.name}")>&ndash;&gt;
            <label class="btn btn-primary btn-sm form-group">
                <input class="x-ingredient" id="${ingredient.name}" type="checkbox" name="myradio" value="${ingredient.name}"
                       onclick="checkFilters()" checked>
                <span class="form-check-label">${ingredient.name}</span>
            </label>
        &lt;#&ndash;</#if>&ndash;&gt;
    </#items>
</#list>-->
