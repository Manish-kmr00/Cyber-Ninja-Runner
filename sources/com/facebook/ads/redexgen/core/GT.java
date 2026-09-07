package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GT extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC2488gW A02;
    public static final int A05 = (int) (CP.A02 * 36.0f);
    public static final int A06 = (int) (CP.A02 * 36.0f);
    public static final int A03 = (int) (CP.A02 * 23.0f);
    public static final int A04 = (int) (CP.A02 * 3.0f);
    public static final int A07 = (int) (CP.A02 * 4.0f);

    public GT(C2699k1 c2699k1, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW, AbstractC2855md abstractC2855md, A7 a7, DR dr, JL jl, C1518Cv c1518Cv, C12622c c12622c, FP fp) {
        super(c2699k1);
        this.A00 = c12622c.A09(true);
        this.A01 = new RelativeLayout(c2699k1);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c2699k1, abstractC2855md.A1b().A0H().A04());
        if (viewOnClickListenerC2488gW == null) {
            this.A02 = new ViewOnClickListenerC2488gW(c2699k1, abstractC2855md.A0e(), (C12622c) null, a7, dr, jl, c1518Cv, abstractC2855md.A1c());
        } else {
            this.A02 = viewOnClickListenerC2488gW;
        }
        A02();
        this.A02.setCta(abstractC2855md.A1b().A0H(), abstractC2855md.A1g(), new HashMap(), fp);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C2699k1 c2699k1, View view) {
        ImageView imageView = new ImageView(c2699k1);
        imageView.setImageBitmap(DC.A01(DB.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C2699k1 c2699k1, String str) {
        Button button = new Button(c2699k1);
        D3.A0I(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        D3.A0M(button, this.A00, A07);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c2699k1, button);
    }

    public final void A02() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    public final void A03(String str) {
        this.A02.A0A(str);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC2855md abstractC2855md, DQ dq) {
        this.A02.A0B(abstractC2855md, dq);
    }

    public void setCta(C12632d c12632d, String str, HashMap<String, String> extras, FP fp) {
        this.A02.setCta(c12632d, str, extras, fp);
    }
}
