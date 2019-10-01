<header class="card-header"><h4 class="title">Category</h4></header>
<div class="btn-group-vertical">
    <#list categoryList>
        <#items as category>
            <label class="btn btn-outline-light ">
                <input class="x-category" type="checkbox" name="myradio" value="${category.id}"
                       onclick="checkFilters()" ${categoryListChecked?seq_contains("${category.id}")?string("checked", "")}>
                <span class="form-check-label">${category.name}</span>
            </label>
        </#items>
    </#list>
</div>