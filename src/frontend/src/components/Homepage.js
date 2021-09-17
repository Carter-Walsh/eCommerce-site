import React, { useEffect, useState } from "react";
import Product from "./Product";
import NavigationBar from "./NavigationBar";
import Container from "react-bootstrap/Container";
import axios from "axios";
import "../styles/Homepage.css";

const Homepage = () => {
  const [homepageResults, setHomepageResults] = useState([]);

  // loads homepage products on startup
  useEffect(() => {
    axios
      .get("http://localhost:8080/homepage")
      .then((res) => {
        setHomepageResults(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  // maps through all returned products and passes them to the Product component. <Product /> will create a card for each
  const displayHomepageProductResults = homepageResults.map((product) => {
    return (
      <div key={product.productId}>
        <Product product={product} />
      </div>
    );
  });

  return (
    <div>
      <NavigationBar />

      <div className="sale-image-container">
        <img
          className="sale-image"
          src={
            "https://images.unsplash.com/photo-1607082349566-187342175e2f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2000&q=80"
          }
          alt="sale"
        />
      </div>

      <Container className="products-container">
        {displayHomepageProductResults}
      </Container>
    </div>
  );
};

export default Homepage;
