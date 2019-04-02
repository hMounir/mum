let callFunction = (
    function () {
        function calcTip() {
            document.getElementById("subTotalErrorMsg").style.display = 'none';
            document.getElementById("tipErrorMsg").style.display = 'none';
            let subtotalElem = document.getElementById("subtotal");
            let tipElem = document.getElementById("tip");
            let totalElem = document.getElementById('total');
            let subtotal = subtotalElem.value;
            let tip = tipElem.value;
            if(subtotal === ''){
                document.getElementById("subTotalErrorMsg").style.display = 'block';
            }
            if(tip === ''){
                document.getElementById("tipErrorMsg").style.display = 'block';
            }
            let total = subtotal * tip/100;
            totalElem.innerHTML = '$' + total;
        }
        return {
            calcTip: calcTip
        };
    })();