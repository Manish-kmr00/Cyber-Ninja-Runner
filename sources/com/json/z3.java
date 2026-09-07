package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/ironsource/z3;", "", "Lcom/ironsource/gm;", "a", "Lcom/ironsource/gm;", "e", "()Lcom/ironsource/gm;", "logger", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "d", "()Z", b4.g, "Lcom/ironsource/d4;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/d4;", "()Lcom/ironsource/d4;", b4.h, "Lcom/ironsource/k4;", "Lcom/ironsource/k4;", "()Lcom/ironsource/k4;", "generalSettings", "Lcom/ironsource/x3;", "Lcom/ironsource/x3;", "()Lcom/ironsource/x3;", "auctionSettings", "Lorg/json/JSONObject;", "applicationConfigurations", "<init>", "(Lorg/json/JSONObject;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final gm logger;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean integration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final d4 crashReporter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final k4 generalSettings;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final x3 auctionSettings;

    public z3(JSONObject applicationConfigurations) {
        Intrinsics.checkNotNullParameter(applicationConfigurations, "applicationConfigurations");
        JSONObject jSONObjectOptJSONObject = applicationConfigurations.optJSONObject(b4.f3541a);
        this.logger = new gm(jSONObjectOptJSONObject == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject);
        this.integration = applicationConfigurations.optBoolean(b4.g, false);
        JSONObject jSONObjectOptJSONObject2 = applicationConfigurations.optJSONObject(b4.h);
        this.crashReporter = new d4(jSONObjectOptJSONObject2 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = applicationConfigurations.optJSONObject("settings");
        this.generalSettings = new k4(jSONObjectOptJSONObject3 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = applicationConfigurations.optJSONObject(b4.f);
        this.auctionSettings = new x3(jSONObjectOptJSONObject4 == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject4);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final x3 getAuctionSettings() {
        return this.auctionSettings;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final d4 getCrashReporter() {
        return this.crashReporter;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final k4 getGeneralSettings() {
        return this.generalSettings;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIntegration() {
        return this.integration;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final gm getLogger() {
        return this.logger;
    }
}
