package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class JN {
    public static boolean A00(View view) {
        return view.getBackground() == null || view.getBackground().getAlpha() <= 0;
    }
}
