package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ironsource/vo;", "", "", "a", "", "duration", "", "errorCode", "", "reason", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/e2;", "Lcom/ironsource/e2;", "eventsWrapper", "<init>", "(Lcom/ironsource/e2;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class vo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e2 eventsWrapper;

    public vo(e2 eventsWrapper) {
        Intrinsics.checkNotNullParameter(eventsWrapper, "eventsWrapper");
        this.eventsWrapper = eventsWrapper;
    }

    public final void a() {
        this.eventsWrapper.a(b2.OPERATIONAL_LOAD_AD, new HashMap());
    }

    public final void a(long duration) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(duration));
        this.eventsWrapper.a(b2.OPERATIONAL_LOAD_SUCCESS, map);
    }

    public final void a(long duration, int errorCode, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap map = new HashMap();
        map.put("errorCode", Integer.valueOf(errorCode));
        map.put("reason", reason);
        map.put("duration", Long.valueOf(duration));
        this.eventsWrapper.a(b2.OPERATIONAL_LOAD_FAILED, map);
    }

    public final void b() {
        this.eventsWrapper.a(b2.PAUSE_AD, null);
    }

    public final void c() {
        this.eventsWrapper.a(b2.RESUME_AD, null);
    }
}
