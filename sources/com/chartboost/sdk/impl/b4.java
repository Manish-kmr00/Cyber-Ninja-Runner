package com.chartboost.sdk.impl;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0003\u0010\bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/chartboost/sdk/impl/b4;", "", "Lcom/chartboost/sdk/impl/c4;", "a", "()Lcom/chartboost/sdk/impl/c4;", "d", "Landroid/view/WindowManager;", "windowManager", "(Landroid/view/WindowManager;)Lcom/chartboost/sdk/impl/c4;", "Landroid/view/WindowManager;", "Landroid/util/DisplayMetrics;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/util/DisplayMetrics;", "displayMetrics", "Lkotlin/Function0;", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/jvm/functions/Function0;", "androidVersion", "realDisplayMetrics", "", "e", "F", "()F", "displayMetricsDensity", InneractiveMediationDefs.GENDER_FEMALE, "I", "()I", "displayMetricsDensityDpi", "<init>", "(Landroid/view/WindowManager;Landroid/util/DisplayMetrics;Lkotlin/jvm/functions/Function0;Landroid/util/DisplayMetrics;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final WindowManager windowManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final DisplayMetrics displayMetrics;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function0<Integer> androidVersion;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final DisplayMetrics realDisplayMetrics;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final float displayMetricsDensity;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int displayMetricsDensityDpi;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<Integer> {
        public static final a b = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    public b4(WindowManager windowManager, DisplayMetrics displayMetrics, Function0<Integer> androidVersion, DisplayMetrics realDisplayMetrics) {
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        Intrinsics.checkNotNullParameter(androidVersion, "androidVersion");
        Intrinsics.checkNotNullParameter(realDisplayMetrics, "realDisplayMetrics");
        this.windowManager = windowManager;
        this.displayMetrics = displayMetrics;
        this.androidVersion = androidVersion;
        this.realDisplayMetrics = realDisplayMetrics;
        this.displayMetricsDensity = displayMetrics.density;
        this.displayMetricsDensityDpi = displayMetrics.densityDpi;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getDisplayMetricsDensity() {
        return this.displayMetricsDensity;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getDisplayMetricsDensityDpi() {
        return this.displayMetricsDensityDpi;
    }

    public /* synthetic */ b4(WindowManager windowManager, DisplayMetrics displayMetrics, Function0 function0, DisplayMetrics displayMetrics2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowManager, displayMetrics, (i & 4) != 0 ? a.b : function0, (i & 8) != 0 ? new DisplayMetrics() : displayMetrics2);
    }

    public final c4 d() {
        try {
            if (this.androidVersion.invoke().intValue() >= 30) {
                Rect bounds = this.windowManager.getCurrentWindowMetrics().getBounds();
                return new c4(bounds.width(), bounds.height());
            }
            this.realDisplayMetrics.setTo(this.displayMetrics);
            Display defaultDisplay = this.windowManager.getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(this.realDisplayMetrics);
            }
            DisplayMetrics displayMetrics = this.realDisplayMetrics;
            return new c4(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception e) {
            b7.b("Cannot create size", e);
            return new c4(0, 0);
        }
    }

    public final c4 a(WindowManager windowManager) {
        WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "windowManager.currentWindowMetrics");
        WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
        Intrinsics.checkNotNullExpressionValue(windowInsets, "metrics.windowInsets");
        Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "windowInsets.getInsetsIg…ayCutout(),\n            )");
        int i = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
        int i2 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
        Rect bounds = currentWindowMetrics.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "metrics.bounds");
        return new c4(bounds.width() - i, bounds.height() - i2);
    }

    public final c4 a() {
        c4 c4Var;
        try {
            if (this.androidVersion.invoke().intValue() >= 30) {
                c4Var = a(this.windowManager);
            } else {
                DisplayMetrics displayMetrics = this.displayMetrics;
                c4Var = new c4(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            return c4Var;
        } catch (Exception e) {
            b7.b("Cannot create device size", e);
            return new c4(0, 0);
        }
    }
}
