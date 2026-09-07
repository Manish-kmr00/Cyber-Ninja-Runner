package com.bytedance.sdk.openadsdk.Bzk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Og<T> implements oX<T> {
    private final oX<T> KZx;
    private final String Og;
    private final yFO ZZv;
    private final long pA = SystemClock.elapsedRealtime();

    public Og(yFO yfo, String str, oX<T> oXVar) {
        this.KZx = oXVar;
        this.ZZv = yfo;
        this.Og = str;
    }

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(BSW<T> bsw) {
        oX<T> oXVar = this.KZx;
        if (oXVar != null) {
            oXVar.pA(bsw);
        }
        if (this.ZZv != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.pA;
            final int iSD = bsw.SD() / 1024;
            final int i = bsw.JG() ? 1 : 0;
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_image_success", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.Bzk.Og.1
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jElapsedRealtime);
                    jSONObject.put("url", Og.this.Og);
                    jSONObject.put("preload_size", iSD);
                    jSONObject.put("local_cache", i);
                    jSONObject.put("image_mode", Og.this.ZZv.RS());
                    return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("load_image_success").pA(Og.this.ZZv.FHA()).Og(jSONObject.toString());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.ML.oX
    public void pA(final int i, final String str, Throwable th) {
        oX<T> oXVar = this.KZx;
        if (oXVar != null) {
            oXVar.pA(i, str, th);
        }
        yFO yfo = this.ZZv;
        if (yfo == null || TextUtils.isEmpty(gbA.pA(yfo))) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - this.pA;
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("load_image_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.Bzk.Og.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", jElapsedRealtime);
                jSONObject.put("url", Og.this.Og);
                jSONObject.put("error_code", i);
                jSONObject.put("error_message", str);
                jSONObject.put("image_mode", Og.this.ZZv.RS());
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("load_image_error").pA(Og.this.ZZv.FHA()).Og(jSONObject.toString());
            }
        });
    }
}
