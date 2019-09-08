<header class="card-header"><h6 class="title">Category</h6></header>
<div class="btn-group-vertical">
    <#list categoryList>
        <#items as category>
            <label class="btn btn-outline-light btn-sm">
                <input class="x-category" type="checkbox" name="myradio" value="${category.id}"
                       onclick="checkFilters()" ${categoryListChecked?seq_contains("${category.id}")?string("checked", "")}>
                <span class="form-check-label">${category.name}</span>
            </label>

        </#items>
    </#list>

</div>