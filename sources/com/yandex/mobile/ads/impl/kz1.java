package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class kz1 {
    private static final HashSet b = new HashSet(CollectionsKt.listOf((Object[]) new u42[]{u42.c, u42.b}));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w42 f9463a;

    public final gd2 a(ru creative) {
        Intrinsics.checkNotNullParameter(creative, "creative");
        int iD = creative.d();
        lz1 lz1VarH = creative.h();
        if (lz1VarH != null) {
            fa2 fa2VarA = this.f9463a.a(lz1VarH.a());
            if (fa2VarA != null) {
                float fD = fa2VarA.d();
                if (fa2.b.c == fa2VarA.c()) {
                    fD = (long) ((fD / 100) * iD);
                }
                return new gd2((long) Math.min(fD, iD));
            }
        }
        return null;
    }

    public /* synthetic */ kz1() {
        this(new w42(b));
    }

    public kz1(w42 timeOffsetParser) {
        Intrinsics.checkNotNullParameter(timeOffsetParser, "timeOffsetParser");
        this.f9463a = timeOffsetParser;
    }
}
