package net.pubnative.lite.sdk.contentinfo;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class FeedbackMacros {
    private static final String MACRO_AD_FORMAT = "[ADFORMAT]";
    public static final String MACRO_APP_TOKEN = "[APPTOKEN]";
    private static final String MACRO_APP_VERSION = "[APPVERSION]";
    private static final String MACRO_AUDIO_STATE = "[AUDIOSTATE]";
    private static final String MACRO_CREATIVE_ID = "[CREATIVEID]";
    private static final String MACRO_DEVICE_INFO = "[DEVICEINFO]";
    private static final String MACRO_HAS_END_CARD = "[HASENDCARD]";
    private static final String MACRO_IMPRESSION_BEACON = "[IMPRESSIONBEACON]";
    private static final String MACRO_INTEGRATION_TYPE = "[INTEGRATIONTYPE]";
    private static final String MACRO_SDK_VERSION = "[SDKVERSION]";
    private static final String MACRO_ZONE_ID = "[ZONEID]";

    public String processUrl(String str, AdFeedbackData adFeedbackData) {
        if (adFeedbackData == null) {
            return str;
        }
        if (!TextUtils.isEmpty(adFeedbackData.getAppToken())) {
            str = str.replace(MACRO_APP_TOKEN, adFeedbackData.getAppToken());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getSdkVersion())) {
            str = str.replace(MACRO_SDK_VERSION, adFeedbackData.getSdkVersion());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getAppVersion())) {
            str = str.replace(MACRO_APP_VERSION, adFeedbackData.getAppVersion());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getAdFormat())) {
            str = str.replace(MACRO_AD_FORMAT, adFeedbackData.getAdFormat());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getIntegrationType())) {
            str = str.replace(MACRO_INTEGRATION_TYPE, adFeedbackData.getIntegrationType());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getZoneId())) {
            str = str.replace(MACRO_ZONE_ID, adFeedbackData.getZoneId());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getAudioState())) {
            str = str.replace(MACRO_AUDIO_STATE, adFeedbackData.getAudioState());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getDeviceInfo())) {
            str = str.replace(MACRO_DEVICE_INFO, adFeedbackData.getDeviceInfo());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getCreativeId())) {
            str = str.replace(MACRO_CREATIVE_ID, adFeedbackData.getCreativeId());
        }
        if (!TextUtils.isEmpty(adFeedbackData.getImpressionBeacon())) {
            str = str.replace(MACRO_IMPRESSION_BEACON, adFeedbackData.getImpressionBeacon());
        }
        return !TextUtils.isEmpty(adFeedbackData.getHasEndCard()) ? str.replace(MACRO_HAS_END_CARD, adFeedbackData.getHasEndCard()) : str;
    }
}
