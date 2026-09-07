package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SGo {
    private final int BSW;
    private final long Bzk;
    private final SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> DX;
    private final float JG;
    private final int[] KZx;
    private final float ML;
    private final int[] Og;
    private final float SD;
    private final long SGo;
    private final int Sn;
    private final int WV;
    private final int Wx;
    private final String XT;
    private final int[] ZZv;
    private final JSONObject aBv;
    private final int oX;
    private final float omh;
    private final int[] pA;
    private final JSONObject yFO;

    private SGo(pA pAVar) {
        this.pA = pAVar.BSW;
        this.Og = pAVar.WV;
        this.ZZv = pAVar.Wx;
        this.KZx = pAVar.SGo;
        this.ML = pAVar.Bzk;
        this.JG = pAVar.omh;
        this.SD = pAVar.SD;
        this.omh = pAVar.JG;
        this.Bzk = pAVar.ML;
        this.SGo = pAVar.ZZv;
        this.BSW = pAVar.Sn;
        this.WV = pAVar.DX;
        this.Wx = pAVar.oX;
        this.Sn = pAVar.XT;
        this.DX = pAVar.aBv;
        this.XT = pAVar.yFO;
        this.oX = pAVar.vZF;
        this.aBv = pAVar.Sd;
        this.yFO = pAVar.TX;
    }

    public JSONObject pA() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.yFO;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.yFO.opt(next));
                    }
                } catch (Exception unused) {
                }
            }
            int[] iArr = this.pA;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.pA[1]));
            }
            int[] iArr2 = this.Og;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.Og[1]));
            }
            int[] iArr3 = this.KZx;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.KZx[1]));
            }
            int[] iArr4 = this.ZZv;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.ZZv[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.ML)).putOpt("down_y", Float.toString(this.JG)).putOpt("up_x", Float.toString(this.SD)).putOpt("up_y", Float.toString(this.omh)).putOpt("down_time", Long.valueOf(this.Bzk)).putOpt("up_time", Long.valueOf(this.SGo)).putOpt("toolType", Integer.valueOf(this.BSW)).putOpt("deviceId", Integer.valueOf(this.WV)).putOpt("source", Integer.valueOf(this.Wx)).putOpt("ft", pA(this.DX, this.Sn)).putOpt("click_area_type", this.XT);
            int i = this.oX;
            if (i > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i));
            }
            JSONObject jSONObject3 = this.aBv;
            if (jSONObject3 != null) {
                jSONObject.putOpt("rectInfo", jSONObject3);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static JSONObject pA(SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    com.bytedance.sdk.openadsdk.core.Og.KZx.pA pAVarValueAt = sparseArray.valueAt(i2);
                    if (pAVarValueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(pAVarValueAt.KZx)).putOpt("mr", Double.valueOf(pAVarValueAt.Og)).putOpt(TypedValues.CycleType.S_WAVE_PHASE, Integer.valueOf(pAVarValueAt.pA)).putOpt("ts", Long.valueOf(pAVarValueAt.ZZv));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i)).putOpt("info", jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static class pA {
        private int[] BSW;
        private float Bzk;
        private int DX;
        private float JG;
        float KZx;
        private long ML;
        int Og;
        private float SD;
        private int[] SGo;
        private JSONObject Sd;
        private int Sn;
        private JSONObject TX;
        private int[] WV;
        private int[] Wx;
        private int XT;
        private long ZZv;
        private SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> aBv;
        private int oX;
        private float omh;
        float pA;
        private int vZF;
        private String yFO;

        public pA pA(int i) {
            this.vZF = i;
            return this;
        }

        public pA pA(JSONObject jSONObject) {
            this.Sd = jSONObject;
            return this;
        }

        public pA Og(JSONObject jSONObject) {
            this.TX = jSONObject;
            return this;
        }

        public pA Og(int i) {
            this.XT = i;
            return this;
        }

        public pA pA(SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray) {
            this.aBv = sparseArray;
            return this;
        }

        public pA pA(float f) {
            this.pA = f;
            return this;
        }

        public pA KZx(int i) {
            this.Og = i;
            return this;
        }

        public pA Og(float f) {
            this.KZx = f;
            return this;
        }

        public pA pA(long j) {
            this.ZZv = j;
            return this;
        }

        public pA Og(long j) {
            this.ML = j;
            return this;
        }

        public pA KZx(float f) {
            this.JG = f;
            return this;
        }

        public pA ZZv(float f) {
            this.SD = f;
            return this;
        }

        public pA ML(float f) {
            this.omh = f;
            return this;
        }

        public pA JG(float f) {
            this.Bzk = f;
            return this;
        }

        public pA pA(int[] iArr) {
            this.SGo = iArr;
            return this;
        }

        public pA Og(int[] iArr) {
            this.BSW = iArr;
            return this;
        }

        public pA KZx(int[] iArr) {
            this.WV = iArr;
            return this;
        }

        public pA ZZv(int[] iArr) {
            this.Wx = iArr;
            return this;
        }

        public pA ZZv(int i) {
            this.Sn = i;
            return this;
        }

        public pA ML(int i) {
            this.DX = i;
            return this;
        }

        public pA JG(int i) {
            this.oX = i;
            return this;
        }

        public pA pA(String str) {
            this.yFO = str;
            return this;
        }

        public SGo pA() {
            return new SGo(this);
        }
    }
}
