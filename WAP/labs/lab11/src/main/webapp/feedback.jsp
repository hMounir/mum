<%--
  Created by IntelliJ IDEA.
  User: Hisham
  Date: 3/8/2019
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
</head>
<body>
<p>Thank you! <strong>${param.name}</strong> for contacting us. We should receive reply from us with in 24 hrs in your email address <strong>${param.email}</strong>.
        Let us know in our support email ${initParam['support_email']} if you don’t receive reply within 24 hrs. Please be sure to attach
        your reference ${param.Support_ticket_id} in your email.</p>
</body>
</html>