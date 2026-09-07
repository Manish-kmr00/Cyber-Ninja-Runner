package com.yandex.mobile.ads.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 {
    private static final String b = "com.yandex.mobile.ads.common.AdActivity";
    private static final String c = "There is no presence of com.yandex.mobile.ads.common.AdActivity activity in AndroidManifest file.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a1 f9161a = new a1();

    public final void a(Context context) throws xo0 {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), b), 0);
            Intrinsics.checkNotNullExpressionValue(activityInfo, "getActivityInfo(...)");
            this.f9161a.getClass();
            a1.a(activityInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            String str = c;
            throw new xo0(str, str);
        }
    }
}
