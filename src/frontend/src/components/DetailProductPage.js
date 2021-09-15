import React, { useEffect, useState } from "react";
import axios from "axios";
import "../styles/DetailProductPage.css";
import Row from "react-bootstrap/esm/Row";
import Col from "react-bootstrap/Col";
import Container from "react-bootstrap/esm/Container";
import Image from "react-bootstrap/Image";

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
    <div className="product-container">
      <Container>
        <div className="title">
          <h1>{product.productName}</h1>
        </div>

        <Row gutter={[16, 16]}>
          <Col>
            <div className="details-container">
              <Image className="product-details-image" src={product.imageUrl} />
            </div>
          </Col>
          <Col>
            <div className="details-container">
              <p className="product-details-text">${product.price}</p>
              <p className="product-details-text">Brand: {product.brand}</p>
              <p className="product-details-text">
                Availability: {product.availability}
              </p>
              <p className="product-details-text">
                Categories: {product.categories}
              </p>
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default DetailProductPage;
