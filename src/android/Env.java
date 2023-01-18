/*
The MIT License (MIT)

Copyright (c) 2014

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package dejiren.cordova.environment;

import android.os.Environment;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class Env extends CordovaPlugin {

    public static final String GET_DIRECTORY = "getDirectory";
    public static final String DIRECTORY_ALARMS = "Alarms";
    public static final String DIRECTORY_DCIM = "DCIM";
    public static final String DIRECTORY_DOCUMENTS = "Documents";
    public static final String DIRECTORY_DOWNLOADS = "Downloads";
    public static final String DIRECTORY_MOVIES = "Movies";
    public static final String DIRECTORY_MUSIC = "Music";
    public static final String DIRECTORY_NOTIFICATIONS = "Notifications";
    public static final String DIRECTORY_PICTURES = "Pictures";
    public static final String DIRECTORY_PODCASTS = "Podcasts";
    public static final String DIRECTORY_RINGTONES = "Ringtones";

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals(GET_DIRECTORY)) {
                final String strDir = args.getString(0);
                cordova.getThreadPool().execute(
                        new Runnable() {
                            public void run() {
                                final String results = getDirectory(strDir);
                                callbackContext.success(results);
                            }
                        });
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.w("Env", e.getMessage());
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        }
        return true;
    }

    private String getDirectory(String path) {
        String result = "";
        if (path.equals(DIRECTORY_ALARMS)) {
            result = Environment.DIRECTORY_ALARMS;
        } else if (path.equals(DIRECTORY_DCIM)) {
            result = Environment.DIRECTORY_DCIM;
        } else if (path.equals(DIRECTORY_DOCUMENTS)) {
            result = Environment.DIRECTORY_DOCUMENTS;
        } else if (path.equals(DIRECTORY_DOWNLOADS)) {
            result = Environment.DIRECTORY_DOWNLOADS;
        } else if (path.equals(DIRECTORY_MOVIES)) {
            result = Environment.DIRECTORY_MOVIES;
        } else if (path.equals(DIRECTORY_MUSIC)) {
            result = Environment.DIRECTORY_MUSIC;
        } else if (path.equals(DIRECTORY_NOTIFICATIONS)) {
            result = Environment.DIRECTORY_NOTIFICATIONS;
        } else if (path.equals(DIRECTORY_PICTURES)) {
            result = Environment.DIRECTORY_PICTURES;
        } else if (path.equals(DIRECTORY_PODCASTS)) {
            result = Environment.DIRECTORY_PODCASTS;
        } else if (path.equals(DIRECTORY_RINGTONES)) {
            result = Environment.DIRECTORY_RINGTONES;
        }
        return result;
    }

}
