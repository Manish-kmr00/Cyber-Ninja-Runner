package com.yandex.mobile.ads.impl;

import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class lo0 {
    public static final a c = new a(0);
    private static volatile lo0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9548a;
    private final WeakHashMap<ju, ct> b;

    public final void b(ju videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        synchronized (this.f9548a) {
            this.b.remove(videoPlayer);
        }
    }

    private lo0() {
        this.f9548a = new Object();
        this.b = new WeakHashMap<>();
    }

    public /* synthetic */ lo0(int i) {
        this();
    }

    public final ct a(ju videoPlayer) {
        ct ctVar;
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        synchronized (this.f9548a) {
            ctVar = this.b.get(videoPlayer);
        }
        return ctVar;
    }

    public final void a(ju videoPlayer, ct adBinder) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(adBinder, "adBinder");
        synchronized (this.f9548a) {
            this.b.put(videoPlayer, adBinder);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class a {
        public final lo0 a() {
            lo0 lo0Var = lo0.d;
            if (lo0Var == null) {
                synchronized (this) {
                    lo0Var = lo0.d;
                    if (lo0Var == null) {
                        lo0Var = new lo0(0);
                        lo0.d = lo0Var;
                    }
                }
            }
            return lo0Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
