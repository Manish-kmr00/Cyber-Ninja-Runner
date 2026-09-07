package net.pubnative.lite.sdk.contentinfo;

import android.text.TextUtils;
import java.util.Locale;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.utils.string.StringEscapeUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FeedbackJSInterface {
    private static final String JS_PARAM_AD_FORMAT = "adFormat";
    private static final String JS_PARAM_APP_TOKEN = "appToken";
    private static final String JS_PARAM_APP_VERSION = "appVersion";
    private static final String JS_PARAM_AUDIO_STATE = "audioState";
    private static final String JS_PARAM_CREATIVE = "creative";
    private static final String JS_PARAM_CREATIVE_ID = "creativeId";
    private static final String JS_PARAM_DEVICE_INFO = "deviceInfo";
    private static final String JS_PARAM_HAS_END_CARD = "hasEndCard";
    private static final String JS_PARAM_IMPRESSION_BEACON = "impressionBeacon";
    private static final String JS_PARAM_INTEGRATION_TYPE = "integrationType";
    private static final String JS_PARAM_SDK_VERSION = "sdkVersion";
    private static final String JS_PARAM_ZONE_ID = "zoneId";
    private static final String JS_VAR = "hybidFeedback";
    private static final String TAG = "FeedbackJSInterface";

    private String buildJS(AdFeedbackData adFeedbackData) {
        StringBuilder sb = new StringBuilder();
        if (adFeedbackData != null) {
            if (!TextUtils.isEmpty(adFeedbackData.getAppToken())) {
                sb.append(getJSFunction(JS_PARAM_APP_TOKEN, adFeedbackData.getAppToken()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getZoneId())) {
                sb.append(getJSFunction(JS_PARAM_ZONE_ID, adFeedbackData.getZoneId()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getAudioState())) {
                sb.append(getJSFunction(JS_PARAM_AUDIO_STATE, adFeedbackData.getAudioState()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getAppVersion())) {
                sb.append(getJSFunction("appVersion", adFeedbackData.getAppVersion()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getDeviceInfo())) {
                sb.append(getJSFunction("deviceInfo", adFeedbackData.getDeviceInfo()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getCreativeId())) {
                sb.append(getJSFunction("creativeId", adFeedbackData.getCreativeId()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getImpressionBeacon())) {
                sb.append(getJSFunction(JS_PARAM_IMPRESSION_BEACON, adFeedbackData.getImpressionBeacon()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getSdkVersion())) {
                sb.append(getJSFunction("sdkVersion", adFeedbackData.getSdkVersion()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getIntegrationType())) {
                sb.append(getJSFunction(JS_PARAM_INTEGRATION_TYPE, adFeedbackData.getIntegrationType()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getAdFormat())) {
                sb.append(getJSFunction("adFormat", adFeedbackData.getAdFormat()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getHasEndCard())) {
                sb.append(getJSFunction(JS_PARAM_HAS_END_CARD, adFeedbackData.getHasEndCard()));
            }
            if (!TextUtils.isEmpty(adFeedbackData.getCreative())) {
                sb.append(getJSFunction("creative", StringEscapeUtils.escapeJava(adFeedbackData.getCreative())));
            }
        }
        return sb.toString();
    }

    public void submitData(AdFeedbackData adFeedbackData, MRAIDView mRAIDView) {
        if (adFeedbackData != null) {
            String strBuildJS = buildJS(adFeedbackData);
            if (mRAIDView == null || TextUtils.isEmpty(strBuildJS)) {
                return;
            }
            mRAIDView.injectJavaScript(strBuildJS);
        }
    }

    private String getJSFunction(String str, String str2) {
        return String.format(Locale.ENGLISH, "%s.%s = \"%s\";", JS_VAR, str, str2);
    }
}
