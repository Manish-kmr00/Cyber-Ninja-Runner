package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10009a;
    private final g10 b;

    public qe(Context context, g10 deviceInfoProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceInfoProvider, "deviceInfoProvider");
        this.f10009a = context;
        this.b = deviceInfoProvider;
    }

    public final uw a() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        PackageManager packageManager = this.f10009a.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            packageInfo = packageManager.getPackageInfo(this.f10009a.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } else {
            packageInfo = packageManager.getPackageInfo(this.f10009a.getPackageName(), 0);
        }
        this.b.getClass();
        String strB = g10.b();
        if (strB == null) {
            strB = "Undefined";
        }
        String str = "Android " + strB;
        String str2 = "API " + i;
        String packageName = packageInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        String versionName = packageInfo.versionName;
        Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
        return new uw(packageName, versionName, str, str2);
    }
}
