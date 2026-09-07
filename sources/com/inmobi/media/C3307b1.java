package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.b1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3307b1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3307b1 f3271a = new C3307b1();

    public C3307b1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 event = (N1) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        int i = event.f3141a;
        if (i == 1 || i == 2) {
            C3335d1 c3335d1 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
            C3335d1.m.set(false);
        } else if (i != 10) {
            C3335d1 c3335d2 = C3335d1.f3289a;
            Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        } else if (Intrinsics.areEqual("available", event.b)) {
            C3335d1 c3335d3 = C3335d1.f3289a;
            if (!C3335d1.j.get()) {
                c3335d3.c();
            }
        } else {
            C3335d1 c3335d4 = C3335d1.f3289a;
            C3335d1.d();
        }
        return Unit.INSTANCE;
    }
}
