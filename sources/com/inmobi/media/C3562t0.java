package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3562t0 extends AbstractRunnableC3521q1 {
    public final /* synthetic */ C0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ M1 f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3562t0(C0 c0, String str, M1 m1, String str2, String str3) {
        super(c0);
        this.d = c0;
        this.e = str;
        this.f = m1;
        this.g = str2;
        this.h = str3;
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C0 c0 = (C0) this.b.get();
        if (c0 != null) {
            try {
                C3389h c3389hM = c0.m();
                if (c3389hM == null || !Intrinsics.areEqual(c3389hM.s(), this.e)) {
                    L4 l4 = this.d.j;
                    if (l4 != null) {
                        String strE = C0.e();
                        Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                        ((M4) l4).c(strE, "Returning blob as empty string");
                    }
                    M1 m1 = this.f;
                    String jsCallbackNamespace = this.g;
                    String callback = this.h;
                    Ba ba = (Ba) m1;
                    ba.getClass();
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    Intrinsics.checkNotNullParameter("", "blob");
                    L4 l5 = ba.i;
                    if (l5 != null) {
                        String TAG = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l5).a(TAG, "retrievedBlob");
                    }
                    ba.a(jsCallbackNamespace, callback + "();");
                    return;
                }
                String blob = c3389hM.F();
                M1 m2 = this.f;
                String jsCallbackNamespace2 = this.g;
                String callback2 = this.h;
                Ba ba2 = (Ba) m2;
                ba2.getClass();
                Intrinsics.checkNotNullParameter(jsCallbackNamespace2, "jsCallbackNamespace");
                Intrinsics.checkNotNullParameter(callback2, "callback");
                Intrinsics.checkNotNullParameter(blob, "blob");
                L4 l6 = ba2.i;
                if (l6 != null) {
                    String TAG2 = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l6).a(TAG2, "retrievedBlob");
                }
                ba2.a(jsCallbackNamespace2, callback2 + '(' + blob + ");");
                L4 l7 = this.d.j;
                if (l7 != null) {
                    String strE2 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
                    ((M4) l7).c(strE2, "Returning blob " + blob);
                }
            } catch (Exception e) {
                L4 l8 = this.d.j;
                if (l8 != null) {
                    String strE3 = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE3, "<get-TAG>(...)");
                    ((M4) l8).a(strE3, "Exception while getBlob", e);
                }
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }
}
