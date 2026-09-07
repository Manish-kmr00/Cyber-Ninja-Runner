package com.bytedance.sdk.component.JG.pA.ZZv.pA;

import android.text.TextUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class pA implements com.bytedance.sdk.component.JG.pA.ZZv.pA {
    private String BSW;
    private String Bzk;
    private long JG;
    private byte KZx;
    private long ML;
    private Og Og;
    private long SD;
    private byte SGo;
    private int WV;
    private byte ZZv;
    private String omh;
    protected JSONObject pA;

    public pA(String str, JSONObject jSONObject) {
        this.Bzk = str;
        this.pA = jSONObject;
    }

    public pA(String str, Og og) {
        this.Bzk = str;
        this.Og = og;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public Og pA() {
        return this.Og;
    }

    private pA() {
    }

    public String BSW() {
        return this.BSW;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public synchronized JSONObject SD() {
        Og og;
        if (this.pA == null && (og = this.Og) != null) {
            this.pA = og.pA(BSW());
        }
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void pA(JSONObject jSONObject) {
        this.pA = jSONObject;
    }

    public static com.bytedance.sdk.component.JG.pA.ZZv.pA KZx(String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            int iOptInt = jSONObjectJsonObjectInit.optInt("type");
            int iOptInt2 = jSONObjectJsonObjectInit.optInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            pA pAVar = new pA();
            pAVar.pA((byte) iOptInt);
            pAVar.Og((byte) iOptInt2);
            pAVar.pA(jSONObjectJsonObjectInit.optJSONObject("event"));
            pAVar.pA(jSONObjectJsonObjectInit.optString("localId"));
            pAVar.Og(jSONObjectJsonObjectInit.optString("genTime"));
            pAVar.pA(jSONObjectJsonObjectInit.optInt("channel"));
            return pAVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void KZx(byte b) {
        this.SGo = b;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public byte Og() {
        return this.SGo;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public String KZx() {
        return this.Bzk;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public byte ZZv() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void pA(byte b) {
        this.KZx = b;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void pA(String str) {
        this.Bzk = str;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void Og(String str) {
        this.omh = str;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void pA(long j) {
        this.ML = j;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public long omh() {
        return this.ML;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void Og(long j) {
        this.JG = j;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public long Bzk() {
        return this.JG;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void KZx(long j) {
        this.SD = j;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public int SGo() {
        return this.WV;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void pA(int i) {
        this.WV = i;
    }

    public String WV() {
        return this.omh;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public void Og(byte b) {
        this.ZZv = b;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public byte ML() {
        return this.ZZv;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA
    public String JG() {
        if (TextUtils.isEmpty(this.Bzk)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.Bzk);
            jSONObject.put("event", SD());
            jSONObject.put("genTime", WV());
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, (int) this.ZZv);
            jSONObject.put("type", (int) this.KZx);
            jSONObject.put("channel", this.WV);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
