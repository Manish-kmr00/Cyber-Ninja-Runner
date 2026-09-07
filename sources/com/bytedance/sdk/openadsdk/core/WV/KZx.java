package com.bytedance.sdk.openadsdk.core.WV;

import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class KZx {
    private final AtomicBoolean BSW = new AtomicBoolean(false);
    protected String Bzk = "endcard_click";
    protected List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> JG;
    protected com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA KZx;
    protected String ML;
    protected int Og;
    protected List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> SD;
    private String SGo;
    private yFO WV;
    protected com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og ZZv;
    protected String omh;
    protected int pA;

    public KZx(int i, int i2, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og, String str, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list, List<com.bytedance.sdk.openadsdk.core.WV.Og.KZx> list2, String str2) {
        this.JG = new ArrayList();
        this.SD = new ArrayList();
        this.pA = i;
        this.Og = i2;
        this.KZx = enumC0233pA;
        this.ZZv = og;
        this.ML = str;
        this.JG = list;
        this.SD = list2;
        this.omh = str2;
    }

    public int Og() {
        return this.pA;
    }

    public int KZx() {
        return this.Og;
    }

    public void pA(long j) {
        com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.JG, null, j, this.SGo, new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og(this.Bzk, this.WV));
    }

    public void Og(long j) {
        if (this.BSW.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.WV.Og.KZx.Og(this.SD, null, j, this.SGo);
        }
    }

    public static float pA(int i, int i2, int i3, int i4, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA) {
        if (i2 == 0 || i4 == 0) {
            return 0.0f;
        }
        float f = i;
        float f2 = i3;
        return pA(og, enumC0233pA) / ((Math.abs((f / i2) - (f2 / i4)) + Math.abs((f - f2) / f)) + 1.0f);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.WV.KZx$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static float pA(com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og og, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA enumC0233pA) {
        int i = AnonymousClass1.pA[og.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.JAVASCRIPT.equals(enumC0233pA)) {
            return 1.0f;
        }
        return com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.IMAGE.equals(enumC0233pA) ? 0.8f : 0.0f;
    }

    public String ZZv() {
        int i = AnonymousClass1.pA[this.ZZv.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.ML;
            }
            if (i != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.pA + "\" height=\"" + this.Og + "\" src=\"" + this.ML + "\"></iframe>";
        }
        if (this.KZx == com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.ML + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        }
        if (this.KZx == com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.JAVASCRIPT) {
            return "<script src=\"" + this.ML + "\"></script>";
        }
        return null;
    }

    public String ML() {
        if (this.ZZv == com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.STATIC_RESOURCE && this.KZx == com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.IMAGE) {
            return this.ML;
        }
        return null;
    }

    public String JG() {
        return this.ML;
    }

    public void pA(String str) {
        this.SGo = str;
    }

    public static KZx Og(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        String strOptString = jSONObject.optString("creativeType", com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.NONE.toString());
        String strOptString2 = jSONObject.optString("resourceType", com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.HTML_RESOURCE.toString());
        String strOptString3 = jSONObject.optString("contentUrl");
        String strOptString4 = jSONObject.optString("clickThroughUri");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONArrayOptJSONArray.optString(i)).pA());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            arrayList2.add(new com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(jSONArrayOptJSONArray2.optString(i2)).pA());
        }
        return new KZx(iOptInt, iOptInt2, com.bytedance.sdk.openadsdk.core.WV.KZx.pA.EnumC0233pA.valueOf(strOptString), com.bytedance.sdk.openadsdk.core.WV.KZx.pA.Og.valueOf(strOptString2), strOptString3, arrayList, arrayList2, strOptString4);
    }

    public JSONObject pA() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.pA);
        jSONObject.put("height", this.Og);
        jSONObject.put("creativeType", this.KZx.toString());
        jSONObject.put("resourceType", this.ZZv.toString());
        jSONObject.put("contentUrl", this.ML);
        jSONObject.put("clickThroughUri", this.omh);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.JG));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.WV.Og.KZx.pA(this.SD));
        return jSONObject;
    }

    public void pA(yFO yfo) {
        this.WV = yfo;
    }
}
