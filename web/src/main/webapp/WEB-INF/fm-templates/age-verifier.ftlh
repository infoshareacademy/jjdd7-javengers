<#if recipeType != "non alcoholic" && isAdult == "false" >
  <div class="modal fade" id="isOfAge" tabindex="-1" role="dialog"
       aria-labelledby="isOfAge" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Age verifier</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <h1> Are you over 18 years old? </h1>
        </div>
        <div class="modal-footer">
          <button type="button" id="yes" class="btn btn-success" >Yes</button>
          <button type="button" id="no" class="btn btn-danger" >No</button>
        </div>
      </div>
    </div>
  </div>
</#if>

