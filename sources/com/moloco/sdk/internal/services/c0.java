package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6356a;
    public final y b;

    public c0(Context context, y deviceInfoService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        this.f6356a = context;
        this.b = deviceInfoService;
    }

    @Override // com.moloco.sdk.internal.services.b0
    public boolean a() {
        Object systemService = this.f6356a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return c((ConnectivityManager) systemService);
    }

    @Override // com.moloco.sdk.internal.services.b0
    public Integer b() {
        Object systemService = this.f6356a.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(networkOperator, "networkOperator");
        String strSubstring = networkOperator.substring(3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.b0
    public a0 c() {
        Object systemService = this.f6356a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return b((ConnectivityManager) systemService);
    }

    @Override // com.moloco.sdk.internal.services.b0
    public Integer d() {
        Object systemService = this.f6356a.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkOperator = ((TelephonyManager) systemService).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() == 0) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(networkOperator, "networkOperator");
        String strSubstring = networkOperator.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Integer.valueOf(Integer.parseInt(strSubstring));
    }

    @Override // com.moloco.sdk.internal.services.b0
    @Deprecated(message = "Use networkInfo()", replaceWith = @ReplaceWith(expression = "networkInfo()", imports = {}))
    public a0 invoke() {
        return c();
    }

    public final a0 a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        Integer numValueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return a0.c.f6301a;
        }
        return (numValueOf != null && numValueOf.intValue() == 0) ? new a0.a(this.b.invoke().q()) : a0.b.f6300a;
    }

    public final a0 b(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (connectivityManager.getActiveNetwork() != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
            if (networkCapabilities.hasTransport(1)) {
                return a0.c.f6301a;
            }
            return networkCapabilities.hasTransport(0) ? new a0.a(this.b.invoke().q()) : a0.b.f6300a;
        }
        return a0.b.f6300a;
    }

    public final boolean c(ConnectivityManager connectivityManager) {
        return connectivityManager.getRestrictBackgroundStatus() == 3;
    }
}
