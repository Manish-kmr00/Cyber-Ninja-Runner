package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final el f8674a;

    public da(el biddingSettings) {
        Intrinsics.checkNotNullParameter(biddingSettings, "biddingSettings");
        this.f8674a = biddingSettings;
    }

    public final ba a(String str) {
        Object next;
        Iterator<T> it = this.f8674a.c().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((ba) next).e(), str)) {
                return (ba) next;
            }
        }
        next = null;
        return (ba) next;
    }
}
