package com.bytedance.sdk.openadsdk.core.WV.pA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.WV.Og.KZx;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class Og {
    public pA JG;
    protected int KZx;
    public int ML;
    protected final Context Og;
    protected double ZZv;
    public int pA;

    public static class pA {
        public boolean KZx;
        public int Og;
        public int pA;
    }

    public abstract com.bytedance.sdk.openadsdk.core.WV.pA pA(String str, List<KZx> list);

    public Og(Context context, int i, int i2) {
        this.KZx = 0;
        this.ZZv = 0.0d;
        if (i2 > 0 && i > 0) {
            this.ZZv = ((double) i) / ((double) i2);
        }
        float fML = Vgu.ML(context);
        if (fML != 0.0f && i > 0) {
            this.KZx = (int) (i / fML);
        }
        this.Og = context.getApplicationContext();
    }

    protected void pA(Exception exc, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put("error_code", i);
            com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    protected boolean pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    protected String Og(String str, List<KZx> list) {
        String strZZv;
        int i = this.pA;
        if (i >= 5) {
            return null;
        }
        this.pA = i + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
            ogKZx.Og(str);
            com.bytedance.sdk.component.SD.Og ogPA = ogKZx.pA();
            strZZv = ogPA.ZZv();
            try {
                ogPA.pA();
            } catch (Exception e) {
                e = e;
                pA(e, 0);
                if (!list.isEmpty()) {
                    KZx.Og(list, com.bytedance.sdk.openadsdk.core.WV.pA.pA.WRAPPER_TIMEOUT, -1L, null);
                }
            }
        } catch (Exception e2) {
            e = e2;
            strZZv = null;
        }
        return strZZv;
    }
}
