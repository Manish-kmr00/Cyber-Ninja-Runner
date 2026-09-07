package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HE implements View.OnClickListener {
    public static String[] A01 = {"iIV4C6PCamFbOwLs9osqMP65CW35qHVZ", "vu8ePLRZods6FhLp1sOjcscbCnKQtV0u", "aj5bYqq1P6NsPozz4AKHPhJxq4tExiSQ", "sREORf6VoPUSDy", "tYmkAFK6aojaVt6XrGIUitMYwL", "t5b15Ic4Fw72vyTqFljisKwND31PO9vi", "k2wG1EEpilyBuA", "DdpD6jZ5PRtvRqlim5b1myDycB"};
    public final /* synthetic */ C1722Kr A00;

    public HE(C1722Kr c1722Kr) {
        this.A00 = c1722Kr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (!(this.A00.A0U instanceof N9)) {
                return;
            }
            boolean z = this.A00.A0K;
            if (A01[5].charAt(19) != 'i') {
                throw new RuntimeException();
            }
            A01[5] = "JfKhMnDlcffILoVNGoui3HCKoOWuag6G";
            if (!z) {
                this.A00.A0L = true;
                this.A00.A0f(((N9) this.A00.A0U).A0G().toString());
                if (((AbstractC2402f6) this.A00).A05.A0a() >= 0) {
                    this.A00.A08.postDelayed(this.A00.A0k, ((AbstractC2402f6) this.A00).A05.A0a());
                }
            }
            this.A00.A0i(this.A00.A0K ? false : true);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
