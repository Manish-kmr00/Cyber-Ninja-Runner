package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f8683a = new Object();
    private static volatile bq1 b;

    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    @JvmStatic
    public static final bq1 a(Context context) {
        bq1 bq1VarA;
        int iIntValue;
        Integer numE;
        Intrinsics.checkNotNullParameter(context, "context");
        bq1 bq1Var = b;
        if (bq1Var != null) {
            return bq1Var;
        }
        synchronized (f8683a) {
            bq1 bq1Var2 = b;
            if (bq1Var2 == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                int i = iw1.l;
                cu1 cu1VarA = iw1.a.a().a(context);
                if (cu1VarA == null || (numE = cu1VarA.E()) == null) {
                    iIntValue = 1;
                } else {
                    if (numE.intValue() == 0) {
                        numE = null;
                    }
                    if (numE != null) {
                        iIntValue = numE.intValue();
                    } else {
                        iIntValue = 1;
                    }
                }
                bq1VarA = cq1.a(context, iIntValue);
                b = bq1VarA;
                bq1VarA.a();
            } else {
                bq1VarA = bq1Var2;
            }
        }
        return bq1VarA;
    }
}
