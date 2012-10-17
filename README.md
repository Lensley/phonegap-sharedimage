# PhoneGap Shared Image Plugin

This plugin will allow your app to receive shared image intents easily.

## Requirements
This plugin has been tested to work w/ [PhoneGap](http://phonegap.com/download) 2.1.0

## Installing the Plugin

Copy `src` and `assets` into your project folders. This is the plugin.

Update `<plugins>` in `res/xml/config.xml`:

  <plugin name="SharedImage" value="com.lensley.phonegap.SharedImage" />


## Example Usage

An example of using the code (put this in your `deviceready` callback):

  sharedimage.shared(function(e) {
    // the media path
    console.log("IMAGE: " + e.img);

    // actual file name
    window.resolveLocalFileSystemURI(e.img, function(imgfile) {
      console.log("FILENAME: " + imgfile.name);
    });
  }
