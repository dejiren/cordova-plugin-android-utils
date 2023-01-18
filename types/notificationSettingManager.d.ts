export = NotificationManager;
declare function NotificationManager(): void;
declare namespace NotificationManager {
    const SERVICE_NAME: string;
    /**
     * getNotificationChannel
     *
     * @param {string} channelId
     */
    function getNotificationChannel(channelId: string): Promise<any>;
    /**
     * openAppNotificationSettings
     *
     * @param {string} channelId
     */
    function openAppNotificationSettings(channelId: string): Promise<any>;
    /**
     * openNotificationChannelSettings
     *
     * @param {string} channelId
     */
    function openNotificationChannelSettings(channelId: string): Promise<any>;
}
