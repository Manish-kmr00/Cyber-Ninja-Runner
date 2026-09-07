package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00108\u001a\u000206\u0012\u0006\u0010=\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u0014\u0010\u000b\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\u0017J\u0014\u0010\r\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\r\u0010\u0017J\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0018J\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u0014\u0010\u0016\u001a\u00020\t*\u00020\tH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\u001e\u0010\"J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b\u001e\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010'J\u000f\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010'J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b\u001e\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010'J\u001f\u0010\u001e\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b\u001e\u00104J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010'J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010'R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00107R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010:R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010:R\u0016\u0010<\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010;¨\u0006@"}, d2 = {"Lcom/chartboost/sdk/impl/a9;", "Lcom/chartboost/sdk/impl/z8;", "Lcom/chartboost/sdk/impl/m4;", "", "type", "location", "", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Lcom/chartboost/sdk/impl/b;", "activityInterface", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "a", "(Lcom/chartboost/sdk/impl/b;Lcom/chartboost/sdk/view/CBImpressionActivity;)V", "Lcom/chartboost/sdk/impl/vb;", "viewBase", "(Lcom/chartboost/sdk/impl/vb;)V", "Lcom/chartboost/sdk/impl/h0;", "adUnitRendererActivityInterface", "(Lcom/chartboost/sdk/impl/h0;)V", "g", "()V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, InneractiveMediationDefs.GENDER_FEMALE, "e", "d", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "forceOrientation", "", "allowOrientationChange", "(IZ)V", "h", "Lcom/chartboost/sdk/impl/t5;", "Lcom/chartboost/sdk/impl/t5;", "impressionActivityIntentWrapper", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "Z", "isFinishedHandled", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/t5;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class a9 implements z8, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final t5 impressionActivityIntentWrapper;
    public final /* synthetic */ m4 b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public WeakReference<b> activityInterface;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public WeakReference<h0> adUnitRendererActivityInterface;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean isFinishedHandled;

    public a9(t5 impressionActivityIntentWrapper, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(impressionActivityIntentWrapper, "impressionActivityIntentWrapper");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.impressionActivityIntentWrapper = impressionActivityIntentWrapper;
        this.b = eventTracker;
    }

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.b.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.b.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.b.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.b.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.b.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.b.track(kaVar);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage, reason: collision with other method in class */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.b.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist, reason: collision with other method in class */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.b.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh, reason: collision with other method in class */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.b.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store, reason: collision with other method in class */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.b.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track, reason: collision with other method in class */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.b.mo4741track(event);
    }

    @Override // com.chartboost.sdk.impl.z8
    public void g() {
        Unit unit;
        h0 h0Var;
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            unit = null;
        } else {
            h0Var.y();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("Bridge onStart missing callback to renderer", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.z8
    public void c() {
        Unit unit;
        h0 h0Var;
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            unit = null;
        } else {
            h0Var.A();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("Bridge onResume missing callback to renderer", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.z8
    public void f() {
        Unit unit;
        h0 h0Var;
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            unit = null;
        } else {
            h0Var.s();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("Bridge onPause missing callback to renderer", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.z8
    public void e() {
        Unit unit;
        h0 h0Var;
        h();
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            unit = null;
        } else {
            h0Var.q();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("Bridge onDestroy missing callback to renderer", (Throwable) null, 2, (Object) null);
        }
        WeakReference<b> weakReference2 = this.activityInterface;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<h0> weakReference3 = this.adUnitRendererActivityInterface;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
    }

    @Override // com.chartboost.sdk.impl.z8
    public void d() {
        h0 h0Var;
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            return;
        }
        h0Var.d();
    }

    @Override // com.chartboost.sdk.impl.z8
    public void b() {
        b bVar;
        this.isFinishedHandled = true;
        WeakReference<b> weakReference = this.activityInterface;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.b();
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a(int forceOrientation, boolean allowOrientationChange) {
        b bVar;
        WeakReference<b> weakReference = this.activityInterface;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.a(forceOrientation, allowOrientationChange);
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a(vb viewBase) {
        Unit unit;
        b bVar;
        Intrinsics.checkNotNullParameter(viewBase, "viewBase");
        WeakReference<b> weakReference = this.activityInterface;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            unit = null;
        } else {
            bVar.a(viewBase);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            b7.a("activityInterface is null", (Throwable) null, 2, (Object) null);
        }
    }

    public final void h() {
        if (this.isFinishedHandled) {
            return;
        }
        track((ka) new j4(ma.i.DISMISS_MISSING, "dismiss_missing happened due to sdk closure outside expected flow", null, null, null, 28, null));
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a(CBError.b error) {
        h0 h0Var;
        Intrinsics.checkNotNullParameter(error, "error");
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            return;
        }
        h0Var.a(error);
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a() {
        b bVar;
        WeakReference<b> weakReference = this.activityInterface;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.a();
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a(b activityInterface, CBImpressionActivity activity) {
        h0 h0Var;
        Intrinsics.checkNotNullParameter(activityInterface, "activityInterface");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityInterface = new WeakReference<>(activityInterface);
        WeakReference<h0> weakReference = this.adUnitRendererActivityInterface;
        if (weakReference == null || (h0Var = weakReference.get()) == null) {
            return;
        }
        h0Var.a(activity);
    }

    @Override // com.chartboost.sdk.impl.z8
    public void a(h0 adUnitRendererActivityInterface) {
        Intrinsics.checkNotNullParameter(adUnitRendererActivityInterface, "adUnitRendererActivityInterface");
        this.adUnitRendererActivityInterface = new WeakReference<>(adUnitRendererActivityInterface);
        try {
            t5 t5Var = this.impressionActivityIntentWrapper;
            t5Var.a(t5Var.a());
        } catch (Exception e) {
            b7.b("Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions", e);
            a(CBError.b.ACTIVITY_MISSING_IN_MANIFEST);
        }
    }
}
