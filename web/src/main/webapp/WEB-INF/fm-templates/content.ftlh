<header class="card-header"><h6 class="title">Content</h6></header>

<div class="content-container">
    <ul class="list-group list-group-flush">
        <#list recipeListPerPage>
            <#items as recipe>
                <li><a href="#" class="list-group-item">${recipe.name} bedzie category i czy cos jeszcze?? </a></li>
            </#items>
        </#list>
    </ul>
</div>
<div class="row paginator">
    <div class="col-sm-3 paginator">
        <button class="favorite btn btn-primary btn-sm" type="button" value="1" >First(1)</button>
        <button class="favorite btn btn-primary btn-sm" type="button" value="1" >&leftarrow;</button>
    </div>
    <div class="col-sm-6 paginator">
    <#--<#if pageNumber gt 1>
    <button class="favorite btn btn-primary btn-sm" type="button" value="1" >First(1)</button>
    </#if>-->
    <#if pageNumber gt 3>
        ...
        <button class="favorite btn btn-primary btn-sm" type="button" value='${pageNumber-2}'>${pageNumber-2}</button>
    </#if>
    <#if pageNumber gt 2>
        <button class="favorite btn btn-primary btn-sm" type="button" value='${pageNumber-1}'>${pageNumber-1}</button>
    </#if>
    <button class="favorite btn btn-light btn-sm" type="button" value='${pageNumber}'><strong>${pageNumber}</strong></button>
    <#if  (lastPageNumber-2) gt pageNumber>
        <button class="favorite btn btn-primary btn-sm" type="button" value='${pageNumber+1}'>${pageNumber+1}</button>
    </#if>
    <#if (lastPageNumber-3) gt pageNumber>
        <button class="favorite btn btn-primary btn-sm" type="button" value='${pageNumber+2}'>${pageNumber+2}</button>
        ...
    </#if>
   <#-- <#if (lastPageNumber-1) gte pageNumber>
    <button class="favorite btn btn-primary btn-sm" type="button" value='${lastPageNumber}'>Last(${lastPageNumber})</button>
    </#if>-->
    </div>
    <div class="col-sm-3 paginator">
        <button class="favorite btn btn-primary btn-sm" type="button" value="1" >&rightarrow;</button>
        <button class="favorite btn btn-primary btn-sm" type="button" value="1" >Last(${lastPageNumber})</button>
    </div>

</div>