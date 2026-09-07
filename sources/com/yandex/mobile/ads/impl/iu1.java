package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class iu1 {
    private static final Object b = new Object();
    private static volatile iu1 c;
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f9256a;

    public static final class a {
        public static iu1 a() {
            iu1 iu1Var;
            iu1 iu1Var2 = iu1.c;
            if (iu1Var2 != null) {
                return iu1Var2;
            }
            synchronized (iu1.b) {
                iu1Var = iu1.c;
                if (iu1Var == null) {
                    iu1Var = new iu1(0);
                    iu1.c = iu1Var;
                }
            }
            return iu1Var;
        }
    }

    private iu1() {
        this.f9256a = new HashMap();
    }

    public final void a(Context context, cu1 sdkConfiguration) {
        HashSet hashSet;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        synchronized (b) {
            hashSet = new HashSet(this.f9256a.keySet());
            int i = iw1.l;
            iw1.a.a().a(context, sdkConfiguration);
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((su1) it.next()).a(context, sdkConfiguration);
        }
    }

    public /* synthetic */ iu1(int i) {
        this();
    }

    public final void a(eu1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (b) {
            if (!this.f9256a.containsKey(listener)) {
                this.f9256a.put(listener, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
