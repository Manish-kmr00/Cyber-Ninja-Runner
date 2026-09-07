package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class Wx implements com.bytedance.sdk.openadsdk.oem.pA {
    private static boolean KZx;
    private static com.bytedance.sdk.openadsdk.component.reward.pA.pA Og;
    private static final Wx pA = new Wx();

    public static void pA(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        com.bytedance.sdk.openadsdk.core.model.BF bfDL = pAVar.Og.dL();
        if (bfDL == null || !bfDL.pA()) {
            return;
        }
        Og = pAVar;
        IPMiBroadcastReceiver iPMiBroadcastReceiverPA = IPMiBroadcastReceiver.pA(pAVar.Gx);
        if (iPMiBroadcastReceiverPA != null) {
            iPMiBroadcastReceiverPA.pA(pA);
        }
    }

    public static void pA() {
        if (Og == null) {
            return;
        }
        Og = null;
        IPMiBroadcastReceiver iPMiBroadcastReceiverPA = IPMiBroadcastReceiver.pA(com.bytedance.sdk.openadsdk.core.aBv.pA());
        if (iPMiBroadcastReceiverPA != null) {
            iPMiBroadcastReceiverPA.pA();
        }
        KZx = false;
    }

    public static void Og() {
        KZx = true;
    }

    @Override // com.bytedance.sdk.openadsdk.oem.pA
    public void pA(String str, final int i) {
        com.bytedance.sdk.openadsdk.core.model.KZx kZxWo;
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = Og;
        if (pAVar == null || (kZxWo = pAVar.Og.Wo()) == null) {
            return;
        }
        String strKZx = kZxWo.KZx();
        if (TextUtils.isEmpty(strKZx) || !strKZx.equals(str)) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.Wx.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (Wx.Og == null || (i2 = i) <= 0 || i2 > 5) {
                    return;
                }
                boolean z = true;
                boolean z2 = i2 == 1;
                if (Wx.KZx) {
                    Wx.Og.FQ.ZZv();
                    HashMap map = new HashMap();
                    map.put("click_scence", 4);
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA("click", Wx.Og.Og, new com.bytedance.sdk.openadsdk.core.model.SGo.pA().pA(), Wx.Og.ML, true, (Map<String, Object>) map, 1);
                } else {
                    z = z2;
                }
                if (z) {
                    Wx.pA();
                }
            }
        });
    }
}
