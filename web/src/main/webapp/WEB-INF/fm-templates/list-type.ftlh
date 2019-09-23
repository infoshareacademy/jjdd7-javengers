<header class="card-header"><h4 class="title">Type</h4></header>
<div class="btn-group-vertical">
    <#list typeList>
        <#items as type>
            <label class="btn btn-outline-light ">
                <input class="x-type" type="checkbox" name="myradio" value="${type}"
                       onclick="checkFilters()" ${typeListChecked?seq_contains("${type}")?string("checked", "")}>
                <span class="form-check-label">${type}</span>
            </label>
        </#items>
    </#list>

</div>

