package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class RC implements InterfaceC2151az {
    public static String[] A07 = {"bvkjR0z2JuCPgN2uAbpqPjh1auWjFN2m", "jDmTxi1msFLiyIykemTdf3SyMPUAROGA", "OXoBlYAGv7iOLjHl9567wWnPGXT5zRPb", "Efu31", "aky9HEhQ7EdDCqCiIpT5H8t2NR6VgViF", "iq3qY", "qXUoBaVWj6OuQ8", "Oco5vFKqVajXf16TyX0nMhcG593FlptK"};
    public Looper A00;
    public Timeline A01;
    public RK A02;
    public final ArrayList<InterfaceC2150ay> A05 = new ArrayList<>(1);
    public final HashSet<InterfaceC2150ay> A06 = new HashSet<>(1);
    public final C2159bA A04 = new C2159bA();
    public final TJ A03 = new TJ();

    public abstract void A09();

    public abstract void A0A(InterfaceC2357eN interfaceC2357eN);

    public final RK A00() {
        return (RK) AbstractC2388es.A02(this.A02);
    }

    public final TJ A01(R5 r5) {
        return this.A03.A00(0, r5);
    }

    public final C2159bA A02(R5 r5) {
        return this.A04.A02(0, r5, 0L);
    }

    public void A03() {
    }

    public void A04() {
    }

    public final void A05(Timeline timeline) {
        this.A01 = timeline;
        Iterator<InterfaceC2150ay> it = this.A05.iterator();
        while (it.hasNext()) {
            it.next().AFA(this, timeline);
        }
    }

    public final void A06(InterfaceC2150ay interfaceC2150ay) {
        boolean z = !this.A06.isEmpty();
        this.A06.remove(interfaceC2150ay);
        if (z) {
            boolean wasEnabled = this.A06.isEmpty();
            if (wasEnabled) {
                A03();
            }
        }
    }

    public final void A07(InterfaceC2150ay interfaceC2150ay) {
        AbstractC2388es.A01(this.A00);
        boolean zIsEmpty = this.A06.isEmpty();
        this.A06.add(interfaceC2150ay);
        if (zIsEmpty) {
            A04();
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    public final void A08(InterfaceC2150ay interfaceC2150ay, InterfaceC2357eN interfaceC2357eN, RK rk) {
        boolean z;
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.A00;
        if (looper != null) {
            Looper looper2 = this.A00;
            if (looper2 == looperMyLooper) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        AbstractC2388es.A07(z);
        if (A07[7].charAt(29) == 'V') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "50KTM";
        strArr[3] = "Za3v7";
        this.A02 = rk;
        Timeline timeline = this.A01;
        this.A05.add(interfaceC2150ay);
        Looper looper3 = this.A00;
        if (looper3 == null) {
            this.A00 = looperMyLooper;
            this.A06.add(interfaceC2150ay);
            A0A(interfaceC2357eN);
        } else {
            if (timeline == null) {
                return;
            }
            A07(interfaceC2150ay);
            interfaceC2150ay.AFA(this, timeline);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void A3p(Handler handler, InterfaceC2160bB interfaceC2160bB) {
        AbstractC2388es.A01(handler);
        AbstractC2388es.A01(interfaceC2160bB);
        this.A04.A04(handler, interfaceC2160bB);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void AGF(InterfaceC2150ay interfaceC2150ay, InterfaceC2357eN interfaceC2357eN) {
        A08(interfaceC2150ay, interfaceC2357eN, RK.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void AGt(InterfaceC2150ay interfaceC2150ay) {
        this.A05.remove(interfaceC2150ay);
        if (this.A05.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            this.A02 = null;
            this.A06.clear();
            A09();
            return;
        }
        A06(interfaceC2150ay);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void AHY(InterfaceC2160bB interfaceC2160bB) {
        this.A04.A0D(interfaceC2160bB);
    }
}
