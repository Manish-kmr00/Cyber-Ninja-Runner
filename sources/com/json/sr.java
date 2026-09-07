package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\t\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/sr;", "", "Lcom/ironsource/ls;", "a", "Lcom/ironsource/ls;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/ls;", "fullResponse", "Lcom/ironsource/zp;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/zp;", "d", "()Lcom/ironsource/zp;", tr.f4469a, "Lcom/ironsource/bq;", "Lcom/ironsource/bq;", "e", "()Lcom/ironsource/bq;", tr.b, "Lcom/ironsource/t8;", "Lcom/ironsource/t8;", "()Lcom/ironsource/t8;", "configurations", "Lcom/ironsource/mc;", "Lcom/ironsource/mc;", "()Lcom/ironsource/mc;", tr.d, "<init>", "(Lcom/ironsource/ls;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class sr {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ls fullResponse;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final zp providerOrder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final bq providerSettings;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final t8 configurations;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final mc experiments;

    public sr(ls fullResponse) {
        Intrinsics.checkNotNullParameter(fullResponse, "fullResponse");
        this.fullResponse = fullResponse;
        JSONObject jSONObjectOptJSONObject = fullResponse.i().optJSONObject(tr.f4469a);
        this.providerOrder = new zp(jSONObjectOptJSONObject == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject);
        JSONObject jSONObjectOptJSONObject2 = fullResponse.i().optJSONObject(tr.b);
        this.providerSettings = new bq(jSONObjectOptJSONObject2 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = fullResponse.i().optJSONObject("configurations");
        this.configurations = new t8(jSONObjectOptJSONObject3 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = fullResponse.i().optJSONObject(tr.d);
        this.experiments = new mc(jSONObjectOptJSONObject4 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject4);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final t8 getConfigurations() {
        return this.configurations;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final mc getExperiments() {
        return this.experiments;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ls getFullResponse() {
        return this.fullResponse;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final zp getProviderOrder() {
        return this.providerOrder;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final bq getProviderSettings() {
        return this.providerSettings;
    }
}
