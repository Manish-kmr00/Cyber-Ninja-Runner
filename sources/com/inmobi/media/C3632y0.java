package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3632y0 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0 f3481a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3632y0(C0 c0) {
        super(1);
        this.f3481a = c0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        I3 it = (I3) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        L4 l4 = this.f3481a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).b(strE, "load with retry failed - max retry reached - No network");
        }
        this.f3481a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC3303ac.a(it));
        return Unit.INSTANCE;
    }
}
