package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class I7 implements InterfaceC3486n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ L7 f3096a;
    public final /* synthetic */ C3426j8 b;

    public I7(L7 l7, C3426j8 c3426j8) {
        this.f3096a = l7;
        this.b = c3426j8;
    }

    public final void a(byte b) {
        C3313b7 c3313b7 = this.f3096a.b;
        if (c3313b7.t || !(c3313b7 instanceof C3398h8) || b == 4) {
            return;
        }
        try {
            if (b == 0) {
                Sc sc = ((C3398h8) c3313b7).p;
                if (sc != null) {
                    sc.a((byte) 5);
                }
            } else if (b == 1) {
                ((C3398h8) c3313b7).g(this.b);
            } else if (b == 2) {
                ((C3398h8) c3313b7).f(this.b);
            } else if (b == 3) {
                ((C3398h8) c3313b7).h(this.b);
            } else if (b != 5) {
            } else {
                ((C3398h8) c3313b7).d(this.b);
            }
        } catch (Exception e) {
            L7 l7 = this.f3096a;
            L4 l4 = l7.f;
            if (l4 != null) {
                String str = l7.g;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4).b(str, ld.a(e, new StringBuilder("SDK encountered unexpected error in handling (").append((int) b).append(") event; ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
