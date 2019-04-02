let jsFunction = (
    function () {
        function gogogo() {
            alert("Yay, it works!");
        }
        return {
            gogogo: gogogo
        };
    })();