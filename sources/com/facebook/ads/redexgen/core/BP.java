package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class BP {
    public static void A00(BL bl) {
        new Handler(Looper.getMainLooper()).post(bl);
    }
}
