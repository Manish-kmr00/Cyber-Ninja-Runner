package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.logger.IronLog;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/ironsource/pb;", "Lcom/ironsource/pf;", "Lcom/ironsource/pf$a;", "Lorg/json/JSONObject;", DTBMetricsConfiguration.CONFIG_DIR, b9.a.c, "", "a", "", InneractiveMediationDefs.GENDER_FEMALE, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", "Lorg/json/JSONObject;", "g", "()Lorg/json/JSONObject;", qb.f4198a, "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class pb implements pf, pf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private JSONObject config = IronSourceNetworkBridge.jsonObjectInit();

    private final JSONObject g() {
        JSONObject jSONObjectOptJSONObject = this.config.optJSONObject(qb.f4198a);
        return jSONObjectOptJSONObject == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObjectOptJSONObject;
    }

    @Override // com.ironsource.pf.a
    public void a(JSONObject epConfig) {
        if (epConfig == null) {
            epConfig = this.config;
        }
        this.config = epConfig;
        IronLog.INTERNAL.verbose("setEpConfig: " + this.config);
    }

    @Override // com.json.rb
    public boolean a() {
        return g().optBoolean(sb.f, true);
    }

    @Override // com.json.rb
    public long b() {
        String strOptString = g().optString(sb.d);
        Intrinsics.checkNotNullExpressionValue(strOptString, "traits.optString(LPM_DEL…_TIME_AFTER_INIT_PROCESS)");
        Long longOrNull = StringsKt.toLongOrNull(strOptString);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 2000L;
    }

    @Override // com.json.rb
    public int c() {
        String strOptString = g().optString(sb.b);
        Intrinsics.checkNotNullExpressionValue(strOptString, "traits.optString(ISN_CTRL_INIT_DELAY)");
        Integer intOrNull = StringsKt.toIntOrNull(strOptString);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    @Override // com.json.pf
    /* JADX INFO: renamed from: config, reason: from getter */
    public JSONObject getConfig() {
        return this.config;
    }

    @Override // com.json.rb
    public boolean d() {
        return g().optBoolean(sb.e, true);
    }

    @Override // com.json.rb
    public long e() {
        String strOptString = g().optString(sb.c);
        Intrinsics.checkNotNullExpressionValue(strOptString, "traits.optString(LPM_BN_…FRESH_ANIMATION_DURATION)");
        Long longOrNull = StringsKt.toLongOrNull(strOptString);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    @Override // com.json.rb
    public boolean f() {
        String strOptString = g().optString(sb.f4271a);
        Intrinsics.checkNotNullExpressionValue(strOptString, "traits.optString(IS_EP_CONFIG_ENABLED)");
        String lowerCase = strOptString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return Intrinsics.areEqual(lowerCase, "true");
    }
}
