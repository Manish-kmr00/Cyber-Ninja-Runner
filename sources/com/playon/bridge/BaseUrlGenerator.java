package com.playon.bridge;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.json.b9;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.LocationUtil;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public class BaseUrlGenerator {
    protected static final String AD_TYPE = "ad_type";
    protected static final String API_ID = "api_key";
    protected static final String APP_ENGINE_NAME = "engine_name";
    protected static final String APP_ENGINE_VERSION = "engine_ver";
    protected static final String CONSENT_STATUS = "consent";
    protected static final String CONSENT_STRING = "consent_str";
    protected static final String COPPA = "coppa";
    protected static final String DEVICE_AUDIO_INPUT = "device_audio_input";
    protected static final String DEVICE_AUDIO_OUTPUT = "device_audio_output";
    protected static final String DEVICE_BATTERY_LEVEL = "device_battery_level";
    protected static final String DEVICE_BATTERY_STATE = "device_battery_state";
    protected static final String DEVICE_INPUT_LANGUAGE = "device_input_language";
    protected static final String DEVICE_LANGUAGE = "device_language";
    protected static final String DEVICE_MANUFACTURER = "device_manufacturer";
    protected static final String DEVICE_MAXVOLUME_LEVEL = "max_volume";
    protected static final String DEVICE_MODEL = "device_model";
    protected static final String DEVICE_ORIENTATION = "device_orientation";
    protected static final String DEVICE_OS_VERSION = "device_os_version";
    protected static final String DEVICE_VOLUME_LEVEL = "current_volume";
    protected static final String LATITUDE = "lat";
    protected static final String LONGITUDE = "long";
    protected static final String NETWORK_TYPE = "network_type";
    protected static final String OPERATOR_NAME = "operator_name";
    protected static final String PACKAGE_ID = "package_id";
    protected static final String PLATFORM = "platform";
    protected static final String PLAYON_ID = "playon_id";
    protected static final String REGULATION_TYPE = "regulation_type";
    protected static final String REQUEST_ID = "request_id";
    protected static final String SDK_VERSION = "sdk_version";
    protected static final String USER_ID = "user_id";
    private static final String sServerHostname = "us-east-1.ingaa.xyz";
    private boolean mFirstParam;
    private final StringBuilder mStringBuilder = new StringBuilder("https").append("://us-east-1.ingaa.xyz/");
    private static final String TAG = Log.makeTag("AdUnit");
    private static String sEngineName = "native";
    private static String sEngineVersion = "0.0.0";
    private static final List<Map.Entry<String, String>> customAttributes = new ArrayList();

    public void initUrlString(String str) {
        this.mStringBuilder.append(str);
        this.mFirstParam = true;
    }

    public String getFinalUrlString() {
        return this.mStringBuilder.toString();
    }

    public static void addCustomAttribute(String str, String str2) {
        customAttributes.add(new AbstractMap.SimpleEntry(str, str2));
    }

    public static List<Map.Entry<String, String>> getCustomAttributes() {
        return customAttributes;
    }

    public static List<Map.Entry<String, String>> getCustomAttributes(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : customAttributes) {
            if (entry.getKey().equals(str)) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public static void clearCustomAttributes() {
        customAttributes.clear();
    }

    public static void removeCustomAttribute(String str) {
        for (int size = customAttributes.size() - 1; size >= 0; size--) {
            List<Map.Entry<String, String>> list = customAttributes;
            if (list.get(size).getKey().equals(str)) {
                list.remove(size);
            }
        }
    }

    protected void addParam(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mStringBuilder.append(getParamDelimiter());
        this.mStringBuilder.append(str);
        this.mStringBuilder.append("=");
        this.mStringBuilder.append(Uri.encode(str2));
    }

    public void addParam(String str, Boolean bool) {
        if (bool == null) {
            return;
        }
        this.mStringBuilder.append(getParamDelimiter());
        this.mStringBuilder.append(str);
        this.mStringBuilder.append("=");
        this.mStringBuilder.append(bool.booleanValue() ? "1" : "0");
    }

    private String getParamDelimiter() {
        if (this.mFirstParam) {
            this.mFirstParam = false;
            return "?";
        }
        return b9.i.c;
    }

    public static void setEngineInfo(String str, String str2) {
        sEngineName = str;
        sEngineVersion = str2;
    }

    public void appendApiKey() {
        addParam(API_ID, PlayOnManager.getInstance().getPersonalInfo().getApiKey());
    }

    public void appendAppInfo() {
        addParam(PACKAGE_ID, PlayOnManager.getInstance().getPersonalInfo().getApplicationID());
    }

    public void appendDeviceInfo() {
        addParam(DEVICE_MANUFACTURER, PlayOnManager.getInstance().getClientMetadata().getDeviceManufacturer());
        addParam(DEVICE_MODEL, PlayOnManager.getInstance().getClientMetadata().getDeviceModel());
        addParam(DEVICE_OS_VERSION, PlayOnManager.getInstance().getClientMetadata().getDeviceOsVersion());
        addParam(OPERATOR_NAME, PlayOnManager.getInstance().getClientMetadata().getSimOperatorName());
        addParam(NETWORK_TYPE, PlayOnManager.getInstance().getClientMetadata().getActiveNetworkType().name());
        addParam(DEVICE_LANGUAGE, PlayOnManager.getInstance().getClientMetadata().getCurrentLanguage());
        addParam("device_orientation", PlayOnManager.getInstance().getClientMetadata().getOrientationString());
        addParam(DEVICE_BATTERY_LEVEL, String.valueOf(PlayOnManager.getInstance().getClientMetadata().getDeviceBatteryLevel()));
        addParam(DEVICE_BATTERY_STATE, String.valueOf(PlayOnManager.getInstance().getClientMetadata().getDeviceBatteryState()));
        addParam(DEVICE_VOLUME_LEVEL, String.format("%.2f", Float.valueOf(PlayOnManager.getInstance().getClientMetadata().getDeviceVolumeLevel())));
        addParam(DEVICE_MAXVOLUME_LEVEL, StatisticData.ERROR_CODE_NOT_FOUND);
        for (String str : PlayOnManager.getInstance().getClientMetadata().getDeviceInputLanguages()) {
            addParam(DEVICE_INPUT_LANGUAGE, str);
        }
        for (String str2 : PlayOnManager.getInstance().getClientMetadata().getDeviceInputInfo()) {
            addParam(DEVICE_AUDIO_INPUT, str2);
        }
        for (String str3 : PlayOnManager.getInstance().getClientMetadata().getDeviceOutputInfo()) {
            addParam(DEVICE_AUDIO_OUTPUT, str3);
        }
    }

    public void appendSDKInfo() {
        addParam("sdk_version", "2.0.9");
        addParam("platform", "android");
    }

    public void appendEngineInfo() {
        addParam(APP_ENGINE_NAME, sEngineName);
        addParam(APP_ENGINE_VERSION, sEngineVersion);
    }

    public void appendPrivacyInfo() {
        addParam("user_id", PlayOnManager.getInstance().getPersonalInfo().getAdvertiserIdentifier());
        addParam(PLAYON_ID, PlayOnManager.getInstance().getPersonalInfo().getPlayOnIdentifier());
        PersonalInfoManager personalInfo = PlayOnManager.getInstance().getPersonalInfo();
        addParam("consent", Boolean.valueOf(personalInfo.isGeneralConsentGiven()));
        addParam(REGULATION_TYPE, personalInfo.getRegulationType().getValue());
        addParam("coppa", PlayOnManager.getInstance().getPersonalInfo().getIsChildDirected());
        String consentString = personalInfo.getConsentString();
        if (TextUtils.isEmpty(consentString)) {
            return;
        }
        addParam(CONSENT_STRING, consentString);
    }

    public void appendLocationInfo(Context context) {
        Location lastKnownNetworkLocation;
        if (!LocationUtil.isAnyLocationProviderEnabled(context) || (lastKnownNetworkLocation = LocationUtil.getLastKnownNetworkLocation(context)) == null) {
            return;
        }
        addParam("lat", String.valueOf(lastKnownNetworkLocation.getLatitude()));
        addParam("long", String.valueOf(lastKnownNetworkLocation.getLongitude()));
    }

    public void appendFreshRequestID() {
        addParam("request_id", UUID.randomUUID().toString());
    }

    /* JADX INFO: renamed from: com.playon.bridge.BaseUrlGenerator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$playon$bridge$AdUnit$AdUnitType;

        static {
            int[] iArr = new int[AdUnit.AdUnitType.values().length];
            $SwitchMap$com$playon$bridge$AdUnit$AdUnitType = iArr;
            try {
                iArr[AdUnit.AdUnitType.AudioBannerAd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnit.AdUnitType.AudioLogoAd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnit.AdUnitType.AudioRewardedBannerAd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$playon$bridge$AdUnit$AdUnitType[AdUnit.AdUnitType.AudioRewardedLogoAd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void appendAdType(AdUnit.AdUnitType adUnitType) {
        String str;
        int i = AnonymousClass1.$SwitchMap$com$playon$bridge$AdUnit$AdUnitType[adUnitType.ordinal()];
        if (i == 1) {
            str = "audio_banner_ad";
        } else if (i == 2) {
            str = "audio_logo_ad";
        } else if (i == 3) {
            str = "audio_rewarded_banner_ad";
        } else {
            str = i != 4 ? "no_type" : "audio_rewarded_logo_ad";
        }
        addParam("ad_type", str);
    }

    public void appendCustomAttributes() {
        for (Map.Entry<String, String> entry : customAttributes) {
            String str = "x-" + entry.getKey();
            String value = entry.getValue();
            if (this.mStringBuilder.toString().contains(str + "=")) {
                Log.w(TAG, "This key is already in use, rewriting default key set is not allowed");
            }
            addParam(str, value);
        }
    }
}
