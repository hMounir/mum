<!doctype html>
<html>
<head>
    <title>Test Page</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <h1>Support Form</h1>

    <form action="support" method="post">
        <div class="input">
            <label for="name">Name</label>
            <input type="text" id="name" name="name"/>
        </div>
        <div class="input">
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </div>
        <div class="input">
            <label for="problem">Problem</label>
            <input type="text" id="problem" name="problem"/>
        </div>
        <div class="input">
            <label for="problemDesc">Problem Description</label>
            <textarea id="problemDesc" name="problemDesc" rows="5" cols="60"></textarea>
        </div>
        <input type="submit" value="Help"/>
    </form>
</body>
</html>