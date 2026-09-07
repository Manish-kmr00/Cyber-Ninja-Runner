package com.chartboost.sdk.impl;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0006\u0010\u0015J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tR\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010#¨\u0006'"}, d2 = {"Lcom/chartboost/sdk/impl/u5;", "", "Lcom/chartboost/sdk/impl/b;", "Lcom/chartboost/sdk/impl/vb;", "viewBase", "", "a", "(Lcom/chartboost/sdk/impl/vb;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "d", "h", "g", InneractiveMediationDefs.GENDER_FEMALE, "e", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "i", "", "forceOrientation", "", "allowOrientationChange", "(IZ)V", "j", "Lcom/chartboost/sdk/impl/s5;", "Lcom/chartboost/sdk/impl/s5;", "view", "Lcom/chartboost/sdk/impl/z8;", "Lcom/chartboost/sdk/impl/z8;", "rendererActivityBridge", "Lcom/chartboost/sdk/impl/o9;", "Lcom/chartboost/sdk/impl/o9;", "sdkConfiguration", "Lcom/chartboost/sdk/impl/b4;", "Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "I", "originalOrientation", "<init>", "(Lcom/chartboost/sdk/impl/s5;Lcom/chartboost/sdk/impl/z8;Lcom/chartboost/sdk/impl/o9;Lcom/chartboost/sdk/impl/b4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class u5 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s5 view;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final z8 rendererActivityBridge;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final o9 sdkConfiguration;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final b4 displayMeasurement;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int originalOrientation;

    public u5(s5 view, z8 rendererActivityBridge, o9 sdkConfiguration, b4 displayMeasurement) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(rendererActivityBridge, "rendererActivityBridge");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        this.view = view;
        this.rendererActivityBridge = rendererActivityBridge;
        this.sdkConfiguration = sdkConfiguration;
        this.displayMeasurement = displayMeasurement;
        this.originalOrientation = -1;
    }

    @Override // com.chartboost.sdk.impl.b
    public void b() {
        this.view.b();
    }

    public void d() {
        this.rendererActivityBridge.a(this, this.view.a());
        this.view.d();
        j();
    }

    public void h() {
        try {
            this.rendererActivityBridge.g();
        } catch (Exception e) {
            b7.a("Cannot perform onResume", e);
        }
    }

    public void g() {
        try {
            this.rendererActivityBridge.a(this, this.view.a());
        } catch (Exception e) {
            b7.a("Cannot setActivityRendererInterface", e);
        }
        try {
            this.rendererActivityBridge.c();
        } catch (Exception e2) {
            b7.a("Cannot perform onResume", e2);
        }
        this.view.d();
        try {
            b8.a(this.view.a(), this.sdkConfiguration, this.displayMeasurement);
        } catch (Exception e3) {
            b7.a("Cannot lock the orientation in activity", e3);
        }
    }

    public void f() {
        try {
            this.rendererActivityBridge.f();
        } catch (Exception e) {
            b7.a("Cannot perform onPause", e);
        }
        try {
            b8.a(this.view.a(), this.sdkConfiguration);
        } catch (Exception e2) {
            b7.a("Cannot lock the orientation in activity", e2);
        }
    }

    public void e() {
        try {
            this.rendererActivityBridge.e();
        } catch (Exception e) {
            b7.a("Cannot perform onStop", e);
        }
    }

    public void c() {
        try {
            this.rendererActivityBridge.d();
        } catch (Exception e) {
            b7.a("Cannot perform onStop", e);
        }
    }

    public void i() {
        try {
            if (this.view.c()) {
                return;
            }
            b7.b("The activity passed down is not hardware accelerated, so Chartboost cannot show ads", null, 2, null);
            this.rendererActivityBridge.a(CBError.b.HARDWARE_ACCELERATION_DISABLED);
            this.view.b();
        } catch (Exception e) {
            b7.b("onAttachedToWindow", e);
        }
    }

    @Override // com.chartboost.sdk.impl.b
    public void a(int forceOrientation, boolean allowOrientationChange) {
        int i;
        try {
            CBImpressionActivity cBImpressionActivityA = this.view.a();
            if (b8.a((Activity) cBImpressionActivityA)) {
                return;
            }
            j();
            if (forceOrientation != 0) {
                i = 1;
                if (forceOrientation != 1) {
                    i = allowOrientationChange ? -1 : cBImpressionActivityA.getResources().getConfiguration().orientation;
                }
            } else {
                i = 0;
            }
            cBImpressionActivityA.setRequestedOrientation(i);
        } catch (Exception e) {
            b7.b("applyOrientationProperties: ", e);
        }
    }

    @Override // com.chartboost.sdk.impl.b
    public void a(vb viewBase) {
        Intrinsics.checkNotNullParameter(viewBase, "viewBase");
        this.view.a(viewBase);
    }

    public final void j() {
        try {
            this.originalOrientation = this.view.a().getRequestedOrientation();
        } catch (Exception e) {
            b7.b("saveOriginalOrientation: ", e);
        }
    }

    @Override // com.chartboost.sdk.impl.b
    public void a() {
        try {
            CBImpressionActivity cBImpressionActivityA = this.view.a();
            if (b8.a((Activity) cBImpressionActivityA) || cBImpressionActivityA.getRequestedOrientation() == this.originalOrientation) {
                return;
            }
            b7.b("restoreOriginalOrientation: " + this.originalOrientation, null, 2, null);
            cBImpressionActivityA.setRequestedOrientation(this.originalOrientation);
        } catch (Exception e) {
            b7.b("restoreOriginalOrientation: ", e);
        }
    }
}
