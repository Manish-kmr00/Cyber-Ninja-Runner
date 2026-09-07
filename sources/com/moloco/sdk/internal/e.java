package com.moloco.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {
    public static final String a() {
        String packageName = com.moloco.sdk.internal.android_context.b.a(null, 1, null).getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "ApplicationContext().packageName");
        return packageName;
    }
}
