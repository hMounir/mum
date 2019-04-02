<%@ page import="edu.wap.jobs.dao.UserDao" %>
<%@ page import="edu.wap.jobs.domain.User" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">
        <!-- Page header -->
        <div class="page-header page-header-light">
            <div class="page-header-content header-elements-md-inline">
                <div class="page-title d-flex">
                    <h4><i class="icon-arrow-left52 mr-2"></i> <span class="font-weight-semibold">User Profile</span></h4>
                    <a href="#" class="header-elements-toggle text-default d-md-none"><i class="icon-more"></i></a>
                </div>
            </div>

            <div class="breadcrumb-line breadcrumb-line-light header-elements-md-inline">
                <div class="d-flex">
                    <div class="breadcrumb">
                        <a href="<c:url value="/"/>" class="breadcrumb-item"><i class="icon-home2 mr-2"></i> Home</a>
                        <a href="<c:url value="/profile"/> " class="breadcrumb-item">User Profile</a>
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

                <div class="tab-content w-100 overflow-auto">
                    <div class="tab-pane fade active show" id="profile">
                        <!-- Profile info -->
                        <div class="card">
                            <div class="card-header header-elements-inline">
                                <h5 class="card-title">Profile information</h5>
                                <div class="header-elements">
                                    <div class="list-icons">
                                        <a class="list-icons-item" data-action="collapse"></a>
                                        <a class="list-icons-item" data-action="reload"></a>
                                        <a class="list-icons-item" data-action="remove"></a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <script src="resources/js/template/extra_jgrowl_noty.js"></script>
                                <script src="resources/js/profile.js"></script>
                                <form action="profile" method="post" id="profileForm">
                                    <input type="hidden" name="id" id="id" value="${sessionScope.get('loggedUser').id}"/>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>First Name</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').firstName}" id="firstName" name="firstName" class="form-control">
                                            </div>
                                            <div class="col-md-6">
                                                <label>Last name</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').lastName}" id="lastName" name="lastName" class="form-control">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Address line</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').address}" id="address" name="address" class="form-control">
                                            </div>
                                            <div class="col-md-6">
                                                <label>Your country</label>
                                                <input type="text" readonly="readonly" value="${sessionScope.get('loggedUser').country}" class="form-control" id="country" name="country">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <label>City</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').city}" id="city" name="city" class="form-control">
                                            </div>
                                            <div class="col-md-4">
                                                <label>State/Province</label>
                                                <div class="form-group form-group-feedback form-group-feedback-left">

                                                    <select data-placeholder="Select  state"   class="form-control select-icons" data-fouc id="state" name="state">
                                                        <c:forEach items="${stateList}" var="st">
                                                            <option value="${st.state}" ${st.state == sessionScope.get('loggedUser').state ? 'selected="selected"' : ''}>${st.state}</option>
                                                        </c:forEach>
                                                    </select>

                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <label>ZIP code</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').zipCode}" class="form-control" id="zipCode" name="zipCode">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                                <input type="text" readonly="readonly" value="${sessionScope.get('loggedUser').email}" class="form-control" id="email" name="email">
                                            </div>
                                            <div class="col-md-6">
                                                <label>Phone #</label>
                                                <input type="text" value="${sessionScope.get('loggedUser').phone}" class="form-control" id="phone" name="phone">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group text-right">
                                        <button type="submit" class="btn btn-primary" id="noty_success">Save changes <i class="icon-play3 ml-2"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /profile info -->


                        <!-- Account settings -->
                        <div class="card">
                            <div class="card-header header-elements-inline">
                                <h5 class="card-title">Account settings</h5>
                                <div class="header-elements">
                                    <div class="list-icons">
                                        <a class="list-icons-item" data-action="collapse"></a>
                                        <a class="list-icons-item" data-action="reload"></a>
                                        <a class="list-icons-item" data-action="remove"></a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <form action="password" method="post" id="passwordForm">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input type="text" hidden value="${sessionScope.get('loggedUser').password}" id="oldPassword" name="oldPassword"/>
                                                <label>Current password</label>
                                                <input type="password" name="currentPassword" id="currentPassword" placeholder="Write your old password"  class="form-control">
                                            </div>
                                            <%--<script>--%>
                                                <%--$('#currentPassword').on('keyup', function () {--%>
                                                    <%--if ($('#password').val() == $('#currentPassword').val()) {--%>
                                                        <%--$('#message1').html('current password correct').css('color', 'green');--%>
                                                    <%--} else $('#message1').html('currentpassword incorrect').css('color', 'red');--%>
                                                <%--});--%>
                                            <%--</script>--%>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6 form-group form-group-feedback form-group-feedback-left">
                                                <label>New password</label>
                                                <input type="password" id="newPassword" name="newPassword" class="form-control" placeholder="Enter new password"/>
                                            </div>

                                            <div class="col-md-6 form-group form-group-feedback form-group-feedback-left">
                                                <label>Repeat password</label>
                                                <input type="password" id="repeatPassword" name="repeatPassword" class="form-control" placeholder="Confirm your password"/>
                                                <span id='message'></span>
                                            </div>
                                            <script>
                                                $('#repeatPassword').on('keyup', function () {
                                                    if ($(this).val() == $('#newPassword').val()) {
                                                        $('#message').html('matching').css('color', 'green');
                                                    } else $('#message').html('not matching').css('color', 'red');
                                                });
                                        </script>
                                        </div>
                                    </div>

                                    <div class="form-group text-right">
                                        <button type="submit" class="btn btn-primary" id="noty_success2">Save changes <i class="icon-play3 ml-2"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /account settings -->
                    </div>

                    <div class="tab-pane fade" id="schedule">

                        <!-- Available hours -->
                        <div class="card">
                            <div class="card-header header-elements-inline">
                                <h6 class="card-title">Available hours</h6>
                                <div class="header-elements">
                                    <div class="list-icons">
                                        <a class="list-icons-item" data-action="collapse"></a>
                                        <a class="list-icons-item" data-action="reload"></a>
                                        <a class="list-icons-item" data-action="remove"></a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="chart-container">
                                    <div class="chart has-fixed-height" id="available_hours"></div>
                                </div>
                            </div>
                        </div>
                        <!-- /available hours -->


                        <!-- Schedule -->
                        <div class="card">
                            <div class="card-header header-elements-inline">
                                <h5 class="card-title">My schedule</h5>
                                <div class="header-elements">
                                    <div class="list-icons">
                                        <a class="list-icons-item" data-action="collapse"></a>
                                        <a class="list-icons-item" data-action="reload"></a>
                                        <a class="list-icons-item" data-action="remove"></a>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="my-schedule"></div>
                            </div>
                        </div>
                        <!-- /schedule -->

                    </div>

                    <div class="tab-pane fade" id="inbox">

                        <!-- My inbox -->
                        <div class="card">
                            <div class="card-header bg-transparent header-elements-inline">
                                <h6 class="card-title">My inbox</h6>

                                <div class="header-elements">
                                    <span class="badge bg-blue">25 new today</span>
                                </div>
                            </div>

                            <!-- Action toolbar -->
                            <div class="bg-light">
                                <div class="navbar navbar-light bg-light navbar-expand-lg py-lg-2">
                                    <div class="text-center d-lg-none w-100">
                                        <button type="button" class="navbar-toggler w-100" data-toggle="collapse" data-target="#inbox-toolbar-toggle-multiple">
                                            <i class="icon-circle-down2"></i>
                                        </button>
                                    </div>

                                    <div class="navbar-collapse text-center text-lg-left flex-wrap collapse" id="inbox-toolbar-toggle-multiple">
                                        <div class="mt-3 mt-lg-0">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-light btn-icon btn-checkbox-all">
                                                    <input type="checkbox" class="form-input-styled" data-fouc>
                                                </button>

                                                <button type="button" class="btn btn-light btn-icon dropdown-toggle" data-toggle="dropdown"></button>
                                                <div class="dropdown-menu">
                                                    <a href="#" class="dropdown-item">Select all</a>
                                                    <a href="#" class="dropdown-item">Select read</a>
                                                    <a href="#" class="dropdown-item">Select unread</a>
                                                    <div class="dropdown-divider"></div>
                                                    <a href="#" class="dropdown-item">Clear selection</a>
                                                </div>
                                            </div>

                                            <div class="btn-group ml-3 mr-lg-3">
                                                <button type="button" class="btn btn-light"><i class="icon-pencil7"></i> <span class="d-none d-lg-inline-block ml-2">Compose</span></button>
                                                <button type="button" class="btn btn-light"><i class="icon-bin"></i> <span class="d-none d-lg-inline-block ml-2">Delete</span></button>
                                                <button type="button" class="btn btn-light"><i class="icon-spam"></i> <span class="d-none d-lg-inline-block ml-2">Spam</span></button>
                                            </div>
                                        </div>

                                        <div class="navbar-text ml-lg-auto"><span class="font-weight-semibold">1-50</span> of <span class="font-weight-semibold">528</span></div>

                                        <div class="ml-lg-3 mb-3 mb-lg-0">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-light btn-icon disabled"><i class="icon-arrow-left12"></i></button>
                                                <button type="button" class="btn btn-light btn-icon"><i class="icon-arrow-right13"></i></button>
                                            </div>

                                            <div class="btn-group ml-3">
                                                <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown"><i class="icon-cog3"></i></button>
                                                <div class="dropdown-menu dropdown-menu-right">
                                                    <a href="#" class="dropdown-item">Action</a>
                                                    <a href="#" class="dropdown-item">Another action</a>
                                                    <a href="#" class="dropdown-item">Something else here</a>
                                                    <a href="#" class="dropdown-item">One more line</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /action toolbar -->
                        </div>
                        <!-- /my inbox -->

                    </div>

                    <div class="tab-pane fade" id="orders">

                        <!-- Orders history -->
                        <div class="card">
                            <div class="card-header header-elements-inline">
                                <h6 class="card-title">Orders history</h6>
                                <div class="header-elements">
                                    <span><i class="icon-arrow-down22 text-danger"></i> <span class="font-weight-semibold">- 29.4%</span></span>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="chart-container">
                                    <div class="chart has-fixed-height" id="balance_statistics"></div>
                                </div>
                            </div>

                            <div class="table-responsive">
                                <table class="table text-nowrap">
                                    <thead>
                                    <tr>
                                        <th colspan="2">Product name</th>
                                        <th>Size</th>
                                        <th>Colour</th>
                                        <th>Article number</th>
                                        <th>Units</th>
                                        <th>Price</th>
                                        <th class="text-center" style="width: 20px;"><i class="icon-arrow-down12"></i></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="table-active">
                                        <td colspan="7" class="font-weight-semibold">New orders</td>
                                        <td class="text-right">
                                            <span class="badge bg-secondary badge-pill">24</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0" style="width: 45px;">
                                            <a href="#">
                                                <img src="<c:url value='/resources/images/placeholder.jpg'/>" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Fathom Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-grey border-grey mr-1"></span>
                                                Processing
                                            </div>
                                        </td>
                                        <td>34cm x 29cm</td>
                                        <td>Orange</td>
                                        <td>
                                            <a href="#">1237749</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 79.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="<c:url value='/resources/images/placeholder.jpg'/>" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Mystery Air Long Sleeve T Shirt</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-grey border-grey mr-1"></span>
                                                Processing
                                            </div>
                                        </td>
                                        <td>L</td>
                                        <td>Process Red</td>
                                        <td>
                                            <a href="#">345634</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 38.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Women’s Prospect Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-grey border-grey mr-1"></span>
                                                Processing
                                            </div>
                                        </td>
                                        <td>46cm x 28cm</td>
                                        <td>Neu Nordic Print</td>
                                        <td>
                                            <a href="#">5739584</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 60.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Overlook Short Sleeve T Shirt</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-grey border-grey mr-1"></span>
                                                Processing
                                            </div>
                                        </td>
                                        <td>M</td>
                                        <td>Gray Heather</td>
                                        <td>
                                            <a href="#">434450</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 35.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr class="table-active">
                                        <td colspan="7" class="font-weight-semibold">Shipped orders</td>
                                        <td class="text-right">
                                            <span class="badge bg-success badge-pill">42</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Infinite Ride Liner</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>43</td>
                                        <td>Black</td>
                                        <td>
                                            <a href="#">34739</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 210.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Custom Snowboard</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>151</td>
                                        <td>Black/Blue</td>
                                        <td>
                                            <a href="#">5574832</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 600.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Kids' Day Hiker 20L Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>24cm x 29cm</td>
                                        <td>Figaro Stripe</td>
                                        <td>
                                            <a href="#">6684902</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 55.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Lunch Sack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>24cm x 20cm</td>
                                        <td>Junk Food Print</td>
                                        <td>
                                            <a href="#">5574829</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 20.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Cambridge Jacket</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>XL</td>
                                        <td>Nomad/Railroad</td>
                                        <td>
                                            <a href="#">475839</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 175.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Covert Jacket</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-success border-success mr-1"></span>
                                                Shipped
                                            </div>
                                        </td>
                                        <td>XXL</td>
                                        <td>Mocha/Glacier Sierra</td>
                                        <td>
                                            <a href="#">589439</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 126.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr class="table-active">
                                        <td colspan="7" class="font-weight-semibold">Cancelled orders</td>
                                        <td class="text-right">
                                            <span class="badge bg-danger badge-pill">9</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Day Hiker Pinnacle 31L Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-danger border-danger mr-1"></span>
                                                Cancelled
                                            </div>
                                        </td>
                                        <td>42cm x 26.5cm</td>
                                        <td>Blotto Ripstop</td>
                                        <td>
                                            <a href="#">5849305</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 130.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Kids' Gromlet Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-danger border-danger mr-1"></span>
                                                Cancelled
                                            </div>
                                        </td>
                                        <td>22cm x 20cm</td>
                                        <td>Slime Camo Print</td>
                                        <td>
                                            <a href="#">4438495</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 35.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Tinder Backpack</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-danger border-danger mr-1"></span>
                                                Cancelled
                                            </div>
                                        </td>
                                        <td>42cm x 26cm</td>
                                        <td>Dark Tide Twill</td>
                                        <td>
                                            <a href="#">4759383</a>
                                        </td>
                                        <td>2</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 180.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="pr-0">
                                            <a href="#">
                                                <img src="../../resources/images/placeholder.jpg" height="60" alt="">
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" class="font-weight-semibold">Almighty Snowboard Boot</a>
                                            <div class="text-muted font-size-sm">
                                                <span class="badge badge-mark bg-danger border-danger mr-1"></span>
                                                Cancelled
                                            </div>
                                        </td>
                                        <td>45</td>
                                        <td>Multiweave</td>
                                        <td>
                                            <a href="#">34432</a>
                                        </td>
                                        <td>1</td>
                                        <td>
                                            <h6 class="mb-0 font-weight-semibold">&euro; 370.00</h6>
                                        </td>
                                        <td class="text-center">
                                            <div class="list-icons">
                                                <div class="list-icons-item dropdown">
                                                    <a href="#" class="list-icons-item" data-toggle="dropdown"><i class="icon-menu7"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item"><i class="icon-truck"></i> Track parcel</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-file-download"></i> Download invoice</a>
                                                        <a href="#" class="dropdown-item"><i class="icon-wallet"></i> Payment details</a>
                                                        <div class="dropdown-divider"></div>
                                                        <a href="#" class="dropdown-item"><i class="icon-warning2"></i> Report problem</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /orders history -->

                    </div>
                </div>
                <!-- /right content -->

            </div>
            <!-- /inner container -->

        </div>
        <!-- /content area -->
    </layout:put>
</layout:extends>