package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00107\u001a\u000205¢\u0006\u0004\b>\u0010?J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J7\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u000f\u0010\u001cJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u001eJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u000f\u0010\"J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b\u000f\u0010%J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0007J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010*J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u000f\u0010+J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b\u000f\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0007J7\u0010(\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b(\u0010\u001cJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u000f\u00100J\u000f\u00101\u001a\u00020\u0005H\u0002¢\u0006\u0004\b1\u0010\u0007R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010<¨\u0006@"}, d2 = {"Lcom/chartboost/sdk/impl/r7;", "Lcom/chartboost/sdk/impl/s7;", "", "h", "()Z", "", "i", "()V", "Landroid/content/Context;", "context", "Landroid/view/View;", "trackedView", "rootView", "Lcom/chartboost/sdk/impl/wb$b;", "visibilityTrackerListener", "a", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;Lcom/chartboost/sdk/impl/wb$b;)V", "g", "e", "Lcom/chartboost/sdk/impl/d7;", "mtype", "Lcom/chartboost/sdk/impl/p2;", com.ironsource.b9.h.K, "", UnifiedMediationParams.KEY_SKIP_OFFSET, "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourcesList", "(Lcom/chartboost/sdk/impl/d7;Lcom/chartboost/sdk/impl/p2;Ljava/lang/Integer;Ljava/util/List;)V", "view", "(Landroid/view/View;)V", "", "videoDuration", "volume", "(FF)V", "Lcom/chartboost/sdk/impl/t8;", "quartile", "(Lcom/chartboost/sdk/impl/t8;)V", InneractiveMediationDefs.GENDER_FEMALE, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "isBufferStart", "(Z)V", "(F)V", "Lcom/chartboost/sdk/impl/g8;", "state", "(Lcom/chartboost/sdk/impl/g8;)V", "d", "(Ljava/lang/Integer;)V", "j", "Lcom/chartboost/sdk/impl/t7;", "Lcom/chartboost/sdk/impl/t7;", "openMeasurementManager", "Lcom/chartboost/sdk/impl/v7;", "Lcom/chartboost/sdk/impl/v7;", "openMeasurementSessionBuilder", "Lcom/chartboost/sdk/impl/w7;", "Lcom/chartboost/sdk/impl/w7;", "omTracker", "Lcom/chartboost/sdk/impl/wb;", "Lcom/chartboost/sdk/impl/wb;", "omVisibilityTracker", "<init>", "(Lcom/chartboost/sdk/impl/t7;Lcom/chartboost/sdk/impl/v7;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class r7 implements s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final t7 openMeasurementManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final v7 openMeasurementSessionBuilder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public w7 omTracker;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public wb omVisibilityTracker;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1125a;

        static {
            int[] iArr = new int[t8.values().length];
            try {
                iArr[t8.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[t8.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[t8.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f1125a = iArr;
        }
    }

    public r7(t7 openMeasurementManager, v7 openMeasurementSessionBuilder) {
        Intrinsics.checkNotNullParameter(openMeasurementManager, "openMeasurementManager");
        Intrinsics.checkNotNullParameter(openMeasurementSessionBuilder, "openMeasurementSessionBuilder");
        this.openMeasurementManager = openMeasurementManager;
        this.openMeasurementSessionBuilder = openMeasurementSessionBuilder;
    }

    public final void a(Context context, View trackedView, View rootView, wb.b visibilityTrackerListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(trackedView, "trackedView");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(visibilityTrackerListener, "visibilityTrackerListener");
        g();
        n7 n7VarB = this.openMeasurementManager.b();
        wb wbVar = new wb(context, trackedView, rootView, n7VarB.getMinVisibleDips(), n7VarB.getMinVisibleDurationMs(), n7VarB.getVisibilityCheckIntervalMs(), n7VarB.getTraversalLimit());
        wbVar.a(visibilityTrackerListener);
        wbVar.h();
        this.omVisibilityTracker = wbVar;
    }

    public final boolean h() {
        return this.openMeasurementManager.g();
    }

    public final void i() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.a();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("signalImpressionEvent missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    public final void g() {
        wb wbVar = this.omVisibilityTracker;
        if (wbVar != null) {
            wbVar.b();
        }
        this.omVisibilityTracker = null;
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.a(view);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void e() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.m();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionDestroyWebview missing om tracker", (Throwable) null, 2, (Object) null);
        }
        this.omTracker = null;
    }

    @Override // com.chartboost.sdk.impl.s7
    public void f() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.i();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoSkipped missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void c() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.g();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoPaused missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(g8 state) {
        Unit unit;
        Intrinsics.checkNotNullParameter(state, "state");
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.a(state);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyStateChanged missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void d() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.k();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyClick missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    public final void b(d7 mtype, p2 webview, Integer skipOffset, List<fb> verificationScriptResourcesList) throws Exception {
        this.openMeasurementManager.e();
        j();
        v7.a aVarA = this.openMeasurementSessionBuilder.a(webview, mtype, this.openMeasurementManager.c(), this.openMeasurementManager.a(), verificationScriptResourcesList, this.openMeasurementManager.h(), this.openMeasurementManager.d());
        if (aVarA != null) {
            this.omTracker = new w7(aVarA, this.openMeasurementManager.g());
        }
        a(skipOffset);
    }

    public final void j() {
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.m();
        }
        this.omTracker = null;
    }

    @Override // com.chartboost.sdk.impl.s7
    public void b() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.h();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoResumed missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(boolean isBufferStart) {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            if (isBufferStart) {
                w7Var.c();
            } else {
                w7Var.b();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoBuffer missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a() {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.d();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoComplete missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(t8 quartile) {
        Unit unit;
        Intrinsics.checkNotNullParameter(quartile, "quartile");
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            int i = a.f1125a[quartile.ordinal()];
            if (i == 1) {
                w7Var.e();
            } else if (i == 2) {
                w7Var.f();
            } else if (i == 3) {
                w7Var.j();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoProgress missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(float videoDuration, float volume) {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.a(videoDuration, volume);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVideoStarted missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(float volume) {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.a(volume);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("onImpressionNotifyVolumeChanged missing om tracker", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.s7
    public void a(d7 mtype, p2 webview, Integer skipOffset, List<fb> verificationScriptResourcesList) {
        Intrinsics.checkNotNullParameter(mtype, "mtype");
        Intrinsics.checkNotNullParameter(webview, "webview");
        Intrinsics.checkNotNullParameter(verificationScriptResourcesList, "verificationScriptResourcesList");
        try {
            b(mtype, webview, skipOffset, verificationScriptResourcesList);
        } catch (Exception e) {
            b7.a("OMSDK Session error", e);
        }
    }

    public final void a(Integer skipOffset) {
        Unit unit;
        w7 w7Var = this.omTracker;
        if (w7Var != null) {
            w7Var.l();
            w7Var.a(skipOffset);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("startAndLoadSession missing tracker", (Throwable) null, 2, (Object) null);
        }
    }
}
