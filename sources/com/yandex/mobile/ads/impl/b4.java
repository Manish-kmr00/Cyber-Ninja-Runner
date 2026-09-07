package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k4> f8473a;
    private int b;

    public b4(ArrayList adGroupPlaybackItems) {
        Intrinsics.checkNotNullParameter(adGroupPlaybackItems, "adGroupPlaybackItems");
        this.f8473a = adGroupPlaybackItems;
    }

    public final rb2<do0> b() {
        k4 k4Var = (k4) CollectionsKt.getOrNull(this.f8473a, this.b);
        if (k4Var != null) {
            return k4Var.c();
        }
        return null;
    }

    public final ao0 c() {
        k4 k4Var = (k4) CollectionsKt.getOrNull(this.f8473a, this.b);
        if (k4Var != null) {
            return k4Var.a();
        }
        return null;
    }

    public final eg2 d() {
        k4 k4Var = (k4) CollectionsKt.getOrNull(this.f8473a, this.b);
        if (k4Var != null) {
            return k4Var.d();
        }
        return null;
    }

    public final k4 e() {
        return (k4) CollectionsKt.getOrNull(this.f8473a, this.b + 1);
    }

    public final k4 f() {
        int i = this.b + 1;
        this.b = i;
        return (k4) CollectionsKt.getOrNull(this.f8473a, i);
    }

    public final void a() {
        this.b = this.f8473a.size();
    }

    public final k4 a(rb2<do0> videoAdInfo) {
        Object next;
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Iterator<T> it = this.f8473a.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((k4) next).c(), videoAdInfo)) {
                return (k4) next;
            }
        }
        next = null;
        return (k4) next;
    }
}
