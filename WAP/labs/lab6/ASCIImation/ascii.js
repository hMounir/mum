"use strict";

let animationFunc = function() {
    let timer;
    let index = 0;
    let speed = 250;
    let animationData = ANIMATIONS['Dive'];
    let text = document.getElementById("txtAnimation");
    let array = animationData.split("=====\n");
    document.getElementById("btnStop").disabled = true;

    function setText() {
        timer = setInterval(function() {
            text.value = array[index];
            index+=1;
            if (index >= array.length) {
                index = 0;
            }
        }, speed);
    }

    function stop() {
        clearInterval(timer);
        text.value=animationData;
        document.getElementById("btnStart").disabled = false;
        document.getElementById("btnStop").disabled = true;
        document.getElementById("animation").disabled = false;
        document.getElementById("size").disabled = false;
    }
    function doAnimation() {
        if (timer === null) {
            setText();
        } else {
            stop();
            setText();
        }
        document.getElementById("btnStop").disabled = false;
        document.getElementById("btnStart").disabled = true;
        document.getElementById("animation").disabled = true;
    }



    function changeAnimation() {
        let animation = document.getElementById("animation");
        let animationText = animation.options[animation.selectedIndex].text;
        animationData = ANIMATIONS[animationText];
        array = animationData.split("=====\n");
        text.value=animationData;
    }

    function changeSize() {
        let size = document.getElementById("size");
        text.style.fontSize = size.options[size.selectedIndex].value;
    }
    return {
        startOnclick: function() {
            changeAnimation();
            changeSize();
            doAnimation(speed);

        },
        stopOnclick: function() {
            stop();
        },
        animationOnchange: function() {
            changeAnimation();
        },
        sizeOnchange: function() {
            changeSize();
        },
        turboOnclick: function() {
            let checkbox = document.getElementById("turbo");
            if (checkbox.checked) {
                speed = 50;
                stop();
                doAnimation(speed);
            } else {
                speed = 250;
                stop();
                doAnimation(speed);
            }
        }
    };

};
window.onload = function() {
    let animation = animationFunc();
    document.getElementById("btnStart").onclick = animation.startOnclick;
    document.getElementById("btnStop").onclick = animation.stopOnclick;
    document.getElementById("animation").onchange = animation.animationOnchange;
    document.getElementById("size").onchange = animation.sizeOnchange;
    document.getElementById("turbo").onclick = animation.turboOnclick;
};