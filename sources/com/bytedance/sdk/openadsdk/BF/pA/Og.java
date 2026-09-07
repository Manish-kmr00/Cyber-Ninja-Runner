package com.bytedance.sdk.openadsdk.BF.pA;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    private final yFO Og;
    private int pA = KZx.Og;
    private final AtomicBoolean KZx = new AtomicBoolean(false);
    private final AtomicBoolean ZZv = new AtomicBoolean(true);
    private final AtomicInteger ML = new AtomicInteger(0);
    private long JG = 0;
    private long SD = 0;
    private final Runnable omh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.BF.pA.Og.3
        @Override // java.lang.Runnable
        public void run() {
            Og.this.ZZv();
        }
    };

    public Og(yFO yfo) {
        this.Og = yfo;
    }

    public void pA() {
        if (this.ML.get() != 0) {
            return;
        }
        this.pA = this.Og.fhy() * 1000;
        this.ML.set(1);
        this.JG = SystemClock.elapsedRealtime();
        Handler handlerPA = pA.pA();
        if (handlerPA != null) {
            handlerPA.postDelayed(this.omh, this.pA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        if (this.KZx.compareAndSet(false, true)) {
            Og();
            final long jElapsedRealtime = this.SD + (SystemClock.elapsedRealtime() - this.JG);
            this.SD = jElapsedRealtime;
            xy.KZx(new omh("ev_tracker") { // from class: com.bytedance.sdk.openadsdk.BF.pA.Og.1
                @Override // java.lang.Runnable
                public void run() {
                    String strPA = gbA.pA(Og.this.Og);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ev_wait_time_server", Og.this.Og.fhy() * 1000);
                        jSONObject.put("ev_wait_time_client", jElapsedRealtime);
                    } catch (JSONException e) {
                        WV.pA("EvTracker", e.getMessage());
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(Og.this.Og, strPA, Og.this.Og.aOS(), jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        if (this.ML.get() == 2) {
            this.JG = SystemClock.elapsedRealtime();
            Handler handlerPA = pA.pA();
            if (handlerPA != null) {
                handlerPA.postDelayed(this.omh, ((long) this.pA) - this.SD);
            }
            this.ML.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (this.ML.get() != 1 || this.JG == 0) {
            return;
        }
        Handler handlerPA = pA.pA();
        if (handlerPA != null) {
            handlerPA.removeCallbacks(this.omh);
        }
        this.SD += SystemClock.elapsedRealtime() - this.JG;
        this.JG = 0L;
        this.ML.set(2);
    }

    public void Og() {
        this.ML.set(3);
        Handler handlerPA = pA.pA();
        if (handlerPA != null) {
            handlerPA.removeCallbacks(this.omh);
        }
    }

    public void pA(final int i) {
        Handler handlerPA;
        if (this.ML.get() == 3 || (handlerPA = pA.pA()) == null) {
            return;
        }
        handlerPA.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.BF.pA.Og.2
            @Override // java.lang.Runnable
            public void run() {
                if (i == 4 && Og.this.ZZv.get()) {
                    Og.this.ML();
                    return;
                }
                int i2 = i;
                if (i2 == 8) {
                    Og.this.JG();
                } else if (i2 == 5) {
                    Og.this.ZZv();
                }
            }
        });
    }

    public void pA(boolean z) {
        this.ZZv.set(z);
    }

    public boolean KZx() {
        return this.ML.get() == 3;
    }
}
