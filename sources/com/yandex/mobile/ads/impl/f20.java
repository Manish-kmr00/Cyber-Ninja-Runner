package com.yandex.mobile.ads.impl;

import com.yandex.div2.DivBase;
import com.yandex.div2.DivExtension;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f20 {
    public static DivExtension a(DivBase divBase, String extensionId) {
        Intrinsics.checkNotNullParameter(divBase, "divBase");
        Intrinsics.checkNotNullParameter(extensionId, "extensionId");
        List<DivExtension> extensions = divBase.getExtensions();
        if (extensions == null) {
            return null;
        }
        for (DivExtension divExtension : extensions) {
            if (Intrinsics.areEqual(extensionId, divExtension.id)) {
                return divExtension;
            }
        }
        return null;
    }
}
