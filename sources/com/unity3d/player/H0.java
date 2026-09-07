package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class H0 implements Runnable {
    H0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC3787c.a();
        } catch (Exception e) {
            B.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
