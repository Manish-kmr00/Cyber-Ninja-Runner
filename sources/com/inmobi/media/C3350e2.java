package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.e2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3350e2 implements InterfaceC3308b2 {
    @Override // com.inmobi.media.InterfaceC3308b2
    public final void a(T1 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
        String str = click.b;
        C3364f2.b(C3364f2.f3308a, click);
        U1 u1B = AbstractC3415ib.b();
        u1B.getClass();
        Intrinsics.checkNotNullParameter(click, "click");
        u1B.a("id = ?", new String[]{String.valueOf(click.f3198a)});
    }

    @Override // com.inmobi.media.InterfaceC3308b2
    public final void a(T1 click, I3 errorCode) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
        String str = click.b;
        if (click.f == 0) {
            C3364f2.f3308a.a(click, errorCode.name());
        }
        C3364f2 c3364f2 = C3364f2.f3308a;
        C3364f2.c(c3364f2, click);
        c3364f2.h();
    }
}
