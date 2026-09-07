package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ironsource/dm;", "Lcom/ironsource/rc;", "Lcom/ironsource/cm;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "Ljava/lang/String;", "adm", "Lcom/ironsource/yp;", "Lcom/ironsource/yp;", "providerName", "Lcom/ironsource/e3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/e3;", "adapterConfigs", "", "d", "Z", "isSDKInitialized", "<init>", "(Ljava/lang/String;Lcom/ironsource/yp;Lcom/ironsource/e3;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class dm implements rc<cm> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String adm;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final yp providerName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e3 adapterConfigs;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean isSDKInitialized;

    public dm(String adm, yp providerName, e3 adapterConfigs, boolean z) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(adapterConfigs, "adapterConfigs");
        this.adm = adm;
        this.providerName = providerName;
        this.adapterConfigs = adapterConfigs;
        this.isSDKInitialized = z;
    }

    @Override // com.json.rc
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cm a() throws Exception {
        ui uiVarA = this.adapterConfigs.a(this.providerName);
        new s0(this.adm, uiVarA, this.isSDKInitialized).a();
        if (uiVarA != null) {
            return new cm(uiVarA.c(), uiVarA.b(), uiVarA.e(), uiVarA.a(), false, 16, null);
        }
        return null;
    }
}
