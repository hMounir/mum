/* ------------------------------------------------------------------------------
 *
 *  # Job search - list
 *
 *  Demo JS code for job search page kit - list view
 *
 * ---------------------------------------------------------------------------- */


// Setup module
// ------------------------------

let JobList = function () {

    let _componentUniform = function() {
        if (!$().uniform) {
            console.warn('Warning - uniform.min.js is not loaded.');
            return;
        }

        // Initialize
        $('.form-input-styled').uniform();
    };

    //
    // Return objects assigned to module
    //

    return {
        init: function() {
            _componentUniform();
        }
    }
}();

function jobsPaginationList(page){
    fetch('jobs?requestType=LIST_JOBS&row='+page)
        .then(function(response) {
            return response.json();
        })
        .then(function(myJson) {
            $('#jobsList').html("");
            myJson.forEach(function(element) {
                $('#jobsList').append("<div class=\"card card-body\">\n" +
                    "                                <div class=\"media flex-column flex-sm-row\">\n" +
                    "                                    <div class=\"mr-sm-3 mb-2 mb-sm-0\">\n" +
                    "                                        <a href=\"#\">\n" +
                    "                                            <img src=\"resources/images/placeholder.jpg\" class=\"rounded\" width=\"44\" height=\"44\" alt=\"\">\n" +
                    "                                        </a>\n" +
                    "                                    </div>\n" +
                    "\n" +
                    "                                    <div class=\"media-body\">\n" +
                    "                                        <h6 class=\"media-title font-weight-semibold\">\n" +
                    "                                            <a href=\"jobDetails?id="+element.id+"\">"+element.jobTitle.name+"</a>\n" +
                    "                                        </h6>\n" +
                    "\n" +
                    "                                        <ul class=\"list-inline list-inline-dotted text-muted mb-2\">\n" +
                    "                                            <li class=\"list-inline-item\"><a href=\"#\" class=\"text-muted\">"+element.company.name+"</a></li>\n" +
                    "                                            <li class=\"list-inline-item\">"+element.location.city+", "+element.location.state+"</li>\n" +
                    "                                        </ul>\n" +
                    "\n" +
                    "                                        Job Short Description\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>");
            });
        });
}

function applyPagination(noOfPages) {
    $('#pagination').twbsPagination({
        totalPages: noOfPages,
        visiblePages: 6,
        onPageClick: function (event, page) {
            jobsPaginationList(page);
        }
    });
}


// Initialize module
// ------------------------------

document.addEventListener('DOMContentLoaded', function() {
    JobList.init();
});