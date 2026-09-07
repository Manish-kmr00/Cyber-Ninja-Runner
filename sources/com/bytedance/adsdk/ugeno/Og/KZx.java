package com.bytedance.adsdk.ugeno.Og;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.BSW;
import com.bytedance.adsdk.ugeno.core.DX;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.core.JG;
import com.bytedance.adsdk.ugeno.core.ML;
import com.bytedance.adsdk.ugeno.core.Og.ZZv;
import com.bytedance.adsdk.ugeno.core.SD;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import com.bytedance.adsdk.ugeno.core.Wx;
import com.bytedance.adsdk.ugeno.core.omh;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.b9;
import io.appmetrica.analytics.impl.J2;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class KZx<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.KZx, WV.Og, WV.pA {
    private String BDQ;
    protected float BF;
    protected ML.pA BSW;
    protected ImageView.ScaleType Bf;
    private boolean Bpk;
    protected pA<ViewGroup> Bzk;
    protected boolean CIG;
    protected String DX;
    private float EC;
    protected Wx FGT;
    private boolean FHA;
    private boolean FK;
    protected int FQ;
    protected float Gag;

    @Deprecated
    private ZZv GbR;
    protected String Gx;
    private boolean HMH;
    protected float HSv;
    protected float IG;
    protected boolean IIF;
    protected com.bytedance.adsdk.ugeno.pA.pA Itl;
    protected boolean JBA;
    protected JSONObject JG;
    private boolean KZx;
    private boolean Kj;
    protected float Ld;
    protected Map<Integer, SGo> Lm;
    protected Context ML;
    protected float Mc;
    private boolean Og;
    private JSONObject PKZ;
    private String PU;
    protected boolean PV;
    protected float QI;
    private boolean Qd;
    protected float Qj;
    protected float RS;
    protected JSONObject SD;
    protected pA<ViewGroup> SGo;
    protected int SXO;
    protected float Sd;
    protected String Sn;
    protected boolean SzT;
    protected boolean TV;
    protected float TX;
    private DX Tsy;
    protected float Uz;
    protected boolean Vgu;
    protected float WQf;
    protected omh WV;
    protected ViewGroup.LayoutParams Wo;
    protected boolean Wx;
    protected float XT;
    private boolean Xj;
    protected float YkC;
    private boolean ZZv;
    protected float aBv;
    protected boolean agB;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.Og.KZx.pA aj;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.Og.pA bA;
    protected boolean bU;
    protected boolean cFQ;
    protected float dC;
    private boolean dGZ;
    protected float dmv;
    protected boolean du;
    protected boolean eG;
    protected float fJy;
    protected float fN;
    private boolean fg;
    protected String fw;
    protected boolean gbA;
    private boolean guZ;
    protected int gy;
    protected WV jO;
    private com.bytedance.adsdk.ugeno.ZZv.pA.pA kK;
    private com.bytedance.adsdk.ugeno.core.pA ka;
    protected float lT;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.Og.Og lgT;
    protected float lx;
    protected com.bytedance.adsdk.ugeno.SD.pA.C0175pA mK;
    private boolean mY;
    protected float nCO;
    private boolean npn;
    protected float oX;
    protected T omh;
    private boolean pA;
    private boolean qQU;
    protected boolean qmB;
    protected float rB;
    private com.bytedance.adsdk.ugeno.ZZv.ML rX;
    private boolean rjD;
    protected boolean roi;
    protected float rtW;
    private SD sPI;
    protected float sk;
    protected float slz;
    protected float tM;
    protected float tZW;
    protected JG uQ;

    @Deprecated
    private com.bytedance.adsdk.ugeno.core.Og.ML uhO;
    protected boolean vA;
    protected float vZF;
    private GradientDrawable vkV;
    protected boolean xkn;
    private boolean xt;
    protected float xy;
    protected float yFO;

    protected void CIG() {
    }

    protected void SzT() {
    }

    public T ZZv() {
        return null;
    }

    public KZx(Context context) {
        this(context, null);
    }

    public KZx(Context context, pA<ViewGroup> pAVar) {
        this.oX = -2.0f;
        this.aBv = -2.0f;
        this.fw = "solid";
        this.gy = 0;
        this.bU = true;
        this.tM = 0.0f;
        this.RS = 0.0f;
        this.QI = 0.0f;
        this.Gag = 1.0f;
        this.Qj = 1.0f;
        this.sk = 1.0f;
        this.tZW = 0.0f;
        this.Ld = 0.0f;
        this.rtW = 0.0f;
        this.slz = 0.0f;
        this.Uz = 1.0f;
        this.qQU = true;
        this.fg = true;
        this.FHA = false;
        this.Kj = false;
        this.EC = 12.0f;
        this.ML = context;
        this.Bzk = pAVar;
        this.Lm = new HashMap();
        this.vkV = new GradientDrawable();
        this.omh = (T) ZZv();
    }

    public T Bzk() {
        return this.omh;
    }

    public void pA(JSONObject jSONObject) {
        this.SD = jSONObject;
        JSONObject jSONObject2 = this.JG;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        pA<ViewGroup> pAVar = this.Bzk;
        pA.C0174pA c0174pAKZx = pAVar instanceof pA ? pAVar.KZx() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(this.JG.optString(next), jSONObject);
            pA(next, strPA);
            if (c0174pAKZx != null) {
                c0174pAKZx.pA(this.ML, next, strPA);
            }
        }
        if (c0174pAKZx != null) {
            pA(c0174pAKZx.pA());
        }
        if (this.PKZ == null || this.SD == null) {
            return;
        }
        try {
            if (roi()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.PKZ);
                this.SD.put("xNode", jSONObject3);
                return;
            }
            this.SD.put("i18n", this.PKZ);
        } catch (JSONException unused) {
        }
    }

    public JSONObject SGo() {
        return this.SD;
    }

    public void Og() {
        BF();
        BSW();
        KZx(this.gy);
        pA();
        KZx();
        com.bytedance.adsdk.ugeno.ZZv.ML ml = this.rX;
        if (ml != null) {
            ml.pA();
            this.rX.Og();
            this.rX.KZx();
        }
        this.omh.setOnTouchListener(this);
        dmv();
        ViewGroup viewGroup = (ViewGroup) this.omh.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.qQU);
        }
        com.bytedance.adsdk.ugeno.pA.pA pAVar = this.Itl;
        if (pAVar != null) {
            pAVar.KZx();
        }
        if (this.jO == null || !Og(22)) {
            return;
        }
        this.jO.pA(this.Lm.get(22), this, this);
    }

    protected void BSW() {
        this.omh.setPadding((int) (this.gbA ? this.IG : this.Mc), (int) (this.CIG ? this.rB : this.Mc), (int) (this.Vgu ? this.lT : this.Mc), (int) (this.SzT ? this.xy : this.Mc));
    }

    private void pA() {
        if (this.pA) {
            this.omh.setTranslationX(this.RS);
        }
        if (this.Og) {
            this.omh.setTranslationY(this.QI);
        }
        if (this.KZx) {
            this.omh.setScaleX(this.Qj);
        }
        if (this.ZZv) {
            this.omh.setScaleY(this.sk);
        }
        if (this.guZ) {
            this.omh.setRotation(this.tZW);
        }
        if (this.npn) {
            this.omh.setRotationX(this.Ld);
        }
        if (this.rjD) {
            this.omh.setRotationY(this.rtW);
        }
        if (this.dGZ) {
            this.omh.setAlpha(this.Uz);
        }
        float f = this.slz;
        if (f != 0.0f) {
            this.omh.setRotation(f);
        }
    }

    public float WV() {
        return this.RS;
    }

    public float Wx() {
        return this.QI;
    }

    public float Sn() {
        return this.Qj;
    }

    public float DX() {
        return this.sk;
    }

    public float oX() {
        return this.Ld;
    }

    public float aBv() {
        return this.rtW;
    }

    public float XT() {
        return this.slz;
    }

    public float yFO() {
        return this.Uz;
    }

    public float vZF() {
        return this.fN;
    }

    @Deprecated
    private void KZx() {
        com.bytedance.adsdk.ugeno.core.Og.KZx kZxZZv;
        this.omh.setVisibility(this.gy);
        float f = this.slz;
        if (f != 0.0f) {
            this.omh.setRotation(f);
        }
        ML.pA pAVar = this.BSW;
        if (pAVar != null && TextUtils.isEmpty(pAVar.Og())) {
            this.omh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (KZx.this.uQ != null) {
                        boolean unused = KZx.this.fg;
                    }
                }
            });
        } else if (Og(1) && !this.FK) {
            this.omh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (KZx.this.jO == null || !KZx.this.fg) {
                        return;
                    }
                    WV wv = KZx.this.jO;
                    SGo sGo = KZx.this.Lm.get(1);
                    KZx kZx = KZx.this;
                    wv.pA(sGo, kZx, kZx);
                }
            });
        }
        if (this.jO != null && Og(4)) {
            if (Og(1)) {
                this.mY = true;
                this.GbR = new ZZv(this.ML, this.Lm.get(4), this.Lm.get(1), this.mY);
            } else {
                this.GbR = new ZZv(this.ML, this.Lm.get(4), this.mY);
            }
        }
        if (this.jO != null && Og(1) && this.FK) {
            this.lgT = new com.bytedance.adsdk.ugeno.core.Og.Og(this.ML, this.Lm.get(1));
        }
        fN();
        if (this.jO != null && Og(3) && (kZxZZv = com.bytedance.adsdk.ugeno.ZZv.pA().ZZv()) != null) {
            this.aj = kZxZZv.pA(this.ML);
            new Object() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.3
            };
        }
        if (this.jO != null && Og(9)) {
            com.bytedance.adsdk.ugeno.core.Og.ML ml = new com.bytedance.adsdk.ugeno.core.Og.ML(this.ML, this.Lm.get(9), this);
            this.uhO = ml;
            ml.pA(this.jO);
        }
        if (Og(10)) {
            com.bytedance.adsdk.ugeno.core.Og.pA pAVar2 = new com.bytedance.adsdk.ugeno.core.Og.pA(this.ML, this.Lm.get(10), this);
            this.bA = pAVar2;
            pAVar2.pA(this.jO);
        }
    }

    private void fN() {
        SGo sGo;
        if (this.jO == null || !Og(18) || (sGo = this.Lm.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectKZx = sGo.KZx();
        if (jSONObjectKZx != null) {
            try {
                jSONObjectKZx.put("rotateZ", com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectKZx.optString("rotateZ"), this.SD));
            } catch (JSONException unused) {
            }
        }
        this.jO.pA(sGo, this, this);
    }

    private void dmv() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.Sn);
        this.omh.setContentDescription(sb);
    }

    public void pA(DX dx) {
        this.Tsy = dx;
    }

    public void SD() {
        if (this.ka != null) {
            SD sd = new SD(this.omh, this.ka);
            this.sPI = sd;
            sd.pA();
        }
        com.bytedance.adsdk.ugeno.pA.pA pAVar = this.Itl;
        if (pAVar != null) {
            pAVar.pA();
        }
        com.bytedance.adsdk.ugeno.ZZv.ML ml = this.rX;
        if (ml != null) {
            ml.ZZv();
        }
        if (this.bA != null && Og(10)) {
            this.bA.pA();
        }
        if (this.uhO == null || !Og(9)) {
            return;
        }
        this.uhO.pA();
    }

    public void omh() {
        SD sd = this.sPI;
        if (sd != null) {
            sd.Og();
        }
        com.bytedance.adsdk.ugeno.pA.pA pAVar = this.Itl;
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    public WV Sd() {
        return this.jO;
    }

    public boolean Og(int i) {
        Map<Integer, SGo> map = this.Lm;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void KZx(int i) {
        ViewParent viewParent = (ViewGroup) this.omh.getParent();
        if (viewParent instanceof Og) {
            ((Og) viewParent).KZx(this.omh, i);
        } else {
            this.omh.setVisibility(i);
        }
    }

    public void pA(Wx wx) {
        this.FGT = wx;
    }

    public void pA(WV wv) {
        this.jO = wv;
    }

    public void Og(JSONObject jSONObject) {
        this.JG = jSONObject;
    }

    public JSONObject TX() {
        return this.JG;
    }

    protected void BF() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapPA;
        if (TextUtils.isEmpty(this.Gx)) {
            if (this.xkn) {
                pA(this.mK);
                return;
            } else {
                this.vkV.setColor(this.FQ);
                ZZv(this.FQ);
                return;
            }
        }
        if (this.Gx.startsWith("local://")) {
            String strReplace = this.Gx.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.JBA ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.ML.getResources().openRawResource(com.bytedance.adsdk.ugeno.SD.ZZv.pA(this.ML, strReplace)), null, options);
                if (this.JBA && (bitmapPA = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, bitmapDecodeStream, (int) this.HSv)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.ML.getResources(), bitmapPA);
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.ML.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                }
                pA(bitmapDrawable);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        WQf();
    }

    protected void WQf() {
        com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.Gx, new com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.4
            @Override // com.bytedance.adsdk.ugeno.pA.InterfaceC0181pA
            public void pA(final Bitmap bitmap) {
                if (bitmap != null) {
                    if (KZx.this.JBA) {
                        final Bitmap bitmapPA = com.bytedance.adsdk.ugeno.SD.omh.pA(KZx.this.ML, bitmap, (int) KZx.this.HSv);
                        if (bitmapPA != null) {
                            com.bytedance.adsdk.ugeno.SD.omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    KZx.this.pA(new BitmapDrawable(bitmapPA));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    com.bytedance.adsdk.ugeno.SD.omh.pA(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Og.KZx.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            KZx.this.pA(new BitmapDrawable(bitmap));
                        }
                    });
                }
            }
        });
    }

    protected void pA(com.bytedance.adsdk.ugeno.SD.pA.C0175pA c0175pA) {
        if (c0175pA == null) {
            return;
        }
        this.vkV.setShape(0);
        if (c0175pA != null) {
            this.vkV.setOrientation(c0175pA.pA);
            if (Build.VERSION.SDK_INT >= 29) {
                this.vkV.setColors(c0175pA.Og, c0175pA.KZx);
            } else {
                this.vkV.setColors(c0175pA.Og);
            }
        }
        YkC();
        fJy();
        this.omh.setBackground(this.vkV);
    }

    protected void ZZv(int i) {
        this.vkV.setShape(0);
        this.vkV.setColor(i);
        YkC();
        fJy();
        this.omh.setBackground(this.vkV);
    }

    private void fJy() {
        if (TextUtils.equals("dashed", this.fw)) {
            GradientDrawable gradientDrawable = this.vkV;
            float f = this.lx;
            gradientDrawable.setStroke((int) f, this.SXO, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.fw)) {
                GradientDrawable gradientDrawable2 = this.vkV;
                float f2 = this.lx;
                gradientDrawable2.setStroke((int) f2, this.SXO, f2 / 2.0f, f2);
                return;
            }
            this.vkV.setStroke((int) this.lx, this.SXO);
        }
    }

    private void YkC() {
        float f = this.IIF ? this.dmv : this.fN;
        float f2 = this.vA ? this.YkC : this.fN;
        float f3 = this.PV ? this.fJy : this.fN;
        float f4 = this.cFQ ? this.dC : this.fN;
        this.vkV.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    protected void pA(Drawable drawable) {
        this.omh.setBackground(drawable);
    }

    public void pA(ViewGroup.LayoutParams layoutParams) {
        T t = this.omh;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.Wo = layoutParams;
    }

    public ViewGroup.LayoutParams TV() {
        return this.Wo;
    }

    public void du() {
        if (this.omh != null) {
            pA(this.Wo);
            ML((int) this.oX);
            JG((int) this.aBv);
        }
    }

    public void pA(ML.pA pAVar) {
        this.BSW = pAVar;
    }

    public ML.pA eG() {
        return this.BSW;
    }

    public KZx<T> KZx(String str) {
        return pA(str);
    }

    protected KZx<T> pA(String str) {
        if (TextUtils.isEmpty(this.Sn) || !TextUtils.equals(this.Sn, str)) {
            return null;
        }
        return this;
    }

    public KZx<T> ZZv(String str) {
        return Og(str);
    }

    protected KZx<T> Og(String str) {
        if (TextUtils.isEmpty(this.DX) || !TextUtils.equals(this.DX, str)) {
            return null;
        }
        return this;
    }

    public void pA(boolean z) {
        this.Wx = z;
    }

    public boolean roi() {
        return this.Wx;
    }

    public pA Mc() {
        return this.Bzk;
    }

    public void pA(pA pAVar) {
        this.Bzk = pAVar;
    }

    public void ML(String str) {
        this.Sn = str;
    }

    public String IG() {
        return this.Sn;
    }

    public void JG(String str) {
        this.DX = str;
    }

    public String lT() {
        return this.DX;
    }

    public int rB() {
        return (int) this.oX;
    }

    public int xy() {
        return (int) this.aBv;
    }

    public void pA(omh omhVar) {
        this.WV = omhVar;
    }

    public boolean qmB() {
        return this.bU;
    }

    public void pA(JG jg) {
        this.uQ = jg;
    }

    public int gbA() {
        return this.FQ;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void pA(String str, String str2) {
        pA<ViewGroup> pAVar;
        pA<ViewGroup> pAVar2;
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 10;
                }
                break;
            case -1332194002:
                if (str.equals(J2.g)) {
                    b = Ascii.VT;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    b = Ascii.FF;
                }
                break;
            case -1267206133:
                if (str.equals(VastAttributes.OPACITY)) {
                    b = Ascii.CR;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = Ascii.SO;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = Ascii.SI;
                }
                break;
            case -1081309778:
                if (str.equals(VastAttributes.MARGIN)) {
                    b = Ascii.DLE;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = Ascii.DC2;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 19;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = Ascii.DC4;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = Ascii.NAK;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = Ascii.SYN;
                }
                break;
            case -806339567:
                if (str.equals(VastAttributes.PADDING)) {
                    b = Ascii.ETB;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = Ascii.CAN;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = Ascii.EM;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = Ascii.SUB;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = Ascii.ESC;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = Ascii.FS;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.GS;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = Ascii.RS;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = Ascii.US;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 32;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 33;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 34;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 35;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 36;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 37;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 38;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 39;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 40;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 41;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 42;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 43;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 44;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 45;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 46;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 47;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 48;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 49;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 50;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 51;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 52;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 53;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 54;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 55;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 56;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 57;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 58;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = 59;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = 60;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = Base64.padSymbol;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = 62;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = 63;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = SignedBytes.MAX_POWER_OF_TWO;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 65;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 66;
                }
                break;
        }
        switch (b) {
            case 0:
                this.fg = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 33:
            case 38:
            case 47:
            case 50:
            case 53:
            case 61:
            case 63:
                Og(str, str2);
                break;
            case 2:
                this.pA = true;
                this.RS = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 3:
                this.Og = true;
                this.QI = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f));
                break;
            case 4:
                this.IG = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.gbA = true;
                break;
            case 5:
                this.BF = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 11:
            case 54:
                if (com.bytedance.adsdk.ugeno.SD.pA.KZx(str2)) {
                    this.xkn = true;
                    this.mK = com.bytedance.adsdk.ugeno.SD.pA.Og(str2);
                } else {
                    this.FQ = com.bytedance.adsdk.ugeno.SD.pA.pA(str2, 0);
                    this.xkn = false;
                }
                break;
            case 12:
                this.rX = com.bytedance.adsdk.ugeno.ZZv.ML.pA(this, str2);
                break;
            case 13:
                this.dGZ = true;
                this.Uz = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 1.0f);
                break;
            case 14:
                this.dmv = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.IIF = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (roi() && (pAVar = this.Bzk) != null && pAVar.xy() == -2) {
                        this.aBv = -2.0f;
                    } else {
                        this.aBv = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.aBv = -2.0f;
                } else {
                    this.aBv = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                }
                this.Kj = true;
                break;
            case 16:
                this.XT = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                break;
            case 17:
                this.Sd = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.eG = true;
                break;
            case 19:
            case 55:
                this.Gx = str2;
                break;
            case 20:
                this.guZ = true;
                this.tZW = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 21:
                this.KZx = true;
                this.Qj = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 22:
                this.ZZv = true;
                this.sk = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 23:
                this.Mc = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.qmB = true;
                break;
            case 24:
                this.BDQ = str2;
                break;
            case 25:
                this.TX = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.roi = true;
                break;
            case 26:
                this.WQf = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 27:
                this.Sn = str2;
                break;
            case 28:
                this.PKZ = com.bytedance.adsdk.ugeno.SD.Og.pA(str2, (JSONObject) null);
                break;
            case 29:
                this.DX = str2;
                break;
            case 30:
                float fPA = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                this.HSv = fPA;
                if (fPA > 0.0f) {
                    this.JBA = true;
                }
                break;
            case 31:
                this.rB = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.CIG = true;
                break;
            case 32:
                this.PU = str2;
                break;
            case 34:
                this.nCO = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 35:
                this.KZx = true;
                this.ZZv = true;
                float[] fArrKZx = com.bytedance.adsdk.ugeno.pA.KZx.KZx(str2);
                this.Qj = fArrKZx[0];
                this.sk = fArrKZx[1];
                break;
            case 36:
                if (TextUtils.equals(str2, "match_parent")) {
                    if (roi() && (pAVar2 = this.Bzk) != null && pAVar2.rB() == -2) {
                        this.oX = -2.0f;
                    } else {
                        this.oX = -1.0f;
                    }
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.oX = -2.0f;
                } else {
                    this.oX = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                }
                this.FHA = true;
                break;
            case 37:
                this.xy = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.SzT = true;
                break;
            case 39:
                this.YkC = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.vA = true;
                break;
            case 40:
                this.qQU = omh(str2);
                break;
            case 41:
                this.fJy = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.PV = true;
                break;
            case 42:
                this.dC = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.cFQ = true;
                break;
            case 43:
                this.lT = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.Vgu = true;
                break;
            case 44:
                this.SXO = com.bytedance.adsdk.ugeno.SD.pA.pA(str2);
                break;
            case 45:
                this.fw = str2;
                break;
            case 46:
                this.lx = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                break;
            case 48:
                this.vZF = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.du = true;
                break;
            case 49:
                this.pA = true;
                this.Og = true;
                float[] fArrKZx2 = com.bytedance.adsdk.ugeno.pA.KZx.KZx(str2);
                this.RS = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, fArrKZx2[0]);
                this.QI = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, fArrKZx2[1]);
                break;
            case 51:
                try {
                    this.Itl = new com.bytedance.adsdk.ugeno.pA.pA(this.ML, this, com.bytedance.adsdk.ugeno.pA.KZx.pA(new JSONObject(str2)));
                } catch (JSONException unused) {
                    return;
                }
                break;
            case 52:
                this.ka = com.bytedance.adsdk.ugeno.core.pA.pA(str2, this);
                break;
            case 56:
                this.agB = true;
                this.Bf = SD(str2);
                break;
            case 57:
                this.fN = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                break;
            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                this.npn = true;
                this.Ld = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                this.rjD = true;
                this.rtW = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 60:
                this.slz = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, 0.0f);
                break;
            case 62:
                this.Xj = com.bytedance.adsdk.ugeno.SD.KZx.pA(str2, false);
                break;
            case 64:
                if (TextUtils.equals(VastAttributes.VISIBLE, str2)) {
                    this.gy = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.gy = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.gy = 8;
                }
                this.omh.setVisibility(this.gy);
                break;
            case 65:
                this.yFO = com.bytedance.adsdk.ugeno.SD.omh.pA(this.ML, str2);
                this.TV = true;
                break;
            case 66:
                this.bU = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType SD(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.Bf = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.Bf = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.Bf = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.Bf = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.Bf;
    }

    private boolean omh(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    protected void Og(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.Lm == null) {
            return;
        }
        try {
            int iPA = BSW.pA(str).pA();
            SGo sGo = new SGo();
            sGo.pA(iPA);
            sGo.pA(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (iPA == 3) {
                try {
                    this.EC = Float.parseFloat(com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObject.optString("shakeAmplitude"), this.SD));
                } catch (NumberFormatException unused) {
                    this.EC = 12.0f;
                }
            }
            WV wv = this.jO;
            if (!(wv instanceof com.bytedance.adsdk.ugeno.core.pA.pA)) {
                pA(iPA, jSONObject, sGo);
            } else if (!((com.bytedance.adsdk.ugeno.core.pA.pA) wv).pA()) {
                pA(iPA, jSONObject, sGo);
            } else {
                sGo.pA(jSONObject);
                this.Lm.put(Integer.valueOf(iPA), sGo);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    protected void pA(int i, JSONObject jSONObject, SGo sGo) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            SGo sGo2 = new SGo();
            sGo2.pA(jSONObjectOptJSONObject);
            sGo2.pA(this);
            sGo.pA(sGo2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(b9.f.e);
        if (jSONObjectOptJSONObject2 != null) {
            SGo sGo3 = new SGo();
            sGo3.pA(jSONObjectOptJSONObject2);
            sGo3.pA(this);
            sGo.Og(sGo3);
        }
        sGo.pA(jSONObject);
        this.Lm.put(Integer.valueOf(i), sGo);
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void ML() {
        if (this.Tsy == null || this.Qd) {
            return;
        }
        this.Qd = true;
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void JG() {
        if (this.Tsy == null || this.HMH) {
            return;
        }
        this.HMH = true;
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public int[] pA(int i, int i2) {
        if (this.nCO > 0.0f) {
            if (this.FHA) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.nCO;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.Kj) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.nCO;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.Tsy != null && !this.xt) {
            this.xt = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void pA(int i, int i2, int i3, int i4) {
        if (this.Tsy == null || this.Bpk) {
            return;
        }
        this.Bpk = true;
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void pA(Canvas canvas, IAnimation iAnimation) {
        SD sd = this.sPI;
        if (sd != null) {
            sd.pA(canvas, iAnimation);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void pA(Canvas canvas) {
        com.bytedance.adsdk.ugeno.pA.pA pAVar = this.Itl;
        if (pAVar != null) {
            pAVar.pA(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.KZx
    public void Og(int i, int i2, int i3, int i4) {
        SD sd = this.sPI;
        if (sd != null) {
            sd.pA(i, i2);
        }
        com.bytedance.adsdk.ugeno.pA.pA pAVar = this.Itl;
        if (pAVar != null) {
            pAVar.pA(i, i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV.Og
    public void pA(SGo sGo) {
        pA<ViewGroup> pAVar;
        KZx<T> KZx;
        if (sGo == null || sGo.KZx() == null || !TextUtils.equals(sGo.KZx().optString("type"), "onDismiss")) {
            return;
        }
        String strOptString = sGo.KZx().optString("nodeId");
        KZx(8);
        this.SGo = (pA) Og(this);
        if (TextUtils.isEmpty(strOptString) || (pAVar = this.SGo) == null || (KZx = pAVar.KZx(strOptString)) == null) {
            return;
        }
        KZx.KZx(8);
    }

    public void pA(com.bytedance.adsdk.ugeno.ZZv.pA.pA pAVar) {
        this.kK = pAVar;
    }

    public com.bytedance.adsdk.ugeno.ZZv.pA.pA Vgu() {
        return this.kK;
    }

    public KZx Og(KZx kZx) {
        return (kZx.Mc() == null && (kZx instanceof pA)) ? kZx : Og(kZx.Mc());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ZZv zZv;
        WV wv;
        com.bytedance.adsdk.ugeno.core.Og.Og og;
        int action = motionEvent.getAction();
        if (action == 0) {
            CIG();
        } else if (action == 1 || action == 3) {
            SzT();
        }
        Wx wx = this.FGT;
        if (wx != null) {
            wx.pA(this, motionEvent);
        }
        if (Og(17) && motionEvent.getAction() == 0) {
            this.jO.pA(this.Lm.get(17), this, this);
        }
        if (Og(1) && this.FK && (wv = this.jO) != null && (og = this.lgT) != null) {
            return og.pA(wv, this, motionEvent);
        }
        WV wv2 = this.jO;
        if (wv2 != null && (zZv = this.GbR) != null) {
            return zZv.pA(wv2, this, motionEvent);
        }
        com.bytedance.adsdk.ugeno.ZZv.ML ml = this.rX;
        if (ml != null) {
            return ml.pA(motionEvent);
        }
        return false;
    }

    public boolean FQ() {
        return this.nCO > 0.0f;
    }

    public float Gx() {
        T t = this.omh;
        if (t instanceof com.bytedance.adsdk.ugeno.pA.ML) {
            return ((com.bytedance.adsdk.ugeno.pA.ML) t).getRipple();
        }
        return 0.0f;
    }

    public float Bf() {
        T t = this.omh;
        if (t instanceof com.bytedance.adsdk.ugeno.pA.ML) {
            return ((com.bytedance.adsdk.ugeno.pA.ML) t).getShine();
        }
        return 0.0f;
    }

    public float HSv() {
        T t = this.omh;
        if (t instanceof com.bytedance.adsdk.ugeno.pA.ML) {
            return ((com.bytedance.adsdk.ugeno.pA.ML) t).getStretch();
        }
        return 0.0f;
    }

    public float JBA() {
        T t = this.omh;
        if (t instanceof com.bytedance.adsdk.ugeno.pA.ML) {
            return ((com.bytedance.adsdk.ugeno.pA.ML) t).getRubIn();
        }
        return 0.0f;
    }

    public void ML(int i) {
        if (roi()) {
            T t = this.omh;
            if (t instanceof Og) {
                ((Og) t).pA(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof Og) {
                ((Og) viewParent).pA(this.omh, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.omh.getLayoutParams();
        layoutParams.width = i;
        this.omh.setLayoutParams(layoutParams);
    }

    public void JG(int i) {
        if (roi()) {
            T t = this.omh;
            if (t instanceof Og) {
                ((Og) t).Og(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof Og) {
                ((Og) viewParent).Og(this.omh, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.omh.getLayoutParams();
        layoutParams.height = i;
        this.omh.setLayoutParams(layoutParams);
    }

    public boolean agB() {
        return this.Xj;
    }
}
