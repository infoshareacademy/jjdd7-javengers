<header class="card-header"><h6 class="title">Content</h6></header>

<div class="content-container">
    <ul class="list-group list-group-flush">
        <#list recipeListPerPage>
            <#items as recipe>
                <li><a href="#" class="list-group-item">${recipe.name}</a></li>
            </#items>
        </#list>
    </ul>  <!-- list-group .// -->
</div>
<div class="col paginator">
    <button class="favorite" type="button" value="1" >1</button>
    ...
    <button class="favorite" type="button" value='${pageNumber-1}'>${pageNumber-1}</button>
    <button class="favorite" type="button" value='${pageNumber}'><<${pageNumber}>></button>
    ...
    <button class="favorite" type="button" value='${lastPageNumber}'>${lastPageNumber}</button>
</div>$