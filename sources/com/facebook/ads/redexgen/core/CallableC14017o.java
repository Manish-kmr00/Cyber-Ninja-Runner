package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class CallableC14017o implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C14067t A01;

    public CallableC14017o(C14067t c14067t, C14027p c14027p) {
        this.A01 = c14067t;
        new Handler(Looper.getMainLooper()).post(new C2702k4(this, c14067t, c14027p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C14027p c14027p) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        J7 j7A01 = J7.A01(this.A01.A04.A02());
        Uri uriA00 = C5.A00(c14027p.A08);
        long jA0R = c14027p.A00;
        if (jA0R == -1) {
            jA0R = C14499m.A0R(this.A01.A04);
        }
        j7A01.A0I(uriA00, new C2701k3(this, c14027p, jA0R, jCurrentTimeMillis), jA0R);
    }
}
