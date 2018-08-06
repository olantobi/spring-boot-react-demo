import React, { Component } from 'react';
import './App.css';
import AppNavBar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavBar/>
                <Container fluid>
                    <Button color="link"><Link to="/groups">Manage Tours</Link></Button>
                </Container>
            </div>
        );
    }
}

export default Home;