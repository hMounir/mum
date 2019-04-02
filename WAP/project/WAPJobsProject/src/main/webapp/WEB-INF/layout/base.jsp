<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>WAP Jobs</title>

        <!-- Global stylesheets -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
        <link href="resources/css/icomoon/styles.css" rel="stylesheet" type="text/css">
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="resources/css/bootstrap_limitless.css" rel="stylesheet" type="text/css">
        <link href="resources/css/layout.css" rel="stylesheet" type="text/css">
        <link href="resources/css/components.css" rel="stylesheet" type="text/css">
        <link href="resources/css/colors.css" rel="stylesheet" type="text/css">
        <!-- /global stylesheets -->

        <!-- Core JS files -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.70/jquery.blockUI.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Ripple.js/1.2.1/ripple.min.js"></script>
        <!-- /core JS files -->

        <%--<!-- Theme JS files -->--%>
        <script src="resources/js/libs/interactions.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-jgrowl/1.4.6/jquery.jgrowl.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/noty/3.1.4/noty.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

        <script src="resources/js/libs/uniform.min.js"></script>
        <script src="resources/js/template/app.js"></script>
        <script src="resources/js/template/components_modals.js"></script>
        <script src="resources/js/template/form_select2.js"></script>
        <%--<!-- /theme JS files -->--%>
    </head>
    <body class="${sessionScope.get('loggedUser')!=null ? 'navbar-top sidebar-xs' : ''}">
            <jsp:include page="header.jsp"/>
            <layout:block name="container">
                    <!-- Page content -->
                    <div class="page-content">
                        <c:if test="${sessionScope.get('loggedUser')!=null}">
                            <jsp:include page="sidebar.jsp"/>
                        </c:if>
                        <div class="content-wrapper">
                            <layout:block name="content">
                                <h1>content here</h1>
                            </layout:block>
                            <jsp:include page="footer.jsp"/>
                        </div>
                    </div>
                    <!-- /page content -->
            </layout:block>
    </body>
</html>