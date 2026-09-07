package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class X6 implements InterfaceC3519q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3235a;

    public X6(C3313b7 c3313b7) {
        this.f3235a = c3313b7;
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a() {
        Intrinsics.checkNotNullExpressionValue(this.f3235a.m, "access$getTAG$p(...)");
        A0 a0 = this.f3235a.w;
        if (a0 != null) {
            a0.c();
        }
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void b(Object obj) {
        A0 a0 = this.f3235a.w;
        if (a0 != null) {
            a0.b();
        }
        L4 l4 = this.f3235a.j;
        if (l4 != null) {
            ((M4) l4).a();
        }
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a(Object obj) {
        A0 a0;
        if (this.f3235a.f() == null || (a0 = this.f3235a.w) == null) {
            return;
        }
        a0.d();
    }
}
