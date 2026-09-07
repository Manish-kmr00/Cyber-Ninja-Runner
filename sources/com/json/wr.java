package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/ironsource/wr;", "", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mr;", "a", "Lcom/ironsource/mr;", "()Lcom/ironsource/mr;", "error", "Lcom/ironsource/sr;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/sr;", "()Lcom/ironsource/sr;", "sdkInitResponse", "<init>", "(Lcom/ironsource/mr;)V", "(Lcom/ironsource/sr;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final mr error;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sr sdkInitResponse;

    public wr(mr error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.sdkInitResponse = null;
    }

    public wr(sr sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        this.sdkInitResponse = sdkInitResponse;
        this.error = null;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final mr getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sr getSdkInitResponse() {
        return this.sdkInitResponse;
    }

    public final boolean c() {
        sr srVar;
        if (this.error == null && (srVar = this.sdkInitResponse) != null) {
            return srVar.getFullResponse().p();
        }
        return false;
    }
}
