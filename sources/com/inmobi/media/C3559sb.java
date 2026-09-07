package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3559sb extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3559sb f3430a = new C3559sb();

    public C3559sb() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C3587ub.f3446a.getClass();
        K5 k5 = C3587ub.j;
        int i = 0;
        if (k5 != null) {
            Intrinsics.checkNotNullParameter(com.safedk.android.analytics.brandsafety.l.R, "key");
            i = k5.f3112a.getInt(com.safedk.android.analytics.brandsafety.l.R, 0);
        }
        return Integer.valueOf(i);
    }
}
