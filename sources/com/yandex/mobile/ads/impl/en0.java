package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class en0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f8814a;

    public final ig<?> a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        List<ig<?>> list = this.f8814a;
        Object obj = null;
        if (list == null) {
            return null;
        }
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((ig) obj2).b(), assetName)) {
                obj = obj2;
                break;
            }
        }
        return (ig) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public en0(List<? extends ig<?>> list) {
        this.f8814a = list;
    }
}
