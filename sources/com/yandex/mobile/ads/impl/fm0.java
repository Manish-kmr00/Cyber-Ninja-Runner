package com.yandex.mobile.ads.impl;

import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class fm0 {
    public static final a c = new a(0);
    private static volatile fm0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8907a;
    private final WeakHashMap<gt, a82> b;

    public final void b(gt instreamAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        synchronized (this.f8907a) {
            this.b.remove(instreamAdPlayer);
        }
    }

    private fm0() {
        this.f8907a = new Object();
        this.b = new WeakHashMap<>();
    }

    public /* synthetic */ fm0(int i) {
        this();
    }

    public final a82 a(gt instreamAdPlayer) {
        a82 a82Var;
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        synchronized (this.f8907a) {
            a82Var = this.b.get(instreamAdPlayer);
        }
        return a82Var;
    }

    public final void a(gt instreamAdPlayer, a82 adBinder) {
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        Intrinsics.checkNotNullParameter(adBinder, "adBinder");
        synchronized (this.f8907a) {
            this.b.put(instreamAdPlayer, adBinder);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class a {
        public final fm0 a() {
            fm0 fm0Var = fm0.d;
            if (fm0Var == null) {
                synchronized (this) {
                    fm0Var = fm0.d;
                    if (fm0Var == null) {
                        fm0Var = new fm0(0);
                        fm0.d = fm0Var;
                    }
                }
            }
            return fm0Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
