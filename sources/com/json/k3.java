package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.adapters.ironsource.IronSourceLoadParameters;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005BA\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\u0010\u000f\u001a\u00060\u000bj\u0002`\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u000f\u001a\u00060\u000bj\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/ironsource/k3;", "Lcom/ironsource/l3;", "Ljava/util/ArrayList;", "Lcom/ironsource/n3;", "Lkotlin/collections/ArrayList;", "a", "", "Ljava/lang/String;", "version", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "instanceId", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/unity3d/ironsourceads/internal/AdFormat;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "", "d", "Z", "oneFlow", "e", IronSourceLoadParameters.Constants.DEMAND_ONLY, InneractiveMediationDefs.GENDER_FEMALE, "multipleAdObjects", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;ZZZ)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class k3 implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String version;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String instanceId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean oneFlow;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean demandOnly;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean multipleAdObjects;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/ironsource/k3$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "DEMAND_ONLY", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "ONE_FLOW", "d", "MULTIPLE_AD_OBJECTS", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3826a = new a();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final int DEMAND_ONLY = 1;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final int ONE_FLOW = 1;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public static final int MULTIPLE_AD_OBJECTS = 1;

        private a() {
        }
    }

    public k3(String version, String instanceId, IronSource.AD_UNIT adFormat, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.version = version;
        this.instanceId = instanceId;
        this.adFormat = adFormat;
        this.oneFlow = z;
        this.demandOnly = z2;
        this.multipleAdObjects = z3;
    }

    public /* synthetic */ k3(String str, String str2, IronSource.AD_UNIT ad_unit, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, ad_unit, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3);
    }

    @Override // com.json.l3
    public ArrayList<n3> a() {
        ArrayList<n3> arrayList = new ArrayList<>();
        arrayList.add(new m3.v(this.version));
        arrayList.add(new m3.x(this.instanceId));
        arrayList.add(new m3.a(this.adFormat));
        if (this.oneFlow) {
            arrayList.add(new m3.p(1));
        }
        if (this.demandOnly) {
            arrayList.add(new m3.e(1));
        }
        if (this.multipleAdObjects) {
            arrayList.add(new m3.o(1));
        }
        return arrayList;
    }
}
