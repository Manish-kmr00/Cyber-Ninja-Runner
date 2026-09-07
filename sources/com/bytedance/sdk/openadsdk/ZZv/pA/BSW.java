package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.content.Context;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.unity3d.services.UnityAdsConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BSW implements com.bytedance.sdk.component.JG.pA.ML {
    private final String pA = "[6508]";

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public int JG() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean KZx() {
        return true;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean Og() {
        return false;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean SD() {
        return false;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public com.bytedance.sdk.component.JG.pA.SD WV() {
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean omh() {
        return true;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public com.bytedance.sdk.component.JG.pA.ZZv.pA pA(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean pA() {
        return false;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean pA(Context context) {
        return DX.pA(context);
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public String pA(String str) {
        return com.bytedance.sdk.component.ZZv.pA.Og(str, com.bytedance.sdk.openadsdk.core.pA.pA());
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public String Og(String str) {
        return com.bytedance.sdk.component.ZZv.pA.pA(str, com.bytedance.sdk.openadsdk.core.pA.pA());
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public String Bzk() {
        return gbA.KZx();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public com.bytedance.sdk.component.JG.pA.ML.KZx SGo() {
        return new SD();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public Executor ZZv() {
        return xy.KZx();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public Executor ML() {
        return xy.SD();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public com.bytedance.sdk.component.JG.pA.JG BSW() {
        com.bytedance.sdk.component.JG.pA.JG jgPA;
        synchronized (this) {
            jgPA = com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(aBv.pA());
        }
        return jgPA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public void pA(boolean z, int i, long j, com.bytedance.sdk.component.JG.pA.JG.ZZv zZv) {
        Runnable runnablePA;
        if (zZv == null) {
            return;
        }
        pA.pA(pA.KZx, z, i, j);
        if (z) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("track_link_result", false, (com.bytedance.sdk.openadsdk.Sn.Og) new Wx(true, zZv));
            return;
        }
        Sn snRtW = oX.vkV().rtW();
        if (snRtW == null || zZv.ZZv() >= snRtW.pA(zZv.JG())) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("track_link_result", false, (com.bytedance.sdk.openadsdk.Sn.Og) new Wx(false, zZv));
        } else {
            if (!snRtW.pA() || (runnablePA = zZv.pA(com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA()), null)) == null) {
                return;
            }
            xy.pA().schedule(runnablePA, snRtW.Og(zZv.JG()), TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public void pA(boolean z) {
        pA.pA(pA.JG, z);
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public boolean Sn() {
        return BinderPoolService.pA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public int KZx(String str) {
        return oX.vkV().rtW().pA(str);
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public long DX() {
        long jPA = com.bytedance.sdk.openadsdk.vZF.pA.pA("log_queue_timeout", 40000);
        if (jPA < 30000 || jPA > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
            return 40000L;
        }
        return jPA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ML
    public void Wx() {
        pA.pA(pA.JG);
    }
}
