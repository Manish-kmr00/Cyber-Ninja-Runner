package com.bytedance.sdk.component.omh.pA;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.TV;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes10.dex */
public class Og extends TV implements KZx {
    private final HandlerThread Og;

    Og(HandlerThread handlerThread, TV.pA pAVar) {
        super(handlerThread.getLooper(), pAVar);
        this.Og = handlerThread;
    }

    @Override // com.bytedance.sdk.component.omh.pA.KZx
    public void pA() {
        removeCallbacksAndMessages(null);
        if (this.pA != null) {
            this.pA.clear();
            this.pA = null;
        }
    }

    public void pA(TV.pA pAVar) {
        this.pA = new WeakReference<>(pAVar);
    }

    public void Og() {
        HandlerThread handlerThread = this.Og;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
