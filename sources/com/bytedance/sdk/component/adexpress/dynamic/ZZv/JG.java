package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.b9;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JG {
    private boolean BDQ;
    private String BF;
    private double BSW;
    private double Bf;
    private String Bpk;
    private float Bzk;
    private int CIG;
    private String DX;
    private boolean FGT;
    private int FK;
    private int FQ;
    private int Gag;
    private int GbR;
    private int Gx;
    private long HMH = -1;
    private int HSv;
    private String IG;
    private boolean IIF;
    private int Itl;
    private boolean JBA;
    private float JG;
    private float KZx;
    private int Ld;
    private int Lm;
    private boolean ML;
    private double Mc;
    private float Og;
    private int PU;
    private String PV;
    private boolean QI;
    private String Qd;
    private int Qj;
    private String RS;
    private float SD;
    private float SGo;
    private boolean SXO;
    private String Sd;
    private String Sn;
    private int SzT;
    private boolean TV;
    private String TX;
    private int Tsy;
    private int Uz;
    private int Vgu;
    private String WQf;
    private double WV;
    private int Wo;
    private String Wx;
    private String XT;
    private JSONObject Xj;
    private boolean YkC;
    private float ZZv;
    private String aBv;
    private int agB;
    private boolean aj;
    private int bA;
    private int bU;
    private JSONObject cFQ;
    private boolean dC;
    private String dGZ;
    private int dmv;
    private int du;
    private int eG;
    private String fJy;
    private boolean fN;
    private String fg;
    private int fw;
    private boolean gbA;
    private JSONObject guZ;
    private int gy;
    private boolean jO;
    private int ka;
    private String lT;
    private String lgT;
    private int lx;
    private double mK;
    private int mY;
    private int nCO;
    private JSONObject npn;
    private String oX;
    private float omh;
    private float pA;
    private boolean qQU;
    private String qmB;
    private String rB;
    private int rjD;
    private double roi;
    private int rtW;
    private String sPI;
    private int sk;
    private int slz;
    private String tM;
    private List<pA> tZW;
    private boolean uQ;
    private int uhO;
    private boolean vA;
    private String vZF;
    private int vkV;
    private boolean xkn;
    private String xt;
    private String xy;
    private String yFO;

    public static JG pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JG jg = new JG();
        jg.Og(jSONObject.optString(Ad.AD_TYPE, "embeded"));
        jg.DX(jSONObject.optString("clickArea", Reporting.Key.CREATIVE));
        jg.oX(jSONObject.optString("clickTigger", "click"));
        jg.KZx(jSONObject.optString("fontFamily", "PingFangSC"));
        jg.ZZv(jSONObject.optString("textAlign", "left"));
        jg.ML(jSONObject.optString("color", "#999999"));
        jg.JG(jSONObject.optString("bgColor", b9.h.T));
        jg.SD(jSONObject.optString("bgImgUrl", ""));
        jg.eG(jSONObject.optString("bgImgData", ""));
        jg.omh(jSONObject.optString("borderColor", "#000000"));
        jg.Bzk(jSONObject.optString("borderStyle", "solid"));
        jg.SGo(jSONObject.optString("heightMode", "auto"));
        jg.BSW(jSONObject.optString("widthMode", "fixed"));
        jg.WV(jSONObject.optString("interactText", ""));
        jg.KZx(jSONObject.optBoolean("isShowBgControl", false));
        jg.Wx(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            jg.SD(jSONObjectOptJSONObject.optInt("translateY", 0));
            jg.omh(jSONObjectOptJSONObject.optInt("translateX", 0));
            jg.ZZv(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            jg.ML(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        jg.Sn(jSONObject.optString("interactType", ""));
        jg.ML(jSONObject.optInt("interactSlideDirection", -1));
        jg.aBv(jSONObject.optString("justifyHorizontal", "space-around"));
        jg.XT(jSONObject.optString("justifyVertical", "flex-start"));
        jg.Og(jSONObject.optDouble("timingStart"));
        jg.KZx(jSONObject.optDouble("timingEnd"));
        jg.ZZv((float) jSONObject.optDouble("width", 0.0d));
        jg.KZx((float) jSONObject.optDouble("height", 0.0d));
        jg.pA((float) jSONObject.optDouble("borderRadius", 0.0d));
        jg.Og((float) jSONObject.optDouble("borderSize", 0.0d));
        jg.Og(jSONObject.optBoolean("interactValidate", false));
        jg.Bzk((float) jSONObject.optDouble("fontSize", 0.0d));
        jg.ML((float) jSONObject.optDouble("paddingBottom", 0.0d));
        jg.JG((float) jSONObject.optDouble("paddingLeft", 0.0d));
        jg.SD((float) jSONObject.optDouble("paddingRight", 0.0d));
        jg.omh((float) jSONObject.optDouble("paddingTop", 0.0d));
        jg.ZZv(jSONObject.optBoolean("lineFeed", false));
        jg.Bzk(jSONObject.optInt("lineCount", 0));
        jg.JG(jSONObject.optDouble("lineHeight", 1.2d));
        jg.Sn(jSONObject.optInt("letterSpacing", 0));
        jg.ML(jSONObject.optBoolean("isDataFixed", false));
        jg.DX(jSONObject.optInt("fontWeight"));
        jg.JG(jSONObject.optBoolean("lineLimit"));
        jg.oX(jSONObject.optInt(b9.h.L));
        jg.yFO(jSONObject.optString("align"));
        jg.SD(jSONObject.optBoolean("useLeft"));
        jg.omh(jSONObject.optBoolean("useRight"));
        jg.Bzk(jSONObject.optBoolean("useTop"));
        jg.SGo(jSONObject.optBoolean("useBottom"));
        jg.vZF(jSONObject.optString("data"));
        jg.Og(jSONObject.optJSONObject("i18n"));
        jg.WV(jSONObject.optInt("marginLeft"));
        jg.Wx(jSONObject.optInt("marginRight"));
        jg.SGo(jSONObject.optInt("marginTop"));
        jg.BSW(jSONObject.optInt("marginBottom"));
        jg.aBv(jSONObject.optInt("tagMaxCount"));
        jg.BSW(jSONObject.optBoolean("allowTextFlow"));
        jg.XT(jSONObject.optInt("textFlowType"));
        jg.yFO(jSONObject.optInt("textFlowDuration"));
        jg.vZF(jSONObject.optInt("left"));
        jg.Sd(jSONObject.optInt("right"));
        jg.TX(jSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY));
        jg.BF(jSONObject.optInt("bottom"));
        jg.Sd(jSONObject.optString("alignItems", "flex-start"));
        jg.TX(jSONObject.optString("direction", ""));
        jg.pA(jSONObject.optBoolean("loop", false));
        jg.WQf(jSONObject.optInt("zIndex"));
        jg.Mc(jSONObject.optInt("interactVisibleTime"));
        jg.TV(jSONObject.optInt("interactHiddenTime"));
        jg.Wx(jSONObject.optBoolean("interactEnableMask"));
        jg.Sn(jSONObject.optBoolean("interactWontHide"));
        jg.pA(jSONObject.optString("bgGradient"));
        jg.lT(jSONObject.optInt("areaType"));
        jg.rB(jSONObject.optInt("interactSlideThreshold", 0));
        jg.gbA(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.ZZv.Og() ? 0 : 120));
        jg.XT(jSONObject.optBoolean("openPlayableLandingPage", false));
        jg.KZx(jSONObject.optJSONObject("video"));
        jg.ZZv(jSONObject.optJSONObject("image"));
        jg.xy(jSONObject.optInt("borderShadowExtent"));
        jg.DX(jSONObject.optBoolean("bgGauseBlur"));
        jg.qmB(jSONObject.optInt("bgGauseBlurRadius"));
        jg.oX(jSONObject.optBoolean("showTimeProgress", false));
        jg.aBv(jSONObject.optBoolean("showPlayButton", false));
        jg.pA(jSONObject.optDouble("bgColorCg", 0.0d));
        jg.JG(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        jg.Og(jSONObject.optInt("borderTopLeftRadius", 0));
        jg.pA(jSONObject.optInt("borderTopRightRadius", 0));
        jg.ZZv(jSONObject.optInt("borderBottomLeftRadius", 0));
        jg.KZx(jSONObject.optInt("borderBottomRightRadius", 0));
        jg.ML(jSONObject.optJSONObject("interactI18n"));
        jg.WQf(jSONObject.optString("imageObjectFit"));
        jg.TV(jSONObject.optString("interactTitle"));
        jg.IG(jSONObject.optInt("interactTextPositionTop"));
        jg.BF(jSONObject.optString("imageLottieTosPath"));
        jg.WV(jSONObject.optBoolean("animationsLoop"));
        jg.du(jSONObject.optInt("lottieAppNameMaxLength"));
        jg.roi(jSONObject.optInt("lottieAdDescMaxLength"));
        jg.eG(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    pA pAVar = new pA();
                    pAVar.KZx(jSONObject2.optString("animationType"));
                    pAVar.pA(jSONObject2.optDouble("animationDuration"));
                    pAVar.Og(jSONObject2.optDouble("animationScaleX"));
                    pAVar.KZx(jSONObject2.optDouble("animationScaleY"));
                    pAVar.ZZv(jSONObject2.optString("animationTimeFunction"));
                    pAVar.ZZv(jSONObject2.optDouble("animationDelay"));
                    pAVar.JG(jSONObject2.optInt("animationIterationCount"));
                    pAVar.ML(jSONObject2.optString("animationDirection"));
                    pAVar.ML(jSONObject2.optDouble("animationInterval"));
                    pAVar.pA(jSONObject2.optInt("animationBorderWidth"));
                    pAVar.pA(jSONObject2.optLong("key"));
                    pAVar.Og(jSONObject2.optInt("animationEffectWidth"));
                    pAVar.KZx(jSONObject2.optInt("animationSwing", 1));
                    pAVar.ZZv(jSONObject2.optInt("animationTranslateX"));
                    pAVar.ML(jSONObject2.optInt("animationTranslateY"));
                    pAVar.Og(jSONObject2.optString("animationRippleBackgroundColor"));
                    pAVar.pA(jSONObject2.optString("animationScaleDirection"));
                    pAVar.SD(jSONObject2.optInt("animationFadeStart"));
                    pAVar.omh(jSONObject2.optInt("animationFadeEnd"));
                    pAVar.JG(jSONObject2.optString("animationFillMode"));
                    pAVar.Bzk(jSONObject2.optInt("animationBounceHeight"));
                    if (jg.yFO() > 0.0d) {
                        pAVar.ZZv(pAVar.Sn() + jg.yFO());
                    }
                    arrayList.add(pAVar);
                }
                jg.pA(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                jg.du(jSONObject.optString("triggerSlideDirection", "0"));
                jg.pA(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return jg;
    }

    public boolean pA() {
        return this.QI;
    }

    public void pA(boolean z) {
        this.QI = z;
    }

    public int Og() {
        return this.PU;
    }

    public void pA(int i) {
        this.PU = i;
    }

    public int KZx() {
        return this.ka;
    }

    public void Og(int i) {
        this.ka = i;
    }

    public int ZZv() {
        return this.uhO;
    }

    public void KZx(int i) {
        this.uhO = i;
    }

    public int ML() {
        return this.bA;
    }

    public void ZZv(int i) {
        this.bA = i;
    }

    public JSONObject JG() {
        return this.Xj;
    }

    public int SD() {
        return this.rjD;
    }

    public void ML(int i) {
        this.rjD = i;
    }

    public double omh() {
        return this.mK;
    }

    public void pA(double d) {
        this.mK = d;
    }

    public int Bzk() {
        return this.vkV;
    }

    public void JG(int i) {
        this.vkV = i;
    }

    public String SGo() {
        return this.fg;
    }

    public void pA(String str) {
        this.fg = str;
    }

    public float BSW() {
        return this.pA;
    }

    public void pA(float f) {
        this.pA = f;
    }

    public float WV() {
        return this.Og;
    }

    public void Og(float f) {
        this.Og = f;
    }

    public void KZx(float f) {
        this.KZx = f;
    }

    public void ZZv(float f) {
        this.ZZv = f;
    }

    public boolean Wx() {
        return this.ML;
    }

    public void Og(boolean z) {
        this.ML = z;
    }

    public float Sn() {
        return this.JG;
    }

    public void ML(float f) {
        this.JG = f;
    }

    public float DX() {
        return this.SD;
    }

    public void JG(float f) {
        this.SD = f;
    }

    public float oX() {
        return this.omh;
    }

    public void SD(float f) {
        this.omh = f;
    }

    public float aBv() {
        return this.Bzk;
    }

    public void omh(float f) {
        this.Bzk = f;
    }

    public float XT() {
        return this.SGo;
    }

    public void Bzk(float f) {
        this.SGo = f;
    }

    public double yFO() {
        return this.BSW;
    }

    public void Og(double d) {
        this.BSW = d;
    }

    public double vZF() {
        return this.WV;
    }

    public void KZx(double d) {
        this.WV = d;
    }

    public void Og(String str) {
        this.Wx = str;
    }

    public void KZx(String str) {
        this.Sn = str;
    }

    public String Sd() {
        return this.DX;
    }

    public void ZZv(String str) {
        this.DX = str;
    }

    public String TX() {
        return this.oX;
    }

    public void ML(String str) {
        this.oX = str;
    }

    public String BF() {
        return this.aBv;
    }

    public void JG(String str) {
        this.aBv = str;
    }

    public void SD(String str) {
        this.XT = str;
    }

    public String WQf() {
        return this.XT;
    }

    private void eG(String str) {
        this.Bpk = str;
    }

    public String TV() {
        return this.Bpk;
    }

    public String du() {
        return this.yFO;
    }

    public void omh(String str) {
        this.yFO = str;
    }

    public void Bzk(String str) {
        this.vZF = str;
    }

    public String eG() {
        return this.Sd;
    }

    public void SGo(String str) {
        this.Sd = str;
    }

    public String roi() {
        return this.TX;
    }

    public void BSW(String str) {
        this.TX = str;
    }

    public String Mc() {
        return this.BF;
    }

    public void WV(String str) {
        this.BF = str;
    }

    public String IG() {
        return this.WQf;
    }

    public void Wx(String str) {
        this.WQf = str;
    }

    public boolean lT() {
        return this.TV;
    }

    public void KZx(boolean z) {
        this.TV = z;
    }

    public int rB() {
        return this.du;
    }

    public void SD(int i) {
        this.du = i;
    }

    public int xy() {
        return this.eG;
    }

    public void omh(int i) {
        this.eG = i;
    }

    public double qmB() {
        return this.roi;
    }

    public void ZZv(double d) {
        this.roi = d;
    }

    public double gbA() {
        return this.Mc;
    }

    public void ML(double d) {
        this.Mc = d;
    }

    public String Vgu() {
        return this.IG;
    }

    public void Sn(String str) {
        this.IG = str;
    }

    public String CIG() {
        return this.lT;
    }

    public void DX(String str) {
        this.lT = str;
    }

    public String SzT() {
        return this.rB;
    }

    public void oX(String str) {
        this.rB = str;
    }

    public String FQ() {
        return this.xy;
    }

    public void aBv(String str) {
        this.xy = str;
    }

    public String Gx() {
        return this.qmB;
    }

    public void XT(String str) {
        this.qmB = str;
    }

    public boolean Bf() {
        return this.gbA;
    }

    public void ZZv(boolean z) {
        this.gbA = z;
    }

    public void Bzk(int i) {
        this.Vgu = i;
    }

    public int HSv() {
        return this.Vgu;
    }

    public int JBA() {
        return this.CIG;
    }

    public void SGo(int i) {
        this.CIG = i;
    }

    public int agB() {
        return this.SzT;
    }

    public void BSW(int i) {
        this.SzT = i;
    }

    public int fN() {
        return this.FQ;
    }

    public void WV(int i) {
        this.FQ = i;
    }

    public int dmv() {
        return this.Gx;
    }

    public void Wx(int i) {
        this.Gx = i;
    }

    public double fJy() {
        return this.Bf;
    }

    public void JG(double d) {
        this.Bf = d;
    }

    public int YkC() {
        return this.HSv;
    }

    public void Sn(int i) {
        this.HSv = i;
    }

    public boolean dC() {
        return this.JBA;
    }

    public void ML(boolean z) {
        this.JBA = z;
    }

    public int IIF() {
        return this.agB;
    }

    public void DX(int i) {
        this.agB = i;
    }

    public boolean vA() {
        return this.fN;
    }

    public void JG(boolean z) {
        this.fN = z;
    }

    public int PV() {
        return this.dmv;
    }

    public void oX(int i) {
        this.dmv = i;
    }

    public String cFQ() {
        return this.fJy;
    }

    public void yFO(String str) {
        this.fJy = str;
    }

    public boolean lx() {
        return this.YkC;
    }

    public void SD(boolean z) {
        this.YkC = z;
    }

    public boolean SXO() {
        return this.dC;
    }

    public void omh(boolean z) {
        this.dC = z;
    }

    public boolean fw() {
        return this.IIF;
    }

    public void Bzk(boolean z) {
        this.IIF = z;
    }

    public boolean gy() {
        return this.vA;
    }

    public void SGo(boolean z) {
        this.vA = z;
    }

    public String nCO() {
        return this.PV;
    }

    public void vZF(String str) {
        this.PV = str;
    }

    public void Og(JSONObject jSONObject) {
        this.cFQ = jSONObject;
    }

    public JSONObject bU() {
        return this.cFQ;
    }

    public int Wo() {
        return this.lx;
    }

    public void aBv(int i) {
        this.lx = i;
    }

    public boolean Itl() {
        return this.SXO;
    }

    public void BSW(boolean z) {
        this.SXO = z;
    }

    public int tM() {
        return this.fw;
    }

    public void XT(int i) {
        this.fw = i;
    }

    public int RS() {
        return this.gy;
    }

    public void yFO(int i) {
        this.gy = i;
    }

    public int QI() {
        return this.nCO;
    }

    public void vZF(int i) {
        this.nCO = i;
    }

    public int Gag() {
        return this.bU;
    }

    public void Sd(int i) {
        this.bU = i;
    }

    public int Qj() {
        return this.Wo;
    }

    public void TX(int i) {
        this.Wo = i;
    }

    public int sk() {
        return this.Itl;
    }

    public void BF(int i) {
        this.Itl = i;
    }

    public String tZW() {
        return this.tM;
    }

    public void Sd(String str) {
        this.tM = str;
    }

    public String Ld() {
        return this.RS;
    }

    public void TX(String str) {
        this.RS = str;
    }

    public int rtW() {
        return this.Gag;
    }

    public void WQf(int i) {
        this.Gag = i;
    }

    public int slz() {
        return this.Qj;
    }

    public void TV(int i) {
        this.Qj = i;
    }

    public String Uz() {
        return this.sPI;
    }

    public void BF(String str) {
        this.sPI = str;
    }

    public boolean uQ() {
        return this.BDQ;
    }

    public void WV(boolean z) {
        this.BDQ = z;
    }

    public int jO() {
        return this.FK;
    }

    public void du(int i) {
        this.FK = i;
    }

    public int FGT() {
        return this.mY;
    }

    public void eG(int i) {
        this.mY = i;
    }

    public int Lm() {
        return this.Tsy;
    }

    public void roi(int i) {
        this.Tsy = i;
    }

    public boolean xkn() {
        return this.aj;
    }

    public void Wx(boolean z) {
        this.aj = z;
    }

    public int mK() {
        return this.sk;
    }

    public void Mc(int i) {
        this.sk = i;
    }

    public void Sn(boolean z) {
        this.qQU = z;
    }

    public boolean guZ() {
        return this.qQU;
    }

    public void WQf(String str) {
        this.lgT = str;
    }

    public String npn() {
        return this.lgT;
    }

    public void IG(int i) {
        this.GbR = i;
    }

    public int rjD() {
        return this.GbR;
    }

    public List<pA> dGZ() {
        return this.tZW;
    }

    public int qQU() {
        List<pA> list = this.tZW;
        if (list == null) {
            return 0;
        }
        for (pA pAVar : list) {
            if ("translate".equals(pAVar.Bzk()) && pAVar.SD() < 0) {
                return -pAVar.SD();
            }
        }
        return 0;
    }

    public void pA(List<pA> list) {
        this.tZW = list;
    }

    public int Xj() {
        return this.Ld;
    }

    public void lT(int i) {
        this.Ld = i;
    }

    public int vkV() {
        return this.rtW;
    }

    public void rB(int i) {
        this.rtW = i;
    }

    public int PU() {
        return this.slz;
    }

    public void xy(int i) {
        this.slz = i;
    }

    public boolean ka() {
        return this.uQ;
    }

    public void DX(boolean z) {
        this.uQ = z;
    }

    public int uhO() {
        return this.Uz;
    }

    public void qmB(int i) {
        this.Uz = i;
    }

    public boolean bA() {
        return this.jO;
    }

    public void oX(boolean z) {
        this.jO = z;
    }

    public boolean lgT() {
        return this.FGT;
    }

    public void aBv(boolean z) {
        this.FGT = z;
    }

    public int GbR() {
        return this.Lm;
    }

    public void gbA(int i) {
        this.Lm = i;
    }

    public String aj() {
        return this.dGZ;
    }

    public boolean sPI() {
        return this.xkn;
    }

    public void XT(boolean z) {
        this.xkn = z;
    }

    public void KZx(JSONObject jSONObject) {
        this.guZ = jSONObject;
    }

    public JSONObject BDQ() {
        return this.npn;
    }

    public void ZZv(JSONObject jSONObject) {
        this.npn = jSONObject;
    }

    public void ML(JSONObject jSONObject) {
        this.Xj = jSONObject;
    }

    public String FK() {
        return this.Qd;
    }

    public void TV(String str) {
        this.Qd = str;
    }

    public void mY() {
        pA(this, this.guZ);
    }

    public void Tsy() {
        pA(this, this.npn);
    }

    public String Qd() {
        return this.xt;
    }

    public void du(String str) {
        this.xt = str;
    }

    public long xt() {
        return this.HMH;
    }

    public void pA(long j) {
        this.HMH = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void pA(JG jg, JSONObject jSONObject) {
        if (jg == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals(Ad.AD_TYPE)) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        b = Ascii.VT;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b = Ascii.FF;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        b = Ascii.CR;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = Ascii.SO;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = Ascii.SI;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = Ascii.DLE;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = Ascii.DC2;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = Ascii.DC4;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = Ascii.NAK;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = Ascii.SYN;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        b = Ascii.ETB;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = Ascii.CAN;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = Ascii.EM;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = Ascii.SUB;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = Ascii.ESC;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = Ascii.FS;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = Ascii.GS;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = Ascii.RS;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = Ascii.US;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 32;
                    }
                    break;
                case 115029:
                    if (next.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                        b = 33;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 34;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b = 35;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 36;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 37;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 38;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 39;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b = 40;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b = 41;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 42;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 43;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 44;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 45;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        b = 46;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 47;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 48;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 49;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 50;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 51;
                    }
                    break;
                case 747804969:
                    if (next.equals(b9.h.L)) {
                        b = 52;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 53;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 54;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 55;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 56;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 57;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 58;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 59;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = 60;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = 62;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = 63;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 65;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 66;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jg.KZx(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    jg.DX(jSONObject.optString(next));
                    break;
                case 2:
                    jg.du(jSONObject.optString(next));
                    break;
                case 3:
                    jg.SD(jSONObject.optString(next));
                    break;
                case 4:
                    jg.Bzk(jSONObject.optInt(next));
                    break;
                case 5:
                    jg.XT(jSONObject.optBoolean(next));
                    break;
                case 6:
                    jg.JG(jSONObject.optBoolean(next));
                    break;
                case 7:
                    jg.Wx(jSONObject.optString(next));
                    break;
                case 8:
                    jg.JG((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    jg.Og(jSONObject.optString(next));
                    break;
                case 10:
                    jg.BF(jSONObject.optInt(next));
                    break;
                case 11:
                    jg.KZx(jSONObject.optString(next));
                    break;
                case 12:
                    jg.KZx((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    jg.ZZv(jSONObject.optString(next));
                    break;
                case 14:
                    jg.Sd(jSONObject.optString(next));
                    break;
                case 15:
                    jg.Og(jSONObject.optBoolean(next));
                    break;
                case 16:
                    jg.SGo(jSONObject.optInt(next));
                    break;
                case 17:
                    jg.SGo(jSONObject.optBoolean(next));
                    break;
                case 18:
                    jg.pA(jSONObject.optLong(next));
                    break;
                case 19:
                    jg.TX(jSONObject.optString(next));
                    break;
                case 20:
                    jg.aBv(jSONObject.optInt(next));
                    break;
                case 21:
                    jg.TV(jSONObject.optInt(next));
                    break;
                case 22:
                    jg.Bzk(jSONObject.optBoolean(next));
                    break;
                case 23:
                    jg.DX(jSONObject.optInt(next));
                    break;
                case 24:
                    jg.WQf(jSONObject.optInt(next));
                    break;
                case 25:
                    jg.Og(jSONObject.optDouble(next));
                    break;
                case 26:
                    jg.JG(jSONObject.optDouble(next));
                    break;
                case 27:
                    jg.yFO(jSONObject.optInt(next));
                    break;
                case 28:
                    jg.omh(jSONObject.optBoolean(next));
                    break;
                case 29:
                    jg.BSW(jSONObject.optInt(next));
                    break;
                case 30:
                    jg.JG(jSONObject.optString(next));
                    break;
                case 31:
                    jg.SD(jSONObject.optBoolean(next));
                    break;
                case 32:
                    jg.BSW(jSONObject.optString(next));
                    break;
                case 33:
                    jg.TX(jSONObject.optInt(next));
                    break;
                case 34:
                    jg.vZF(jSONObject.optString(next));
                    break;
                case 35:
                    jg.vZF(jSONObject.optInt(next));
                    break;
                case 36:
                    jg.pA(jSONObject.optBoolean(next));
                    break;
                case 37:
                    jg.omh((float) jSONObject.optDouble(next));
                    break;
                case 38:
                    jg.yFO(jSONObject.optString(next));
                    break;
                case 39:
                    jg.ML(jSONObject.optString(next));
                    break;
                case 40:
                    jg.Sd(jSONObject.optInt(next));
                    break;
                case 41:
                    jg.ZZv((float) jSONObject.optDouble(next));
                    break;
                case 42:
                    jg.KZx(jSONObject.optDouble(next));
                    break;
                case 43:
                    jg.ML((float) jSONObject.optDouble(next));
                    break;
                case 44:
                    jg.BSW(jSONObject.optBoolean(next));
                    break;
                case 45:
                    jg.Sn(jSONObject.optBoolean(next));
                    break;
                case 46:
                    jg.Bzk((float) jSONObject.optDouble(next));
                    break;
                case 47:
                    jg.XT(jSONObject.optString(next));
                    break;
                case 48:
                    jg.Mc(jSONObject.optInt(next));
                    break;
                case 49:
                    jg.SD((float) jSONObject.optDouble(next));
                    break;
                case 50:
                    jg.omh(jSONObject.optString(next));
                    break;
                case 51:
                    jg.Bzk(jSONObject.optString(next));
                    break;
                case 52:
                    jg.oX(jSONObject.optInt(next));
                    break;
                case 53:
                    jg.ML(jSONObject.optBoolean(next));
                    break;
                case 54:
                    jg.Wx(jSONObject.optInt(next));
                    break;
                case 55:
                    jg.aBv(jSONObject.optString(next));
                    break;
                case 56:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jg.SD(jSONObjectOptJSONObject.optInt("translateY", 0));
                        jg.omh(jSONObjectOptJSONObject.optInt("translateX", 0));
                        jg.ZZv(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        jg.ML(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 57:
                    jg.ZZv(jSONObject.optBoolean(next));
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    jg.WV(jSONObject.optString(next));
                    break;
                case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    jg.Sn(jSONObject.optString(next));
                    break;
                case 60:
                    jg.pA((float) jSONObject.optDouble(next));
                    break;
                case 61:
                    jg.oX(jSONObject.optString(next));
                    break;
                case 62:
                    jg.SGo(jSONObject.optString(next));
                    break;
                case 63:
                    jg.XT(jSONObject.optInt(next));
                    break;
                case 64:
                    jg.Og((float) jSONObject.optDouble(next));
                    break;
                case 65:
                    jg.WV(jSONObject.optInt(next));
                    break;
                case 66:
                    jg.Sn(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
