function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

$(document).ready(function () {

    $("#checkoutForm").submit(function(e){
        var postData = getFormData($("#checkoutForm"));
        $.ajax({
            contentType: 'application/json',
            url : 'checkout',
            type: "POST",
            data: JSON.stringify(postData),
            success:function(data) {
                console.log(data);
                alert(data);
                window.location.href = "products.jsp";
            },
            error: function(error) {
                console.log(error.responseText);
                alert(error.responseText);
            }
        });
        e.preventDefault();
    });
});