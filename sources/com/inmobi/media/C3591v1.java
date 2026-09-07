package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3591v1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3605w1 f3451a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3591v1(C3605w1 c3605w1) {
        super(1);
        this.f3451a = c3605w1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        I3 it = (I3) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C3605w1 c3605w1 = this.f3451a;
        L4 l4 = c3605w1.j;
        if (l4 != null) {
            String str = c3605w1.M;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).b(str, "loadWithRetry error - " + it);
        }
        this.f3451a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC3303ac.a(it));
        return Unit.INSTANCE;
    }
}
