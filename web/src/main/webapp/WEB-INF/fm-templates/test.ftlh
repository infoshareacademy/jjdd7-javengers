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
<#list checkedIngredients>
    <#items as checkedIngredients>
        <p>${checkedIngredients}</p>
    </#items>
</#list>


</body>
</html>