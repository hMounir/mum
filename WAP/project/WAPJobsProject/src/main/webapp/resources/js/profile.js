$( document ).ready(function() {

    var _componentValidation = function() {
        if (!$().validate) {
            console.warn('Warning - validate.min.js is not loaded.');
            return;
        }

        $('#passwordForm').validate({
            ignore: 'input[type=hidden], .select2-search__field', // ignore hidden fields
            errorClass: 'validation-invalid-label',
            successClass: 'validation-valid-label',
            validClass: 'validation-valid-label',
            highlight: function(element, errorClass) {
                $(element).removeClass(errorClass);
            },
            unhighlight: function(element, errorClass) {
                $(element).removeClass(errorClass);
            },
            success: function(label) {
                label.addClass('validation-valid-label').text('Success.'); // remove to hide Success message
            },

            // Different components require proper error label placement
            errorPlacement: function(error, element) {

                // Unstyled checkboxes, radios
                if (element.parents().hasClass('form-check')) {
                    error.appendTo( element.parents('.form-check').parent() );
                }

                // Input with icons and Select2
                else if (element.parents().hasClass('form-group-feedback') || element.hasClass('select2-hidden-accessible')) {
                    error.appendTo( element.parent() );
                }

                // Input group, styled file input
                else if (element.parent().is('.uniform-uploader, .uniform-select') || element.parents().hasClass('input-group')) {
                    error.appendTo( element.parent().parent() );
                }

                // Other elements
                else {
                    error.insertAfter(element);
                }
            },
            rules: {
                currentPassword: {
                    equalTo: "#oldPassword"
                },
                newPassword: {
                    required: true
                },
                repeatPassword: {
                    required: true,
                    equalTo: "#newPassword"
                }
            },
            messages: {
                currentPassword:{
                    equalTo:"Please check your password"
                },
                newPassword:{
                    required:"Please enter your password"
                },
                repeatPassword:{
                    required:"Please enter your new password again",
                    equalTo:"Please make sure it's equal to your new password"
                }
            }
        });
    };

    _componentValidation();

    $("#profileForm").submit(function(e){
        var postData = objectifyForm($("#profileForm").serializeArray());
        var myJSON = JSON.stringify(postData);

        console.log(myJSON);
        var formURL = $("#profileForm").attr("action");
        $.ajax({
            url : formURL,
            type: "POST",
            data : myJSON,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function(data) {
                $.jGrowl(data.message, {
                    header: 'Well done!',
                    theme: 'bg-success'
                });
            },
            error: function(error) {
                $.jGrowl('Error in saving data', {
                    header: 'Opps!!',
                    theme: 'bg-danger'
                });
            }
        });
        e.preventDefault();
    });

    function objectifyForm(formArray) {//serialize data function

        var returnArray = {};
        for (var i = 0; i < formArray.length; i++){
            returnArray[formArray[i]['name']] = formArray[i]['value'];
        }
        return returnArray;
    }
});