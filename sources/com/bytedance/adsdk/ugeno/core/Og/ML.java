package com.bytedance.adsdk.ugeno.core.Og;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.SD.Bzk;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ML implements Bzk.pA {
    private com.bytedance.adsdk.ugeno.Og.KZx JG;
    private WV KZx;
    private SGo ML;
    private int Og;
    private Handler SD = new Bzk(Looper.getMainLooper(), this);
    private Context ZZv;
    private boolean pA;

    public ML(Context context, SGo sGo, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.ZZv = context;
        this.ML = sGo;
        this.JG = kZx;
    }

    public void pA(WV wv) {
        this.KZx = wv;
    }

    public void pA() {
        SGo sGo = this.ML;
        if (sGo == null) {
            return;
        }
        JSONObject jSONObjectKZx = sGo.KZx();
        try {
            this.Og = Integer.parseInt(com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectKZx.optString("interval", "8000"), this.JG.SGo()));
            this.pA = jSONObjectKZx.optBoolean("repeat");
            this.SD.sendEmptyMessageDelayed(1001, this.Og);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.SD.Bzk.pA
    public void pA(Message message) {
        if (message.what != 1001) {
            return;
        }
        WV wv = this.KZx;
        if (wv != null) {
            SGo sGo = this.ML;
            com.bytedance.adsdk.ugeno.Og.KZx kZx = this.JG;
            wv.pA(sGo, kZx, kZx);
        }
        if (this.pA) {
            this.SD.sendEmptyMessageDelayed(1001, this.Og);
        } else {
            this.SD.removeMessages(1001);
        }
    }
}
