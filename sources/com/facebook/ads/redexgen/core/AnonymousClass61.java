package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.61, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass61 implements TQ {
    public int A00;
    public boolean A01;
    public final C2011Wt A02 = new C2011Wt();
    public final C14308s A03 = new C14308s();
    public final Deque<AbstractC14288q> A04 = new ArrayDeque();

    public AnonymousClass61() {
        for (int i = 0; i < 2; i++) {
            this.A04.addFirst(new AbstractC14288q() { // from class: com.facebook.ads.redexgen.X.0w
                @Override // com.facebook.ads.redexgen.core.AbstractC14288q, com.facebook.ads.redexgen.core.AbstractC2012Wu
                public final void A0B() {
                    this.A00.A03(this);
                }
            });
        }
        this.A00 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1908Sl
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C14308s A5h() throws TP {
        AbstractC2388es.A08(!this.A01);
        if (this.A00 != 0) {
            return null;
        }
        this.A00 = 1;
        return this.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1908Sl
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final AbstractC14288q A5j() throws TP {
        AbstractC2388es.A08(!this.A01);
        if (this.A00 != 2 || this.A04.isEmpty()) {
            return null;
        }
        AbstractC14288q abstractC14288qRemoveFirst = this.A04.removeFirst();
        if (this.A03.A05()) {
            abstractC14288qRemoveFirst.A00(4);
        } else {
            abstractC14288qRemoveFirst.A0C(this.A03.A01, new C1850Qe(this.A03.A01, this.A02.A02(((ByteBuffer) AbstractC2388es.A01(this.A03.A02)).array())), 0L);
        }
        this.A03.A0A();
        this.A00 = 0;
        return abstractC14288qRemoveFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1908Sl
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void AGR(C14308s c14308s) throws TP {
        AbstractC2388es.A08(!this.A01);
        AbstractC2388es.A08(this.A00 == 1);
        AbstractC2388es.A07(this.A03 == c14308s);
        this.A00 = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(AbstractC14288q abstractC14288q) {
        AbstractC2388es.A08(this.A04.size() < 2);
        AbstractC2388es.A07(!this.A04.contains(abstractC14288q));
        abstractC14288q.A0A();
        this.A04.addFirst(abstractC14288q);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1908Sl
    public final void AGj() {
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.TQ
    public final void AIn(long j) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1908Sl
    public final void flush() {
        AbstractC2388es.A08(!this.A01);
        this.A03.A0A();
        this.A00 = 0;
    }
}
