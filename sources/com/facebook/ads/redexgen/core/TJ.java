package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TJ {
    public final int A00;
    public final R5 A01;
    public final CopyOnWriteArrayList<DrmSessionEventListener.EventDispatcher.ListenerAndHandler> A02;

    public TJ() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    public TJ(CopyOnWriteArrayList<DrmSessionEventListener.EventDispatcher.ListenerAndHandler> listenerAndHandlers, int i, R5 r5) {
        this.A02 = listenerAndHandlers;
        this.A00 = i;
        this.A01 = r5;
    }

    public final TJ A00(int i, R5 r5) {
        return new TJ(this.A02, i, r5);
    }
}
