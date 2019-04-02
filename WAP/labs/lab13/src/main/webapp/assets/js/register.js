$( document ).ready(function() {

    let registeredUser = $.cookie("registeredUser");
        $('#uname').val(registeredUser);

    $("#registrationForm").submit(function(e){
        var postData = $("#registrationForm").serializeArray();
        var formURL = $("#registrationForm").attr("action");
        $.ajax({
            url : formURL,
            type: "POST",
            data : postData,
            success:function(data) {
                console.log(data);
                alert(data);
                window.location.href = "login.jsp";
            },
            error: function(error) {
                console.log(error.responseText);
                alert(error.responseText);
            }
        });
        e.preventDefault();
    });
});