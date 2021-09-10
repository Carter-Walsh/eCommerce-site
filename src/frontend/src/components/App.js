import React, { useState } from "react";
import Login from "./Login";
import Homepage from "./Homepage";
import Register from "./Register";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "../styles/App.css";

function App() {
  const [loginResponse, setLoginResponse] = useState();

  const handleLogin = (result) => {
    setLoginResponse(result);
  };

  return (
    <Router>
      <Switch>
        <Route path="/register">
          <Register />
        </Route>
        <Route path="/">
          {loginResponse ? <Homepage /> : <Login onLoginSubmit={handleLogin} />}
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
