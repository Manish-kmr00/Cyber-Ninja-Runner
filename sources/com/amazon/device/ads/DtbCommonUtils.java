package com.amazon.device.ads;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Looper;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.applovin.sdk.AppLovinMediationProvider;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class DtbCommonUtils {
    private static final String IAB_GPP_SID = "gpp_sid";
    private static final String IAB_GPP_STRING = "gpp";
    private static String sdkFlavor;

    private DtbCommonUtils() {
    }

    static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static String getURLEncodedString(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            DtbLog.debugError("Unable to url encode :" + str);
            return str;
        }
    }

    public static String getSDKMRAIDVersion() {
        String sDKFlavor = getSDKFlavor();
        if (sDKFlavor == null) {
            return "aps-android";
        }
        return "aps-android-" + sDKFlavor;
    }

    static String getSDKVersion() {
        String sDKFlavor = getSDKFlavor();
        if (sDKFlavor == null) {
            return "aps-android-9.10.4";
        }
        return "aps-android-9.10.4-" + sDKFlavor;
    }

    /* JADX INFO: Removed unreachable split cross block B:26:0x0036 */
    static String getSDKFlavor() {
        String str = sdkFlavor;
        if (str != null) {
            return str;
        }
        for (String str2 : AdRegistration.serverlessMarkers) {
            try {
                Class.forName(str2);
                if (str2.contains("admob")) {
                    sdkFlavor = "admob";
                    break;
                }
                if (str2.contains(AppLovinMediationProvider.MOPUB)) {
                    sdkFlavor = AppLovinMediationProvider.MOPUB;
                    break;
                }
                if (!str2.contains("applovin")) {
                    break;
                }
                sdkFlavor = "MAX";
                break;
            } catch (Exception unused) {
            }
        }
        Map<String, String> customDictionary = AdRegistration.getCustomDictionary();
        if (!isNullOrEmpty(customDictionary)) {
            String str3 = customDictionary.get(DtbConstants.MEDIATION_NAME);
            if (!isNullOrEmpty(str3)) {
                sdkFlavor = str3;
            }
        }
        return sdkFlavor;
    }

    public static String getSDKFramework() {
        try {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
            return "unity";
        } catch (ClassNotFoundException unused) {
            return "native";
        }
    }

    static boolean isOnMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            DtbLog.debugError("Exception parsing the integer from string:" + str);
            return i;
        }
    }

    static Bundle getApplicationBundle() throws PackageManager.NameNotFoundException {
        if (AdRegistration.getContext() == null) {
            throw new IllegalStateException("Application Context can't be null");
        }
        return AdRegistration.getContext().getPackageManager().getApplicationInfo(AdRegistration.getContext().getPackageName(), 128).metaData;
    }

    static InputStream getResourceAsStream(String str) {
        return DtbCommonUtils.class.getResourceAsStream(str);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    static boolean isNullOrEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    static boolean isNullOrEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNullOrWhiteSpace(String str) {
        return isNullOrEmpty(str) || str.trim().equals("");
    }

    static long getMilliSeconds(String str) {
        return Long.parseLong(str) * 1000;
    }

    static boolean isActivityDestroyed(Activity activity) {
        return activity.isDestroyed();
    }

    static String getParamsAsJsonString(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            jSONObject.put(str, map.get(str));
        }
        return jSONObject.toString();
    }

    static JSONObject getParamsAsJson(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            jSONObject.put(str, map.get(str));
        }
        return jSONObject;
    }

    static String exceptionToString(Exception exc) {
        String localizedMessage = exc.getLocalizedMessage();
        return localizedMessage != null ? "(" + localizedMessage + ")" : "";
    }

    static String getStringFieldValue(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            if (declaredField.isAccessible()) {
                return (String) declaredField.get(null);
            }
            DtbLog.debug("Field:" + str2 + " is not accessable");
            return null;
        } catch (ClassNotFoundException unused) {
            DtbLog.debug("Class not found:" + str);
            return null;
        } catch (IllegalAccessException e) {
            DtbLog.debug("Illegal Access exception:" + e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            DtbLog.debug("Illegal Argument exception:" + e2.getMessage());
            return null;
        } catch (NoSuchFieldException unused2) {
            DtbLog.debug("Field:" + str2 + " does not exist");
            return null;
        } catch (SecurityException unused3) {
            DtbLog.debug("Field:" + str2 + " is not accessable");
            return null;
        }
    }

    static Integer getIntegerFieldValue(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            if (declaredField.isAccessible()) {
                return (Integer) declaredField.get(null);
            }
            DtbLog.debug("Field:" + str2 + " is not accessable");
            return null;
        } catch (ClassNotFoundException unused) {
            DtbLog.debug("Class notFound:" + str);
            return null;
        } catch (IllegalAccessException e) {
            DtbLog.debug("Illegal Access exception:" + e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            DtbLog.debug("Illegal Argument exception:" + e2.getMessage());
            return null;
        } catch (NoSuchFieldException unused2) {
            DtbLog.debug("Field:" + str2 + " does not exist");
            return null;
        } catch (SecurityException unused3) {
            DtbLog.debug("Field:" + str2 + " is not accessable");
            return null;
        }
    }

    static class APIVersion {
        public int majorVersion = 0;
        public int minorVersion = 0;

        APIVersion() {
        }
    }

    static APIVersion getAPIVersion(String str) {
        String strNextToken;
        APIVersion aPIVersion = new APIVersion();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : str;
            if (!stringTokenizer.hasMoreTokens()) {
                strNextToken = "0";
            } else {
                strNextToken = stringTokenizer.nextToken();
            }
            try {
                aPIVersion.majorVersion = Integer.parseInt(strNextToken2);
                aPIVersion.minorVersion = Integer.parseInt(strNextToken);
            } catch (NumberFormatException unused) {
                DtbLog.warn("Invalid API version:" + str);
            }
        }
        return aPIVersion;
    }

    static boolean isNetworkConnected() {
        Network activeNetwork;
        if (AdRegistration.getContext() == null || AdRegistration.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) AdRegistration.getContext().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null) {
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1);
                }
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "failed to get network capabilities in DtbCommonUtils.isNetworkConnected", e);
                return true;
            }
        }
        return false;
    }

    static String getHostNameFromUrl(String str) {
        if (!str.startsWith("https://") && !str.startsWith(d.v)) {
            str = "https://" + str;
        }
        try {
            return new URI(str).getHost();
        } catch (Exception unused) {
            DtbLog.error(String.format("The url %s that is passed for parsing is invalid. Please check the URL", new Object[0]));
            return null;
        }
    }

    static DTBAdRequest createAutoRefreshAdLoader(DTBAdRequest dTBAdRequest) {
        DTBAdRequest dTBAdRequest2 = new DTBAdRequest();
        if (!isNullOrEmpty(dTBAdRequest.getAdSizes())) {
            dTBAdRequest2.setAdSizes(dTBAdRequest.getAdSizes());
        }
        if (!isNullOrEmpty(dTBAdRequest.getSlotGroupName())) {
            dTBAdRequest2.setSlotGroup(dTBAdRequest.getSlotGroupName());
        }
        if (!isNullOrEmpty(dTBAdRequest.getCustomTargets())) {
            dTBAdRequest2.setCustomTargets(dTBAdRequest.getCustomTargets());
        }
        dTBAdRequest2.setRefreshFlag(true);
        return dTBAdRequest2;
    }

    public static Bundle initializeEmptyBundle() {
        return new Bundle();
    }

    static HashMap<String, Object> addGPPParametersFromPreferences(SharedPreferences sharedPreferences) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            Object obj = sharedPreferences.contains("IABGPP_HDR_GppString") ? sharedPreferences.getAll().get("IABGPP_HDR_GppString") : null;
            if ((obj instanceof String) && !isNullOrEmpty((String) obj)) {
                map.put("gpp", (String) obj);
            }
            Object obj2 = sharedPreferences.contains("IABGPP_GppSID") ? sharedPreferences.getAll().get("IABGPP_GppSID") : null;
            if ((obj2 instanceof String) && !isNullOrEmpty((String) obj2)) {
                JSONArray jSONArray = new JSONArray();
                Matcher matcher = Pattern.compile("\\d+").matcher((String) obj2);
                while (matcher.find()) {
                    for (int i = 0; i <= matcher.groupCount(); i++) {
                        jSONArray.put(Integer.parseInt(matcher.group(i)));
                    }
                }
                if (jSONArray.length() > 0) {
                    map.put("gpp_sid", jSONArray);
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to get Global privacy platform params from shared preference", e);
        }
        return map;
    }
}
