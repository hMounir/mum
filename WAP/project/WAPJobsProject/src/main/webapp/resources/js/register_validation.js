/* ------------------------------------------------------------------------------
 *
 *  # Login form with validation
 *
 *  Demo JS code for login_validation.html page
 *
 * ---------------------------------------------------------------------------- */


// Setup module
// ------------------------------

var RegisterValidation = function() {


    //
    // Setup module components
    //

    // Uniform
    var _componentUniform = function() {
        if (!$().uniform) {
            console.warn('Warning - uniform.min.js is not loaded.');
            return;
        }

        // Initialize
        $('.form-input-styled').uniform();
    };

    // Validation config
    var _componentValidation = function() {
        if (!$().validate) {
            console.warn('Warning - validate.min.js is not loaded.');
            return;
        }

        $('.form-validate').validate({
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
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5
                },
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                gender:{
                    required: true
                },
                accept:{
                    required:true
                }
            },
            messages: {
                email: {
                    required: "Please enter your email",
                    email: "Please enter a valid email address"
                },
                password: {
                    required: "Please enter your password",
                    minlength: "Your password must be at least 5 characters long"
                },
                firstName: {
                    required: "Please enter your first name",
                },
                lastName: {
                    required: "Please enter your last name"
                },
                gender: {
                    required: "Please enter your gender"
                },
                accept: {
                    required: "Please check the acceptance checkbox"
                }
            }
        });
    };


    //
    // Return objects assigned to module
    //

    return {
        init: function() {
            _componentUniform();
            _componentValidation();
        }
    }
}();


// Initialize module
// ------------------------------

document.addEventListener('DOMContentLoaded', function() {
    RegisterValidation.init();
});
