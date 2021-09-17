import React, { useEffect, useState } from "react";
import Product from "./Product";
import NavigationBar from "./NavigationBar";
import "../styles/ProductSearchResults.css";
import axios from "axios";

const ProductSearchResults = (props) => {
  const [userSearchResults, setUserSearchResults] = useState([]);
  const query = props.match.params.query;

  // makes a request for the specific search term that the user typed in
  useEffect(() => {
    axios
      .get(`http://localhost:8080/products/search?query=${query}`)
      .then((res) => {
        setUserSearchResults(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [query]);

  // maps through returned results in userSearchResults and creates a <Product /> for each
  const displayUserSearchResults = userSearchResults.map((product) => {
    return (
      <div key={product.productId}>
        <Product product={product} />
      </div>
    );
  });

  return (
    <div>
      <NavigationBar />
      <div className="products-container">
        {displayUserSearchResults}
      </div>
    </div>
  );
};

export default ProductSearchResults;
