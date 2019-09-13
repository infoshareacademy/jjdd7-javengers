<header class="card-header"><h4 class="title">List Options</h4></header>
<div class="btn-group-vertical">
    <label class="btn btn-outline-light">
        <input class="x-list-options" type="radio" name="myradio" value="All Drinks"
               onclick="checkFilters()" checked>
        <span class="form-check-label">All Drinks </span>
    </label>
    <label class="btn btn-outline-light">
        <input class="x-list-options" type="radio" name="myradio" value="Favourites"
               onclick="checkFilters()">
        <span class="form-check-label">Favourites</span>
    </label>
    <label class="btn btn-outline-light">
        <input class="x-list-options" type="radio" name="myradio" value="Most Popular"
               onclick="checkFilters()">
        <span class="form-check-label">Most Popular</span>
    </label>
</div>