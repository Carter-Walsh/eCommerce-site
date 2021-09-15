import React from "react";
import Card from "react-bootstrap/Card";
import CardImg from "react-bootstrap/CardImg";
import Button from "react-bootstrap/Button";

const Product = ({ product }) => {
  return (
    <div>
      <Card key={product.productId} style={{ width: "18rem" }}>
        <Card.Body>
          <a href={`/product/${product.productId}`}>
            <CardImg
              className="homepage-product-image"
              src={product.imageUrl}
            />
          </a>
          <Card.Title>{product.productName}</Card.Title>
          <Card.Text>{product.product}</Card.Text>
          <Card.Text>${product.price}</Card.Text>
          <Button href={`/product/${product.productId}`} variant="primary">
            View Product
          </Button>
        </Card.Body>
      </Card>
    </div>
  );
};

export default Product;
