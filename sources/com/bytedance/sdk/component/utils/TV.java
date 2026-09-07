package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class TV extends Handler {
    protected WeakReference<pA> pA;

    public interface pA {
        void pA(Message message);
    }

    public TV(pA pAVar) {
        if (pAVar != null) {
            this.pA = new WeakReference<>(pAVar);
        }
    }

    public TV(Looper looper, pA pAVar) {
        super(looper);
        if (pAVar != null) {
            this.pA = new WeakReference<>(pAVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        pA pAVar;
        WeakReference<pA> weakReference = this.pA;
        if (weakReference == null || (pAVar = weakReference.get()) == null || message == null) {
            return;
        }
        pAVar.pA(message);
    }
}
