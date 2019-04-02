function calcTip() {
    document.getElementById("subTotalErrorMsg").style.display = 'none';
    document.getElementById("tipErrorMsg").style.display = 'none';
    var subtotalElem = document.getElementById("subtotal");
    var tipElem = document.getElementById("tip");
    var totalElem = document.getElementById('total');
    var subtotal = subtotalElem.value;
    var tip = tipElem.value;
    if(subtotal === ''){
        document.getElementById("subTotalErrorMsg").style.display = 'block';
    }
    if(tip === ''){
        document.getElementById("tipErrorMsg").style.display = 'block';
    }
    var total = subtotal * tip/100;
    totalElem.innerHTML = '$' + total;
}