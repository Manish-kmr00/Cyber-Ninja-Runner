package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<aj1> f9538a;
    private final dt b;
    private final dt c;

    public lm0(ArrayList midrollItems, dt dtVar, dt dtVar2) {
        Intrinsics.checkNotNullParameter(midrollItems, "midrollItems");
        this.f9538a = midrollItems;
        this.b = dtVar;
        this.c = dtVar2;
    }

    public final List<aj1> a() {
        return this.f9538a;
    }

    public final dt c() {
        return this.b;
    }

    public final dt b() {
        return this.c;
    }
}
