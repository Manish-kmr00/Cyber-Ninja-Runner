package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes7.dex */
public final class fz1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8953a;

        static {
            int[] iArr = new int[pz1.values().length];
            try {
                int i = pz1.d;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int i2 = pz1.d;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8953a = iArr;
        }
    }

    public static ez1 a(m6 m6Var) {
        n6 n6VarB;
        pz1 pz1VarC = (m6Var == null || (n6VarB = m6Var.b()) == null) ? null : n6VarB.c();
        int i = pz1VarC == null ? -1 : a.f8953a[pz1VarC.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return new bi2();
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new l00();
    }
}
