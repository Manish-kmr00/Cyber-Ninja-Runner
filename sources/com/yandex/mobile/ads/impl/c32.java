package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c32 {
    private static volatile c32 b;
    private static final Object c = new Object();
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap f8566a;

    public static final class a {
        public static c32 a() {
            if (c32.b == null) {
                synchronized (c32.c) {
                    if (c32.b == null) {
                        c32.b = new c32(0);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            c32 c32Var = c32.b;
            if (c32Var != null) {
                return c32Var;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public final void b(tq0 referenceType, Object keepingObject) {
        Intrinsics.checkNotNullParameter(referenceType, "referenceType");
        Intrinsics.checkNotNullParameter(keepingObject, "keepingObject");
        synchronized (c) {
            Set linkedHashSet = (Set) this.f8566a.get(referenceType);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                this.f8566a.put(referenceType, linkedHashSet);
            }
            linkedHashSet.add(keepingObject);
        }
    }

    private c32() {
        this.f8566a = new LinkedHashMap();
    }

    public final void a(tq0 referenceType, Object keepingObject) {
        Intrinsics.checkNotNullParameter(referenceType, "referenceType");
        Intrinsics.checkNotNullParameter(keepingObject, "keepingObject");
        synchronized (c) {
            Set set = (Set) this.f8566a.get(referenceType);
            if (set != null) {
                set.remove(keepingObject);
            }
        }
    }

    public /* synthetic */ c32(int i) {
        this();
    }
}
