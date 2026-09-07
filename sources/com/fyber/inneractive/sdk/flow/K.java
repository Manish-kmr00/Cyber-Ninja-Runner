package com.fyber.inneractive.sdk.flow;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes10.dex */
public final class K extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f1779a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(N n, long j) {
        super(j, 1000L);
        this.f1779a = n;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        K k = this.f1779a.v;
        if (k != null) {
            k.cancel();
        }
        this.f1779a.d(false);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i = ((int) j) / 1000;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1779a.k;
        if (eVar != null) {
            eVar.updateCloseCountdown(i);
        }
    }
}
