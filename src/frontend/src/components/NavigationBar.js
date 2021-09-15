import React, { useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";

const NavigationBar = ({ handleHomepageSubmit }) => {
  const [userSearchInput, setUserSearch] = useState("");

  // sets state equal to whatever the user typed in to the search bar
  const onUserInputChange = (event) => {
    setUserSearch(event.target.value);
  };

  // calls handleSubmit which was passed down by <Homepage /> and passes it the search term the user typed in
  const handleNavBarSubmit = (event) => {
    event.preventDefault();
    handleHomepageSubmit(userSearchInput);
  };

  return (
    <div>
      <Navbar collapseOnSelect expand="lg" bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="/">eCommerce Site</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="#features">What's New</Nav.Link>
              <Nav.Link href="#pricing">Profile</Nav.Link>
              <NavDropdown title="Categories" id="collasible-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">
                  Electronics
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Headphones
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Computers
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
            <Nav>
              <Form onSubmit={handleNavBarSubmit} className="d-flex">
                <FormControl
                  type="search"
                  placeholder="Search"
                  className="mr-2"
                  aria-label="Search"
                  onChange={onUserInputChange}
                  value={userSearchInput}
                />
                <Button
                  type="submit"
                  href="/products/search"
                  variant="outline-light"
                >
                  Search
                </Button>
              </Form>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavigationBar;
