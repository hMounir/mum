<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Primary modal -->
<script type="text/javascript" src="<c:url value="/resources/js/jobs/apply_job.js"/>"></script>
<div id="applyJob" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h6 class="modal-title">Apply Job</h6>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <div class="modal-body">
                <h6 class="font-weight-semibold">Do you want to apply for this job ?</h6>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-link" data-dismiss="modal">No</button>
                <button type="button" class="btn bg-primary">Yes</button>
            </div>
        </div>
    </div>
</div>
<!-- /primary modal -->
