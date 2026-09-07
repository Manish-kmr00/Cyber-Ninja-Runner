package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class LU extends AbstractC2445fo {
    public E0 A00;
    public GV A01;
    public C1631He A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public RelativeLayout A06;
    public C2291dI A07;
    public final C2699k1 A08;
    public final AbstractC2214c3 A09;
    public final AbstractC2208bx A0A;
    public final AbstractC2206bv A0B;
    public final AbstractC2204bt A0C;
    public final AbstractC2195bk A0D;
    public final String A0E;
    public final Paint A0F;
    public final Path A0G;
    public final RectF A0H;
    public final C1598Fx A0I;
    public static String[] A0J = {"MpRqvkZj1q70y", "JmeA7cKwz52Cf66UfzrPr0LMRH4SYAx7", "6sdDVsKAMYqDcEUPGSGZSzHS1QCr5tGd", "kTGZxaoWJV94XtNMqSwvdL", "Mc6tnSsqpweEwwZBrEzxWewdD5U0ZBnH", "pH8A6EuZ6tOwC2LEaYgoPeYfMAE", "hIXMP87egv28CzL5Z81pRvvAccgq29VA", "kjeLkimcHFb7T02SebLVQF"};
    public static final int A0L = (int) (CP.A02 * 0.0f);
    public static final int A0M = (int) (CP.A02 * 9.0f);
    public static final int A0K = (int) (CP.A02 * 9.0f);

    public LU(C1598Fx c1598Fx, boolean z, String str, C2291dI c2291dI) {
        super(c1598Fx, z);
        this.A0G = new Path();
        this.A0H = new RectF();
        this.A0D = new LZ(this);
        this.A09 = new LY(this);
        this.A0B = new LX(this);
        this.A0A = new LW(this);
        this.A0C = new LV(this);
        this.A0I = c1598Fx;
        this.A07 = c2291dI;
        this.A0E = str;
        this.A08 = c1598Fx.A05();
        setGravity(17);
        setPadding(A0L, 0, A0L, A0L);
        D3.A0K(this, 0);
        setUpView(this.A08);
        this.A0F = new Paint();
        this.A0F.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.A0F.setStyle(Paint.Style.FILL);
        this.A0F.setAlpha(16);
        this.A0F.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        if (this.A0I.A0D() != null && this.A02 != null) {
            C2154b5 c2154b5A0D = this.A0I.A0D();
            C2232cL simpleVideoView = this.A02.getSimpleVideoView();
            if (A0J[2].charAt(30) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[6] = "7Tm7E6hvxl2lrINlaGqN4b4kJs9I709m";
            strArr[1] = "njm7q4dCrj2NJr9FsCrNNlLowJdEGDJD";
            c2154b5A0D.AAk(simpleVideoView);
            if (C14499m.A2C(getContext())) {
                this.A0I.A0D().A07(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (this.A0I.A0D() != null) {
            this.A0I.A0D().A05();
            if (this.A02 != null) {
                this.A0I.A0D().AJa(this.A02.getSimpleVideoView());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    public void A02() {
        if (this.A01 == null) {
            return;
        }
        if (!A1F()) {
            if (!A1F()) {
                return;
            } else {
                return;
            }
        }
        boolean z = this.A05;
        if (A0J[4].charAt(16) == 'S') {
            throw new RuntimeException();
        }
        A0J[4] = "H2PvwmHOgvOi5klEuL8elNjNTBtJADxS";
        if (!z) {
            if (!A1F() || !this.A04) {
                return;
            }
        }
        this.A01.ACH();
    }

    private void A03(View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    public static void A04(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        D3.A0I(view);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A0A() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft
    public final boolean A17() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2445fo
    public final void A1B() {
        if (A1F() && this.A02 != null) {
            C1631He c1631He = this.A02;
            if (A0J[4].charAt(16) == 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[0] = "PPsdw83Xwgr8n";
            strArr[5] = "5ciU0wOzbld7CiHKSmuHpDfStOE";
            c1631He.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2445fo
    public final void A1C() {
        if (A1F()) {
            A1D();
            if (this.A02 != null) {
                this.A02.A05(IP.A02);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2445fo
    public final void A1D() {
        float volume = this.A07.A0P().getVolume();
        if (!A1F() || this.A02 == null) {
            return;
        }
        float newVolume = this.A02.getVolume();
        if (volume != newVolume) {
            this.A02.setVolume(volume);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2445fo
    public final boolean A1E() {
        return A1F() && this.A02 != null && this.A02.A06();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2445fo
    public final boolean A1F() {
        return this.A03;
    }

    public final void A1G(Map<String, String> extraParams) {
        if (this.A02 != null) {
            this.A02.A02();
            if (A1F()) {
                this.A02.A04(getAdEventManager(), this.A0E, extraParams);
            }
        }
    }

    public final C1631He getVideoView() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Ft, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A0G.reset();
        this.A0H.set(0.0f, 0.0f, getWidth(), getHeight());
        int i = 0;
        int radius = getResources().getConfiguration().orientation;
        boolean z = radius == 1;
        if (z) {
            i = A0K;
        }
        this.A0G.addRoundRect(this.A0H, i, i, Path.Direction.CW);
        canvas.drawPath(this.A0G, this.A0F);
        RectF rectF = this.A0H;
        int radius2 = A0L;
        float f = radius2;
        int width = getWidth();
        int radius3 = A0L;
        float f2 = width - radius3;
        int height = getHeight();
        int radius4 = A0L;
        rectF.set(f, 0.0f, f2, height - radius4);
        if (z) {
            i = A0M;
        }
        this.A0G.addRoundRect(this.A0H, i, i, Path.Direction.CW);
        canvas.clipPath(this.A0G);
        super.onDraw(canvas);
    }

    public void setCTAInfo(C12632d c12632d, Map<String, String> extraData) {
        getCtaButton().setCta(c12632d, this.A0E, extraData);
    }

    public void setImageUrl(String str) {
        if (this.A00 != null) {
            this.A00.setVisibility(0);
            new AsyncTaskC2494gc(this.A00, this.A08).A04().A06(new C2478gL(this, null)).A07(str);
        }
        if (this.A02 != null) {
            this.A02.setVisibility(8);
        }
    }

    public void setIsVideo(boolean z) {
        this.A03 = z;
    }

    public void setOnAssetsLoadedListener(GV gv) {
        this.A01 = gv;
    }

    public void setUpImageView(C2699k1 c2699k1) {
        this.A00 = new E0(c2699k1);
        if (C14499m.A1G(c2699k1)) {
            FE.A00(this.A00, C14499m.A1H(c2699k1), new FX(this));
        }
        A04(this.A00);
    }

    public void setUpMediaContainer(C2699k1 c2699k1) {
        this.A06 = new RelativeLayout(c2699k1);
        A04(this.A06);
        if (this.A00 != null) {
            this.A06.addView(this.A00);
            A03(this.A00);
        }
        if (this.A02 != null) {
            this.A06.addView(this.A02);
            A03(this.A02);
        }
        addView(this.A06);
    }

    public void setUpVideoView(C2699k1 c2699k1) {
        this.A02 = new C1631He(c2699k1, new AF(this.A0E, getAdEventManager()));
        if (C14499m.A1I(c2699k1)) {
            FE.A00(this.A02, C14499m.A1J(c2699k1), new FY(this));
        }
        C1631He c1631He = this.A02;
        if (A0J[2].charAt(30) != 'G') {
            throw new RuntimeException();
        }
        A0J[4] = "tNSgYVifT5FMSy2OwNBjuNxtKDkDnPPF";
        A04(c1631He);
    }

    private void setUpView(C2699k1 c2699k1) {
        setUpImageView(c2699k1);
        setUpVideoView(c2699k1);
        setUpMediaContainer(c2699k1);
    }

    public void setVideoPlaceholderUrl(String str) {
        if (this.A02 != null) {
            this.A02.setPlaceholderUrl(str);
        }
    }

    public void setVideoUrl(String str) {
        if (this.A00 != null) {
            this.A00.setVisibility(8);
        }
        C1631He c1631He = this.A02;
        String[] strArr = A0J;
        if (strArr[6].charAt(10) != strArr[1].charAt(10)) {
            throw new RuntimeException();
        }
        A0J[2] = "Key351avhXFGNIES0xzUdjVz8AR1nkGO";
        if (c1631He != null) {
            this.A02.setVisibility(0);
            this.A02.setVideoURI(str);
            this.A02.A03(this.A0D);
            this.A02.A03(this.A09);
            this.A02.A03(this.A0B);
            this.A02.A03(this.A0A);
            this.A02.A03(this.A0C);
        }
    }
}
