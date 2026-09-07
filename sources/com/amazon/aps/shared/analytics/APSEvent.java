package com.amazon.aps.shared.analytics;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.amazon.device.ads.DtbDeviceData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.json.b9;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class APSEvent implements Serializable {
    public static final int EXCEPTION_LOG_SIZE = 2048;
    String deviceManufacturer;
    String deviceModel;
    String eventType;
    String osName;
    int osVersion;
    String pkgName;
    String sdkVersion;
    APSEventSeverity severity;
    long timestamp;
    String configVersion = "";
    String errorDetails = "";
    String exceptionLog = "";

    public APSEvent build() {
        return this;
    }

    public APSEvent(Context context, APSEventSeverity aPSEventSeverity, String str) {
        this.sdkVersion = null;
        this.pkgName = "";
        this.osName = "";
        this.deviceManufacturer = "";
        this.deviceModel = "";
        try {
            this.sdkVersion = APSAnalytics.getVersion();
            String adapterVersion = APSAnalytics.getAdapterVersion();
            if (adapterVersion != null) {
                this.sdkVersion += "_" + adapterVersion;
            }
            this.osName = "Android";
            this.osVersion = Build.VERSION.SDK_INT;
            this.deviceManufacturer = Build.MANUFACTURER;
            this.deviceModel = Build.MODEL;
            this.timestamp = System.currentTimeMillis();
            this.pkgName = context == null ? "unknown" : context.getPackageName();
            setEventSeverity(aPSEventSeverity);
            setEventType(str);
        } catch (RuntimeException e) {
            Log.e("APSEvent", "Error constructing the APSEvent:", e);
        }
    }

    public APSEvent setEventType(String str) {
        this.eventType = str;
        return this;
    }

    public APSEvent setEventSeverity(APSEventSeverity aPSEventSeverity) {
        this.severity = aPSEventSeverity;
        return this;
    }

    public APSEvent setExceptionDetails(Exception exc) {
        if (exc != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                if (string.length() > 2048) {
                    int length = ((2048 - exc.getMessage().length()) - (APSSharedUtil.TRUNCATE_SEPARATOR.length() * 2)) / 2;
                    this.exceptionLog = exc.getMessage() + APSSharedUtil.TRUNCATE_SEPARATOR + string.substring(0, length) + APSSharedUtil.TRUNCATE_SEPARATOR + string.substring(string.length() - length);
                } else {
                    this.exceptionLog = exc.getMessage() + "\n" + string;
                }
            } catch (RuntimeException e) {
                Log.e("APSEvent", "Error in parsing the exception detail; ", e);
            }
        }
        return this;
    }

    public APSEvent setExceptionDetails(String str) {
        int length = 2048 > str.length() ? str.length() : 2048;
        if (str != null) {
            this.exceptionLog = str.substring(0, length);
        }
        return this;
    }

    public APSEvent setErrorDetails(String str) {
        if (str != null) {
            int length = str.length();
            if (length > 2048) {
                length = 2048;
            }
            this.errorDetails = str.substring(0, length);
        }
        return this;
    }

    public APSEvent setConfigVersion(String str) {
        this.configVersion = str;
        return this;
    }

    public APSEvent setTimestamp(long j) {
        this.timestamp = j;
        return this;
    }

    public APSEventSeverity getEventSeverity() {
        return this.severity;
    }

    public String getExceptionDetails() {
        return this.exceptionLog;
    }

    public String getEventType() {
        return this.eventType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isValidEvent() {
        return this.eventType != null;
    }

    public String toJsonPayload() {
        String strReplace = "";
        String strConcat = String.format("msg = %s;", this.errorDetails);
        String additionalDetails = APSAnalytics.getAdditionalDetails();
        if (!APSSharedUtil.isNullOrEmpty(additionalDetails)) {
            strConcat = strConcat.concat(additionalDetails);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", this.sdkVersion);
            jSONObject.put("eventType", this.eventType);
            jSONObject.put("eventTimestamp", this.timestamp);
            jSONObject.put(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, this.severity.name());
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.pkgName);
            jSONObject.put("osName", this.osName);
            jSONObject.put(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, this.osVersion);
            jSONObject.put("deviceManufacturer", this.deviceManufacturer);
            jSONObject.put(b9.i.l, this.deviceModel);
            jSONObject.put("configVersion", this.configVersion);
            jSONObject.put("otherDetails", strConcat);
            jSONObject.put("exceptionDetails", this.exceptionLog);
            strReplace = Base64.encodeToString(jSONObject.toString().getBytes(), 0).replace("\n", "");
        } catch (RuntimeException | JSONException e) {
            Log.e("APSEvent", "Error in parsing the json .. ignoring : ", e);
        }
        return "{\"Data\": \"" + strReplace + "\",\"PartitionKey\": \"" + this.timestamp + "\"}";
    }
}
