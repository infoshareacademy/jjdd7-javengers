<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<#--<#list recipes>
    <#items as recipes>
            <p>${recipes.name}</p>

    </#items>
</#list>
<#list categories>
    <#items as categories>
        <p>${categories.name}</p>
    </#items>
</#list>-->
<#list categoryList>
    <#items as category>
        <label class="btn btn-outline-light btn-sm">
            <input class="x-category" type="checkbox" name="myradio" value="${category.id}"
                   onclick="checkFilters()" ${categoryListChecked?seq_contains("${category.id}")?string("checked", "")}>
            <span class="form-check-label">${category.name}</span>
        </label>
    </#items>
</#list>


</body>
</html>