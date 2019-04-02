<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <h1>logged in page, welcome ${sessionScope.get('loggedUser').userName}</h1>

        <a href="logout">Click Here to login</a>
    </body>
</html>
