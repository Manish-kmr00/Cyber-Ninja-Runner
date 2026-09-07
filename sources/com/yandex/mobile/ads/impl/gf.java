package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile xi0 f8998a;

    @JvmStatic
    public static final xi0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f8998a == null) {
            synchronized (xi0.h) {
                if (f8998a == null) {
                    Context context2 = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
                    pf pfVarA = ve.a();
                    hf hfVar = new hf();
                    ff ffVar = new ff(new ef(), ve.a());
                    int i = ns0.b;
                    Intrinsics.checkNotNullParameter(context2, "context");
                    f8998a = new xi0(context2, pfVarA, hfVar, ffVar, new ju0(ns0.a(context2, "YadPreferenceFile")));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        xi0 xi0Var = f8998a;
        Intrinsics.checkNotNull(xi0Var);
        return xi0Var;
    }
}
