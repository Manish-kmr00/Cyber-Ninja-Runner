package com.amazon.aps.shared;

import android.content.Context;
import android.util.Log;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.shared.analytics.APSEvent;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.util.APSNetworkManager;
import com.amazon.aps.shared.util.APSSharedUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes11.dex */
public class APSAnalytics {
    private static final int ADDITIONAL_DETAILS_MAP_LIMIT = 20;
    private static final int ADDITIONAL_VALUE_SIZE_LIMIT = 100;
    public static final String BETA_HTTP_URL = "https://api.beta.sdklogger.publishers.advertising.a2z.com/logrecord/putlog";
    private static final String DEFAULT_API_KEY = "e9026ffd475a1a3691e6b2ce637a9b92aab1073ebf53a67c5f2583be8a804ecb";
    private static final int DEFAULT_SAMPLING_RATE = 1;
    public static final String DEFAULT_SDK_VERSION = "1.0";
    public static final String GAMMA_HTTP_URL = "https://gamma.cm.publishers.advertising.a2z.com/logrecord/putlog";
    private static final String HTTP_URL = "https://prod.cm.publishers.advertising.a2z.com/logrecord/putlog";
    public static final String OS_NAME = "Android";
    private static final int SAMPLING_LOWER_LIMIT = 0;
    private static final int SAMPLING_UPPER_LIMIT = 100;
    public static final String TAG = "APSAnalytics";
    private static String VERSION = "1.0";
    private static String adapterVersion;
    private static String additionalDetails;
    private static Map<String, String> additionalDetailsMap;
    private static String apiKey;
    private static Context context;
    private static boolean isSamplingAllowed;
    private static String url;

    public static void init(Context context2) {
        init(context2, 1, DEFAULT_API_KEY);
    }

    public static void init(Context context2, int i, String str) {
        context = context2;
        setApiKey(str);
        setSamplingRate(i);
        setHttpUrl(HTTP_URL);
        additionalDetails = "";
        adapterVersion = null;
        additionalDetailsMap = new HashMap();
    }

    public static void setApiKey(String str) {
        apiKey = getDefaultIfEmptyString(str, DEFAULT_API_KEY);
    }

    public static void setHttpUrl(String str) {
        url = getDefaultIfEmptyString(str, HTTP_URL);
    }

    public static String getHttpUrl() {
        return url;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static void setSamplingRate(int i) {
        boolean z = true;
        if (i < 0 || i > 100) {
            Log.e(TAG, "Invalid sampling rate - setting the default one");
            i = 1;
        }
        try {
            if (new Random().nextInt(100) + 1 > i) {
                z = false;
            }
            isSamplingAllowed = z;
        } catch (RuntimeException e) {
            Log.e(TAG, "Unable to set the sampling rate", e);
        }
    }

    public static void logEvent(APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, String str, Exception exc) {
        try {
            ApsLog.e(TAG, str + exc);
            if (!isInitialized()) {
                Log.d(TAG, "Analytics not initialized, and ignoring the event");
            } else {
                processEvent(new APSEvent(context, aPSEventSeverity, aPSEventType.name()).setExceptionDetails(exc).setErrorDetails(str).build());
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in processing the event: ", e);
        }
    }

    public static void logEvent(APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, Exception exc) {
        logEvent(aPSEventSeverity, aPSEventType, null, exc);
    }

    public static void logEvent(APSEventSeverity aPSEventSeverity, APSEventType aPSEventType, String str) {
        logEvent(aPSEventSeverity, aPSEventType, str, null);
    }

    private static void processEvent(APSEvent aPSEvent) {
        if (aPSEvent.getEventSeverity() == APSEventSeverity.FATAL) {
            processCriticalEvent(aPSEvent);
        }
    }

    public static boolean isIsSamplingAllowed() {
        return isSamplingAllowed;
    }

    public static boolean isInitialized() {
        return context != null && isSamplingAllowed;
    }

    private static void processCriticalEvent(APSEvent aPSEvent) {
        APSNetworkManager.getInstance(context).sendRemoteLog(aPSEvent);
    }

    public static String getDefaultIfEmptyString(String str, String str2) {
        return (str == null || str.trim().isEmpty()) ? str2 : str;
    }

    public static void addAdditionalDetails(String str, String str2) {
        try {
            if (additionalDetailsMap == null) {
                additionalDetailsMap = new HashMap();
            }
            if (additionalDetailsMap.size() >= 20) {
                Log.e(TAG, "Ignoring adding the details as the dictionary size limit exceeded");
            } else if (!APSSharedUtil.isNullOrEmpty(str) && str.length() <= 100 && !APSSharedUtil.isNullOrEmpty(str2) && str2.length() <= 100) {
                additionalDetailsMap.put(str, str2);
            }
            storeAdditionalDetailsString();
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in executing addAdditionalDetails method: ", e);
        }
    }

    public static void removeAdditionalDetails(String str) {
        try {
            additionalDetailsMap.remove(str);
            storeAdditionalDetailsString();
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in executing removeAdditionalDetails method: ", e);
        }
    }

    public static String getAdditionalDetails() {
        return additionalDetails;
    }

    private static void storeAdditionalDetailsString() {
        int size = additionalDetailsMap.size();
        additionalDetails = "";
        if (size > 0) {
            for (Map.Entry<String, String> entry : additionalDetailsMap.entrySet()) {
                additionalDetails = additionalDetails.concat(String.format("%s = %s;", entry.getKey(), entry.getValue()));
            }
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getAdapterVersion() {
        return adapterVersion;
    }

    public static void setAdapterVersion(String str) {
        if (APSSharedUtil.isNullOrEmpty(str)) {
            return;
        }
        adapterVersion = str;
    }

    public static void setVersion(String str) {
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        VERSION = str.trim();
    }
}
