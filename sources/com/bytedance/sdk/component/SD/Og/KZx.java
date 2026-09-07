package com.bytedance.sdk.component.SD.Og;

import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public abstract class KZx {
    int JG;
    protected BSW KZx;
    String ML;
    protected String ZZv = null;
    protected final Map<String, String> SD = new HashMap();
    protected String omh = null;
    protected boolean Bzk = false;

    public void pA(String str) {
        this.ML = str;
    }

    public void pA(int i) {
        this.JG = i;
    }

    public KZx(BSW bsw) {
        this.KZx = bsw;
        try {
            KZx(UUID.randomUUID().toString());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void Og(String str) {
        this.omh = str;
    }

    public void Og(String str, String str2) {
        this.SD.put(str, str2);
    }

    public void ZZv(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.SD.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void KZx(String str) {
        this.ZZv = str;
    }

    public String KZx() {
        return this.ZZv;
    }

    public void Og() {
        BSW bsw;
        if (this.ZZv == null || (bsw = this.KZx) == null) {
            return;
        }
        com.bytedance.sdk.component.Og.pA.ZZv zZvPA = bsw.pA();
        synchronized (zZvPA) {
            for (com.bytedance.sdk.component.Og.pA.Og og : zZvPA.KZx()) {
                if (this.ZZv.equals(og.pA().pA())) {
                    og.KZx();
                }
            }
            for (com.bytedance.sdk.component.Og.pA.Og og2 : zZvPA.ZZv()) {
                if (this.ZZv.equals(og2.pA().pA())) {
                    og2.KZx();
                }
            }
        }
    }

    protected void pA(Wx.pA pAVar) {
        if (pAVar != null && this.SD.size() > 0) {
            for (Map.Entry<String, String> entry : this.SD.entrySet()) {
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
    }
}
