import React, { useEffect, useState } from "react";
import Product from "./Product";
import NavigationBar from "./NavigationBar";
import axios from "axios";

const ProductSearchResults = ({ searchQuery }) => {
  const [userSearchResults, setUserSearchResults] = useState([]);

  // makes a request for the specific search term that the user typed in
  useEffect(() => {
    axios
      .get(`http://localhost:8080/search?query=${searchQuery}`)
      .then((res) => {
        setUserSearchResults(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [searchQuery]);

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
      {displayUserSearchResults}
    </div>
  );
};

export default ProductSearchResults;
