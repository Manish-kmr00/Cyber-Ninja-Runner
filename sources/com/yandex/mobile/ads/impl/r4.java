package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r4 {
    private static final Object c = new Object();
    private static volatile r4 d;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f10071a;
    private final ArrayList b;

    public static final class a {
        @JvmStatic
        public static r4 a() {
            r4 r4Var;
            r4 r4Var2 = r4.d;
            if (r4Var2 != null) {
                return r4Var2;
            }
            synchronized (r4.c) {
                r4Var = r4.d;
                if (r4Var == null) {
                    r4Var = new r4(0);
                    r4.d = r4Var;
                }
            }
            return r4Var;
        }
    }

    public final void b(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (c) {
            this.f10071a.remove(id);
            this.f10071a.add(id);
        }
    }

    private r4() {
        this.f10071a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void a(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (c) {
            this.b.remove(id);
            this.b.add(id);
        }
    }

    public /* synthetic */ r4(int i) {
        this();
    }

    public final List<String> d() {
        List<String> list;
        synchronized (c) {
            list = CollectionsKt.toList(this.f10071a);
        }
        return list;
    }

    public final List<String> c() {
        List<String> list;
        synchronized (c) {
            list = CollectionsKt.toList(this.b);
        }
        return list;
    }
}
