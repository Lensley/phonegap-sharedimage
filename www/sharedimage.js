cordova.define("phonegap-sharedimage.sharedimage", function(require, exports, module) {
  function SharedImage() {
  }

  SharedImage.prototype.shared = function(callback, success, fail) {
    document.addEventListener("sharedimage", callback, false);
    cordova.exec(callback, fail, "SharedImage", "registerShared", []);
  };

  module.exports = new SharedImage();
});
