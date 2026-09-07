package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7412a;
    public final String b;

    public u4(String adId, String name) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f7412a = adId;
        this.b = name;
    }
}
