package com.facebook.ads.redexgen.core;

import android.os.Looper;
import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QT {
    public int A00;
    public int A01;
    public Looper A03;
    public Object A04;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final QR A0A;
    public final QS A0B;
    public final Timeline A0C;
    public final InterfaceC2395ez A0D;
    public long A02 = -9223372036854775807L;
    public boolean A05 = true;

    public QT(QR qr, QS qs, Timeline timeline, int i, InterfaceC2395ez interfaceC2395ez, Looper looper) {
        this.A0A = qr;
        this.A0B = qs;
        this.A0C = timeline;
        this.A03 = looper;
        this.A0D = interfaceC2395ez;
        this.A00 = i;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final Looper A03() {
        return this.A03;
    }

    public final QS A04() {
        return this.A0B;
    }

    public final QT A05() {
        AbstractC2388es.A08(!this.A09);
        if (this.A02 == -9223372036854775807L) {
            AbstractC2388es.A07(this.A05);
        }
        this.A09 = true;
        this.A0A.AII(this);
        return this;
    }

    public final QT A06(int i) {
        AbstractC2388es.A08(!this.A09);
        this.A01 = i;
        return this;
    }

    public final QT A07(Object obj) {
        AbstractC2388es.A08(!this.A09);
        this.A04 = obj;
        return this;
    }

    public final Timeline A08() {
        return this.A0C;
    }

    public final Object A09() {
        return this.A04;
    }

    public final synchronized void A0A(boolean z) {
        this.A07 |= z;
        this.A08 = true;
        notifyAll();
    }

    public final boolean A0B() {
        return this.A05;
    }

    public final synchronized boolean A0C() throws InterruptedException {
        AbstractC2388es.A08(this.A09);
        AbstractC2388es.A08(this.A03.getThread() != Thread.currentThread());
        while (!this.A08) {
            wait();
        }
        return this.A07;
    }

    public final synchronized boolean A0D() {
        return this.A06;
    }
}
