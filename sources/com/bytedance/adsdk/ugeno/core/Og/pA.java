package com.bytedance.adsdk.ugeno.core.Og;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.SD.Bzk;
import com.bytedance.adsdk.ugeno.core.SD;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class pA implements Bzk.pA {
    private Handler JG = new Bzk(Looper.getMainLooper(), this);
    private Context KZx;
    private com.bytedance.adsdk.ugeno.Og.KZx ML;
    private WV Og;
    private SGo ZZv;
    private int pA;

    public pA(Context context, SGo sGo, com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.KZx = context;
        this.ZZv = sGo;
        this.ML = kZx;
    }

    public void pA(WV wv) {
        this.Og = wv;
    }

    public void pA() {
        SGo sGo = this.ZZv;
        if (sGo == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.bytedance.adsdk.ugeno.KZx.Og.pA(sGo.KZx().optString("delay"), this.ML.SGo()));
            this.pA = i;
            this.JG.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.SD.Bzk.pA
    public void pA(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectKZx = this.ZZv.KZx();
        if (TextUtils.equals(jSONObjectKZx.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectKZx.optString("nodeId");
            com.bytedance.adsdk.ugeno.Og.KZx kZx = this.ML;
            com.bytedance.adsdk.ugeno.Og.KZx KZx = kZx.Og(kZx).KZx(strOptString);
            new SD(KZx.Bzk(), com.bytedance.adsdk.ugeno.core.pA.pA(jSONObjectKZx.optJSONObject("animatorSet"), KZx)).pA();
        } else {
            WV wv = this.Og;
            if (wv != null) {
                SGo sGo = this.ZZv;
                com.bytedance.adsdk.ugeno.Og.KZx kZx2 = this.ML;
                wv.pA(sGo, kZx2, kZx2);
            }
        }
        this.JG.removeMessages(1001);
    }
}
