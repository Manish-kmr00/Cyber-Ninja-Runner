package com.five_corp.ad.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes11.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1264a;
    public final String b;

    public E(Context context) {
        this.f1264a = context;
        this.b = com.five_corp.ad.internal.tracking_data.c.a(context);
    }

    public final int a(int i) {
        return (int) TypedValue.applyDimension(1, i, this.f1264a.getResources().getDisplayMetrics());
    }

    public final Rect b() {
        if (Build.VERSION.SDK_INT > 30) {
            return ((WindowManager) this.f1264a.getSystemService("window")).getCurrentWindowMetrics().getBounds();
        }
        Display defaultDisplay = ((WindowManager) this.f1264a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Rect(0, 0, point.x, point.y);
    }

    public final com.five_corp.ad.internal.util.f a() {
        try {
            PackageInfo packageInfoA = com.five_corp.ad.internal.system.i.a(this.f1264a, "com.google.android.gms");
            return Build.VERSION.SDK_INT < 28 ? new com.five_corp.ad.internal.util.f(true, null, Integer.valueOf(packageInfoA.versionCode)) : new com.five_corp.ad.internal.util.f(true, null, Integer.valueOf((int) (packageInfoA.getLongVersionCode() & 4294967295L)));
        } catch (Exception e) {
            return new com.five_corp.ad.internal.util.f(false, new o(p.H, "Unknown error occurred when fetching Google Play Services version.", e, null), null);
        }
    }
}
