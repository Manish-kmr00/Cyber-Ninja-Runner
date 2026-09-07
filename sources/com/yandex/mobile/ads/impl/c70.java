package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c70 {
    private static final Object b = new Object();
    private static volatile c70 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b70 f8574a;

    public static final class a {
        @JvmStatic
        public static c70 a() {
            c70 c70Var;
            c70 c70Var2 = c70.c;
            if (c70Var2 != null) {
                return c70Var2;
            }
            synchronized (c70.b) {
                c70Var = c70.c;
                if (c70Var == null) {
                    c70Var = new c70(0);
                    c70.c = c70Var;
                }
            }
            return c70Var;
        }
    }

    private c70() {
        this.f8574a = new b70(ff2.a());
    }

    public final oa1 a(rb2<?> videoAdInfo) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        return this.f8574a.get(videoAdInfo);
    }

    public /* synthetic */ c70(int i) {
        this();
    }

    public final void a(rb2 videoAdInfo, f70 exoVideoAdPlayer) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(exoVideoAdPlayer, "exoVideoAdPlayer");
        this.f8574a.put(videoAdInfo, exoVideoAdPlayer);
    }
}
