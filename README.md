# PhoneGap Shared Image Plugin
By Leonard Lin

This plugin will allow your app to receive shared image intents easily.

## Requirements
This plugin has been tested to work w/ [PhoneGap](http://phonegap.com/download) 2.1.0

## Installing the Plugin

Copy `src` and `assets` into your project folders. This is the plugin.

Update `<plugins>` in `res/xml/config.xml`:

  <plugin name="SharedImage" value="com.lensley.phonegap.SharedImage" />


## Usage

First you'll need to install the appropriate Intent in your `AndroidManifest.xml`:

  <intent-filter>
    <action android:name="android.intent.action.SEND" />
    <data android:mimeType="image/*" />
    <category android:name="android.intent.category.DEFAULT" />
  </intent-filter>


Then in your PhoneGap app, add a Handler (put this in your `deviceready` callback):

  sharedimage.shared(function(e) {
    // the media uri - e.img is the only attribute
    console.log("IMAGE: " + e.img);

    // actual file name
    window.resolveLocalFileSystemURI(e.img, function(imgfile) {
      console.log("FILENAME: " + imgfile.name);
    });
  }

That's about it.

## Mentions

The skeleton of the code was pulled from [phonegap-nfc](https://github.com/chariotsolutions/phonegap-nfc). I wrote this because [WebIntent](https://github.com/phonegap/phonegap-plugins/tree/master/Android/WebIntent) was bugging out in conjunction with phonegap-nfc. 

## License
The MIT License

Copyright (c) 2012 Leonard Lin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
