package com.ogury.ad.internal;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l8 f7347a = new l8();

    public static void a(Context context) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        if ((context.getApplicationInfo().flags & 2) == 0) {
            return;
        }
        IntegrationLogger.d("[Ads][setup] Checking permissions...");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter("android.permission.INTERNET", "permission");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            IntegrationLogger.d("[Ads][setup] Permissions checked");
        } else {
            IntegrationLogger.e("[Ads][setup] No Internet permission");
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        IntegrationLogger.d("[Ads][setup] Checking components...");
        Intrinsics.checkNotNull(packageInfo);
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            a(activityInfoArr, "com.ogury.ad.interstitial.ui.InterstitialActivity");
            a(activityInfoArr, "com.ogury.ad.interstitial.ui.InterstitialAndroid8TransparentActivity");
            a(activityInfoArr, "com.ogury.ad.interstitial.ui.InterstitialAndroid8RotableActivity");
        }
        IntegrationLogger.d("[Ads][setup] Components checked");
    }

    public static void a(ActivityInfo[] activityInfoArr, String str) {
        for (ActivityInfo activityInfo : activityInfoArr) {
            if (Intrinsics.areEqual(activityInfo.name, str)) {
                return;
            }
        }
        IntegrationLogger.e("[Ads][setup] Missing activity: " + str);
    }
}
