package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2159bA {
    public final int A00;
    public final R5 A01;
    public final long A02;
    public final CopyOnWriteArrayList<C2158b9> A03;

    public C2159bA() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public C2159bA(CopyOnWriteArrayList<C2158b9> copyOnWriteArrayList, int i, R5 r5, long j) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i;
        this.A01 = r5;
        this.A02 = j;
    }

    private long A00(long j) {
        long jA0P = AbstractC2471gE.A0P(j);
        if (jA0P == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long mediaTimeMs = this.A02;
        return mediaTimeMs + jA0P;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    private final void A01(final C2143ar c2143ar, final C2146au c2146au, final int i) {
        for (C2158b9 c2158b9 : this.A03) {
            final InterfaceC2160bB interfaceC2160bB = c2158b9.A01;
            AbstractC2471gE.A1B(c2158b9.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.b4
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final C2159bA A02(int i, R5 r5, long j) {
        return new C2159bA(this.A03, i, r5, j);
    }

    public final void A03(int i, ZM zm, int i2, Object obj, long j) {
        A0C(new C2146au(1, i, zm, i2, obj, A00(j), -9223372036854775807L));
    }

    public final void A04(Handler handler, InterfaceC2160bB interfaceC2160bB) {
        AbstractC2388es.A01(handler);
        AbstractC2388es.A01(interfaceC2160bB);
        this.A03.add(new C2158b9(handler, interfaceC2160bB));
    }

    public final void A05(C2143ar c2143ar, int i, int i2, ZM zm, int i3, Object obj, long j, long j2) {
        A09(c2143ar, new C2146au(i, i2, zm, i3, obj, A00(j), A00(j2)));
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    public final void A06(C2143ar c2143ar, int i, int i2, ZM zm, int i3, Object obj, long j, long j2, int i4) {
        A01(c2143ar, new C2146au(i, i2, zm, i3, obj, A00(j), A00(j2)), i4);
    }

    public final void A07(C2143ar c2143ar, int i, int i2, ZM zm, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
        A0A(c2143ar, new C2146au(i, i2, zm, i3, obj, A00(j), A00(j2)), iOException, z);
    }

    public final void A08(@MetaExoPlayerCustomization C2143ar c2143ar, @MetaExoPlayerCustomization int i, int i2, ZM zm, int i3, Object obj, long j, long j2, Object obj2, Object obj3) {
        A0B(c2143ar, new C2146au(i, i2, zm, i3, obj, A00(j), A00(j2)), obj2, obj3);
    }

    public final void A09(final C2143ar c2143ar, final C2146au c2146au) {
        for (C2158b9 c2158b9 : this.A03) {
            final InterfaceC2160bB listener = c2158b9.A01;
            AbstractC2471gE.A1B(c2158b9.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.b3
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0E(listener, c2143ar, c2146au);
                }
            });
        }
    }

    public final void A0A(final C2143ar c2143ar, final C2146au c2146au, final IOException iOException, final boolean z) {
        for (C2158b9 c2158b9 : this.A03) {
            final InterfaceC2160bB interfaceC2160bB = c2158b9.A01;
            AbstractC2471gE.A1B(c2158b9.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.b2
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0F(interfaceC2160bB, c2143ar, c2146au, iOException, z);
                }
            });
        }
    }

    public final void A0B(@MetaExoPlayerCustomization final C2143ar c2143ar, @MetaExoPlayerCustomization final C2146au c2146au, final Object obj, final Object obj2) {
        for (C2158b9 c2158b9 : this.A03) {
            final InterfaceC2160bB interfaceC2160bB = c2158b9.A01;
            AbstractC2471gE.A1B(c2158b9.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.b7
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0G(interfaceC2160bB, c2143ar, c2146au, obj, obj2);
                }
            });
        }
    }

    public final void A0C(final C2146au c2146au) {
        for (C2158b9 c2158b9 : this.A03) {
            final InterfaceC2160bB listener = c2158b9.A01;
            AbstractC2471gE.A1B(c2158b9.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.b8
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0H(listener, c2146au);
                }
            });
        }
    }

    public final void A0D(InterfaceC2160bB interfaceC2160bB) {
        for (C2158b9 listenerAndHandler : this.A03) {
            if (listenerAndHandler.A01 == interfaceC2160bB) {
                this.A03.remove(listenerAndHandler);
            }
        }
    }

    public final /* synthetic */ void A0E(InterfaceC2160bB interfaceC2160bB, C2143ar c2143ar, C2146au c2146au) {
        interfaceC2160bB.ADp(this.A00, this.A01, c2143ar, c2146au);
    }

    public final /* synthetic */ void A0F(InterfaceC2160bB interfaceC2160bB, C2143ar c2143ar, C2146au c2146au, IOException iOException, boolean z) {
        interfaceC2160bB.ADu(this.A00, this.A01, c2143ar, c2146au, iOException, z);
    }

    public final /* synthetic */ void A0G(InterfaceC2160bB interfaceC2160bB, C2143ar c2143ar, C2146au c2146au, Object obj, Object obj2) {
        interfaceC2160bB.ADr(this.A00, this.A01, c2143ar, c2146au, obj, obj2);
    }

    public final /* synthetic */ void A0H(InterfaceC2160bB interfaceC2160bB, C2146au c2146au) {
        interfaceC2160bB.ACz(this.A00, this.A01, c2146au);
    }
}
