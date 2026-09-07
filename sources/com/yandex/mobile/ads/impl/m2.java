package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m2 {
    private static final Object b = new Object();
    private static volatile m2 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l2 f9590a;

    public static final class a {
        @JvmStatic
        public static m2 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (m2.c == null) {
                synchronized (m2.b) {
                    if (m2.c == null) {
                        int i = ns0.b;
                        Intrinsics.checkNotNullParameter(context, "context");
                        m2.c = new m2(ns0.a(context, "YadPreferenceFile"));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            m2 m2Var = m2.c;
            if (m2Var != null) {
                return m2Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    private m2(l2 l2Var) {
        this.f9590a = l2Var;
    }

    /* synthetic */ m2(ls0 ls0Var) {
        this(new l2(ls0Var));
    }

    public final l2 c() {
        return this.f9590a;
    }
}
