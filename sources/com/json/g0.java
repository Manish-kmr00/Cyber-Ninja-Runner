package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.logger.IronLog;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0003\n\u0004\u000fB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ironsource/g0;", "", "", "Lcom/ironsource/a0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, m5.p, "Lcom/ironsource/g0$b;", "loadSelection", "", "", "a", "Lcom/ironsource/zv;", "waterfallInstances", "d", "Lcom/ironsource/g0$c;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/w1;", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/zv;", "<init>", "(Lcom/ironsource/w1;Lcom/ironsource/zv;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class g0 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final zv waterfallInstances;

    /* JADX INFO: renamed from: com.ironsource.g0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/ironsource/g0$a;", "", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/zv;", "waterfallInstances", "Lcom/ironsource/g0;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.ironsource.g0$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class C0391a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3707a;

            static {
                int[] iArr = new int[dw.values().length];
                try {
                    iArr[dw.BIDDER_SENSITIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[dw.DEFAULT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f3707a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g0 a(w1 adUnitData, zv waterfallInstances) {
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
            int i = C0391a.f3707a[(adUnitData.getAdvancedLoading() ? dw.BIDDER_SENSITIVE : dw.DEFAULT).ordinal()];
            if (i == 1) {
                return new u7(adUnitData, waterfallInstances);
            }
            if (i == 2) {
                return adUnitData.getShowPriorityEnabled() ? new nt(adUnitData, waterfallInstances) : new ha(adUnitData, waterfallInstances);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\t\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/ironsource/g0$b;", "", "", "e", InneractiveMediationDefs.GENDER_FEMALE, "", "g", "", "Lcom/ironsource/a0;", "a", "Ljava/util/List;", "()Ljava/util/List;", "instancesToLoad", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "loadedInstances", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "loadingInProgressInstances", "d", "Z", "()Z", "(Z)V", "isBidderReached", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<a0> instancesToLoad = new ArrayList();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final List<a0> loadedInstances = new ArrayList();

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final List<a0> loadingInProgressInstances = new ArrayList();

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private boolean isBidderReached;

        public final List<a0> a() {
            return this.instancesToLoad;
        }

        public final void a(boolean z) {
            this.isBidderReached = z;
        }

        public final List<a0> b() {
            return this.loadedInstances;
        }

        public final List<a0> c() {
            return this.loadingInProgressInstances;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final boolean getIsBidderReached() {
            return this.isBidderReached;
        }

        public final boolean e() {
            return g() == 0;
        }

        public final boolean f() {
            return this.instancesToLoad.isEmpty() && this.loadingInProgressInstances.isEmpty();
        }

        public final int g() {
            return this.instancesToLoad.size() + this.loadedInstances.size() + this.loadingInProgressInstances.size();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003J%\u0010\u0003\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/ironsource/g0$c;", "", "Lcom/ironsource/a0;", "a", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "instanceToShow", "orderedInstances", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/ironsource/a0;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/a0;", "Ljava/util/List;", "d", "()Ljava/util/List;", "<init>", "(Lcom/ironsource/a0;Ljava/util/List;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final a0 instanceToShow;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final List<a0> orderedInstances;

        /* JADX WARN: Multi-variable type inference failed */
        public c(a0 a0Var, List<? extends a0> orderedInstances) {
            Intrinsics.checkNotNullParameter(orderedInstances, "orderedInstances");
            this.instanceToShow = a0Var;
            this.orderedInstances = orderedInstances;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(c cVar, a0 a0Var, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                a0Var = cVar.instanceToShow;
            }
            if ((i & 2) != 0) {
                list = cVar.orderedInstances;
            }
            return cVar.a(a0Var, list);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final a0 getInstanceToShow() {
            return this.instanceToShow;
        }

        public final c a(a0 instanceToShow, List<? extends a0> orderedInstances) {
            Intrinsics.checkNotNullParameter(orderedInstances, "orderedInstances");
            return new c(instanceToShow, orderedInstances);
        }

        public final List<a0> b() {
            return this.orderedInstances;
        }

        public final a0 c() {
            return this.instanceToShow;
        }

        public final List<a0> d() {
            return this.orderedInstances;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.instanceToShow, cVar.instanceToShow) && Intrinsics.areEqual(this.orderedInstances, cVar.orderedInstances);
        }

        public int hashCode() {
            a0 a0Var = this.instanceToShow;
            return ((a0Var == null ? 0 : a0Var.hashCode()) * 31) + this.orderedInstances.hashCode();
        }

        public String toString() {
            return "ShowSelection(instanceToShow=" + this.instanceToShow + ", orderedInstances=" + this.orderedInstances + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((a0) t).getAuctionResponseItem().l()), Integer.valueOf(((a0) t2).getAuctionResponseItem().l()));
        }
    }

    public g0(w1 adUnitData, zv waterfallInstances) {
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        this.adUnitData = adUnitData;
        this.waterfallInstances = waterfallInstances;
    }

    private final List<a0> b() {
        return CollectionsKt.sortedWith(this.waterfallInstances.b(), new d());
    }

    private final boolean b(a0 instance, b loadSelection) {
        IronLog ironLog;
        StringBuilder sbAppend;
        String str;
        List<a0> listC;
        if (!instance.getIsInstanceFailed()) {
            if (!instance.getIsInstanceLoaded()) {
                if (instance.getIsInstanceLoading()) {
                    IronLog.INTERNAL.verbose(instance.getAdFormat().name() + " - Instance " + instance.getInstanceSignature() + " still loading");
                    listC = loadSelection.c();
                } else if (a(instance, this.waterfallInstances)) {
                    ironLog = IronLog.INTERNAL;
                    sbAppend = new StringBuilder().append(instance.getAdFormat().name()).append(" - Instance ").append(instance.getInstanceSignature());
                    str = " is not better than already loaded instances";
                } else {
                    a(instance, loadSelection);
                }
                return a(loadSelection);
            }
            IronLog.INTERNAL.verbose(instance.getAdFormat().name() + " - Instance " + instance.getInstanceSignature() + " is already loaded");
            listC = loadSelection.b();
            listC.add(instance);
            return a(loadSelection);
        }
        ironLog = IronLog.INTERNAL;
        sbAppend = new StringBuilder().append(instance.getAdFormat().name()).append(" - Instance ").append(instance.getInstanceSignature());
        str = " is failed to load";
        ironLog.verbose(sbAppend.append(str).toString());
        return a(loadSelection);
    }

    public abstract void a(a0 instance, b loadSelection);

    public final boolean a() {
        int i;
        List<a0> listB = this.waterfallInstances.b();
        if ((listB instanceof Collection) && listB.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = listB.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((a0) it.next()).getIsInstanceLoaded() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i >= this.adUnitData.getMaxInstancesToLoad();
    }

    public final boolean a(a0 instance) {
        Object next;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (!((a0) next).getIsInstanceFailed()) {
                return Intrinsics.areEqual(next, instance);
            }
        }
        next = null;
        return Intrinsics.areEqual(next, instance);
    }

    protected boolean a(a0 instance, zv waterfallInstances) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        return false;
    }

    public boolean a(b loadSelection) {
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        return loadSelection.g() >= this.adUnitData.getMaxInstancesToLoad();
    }

    public final c c() {
        Object next;
        List<a0> listB = b();
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((a0) next).getIsInstanceLoaded()) {
                return new c((a0) next, listB);
            }
        }
        next = null;
        return new c((a0) next, listB);
    }

    public final b d() {
        IronLog.INTERNAL.verbose(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String().name() + " waterfall size: " + this.waterfallInstances.b().size());
        b bVar = new b();
        Iterator<a0> it = this.waterfallInstances.b().iterator();
        while (it.hasNext() && !b(it.next(), bVar)) {
        }
        return bVar;
    }
}
