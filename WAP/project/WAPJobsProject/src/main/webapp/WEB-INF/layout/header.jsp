<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:block name="header">
   <!-- Main navbar -->
   <div class="navbar navbar-expand-md navbar-dark bg-indigo navbar-static ${sessionScope.get('loggedUser')!=null ? 'fixed-top' : ''}">
      <div class="navbar-brand">
         <a href="<c:url value="/"/>" class="d-inline-block">
         <img src="resources/images/logo.png" alt="">
         </a>
      </div>
      <div class="d-md-none">
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-mobile">
         <i class="icon-tree5"></i>
         </button>
         <button class="navbar-toggler sidebar-mobile-main-toggle" type="button">
         <i class="icon-paragraph-justify3"></i>
         </button>
      </div>
      <c:if test="${sessionScope.get('loggedUser')!=null}">
         <div class="collapse navbar-collapse" id="navbar-mobile">
               <ul class="navbar-nav">
                  <li class="nav-item">
                     <a href="#" class="navbar-nav-link sidebar-control sidebar-main-toggle d-none d-md-block">
                     <i class="icon-paragraph-justify3"></i>
                     </a>
                  </li>
               </ul>
               <ul class="navbar-nav ml-auto">
                  <li class="nav-item dropdown dropdown-user">
                     <a href="#" class="navbar-nav-link dropdown-toggle" data-toggle="dropdown">
                     <img src="resources/images/image.png" class="rounded-circle" alt="">
                     <span>${sessionScope.get('loggedUser').firstName} ${sessionScope.get('loggedUser').lastName}</span>
                     </a>
                     <div class="dropdown-menu dropdown-menu-right">
                        <a href="<c:url value="/profile"/>" class="dropdown-item"><i class="icon-user-plus"></i> My profile</a>
                        <a href="logout" class="dropdown-item"><i class="icon-switch2"></i> Logout</a>
                     </div>
                  </li>
            </ul>
         </div>
      </c:if>
   </div>
   <!-- /main navbar -->
</layout:block>