let applyJobModule = function() {

    function get(name){
        if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }

    let applyJobModel = function() {

        $('#applyJob .bg-primary').on('click', function() {
            fetch('jobDetails?id='+get('id'), {
                method: 'post',
            }).then(function(response) {
                return response.text();
            }).then(function(data) {
                console.log(data);
                $('#applyJob').modal('hide');
                $.jGrowl(data, {
                    header: 'Well done!',
                    theme: 'bg-success'
                });
            });
        });
    };

    return {
        init: function() {
            applyJobModel();
        }
    }
}();


// Initialize module
// ------------------------------

document.addEventListener('DOMContentLoaded', function() {
    applyJobModule.init();
});