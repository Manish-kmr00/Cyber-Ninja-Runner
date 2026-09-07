package com.bytedance.sdk.openadsdk.BF.Og;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.WV;

/* JADX INFO: loaded from: classes11.dex */
public class SD {
    private static HandlerThread Og;
    private static pA pA;

    public static void pA() {
    }

    public static void pA(Og og) {
        if (og == null) {
            return;
        }
        Og();
        pA pAVar = pA;
        if (pAVar != null) {
            pAVar.pA(og);
        }
    }

    public static void Og(Og og) {
        if (og == null || pA == null) {
            return;
        }
        try {
            int iIntValue = og.BSW().intValue();
            if (pA.hasMessages(iIntValue)) {
                pA.removeMessages(iIntValue);
            }
        } catch (Exception unused) {
        }
    }

    public static void Og() {
        if (pA != null) {
            return;
        }
        try {
            HandlerThread handlerThread = Og;
            if (handlerThread != null && handlerThread.isAlive()) {
                return;
            }
            synchronized (SD.class) {
                HandlerThread handlerThread2 = Og;
                if (handlerThread2 == null || !handlerThread2.isAlive()) {
                    HandlerThread handlerThread3 = new HandlerThread("csj_MRC");
                    Og = handlerThread3;
                    handlerThread3.start();
                    pA = new pA(Og.getLooper());
                }
            }
        } catch (Throwable th) {
            WV.pA("MRC", th.getMessage());
        }
    }

    private static class pA extends Handler {
        public pA(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Og og = (Og) message.obj;
            if (og == null) {
                return;
            }
            int iOg = og.Og();
            if (iOg == 1) {
                og.SD();
            } else if (iOg == 2) {
                og.omh();
            } else {
                ML.Og(og.BSW());
                return;
            }
            if (og.Bzk()) {
                ML.Og(og.BSW());
            } else if (og.WV()) {
                pA(og);
            }
        }

        public void pA(Og og) {
            if (og == null) {
                return;
            }
            int iIntValue = og.BSW().intValue();
            if (hasMessages(iIntValue)) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = iIntValue;
            messageObtain.obj = og;
            sendMessageDelayed(messageObtain, og.JG());
        }
    }
}
