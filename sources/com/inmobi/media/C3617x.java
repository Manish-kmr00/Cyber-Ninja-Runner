package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.RootConfig;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3617x extends AbstractC3518pc {
    public final L4 d;
    public final WeakReference e;
    public C3603w f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3617x(C0 adUnit, L4 l4) {
        super(adUnit, (byte) 0);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = l4;
        this.e = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        C3418j0 c3418j0 = (C3418j0) obj;
        C0 c0 = (C0) this.e.get();
        if (c0 == null) {
            return;
        }
        c0.b((byte) 0);
        if (this.f == null) {
            if (c3418j0 == null) {
                c0.a(c0.I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                return;
            } else if (c3418j0.m()) {
                c0.c(c3418j0);
                return;
            } else {
                c0.d(c3418j0);
                return;
            }
        }
        J jI = c0.I();
        C3603w c3603w = this.f;
        Intrinsics.checkNotNull(c3603w);
        InMobiAdRequestStatus inMobiAdRequestStatus = c3603w.f3462a;
        C3603w c3603w2 = this.f;
        Intrinsics.checkNotNull(c3603w2);
        c0.a(jI, inMobiAdRequestStatus, c3603w2.b);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        C0 c0 = (C0) this.e.get();
        if (c0 == null) {
            return;
        }
        c0.b((byte) 0);
        c0.a(c0.I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2117);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        L4 l4 = this.d;
        if (l4 != null) {
            ((M4) l4).c("AdFetcherTask", "executeTask " + this);
        }
        C0 c0 = (C0) this.e.get();
        if (c0 == null) {
            L4 l5 = this.d;
            if (l5 != null) {
                ((M4) l5).b("AdFetcherTask", "adUnit is null. fail");
            }
            this.f = new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 2111);
            b(null);
            return;
        }
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        if (!((RootConfig) B4.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null)).getMonetizationDisabled()) {
            E0 e0S = c0.s();
            e0S.getClass();
            e0S.f = SystemClock.elapsedRealtime();
            try {
                L4 l6 = this.d;
                if (l6 != null) {
                    ((M4) l6).a("AdFetcherTask", "getting ad from store");
                }
                b(c0.p().a(c0.h0(), c0.F()));
                return;
            } catch (C3603w e) {
                Intrinsics.checkNotNullExpressionValue(C0.e(), "<get-TAG>(...)");
                this.f = e;
                b(null);
                return;
            }
        }
        L4 l7 = this.d;
        if (l7 != null) {
            ((M4) l7).b("AdFetcherTask", "SDK will not perform this load operation as monetization has been disabled. Please contact InMobi for further info.");
        }
        this.f = new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (short) 2012);
        b(null);
    }
}
