"use strict";

// const countButton = document.getElementById("incrementButton");
// const count = document.getElementById("count");

// countButton.onclick = () => {
       
//     $("random").load("/)
//     fetch("/increment").then((response) => {
//         return response.text();
//     }).then((responseText) => {
//         const count = document.getElementById("count");
//         count.innerHTML = responseText;
//     });

    


// }

const ce = React.createElement;


const countSocket = document.getElementById("count-route").value;
const socket = new WebSocket(countSocket.replace("http", "ws"));

class Counting extends React.Component {
    constructor(props) {
        super(props);
        this.state = {clickCount: 0, socket: null}
        socket.onmessage = (event) => {//could be better in lifecycle method 
            this.setState({clickCount: event.data});
        }
    }

    render() {
        return ce('button', {onClick: (e) => this.clickHandler(e)}, this.state.clickCount);
    }

    clickHandler(e) {
        socket.send(this.state.clickCount);
    }

    

    
}

ReactDOM.render(
    ce(Counting, {socket}, null),
    document.getElementById("react-route")
);



// countButton.onclick = (event) => {
//     socket.send(count.innerHTML);
// }



// socket.onopen = (event) => socket.send("New user connected.");
