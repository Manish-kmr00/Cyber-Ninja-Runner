package com.ogury.ad.internal;

import android.os.Build;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c9 {
    public static final void a(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        u3.f7411a.getClass();
    }

    public static final void a(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (!Intrinsics.areEqual("robolectric", Build.FINGERPRINT) && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Intrinsics.checkNotNullParameter(new IllegalStateException(methodName + " cannot be called from the main thread"), "<this>");
            u3.f7411a.getClass();
        }
    }
}
