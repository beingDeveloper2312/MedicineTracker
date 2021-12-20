import React, { Component } from 'react'; 
import { Navbar, Nav, NavItem, NavDropdown, MenuItem, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Image from "./logoM.jpeg";
import './NavBar.css';
const NavBar = () => {
    return (
        <div>
 <Navbar className='navbar-custom' collapseOnSelect expand="lg" bg="dark" variant="dark">
  <Container>
  <Navbar.Brand href="#head" >
        <img
          alt="logo"
          src={Image}
          width="50"
          height="50"
          className="d-inline-block align-top .navbar__logo"
        />
      </Navbar.Brand>
  <Navbar.Toggle aria-controls="responsive-navbar-nav" />
  <Navbar.Collapse id="responsive-navbar-nav">
    <Nav className="me-auto">
    <Nav.Link href="#head">Home</Nav.Link>
      <Nav.Link href="#Services">Features</Nav.Link>
      <Nav.Link href="#Download-web" className='web-app'>App</Nav.Link>
      <Nav.Link href="#Download" className='mob-app'>App</Nav.Link>
      <Nav.Link href="#Testimonial">Contributors</Nav.Link>
    </Nav>
    <Nav>
    <Nav.Link >
                <Link to="login" className="navbar__link">
                    Register
                </Link>
      </Nav.Link>
      <Nav.Link eventKey={2} >
                <Link to="login" className="navbar__link">
                    Login
                </Link>
      </Nav.Link>
    </Nav>
  </Navbar.Collapse>
  </Container>
</Navbar>
        </div>
    )
}

export default NavBar
