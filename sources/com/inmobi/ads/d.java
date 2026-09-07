package com.inmobi.ads;

import com.inmobi.media.B1;
import com.inmobi.media.L4;
import com.inmobi.media.M4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiBanner f3020a;
    public final /* synthetic */ byte[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InMobiBanner inMobiBanner, byte[] bArr) {
        super(0);
        this.f3020a = inMobiBanner;
        this.b = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        L4 l4P;
        B1 mAdManager = this.f3020a.getMAdManager();
        if (mAdManager != null && (l4P = mAdManager.p()) != null) {
            String strAccess$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$cp, "access$getTAG$cp(...)");
            ((M4) l4P).c(strAccess$getTAG$cp, "load with response");
        }
        B1 mAdManager2 = this.f3020a.getMAdManager();
        if (mAdManager2 != null) {
            mAdManager2.a(this.b, this.f3020a.e);
        }
        return Unit.INSTANCE;
    }
}
