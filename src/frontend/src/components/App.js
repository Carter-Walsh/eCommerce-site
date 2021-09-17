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

  const handleSubmit = (result) => {
    setLoginResponse(result);
  };

  return (
    <Router>
      <Switch>
        <Route exact path="/register" component={Register} />
        {/* <Route exact path="/login" component={Login} /> */}
        <Route exact path="/product/:productId" component={DetailProductPage} />
        <Route
          exact
          path="/products/search/:query"
          component={ProductSearchResults}
        />
        <Route exact path={["/", "/login"]}>
          {loginResponse ? <Homepage /> : <Login handleSubmit={handleSubmit} />}
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
