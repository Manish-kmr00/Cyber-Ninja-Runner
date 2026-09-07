package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1733Lc extends AbstractC2493gb {
    public static String[] A00 = {"G", "KzTy2hy9hhtw1RMGA4AWQtLCSBRvIgNx", "TFXx3faCMHKsw8ZQwSQJp4p3qrvSFGQZ", "FDPqMwfpfrBnIs9VqOwKhGqv0efVrSDC", "w99CmZO3gVFe1JaqJ0AV2MifxVBEUT0K", "IReileYPgfNfW", "Qab6Yr7DAj1gKX83C9lxa", "vvhOodmvLfB1cs4WARwmrAXLlmUlw4y7"};
    public static final int A01 = (int) (CP.A02 * 152.0f);

    public C1733Lc(C2699k1 c2699k1, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW, int i, C12622c c12622c, String str, A7 a7, DR dr, JL jl, C1518Cv c1518Cv, AbstractC2855md abstractC2855md, C2154b5 c2154b5, AF af) {
        super(c2699k1, viewOnClickListenerC2488gW, i, c12622c, false, str, a7, dr, jl, c1518Cv, abstractC2855md, c2154b5, af);
        int i2 = getResources().getConfiguration().orientation;
        A02();
        setIconImageParam(i2);
        A01();
        D3.A0I(this.A0K);
        setDescriptionViewParams(i2);
        setAdReportingView(i2);
        setCTALayoutParam(i2);
        setProgressBarParam(i2);
        setRewardTextParam(i2);
        addView(this.A0J);
    }

    private void A01() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0L.getLayoutParams();
        this.A0L.setTypeface(Typeface.DEFAULT_BOLD);
        this.A0L.setTextSize(30.0f);
        layoutParams.setMargins(0, AbstractC2493gb.A0a, 0, 0);
        layoutParams.addRule(14);
        layoutParams.addRule(3, ((FH) this).A09.getId());
        this.A0L.setLayoutParams(layoutParams);
    }

    private void A02() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(1);
        int screenWidth = (int) (getResources().getDisplayMetrics().widthPixels * 0.1f);
        layoutParams.setMargins(screenWidth, AbstractC2493gb.A0a, screenWidth, AbstractC2493gb.A0d);
        RelativeLayout relativeLayout = this.A0I;
        int margin = AbstractC2493gb.A0a;
        relativeLayout.setPadding(margin, AbstractC2493gb.A0a, AbstractC2493gb.A0a, AbstractC2493gb.A0a);
        this.A0I.setLayoutParams(layoutParams);
    }

    private void A03(int i) {
        if (((FH) this).A08.getParent() != null) {
            ViewOnClickListenerC2488gW viewOnClickListenerC2488gW = ((FH) this).A08;
            if (A00[6].length() != 21) {
                throw new RuntimeException();
            }
            A00[6] = "77Sm8WMgdJozvQKOpKshJ";
            D3.A0H(viewOnClickListenerC2488gW);
        }
        if (i == 1) {
            if (((AbstractC2493gb) this).A03 != null && ((AbstractC2493gb) this).A03.getVisibility() == 0) {
                this.A0J.addView(((AbstractC2493gb) this).A03);
            }
            this.A0J.addView(this.A0P);
            this.A0J.addView(((FH) this).A08);
            this.A0J.addView(this.A0G);
            return;
        }
        this.A0I.addView(((FH) this).A09);
        this.A0I.addView(this.A0L);
        this.A0I.addView(this.A0K);
        this.A0I.addView(((FH) this).A08);
        this.A0I.addView(this.A0P);
        if (((AbstractC2493gb) this).A03 != null && ((AbstractC2493gb) this).A03.getVisibility() == 0) {
            this.A0I.addView(((AbstractC2493gb) this).A03);
        }
        this.A0J.addView(this.A0I);
        this.A0J.addView(this.A0G);
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final void A0D(int i) {
        D3.A0Z(this.A0I, ((FH) this).A09, this.A0L, this.A0P, ((AbstractC2493gb) this).A03, this.A0K, this.A0G);
        A02();
        setIconImageParam(i);
        setRewardTextParam(i);
        setProgressBarParam(i);
        setCTALayoutParam(i);
        A01();
        setDescriptionViewParams(i);
        setAdReportingView(i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2493gb
    public final void A0S(int i) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2493gb
    public final void A0U(C2232cL c2232cL, int i) {
        if (i == 1 && c2232cL != null && c2232cL.getVideoView() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((FH) this).A09.getLayoutParams();
            layoutParams.addRule(3, c2232cL.getVideoView().getId());
            ((FH) this).A09.setLayoutParams(layoutParams);
            c2232cL.addView(((FH) this).A09);
            if (A00[2].charAt(22) == 'z') {
                throw new RuntimeException();
            }
            A00[1] = "8edlxl8iBTjA4xFkn0kwBC7lhr04uOIj";
            c2232cL.addView(this.A0L);
            c2232cL.addView(this.A0K);
        }
        A03(i);
    }

    private void setAdReportingView(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0G.getLayoutParams();
        if (i == 1) {
            int i2 = AbstractC2493gb.A0e;
            if (A00[0].length() != 1) {
                throw new RuntimeException();
            }
            A00[6] = "cifcGfDigOiJ6pKzXhRS8";
            layoutParams.setMargins(0, 0, i2, 0);
        } else {
            int i3 = AbstractC2493gb.A0a;
            if (A00[5].length() != 30) {
                A00[2] = "FhhCaBUja7jVhQgWYRh7qP6cuGlTkNG9";
                layoutParams.setMargins(0, 0, i3, 0);
            } else {
                layoutParams.setMargins(0, 0, i3, 0);
            }
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.A0G.setLayoutParams(layoutParams);
    }

    private void setCTALayoutParam(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC2493gb.A0T);
        if (i == 1) {
            layoutParams.setMargins(AbstractC2493gb.A0e, 0, AbstractC2493gb.A0e, AbstractC2493gb.A0a);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        layoutParams.addRule(2, this.A0P.getId());
        layoutParams.addRule(14);
        ((FH) this).A08.setLayoutParams(layoutParams);
        A0O();
    }

    private void setDescriptionViewParams(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.A0L.getId());
        layoutParams.setMargins(AbstractC2493gb.A0a, AbstractC2493gb.A0g, AbstractC2493gb.A0a, 0);
        layoutParams.addRule(14);
        this.A0K.setTypeface(Typeface.DEFAULT);
        this.A0K.setTextSize(18.0f);
        this.A0K.setLayoutParams(layoutParams);
        if (i == 1) {
            this.A0K.setMaxLines(4);
            return;
        }
        TextView textView = this.A0K;
        if (A00[1].charAt(4) == 'n') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[7] = "oD8t0MbbkSItHj1TmxwB1nOaZGDH8k2A";
        strArr[3] = "hbdI9dZBf2S8DlHlHEwZw178JE33VfjJ";
        textView.setMaxLines(1);
    }

    private void setIconImageParam(int i) {
        int topMargin;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((FH) this).A09.getLayoutParams();
        if (i == 1) {
            layoutParams.width = A01;
            layoutParams.height = A01;
            layoutParams.setMargins(0, (-A01) / 4, 0, 0);
            topMargin = 30;
        } else {
            layoutParams.removeRule(3);
            layoutParams.removeRule(14);
            layoutParams.width = AbstractC2493gb.A0Y;
            layoutParams.height = AbstractC2493gb.A0Y;
            layoutParams.setMargins(0, AbstractC2493gb.A0a, 0, 0);
            topMargin = 15;
        }
        ((FH) this).A09.setRadius(topMargin);
        layoutParams.addRule(14);
        ((FH) this).A09.setLayoutParams(layoutParams);
    }

    private void setProgressBarParam(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0P.getLayoutParams();
        if (i == 1) {
            layoutParams.removeRule(12);
            layoutParams.addRule(2, this.A0G.getId());
            layoutParams.setMargins(AbstractC2493gb.A0e, 0, AbstractC2493gb.A0e, AbstractC2493gb.A0b);
        } else {
            layoutParams.removeRule(2);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, AbstractC2493gb.A0a, 0, AbstractC2493gb.A0c);
        }
        this.A0P.setLayoutParams(layoutParams);
    }

    private void setRewardTextParam(int i) {
        if (((AbstractC2493gb) this).A03 == null || ((AbstractC2493gb) this).A03.getVisibility() != 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2493gb) this).A03.getLayoutParams();
        layoutParams.addRule(12);
        if (i == 1) {
            layoutParams.setMargins(AbstractC2493gb.A0e, 0, AbstractC2493gb.A0e, AbstractC2493gb.A0g);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        ((AbstractC2493gb) this).A03.setLayoutParams(layoutParams);
    }
}
