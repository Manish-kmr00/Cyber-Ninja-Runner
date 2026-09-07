package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.WebResourceResponse;
import android.widget.RelativeLayout;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.inmobi.media.j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3420j2 {
    public static final boolean a(String str) {
        return str != null && str.length() > 0;
    }

    public static final boolean a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        return jSONArray.length() == 0;
    }

    public static final WebResourceResponse a(InputStream inputStream, String mimeType) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*"));
        if (C3435k3.G()) {
            return new WebResourceResponse(mimeType, "UTF-8", 200, "OK", mapMapOf, inputStream);
        }
        return new WebResourceResponse(mimeType, "UTF-8", inputStream);
    }

    public static final int a(float f) {
        try {
            return (int) (f / AbstractC3565t3.b());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final int a(int i) {
        try {
            return (int) (i / AbstractC3565t3.b());
        } catch (Exception unused) {
            return i;
        }
    }

    public static final Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (C3435k3.f3355a.B()) {
            return context.registerReceiver(broadcastReceiver, filter, 2);
        }
        return context.registerReceiver(broadcastReceiver, filter);
    }

    public static final boolean a(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!C3435k3.f3355a.D()) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            i = applicationInfo != null ? applicationInfo.targetSdkVersion : -1;
        } catch (Exception unused) {
        }
        return i >= 35;
    }

    public static final void a(zd zdVar, RelativeLayout.LayoutParams layoutParams, EnumC3501o9 orientation) {
        Intrinsics.checkNotNullParameter(zdVar, "<this>");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        zdVar.getClass();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        yd ydVar = (yd) zdVar.f3497a.get(orientation);
        int i = ydVar != null ? ydVar.f3489a : 0;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        yd ydVar2 = (yd) zdVar.f3497a.get(orientation);
        int i2 = ydVar2 != null ? ydVar2.c : 0;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        yd ydVar3 = (yd) zdVar.f3497a.get(orientation);
        layoutParams.setMargins(i, 0, i2, ydVar3 != null ? ydVar3.d : 0);
    }
}
