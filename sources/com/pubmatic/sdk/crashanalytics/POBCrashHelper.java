package com.pubmatic.sdk.crashanalytics;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBAppInfo;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.utility.POBUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/pubmatic/sdk/crashanalytics/POBCrashHelper;", "", "", "crashName", "stackTrace", "", "timeStamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "a", "(Landroid/content/Context;)Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getCrashJson", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "J", "d", "tag", "crashanalytics_release"}, k = 1, mv = {1, 7, 1})
public final class POBCrashHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String crashName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String stackTrace;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final long timeStamp;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String tag;

    public POBCrashHelper(String crashName, String stackTrace, long j) {
        Intrinsics.checkNotNullParameter(crashName, "crashName");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        this.crashName = crashName;
        this.stackTrace = stackTrace;
        this.timeStamp = j;
        this.tag = "POBCrashHelper";
    }

    private final JSONObject a(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        POBAppInfo appInfo = POBInstanceProvider.getAppInfo(context);
        Intrinsics.checkNotNullExpressionValue(appInfo, "getAppInfo(context)");
        jSONObject.put("name", appInfo.getAppName());
        jSONObject.put("ver", appInfo.getAppVersion());
        jSONObject.put(POBCrashAnalyticsConstants.BUNDLE_KEY, appInfo.getPackageName());
        jSONObject.put(POBCrashAnalyticsConstants.OW_SDK_VERSION_KEY, OpenWrapSDK.getVersion());
        jSONObject.put("pubid", POBInstanceProvider.getCacheManager(context).getPublisherId());
        return jSONObject;
    }

    private final JSONObject b(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", "Android");
        jSONObject.put("type", POBUtils.isTablet(context) ? 5 : 4);
        POBDeviceInfo deviceInfo = POBInstanceProvider.getDeviceInfo(context);
        Intrinsics.checkNotNullExpressionValue(deviceInfo, "getDeviceInfo(context)");
        jSONObject.put("model", deviceInfo.getModel());
        jSONObject.put("make", deviceInfo.getMake());
        jSONObject.put("osv", deviceInfo.getOsVersion());
        jSONObject.put(POBCrashAnalyticsConstants.CONNECTION_TYPE_KEY, POBInstanceProvider.getNetworkMonitor(context).getConnectionType().getValue());
        return jSONObject;
    }

    public final JSONObject getCrashJson(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put(POBCrashAnalyticsConstants.APPLICATION_INFO_KEY, a(context));
            jSONObject.put(POBCrashAnalyticsConstants.DEVICE_INFO_KEY, b(context));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", this.crashName);
            jSONObject2.put("st", this.stackTrace);
            jSONObject.put(POBCrashAnalyticsConstants.CRASH_INFO_KEY, jSONObject2);
            jSONObject.put(POBCrashAnalyticsConstants.AD_SESSIONS_KEY, POBInstanceProvider.getCacheManager(context).getCachedBidResponses().toString());
        } catch (JSONException e) {
            POBLog.debug(this.tag, "JSONException caught while inserting crash details in jsonObject.Message -> " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }
}
