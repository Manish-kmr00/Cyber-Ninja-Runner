package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3511p5 extends AbstractC3518pc {
    public final WeakReference d;
    public final WeakReference e;
    public short f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3511p5(C3609w5 adUnit, AbstractC3520q0 eventListener) {
        super(adUnit, (byte) 5);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.d = new WeakReference(adUnit);
        this.e = new WeakReference(eventListener);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        AbstractC3520q0 abstractC3520q0;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        C3609w5 c3609w5 = (C3609w5) this.d.get();
        if (c3609w5 == null || (abstractC3520q0 = (AbstractC3520q0) this.e.get()) == null) {
            return;
        }
        if (!zBooleanValue) {
            short s = this.f;
            if (s != 0) {
                c3609w5.a(this.e, s, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            } else {
                c3609w5.b(abstractC3520q0, (short) 85);
                return;
            }
        }
        r rVarK = c3609w5.k();
        Ba baX = c3609w5.x();
        if (baX != null) {
            if (rVarK instanceof C3313b7) {
                C3313b7 c3313b7 = (C3313b7) rVarK;
                c3313b7.H = baX;
                c3313b7.K = c3609w5.T();
            } else {
                c3609w5.b(abstractC3520q0, (short) 84);
            }
        }
        c3609w5.h(abstractC3520q0);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        C3609w5 c3609w5 = (C3609w5) this.d.get();
        if (c3609w5 == null || ((AbstractC3520q0) this.e.get()) == null) {
            return;
        }
        c3609w5.a(this.e, (short) 40, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C3609w5 c3609w5 = (C3609w5) this.d.get();
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.e.get();
        if (c3609w5 != null && abstractC3520q0 != null) {
            if (c3609w5.D0()) {
                short sC = c3609w5.c(abstractC3520q0);
                this.f = sC;
                b(Boolean.valueOf(sC == 0));
                return;
            }
            b(Boolean.FALSE);
            return;
        }
        b(Boolean.FALSE);
    }
}
