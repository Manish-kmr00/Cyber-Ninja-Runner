package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class z21 {
    public static final a c = new a(0);
    private static volatile z21 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10785a;
    private final WeakHashMap<su0, s21> b;

    public final s21 b(su0 media) {
        Intrinsics.checkNotNullParameter(media, "media");
        return this.b.remove(media);
    }

    private z21(int i) {
        this.f10785a = i;
        this.b = new WeakHashMap<>();
    }

    public final boolean a(su0 media) {
        Intrinsics.checkNotNullParameter(media, "media");
        return this.b.containsKey(media);
    }

    public /* synthetic */ z21(int i, int i2) {
        this(i);
    }

    public static final class a {
        public final z21 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            z21 z21Var = z21.d;
            if (z21Var == null) {
                synchronized (this) {
                    z21Var = z21.d;
                    if (z21Var == null) {
                        int i = iw1.l;
                        cu1 cu1VarA = iw1.a.a().a(context);
                        z21 z21Var2 = new z21(cu1VarA != null ? cu1VarA.D() : 0, 0);
                        z21.d = z21Var2;
                        z21Var = z21Var2;
                    }
                }
            }
            return z21Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    public final void a(s21 mraidWebView, su0 media) {
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        if (this.b.size() < this.f10785a) {
            this.b.put(media, mraidWebView);
        }
    }

    public final boolean b() {
        return this.b.size() == this.f10785a;
    }
}
