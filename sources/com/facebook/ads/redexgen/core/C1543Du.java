package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Du, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1543Du extends LinearLayout {
    public static final int A03 = (int) (CP.A02 * 10.0f);
    public static final int A04 = (int) (CP.A02 * 24.0f);
    public final ImageView A00;
    public final C12923g A01;
    public final C2699k1 A02;

    public C1543Du(C2699k1 c2699k1) {
        super(c2699k1);
        this.A02 = c2699k1;
        this.A01 = AbstractC12933h.A00(c2699k1.A02());
        this.A00 = new ImageView(c2699k1);
        A02();
    }

    private void A02() {
        A03(this.A00, DB.REDESIGN_INFO_ICON);
        setPadding(A03, A03 / 3, A03, A03 / 3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 16;
        addView(this.A00, layoutParams);
    }

    public static void A03(ImageView imageView, DB db) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(DC.A01(db));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C12732n c12732n, String str, AF af, DR dr) {
        setOnClickListener(new ViewOnClickListenerC1542Dt(this, af, dr, str, c12732n));
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
    }
}
