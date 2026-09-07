package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a70 {
    private static final Object c = new Object();
    private static volatile a70 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z60 f8375a;
    private fy1 b;

    public static final class a {
        @JvmStatic
        public static a70 a() {
            a70 a70Var;
            a70 a70Var2 = a70.d;
            if (a70Var2 != null) {
                return a70Var2;
            }
            synchronized (a70.c) {
                a70Var = a70.d;
                if (a70Var == null) {
                    a70Var = new a70(0);
                    a70.d = a70Var;
                }
            }
            return a70Var;
        }
    }

    private a70() {
        this.f8375a = new z60();
    }

    public final rm a(Context context) {
        fy1 fy1VarA;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (c) {
            fy1VarA = this.b;
            if (fy1VarA == null) {
                fy1VarA = this.f8375a.a(context);
                this.b = fy1VarA;
            }
        }
        return fy1VarA;
    }

    public /* synthetic */ a70(int i) {
        this();
    }
}
