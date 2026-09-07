package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.j7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3425j7 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3439k7 f3347a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3425j7(C3439k7 c3439k7) {
        super(1);
        this.f3347a = c3439k7;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        I3 it = (I3) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f3347a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC3303ac.a(it));
        return Unit.INSTANCE;
    }
}
