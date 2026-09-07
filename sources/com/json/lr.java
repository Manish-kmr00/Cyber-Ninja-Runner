package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/ironsource/lr;", "Lcom/ironsource/wh;", "Lcom/ironsource/wh$a;", "Lcom/ironsource/kr;", "sdkConfig", "", "a", "d", "Lcom/ironsource/kr;", "", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Z", "isSDKInitialized", "Lcom/ironsource/el;", "()Lcom/ironsource/el;", "levelPlayConfig", "Lcom/ironsource/tj;", "()Lcom/ironsource/tj;", "ironSourceAdsConfig", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class lr implements wh, wh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private kr sdkConfig;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private boolean isSDKInitialized;

    @Override // com.json.wh
    public el a() {
        kr krVar = this.sdkConfig;
        if (krVar != null) {
            return new el(krVar);
        }
        return null;
    }

    @Override // com.ironsource.wh.a
    public void a(kr sdkConfig) {
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        this.sdkConfig = sdkConfig;
    }

    @Override // com.json.wh
    public tj b() {
        kr krVar = this.sdkConfig;
        if (krVar != null) {
            return new tj(krVar);
        }
        return null;
    }

    @Override // com.json.wh
    /* JADX INFO: renamed from: c, reason: from getter */
    public boolean getIsSDKInitialized() {
        return this.isSDKInitialized;
    }

    @Override // com.ironsource.wh.a
    public void d() {
        this.isSDKInitialized = true;
    }
}
