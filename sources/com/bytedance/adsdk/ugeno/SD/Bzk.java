package com.bytedance.adsdk.ugeno.SD;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes10.dex */
public class Bzk extends Handler {
    private final WeakReference<pA> pA;

    public interface pA {
        void pA(Message message);
    }

    public Bzk(Looper looper, pA pAVar) {
        super(looper);
        this.pA = new WeakReference<>(pAVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        pA pAVar = this.pA.get();
        if (pAVar == null || message == null) {
            return;
        }
        pAVar.pA(message);
    }
}
