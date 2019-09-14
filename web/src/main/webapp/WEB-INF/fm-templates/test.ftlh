<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<#list recipes>
    <#items as recipes>
            <p> ${recipes.name}</p>

    </#items>
</#list>
<#list categories>All categories
    <#items as categories>
        <p>${categories.name}</p>
    </#items>
</#list>
All checked recipies and ingredients
<#list checkedCategoriesAndIngredients>
    <#items as checkedCategoriesAndIngredients>
        <p>${checkedCategoriesAndIngredients}</p>
    </#items>
</#list>
</body>
</html>