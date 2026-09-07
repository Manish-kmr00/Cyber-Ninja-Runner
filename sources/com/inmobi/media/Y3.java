package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Y3 extends AbstractC3518pc {
    public final long d;
    public final L4 e;
    public final WeakReference f;
    public C3603w g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y3(C0 adUnit, long j, L4 l4) {
        super(adUnit, (byte) 2);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = j;
        this.e = l4;
        this.f = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        byte[] bArr = (byte[]) obj;
        C0 c0 = (C0) this.f.get();
        if (c0 == null) {
            return;
        }
        if (this.g != null) {
            L4 l4 = this.e;
            if (l4 != null) {
                ((M4) l4).d("GetSignalsWorker", "AdUnit " + c0 + " state - FAILED");
            }
            c0.d((byte) 3);
        }
        AbstractC3520q0 abstractC3520q0R = c0.r();
        if (abstractC3520q0R == null) {
            return;
        }
        C3603w c3603w = this.g;
        if (c3603w != null) {
            L4 l5 = this.e;
            if (l5 != null) {
                ((M4) l5).a("GetSignalsWorker", "get signals failed", c3603w);
            }
            c0.a(c3603w.b, this.d);
            abstractC3520q0R.b(new InMobiAdRequestStatus(c3603w.f3462a.getStatusCode()));
            return;
        }
        if (bArr != null) {
            c0.b(this.d);
            abstractC3520q0R.a(bArr);
            L4 l6 = this.e;
            if (l6 != null) {
                ((M4) l6).a("GetSignalsWorker", "callback - onRequestCreated");
                return;
            }
            return;
        }
        c0.d((byte) 3);
        L4 l7 = this.e;
        if (l7 != null) {
            ((M4) l7).d("GetSignalsWorker", "AdUnit " + this + " state - FAILED");
        }
        L4 l8 = this.e;
        if (l8 != null) {
            ((M4) l8).b("GetSignalsWorker", "no request created - fail");
        }
        c0.a(13, this.d);
        abstractC3520q0R.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        C0 c0 = (C0) this.f.get();
        if (c0 == null) {
            return;
        }
        AbstractC3520q0 abstractC3520q0R = c0.r();
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).a("GetSignalsWorker", "onOOM");
        }
        if (abstractC3520q0R != null) {
            abstractC3520q0R.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C0 c0 = (C0) this.f.get();
        if ((c0 != null ? c0.H() : null) == null) {
            L4 l4 = this.e;
            if (l4 != null) {
                ((M4) l4).b("GetSignalsWorker", "OAManager is null");
            }
            b(null);
            return;
        }
        if (c0.r() == null) {
            L4 l5 = this.e;
            if (l5 != null) {
                ((M4) l5).b("GetSignalsWorker", "listener is null");
            }
            b(null);
            return;
        }
        try {
            C3343d9 c3343d9H = c0.H();
            b(c3343d9H != null ? new C3357e9(c3343d9H.f3294a).a() : null);
        } catch (C3603w e) {
            this.g = e;
            b(null);
        }
    }
}
