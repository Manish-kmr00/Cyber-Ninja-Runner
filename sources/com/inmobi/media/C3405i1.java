package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.i1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3405i1 extends AbstractC3518pc {
    public final JSONObject d;
    public final L4 e;
    public final WeakReference f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3405i1(C0 adUnit, JSONObject response, L4 l4) {
        super(adUnit, (byte) 4);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(response, "response");
        this.d = response;
        this.e = l4;
        this.f = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final void a(Object obj) {
        AbstractC3520q0 abstractC3520q0R;
        InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) obj;
        C0 c0 = (C0) this.f.get();
        if (c0 == null || (abstractC3520q0R = c0.r()) == null) {
            return;
        }
        if (inMobiAdRequestStatus != null) {
            c0.b(inMobiAdRequestStatus, true, (short) 2182);
            return;
        }
        c0.d((byte) 2);
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).d("AuctionCloseWorker", "AdUnit " + c0 + " state - AVAILABLE");
        }
        c0.e(abstractC3520q0R);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        C0 c0 = (C0) this.f.get();
        if (c0 == null) {
            return;
        }
        c0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), true, (short) 2181);
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        C3418j0 c3418j0Y;
        C0 c0 = (C0) this.f.get();
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if ((c0 != null ? c0.y() : null) == null) {
            b(inMobiAdRequestStatus);
            return;
        }
        try {
            AdConfig adConfigJ = c0.j();
            if (adConfigJ != null && (c3418j0Y = c0.y()) != null) {
                c3418j0Y.a(this.d, adConfigJ, this.e);
            }
            b(null);
        } catch (Exception unused) {
            C0.e();
            b(inMobiAdRequestStatus);
        }
    }
}
