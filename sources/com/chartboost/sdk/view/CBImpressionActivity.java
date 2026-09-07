package com.chartboost.sdk.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.impl.b7;
import com.chartboost.sdk.impl.o9;
import com.chartboost.sdk.impl.s5;
import com.chartboost.sdk.impl.u5;
import com.chartboost.sdk.impl.vb;
import com.chartboost.sdk.impl.y2;
import com.chartboost.sdk.impl.z8;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.b9;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0019\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\tR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010!¨\u0006$"}, d2 = {"Lcom/chartboost/sdk/view/CBImpressionActivity;", "Landroid/app/Activity;", "Lcom/chartboost/sdk/impl/s5;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", b9.h.u0, b9.h.t0, "onDestroy", "onBackPressed", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onAttachedToWindow", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/vb;", "view", "a", "(Lcom/chartboost/sdk/impl/vb;)V", "()Lcom/chartboost/sdk/view/CBImpressionActivity;", "d", InneractiveMediationDefs.GENDER_FEMALE, "e", "g", "Lcom/chartboost/sdk/impl/u5;", "Lcom/chartboost/sdk/impl/u5;", "presenter", "<init>", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class CBImpressionActivity extends Activity implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public u5 presenter;

    @Override // com.chartboost.sdk.impl.s5
    public CBImpressionActivity a() {
        return this;
    }

    @Override // com.chartboost.sdk.impl.s5
    public void a(vb view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            addContentView(view, new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e) {
            b7.a("Cannot attach view to activity", e);
        }
    }

    @Override // com.chartboost.sdk.impl.s5
    public void b() {
        finish();
    }

    @Override // com.chartboost.sdk.impl.s5
    public boolean c() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        return decorView.isHardwareAccelerated();
    }

    @Override // com.chartboost.sdk.impl.s5
    public void d() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                Window window = getWindow();
                if (window != null) {
                    window.setDecorFitsSystemWindows(true);
                    WindowInsetsController insetsController = window.getInsetsController();
                    if (insetsController != null) {
                        insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                        insetsController.setSystemBarsBehavior(2);
                    }
                }
            } else {
                Window window2 = getWindow();
                View decorView = window2 != null ? window2.getDecorView() : null;
                if (decorView != null) {
                    decorView.setSystemUiVisibility(3846);
                }
            }
            if (i >= 28) {
                Window window3 = getWindow();
                WindowManager.LayoutParams attributes = window3 != null ? window3.getAttributes() : null;
                if (attributes == null) {
                    return;
                }
                attributes.layoutInDisplayCutoutMode = 1;
            }
        } catch (Exception e) {
            b7.a("Cannot set view to fullscreen", e);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.c, me);
        return super.dispatchTouchEvent(me);
    }

    public final void e() {
        if (this.presenter == null) {
            if (!Chartboost.isSdkStarted()) {
                b7.b("Cannot start Chartboost activity due to SDK not being initialized.", null, 2, null);
                finish();
                return;
            }
            y2 y2Var = y2.b;
            z8 z8VarA = y2Var.j().a();
            o9 o9Var = y2Var.d().b().get();
            Intrinsics.checkNotNullExpressionValue(o9Var, "ChartboostDependencyCont…Component.sdkConfig.get()");
            this.presenter = new u5(this, z8VarA, o9Var, y2Var.a().h());
        }
    }

    public final boolean f() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getBooleanExtra("isChartboost", false);
        }
        return false;
    }

    public final void g() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.i();
        }
    }

    @Override // android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.c();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        g();
        if (!f()) {
            b7.b("This activity cannot be called from outside chartboost SDK", null, 2, null);
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().setWindowAnimations(0);
        e();
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.d();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.e();
        }
        this.presenter = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.f();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        e();
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.g();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        u5 u5Var = this.presenter;
        if (u5Var != null) {
            u5Var.h();
        }
    }
}
