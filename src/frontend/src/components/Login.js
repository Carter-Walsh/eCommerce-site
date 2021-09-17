import React, { useState } from "react";
import "../styles/Login.css";
import axios from "axios";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";

const Login = ({ handleSubmit }) => {

    const [emailAddress, setEmailAddress] = useState("");
    const [password, setPassword] = useState("");

    const onEmailChange = (event) => {
        setEmailAddress(event.target.value);
    }
    
    const onPasswordChange = (event) => {
        setPassword(event.target.value);
    }
    
    const handleSubmitLogin = (event) => {
        event.preventDefault();
        axios.get("http://localhost:8080/login", {
            params: {
                emailAddress: emailAddress,
                password: password
            }
        }).then((res) => {
            console.log(res.data);
            handleSubmit(res.data);
        }, (err) => {
            console.log(err);
        });
    }

  return (
    <Container className="form d-flex justify-content-center align-items-center">
      <Form onSubmit={handleSubmitLogin}>
        <h1 className="mb-3">Welcome to the eCommerce site!</h1>
        <h3 className="mb-3">Please sign in below</h3>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Email address</Form.Label>
          <Form.Control type="email" placeholder="Enter email" value={emailAddress} onChange={onEmailChange} />
          <Form.Text className="text-muted">
            We'll never share your email with anyone else.
          </Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" placeholder="Password" value={password} onChange={onPasswordChange} />
        </Form.Group>
        <Button variant="primary" type="submit">Submit</Button>
        <Button variant="primary" href="/register">Register</Button>
      </Form>
    </Container>
  );
};

export default Login;
