import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import $ from 'jquery';

class App extends Component {

/* global token */
/* global ip */

  componentDidMount() {
    $.ajax({
      url: 'http://' + ip + '/api/v1/status',
      type: 'POST',
      data: { "token": token },
      error: function (xhr, status, err) {
        console.error(status, err.toString());
      }
    });
  }
    
    
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
