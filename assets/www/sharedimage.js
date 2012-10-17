cordova.addConstructor(
    function () {
        cordova.exec(
            function () {
                console.log("Initialized SendImage");
            },
            function (reason) {
                alert("Failed to initialize SendImage " + reason);
            },
            "SharedImage", "init", []
        );
    }
);

var sharedimage = {
  shared: function(callback, success, fail) {
    document.addEventListener("sharedimage", callback, false);
    cordova.exec(callback, fail, "SharedImage", "registerShared", []);
  }
};
