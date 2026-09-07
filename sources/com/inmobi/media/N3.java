package com.inmobi.media;

import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class N3 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N3 f3143a = new N3();

    public N3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Lazy lazy = O3.f3154a;
        Intrinsics.checkNotNullExpressionValue("O3", "access$getTAG$p(...)");
        return Executors.newSingleThreadScheduledExecutor(new V4("O3"));
    }
}
