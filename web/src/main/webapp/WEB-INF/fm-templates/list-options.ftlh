<header class="card-header"><h4 class="title">List Options</h4></header>
<div class="btn-group-vertical">
    <label class="btn btn-outline-light">
        <input class="x-list-options" type="radio" name="myradio" value="All Drinks"
               onclick="checkFilters()"
                <#if checkedListOption == "All Drinks">
                    checked
                </#if>
        >
        <span class="form-check-label">All Drinks </span>
    </label>
    <#if userType !="guest">
    <label class="btn btn-outline-light">
        <input class="x-list-options" type="radio" name="myradio" value="Favourites"
               onclick="checkFilters()"

                <#if checkedListOption == "Favourites">
                    checked
                </#if>
        >
        <span class="form-check-label">Favourites</span>
    </label>
    </#if>
</div>