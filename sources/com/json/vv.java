package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tR\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/ironsource/vv;", "Lcom/ironsource/f0;", "Lcom/ironsource/zv;", "waterfallInstances", "", "a", "e", "", "d", "Lcom/ironsource/a0;", "showingAdInstance", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/d0;", "adInstanceFactory", "Lcom/ironsource/j0;", "adInstancePresenter", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, m5.p, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/cw;", "Lcom/ironsource/cw;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/xv;", "Lcom/ironsource/xv;", "waterfallFetcher", "Lcom/ironsource/g0;", "Lcom/ironsource/g0;", "adInstanceLoadStrategy", "Lcom/ironsource/ew;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/ew;", "waterfallReporter", "", "g", "Ljava/util/List;", "instancesReadyToShow", "h", "Lcom/ironsource/a0;", "i", "Z", "isDestroyed", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;Lcom/ironsource/cw;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class vv implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final cw listener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final xv waterfallFetcher;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private g0 adInstanceLoadStrategy;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private ew waterfallReporter;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final List<a0> instancesReadyToShow;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private a0 showingAdInstance;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean isDestroyed;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/ironsource/vv$a", "Lcom/ironsource/yv;", "Lcom/ironsource/zv;", "waterfallInstances", "", "a", "", "errorCode", "", "errorReason", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements yv {
        a() {
        }

        @Override // com.json.yv
        public void a(int errorCode, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            if (vv.this.isDestroyed) {
                return;
            }
            vv.this.listener.a(errorCode, errorReason);
        }

        @Override // com.json.yv
        public void a(zv waterfallInstances) {
            Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
            if (vv.this.isDestroyed) {
                return;
            }
            vv.this.a(waterfallInstances);
        }
    }

    public vv(w2 adTools, w1 adUnitData, cw listener) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.adTools = adTools;
        this.adUnitData = adUnitData;
        this.listener = listener;
        this.waterfallFetcher = xv.INSTANCE.a(adTools, adUnitData);
        this.instancesReadyToShow = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zv waterfallInstances) {
        this.adInstanceLoadStrategy = g0.INSTANCE.a(this.adUnitData, waterfallInstances);
        ew.Companion companion = ew.INSTANCE;
        w2 w2Var = this.adTools;
        w1 w1Var = this.adUnitData;
        xo outcomeReporter = this.waterfallFetcher.getOutcomeReporter();
        g0 g0Var = this.adInstanceLoadStrategy;
        if (g0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adInstanceLoadStrategy");
            g0Var = null;
        }
        this.waterfallReporter = companion.a(w2Var, w1Var, outcomeReporter, waterfallInstances, g0Var);
        e();
    }

    private final void c(a0 showingAdInstance) {
        d(showingAdInstance);
        b();
    }

    private final void d(a0 showingAdInstance) {
        this.showingAdInstance = showingAdInstance;
        this.instancesReadyToShow.remove(showingAdInstance);
    }

    private final boolean d() {
        return this.showingAdInstance != null;
    }

    private final void e() {
        g0 g0Var = this.adInstanceLoadStrategy;
        ew ewVar = null;
        if (g0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adInstanceLoadStrategy");
            g0Var = null;
        }
        g0.b bVarD = g0Var.d();
        if (bVarD.e()) {
            this.listener.a(509, "Mediation No fill");
            return;
        }
        if (!bVarD.f()) {
            Iterator<a0> it = bVarD.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } else {
            ew ewVar2 = this.waterfallReporter;
            if (ewVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("waterfallReporter");
            } else {
                ewVar = ewVar2;
            }
            ewVar.a();
        }
    }

    public final void a() {
        this.isDestroyed = true;
        a0 a0Var = this.showingAdInstance;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // com.json.f0
    public void a(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.isDestroyed || d()) {
            return;
        }
        ew ewVar = this.waterfallReporter;
        g0 g0Var = null;
        ew ewVar2 = null;
        if (ewVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("waterfallReporter");
            ewVar = null;
        }
        ewVar.a(instance);
        this.instancesReadyToShow.add(instance);
        if (this.instancesReadyToShow.size() == 1) {
            ew ewVar3 = this.waterfallReporter;
            if (ewVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("waterfallReporter");
            } else {
                ewVar2 = ewVar3;
            }
            ewVar2.b(instance);
            this.listener.b(instance);
            return;
        }
        g0 g0Var2 = this.adInstanceLoadStrategy;
        if (g0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adInstanceLoadStrategy");
        } else {
            g0Var = g0Var2;
        }
        if (g0Var.a(instance)) {
            this.listener.a(instance);
        }
    }

    public final void a(d0 adInstanceFactory) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        this.waterfallFetcher.a(adInstanceFactory, new a());
    }

    public final void a(j0 adInstancePresenter) {
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        g0 g0Var = this.adInstanceLoadStrategy;
        ew ewVar = null;
        if (g0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adInstanceLoadStrategy");
            g0Var = null;
        }
        g0.c cVarC = g0Var.c();
        a0 a0VarC = cVarC.c();
        if (a0VarC != null) {
            c(a0VarC);
            ew ewVar2 = this.waterfallReporter;
            if (ewVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("waterfallReporter");
            } else {
                ewVar = ewVar2;
            }
            ewVar.a(cVarC.c(), cVarC.d());
            cVarC.c().a(adInstancePresenter);
        }
    }

    @Override // com.json.f0
    public void a(IronSourceError error, a0 instance) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.isDestroyed) {
            return;
        }
        e();
    }

    public final void b() {
        IronLog.INTERNAL.verbose(o1.a(this.adTools, "dispose", (String) null, 2, (Object) null));
        Iterator<T> it = this.instancesReadyToShow.iterator();
        while (it.hasNext()) {
            ((a0) it.next()).c();
        }
        this.instancesReadyToShow.clear();
        this.adTools.getEventSender().getTroubleshoot().a();
    }

    public final void b(a0 instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ew ewVar = this.waterfallReporter;
        if (ewVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("waterfallReporter");
            ewVar = null;
        }
        ewVar.a(instance, this.adUnitData.l(), this.adUnitData.getPublisherDataHolder());
    }

    public final boolean c() {
        Iterator<a0> it = this.instancesReadyToShow.iterator();
        while (it.hasNext()) {
            if (it.next().y()) {
                return true;
            }
        }
        return false;
    }
}
