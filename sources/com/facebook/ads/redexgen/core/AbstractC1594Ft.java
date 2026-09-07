package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ft, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1594Ft extends RelativeLayout {
    public static final int A07 = (int) (CP.A02 * 16.0f);
    public static final int A08 = (int) (CP.A02 * 28.0f);
    public C12622c A00;
    public boolean A01;
    public final C2699k1 A02;
    public final A7 A03;
    public final ViewOnClickListenerC2488gW A04;
    public final C1586Fl A05;
    public final C1598Fx A06;

    public abstract boolean A17();

    public AbstractC1594Ft(C1598Fx c1598Fx, boolean z) {
        C12622c c12622cA00;
        super(c1598Fx.A05());
        this.A06 = c1598Fx;
        this.A02 = c1598Fx.A05();
        this.A03 = c1598Fx.A06();
        if (c1598Fx.A00() == 1) {
            c12622cA00 = c1598Fx.A04().A1a().A01();
        } else {
            c12622cA00 = c1598Fx.A04().A1a().A00();
        }
        this.A00 = c12622cA00;
        this.A01 = z;
        this.A04 = new ViewOnClickListenerC2488gW(c1598Fx.A05(), c1598Fx.A04(), this.A00, c1598Fx.A06(), c1598Fx.A0C(), c1598Fx.A0E(), c1598Fx.A09(), c1598Fx.A08());
        this.A04.setRoundedCornersEnabled(A00());
        this.A04.setViewShowsOverMedia(A0A());
        D3.A0E(1001, this.A04);
        this.A05 = new C1586Fl(this.A02, this.A00, this.A01, A01(), A02());
        D3.A0I(this.A05);
    }

    public boolean A00() {
        return true;
    }

    public boolean A01() {
        return true;
    }

    public boolean A02() {
        return true;
    }

    public boolean A0A() {
        return true;
    }

    public void A0J(C2205bu c2205bu) {
    }

    public void A0K(KX kx) {
    }

    public void A0z() {
    }

    public void A10() {
    }

    public void A11() {
    }

    public void A12() {
    }

    public void A13() {
    }

    public void A14(C2T c2t, String str, double d, Bundle bundle) {
        this.A05.A04(c2t.A0G().A0E(), c2t.A0G().A04(), null, false, !A17() && d > 0.0d && d < 1.0d);
        this.A04.setCta(c2t.A0H(), str, new HashMap());
    }

    public void A15(C1705Ka c1705Ka) {
    }

    public boolean A16() {
        return true;
    }

    public boolean A18(String str) {
        getCtaButton().A0A(str);
        return true;
    }

    public boolean A19(boolean z) {
        return false;
    }

    public C2699k1 getAdContextWrapper() {
        return this.A02;
    }

    public A7 getAdEventManager() {
        return this.A03;
    }

    public int getCloseButtonStyle() {
        return 0;
    }

    public C12622c getColors() {
        return this.A00;
    }

    public ViewOnClickListenerC2488gW getCtaButton() {
        return this.A04;
    }

    public C1586Fl getTitleDescContainer() {
        return this.A05;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C12622c c12622cA00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            c12622cA00 = this.A06.A04().A1a().A01();
        } else {
            c12622cA00 = this.A06.A04().A1a().A00();
        }
        this.A00 = c12622cA00;
        this.A04.setViewShowsOverMedia(A0A());
        this.A04.setUpButtonColors(this.A00);
        this.A05.A03(this.A00, this.A01);
    }

    public void setChainedWatchAndBrowseSkippableStatus(boolean z) {
    }
}
