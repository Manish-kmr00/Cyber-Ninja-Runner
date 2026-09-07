package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0002*\u00020\u0002H\u0012¢\u0006\u0004\b\u0006\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0002H\u0012¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0002H\u0012¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u0007*\u00020\u0002H\u0012¢\u0006\u0004\b\r\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u0007*\u00020\u0002H\u0012¢\u0006\u0004\b\u000e\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0012¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0012¢\u0006\u0004\b\u0012\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\n*\u00020\u0002H\u0012¢\u0006\u0004\b\u0013\u0010\fR\u0016\u0010\u0015\u001a\u00020\u000f8\u0012@\u0012X\u0092\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u000f8\u0012@\u0012X\u0092\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u00178\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f0\u00178\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001d¨\u0006!"}, d2 = {"Lcom/chartboost/sdk/impl/k4;", "", "Lcom/chartboost/sdk/impl/ka;", "event", "e", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", InneractiveMediationDefs.GENDER_FEMALE, "", "g", "(Lcom/chartboost/sdk/impl/ka;)V", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/ka;)J", "h", "d", "", "i", "(Lcom/chartboost/sdk/impl/ka;)I", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "I", "eventLimit", "windowDuration", "", "Lcom/chartboost/sdk/impl/ma;", "Ljava/util/Map;", "eventsLastTimestamp", "eventsCount", "", "Ljava/util/Set;", "disabledEvents", "<init>", "(II)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int eventLimit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int windowDuration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Map<ma, Long> eventsLastTimestamp;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Map<ma, Integer> eventsCount;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Set<ma> disabledEvents;

    /* JADX WARN: Illegal instructions before constructor call */
    public k4() {
        int i = 0;
        this(i, i, 3, null);
    }

    public synchronized ka e(ka event) {
        if (event == null) {
            return null;
        }
        d(event);
        if (b(event) > this.windowDuration) {
            g(event);
        }
        if (this.disabledEvents.contains(event.getName())) {
            return null;
        }
        if (i(event) <= this.eventLimit) {
            return event;
        }
        return f(event);
    }

    public final ka f(ka kaVar) {
        r6 r6Var = new r6(ma.f.TOO_MANY_EVENTS, kaVar.getName().getValue(), null, null, null, null, 60, null);
        this.disabledEvents.add(kaVar.getName());
        return r6Var;
    }

    public k4(int i, int i2) {
        this.eventLimit = i;
        this.windowDuration = i2;
        this.eventsLastTimestamp = new LinkedHashMap();
        this.eventsCount = new LinkedHashMap();
        this.disabledEvents = new LinkedHashSet();
    }

    public /* synthetic */ k4(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? 30 : i2);
    }

    public final void g(ka kaVar) {
        h(kaVar);
        this.eventsCount.remove(kaVar.getName());
    }

    public final long b(ka kaVar) {
        return (kaVar.getTimestamp() - a(kaVar)) / ((long) 1000);
    }

    public final void h(ka kaVar) {
        this.eventsLastTimestamp.put(kaVar.getName(), Long.valueOf(kaVar.getTimestamp()));
    }

    public final void d(ka kaVar) {
        if (this.eventsLastTimestamp.containsKey(kaVar.getName())) {
            return;
        }
        this.eventsLastTimestamp.put(kaVar.getName(), Long.valueOf(kaVar.getTimestamp()));
    }

    public final int i(ka kaVar) {
        int iC = c(kaVar) + 1;
        this.eventsCount.put(kaVar.getName(), Integer.valueOf(iC));
        return iC;
    }

    public final int c(ka kaVar) {
        Integer num = this.eventsCount.get(kaVar.getName());
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final long a(ka kaVar) {
        Long l = this.eventsLastTimestamp.get(kaVar.getName());
        return l != null ? l.longValue() : kaVar.getTimestamp();
    }
}
