package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4033c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S6 f11490a;
    public final Fg b;

    public C4033c5(S6 s6, Fg fg) {
        this.f11490a = s6;
        this.b = fg;
    }

    public final List<J8> a() {
        return CollectionsKt.listOf((Object[]) new J8[]{new K5(this.f11490a), new Kc(this.f11490a, this.b)});
    }

    public final List<J8> b() {
        return CollectionsKt.emptyList();
    }
}
