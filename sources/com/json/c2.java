package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ironsource/c2;", "Lcom/ironsource/fc;", "Lcom/ironsource/b2;", "event", "", "", "", "a", "Lcom/ironsource/o1;", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/f1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/f1;", "adProperties", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", IronSourceConstants.EVENTS_MEDIATION_LOAD_STRATEGY, "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/f1;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class c2 extends fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final f1 adProperties;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String mediationLoadStrategy;

    public c2(o1 adTools, f1 adProperties, String str) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        this.adTools = adTools;
        this.adProperties = adProperties;
        this.mediationLoadStrategy = str;
    }

    public /* synthetic */ c2(o1 o1Var, f1 f1Var, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(o1Var, f1Var, (i & 4) != 0 ? null : str);
    }

    @Override // com.json.d2
    public Map<String, Object> a(b2 event) {
        Map<String, Object> mapA = a(this.adProperties);
        mapA.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        mapA.put("sessionDepth", Integer.valueOf(this.adTools.f()));
        String str = this.mediationLoadStrategy;
        if (str != null) {
            mapA.put(IronSourceConstants.EVENTS_MEDIATION_LOAD_STRATEGY, str);
        }
        return mapA;
    }
}
