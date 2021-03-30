const ce = React.createElement

class Hello extends React.Component {
    constructor(props) {
        super(props);
        this.state = {white: true};
    }

    render() {
        return ce('div', this.style(), ce('button', {onClick: (e) => this.clickHandler(e)}, 'switch color'));
    }

    clickHandler(e) {
        this.setState({white: !this.state.white});
    }

    style() {
        if(this.state.white) {
            return {style: {backgroundColor: 'white'}};
        } else {
            return {style: {backgroundColor: 'black'}};        }
    }
}

ReactDOM.render(
    ce(Hello, null, null),
    document.getElementById("react-route")
);