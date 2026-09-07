package com.inmobi.media;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class T4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3200a;
    public static String b;
    public static final String c;

    static {
        Lazy lazy = LazyKt.lazy(S4.f3189a);
        f3200a = lazy;
        c = "T4";
        Intrinsics.checkNotNull("T4");
        K5 k5 = (K5) lazy.getValue();
        String string = null;
        if (k5 != null) {
            Intrinsics.checkNotNullParameter("cip", "key");
            string = k5.f3112a.getString("cip", null);
        }
        b = string;
    }

    public static void a() {
        b = null;
        K5 k5 = (K5) f3200a.getValue();
        if (k5 != null) {
            k5.a("cip");
        }
        Intrinsics.checkNotNull(c);
    }
}
