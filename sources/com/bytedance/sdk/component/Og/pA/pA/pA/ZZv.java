package com.bytedance.sdk.component.Og.pA.pA.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.Wx;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv extends BSW {
    public pA Bzk;
    public ML omh;

    public ZZv(BSW.pA pAVar) {
        super(pAVar);
        this.omh = new ML();
        this.Bzk = new pA(this.omh.Og());
    }

    @Override // com.bytedance.sdk.component.Og.pA.BSW
    public com.bytedance.sdk.component.Og.pA.ZZv pA() {
        return this.omh;
    }

    @Override // com.bytedance.sdk.component.Og.pA.BSW
    public com.bytedance.sdk.component.Og.pA.Og pA(Wx wx) {
        wx.pA(this);
        if (wx == null || wx.Og() == null || wx.Og().pA() == null || TextUtils.isEmpty(wx.Og().pA().toString())) {
            return null;
        }
        if (pA.pA != null && pA.pA.Og() && this.Bzk.ML() && !"setting".equals(wx.JG())) {
            Og og = new Og(wx, this.Bzk);
            this.Bzk.KZx().add(og);
            return og;
        }
        Og og2 = new Og(wx, this.omh);
        this.omh.KZx().add(og2);
        return og2;
    }
}
