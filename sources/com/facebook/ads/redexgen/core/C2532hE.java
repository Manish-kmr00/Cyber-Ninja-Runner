package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2532hE extends EH {
    public static byte[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C12923g A04;
    public final C2699k1 A05;

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A06 = new byte[]{3, 32, 34, 42, 3, 44, 47, 51, 37, 96, 1, 36, 96, Ascii.DC2, 37, 48, 47, 50, 52, 41, 46, 39};
    }

    static {
        A0C();
        A09 = (int) (CP.A02 * 4.0f);
        A08 = (int) (CP.A02 * 10.0f);
        A07 = (int) (CP.A02 * 44.0f);
    }

    public C2532hE(C2699k1 c2699k1, A7 a7, String str) {
        super(c2699k1, a7, str);
        this.A05 = c2699k1;
        this.A04 = AbstractC12933h.A00(c2699k1.A02());
        this.A01 = new ImageView(getContext());
        this.A01.setPadding(A08, A08, A08, A08);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A07, A07);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        D3.A0K(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0L() {
        this.A01.setImageBitmap(DC.A01(DB.CROSS));
        this.A01.setOnClickListener(new EQ(this));
        this.A01.setContentDescription(A0B(4, 18, 84));
        EL el = new EL(this.A05);
        el.setData(this.A04.A0H(), DB.HIDE_AD);
        el.setOnClickListener(new ER(this, el));
        EL el2 = new EL(this.A05);
        el2.setData(this.A04.A0L(), DB.REPORT_AD);
        el2.setOnClickListener(new ES(this, el2));
        EL el3 = new EL(this.A05);
        el3.setData(this.A04.A0M(), DB.AD_CHOICES_ICON);
        el3.setOnClickListener(new ET(this, el3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A09, A09, A09);
        D3.A0R(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(el, layoutParams);
        this.A02.addView(el2, layoutParams);
        this.A02.addView(el3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0M() {
        D3.A0G(this);
        D3.A0H(this);
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0N(C12963k c12963k, EnumC12943i enumC12943i) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        D3.A0W(textView, true, 14);
        textView.setText(this.A04.A0D());
        textView.setGravity(17);
        D3.A0R(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final void A0O(C12963k c12963k, EnumC12943i enumC12943i) {
        D3.A0R(this.A03);
        this.A01.setImageBitmap(DC.A01(DB.BACK_ARROW));
        this.A01.setOnClickListener(new EU(this));
        this.A01.setContentDescription(A0B(0, 4, 85));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A09, A09, A09);
        for (C12963k c12963k2 : c12963k.A05()) {
            EL el = new EL(this.A05);
            el.setData(c12963k2.A04(), null);
            el.setOnClickListener(new EV(this, el, c12963k2));
            this.A02.addView(el, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.EH
    public final boolean A0P() {
        return true;
    }
}
