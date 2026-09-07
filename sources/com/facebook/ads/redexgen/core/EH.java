package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EH extends FrameLayout {
    public static String[] A0C = {"5RNIIKEidNz4CxH4JgV5654XoKm2WCRJ", "1p9zA", "TyFhTVOKfwCiarLUW0", "qGg1KSsP6zNQFhXHIMmjZGXDOHal5qmq", "ysvkaelauuCqE6L7ICudiIGq1Ejo0wOd", "BlsqFJOSCgQfST", "dpiEaUs9Aor9er1WGZ", "tfv9H94"};
    public int A00;
    public EnumC12943i A01;
    public C12953j A02;
    public C12963k A03;
    public final C12923g A04;
    public final C2699k1 A05;
    public final A7 A06;
    public final DR A07;
    public final DS A08;
    public final String A09;
    public final C12732n A0A;
    public final EJ A0B;

    public abstract void A0L();

    public abstract void A0M();

    public abstract void A0N(C12963k c12963k, EnumC12943i enumC12943i);

    public abstract void A0O(C12963k c12963k, EnumC12943i enumC12943i);

    public abstract boolean A0P();

    public EH(C2699k1 c2699k1, A7 a7, String str) {
        this(c2699k1, a7, str, null, null, null);
    }

    public EH(C2699k1 c2699k1, A7 a7, String str, C12732n c12732n, DS ds, DR dr) {
        super(c2699k1);
        this.A00 = 0;
        this.A01 = EnumC12943i.A05;
        this.A03 = null;
        this.A0B = new C2534hG(this);
        this.A05 = c2699k1;
        this.A06 = a7;
        this.A08 = ds;
        this.A07 = dr;
        this.A09 = str;
        this.A0A = c12732n;
        this.A04 = AbstractC12933h.A00(this.A05.A02());
    }

    public static /* synthetic */ int A00(EH eh) {
        int i = eh.A00;
        eh.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A01(EH eh) {
        int i = eh.A00;
        eh.A00 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        if (this.A02.A0A()) {
            this.A06.AAn(this.A09, this.A02.A02());
            this.A02.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C() {
        this.A03 = null;
        this.A02.A05();
        A0L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C12963k c12963k) {
        this.A02.A08(this.A01);
        A0N(c12963k, this.A01);
        C2A.A01(this.A05).A0L();
        if (A0P()) {
            A0B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(C12963k c12963k) {
        this.A03 = c12963k;
        this.A02.A09(this.A01, this.A00);
        A0O(c12963k, this.A01);
    }

    public final void A0J() {
        A0B();
    }

    public final void A0K() {
        this.A02 = new C12953j(new AF(this.A09, this.A06));
        if (this.A08 != null) {
            DS ds = this.A08;
            if (A0C[0].charAt(22) == 'O') {
                throw new RuntimeException();
            }
            A0C[7] = "FLAi4P2";
            ds.AEP(true);
        }
        A0C();
    }
}
