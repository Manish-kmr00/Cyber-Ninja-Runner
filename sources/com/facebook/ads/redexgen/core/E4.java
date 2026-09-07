package com.facebook.ads.redexgen.core;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E4 extends LinearLayout {
    public static String[] A04 = {"iBjFS74UqofOwX9raECs8wFiPopmP8ZT", "DvkIZsK2SfYDf1PYliynkurznpBmB2mx", "JthO9De0vDUnz", "alrxHoKVfabvqyWYzjdfx1EKUXaFGyZT", "MSxuugz3RBTPC5P7p9BXefIxh5y8oQF5", "xAXGeIm", "UaB9zlLwJ5ijSfJwpwiqdPYYRduUW", "7D"};
    public static final int A05 = (int) (CP.A02 * 10.0f);
    public static final int A06 = (int) (CP.A02 * 16.0f);
    public static final int A07 = (int) (CP.A02 * 40.0f);
    public int A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final C2699k1 A03;

    public E4(C2699k1 c2699k1, int i) {
        super(c2699k1);
        this.A03 = c2699k1;
        this.A01 = new ImageView(c2699k1);
        this.A02 = new LinearLayout(c2699k1);
        this.A00 = i;
        A00();
    }

    private void A00() {
        A01();
        setToolbarActionMode(this.A00);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A07, A07);
        layoutParams2.setMargins(A06, 0, A06, 0);
        this.A01.setLayoutParams(layoutParams2);
        this.A02.addView(this.A01, layoutParams2);
        addView(this.A02, layoutParams);
    }

    private void A01() {
        this.A01.setColorFilter(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Integer.MIN_VALUE);
        this.A01.setBackground(gradientDrawable);
        this.A01.setPadding(A05, A05, A05, A05);
    }

    public final boolean A02() {
        return (this.A00 == 2 || this.A00 == 4) ? false : true;
    }

    public int getToolbarActionMode() {
        return this.A00;
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setInitialUnskippableSeconds(int i) {
        if (i > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setToolbarActionMode(int i) {
        DB db;
        this.A03.A0F().AFJ(i);
        this.A00 = i;
        setVisibility(4);
        switch (i) {
            case 0:
                db = DB.NAV_CROSS;
                setVisibility(0);
                break;
            case 1:
                db = DB.ICON_SKIP;
                String[] strArr = A04;
                if (strArr[4].charAt(14) != strArr[1].charAt(14)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A04;
                strArr2[2] = "tOoZDmetKHu9g";
                strArr2[7] = "rn";
                setVisibility(0);
                break;
            case 8:
                db = DB.OTHER_SKIP;
                setVisibility(0);
                break;
            default:
                db = DB.NAV_CROSS;
                break;
        }
        this.A01.setImageBitmap(DC.A01(db));
        if (i == 1) {
            D3.A0E(1005, this.A01);
        } else {
            D3.A0E(1002, this.A01);
        }
    }
}
