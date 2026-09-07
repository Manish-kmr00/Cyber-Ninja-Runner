package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3646z0 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0 f3491a;
    public final /* synthetic */ byte[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3646z0(C0 c0, byte[] bArr) {
        super(0);
        this.f3491a = c0;
        this.b = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f3491a.d((byte) 1);
        L4 l4 = this.f3491a.j;
        if (l4 != null) {
            String strE = C0.e();
            ((M4) l4).d(strE, O5.a(strE, "<get-TAG>(...)", "AdUnit ").append(this.f3491a).append(" state - LOADING").toString());
        }
        L4 l5 = this.f3491a.j;
        if (l5 != null) {
            String strE2 = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE2, "<get-TAG>(...)");
            ((M4) l5).c(strE2, "starting load with response worker");
        }
        C3575u c3575uV = this.f3491a.v();
        int iHashCode = this.f3491a.hashCode();
        C0 c0 = this.f3491a;
        C3343d9 c3343d9H = c0.H();
        Intrinsics.checkNotNull(c3343d9H);
        C3326c6 c3326c6 = new C3326c6(c0, c3343d9H, this.b, this.f3491a.I().l(), this.f3491a.j);
        c3575uV.getClass();
        C3575u.a(iHashCode, c3326c6);
        return Unit.INSTANCE;
    }
}
