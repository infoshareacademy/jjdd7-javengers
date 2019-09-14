<header class="card-header"><h4 class="title">Content</h4></header>


    <#list recipeListPerPage>
        <#items as recipe>

            <div class="row" Style="border: white solid; border-radius: .5rem; margin-bottom: 5px;" >
                <div class="col-sm-8" style="padding: 0px">
                    <a href="/singleview.html" class="list-group-item recipe-link" >
                        <div class="col-sm-3" style="padding: 0px">
                            <img src="https://www.thecocktaildb.com/images/media/drink/qyqtpv1468876144.jpg"
                                 style="max-width: 100%;" class="card-img" alt="...">
                        </div>
                        <div class="col-sm-9" style="padding: 0px; padding-top:4% ">
                            <div class="card-body" style="padding: 0px">
                                <br/>
                                <h4 class="card-title">Sex on the beach</h4>
                                <br/>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-4" style="padding: 0px; padding-top: 7%">
                    <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>FAVS
                    </button>
                    <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>EDIT</button>
                    <button class="favorite btn btn-primary btn-sm" type="button" value='edit'>DEL</button>
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
        <#if pageNumber gt 3>
            ...
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber-2}'>${pageNumber-2}</button>
        </#if>
        <#if pageNumber gt 2>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber-1}'>${pageNumber-1}</button>
        </#if>
        <button class="favorite btn btn-light btn-sm" type="button" value='${pageNumber}'><strong>${pageNumber}</strong>
        </button>
        <#if  (lastPageNumber-2) gt pageNumber>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber+1}'>${pageNumber+1}</button>
        </#if>
        <#if (lastPageNumber-3) gt pageNumber>
            <button class="favorite btn btn-primary btn-sm" type="button"
                    value='${pageNumber+2}'>${pageNumber+2}</button>
            ...
        </#if>
    </div>
    <div class="col-sm-3 paginator">
        <button class="favorite btn btn-primary btn-sm" type="button"
                <#if (lastPageNumber-1) gte pageNumber> value="${pageNumber+1}" <#else> value="${lastPageNumber}" </#if>> &rightarrow;
        </button>
        <button class="favorite btn btn-primary btn-sm" type="button" value="${lastPageNumber}">Last(${lastPageNumber})
        </button>
    </div>
</div>