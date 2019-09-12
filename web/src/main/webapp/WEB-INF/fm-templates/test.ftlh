<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<#list recipes>
    <#items as recipes>
            <p>${recipes.name}</p>

    </#items>
</#list>
<p>${categories[1].name}</p>
</body>
</html>