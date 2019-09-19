
<header class="card-header"><h4 class="title">Type</h4></header>
<div class="btn-group-vertical">
    <label class="btn btn-outline-light ">
        <input class="x-type" type="checkbox" name="myradio" value="Alcoholic"
               onclick="checkFilters()" ${typeListChecked?seq_contains("Alcoholic")?string("checked", "")}>
        <span class="form-check-label">Alcoholic</span>
    </label>
    <label class="btn btn-outline-light ">
        <input class="x-type" type="checkbox" name="myradio" value="non-Alcoholic"
               onclick="checkFilters()" ${typeListChecked?seq_contains("non-Alcoholic")?string("checked", "")}>
        <span class="form-check-label">non-Alcoholic</span>
    </label>
    <label class="btn btn-outline-light">
        <input class="x-type" type="checkbox" name="myradio" value="Optional"
               onclick="checkFilters()" ${typeListChecked?seq_contains("Optional")?string("checked", "")}>
        <span class="form-check-label">Optional</span>
    </label>
</div>