package com.bykv.vk.openvk.pA.pA.Og.Og.ML;

import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ZZv implements Og {
    private BSW pA;

    public ZZv() {
        this.pA = null;
        this.pA = com.bykv.vk.openvk.pA.pA.pA.KZx.ZZv();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.Og
    public pA pA(ML ml) throws IOException {
        Wx.pA pAVar = new Wx.pA();
        try {
            if (ml.ML != null) {
                for (Map.Entry<String, String> entry : ml.ML.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        pAVar.Og(key, value);
                    }
                }
            }
            DX dxOg = this.pA.pA(pAVar.Og(ml.Og).pA().pA("videoPreloadLowVersion").pA(6).Og()).Og();
            new Object[]{"response code = ", Integer.valueOf(dxOg.KZx())};
            return new JG(dxOg, ml);
        } catch (Throwable unused) {
            return null;
        }
    }
}
