package com.bytedance.sdk.openadsdk.component.JG;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes9.dex */
public class Og implements Handler.Callback {
    private pA KZx;
    private final com.bytedance.sdk.openadsdk.component.omh.pA Og;
    private boolean SD;
    private Handler pA = new Handler(Looper.myLooper(), this);
    private int ZZv = 0;
    private int ML = 5;
    private int JG = 0;

    public Og(com.bytedance.sdk.openadsdk.component.omh.pA pAVar) {
        this.Og = pAVar;
    }

    public void pA(int i) {
        this.ZZv = i;
        int i2 = this.ML - i;
        this.Og.pA(i2);
        if (i <= 0) {
            pA pAVar = this.KZx;
            if (pAVar != null && !this.SD) {
                pAVar.Og();
                this.SD = true;
            }
            i = 0;
        }
        boolean z = i2 >= this.JG;
        pA pAVar2 = this.KZx;
        if (pAVar2 != null) {
            pAVar2.pA(i, i2, z);
        }
    }

    public void pA(float f) {
        int i = (int) f;
        this.ML = i;
        if (i <= 0) {
            this.ML = 5;
        }
    }

    public void pA(pA pAVar) {
        this.KZx = pAVar;
    }

    public int pA() {
        return this.JG;
    }

    public void Og(int i) {
        this.JG = i;
    }

    public void Og() {
        Handler handler = this.pA;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(100, this.ML, 0));
        }
    }

    public void KZx() {
        if (this.pA != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            messageObtain.arg1 = this.ZZv;
            this.pA.sendMessage(messageObtain);
        }
    }

    public void ZZv() {
        Handler handler = this.pA;
        if (handler != null) {
            handler.removeMessages(100);
        }
    }

    public void ML() {
        this.pA.removeCallbacksAndMessages(null);
        this.pA = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 100 && this.pA != null) {
            int i = message.arg1;
            pA(i);
            if (i > 0) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i - 1;
                this.pA.sendMessageDelayed(messageObtain, 1000L);
            }
        }
        return true;
    }
}
