package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r11 {
    private static r11 b;
    private static final Object c = new Object();
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<q11> f10065a;

    public static final class a {
        @JvmStatic
        public static r11 a() {
            r11 r11Var;
            r11 r11Var2 = r11.b;
            if (r11Var2 != null) {
                return r11Var2;
            }
            synchronized (r11.c) {
                r11Var = r11.b;
                if (r11Var == null) {
                    r11Var = new r11(0);
                    r11.b = r11Var;
                }
            }
            return r11Var;
        }
    }

    public final void c() {
        synchronized (c) {
            this.f10065a.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private r11() {
        this.f10065a = new ArrayDeque<>();
    }

    public final void a(g11 type, String tag, String text) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(text, "text");
        if (h11.f9051a.a()) {
            q11 q11Var = new q11(System.currentTimeMillis(), type.name(), tag, text);
            synchronized (c) {
                if (this.f10065a.size() > 5000) {
                    this.f10065a.removeFirst();
                }
                this.f10065a.add(q11Var);
            }
        }
    }

    public /* synthetic */ r11(int i) {
        this();
    }

    public final List<q11> d() {
        List<q11> list;
        synchronized (c) {
            list = CollectionsKt.toList(this.f10065a);
        }
        return list;
    }
}
