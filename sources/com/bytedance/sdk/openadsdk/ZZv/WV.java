package com.bytedance.sdk.openadsdk.ZZv;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes9.dex */
public class WV {
    private static volatile WV pA;
    private Map<String, Object> JG;
    private final Handler KZx;
    private HandlerThread Og;
    private final Executor ZZv = Executors.newCachedThreadPool();
    private Og ML = Og.pA();

    public static WV pA() {
        if (pA == null) {
            synchronized (WV.class) {
                if (pA == null) {
                    pA = new WV();
                }
            }
        }
        return pA;
    }

    public WV pA(Map<String, Object> map) {
        this.JG = map;
        return pA();
    }

    private WV() {
        if (this.Og == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.Og = handlerThread;
            handlerThread.start();
        }
        this.KZx = new Handler(this.Og.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.ZZv.WV.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                pA pAVar = (message.obj == null || !(message.obj instanceof pA)) ? null : (pA) message.obj;
                if (pAVar == null) {
                    return true;
                }
                WV.this.Og(pAVar);
                return true;
            }
        });
    }

    public void pA(yFO yfo, String str) {
        Message messageObtainMessage = this.KZx.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = pA.pA(yfo, str, this.JG);
        messageObtainMessage.sendToTarget();
    }

    private void pA(pA pAVar) {
        if (pAVar == null) {
            return;
        }
        pAVar.Og();
        if (pAVar.pA() * this.ML.pA > this.ML.Og) {
            KZx(pAVar.pA(false));
            return;
        }
        Message messageObtainMessage = this.KZx.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = pAVar;
        this.KZx.sendMessageDelayed(messageObtainMessage, this.ML.pA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(pA pAVar) {
        if (pAVar == null) {
            return;
        }
        boolean zZZv = com.bytedance.sdk.openadsdk.core.DX.pA().ZZv();
        boolean zPA = com.bytedance.sdk.openadsdk.core.DX.pA().pA(true);
        if (zZZv || !zPA) {
            if (pAVar.ML == null) {
                pAVar.ML = new HashMap();
            }
            pAVar.ML.put("is_background", Boolean.valueOf(zZZv));
            pAVar.ML.put("has_focus", Boolean.valueOf(zPA));
            KZx(pAVar.pA(true));
            return;
        }
        pA(pAVar);
    }

    private void KZx(pA pAVar) {
        if (pAVar == null) {
            return;
        }
        this.ZZv.execute(pAVar);
    }

    private static class pA implements Serializable, Runnable {
        public yFO KZx;
        public Map<String, Object> ML;
        public String ZZv;
        public final AtomicInteger pA = new AtomicInteger(0);
        public final AtomicBoolean Og = new AtomicBoolean(false);
        private final long JG = SystemClock.elapsedRealtime();

        public static pA pA(yFO yfo, String str, Map<String, Object> map) {
            return new pA(yfo, str, map);
        }

        public pA(yFO yfo, String str, Map<String, Object> map) {
            this.KZx = yfo;
            this.ZZv = str;
            this.ML = map;
        }

        public pA pA(boolean z) {
            this.Og.set(z);
            return this;
        }

        public int pA() {
            return this.pA.get();
        }

        public void Og() {
            this.pA.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.KZx == null || TextUtils.isEmpty(this.ZZv)) {
                return;
            }
            String str = this.Og.get() ? "dpl_success" : "dpl_failed";
            if (this.ML == null) {
                this.ML = new HashMap();
            }
            yFO yfo = this.KZx;
            if (yfo != null && yfo.Lf() == 0) {
                Map<String, Object> map = this.ML;
                yFO yfo2 = this.KZx;
                map.put("auto_click", Boolean.valueOf((yfo2 == null || yfo2.ZZv()) ? false : true));
            }
            this.ML.put("lifeCycleInit", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.DX.pA().KZx()));
            this.ML.put("duration", Long.valueOf(SystemClock.elapsedRealtime() - this.JG));
            KZx.pA(this.KZx, this.ZZv, str, this.ML);
        }
    }

    private static class Og {
        public int pA = 300;
        public int Og = 6000;

        private Og() {
        }

        public static Og pA() {
            return new Og();
        }
    }
}
