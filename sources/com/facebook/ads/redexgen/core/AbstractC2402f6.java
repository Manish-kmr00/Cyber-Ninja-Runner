package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2402f6 extends RelativeLayout implements CJ {
    public boolean A00;
    public final int A01;
    public final JK A02;
    public final boolean A03;
    public final boolean A04;
    public final AbstractC2855md A05;
    public final C2699k1 A06;
    public final A7 A07;
    public final CL A08;
    public final C1518Cv A09;
    public final DR A0A;
    public final EC A0B;
    public final JL A0C;

    public abstract void A13();

    public abstract void A14();

    public abstract void A16(boolean z);

    public abstract void A17(boolean z);

    public abstract boolean A18();

    public abstract boolean A19();

    public abstract boolean A1A(String str);

    public abstract HG getFullScreenAdStyle();

    public AbstractC2402f6(C2699k1 c2699k1, EC ec, A7 a7, AbstractC2855md abstractC2855md, int i, boolean z, boolean z2, DR dr) {
        super(c2699k1);
        this.A09 = new C1518Cv();
        this.A00 = false;
        this.A02 = new C2405fA(this);
        this.A01 = i;
        this.A06 = c2699k1;
        this.A04 = z;
        this.A03 = z2;
        this.A0A = dr;
        this.A0B = ec;
        this.A05 = abstractC2855md;
        this.A07 = a7;
        this.A0C = new JL(this, 1, new WeakReference(this.A02), c2699k1);
        this.A0C.A0W(abstractC2855md.A0U());
        this.A0C.A0X(abstractC2855md.A0V());
        this.A08 = CL.A01(this.A06, this.A05, this);
    }

    public void A11() {
        this.A08.A0B();
    }

    public final void A12() {
        if (!this.A00) {
            this.A0C.A0U();
            this.A00 = true;
        }
    }

    public void A15(boolean z) {
    }

    public void ADz() {
        this.A0A.A4Z(this.A05.A0e());
    }

    public AbstractC2855md getAdDataBundle() {
        return this.A05;
    }

    public JL getAdViewabilityChecker() {
        return this.A0C;
    }

    public C1518Cv getTouchDataRecorder() {
        return this.A09;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
