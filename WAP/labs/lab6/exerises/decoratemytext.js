function clickme() {
    alert("Hello, world!");
}

var timer = null;
function buttonClicked() {
    //changeTextFontSize();
    if (timer == null) {
        timer = setInterval(doubleTextFontSize, 500);
    } else {
        clearInterval(timer);
        timer = null;
    }
}

function changeTextFontSize() {
    document.getElementById('textArea').style.fontSize = '24px';

}

function doubleTextFontSize() {
    let textArea = document.getElementById("textArea");
    let defaultFontSize = window.getComputedStyle(textArea, null).getPropertyValue("font-size");
    textArea.style.fontSize = (parseFloat(defaultFontSize) + 2) + 'px';
}

function checkBoxChanged() {
    alert("checkbox changed");
    let checkBoxValue = document.getElementById('checkbox').checked;
    if(checkBoxValue){
        document.getElementById('textArea').style.fontWeight = 'bold';
        document.getElementById('textArea').style.color = 'green';
        document.getElementById('textArea').style.textDecoration = 'underline';
        document.getElementById('body').className = 'changePageBackground';
    }else{
        document.getElementById('textArea').style.fontWeight = 'normal';
        document.getElementById('textArea').style.color = 'black';
        document.getElementById('textArea').style.textDecoration = 'none';
        document.getElementById('body').className = '';
    }
}

function convertsText() {
    let text = document.getElementById("textArea");
    let words = text.value.split(" ");
    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        let pattern = /^[b-df-hj-np-tv-z]+/i;
        if (pattern.test(word)) {
            let matched = pattern.exec(word);
            let temp = word.replace(pattern, '');
            words[i] = temp + matched + "-ay";
        }
    }
    text.value = words.join(" ");
}