package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.d2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3336d2 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3336d2 f3290a = new C3336d2();

    public C3336d2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f3141a;
        if (i == 1 || i == 2) {
            Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
            C3364f2.h.set(false);
        } else if (i != 10) {
            if (i != 11) {
                Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
            } else if (!Boolean.parseBoolean(it.b)) {
                C3364f2.f3308a.h();
            }
        } else if (Intrinsics.areEqual("available", it.b)) {
            C3364f2.f3308a.h();
        }
        return Unit.INSTANCE;
    }
}
