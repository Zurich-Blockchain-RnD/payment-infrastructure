// This file contains a fix for including "crypto" library into the webpack.config
// It will be called after installing all dependencies

const fs = require("fs");
const file = "node_modules/@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs/browser.js";

fs.readFile(file, "utf8", function (error,data) {
  if (error) {
    return console.log(error);
  }
  var result = data.replace(/node: false/g, "node: {crypto: true, stream: true, fs: 'empty'}");

  fs.writeFile(file, result, "utf8", function (error) {
    if (error) return console.log(error);
  });
});