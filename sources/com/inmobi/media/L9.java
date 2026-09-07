package com.inmobi.media;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class L9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3126a;
    public static C3330ca b;
    public static final SignalsConfig c;
    public static int d;
    public static final Lazy e;

    static {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        c = (SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null);
        e = LazyKt.lazy(K9.f3116a);
    }

    public static boolean a(Context context) {
        boolean zContains;
        short s;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!C3435k3.G()) {
            return false;
        }
        if (!((Boolean) e.getValue()).booleanValue()) {
            S9.a(new O9((short) 2230));
            return false;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            String string = bundle != null ? bundle.getString("com.google.android.play.billingclient.version") : null;
            zContains = CollectionsKt.contains(c.getPurchases().getVersionList(), string);
            if (!zContains) {
                S9.a(new Q9(string));
            }
        } catch (Exception unused) {
            zContains = false;
        }
        if (!zContains) {
            return false;
        }
        int i = d;
        if (i != 1 && i != 2) {
            return true;
        }
        if (i != 1) {
            s = i != 2 ? (short) 0 : (short) 2232;
        } else {
            s = 2231;
        }
        S9.a(new O9(s));
        return false;
    }
}
