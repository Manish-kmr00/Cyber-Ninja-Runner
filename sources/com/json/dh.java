package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/ironsource/dh;", "Lcom/ironsource/ch;", "Lcom/ironsource/ch$a;", "", "configKey", "", "e", "Lorg/json/JSONObject;", "a", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Ljava/lang/Boolean;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Ljava/lang/Integer;", "d", "controllerConfig", "", "Lorg/json/JSONObject;", b9.a.b, b9.a.c, "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class dh implements ch, ch.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private JSONObject controllerConfig = IronSourceNetworkBridge.jsonObjectInit();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private JSONObject networkConfig = IronSourceNetworkBridge.jsonObjectInit();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private JSONObject epConfig = IronSourceNetworkBridge.jsonObjectInit();

    private final Object e(String configKey) {
        JSONObject jSONObject;
        if (this.epConfig.has(configKey)) {
            jSONObject = this.epConfig;
        } else if (this.networkConfig.has(configKey)) {
            jSONObject = this.networkConfig;
        } else {
            if (!this.controllerConfig.has(configKey)) {
                return null;
            }
            jSONObject = this.controllerConfig;
        }
        return jSONObject.get(configKey);
    }

    @Override // com.json.ch
    public JSONObject a(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof JSONObject) {
            return (JSONObject) objE;
        }
        return null;
    }

    @Override // com.ironsource.ch.a
    public void a(JSONObject controllerConfig) {
        Intrinsics.checkNotNullParameter(controllerConfig, "controllerConfig");
        this.controllerConfig = controllerConfig;
        JSONObject jSONObjectOptJSONObject = controllerConfig.optJSONObject(b9.a.b);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = IronSourceNetworkBridge.jsonObjectInit();
        }
        this.networkConfig = jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.controllerConfig.optJSONObject(b9.a.c);
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = IronSourceNetworkBridge.jsonObjectInit();
        }
        this.epConfig = jSONObjectOptJSONObject2;
    }

    @Override // com.json.ch
    public Integer b(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof Integer) {
            return (Integer) objE;
        }
        return null;
    }

    @Override // com.json.ch
    public Boolean c(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof Boolean) {
            return (Boolean) objE;
        }
        return null;
    }

    @Override // com.json.ch
    public String d(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof String) {
            return (String) objE;
        }
        return null;
    }
}
