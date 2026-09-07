package com.pubmatic.sdk.openwrap.core.signal;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBApplicationInfo;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.pubmatic.sdk.openwrap.core.POBCommonOrtbJsonHelper;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001e¨\u0006 "}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBALMAXSignalBuilder;", "Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalBuilding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/pubmatic/sdk/common/models/POBApplicationInfo;", POBCrashAnalyticsConstants.APPLICATION_INFO_KEY, "(Lcom/pubmatic/sdk/common/models/POBApplicationInfo;)Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/pubmatic/sdk/common/models/POBDeviceInfo;", POBCrashAnalyticsConstants.DEVICE_INFO_KEY, "", "setDeviceInfo", "(Lcom/pubmatic/sdk/common/models/POBDeviceInfo;)V", "Lcom/pubmatic/sdk/openwrap/core/POBRequest;", "request", "setRequest", "(Lcom/pubmatic/sdk/openwrap/core/POBRequest;)V", "", "build", "()Ljava/lang/String;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/pubmatic/sdk/common/models/POBDeviceInfo;", "Lcom/pubmatic/sdk/openwrap/core/POBRequest;", "Companion", "openwrapcore_release"}, k = 1, mv = {1, 7, 1})
public final class POBALMAXSignalBuilder implements POBSignalBuilding {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private POBDeviceInfo deviceInfo;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private POBRequest request;

    public POBALMAXSignalBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        POBDeviceInfo pOBDeviceInfo = this.deviceInfo;
        if (pOBDeviceInfo != null) {
            try {
                jSONObject.put("geo", c());
                jSONObject.put(POBConstants.KEY_MCCMNC, pOBDeviceInfo.getMccmnc());
                POBNetworkMonitor.ConnectionType connectionType = POBInstanceProvider.getNetworkMonitor(this.context).getConnectionType();
                Intrinsics.checkNotNullExpressionValue(connectionType, "getNetworkMonitor(context).getConnectionType()");
                jSONObject.put("connectiontype", connectionType.getValue());
            } catch (JSONException e) {
                POBLog.error("POBALMAXSignalBuilder", "Exception occurred in getDeviceObject() : " + e.getMessage(), new Object[0]);
                Unit unit = Unit.INSTANCE;
            }
        }
        return jSONObject;
    }

    private final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(POBConstants.KEY_CLIENT_CONFIG, 1);
            jSONObject.put(POBConstants.KEY_WRAPPER, jSONObject2);
        } catch (JSONException e) {
            POBLog.error("POBALMAXSignalBuilder", "Exception occurred in getExtObject() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            POBDeviceInfo pOBDeviceInfo = this.deviceInfo;
            if (pOBDeviceInfo != null) {
                jSONObject.put(POBConstants.KEY_UTC_OFFSET, pOBDeviceInfo.getTimeZoneOffsetInMinutes());
            }
        } catch (JSONException e) {
            POBLog.error("POBALMAXSignalBuilder", "Exception occurred in getGeoObject() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.pubmatic.sdk.openwrap.core.signal.POBSignalBuilding
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            POBRequest pOBRequest = this.request;
            if (pOBRequest != null) {
                jSONObject.put(POBConstants.KEY_IMPRESSION, POBCommonOrtbJsonHelper.getImpressionJsonArray(pOBRequest));
            }
            jSONObject.put("device", a());
            if (POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.HTML_MEASUREMENT_PROVIDER_CLASS) != null) {
                jSONObject.put("source", POBCommonOrtbJsonHelper.getMeasurementJson());
            }
            Context context = this.context;
            POBRequest pOBRequest2 = this.request;
            JSONObject userJson = POBCommonOrtbJsonHelper.getUserJson(context, pOBRequest2 != null ? pOBRequest2.getPlacementType() : null);
            if (userJson.length() > 0) {
                jSONObject.put(POBConstants.KEY_USER, userJson);
            }
            JSONObject regsJson = POBCommonOrtbJsonHelper.getRegsJson(this.context);
            if (!POBUtils.isJsonObjectNullOrEmpty(regsJson)) {
                jSONObject.put(POBConstants.KEY_REGS, regsJson);
            }
            jSONObject.put("ext", b());
            POBApplicationInfo applicationInfo = POBInstanceProvider.getSdkConfig().getApplicationInfo();
            if (applicationInfo != null) {
                JSONObject jSONObjectA = a(applicationInfo);
                if (jSONObjectA.length() > 0) {
                    jSONObject.put("app", jSONObjectA);
                }
            }
        } catch (JSONException e) {
            POBLog.error("POBALMAXSignalBuilder", "Exception occurred while building signal, reason : " + e.getMessage(), new Object[0]);
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "ortbJSON.toString()");
        return string;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.pubmatic.sdk.openwrap.core.signal.POBSignalBuilding
    public void setDeviceInfo(POBDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @Override // com.pubmatic.sdk.openwrap.core.signal.POBSignalBuilding
    public void setRequest(POBRequest request) {
        this.request = request;
    }

    private final JSONObject a(POBApplicationInfo applicationInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "domain", applicationInfo.getDomain());
            Boolean boolIsPaid = applicationInfo.isPaid();
            if (boolIsPaid != null) {
                jSONObject.put(POBConstants.KEY_PAID, boolIsPaid.booleanValue() ? 1 : 0);
            }
            if (!POBUtils.isNullOrEmpty(applicationInfo.getKeywords())) {
                jSONObject.put("keywords", applicationInfo.getKeywords());
            }
            URL storeURL = applicationInfo.getStoreURL();
            if (storeURL != null) {
                jSONObject.put(POBConstants.KEY_STORE_URL, storeURL.toString());
            }
        } catch (JSONException e) {
            POBLog.error("POBALMAXSignalBuilder", "Exception occurred in getAppJson() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }
}
