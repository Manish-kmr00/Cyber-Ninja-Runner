package com.inmobi.media;

import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class Nc extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Nc f3151a = new Nc();

    public Nc() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Oc oc = Oc.f3161a;
        Intrinsics.checkNotNullExpressionValue("Oc", "access$getTAG$p(...)");
        return Executors.newCachedThreadPool(new V4("Oc"));
    }
}
