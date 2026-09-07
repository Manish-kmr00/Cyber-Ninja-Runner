package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a4 {
    @JvmStatic
    public static final void a(String adType, ArrayList errors) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(errors, "errors");
        if (errors.isEmpty()) {
            return;
        }
        dp0.a(z0.a(new Object[]{adType, CollectionsKt.joinToString$default(errors, "\n - ", "\n - ", null, 0, null, null, 60, null)}, 2, "Found following errors for %s ad type: %s", "format(...)"), new Object[0]);
    }

    @JvmStatic
    public static final void a(String adConfigurationInfo) {
        Intrinsics.checkNotNullParameter(adConfigurationInfo, "adConfigurationInfo");
        dp0.b(z0.a(new Object[]{adConfigurationInfo}, 1, "Ad type %s was integrated successfully", "format(...)"), new Object[0]);
    }
}
