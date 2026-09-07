package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1821Oz implements InterfaceC2422fR {
    public Message A00;
    public C1820Oy A01;

    public C1821Oz() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C1820Oy.A01(this);
    }

    public final C1821Oz A01(Message message, C1820Oy c1820Oy) {
        this.A00 = message;
        this.A01 = c1820Oy;
        return this;
    }

    public final void A02() {
        ((Message) AbstractC2388es.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) AbstractC2388es.A01(this.A00));
        A00();
        return success;
    }
}
