package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.Log;
import java.io.File;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cq1 {
    @JvmStatic
    public static final bq1 a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = wm1.b;
        boolean z = li2.f9524a;
        op0.a("Yandex Mobile Ads");
        li2.f9524a = Log.isLoggable("Yandex Mobile Ads", 2);
        li2.f9524a = false;
        wk wkVar = new wk(new ai0(context, ws1.a()).a(), new om());
        File fileA = o10.a(context, "mobileads-volley-cache");
        int i3 = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        bq1 bq1Var = new bq1(new n10(fileA, (int) f01.a.a(context, 10485760L, (cu1VarA == null || cu1VarA.A() == 0) ? 52428800L : cu1VarA.A())), wkVar, i);
        bq1Var.a(new tp1());
        return bq1Var;
    }
}
