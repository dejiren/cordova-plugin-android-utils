var NotificationChannel = function (channelJSON) {
    for (var property in channelJSON) {
      if (channelJSON.hasOwnProperty(property)) {
        this[property] = channelJSON[property];
      }
    }
  },
  NotificationManager = function () {};

NotificationManager.SERVICE_NAME = "NotificationSettingManager";

/**
 * getNotificationChannel
 *
 * @param {string} channelId
 */
NotificationManager.getNotificationChannel = function (channelId) {
  return new Promise(function (onSuccess, onFail) {
    cordova.exec(
      function (channelJSON) {
        onSuccess(new NotificationChannel(channelJSON));
      },
      onFail,
      NotificationManager.SERVICE_NAME,
      "getNotificationChannel",
      [channelId]
    );
  });
};

/**
 * openAppNotificationSettings
 *
 * @param {string} channelId
 */
NotificationManager.openAppNotificationSettings = function (channelId) {
  return new Promise(function (onSuccess, onFail) {
    cordova.exec(onSuccess, onFail, NotificationManager.SERVICE_NAME, "openAppNotificationSettings");
  });
};

/**
 * openNotificationChannelSettings
 *
 * @param {string} channelId
 */
NotificationManager.openNotificationChannelSettings = function (channelId) {
  return new Promise(function (onSuccess, onFail) {
    cordova.exec(
      function (channelJSON) {
        onSuccess(new NotificationChannel(channelJSON));
      },
      onFail,
      NotificationManager.SERVICE_NAME,
      "openNotificationChannelSettings",
      [channelId]
    );
  });
};

module.exports = NotificationManager;
