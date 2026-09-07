package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HF extends RelativeLayout {
    public ViewOnClickListenerC2488gW A00;
    public final View.OnClickListener A01;
    public final C12602a A02;
    public final C12732n A03;
    public final C2699k1 A04;
    public final C1580Ff A05;
    public final C1586Fl A06;
    public final String A07;
    public static final int A0B = (int) (CP.A02 * 2.0f);
    public static final int A0F = (int) (CP.A02 * 16.0f);
    public static final int A0D = (int) (CP.A02 * 20.0f);
    public static final int A0E = (int) (CP.A02 * 13.0f);
    public static final int A08 = (int) (CP.A02 * 72.0f);
    public static final int A0C = (int) (CP.A02 * 8.0f);
    public static final int A0A = (int) (CP.A02 * 24.0f);
    public static final int A09 = (int) (CP.A02 * 16.0f);

    public HF(C2699k1 c2699k1, C12732n c12732n, C12602a c12602a, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW, String str, View.OnClickListener onClickListener) {
        super(c2699k1);
        this.A04 = c2699k1;
        this.A03 = c12732n;
        this.A02 = c12602a;
        this.A00 = viewOnClickListenerC2488gW;
        this.A07 = str;
        this.A01 = onClickListener;
        this.A05 = new C1580Ff(this.A04);
        this.A06 = new C1586Fl(this.A04, C12622c.A01(null), true, false, true);
        A00();
    }

    private void A00() {
        AbstractC1587Fm.A00(this.A04, this, this.A03.A01());
        ImageView imageView = new ImageView(this.A04);
        imageView.setImageBitmap(DC.A01(DB.REDESIGN_CLOSE_ICON));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0A, A0A);
        imageView.setColorFilter(-1);
        layoutParams.addRule(11);
        layoutParams.setMargins(A09, A09, A09, A09);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
        imageView.setOnClickListener(this.A01);
        LinearLayout layout = new LinearLayout(this.A04);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        layout.setGravity(17);
        layout.setOrientation(1);
        ImageView closeImageView = this.A05;
        D3.A0K(closeImageView, 0);
        this.A05.setRadius(A0B);
        new AsyncTaskC2494gc(this.A05, this.A04).A04().A07(this.A03.A01());
        this.A06.A04(this.A02.A0F(), this.A03.A03(), null, false, true);
        this.A06.setAlignment(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, A0F, 0, A0F);
        this.A06.getDescriptionTextView().setText(this.A07);
        layout.addView(this.A05, new LinearLayout.LayoutParams(A08, A08));
        layout.addView(this.A06, layoutParams2);
        if (this.A00 != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            this.A00.setPadding(A0D, A0E, A0D, A0E);
            this.A00.setLayoutParams(layoutParams3);
            D3.A0Q(this.A00, D3.A06(-16738826, A0C));
            this.A00.setStateListAnimator(null);
            D3.A0V(this.A00);
            layout.addView(this.A00);
        }
        addView(layout);
    }
}
