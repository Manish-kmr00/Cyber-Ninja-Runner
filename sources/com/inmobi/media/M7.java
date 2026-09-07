package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class M7 extends AbstractC3518pc {
    public final WeakReference d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M7(C3439k7 adUnit) {
        super(adUnit, (byte) 6);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        short sShortValue = ((Number) obj).shortValue();
        C0 c0 = (C3439k7) this.d.get();
        if (c0 == null) {
            return;
        }
        if (sShortValue != 0) {
            c0.a(new WeakReference<>(c0.r()), sShortValue, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        if (2 == c0.Q()) {
            c0.d((byte) 4);
            r rVarK = c0.k();
            Ba baX = c0.x();
            AbstractC3520q0 abstractC3520q0R = c0.r();
            if (!(rVarK instanceof C3313b7)) {
                if (abstractC3520q0R != null) {
                    Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                    abstractC3520q0R.a(c0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    return;
                }
                return;
            }
            C3313b7 c3313b7 = (C3313b7) rVarK;
            c3313b7.H = baX;
            c3313b7.K = c0.T();
            E0 e0S = c0.s();
            e0S.getClass();
            e0S.i = SystemClock.elapsedRealtime();
            c0.u0();
            c0.z0();
            if (abstractC3520q0R != null) {
                Intrinsics.checkNotNullExpressionValue("k7", "TAG");
                c0.f(abstractC3520q0R);
            }
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        AbstractC3520q0 abstractC3520q0R;
        super.c();
        C0 c0 = (C3439k7) this.d.get();
        if (c0 == null || (abstractC3520q0R = c0.r()) == null) {
            return;
        }
        abstractC3520q0R.a(c0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C3439k7 c3439k7 = (C3439k7) this.d.get();
        if (c3439k7 == null) {
            b((short) 13);
            return;
        }
        AbstractC3520q0 abstractC3520q0R = c3439k7.r();
        if (abstractC3520q0R != null) {
            b(Short.valueOf(c3439k7.c(abstractC3520q0R)));
        }
    }
}
