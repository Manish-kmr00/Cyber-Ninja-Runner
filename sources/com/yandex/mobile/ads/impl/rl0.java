package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rl0 {
    private static final Object b = new Object();
    private static volatile rl0 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<View, ct> f10118a;

    public static final class a {
        @JvmStatic
        public static rl0 a() {
            if (rl0.c == null) {
                synchronized (rl0.b) {
                    if (rl0.c == null) {
                        rl0.c = new rl0(0);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            rl0 rl0Var = rl0.c;
            if (rl0Var != null) {
                return rl0Var;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    private rl0() {
        this.f10118a = new WeakHashMap<>();
    }

    public /* synthetic */ rl0(int i) {
        this();
    }

    public final ct a(View view) {
        ct ctVar;
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (b) {
            ctVar = this.f10118a.get(view);
        }
        return ctVar;
    }

    public final void a(View view, ct instreamAdBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(instreamAdBinder, "instreamAdBinder");
        synchronized (b) {
            this.f10118a.put(view, instreamAdBinder);
        }
    }

    public final boolean a(ct instreamAdBinder) {
        boolean z;
        Intrinsics.checkNotNullParameter(instreamAdBinder, "instreamAdBinder");
        synchronized (b) {
            Set<Map.Entry<View, ct>> setEntrySet = this.f10118a.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
            Iterator<Map.Entry<View, ct>> it = setEntrySet.iterator();
            z = false;
            while (it.hasNext()) {
                if (instreamAdBinder == it.next().getValue()) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }
}
