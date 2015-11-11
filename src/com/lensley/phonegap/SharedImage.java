package com.lensley.phonegap;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;

import java.text.MessageFormat;

public class SharedImage extends Plugin {
  private static final String TAG = "SharedImagePlugin";
  private static final String INIT = "init";
  private static final String SHARED_IMAGE_EVENT = "sharedimage";
    
  public PluginResult execute(String action, JSONArray args, String callbackId) {
    Log.d(TAG, "execute " + action);
        
    // Init
    if (action.equalsIgnoreCase(INIT)) {
      Log.d(TAG, "Enabling plugin");

      // Sometimes there's an intent and onNewIntent doesn't get fired?
      Intent intent = this.cordova.getActivity().getIntent();
      if(intent != null) {
        this.onNewIntent(intent);
      }

      return new PluginResult(Status.OK);
    }  
    return new PluginResult(PluginResult.Status.INVALID_ACTION);
  }
 
  public void onNewIntent(Intent intent) {
    Log.d(TAG, "onNewIntent " + intent);
        
    // Parse
    String action = intent.getAction();
    Log.d(TAG, "action: " + action);
    String type = intent.getType();
    if (Intent.ACTION_SEND.equals(action) && type != null) {
      if (type.startsWith("image/")) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
          Log.d(TAG, "imageUri: " + imageUri);
          sendSharedImage(imageUri.toString());
        }
      }
    }
  }
    
  private void sendSharedImage(String img) { 
    String javascriptTemplate = "var e = document.createEvent(''Events'');\n" +
                                "e.initEvent(''{0}'');\n" +
                                "e.img = ''{1}'';\n" +
                                "document.dispatchEvent(e);";
    String command = MessageFormat.format(javascriptTemplate, SHARED_IMAGE_EVENT, img);
    Log.d(TAG, command);
    this.sendJavascript(command);        
  }

}
