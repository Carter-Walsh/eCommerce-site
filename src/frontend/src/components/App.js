import React, { useState } from "react";
import Login from "./Login";
import Homepage from "./Homepage";
import DetailProductPage from "./DetailProductPage";
import Register from "./Register";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "../styles/App.css";
import ProductSearchResults from "./ProductSearchResults";

function App() {
  const [loginResponse, setLoginResponse] = useState();
  const [searchQuery, setSearchQuery] = useState("");

  const handleLogin = (result) => {
    setLoginResponse(result);
  };

  // sets state equal to search term the user typed in that it received from <Homepage />
  const handleSubmit = (search) => {
    setSearchQuery(search);
  };

  return (
    <Router>
      <Switch>
        <Route exact path="/register">
          <Register />
        </Route>
        <Route
          exact
          path="/product/:productId"
          component={DetailProductPage}
        ></Route>
        <Route exact path="/products/search">
          <ProductSearchResults searchQuery={searchQuery} />
        </Route>
        <Route exact path="/">
          {loginResponse ? <Homepage /> : <Login onLoginSubmit={handleLogin} />}
          <Homepage handleSubmit={handleSubmit} />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
