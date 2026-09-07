package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes7.dex */
public class a2 extends u1 {
    public a2(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.k kVar) {
        super(bVar, activity, kVar);
    }

    @Override // com.applovin.impl.u1
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    @Override // com.applovin.impl.u1
    public /* bridge */ /* synthetic */ void a(View view) {
        super.a(view);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:20:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:23:0x0114  */
    /* JADX WARN: Code duplicated, block: B:25:0x012a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0132  */
    /* JADX WARN: Code duplicated, block: B:28:0x0136  */
    /* JADX WARN: Code duplicated, block: B:31:0x0145  */
    /* JADX WARN: Code duplicated, block: B:33:0x018a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0193  */
    /* JADX WARN: Code duplicated, block: B:37:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:40:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:42:0x0206  */
    /* JADX WARN: Code duplicated, block: B:45:0x0249  */
    /* JADX WARN: Code duplicated, block: B:48:0x0254  */
    /* JADX WARN: Code duplicated, block: B:49:0x025a  */
    public void a(ImageView imageView, com.applovin.impl.adview.g gVar, final com.applovin.impl.adview.l lVar, a aVar, ProgressBar progressBar, i0 i0Var, View view, View view2, AppLovinAdView appLovinAdView, com.applovin.impl.adview.k kVar, ImageView imageView2, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        l7 l7Var;
        int i;
        int i2;
        a8 a8VarL0;
        if (this.c.s0() == com.applovin.impl.sdk.ad.b.e.TOP) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
        } else if (this.c.s0() == com.applovin.impl.sdk.ad.b.e.BOTTOM) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        } else {
            if (this.c.s0() == com.applovin.impl.sdk.ad.b.e.LEFT) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1, 3);
            } else if (this.c.s0() == com.applovin.impl.sdk.ad.b.e.RIGHT) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1, 5);
            } else {
                layoutParams = this.e;
            }
            appLovinAdView.setLayoutParams(this.e);
            this.d.addView(appLovinAdView);
            view2.setLayoutParams(this.e);
            this.d.addView(view2);
            view.setLayoutParams(layoutParams);
            this.d.addView(view);
            if (lVar != null) {
                a8VarL0 = this.c.l0();
                LinearLayout linearLayout = new LinearLayout(this.b);
                linearLayout.setOrientation(1);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setGravity(a8VarL0.e());
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                LinearLayout linearLayout2 = new LinearLayout(this.b);
                linearLayout2.setOrientation(0);
                linearLayout2.setWeightSum(100.0f);
                linearLayout2.setGravity(a8VarL0.e());
                ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, 0, a8VarL0.f());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, a8VarL0.i());
                int iDpToPx = AppLovinSdkUtils.dpToPx(this.b, a8VarL0.g());
                layoutParams4.setMargins(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
                linearLayout2.addView(lVar, layoutParams4);
                linearLayout.addView(linearLayout2, layoutParams3);
                this.d.addView(linearLayout, layoutParams2);
                if (a8VarL0.a() > 0.0f) {
                    lVar.setVisibility(4);
                    long jC = k7.c(a8VarL0.a());
                    final long jB = a8VarL0.b();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            b8.a(lVar, jB, (Runnable) null);
                        }
                    }, jC);
                }
                if (a8VarL0.c() > 0.0f) {
                    long jC2 = k7.c(a8VarL0.c());
                    final long jD = a8VarL0.d();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b8.b(lVar, jD, null);
                        }
                    }, jC2);
                }
            }
            if (gVar != null) {
                if (this.c.M0()) {
                    i = 48;
                    i2 = 3;
                } else {
                    i = 48;
                    i2 = 5;
                }
                a(this.c.o(), i | i2, gVar);
            }
            if (imageView != null) {
                int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.c2)).intValue());
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, ((Integer) this.f707a.a(v4.e2)).intValue());
                int iDpToPx3 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.d2)).intValue());
                layoutParams5.setMargins(iDpToPx3, iDpToPx3, iDpToPx3, iDpToPx3);
                this.d.addView(imageView, layoutParams5);
            }
            if (aVar != null) {
                this.d.addView(aVar, this.e);
            }
            if (i0Var != null) {
                int iDpToPx4 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.P1)).intValue());
                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iDpToPx4, iDpToPx4, ((Integer) this.f707a.a(v4.O1)).intValue());
                int iDpToPx5 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.N1)).intValue());
                layoutParams6.setMargins(iDpToPx5, iDpToPx5, iDpToPx5, iDpToPx5);
                this.d.addView(i0Var, layoutParams6);
            }
            if (progressBar != null) {
                FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, 20, 80);
                layoutParams7.setMargins(0, 0, 0, ((Integer) this.f707a.a(v4.h2)).intValue());
                this.d.addView(progressBar, layoutParams7);
            }
            if (imageView2 != null) {
                l7Var = (l7) this.c;
                if (l7Var.D1()) {
                    int iDpToPx6 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().g());
                    int iDpToPx7 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().d());
                    int iDpToPx8 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.N4)).intValue());
                    FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(iDpToPx6, iDpToPx7, 83);
                    layoutParams8.setMargins(iDpToPx8, iDpToPx8, iDpToPx8, iDpToPx8);
                    this.d.addView(imageView2, layoutParams8);
                }
            }
            if (kVar != null) {
                this.d.addView(kVar, this.e);
            }
            if (viewGroup != null) {
                viewGroup.addView(this.d);
            } else {
                this.b.setContentView(this.d);
            }
        }
        appLovinAdView.setLayoutParams(this.e);
        this.d.addView(appLovinAdView);
        view2.setLayoutParams(this.e);
        this.d.addView(view2);
        view.setLayoutParams(layoutParams);
        this.d.addView(view);
        if (lVar != null) {
            a8VarL0 = this.c.l0();
            LinearLayout linearLayout3 = new LinearLayout(this.b);
            linearLayout3.setOrientation(1);
            linearLayout3.setWeightSum(100.0f);
            linearLayout3.setGravity(a8VarL0.e());
            ViewGroup.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout4 = new LinearLayout(this.b);
            linearLayout4.setOrientation(0);
            linearLayout4.setWeightSum(100.0f);
            linearLayout4.setGravity(a8VarL0.e());
            ViewGroup.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, 0, a8VarL0.f());
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, -1, a8VarL0.i());
            int iDpToPx9 = AppLovinSdkUtils.dpToPx(this.b, a8VarL0.g());
            layoutParams11.setMargins(iDpToPx9, iDpToPx9, iDpToPx9, iDpToPx9);
            linearLayout4.addView(lVar, layoutParams11);
            linearLayout3.addView(linearLayout4, layoutParams10);
            this.d.addView(linearLayout3, layoutParams9);
            if (a8VarL0.a() > 0.0f) {
                lVar.setVisibility(4);
                long jC3 = k7.c(a8VarL0.a());
                final long jB2 = a8VarL0.b();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b8.a(lVar, jB2, (Runnable) null);
                    }
                }, jC3);
            }
            if (a8VarL0.c() > 0.0f) {
                long jC4 = k7.c(a8VarL0.c());
                final long jD2 = a8VarL0.d();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b8.b(lVar, jD2, null);
                    }
                }, jC4);
            }
        }
        if (gVar != null) {
            if (this.c.M0()) {
                i = 48;
                i2 = 3;
            } else {
                i = 48;
                i2 = 5;
            }
            a(this.c.o(), i | i2, gVar);
        }
        if (imageView != null) {
            int iDpToPx10 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.c2)).intValue());
            FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(iDpToPx10, iDpToPx10, ((Integer) this.f707a.a(v4.e2)).intValue());
            int iDpToPx11 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.d2)).intValue());
            layoutParams12.setMargins(iDpToPx11, iDpToPx11, iDpToPx11, iDpToPx11);
            this.d.addView(imageView, layoutParams12);
        }
        if (aVar != null) {
            this.d.addView(aVar, this.e);
        }
        if (i0Var != null) {
            int iDpToPx12 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.P1)).intValue());
            FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(iDpToPx12, iDpToPx12, ((Integer) this.f707a.a(v4.O1)).intValue());
            int iDpToPx13 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.N1)).intValue());
            layoutParams13.setMargins(iDpToPx13, iDpToPx13, iDpToPx13, iDpToPx13);
            this.d.addView(i0Var, layoutParams13);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams14.setMargins(0, 0, 0, ((Integer) this.f707a.a(v4.h2)).intValue());
            this.d.addView(progressBar, layoutParams14);
        }
        if (imageView2 != null) {
            l7Var = (l7) this.c;
            if (l7Var.D1()) {
                int iDpToPx14 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().g());
                int iDpToPx15 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().d());
                int iDpToPx16 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f707a.a(v4.N4)).intValue());
                FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(iDpToPx14, iDpToPx15, 83);
                layoutParams15.setMargins(iDpToPx16, iDpToPx16, iDpToPx16, iDpToPx16);
                this.d.addView(imageView2, layoutParams15);
            }
        }
        if (kVar != null) {
            this.d.addView(kVar, this.e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.d);
        } else {
            this.b.setContentView(this.d);
        }
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        s.a(this.d, view);
        if (gVar != null) {
            a(this.c.o(), (this.c.E0() ? 3 : 5) | 48, gVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.f707a.a(v4.o2)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.f707a.a(v4.p2)).intValue());
            this.d.addView(progressBar, layoutParams);
        }
        if (kVar != null) {
            this.d.addView(kVar, this.e);
        }
    }
}
