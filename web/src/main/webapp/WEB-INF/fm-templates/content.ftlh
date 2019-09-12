<header class="card-header"><h6 class="title">Content</h6></header>

<div class="content-container">
        <#list recipeListPerPage>
            <#items as recipe>
                <div class="card sm-6">
                    <div class="row">
                        <div class="col-sm-4">
                            <img src="https://www.thecocktaildb.com/images/media/drink/qyqtpv1468876144.jpg" class="card-img" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Super Drink</h5>
                                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <li><a href="#" class="list-group-item">${recipe.name} bedzie category i czy cos jeszcze?? </a></li>
            </#items>
        </#list>
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