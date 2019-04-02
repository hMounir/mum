<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">
            <jsp:include page="applyJob.jsp"/>
            <!-- Page header -->
            <div class="page-header page-header-light">
                <div class="page-header-content header-elements-md-inline">
                    <div class="page-title d-flex">
                        <h4><i class="icon-arrow-left52 mr-2"></i> <span class="font-weight-semibold">Job Search</span> - Detailed</h4>
                        <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                    </div>
                </div>

                <div class="breadcrumb-line breadcrumb-line-light header-elements-md-inline">
                    <div class="d-flex">
                        <div class="breadcrumb">
                            <a href="<c:url value="/"/>" class="breadcrumb-item"><i class="icon-home2 mr-2"></i> Home</a>
                            <a href="<c:url value="/jobDetails"/>" class="breadcrumb-item">Job search</a>
                            <span class="breadcrumb-item active">Detailed</span>
                        </div>

                        <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                    </div>
                </div>
            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Inner container -->
                <div class="d-md-flex align-items-md-start">

                    <!-- Right content -->
                    <div class="flex-fill overflow-auto">

                        <!-- Details -->
                        <div class="card">
                            <div class="card-body">
                                <div class="media flex-column flex-md-row mb-4">
                                    <a href="#" class="align-self-md-center mr-md-3 mb-2 mb-md-0">
                                        <img src="<c:url value="/resources/images/placeholder.jpg"/>" class="rounded" width="44" height="44" alt="">
                                    </a>

                                    <div class="media-body">
                                        <h5 class="media-title font-weight-semibold">${jobDetails.jobTitle.name}</h5>
                                        <ul class="list-inline list-inline-dotted text-muted mb-0">
                                            <li class="list-inline-item">${jobDetails.location.city}, ${jobDetails.location.state}</li>
                                            <li class="list-inline-item">${jobDetails.createdDate}</li>
                                        </ul>
                                    </div>

                                    <div class="align-self-md-center ml-md-3 mt-2 mt-md-0">
                                        <a href="#" class="btn bg-blue" data-toggle="modal" data-target="#applyJob"><i class="icon-envelop2 mr-2"></i> Apply for this job</a>
                                    </div>
                                </div>

                                <c:out value="${jobDetails.description}" escapeXml="false"/>
                            </div>
                        </div>
                        <!-- /details -->


                        <!-- Company profile -->
                        <h6 class="font-weight-semibold pt-2 mb-2">Company profile</h6>
                        <div class="card">
                            <div class="card-body">
                                <div class="media mb-3">
                                    <a href="#" class="mr-3 align-self-center">
                                        <img src="<c:url value="/resources/images/placeholder.jpg"/>" class="rounded" width="44" height="44" alt="">
                                    </a>

                                    <div class="media-body">
                                        <h5 class="media-title font-weight-semibold">Microsoft</h5>
                                        <ul class="list-inline list-inline-dotter text-muted mb-0">
                                            <li class="list-inline-item">IT Services</li>
                                        </ul>
                                    </div>
                                </div>

                                <p>Across a Global footprint, we believe we’re at our best when you’re at yours. From our diverse workforce, our flexible working policies to our creative work spaces, we embrace a culture of learning and sharing to develop our next stage growth. It’s in our hearts to push forward, to create a better future, to never rest and find new ways that help people communicate.</p>

                                We are committed to developing the very best people by offering a flexible, motivating and inclusive workplace in which talent is truly recognised and rewarded. We respect, value and celebrate our people’s individual differences - we are not only multinational but multicultural too. That’s what we mean when we say Power to you.
                            </div>
                        </div>
                        <!-- /company profile -->
                    </div>
                    <!-- /right content -->

                </div>
                <!-- /inner container -->

            </div>
            <!-- /content area -->
    </layout:put>
</layout:extends>