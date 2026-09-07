package com.yandex.mobile.ads.impl;

import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class pn1 {
    public static final a b = new a(0);
    private static final Object c = new Object();
    private static volatile pn1 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f9943a;

    private pn1() {
        this.f9943a = new WeakHashMap();
    }

    public /* synthetic */ pn1(int i) {
        this();
    }

    public final String a(np1<?> request) {
        String str;
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (c) {
            str = (String) this.f9943a.get(request);
            this.f9943a.remove(request);
        }
        return str;
    }

    public final void a(zj request, String response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        synchronized (c) {
            this.f9943a.put(request, response);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class a {
        @JvmStatic
        public final pn1 a() {
            pn1 pn1Var = pn1.d;
            if (pn1Var == null) {
                synchronized (this) {
                    pn1Var = pn1.d;
                    if (pn1Var == null) {
                        pn1Var = new pn1(0);
                        pn1.d = pn1Var;
                    }
                }
            }
            return pn1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
