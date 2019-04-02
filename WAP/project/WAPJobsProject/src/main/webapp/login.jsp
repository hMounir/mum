<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="content" type="REPLACE">

        <!-- Content area -->
        <div class="content d-flex justify-content-center align-items-center">
            <script src="resources/js/login_validation.js"></script>
            <script src="resources/js/template/extra_jgrowl_noty.js"></script>
                ${loginScript}
            <!-- Login form -->
            <form class="login-form form-validate" action="login" method="post">
                <div class="card mb-0">
                    <div class="card-body">
                        <div class="text-center mb-3">
                            <i class="icon-reading icon-2x text-slate-300 border-slate-300 border-3 rounded-round p-3 mb-3 mt-1"></i>
                            <h5 class="mb-0">Login to your account</h5>
                            <span class="d-block text-muted">Enter your credentials below</span>
                        </div>

                        <c:if test="${errorMessage!=null}">
                            <div class="text-center mb-3">
                                <span class="form-text text-danger"><i class="icon-cancel-circle2 mr-2"></i> ${errorMessage}</span>
                            </div>
                        </c:if>

                        <div class="form-group form-group-feedback form-group-feedback-left">
                            <input type="text" class="form-control" placeholder="Email" id="email" name="email"/>
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

                        <div class="form-group d-flex align-items-center">
                            <div class="form-check mb-0">
                                <label class="form-check-label">
                                    <input type="checkbox" name="remember" id="remember" class="form-input-styled" data-fouc/>
                                    Remember
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">Sign in <i class="icon-circle-right2 ml-2"></i></button>
                        </div>

                        <div class="form-group text-center text-muted content-divider">
                            <span class="px-2">Don't have an account?</span>
                        </div>

                        <div class="form-group">
                            <a href="register" class="btn btn-light btn-block">Sign up</a>
                        </div>

                        <span class="form-text text-center text-muted">
                            By continuing, you're confirming that you've read our <a href="#">Terms &amp; Conditions</a> and <a href="#">Cookie Policy</a>
                        </span>
                    </div>
                </div>
            </form>
            <!-- /login form -->

        </div>
        <!-- /content area -->
    </layout:put>
</layout:extends>