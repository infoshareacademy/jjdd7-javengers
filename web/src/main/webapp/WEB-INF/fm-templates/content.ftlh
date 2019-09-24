<#list recipeListPerPage>
    <#items as recipe>


        <div class="row" Style="border: ghostwhite solid; border-radius: .5rem; margin-bottom: 5px;">
            <div class="col-sm-10" style="padding: 0px">
                <#--podmienic link na ftlh -->
                <a href="/recipe-view?recipeId=${recipe.id?c}" class="list-group-item recipe-link">
                    <div class="col-sm-3" style="padding: 0px">
                        <#if recipe.imageUrl??>
                            <img src="${recipe.imageUrl}"
                        <#else>  <img src="http://placekitten.com/500/500"
                        </#if>
                        <img src="${recipe.imageUrl}"
                             style="max-width: 90%;" class="card-img" alt="...">
                    </div>
                    <div class="col-sm-9" style="padding: 0px; padding-top:4% ">
                        <div class="card-body" style="padding: 0px">
                            <h4 class="card-title">${recipe.name}</h4>
                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-2" style="padding:0; padding-top: 7%">
                <label class="btn btn-primary btn-sm" title="add to favourites">
                    <input class="x-favourite" type="checkbox" value="gowno" >
                    <span class="form-check-label" style="padding-left: 2px"><img
                                src="https://img.icons8.com/metro/26/000000/like.png"></span>
                </label>
            </div>
        </div>

    </#items>
</#list>

<div class="row paginator">
    <div class="col-sm-3 paginator">
        <button class="favorite btn btn-primary btn-sm" type="button" value="1">First(1)</button>
        <button class="favorite btn btn-primary btn-sm" type="button"
                <#if pageNumber gt 1> value="${pageNumber-1}" <#else> value="1" </#if>> &leftarrow;
        </button>
    </div>
    <div class="col-sm-6 paginator">
        <#if pageNumber gte 3>
            ...
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber-2}'>${pageNumber-2}</button>
        </#if>
        <#if pageNumber gte 2>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber-1}'>${pageNumber-1}</button>
        </#if>
        <button class="favorite btn btn-light btn-sm" type="button" value='${pageNumber}'><strong>${pageNumber}</strong>
        </button>
        <#if  (lastPageNumber-1) gte pageNumber>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber+1}'>${pageNumber+1}</button>
        </#if>
        <#if (lastPageNumber-2) gte pageNumber>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber+2}'>${pageNumber+2}</button>
            ...
        </#if>
    </div>
    <div class="col-sm-3 paginator">
        <button class="favorite btn btn-primary btn-sm" type="button"
                <#if (lastPageNumber-1) gte pageNumber> value="${pageNumber+1}" <#else> value="${lastPageNumber}" </#if>>
            &rightarrow;
        </button>
        <button class="favorite btn btn-primary btn-sm" type="button" value="${lastPageNumber}">Last(${lastPageNumber})
        </button>
    </div>
</div>