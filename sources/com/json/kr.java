package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/ironsource/kr;", "", "Lcom/ironsource/sr;", "g", "a", "Lcom/ironsource/sr;", "sdkInitResponse", "Lcom/ironsource/ls;", "d", "()Lcom/ironsource/ls;", "legacyInitResponse", "Lcom/ironsource/k4;", "()Lcom/ironsource/k4;", "applicationGeneralSettings", "Lcom/ironsource/gm;", "e", "()Lcom/ironsource/gm;", "loggerSettings", "Lcom/ironsource/d4;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/d4;", "crashReporterSettings", "Lcom/ironsource/mc;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/mc;", tr.d, "Lcom/ironsource/ls$a;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/ls$a;", "responseOrigin", "<init>", "(Lcom/ironsource/sr;)V", "sdkConfig", "(Lcom/ironsource/kr;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class kr {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sr sdkInitResponse;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kr(kr sdkConfig) {
        this(sdkConfig.sdkInitResponse);
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
    }

    public kr(sr sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        this.sdkInitResponse = sdkInitResponse;
    }

    public final k4 a() {
        return this.sdkInitResponse.getConfigurations().getApplicationConfigurations().getGeneralSettings();
    }

    public final d4 b() {
        return this.sdkInitResponse.getConfigurations().getApplicationConfigurations().getCrashReporter();
    }

    public final mc c() {
        return this.sdkInitResponse.getCom.ironsource.tr.d java.lang.String();
    }

    public final ls d() {
        return this.sdkInitResponse.getFullResponse();
    }

    public final gm e() {
        return this.sdkInitResponse.getConfigurations().getApplicationConfigurations().getLogger();
    }

    public final ls.a f() {
        ls.a aVarH = this.sdkInitResponse.getFullResponse().h();
        Intrinsics.checkNotNullExpressionValue(aVarH, "sdkInitResponse.fullResponse.origin");
        return aVarH;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    protected final sr getSdkInitResponse() {
        return this.sdkInitResponse;
    }
}
