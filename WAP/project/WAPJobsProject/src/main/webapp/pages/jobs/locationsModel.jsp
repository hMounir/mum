<%--
  Created by IntelliJ IDEA.
  User: Hisham
  Date: 3/18/2019
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="jobsModel" class="modal fade" tabindex="-1">
    <div class="modal-dialog modal-full">
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h6 class="modal-title">Locations</h6>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <div class="modal-body">
                <table class="table datatable-ajax">
                    <thead>
                    <tr>
                        <th>Street</th>
                        <th>City</th>
                        <th>State</th>
                    </tr>
                    </thead>
                </table>
            <!-- /basic datatable -->
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-link" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn bg-primary">Confirm</button>
            </div>
        </div>
    </div>
</div>
