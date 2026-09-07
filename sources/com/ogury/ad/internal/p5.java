package com.ogury.ad.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f7384a;

    public p5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter("android.permission.ACCESS_NETWORK_STATE", "permission");
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            this.f7384a = (ConnectivityManager) systemService;
        }
    }
}
