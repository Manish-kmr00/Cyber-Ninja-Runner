package com.bytedance.adsdk.ugeno.ZZv.KZx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.adsdk.ugeno.SD.Bzk;

/* JADX INFO: loaded from: classes11.dex */
public class ML extends pA implements Bzk.pA {
    private Handler BSW;
    private int Bzk;
    private int SGo;
    private int WV;

    public ML(Context context) {
        super(context);
        this.SGo = 0;
        this.BSW = new Bzk(Looper.getMainLooper(), this);
        this.WV = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.KZx.pA
    public boolean pA(Object... objArr) {
        if (this.ML != null) {
            int iPA = com.bytedance.adsdk.ugeno.SD.KZx.pA(this.ML.get("loop"), 0);
            this.Bzk = iPA;
            if (iPA <= 0) {
                this.WV = -1;
            } else {
                this.WV = iPA;
            }
            this.SGo = com.bytedance.adsdk.ugeno.SD.KZx.pA(this.ML.get("duration"), 0);
        }
        this.BSW.sendEmptyMessageDelayed(1001, this.SGo);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.SD.Bzk.pA
    public void pA(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        Log.d("UGBaseEventMonitor", "handleMsg: execute timer event" + this.WV);
        this.pA.pA(this.Og, this.JG, this.KZx.Og());
        int i3 = this.WV - 1;
        this.WV = i3;
        if (i3 < 0 && (i2 = this.SGo) != 0) {
            this.BSW.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.SGo) != 0) {
            this.BSW.sendEmptyMessageDelayed(1001, i);
        } else {
            this.BSW.removeMessages(1001);
        }
    }
}
