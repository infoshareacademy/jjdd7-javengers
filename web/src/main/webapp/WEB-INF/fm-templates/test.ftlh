<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<p>Page No:${pageNumber}</p>
<p>Last page No:${lastPageNumber}</p>
All checked recipies and ingredients
<#list checkedCategoriesAndIngredients>
    <#items as checkedCategoriesAndIngredients>
        <p>${checkedCategoriesAndIngredients}</p>
    </#items>
</#list>
</body>
</html>