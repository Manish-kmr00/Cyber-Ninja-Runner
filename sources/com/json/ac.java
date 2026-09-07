package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010<\u001a\u00020;\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010=\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b%\u0010)\u001a\u0004\b\u0010\u0010*R\u0017\u00100\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0007\u0010/R\u0017\u00105\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b-\u00104R\u0017\u0010:\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b#\u00109¨\u0006B"}, d2 = {"Lcom/ironsource/ac;", "Lcom/ironsource/d2;", "Lcom/ironsource/b2;", "event", "", "", "", "a", "eventInterface", "", "", "isPublisherLoad", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Lcom/ironsource/e2;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/e2;", POBConstants.KEY_WRAPPER, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/List;", "()Ljava/util/List;", "eventsInterfaces", "Lcom/ironsource/ki;", "d", "Lcom/ironsource/ki;", "()Lcom/ironsource/ki;", "init", "Lcom/ironsource/zl;", "e", "Lcom/ironsource/zl;", "()Lcom/ironsource/zl;", "load", "Lcom/ironsource/av;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/av;", "g", "()Lcom/ironsource/av;", "token", "Lcom/ironsource/r4;", "Lcom/ironsource/r4;", "()Lcom/ironsource/r4;", b4.f, "Lcom/ironsource/n0;", "h", "Lcom/ironsource/n0;", "()Lcom/ironsource/n0;", "adInteraction", "Lcom/ironsource/fv;", "i", "Lcom/ironsource/fv;", "()Lcom/ironsource/fv;", "troubleshoot", "Lcom/ironsource/vo;", "j", "Lcom/ironsource/vo;", "()Lcom/ironsource/vo;", "operational", "Lcom/ironsource/e2$b;", "level", "", "Lcom/ironsource/s7;", "eventManager", "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Lcom/ironsource/e2$b;Ljava/util/List;Lcom/ironsource/s7;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ac implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final e2 wrapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<d2> eventsInterfaces;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ki init;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final zl load;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final av token;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final r4 auction;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final n0 adInteraction;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final fv troubleshoot;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final vo operational;

    public ac(IronSource.AD_UNIT adFormat, e2.b level, List<? extends d2> eventsInterfaces, s7 s7Var) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(eventsInterfaces, "eventsInterfaces");
        this.adFormat = adFormat;
        e2 e2Var = new e2(adFormat, level, this, s7Var);
        this.wrapper = e2Var;
        this.eventsInterfaces = CollectionsKt.toMutableList((Collection) eventsInterfaces);
        ki kiVar = e2Var.f;
        Intrinsics.checkNotNullExpressionValue(kiVar, "wrapper.init");
        this.init = kiVar;
        zl zlVar = e2Var.g;
        Intrinsics.checkNotNullExpressionValue(zlVar, "wrapper.load");
        this.load = zlVar;
        av avVar = e2Var.h;
        Intrinsics.checkNotNullExpressionValue(avVar, "wrapper.token");
        this.token = avVar;
        r4 r4Var = e2Var.i;
        Intrinsics.checkNotNullExpressionValue(r4Var, "wrapper.auction");
        this.auction = r4Var;
        n0 n0Var = e2Var.j;
        Intrinsics.checkNotNullExpressionValue(n0Var, "wrapper.adInteraction");
        this.adInteraction = n0Var;
        fv fvVar = e2Var.k;
        Intrinsics.checkNotNullExpressionValue(fvVar, "wrapper.troubleshoot");
        this.troubleshoot = fvVar;
        vo voVar = e2Var.l;
        Intrinsics.checkNotNullExpressionValue(voVar, "wrapper.operational");
        this.operational = voVar;
    }

    public /* synthetic */ ac(IronSource.AD_UNIT ad_unit, e2.b bVar, List list, s7 s7Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, bVar, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : s7Var);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final n0 getAdInteraction() {
        return this.adInteraction;
    }

    @Override // com.json.d2
    public Map<String, Object> a(b2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap map = new HashMap();
        Iterator<d2> it = this.eventsInterfaces.iterator();
        while (it.hasNext()) {
            Map<String, Object> mapA = it.next().a(event);
            Intrinsics.checkNotNullExpressionValue(mapA, "it.getEventsAdditionalDataMap(event)");
            map.putAll(mapA);
        }
        return map;
    }

    public final void a(d2 eventInterface) {
        Intrinsics.checkNotNullParameter(eventInterface, "eventInterface");
        this.eventsInterfaces.add(eventInterface);
    }

    public final void a(boolean isPublisherLoad) {
        zl zlVar;
        boolean z = true;
        if (isPublisherLoad) {
            zlVar = this.load;
        } else {
            if (isPublisherLoad) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.adFormat == IronSource.AD_UNIT.BANNER) {
                this.load.a();
                return;
            } else {
                zlVar = this.load;
                z = false;
            }
        }
        zlVar.a(z);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final r4 getAuction() {
        return this.auction;
    }

    public final List<d2> c() {
        return this.eventsInterfaces;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final ki getInit() {
        return this.init;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final zl getLoad() {
        return this.load;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final vo getOperational() {
        return this.operational;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final av getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final fv getTroubleshoot() {
        return this.troubleshoot;
    }
}
