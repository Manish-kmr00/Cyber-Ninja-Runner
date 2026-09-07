package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\n\u0010\f\u001a\u0013\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\r\u001a\u001d\u0010\n\u001a\u00020\u000e*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000f\u001a\u0017\u0010\n\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u0012\u001a\u001d\u0010\u0014\u001a\u00020\u0013*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroid/content/Context;", "Lcom/chartboost/sdk/impl/b4;", "displayMeasurement", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Landroid/content/Context;Lcom/chartboost/sdk/impl/b4;)Z", "Landroid/app/Activity;", "Lcom/chartboost/sdk/impl/o9;", "sdkConfig", "", "a", "(Landroid/app/Activity;Lcom/chartboost/sdk/impl/o9;)V", "(Landroid/app/Activity;Lcom/chartboost/sdk/impl/o9;Lcom/chartboost/sdk/impl/b4;)V", "(Landroid/app/Activity;)Z", "Lcom/chartboost/sdk/impl/a8;", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/b4;)Lcom/chartboost/sdk/impl/a8;", "context", "", "(Landroid/content/Context;)I", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;Lcom/chartboost/sdk/impl/b4;)Ljava/lang/String;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class b8 {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f978a;

        static {
            int[] iArr = new int[a8.values().length];
            try {
                iArr[a8.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a8.PORTRAIT_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a8.PORTRAIT_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a8.PORTRAIT_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a8.LANDSCAPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a8.LANDSCAPE_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a8.LANDSCAPE_REVERSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a8.LANDSCAPE_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f978a = iArr;
        }
    }

    public static final String b(Context context, b4 displayMeasurement) {
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        switch (a.f978a[a(context, displayMeasurement).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "portrait";
            case 5:
            case 6:
            case 7:
            case 8:
                return "landscape";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean c(Context context, b4 displayMeasurement) {
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        a8 a8VarA = a(context, displayMeasurement);
        return a8VarA == a8.PORTRAIT || a8VarA == a8.PORTRAIT_REVERSE || a8VarA == a8.PORTRAIT_LEFT || a8VarA == a8.PORTRAIT_RIGHT;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r5 != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.chartboost.sdk.impl.a8 a(android.content.Context r5, com.chartboost.sdk.impl.b4 r6) {
        /*
            if (r5 != 0) goto L5
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT
            return r5
        L5:
            com.chartboost.sdk.impl.c4 r6 = r6.a()     // Catch: java.lang.Exception -> L6b
            int r0 = a(r5)     // Catch: java.lang.Exception -> L6b
            int r1 = r6.getWidth()     // Catch: java.lang.Exception -> L6b
            int r2 = r6.getHeight()     // Catch: java.lang.Exception -> L6b
            r3 = 1
            r4 = 2
            if (r1 != r2) goto L26
            android.content.res.Resources r5 = r5.getResources()     // Catch: java.lang.Exception -> L6b
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch: java.lang.Exception -> L6b
            int r5 = r5.orientation     // Catch: java.lang.Exception -> L6b
            if (r5 == r4) goto L32
            goto L30
        L26:
            int r5 = r6.getWidth()     // Catch: java.lang.Exception -> L6b
            int r6 = r6.getHeight()     // Catch: java.lang.Exception -> L6b
            if (r5 >= r6) goto L32
        L30:
            r5 = r3
            goto L33
        L32:
            r5 = 0
        L33:
            r6 = 3
            if (r0 == 0) goto L3b
            if (r0 == r4) goto L3b
            if (r5 != 0) goto L54
            goto L3d
        L3b:
            if (r5 == 0) goto L54
        L3d:
            if (r0 == 0) goto L51
            if (r0 == r3) goto L4e
            if (r0 == r4) goto L4b
            if (r0 == r6) goto L48
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L48:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE_RIGHT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L4b:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT_REVERSE     // Catch: java.lang.Exception -> L6b
            goto L6a
        L4e:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE_LEFT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L51:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L54:
            if (r0 == 0) goto L68
            if (r0 == r3) goto L65
            if (r0 == r4) goto L62
            if (r0 == r6) goto L5f
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE     // Catch: java.lang.Exception -> L6b
            goto L6a
        L5f:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT_RIGHT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L62:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE_REVERSE     // Catch: java.lang.Exception -> L6b
            goto L6a
        L65:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.PORTRAIT_LEFT     // Catch: java.lang.Exception -> L6b
            goto L6a
        L68:
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE     // Catch: java.lang.Exception -> L6b
        L6a:
            return r5
        L6b:
            r5 = move-exception
            java.lang.String r6 = "Cannot getOrientation"
            com.chartboost.sdk.impl.b7.b(r6, r5)
            com.chartboost.sdk.impl.a8 r5 = com.chartboost.sdk.impl.a8.LANDSCAPE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.b8.a(android.content.Context, com.chartboost.sdk.impl.b4):com.chartboost.sdk.impl.a8");
    }

    public static final int a(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getRotation();
    }

    public static final void a(Activity activity, o9 o9Var, b4 displayMeasurement) {
        Intrinsics.checkNotNullParameter(displayMeasurement, "displayMeasurement");
        if (activity == null || a(activity) || o9Var == null) {
            return;
        }
        int i = 1;
        if (o9Var.h() && o9Var.j()) {
            switch (a.f978a[a(activity, displayMeasurement).ordinal()]) {
                case 1:
                case 2:
                    break;
                case 3:
                case 4:
                    i = 9;
                    break;
                case 5:
                case 6:
                    i = 0;
                    break;
                default:
                    i = 8;
                    break;
            }
            activity.setRequestedOrientation(i);
        }
    }

    public static final boolean a(Activity activity) {
        Window window;
        View decorView;
        Drawable background;
        return activity == null || (Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && ((window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (background = decorView.getBackground()) == null || background.getAlpha() != 255));
    }

    public static final void a(Activity activity, o9 o9Var) {
        if (activity == null || a(activity) || o9Var == null || !o9Var.h() || !o9Var.j()) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }
}
