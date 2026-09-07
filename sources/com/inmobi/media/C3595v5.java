package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.v5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3595v5 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3609w5 f3455a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3595v5(C3609w5 c3609w5) {
        super(1);
        this.f3455a = c3609w5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        I3 it = (I3) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f3455a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC3303ac.a(it));
        return Unit.INSTANCE;
    }
}
