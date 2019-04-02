<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">
        <!-- Content area -->
        <div class="content">
            <!-- Collapsible options -->
            <div class="mb-3">
                <h6 class="mb-0 font-weight-semibold">
                    Dashboard links
                </h6>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <div class="card card-body border-top-1 border-top-pink">
                        <div class="text-center">
                            <h6 class="font-weight-semibold mb-0">Jobs Page</h6>
                            <p class="mb-3 text-muted">Search for jobs</p>
                            <a class="btn btn-primary legitRipple collapsed" data-toggle="collapse" href="#collapse-link-collapsed" aria-expanded="false">
                                Details
                            </a>
                        </div>
                        <div class="collapse" id="collapse-link-collapsed" style="">
                            <div class="mt-3">
                                Here, you can apply for new daily jobs and and filter using location, skills
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /content area -->
    </layout:put>
</layout:extends>