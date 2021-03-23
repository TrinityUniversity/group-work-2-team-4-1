"use strict";

const countButton = document.getElementById("incrementButton");

countButton.onclick = () => {
       
    //$("random").load("/)
    fetch("/increment").then((response) => {
        return response.text();
    }).then((responseText) => {
        const count = document.getElementById("count");
        count.innerHTML = responseText;
    });


}