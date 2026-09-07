package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class FE {
    public static void A00(View view, boolean z, View.OnClickListener onClickListener) {
        if (!z) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z) {
                return;
            }
            FD fd = new FD(onClickListener);
            view.setOnClickListener(fd);
            view.setOnTouchListener(new FC(fd));
        }
    }
}
