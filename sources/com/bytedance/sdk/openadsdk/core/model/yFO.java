package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.List;
import java.util.Map;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class yFO {
    protected boolean pA;
    public static final String KZx = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"is", gbA.Sd()});
    public static final String ZZv = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"is", gbA.Sd(), "sample"});
    public static final String ML = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{gbA.Sd(), "strategy"});
    protected static int Bzk = 330;
    private long SGo = 0;
    protected boolean Og = false;
    protected boolean JG = com.bytedance.sdk.openadsdk.BF.pA.KZx.pA;
    protected int SD = com.bytedance.sdk.openadsdk.BF.pA.KZx.Og;
    protected String omh = com.bytedance.sdk.openadsdk.BF.pA.KZx.KZx;

    public abstract com.bytedance.sdk.component.Bzk.Og.pA BDQ();

    public abstract int BF();

    public abstract void BF(int i);

    public abstract void BF(String str);

    public abstract ML BSW();

    public abstract void BSW(int i);

    public abstract void BSW(String str);

    public abstract void BSW(boolean z);

    public abstract com.bykv.vk.openvk.pA.pA.pA.KZx.Og Bf();

    public abstract void Bf(int i);

    public abstract int Bi();

    public abstract boolean Bpk();

    public abstract XT Bzk();

    public abstract void Bzk(int i);

    public abstract void Bzk(String str);

    public abstract void Bzk(boolean z);

    public abstract pA CIG();

    public abstract void CIG(int i);

    public abstract boolean DDZ();

    public abstract long DX();

    public abstract void DX(int i);

    public abstract void DX(String str);

    public abstract boolean Dc();

    public abstract boolean EC();

    public abstract boolean Evs();

    public abstract JSONObject FGT();

    public abstract int FHA();

    public abstract int FK();

    public abstract eG FQ();

    public abstract void FQ(int i);

    public abstract boolean Fb();

    public abstract void GL();

    public abstract String Gag();

    public abstract int GbR();

    public abstract int Gx();

    public abstract void Gx(int i);

    public abstract int HMH();

    public abstract String HSv();

    public abstract void HSv(int i);

    public abstract int IG();

    public abstract void IG(int i);

    public abstract List<DX> IIF();

    public abstract boolean ISu();

    public abstract String Ij();

    public abstract long Io();

    public abstract BSW Itl();

    public abstract int JBA();

    public abstract int JEI();

    public abstract String JG();

    public abstract void JG(int i);

    public abstract void JG(String str);

    public abstract void JG(boolean z);

    public abstract void KZx(int i);

    public abstract void KZx(long j);

    public abstract void KZx(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og);

    public abstract void KZx(DX dx);

    public abstract void KZx(JSONObject jSONObject);

    public abstract void KZx(boolean z);

    public abstract long Kj();

    public abstract void Ky();

    public abstract int LAE();

    public abstract JSONObject Ld();

    public abstract int Lf();

    public abstract boolean LhC();

    public abstract int Lm();

    public abstract void ML(int i);

    public abstract void ML(String str);

    public abstract void ML(JSONObject jSONObject);

    public abstract void ML(boolean z);

    public abstract boolean ML();

    public abstract int Mc();

    public abstract void Mc(int i);

    public abstract void Mc(String str);

    public abstract com.bytedance.sdk.openadsdk.core.BSW.JG.pA Mx();

    public abstract void Og(double d);

    public abstract void Og(int i);

    public abstract void Og(long j);

    public abstract void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og);

    public abstract void Og(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar);

    public abstract void Og(DX dx);

    public abstract void Og(JSONObject jSONObject);

    public abstract void Og(boolean z);

    public abstract int PKZ();

    public abstract JSONObject PU();

    public abstract List<String> PV();

    public abstract List<FilterWord> QI();

    public abstract com.bykv.vk.openvk.pA.pA.pA.KZx.Og Qd();

    public abstract long Qj();

    public abstract int RS();

    public abstract String SD();

    public abstract void SD(int i);

    public abstract void SD(String str);

    public abstract void SD(boolean z);

    public abstract oX SGo();

    public abstract void SGo(int i);

    public abstract void SGo(String str);

    public abstract void SGo(boolean z);

    public abstract boolean SRe();

    public abstract String SXO();

    public abstract String Sd();

    public abstract void Sd(int i);

    public abstract void Sd(String str);

    public abstract int Sn();

    public abstract void Sn(int i);

    public abstract void Sn(String str);

    public abstract void SzT(int i);

    public abstract boolean SzT();

    public abstract int TV();

    public abstract String TV(String str);

    public abstract void TV(int i);

    public abstract int TX();

    public abstract void TX(int i);

    public abstract void TX(String str);

    public abstract com.bykv.vk.openvk.pA.pA.pA.KZx.Og Tsy();

    public abstract boolean Uz();

    public abstract int Vgu();

    public abstract void Vgu(int i);

    public abstract void WQf(int i);

    public abstract void WQf(String str);

    public abstract boolean WQf();

    public abstract ZZv WV();

    public abstract void WV(int i);

    public abstract void WV(String str);

    public abstract int Wf();

    public abstract KZx Wo();

    public abstract int Wx();

    public abstract void Wx(int i);

    public abstract void Wx(String str);

    public abstract int XT();

    public abstract void XT(int i);

    public abstract void XT(String str);

    public abstract void Xe();

    public abstract String Xj();

    public abstract com.bytedance.sdk.openadsdk.BF.pA.Og Yg();

    public abstract DX YkC();

    public abstract com.bytedance.sdk.openadsdk.core.BSW.JG.pA ZDE();

    public abstract qmB ZF();

    public abstract String ZL();

    public abstract String ZQ();

    public abstract void ZZv(int i);

    public abstract void ZZv(JSONObject jSONObject);

    public abstract void ZZv(boolean z);

    public abstract boolean ZZv();

    public abstract boolean Zc();

    public abstract int aBv();

    public abstract void aBv(int i);

    public abstract void aBv(String str);

    public abstract String aOS();

    public abstract boolean agB();

    public abstract Wx aj();

    public abstract boolean bA();

    public abstract String bU();

    public abstract boolean boc();

    public abstract List<String> cFQ();

    public abstract String dC();

    public abstract com.bytedance.sdk.openadsdk.core.WV.pA dGZ();

    public abstract BF dL();

    public abstract int dmv();

    public abstract int du();

    public abstract void du(int i);

    public abstract void du(String str);

    public abstract int dz();

    public abstract boolean eD();

    public abstract int eG();

    public abstract void eG(int i);

    public abstract void eG(String str);

    public abstract boolean eUc();

    public abstract String ewI();

    public abstract DX fJy();

    public abstract boolean fN();

    public abstract boolean fS();

    public abstract JSONObject fg();

    public abstract int fhy();

    public abstract String fw();

    public abstract void gbA(int i);

    public abstract boolean gbA();

    public abstract String ged();

    public abstract boolean gl();

    public abstract int guZ();

    public abstract String gy();

    public abstract void hP();

    public abstract boolean iC();

    public abstract String jK();

    public abstract JSONObject jO();

    public abstract boolean juv();

    public abstract boolean kK();

    public abstract boolean ka();

    public abstract Bzk lT();

    public abstract void lT(int i);

    public abstract boolean le();

    public abstract int lgT();

    public abstract List<String> lx();

    public abstract int mK();

    public abstract double mM();

    public abstract int mY();

    public abstract String nCO();

    public abstract int npn();

    public abstract WQf oX();

    public abstract void oX(int i);

    public abstract void oX(String str);

    public abstract void omh(int i);

    public abstract void omh(String str);

    public abstract void omh(boolean z);

    public abstract void pA(double d);

    public abstract void pA(float f);

    public abstract void pA(int i);

    public abstract void pA(int i, int i2);

    public abstract void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.Og og);

    public abstract void pA(AdSlot adSlot);

    public abstract void pA(com.bytedance.sdk.openadsdk.BF.pA.Og og);

    public abstract void pA(FilterWord filterWord);

    public abstract void pA(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar);

    public abstract void pA(com.bytedance.sdk.openadsdk.core.WV.pA pAVar);

    public abstract void pA(BF bf);

    public abstract void pA(BSW bsw);

    public abstract void pA(Bzk bzk);

    public abstract void pA(DX dx);

    public abstract void pA(KZx kZx);

    public abstract void pA(ML ml);

    public abstract void pA(WQf wQf);

    public abstract void pA(WV wv);

    public abstract void pA(Wx wx);

    public abstract void pA(XT xt);

    public abstract void pA(ZZv zZv);

    public abstract void pA(eG eGVar);

    public abstract void pA(oX oXVar);

    public abstract void pA(pA pAVar);

    public abstract void pA(Map<String, Object> map);

    public abstract void pA(boolean z);

    public abstract boolean qH();

    public abstract boolean qK();

    public abstract boolean qQU();

    public abstract String qmB();

    public abstract void qmB(int i);

    public abstract AdSlot rB();

    public abstract void rB(int i);

    public abstract boolean rX();

    public abstract boolean rjD();

    public abstract String roi();

    public abstract void roi(int i);

    public abstract void roi(String str);

    public abstract int rtW();

    public abstract int sPI();

    public abstract boolean sk();

    public abstract float slz();

    public abstract String tM();

    public abstract Map<String, Object> tZW();

    public abstract String tpV();

    public abstract boolean uQ();

    public abstract void uhO();

    public abstract String vA();

    public abstract int vON();

    public abstract int vZF();

    public abstract void vZF(int i);

    public abstract void vZF(String str);

    public abstract int vkV();

    public abstract boolean xkc();

    public abstract boolean xkn();

    public abstract String xt();

    public abstract int xy();

    public abstract void xy(int i);

    public abstract int yFO();

    public abstract void yFO(int i);

    public abstract void yFO(String str);

    public abstract boolean zi();

    public yFO() {
        this.pA = false;
        this.pA = com.bytedance.sdk.openadsdk.vZF.pA.pA("is_new_playable", false);
    }

    public boolean pA() {
        int iABv = aBv();
        return (BF() != 2 || iABv == 5 || iABv == 6 || iABv == 19 || iABv == 12) ? false : true;
    }

    public long Og() {
        return this.SGo;
    }

    public void pA(long j) {
        this.SGo = j;
    }

    public static boolean pA(yFO yfo, boolean z, boolean z2, boolean z3, boolean z4) {
        if (pA(yfo) || z4 || yfo == null || yfo.Bf() == null || TextUtils.isEmpty(yfo.Bf().WV())) {
            return false;
        }
        if (KZx(yfo)) {
            return z3;
        }
        return (yfo.Bf() == null || yfo.Bf().pA() != 1) ? z : z2;
    }

    public static boolean pA(yFO yfo) {
        return (yfo == null || yfo.Bf() == null || yfo.Bf().ZZv() != 1) ? false : true;
    }

    public static boolean Og(yFO yfo) {
        return (pA(yfo) || KZx(yfo)) ? false : true;
    }

    public static boolean KZx(yFO yfo) {
        return (yfo == null || yfo.Bf() == null || yfo.Bf().ZZv() != 7 || WQf.SD(yfo)) ? false : true;
    }

    public static boolean ZZv(yFO yfo) {
        return (yfo == null || yfo.Bf() == null || yfo.Bf().pA() != 1) ? false : true;
    }

    public static boolean ML(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        int iRS = yfo.RS();
        return yfo.rjD() || iRS == 5 || iRS == 15 || iRS == 50;
    }

    public static com.bytedance.sdk.openadsdk.core.Wx.pA.Og pA(String str, yFO yfo) {
        yfo.qmB(0);
        int iPKZ = yfo.PKZ();
        int i = 3;
        if (iPKZ == 3) {
            i = 4;
        } else if (iPKZ == 7) {
            i = 1;
        } else if (iPKZ == 8) {
            i = 2;
        }
        return new com.bytedance.sdk.openadsdk.core.Wx.pA.Og(str, yfo.Tsy(), yfo.Qd(), yfo.FK(), yfo.mY(), i);
    }

    public static long pA(String str) {
        return JG(KZx(str));
    }

    private static long JG(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static double Og(String str) {
        return SD(KZx(str));
    }

    private static double SD(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static JSONObject KZx(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return PangleNetworkBridge.jsonObjectInit(str);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", e.getMessage());
            }
        }
        return null;
    }

    public static int ZZv(String str) {
        return pA(KZx(str));
    }

    public static int pA(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static yFO KZx() {
        return new TV();
    }

    public boolean omh() {
        return (TextUtils.isEmpty(JG()) || TextUtils.isEmpty(SD())) ? false : true;
    }

    public static String pA(Context context, yFO yfo) {
        if (context == null || yfo == null || !((yfo.PKZ() == 8 || yfo.PKZ() == 7) && yfo.gbA())) {
            return null;
        }
        String strOg = Og(context, yfo);
        if (TextUtils.isEmpty(strOg) || com.bytedance.sdk.openadsdk.core.act.pA.pA() != 1) {
            return null;
        }
        return strOg;
    }

    public static String Og(Context context, yFO yfo) {
        if (context != null && yfo != null) {
            try {
                if (yfo.JBA() == 8 || yfo.BSW().pA()) {
                    String strPA = com.bytedance.sdk.openadsdk.core.act.pA.pA(context);
                    if (TextUtils.isEmpty(strPA)) {
                        return null;
                    }
                    return strPA;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", th.getMessage());
            }
        }
        return null;
    }

    public static boolean JG(yFO yfo) {
        Object obj;
        if (yfo == null) {
            return false;
        }
        try {
            Map<String, Object> mapTZW = yfo.tZW();
            return (mapTZW == null || (obj = mapTZW.get(TTAdConstant.SDK_BIDDING_TYPE)) == null || 2 != Integer.parseInt(obj.toString())) ? false : true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("MaterialMeta", th.getMessage());
            return false;
        }
    }

    public static class pA {
        private String BSW;
        private String Bzk;
        private String JG;
        private String KZx;
        private String ML;
        private String Og;
        private String SD;
        private String SGo;
        private String Sn;
        private String WV;
        private String Wx;
        private String ZZv;
        private List<Integer> omh;
        private String pA;

        public static com.bytedance.sdk.component.adexpress.pA.KZx.ZZv pA(pA pAVar, String str) {
            return com.bytedance.sdk.component.adexpress.pA.KZx.ZZv.pA().pA(pAVar.JG()).Og(pAVar.SD()).KZx(pAVar.omh()).ZZv(pAVar.Bzk()).ML(pAVar.ML()).JG(str);
        }

        public static com.bytedance.sdk.openadsdk.core.BSW.JG.pA Og(pA pAVar, String str) {
            return new com.bytedance.sdk.openadsdk.core.BSW.JG.pA().pA(pAVar.JG()).Og(pAVar.oX()).KZx(pAVar.DX()).ZZv(pAVar.aBv()).ML(str);
        }

        public List<Integer> KZx() {
            return this.omh;
        }

        public void pA(List<Integer> list) {
            this.omh = list;
        }

        public String ZZv() {
            return this.Bzk;
        }

        public void pA(String str) {
            this.Bzk = str;
        }

        public String ML() {
            return this.JG;
        }

        public void Og(String str) {
            this.JG = str;
        }

        public String JG() {
            return this.pA;
        }

        public void KZx(String str) {
            this.pA = str;
        }

        public String SD() {
            return this.Og;
        }

        public void ZZv(String str) {
            this.Og = str;
        }

        public String omh() {
            return this.KZx;
        }

        public void ML(String str) {
            this.KZx = str;
        }

        public String Bzk() {
            return this.ZZv;
        }

        public void JG(String str) {
            this.ZZv = str;
        }

        public String SGo() {
            return this.ML;
        }

        public void SD(String str) {
            this.ML = str;
        }

        public String BSW() {
            return this.SD;
        }

        public void omh(String str) {
            this.SD = str;
        }

        public String WV() {
            return this.BSW;
        }

        public void Bzk(String str) {
            this.BSW = str;
        }

        public String Wx() {
            return this.SGo;
        }

        public void SGo(String str) {
            this.SGo = str;
        }

        public boolean Sn() {
            return !TextUtils.isEmpty(this.SGo) && this.SGo.equals("v3");
        }

        public String DX() {
            return this.WV;
        }

        public void BSW(String str) {
            this.WV = str;
        }

        public String oX() {
            return this.Wx;
        }

        public void WV(String str) {
            this.Wx = str;
        }

        public String aBv() {
            return this.Sn;
        }

        public void Wx(String str) {
            this.Sn = str;
        }
    }
}
