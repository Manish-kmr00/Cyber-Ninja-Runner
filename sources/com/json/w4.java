package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.d;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ironsource/w4;", "Lcom/ironsource/x4;", "", "", "auctionUrls", "methodName", "", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/vi;", "Lcom/ironsource/vi;", "instanceInfo", "Lcom/ironsource/mediationsdk/d;", "Lcom/ironsource/mediationsdk/d;", "auctionDataUtils", "Lcom/ironsource/c5;", "Lcom/ironsource/c5;", "auctionReportUrls", "<init>", "(Lcom/ironsource/vi;Lcom/ironsource/mediationsdk/d;Lcom/ironsource/c5;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class w4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final vi instanceInfo;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final d auctionDataUtils;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final c5 auctionReportUrls;

    public w4(vi instanceInfo, d auctionDataUtils, c5 c5Var) {
        Intrinsics.checkNotNullParameter(instanceInfo, "instanceInfo");
        Intrinsics.checkNotNullParameter(auctionDataUtils, "auctionDataUtils");
        this.instanceInfo = instanceInfo;
        this.auctionDataUtils = auctionDataUtils;
        this.auctionReportUrls = c5Var;
    }

    private final void a(List<String> auctionUrls, String methodName) {
        Iterator<String> it = auctionUrls.iterator();
        while (it.hasNext()) {
            this.auctionDataUtils.a(methodName, this.instanceInfo.e(), d.b().a(it.next(), this.instanceInfo.e(), this.instanceInfo.f(), this.instanceInfo.d(), "", "", "", ""));
        }
    }

    @Override // com.json.x4
    public void a(String methodName) {
        List<String> listEmptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        c5 c5Var = this.auctionReportUrls;
        if (c5Var == null || (listEmptyList = c5Var.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        a(listEmptyList, methodName);
    }

    @Override // com.json.x4
    public void b(String methodName) {
        List<String> listEmptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        c5 c5Var = this.auctionReportUrls;
        if (c5Var == null || (listEmptyList = c5Var.c()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        a(listEmptyList, methodName);
    }

    @Override // com.json.x4
    public void c(String methodName) {
        List<String> listEmptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        c5 c5Var = this.auctionReportUrls;
        if (c5Var == null || (listEmptyList = c5Var.a()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        a(listEmptyList, methodName);
    }
}
