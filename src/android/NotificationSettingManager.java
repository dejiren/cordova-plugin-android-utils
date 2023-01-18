package dejiren.cordova.environment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class NotificationSettingManager extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if ("getNotificationChannel".equals(action)) {
                callbackContext.success(getNotificationChannel(args.getString(0)));
                return true;
            } else if ("openNotificationChannelSettings".equals(action)) {
                openNotificationChannelSettings(args.getString(0));
                callbackContext.success();
                return true;
            } else if ("openAppNotificationSettings".equals(action)) {
                openAppNotificationSettings();
                callbackContext.success();
                return true;
            }
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }

        return false;
    }

    @TargetApi(26)
    private void openAppNotificationSettings() {
        final Activity activity = this.cordova.getActivity();
        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, activity.getPackageName());
        activity.startActivity(intent);
    }

    @TargetApi(26)
    private void openNotificationChannelSettings(String channelId) {
        final Activity activity = this.cordova.getActivity();
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, activity.getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        activity.startActivity(intent);
    }

    /**
     * See: https://developer.android.com/training/notify-user/channels#ReadChannel
     **/
    @TargetApi(26)
    private JSONObject getNotificationChannel(String channelId) throws JSONException {
        JSONObject channelJSON = new JSONObject();

        final Activity activity = this.cordova.getActivity();
        final NotificationManager manager = (NotificationManager) activity
                .getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationChannel channel = manager.getNotificationChannel(channelId);

        channelJSON.put("id", channel.getId());
        channelJSON.put("group", channel.getGroup());
        channelJSON.put("description", channel.getDescription());
        channelJSON.put("importance", channel.getImportance());
        channelJSON.put("lightColor", channel.getLightColor());
        channelJSON.put("lockscreenVisibility", channel.getLockscreenVisibility());

        return channelJSON;
    }
}
