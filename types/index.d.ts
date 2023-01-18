declare interface Env {
  getDirectory(path: any): Promise<any>;
}

declare interface MediaScanner {
  scanFile(fileUri: any): Promise<any>;
}

declare interface NotificationManager {
  getNotificationChannel(channelId: string): Promise<any>;
  openAppNotificationSettings(channelId: string): Promise<any>;
  openNotificationChannelSettings(channelId: string): Promise<any>;
}

interface CordovaPlugins {
  androidEnv: Env;
  androidMediaScanner: MediaScanner;
  androidNotificationManager: NotificationManager;
}
