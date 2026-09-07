package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class B0 extends AbstractRunnableC3521q1 {
    public final /* synthetic */ C0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(C0 c0, String str, String str2) {
        super(c0);
        this.d = c0;
        this.e = str;
        this.f = str2;
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C0 c0 = (C0) this.b.get();
        if (c0 != null) {
            C3389h c3389hM = c0.m();
            if (c3389hM == null || !Intrinsics.areEqual(c3389hM.s(), this.e)) {
                L4 l4 = this.d.j;
                if (l4 != null) {
                    String strE = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                    ((M4) l4).b(strE, "Impression ID is null for saveBlob");
                    return;
                }
                return;
            }
            C0.a(c0, c3389hM, this.f);
            L4 l5 = this.d.j;
            if (l5 != null) {
                String strE2 = C0.e();
                ((M4) l5).c(strE2, O5.a(strE2, "<get-TAG>(...)", "Updated blob ").append(this.f).toString());
            }
        }
    }
}
