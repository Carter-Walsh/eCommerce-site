import React, { useEffect, useState } from "react";
import axios from "axios";
import "../styles/DetailProductPage.css";
import Row from "react-bootstrap/esm/Row";
import Col from "react-bootstrap/Col";
import Container from "react-bootstrap/esm/Container";
import Image from "react-bootstrap/Image";
import NavigationBar from "./NavigationBar";
import Button from "react-bootstrap/Button";

const DetailProductPage = (props) => {
  const productId = props.match.params.productId;
  const [product, setProduct] = useState([]);

  // makes request for the single product that was clicked
  useEffect(() => {
    axios
      .get(`http://localhost:8080/product?id=${productId}`)
      .then((res) => {
        setProduct(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [productId]);

  return (
    <div>
      <NavigationBar />
      <div className="product-container">
        <Container>
          <Row gutter={[16, 16]}>
            <Col>
              <div className="image-container">
                <Image
                  className="product-details-image"
                  src={product.imageUrl}
                />
              </div>
            </Col>
            <Col>
              <div className="details-container">
                <h1>{product.productName}</h1>
                <p className="green-text">Availability: {product.availability}</p>
                <p className="product-details-text" style={{fontWeight: 'bold'}}>
                  ${product.price}
                </p>
                <p  style={{fontSize: '1rem', paddingBottom: '3rem'}}>Save 5% every day with eCommerceology <a href="http://google.com">loyalty card!</a></p>
                  <Button variant="primary" type="submit">
                    Add to Cart
                  </Button>
                  <p className="green-text" style={{paddingTop: '1rem'}}>Get it by Saturday, September 25th!</p>
                  <p style={{textDecoration: 'underline', opacity: '.7', cursor: 'pointer'}}>Edit your location</p>
              </div>
            </Col>
          </Row>
        </Container>
      </div>
    </div>
  );
};

export default DetailProductPage;
