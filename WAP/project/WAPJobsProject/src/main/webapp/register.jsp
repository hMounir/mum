<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">
        <style>
            .select2-selection--single .select2-selection__rendered {
                padding-left: 30px;
            }
        </style>
        <%--<button type="button" class="btn btn-success" id="noty_success">Launch <i class="icon-play3 ml-2"></i></button>--%>
        <!-- Content area -->
        <div class="content d-flex justify-content-center align-items-center">
            <script src="resources/js/register_validation.js"></script>
            <script src="resources/js/template/extra_jgrowl_noty.js"></script>
            ${script}
            <!-- Registration form -->
            <form class="login-form form-validate" action="register" method="post">
                <div class="card mb-0">
                    <div class="card-body">
                        <div class="text-center mb-3">
                            <i class="icon-plus3 icon-2x text-success border-success border-3 rounded-round p-3 mb-3 mt-1"></i>
                            <h5 class="mb-0">Create account</h5>
                            <span class="d-block text-muted">All fields are required</span>
                        </div>

                        <div class="form-group text-center text-muted content-divider">
                            <span class="px-2">Your credentials</span>
                        </div>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <input type="text" class="form-control" placeholder="First Name" id="firstName" name="firstName"/>
                            <div class="form-control-feedback">
                                <i class="icon-user text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <input type="text" class="form-control" placeholder="Last name" id="lastName" name="lastName"/>
                            <div class="form-control-feedback">
                                <i class="icon-user-check text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <select data-placeholder="Select Gender" class="form-control select-icons" data-fouc id="gender" name="gender">
                                    <option disabled selected value></option>
                                    <option value="M">Male</option>
                                    <option value="F">Female</option>
                            </select>
                            <div class="form-control-feedback">
                                <i class="icon-user-check text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <input type="text" class="form-control" placeholder="someone@domain.com" id="email" name="email"/>
                            <div class="form-control-feedback">
                                <i class="icon-user text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                            <div class="form-control-feedback">
                                <i class="icon-lock2 text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group  form-group-feedback form-group-feedback-left">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" name="accept" id="accept" class="form-input-styled" data-fouc>
                                    Accept <a href="#">terms of service</a>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn bg-teal-400 btn-block" id="noty_success">Register <i class="icon-play3 ml-2"></i></button>
                        </div>

                        <div class="form-group text-center text-muted content-divider">
                            <span class="px-2">Already have an account?</span>
                        </div>

                        <div class="form-group">
                            <a href="login" class="btn btn-light btn-block">Sign in</a>
                        </div>
                    </div>
                </div>
            </form>
            <!-- /registration form -->

        </div>
        <!-- /content area -->
    </layout:put>
</layout:extends>