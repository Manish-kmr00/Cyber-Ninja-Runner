package com.bytedance.sdk.openadsdk.core.omh;

import android.os.SystemClock;
import com.json.b9;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class TX implements com.bytedance.sdk.openadsdk.core.BSW.ML.KZx {
    private String JG;
    private long pA = 0;
    private long Og = 0;
    private int KZx = 0;
    private String ZZv = null;
    private String ML = null;
    private final AtomicBoolean SD = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
    public void pA(String str) {
        this.JG = str;
        this.pA = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
    public void pA(int i, String str, String str2) {
        this.KZx = i;
        this.ZZv = str;
        this.ML = str2;
        this.Og = SystemClock.elapsedRealtime();
        this.SD.set(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
    public void Og(String str) {
        this.ML = str;
        this.Og = SystemClock.elapsedRealtime();
        this.SD.set(true);
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str) {
        if (this.SD.get()) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, false, str, "success", this.Og - this.pA, this.ML, this.JG, 0, null);
        } else {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, false, str, b9.f.e, this.Og - this.pA, this.ML, this.JG, this.KZx, this.ZZv);
        }
    }
}
