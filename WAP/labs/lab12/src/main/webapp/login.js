$( document ).ready(function() {

    let loggedUser = $.cookie("loggedUser");
    if(loggedUser){
        $('#uname').val(loggedUser);
        $("input[type='checkbox']").prop( "checked", "on" );
    }else{
        $.removeCookie("loggedUser");
    }

    $("#loginForm").submit(function(e){
        var postData = $("#loginForm").serializeArray();
        var formURL = $("#loginForm").attr("action");
        $.ajax({
            url : formURL,
            type: "POST",
            data : postData,
            success:function(data) {
                console.log(data);
                let loggedUser = $.cookie("loggedUser");
                if(!$("input[type='checkbox']").is(':checked')){
                    $.removeCookie("loggedUser");
                }
                alert(data);
                window.location.href = "index.jsp";
            },
            error: function(error) {
                console.log(error.responseText);
                alert(error.responseText);
            }
        });
        e.preventDefault();
    });
});