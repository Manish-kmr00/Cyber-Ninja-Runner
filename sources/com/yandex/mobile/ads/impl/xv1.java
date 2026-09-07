package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.CustomizableMediaView;

/* JADX INFO: loaded from: classes13.dex */
final class xv1 implements Runnable {
    final /* synthetic */ dx0 b;
    final /* synthetic */ CustomizableMediaView c;
    final /* synthetic */ ax0 d;

    xv1(dx0 dx0Var, CustomizableMediaView customizableMediaView, ax0 ax0Var) {
        this.b = dx0Var;
        this.c = customizableMediaView;
        this.d = ax0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.c, this.d);
    }
}
