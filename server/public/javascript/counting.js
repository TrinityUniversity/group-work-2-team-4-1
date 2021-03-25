"use strict";

const countButton = document.getElementById("incrementButton");
const count = document.getElementById("count");

// countButton.onclick = () => {
       
//     $("random").load("/)
//     fetch("/increment").then((response) => {
//         return response.text();
//     }).then((responseText) => {
//         const count = document.getElementById("count");
//         count.innerHTML = responseText;
//     });

    


// }



const countSocket = document.getElementById("count-route").value;
const socket = new WebSocket(countSocket.replace("http", "ws"));

countButton.onclick = (event) => {
    socket.send(count.innerHTML);
}

socket.onmessage = (event) =>{
    count.innerHTML = event.data;
}

socket.onopen = (event) => socket.send("New user connected.");
