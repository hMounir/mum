<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/jobs/job_list.js"/>"></script>
            <!-- Page header -->
            <div class="page-header page-header-light">
                <div class="page-header-content header-elements-md-inline">
                    <div class="page-title d-flex">
                        <h4><i class="icon-arrow-left52 mr-2"></i> <span class="font-weight-semibold">Jobs Search</span></h4>
                        <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                    </div>
                </div>

                <div class="breadcrumb-line breadcrumb-line-light header-elements-md-inline">
                    <div class="d-flex">
                        <div class="breadcrumb">
                            <a href="../../index.jsp" class="breadcrumb-item"><i class="icon-home2 mr-2"></i> Home</a>
                            <a href="jobs" class="breadcrumb-item">Job search</a>
                        </div>

                        <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                    </div>
                </div>
            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">
                <jsp:include page="locationsModel.jsp"/>
                <!-- Inner container -->
                <div class="d-md-flex align-items-md-start">
                    <!-- Right content -->
                    <div class="flex-fill overflow-auto">

                        <div id="jobsList">
                            <c:forEach var="job" items="${jobs}">
                                <div class="card card-body">
                                    <div class="media flex-column flex-sm-row">
                                        <div class="mr-sm-3 mb-2 mb-sm-0">
                                            <a href="#">
                                                <img src="<c:url value="/resources/images/placeholder.jpg"/>" class="rounded" width="44" height="44" alt="">
                                            </a>
                                        </div>

                                        <div class="media-body">
                                            <h6 class="media-title font-weight-semibold">
                                                <a href="jobDetails?id=${job.id}">${job.jobTitle.name}</a>
                                            </h6>

                                            <ul class="list-inline list-inline-dotted text-muted mb-2">
                                                <li class="list-inline-item"><a href="#" class="text-muted">${job.company.name}</a></li>
                                                <li class="list-inline-item">${job.location.city}, ${job.location.state}</li>
                                            </ul>

                                            Job Short Description
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <script type="text/javascript">
                                document.addEventListener('DOMContentLoaded', function() {
                                    applyPagination(${noOfPages});
                                });
                            </script>
                        </div>


                        <!-- Pagination -->
                        <div class="d-flex justify-content-center pt-3 mb-3">
                            <ul class="pagination shadow-1 pagination-sm" id="pagination">
                                <%--<c:forEach begin="1" end="${noOfPages}" var="i">--%>
                                    <%--<c:choose>--%>
                                        <%--<c:when test="${currentPage eq i}">--%>
                                            <%--<c:if test="${i eq 1}">--%>
                                                <%--<li class="page-item"><a honclick="JobList.jobsPaginationList(${i},${noOfPages})" class="page-link page-link-white"><i class="icon-arrow-small-right"></i></a></li>--%>
                                            <%--</c:if>--%>
                                            <%--<li class="page-item active"><a onclick="jobsPaginationList(${i},${noOfPages})" class="page-link page-link-white">${i}</a></li>--%>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>
                                            <%--<li class="page-item"><a onclick="jobsPaginationList(${i},${noOfPages})" class="page-link page-link-white">${i}</a></li>--%>
                                            <%--<c:if test="${i eq noOfPages}">--%>
                                                <%--<li class="page-item"><a onclick="jobsPaginationList(${i},${noOfPages})" class="page-link page-link-white"><i class="icon-arrow-small-left"></i></a></li>--%>
                                            <%--</c:if>--%>
                                        <%--</c:otherwise>--%>
                                    <%--</c:choose>--%>
                                <%--</c:forEach>--%>
                            </ul>
                        </div>
                        <!-- /pagination -->

                    </div>
                    <!-- /right content -->

                </div>
                <!-- /inner container -->

            </div>
            <!-- /content area -->
    </layout:put>
</layout:extends>