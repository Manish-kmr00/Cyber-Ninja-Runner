package com.inmobi.media;

import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class E0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0 f3053a;
    public final Zb b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public final D0 j;

    public E0(C0 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3053a = adUnit;
        this.b = new Zb();
        this.j = new D0(this);
    }

    public final String a() {
        C3418j0 c3418j0Y;
        LinkedList<C3389h> linkedListF;
        C3389h c3389h;
        String strW;
        C0 c0 = this.f3053a;
        return (c0 == null || (c3418j0Y = c0.y()) == null || (linkedListF = c3418j0Y.f()) == null || (c3389h = (C3389h) CollectionsKt.firstOrNull((List) linkedListF)) == null || (strW = c3389h.w()) == null) ? "" : strW;
    }
}
