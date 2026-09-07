package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d71 {
    private static final Object b = new Object();
    private static volatile d71 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<View, v81> f8668a;

    public static final class a {
        @JvmStatic
        public static d71 a() {
            d71 d71Var;
            d71 d71Var2 = d71.c;
            if (d71Var2 != null) {
                return d71Var2;
            }
            synchronized (d71.b) {
                d71Var = d71.c;
                if (d71Var == null) {
                    d71Var = new d71(new WeakHashMap());
                    d71.c = d71Var;
                }
            }
            return d71Var;
        }
    }

    public d71(Map<View, v81> nativeAdViews) {
        Intrinsics.checkNotNullParameter(nativeAdViews, "nativeAdViews");
        this.f8668a = nativeAdViews;
    }

    public final v81 a(View view) {
        v81 v81Var;
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (b) {
            v81Var = this.f8668a.get(view);
        }
        return v81Var;
    }

    public final void a(View view, v81 nativeGenericBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(nativeGenericBinder, "nativeGenericBinder");
        synchronized (b) {
            this.f8668a.put(view, nativeGenericBinder);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean a(v81 nativeGenericBinder) {
        boolean z;
        Intrinsics.checkNotNullParameter(nativeGenericBinder, "nativeGenericBinder");
        synchronized (b) {
            Iterator<Map.Entry<View, v81>> it = this.f8668a.entrySet().iterator();
            z = false;
            while (it.hasNext()) {
                if (it.next().getValue() == nativeGenericBinder) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }
}
