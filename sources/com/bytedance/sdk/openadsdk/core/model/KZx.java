package com.bytedance.sdk.openadsdk.core.model;

import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class KZx {
    private int SD;
    private String pA = "";
    private String Og = "";
    private String KZx = "";
    private String ZZv = "";
    private double ML = -1.0d;
    private int JG = -1;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public String Og() {
        return this.Og;
    }

    public void Og(String str) {
        this.Og = str;
    }

    public String KZx() {
        return this.KZx;
    }

    public void KZx(String str) {
        this.KZx = str;
    }

    public double ZZv() {
        return this.ML;
    }

    public void pA(double d) {
        if (d < 1.0d || d > 5.0d) {
            this.ML = -1.0d;
        } else {
            this.ML = d;
        }
    }

    public int ML() {
        return this.JG;
    }

    public void pA(int i) {
        if (i <= 0) {
            this.JG = -1;
        } else {
            this.JG = i;
        }
    }

    public int JG() {
        return this.SD;
    }

    public void Og(int i) {
        this.SD = i;
    }

    public String SD() {
        return this.ZZv;
    }

    public void ZZv(String str) {
        this.ZZv = str;
    }

    public JSONObject omh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Og());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, JG());
            jSONObject.put("comment_num", ML());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, pA());
            jSONObject.put("package_name", KZx());
            jSONObject.put("score", ZZv());
            jSONObject.put("app_category", SD());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.Og(e.toString());
        }
        return jSONObject;
    }
}
