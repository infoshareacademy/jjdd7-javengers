<div> ${authorization} </div>
<#if authorization=="unauthorizedAttempt">
  <div class="modal fade" id="unauthorizedAccess" tabindex="-1" role="dialog"
       aria-labelledby="unauthorizedAccess" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
          <h3>Unauthorized attempt!</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </div>
  </div>
</#if>