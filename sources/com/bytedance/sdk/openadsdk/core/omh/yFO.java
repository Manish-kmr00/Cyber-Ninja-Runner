package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.lT;
import com.bytedance.sdk.openadsdk.core.rB;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class yFO extends com.bytedance.sdk.openadsdk.core.ML.KZx implements com.bytedance.sdk.component.adexpress.Og.DX, com.bytedance.sdk.component.adexpress.Og.omh, com.bytedance.sdk.component.adexpress.dynamic.ZZv, com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA, Sn {
    public static int Sd = 500;
    int BF;
    protected com.bytedance.sdk.openadsdk.core.model.yFO BSW;
    private final Runnable Bf;
    protected String Bzk;
    private TX CIG;
    protected com.bytedance.sdk.component.adexpress.Og.KZx DX;
    private KZx FQ;
    private final ViewTreeObserver.OnScrollChangedListener Gx;
    private final Runnable HSv;
    private float IG;
    private com.bytedance.sdk.openadsdk.core.BSW.Og.SD IIF;
    private com.bytedance.sdk.openadsdk.core.KZx.SD Itl;
    private final Runnable JBA;
    private omh JG;
    private com.bytedance.sdk.openadsdk.KZx.KZx KZx;
    private PAGExpressAdWrapperListener ML;
    private String Mc;
    private int Og;
    private com.bytedance.sdk.component.adexpress.Og.Bzk PV;
    private Bzk SD;
    protected AdSlot SGo;
    private final SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> SXO;
    protected boolean Sn;
    private final AtomicBoolean SzT;
    public com.bytedance.sdk.openadsdk.ZZv.SD TV;
    public boolean TX;
    private boolean Vgu;
    boolean WQf;
    public FrameLayout WV;
    private long Wo;
    protected boolean Wx;
    protected int XT;
    private com.bytedance.sdk.component.adexpress.Og.oX YkC;
    private TTDislikeDialogAbstract ZZv;
    boolean aBv;
    private ThemeStatusBroadcastReceiver agB;
    private float bU;
    private com.bytedance.sdk.component.adexpress.Og.Wx cFQ;
    private com.bytedance.sdk.component.adexpress.Og.JG dC;
    private com.bytedance.sdk.component.adexpress.Og.SGo.pA dmv;
    long du;
    protected com.bytedance.sdk.component.adexpress.Og.Og eG;
    private List<com.bytedance.sdk.component.adexpress.Og.SGo> fJy;
    private WQf fN;
    private float fw;
    private com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA gbA;
    private float gy;
    private float lT;
    private int lx;
    private float nCO;
    protected boolean oX;
    protected final Context omh;
    private boolean pA;
    private String qmB;
    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML rB;
    public com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> roi;
    private com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx vA;
    protected HashSet<String> vZF;
    private String xy;
    protected String yFO;

    public long KZx() {
        return 0L;
    }

    public void ML() {
    }

    public void Og() {
    }

    public void Og(int i) {
    }

    public int ZZv() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/yFO;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z");
        DetectTouchUtils.viewOnTouch(h.u, this, motionEvent);
        return safedk_yFO_dispatchTouchEvent_f7aef9e03a0f9faed506d5cf3359fa7e(motionEvent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void onvideoComplate() {
    }

    public void pA() {
    }

    public void pA(int i) {
    }

    public void pA(int i, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
    }

    public void pA(int i, String str) {
    }

    protected void pA(com.bytedance.sdk.component.adexpress.Og.Wx.pA pAVar) {
    }

    public void pA(String str, JSONObject jSONObject) {
    }

    protected void pA(JSONObject jSONObject) {
    }

    public void pA(boolean z) {
    }

    protected boolean pA(com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTimeUpdate(int i) {
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.JG jg) {
        if (this.fN != null && getJsObject() != null) {
            getJsObject().pA(jg);
        }
        com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx kZx = this.vA;
        if (kZx != null) {
            kZx.pA(jg);
        }
    }

    public com.bytedance.sdk.openadsdk.ZZv.SD getAdShowTime() {
        return this.TV;
    }

    public void setClosedListenerKey(String str) {
        this.qmB = str;
        KZx kZx = this.FQ;
        if (kZx != null) {
            kZx.pA(str);
        }
    }

    public KZx getBrandBannerController() {
        return this.FQ;
    }

    public String getClosedListenerKey() {
        return this.qmB;
    }

    public void setBannerClickClosedListener(com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA pAVar) {
        this.gbA = pAVar;
    }

    public yFO(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, String str) {
        super(context);
        this.pA = true;
        this.Og = 0;
        this.Bzk = "embeded_ad";
        this.Mc = null;
        this.Sn = false;
        this.oX = false;
        this.aBv = true;
        this.XT = -1;
        this.xy = "";
        this.TX = false;
        this.Vgu = true;
        this.BF = -1;
        this.TV = new com.bytedance.sdk.openadsdk.ZZv.SD();
        this.du = 0L;
        this.SzT = new AtomicBoolean(false);
        this.Gx = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (yFO.this.aBv) {
                    yFO.this.Sd();
                    yFO yfo2 = yFO.this;
                    yfo2.removeCallbacks(yfo2.Bf);
                    yFO yfo3 = yFO.this;
                    yfo3.postDelayed(yfo3.Bf, 500L);
                }
            }
        };
        this.Bf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.2
            @Override // java.lang.Runnable
            public void run() {
                if (lT.pA(yFO.this, 0, 5)) {
                    yFO yfo2 = yFO.this;
                    yfo2.JG(yfo2.getVisibility());
                } else {
                    yFO.this.JG(8);
                }
            }
        };
        this.HSv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.3
            @Override // java.lang.Runnable
            public void run() {
                yFO.this.JG(0);
            }
        };
        this.JBA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.4
            @Override // java.lang.Runnable
            public void run() {
                yFO.this.JG(8);
            }
        };
        this.lx = 8;
        this.SXO = new SparseArray<>();
        this.fw = -1.0f;
        this.gy = -1.0f;
        this.nCO = -1.0f;
        this.bU = -1.0f;
        this.Wo = 0L;
        this.Bzk = str;
        this.omh = context;
        this.BSW = yfo;
        this.SGo = adSlot;
        this.TX = false;
        JG();
    }

    public yFO(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, String str, boolean z, boolean z2) {
        super(context);
        this.pA = true;
        this.Og = 0;
        this.Bzk = "embeded_ad";
        this.Mc = null;
        this.Sn = false;
        this.oX = false;
        this.aBv = true;
        this.XT = -1;
        this.xy = "";
        this.TX = false;
        this.Vgu = true;
        this.BF = -1;
        this.TV = new com.bytedance.sdk.openadsdk.ZZv.SD();
        this.du = 0L;
        this.SzT = new AtomicBoolean(false);
        this.Gx = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (yFO.this.aBv) {
                    yFO.this.Sd();
                    yFO yfo2 = yFO.this;
                    yfo2.removeCallbacks(yfo2.Bf);
                    yFO yfo3 = yFO.this;
                    yfo3.postDelayed(yfo3.Bf, 500L);
                }
            }
        };
        this.Bf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.2
            @Override // java.lang.Runnable
            public void run() {
                if (lT.pA(yFO.this, 0, 5)) {
                    yFO yfo2 = yFO.this;
                    yfo2.JG(yfo2.getVisibility());
                } else {
                    yFO.this.JG(8);
                }
            }
        };
        this.HSv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.3
            @Override // java.lang.Runnable
            public void run() {
                yFO.this.JG(0);
            }
        };
        this.JBA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.4
            @Override // java.lang.Runnable
            public void run() {
                yFO.this.JG(8);
            }
        };
        this.lx = 8;
        this.SXO = new SparseArray<>();
        this.fw = -1.0f;
        this.gy = -1.0f;
        this.nCO = -1.0f;
        this.bU = -1.0f;
        this.Wo = 0L;
        this.Bzk = str;
        this.omh = context;
        this.BSW = yfo;
        this.SGo = adSlot;
        this.TX = z;
        this.Vgu = z2;
        JG();
    }

    protected void JG() {
        this.vZF = new HashSet<>();
        this.agB = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.SGo;
        if (adSlot != null) {
            this.IG = adSlot.getExpressViewAcceptedWidth();
            this.lT = this.SGo.getExpressViewAcceptedHeight();
            SD();
            this.Mc = this.SGo.getCodeId();
            if (TextUtils.equals(this.Bzk, "fullscreen_interstitial_ad")) {
                this.BF = com.bytedance.sdk.openadsdk.core.aBv.ZZv().yFO(this.Mc);
            } else if (TextUtils.equals(this.Bzk, "rewarded_video")) {
                this.BF = com.bytedance.sdk.openadsdk.core.aBv.ZZv().SGo(this.Mc);
            } else if (TextUtils.equals(this.Bzk, "open_ad")) {
                int iTX = com.bytedance.sdk.openadsdk.core.aBv.ZZv().TX(this.Mc);
                this.BF = iTX;
                if (iTX < 0) {
                    this.BF = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.BSW.qQU()) {
            this.FQ = new KZx(this.omh, this, this.BSW, this.Bzk);
            return;
        }
        oX();
        this.fJy = new ArrayList();
        aBv();
        com.bytedance.sdk.component.adexpress.Og.oX oXVar = this.YkC;
        if (oXVar != null) {
            this.fN = (WQf) oXVar.Og();
        }
        IG jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.JG(this.Bzk);
        }
    }

    private void SD() {
        com.bytedance.sdk.openadsdk.core.model.yFO.pA pAVarCIG = this.BSW.CIG();
        if (!TextUtils.equals(this.Bzk, "embeded_ad") || pAVarCIG == null) {
            return;
        }
        String strWV = pAVarCIG.WV();
        if (TextUtils.isEmpty(strWV)) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strWV);
            int iOptInt = jSONObjectJsonObjectInit.optInt("width");
            int iOptInt2 = jSONObjectJsonObjectInit.optInt("height");
            if (iOptInt == 0 || iOptInt2 == 0) {
                return;
            }
            this.lT = iOptInt2;
            this.IG = iOptInt;
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.Bzk.ZZv getWebView() {
        WQf wQf = this.fN;
        if (wQf == null) {
            return null;
        }
        return wQf.pA();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0040  */
    private void oX() {
        long jOptLong;
        boolean z;
        com.bytedance.sdk.component.adexpress.Og.Wx.pA pAVar;
        this.rB = new com.bytedance.sdk.openadsdk.ZZv.aBv(1, this.Bzk, this.BSW);
        this.PV = new Wx(this.rB, this.Bzk, this.BSW, this.Mc);
        final boolean zSzT = this.BSW.SzT();
        try {
            com.bytedance.sdk.openadsdk.core.model.yFO.pA pAVarCIG = this.BSW.CIG();
            if (pAVarCIG != null) {
                String strBSW = pAVarCIG.BSW();
                if (TextUtils.isEmpty(strBSW)) {
                    jOptLong = 0;
                } else {
                    jOptLong = PangleNetworkBridge.jsonObjectInit(strBSW).optLong("render_delay_time");
                }
            } else {
                jOptLong = 0;
            }
        } catch (Exception unused) {
        }
        try {
            z = !com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.BSW) && com.bytedance.sdk.openadsdk.core.aBv.ZZv().Wx(this.Mc) == 1;
            try {
                if (!com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Sn(this.Mc) || this.BSW.aBv() == 5 || this.BSW.aBv() == 6 || this.BSW.FHA() == 3) {
                    z = true;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            z = false;
        }
        long jMin = Math.min(Math.max(jOptLong, 0L), 10000L);
        int renderTimeout = getRenderTimeout();
        double dJG = this.BSW.Bf() != null ? this.BSW.Bf().JG() * ((double) this.BSW.Bf().TX()) : 0.0d;
        int i = this.BF;
        this.WQf = i != -1 && i < ((int) dJG);
        if (com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.BSW) || com.bytedance.sdk.openadsdk.core.BSW.KZx.Og(this.BSW)) {
            com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA.C0228pA c0228pA = new com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA.C0228pA();
            if (com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.BSW)) {
                c0228pA.pA(com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.BSW, this.Bzk));
            }
            c0228pA.pA((com.bytedance.adsdk.ugeno.core.DX) this.PV);
            c0228pA.pA(this.IG);
            c0228pA.Og(this.lT);
            pAVar = c0228pA;
        } else {
            pAVar = new com.bytedance.sdk.component.adexpress.Og.Wx.pA();
        }
        pAVar.ML(zSzT);
        pAVar.pA(this.Bzk).Og(this.BSW.nCO()).KZx(this.BSW.jK()).ZZv(this.BSW.tM()).pA(this.PV).ZZv(this.BSW.GbR()).pA(renderTimeout).Og(this.BSW.uQ()).KZx(this.Vgu).Og(this.BSW.Mc()).pA(jMin).KZx(this.BSW.JBA()).pA(com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(this.BSW)).ZZv(z).ML(this.BF).pA(this.WQf).pA(dJG).JG(com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Gag()).pA(new com.bytedance.sdk.component.adexpress.Og.ML() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.5
            @Override // com.bytedance.sdk.component.adexpress.Og.ML
            public JSONObject pA() {
                try {
                    if (yFO.this.BSW == null) {
                        yFO.this.xy = "material is null";
                        return null;
                    }
                    if (zSzT) {
                        yFO.this.CIG = new TX();
                        JSONObject jSONObjectPA = com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(yFO.this.IG, yFO.this.lT, yFO.this.Sn, yFO.this.BSW, yFO.this.Bzk, yFO.this.CIG);
                        yFO.this.xy = com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA();
                        return jSONObjectPA;
                    }
                    if (com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(yFO.this.BSW)) {
                        yFO.this.CIG = new TX();
                        JSONObject jSONObjectPA2 = com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(yFO.this.BSW, yFO.this.CIG);
                        yFO.this.xy = com.bytedance.sdk.openadsdk.core.BSW.KZx.pA();
                        return jSONObjectPA2;
                    }
                    JSONObject jSONObjectPA3 = com.bytedance.sdk.openadsdk.core.omh.pA.Og.pA(yFO.this.IG, yFO.this.lT, yFO.this.Sn, yFO.this.BSW);
                    yFO.this.pA(jSONObjectPA3);
                    return jSONObjectPA3;
                } catch (Throwable unused4) {
                    return null;
                }
            }
        });
        pA(pAVar);
        this.cFQ = pAVar.pA();
    }

    public String getUgenTemplateErrorReason() {
        return this.xy;
    }

    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.aBv.ZZv().eG();
    }

    private void aBv() {
        if (this.BSW.PKZ() == 1 && this.BSW.rjD()) {
            com.bytedance.sdk.component.adexpress.Og.JG jg = new com.bytedance.sdk.component.adexpress.Og.JG(this.omh, this.cFQ, new vZF(this, this.agB, this.cFQ));
            this.dC = jg;
            this.fJy.add(jg);
            this.dmv = new com.bytedance.sdk.component.adexpress.Og.WV(this.fJy, this.PV);
            return;
        }
        if (TV()) {
            XT();
            return;
        }
        try {
            yFO();
            this.fN = new WQf(this.omh, this.cFQ, this.agB, this.rB, this.BSW);
            com.bytedance.sdk.component.adexpress.Og.oX oXVar = new com.bytedance.sdk.component.adexpress.Og.oX(this.omh, this.cFQ, this.fN, this);
            this.YkC = oXVar;
            this.fJy.add(oXVar);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        com.bytedance.sdk.component.adexpress.Og.JG jg2 = new com.bytedance.sdk.component.adexpress.Og.JG(this.omh, this.cFQ, new vZF(this, this.agB, this.cFQ));
        this.dC = jg2;
        this.fJy.add(jg2);
        this.dmv = new com.bytedance.sdk.component.adexpress.Og.WV(this.fJy, this.PV);
    }

    private void XT() {
        this.Og = this.BSW.du();
        try {
            yFO();
            vZF();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        boolean z = this.BSW.eG() == 1;
        this.pA = z;
        if (z) {
            com.bytedance.sdk.component.adexpress.Og.JG jg = new com.bytedance.sdk.component.adexpress.Og.JG(this.omh, this.cFQ, new vZF(this, this.agB, this.cFQ));
            this.dC = jg;
            this.fJy.add(jg);
        }
        new StringBuilder("initRender: mRenderSequenceType is ").append(this.Og).append(", mInterceptors is ").append(this.fJy);
        this.dmv = new com.bytedance.sdk.component.adexpress.Og.WV(this.fJy, this.PV);
    }

    private void yFO() {
        if (com.bytedance.sdk.openadsdk.core.Sn.ML()) {
            return;
        }
        WV.pA();
    }

    private void vZF() {
        com.bytedance.sdk.openadsdk.core.JG.pA.pA pAVar = new com.bytedance.sdk.openadsdk.core.JG.pA.pA();
        int i = this.Og;
        if (i == 3) {
            com.bytedance.sdk.component.adexpress.dynamic.ML.SD sd = new com.bytedance.sdk.component.adexpress.dynamic.ML.SD();
            com.bytedance.sdk.component.adexpress.Og.Og og = new com.bytedance.sdk.component.adexpress.Og.Og(this.omh.getApplicationContext(), this.cFQ, this.agB, this.TX, sd, this, pAVar, new JG(this.omh, this.agB, this.TX, sd, this.cFQ, pAVar));
            this.eG = og;
            this.fJy.add(og);
            return;
        }
        if (i == 7) {
            this.vA = new com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx(this.omh, this.BSW, this.TX, (com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA) this.cFQ, this);
            com.bytedance.sdk.openadsdk.core.BSW.Og.SD sd2 = new com.bytedance.sdk.openadsdk.core.BSW.Og.SD(this.omh, this.vA, this, this.cFQ);
            this.IIF = sd2;
            this.fJy.add(sd2);
            return;
        }
        if (i == 10) {
            com.bytedance.sdk.openadsdk.core.BSW.Og.SD sd3 = new com.bytedance.sdk.openadsdk.core.BSW.Og.SD(this.omh, new com.bytedance.sdk.openadsdk.core.BSW.ZZv.ML(this.omh, this.BSW, this.TX, (com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA) this.cFQ, this), this, this.cFQ);
            this.IIF = sd3;
            this.fJy.add(sd3);
            return;
        }
        this.fN = new WQf(this.omh, this.cFQ, this.agB, this.rB, this.BSW);
        com.bytedance.sdk.component.adexpress.Og.oX oXVar = new com.bytedance.sdk.component.adexpress.Og.oX(this.omh, this.cFQ, this.fN, this);
        this.YkC = oXVar;
        this.fJy.add(oXVar);
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        pA pAVar;
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv != null && (zZv instanceof vZF) && (pAVar = (pA) zZv.ML()) != null) {
            pAVar.setDislikeOuter(tTDislikeDialogAbstract);
        }
        KZx kZx = this.FQ;
        if (kZx != null) {
            kZx.pA(tTDislikeDialogAbstract);
        }
        this.ZZv = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.KZx.KZx kZx) {
        pA pAVar;
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv != null && (zZv instanceof vZF) && (pAVar = (pA) zZv.ML()) != null) {
            pAVar.setDislikeInner(kZx);
        }
        KZx kZx2 = this.FQ;
        if (kZx2 != null) {
            kZx2.pA(kZx);
        }
        this.KZx = kZx;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.ML = pAGExpressAdWrapperListener;
        KZx kZx = this.FQ;
        if (kZx != null) {
            kZx.pA(pAGExpressAdWrapperListener);
        }
    }

    public void setClickCreativeListener(omh omhVar) {
        this.JG = omhVar;
        if (omhVar != null) {
            omhVar.pA((com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA) this);
        }
    }

    public omh getClickCreativeListener() {
        return this.JG;
    }

    public Bzk getClickListener() {
        return this.SD;
    }

    public void setClickListener(Bzk bzk) {
        this.SD = bzk;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.Og.KZx kZx) {
        this.DX = kZx;
        com.bytedance.sdk.component.adexpress.Og.JG jg = this.dC;
        if (jg != null) {
            jg.pA(kZx);
        }
    }

    public void omh() {
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv instanceof WQf) {
            if (zZv == null) {
                return;
            }
            ((WQf) zZv).omh();
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
            com.bytedance.sdk.component.utils.SD.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.yFO.6
                @Override // java.lang.Runnable
                public void run() {
                    yFO.this.ML(1);
                }
            }, ((long) (yfo != null ? yfo.SGo().pA() : 5)) * 1000);
        }
        com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.BSW;
        if (yfo2 == null || yfo2.dGZ() == null || this.BSW.dGZ().pA() == null) {
            return;
        }
        this.BSW.dGZ().pA().pA(0L);
    }

    public void ML(int i) {
        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.BSW)) {
            com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
            if (zZv instanceof WQf) {
                ((WQf) zZv).Og(i);
            }
        }
    }

    public void JG(int i) {
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv == null || !(zZv instanceof WQf)) {
            return;
        }
        ((WQf) zZv).pA(i);
        this.lx = i;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        pA(i, true, false);
    }

    public void pA(int i, boolean z, boolean z2) {
        this.aBv = z;
        removeCallbacks(this.JBA);
        removeCallbacks(this.HSv);
        if (i == 0) {
            if (z2) {
                this.HSv.run();
                return;
            } else {
                postDelayed(this.HSv, 50L);
                return;
            }
        }
        if (z2) {
            this.JBA.run();
        } else {
            postDelayed(this.JBA, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        Sd();
        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(this.BSW, z);
        if (z) {
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.BSW, 4);
        } else {
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.BSW, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sd() {
        if (this.SzT.get()) {
            this.TV.pA(System.currentTimeMillis(), lT.pA(this));
        }
    }

    public void Bzk() {
        if (this.BSW == null) {
            return;
        }
        this.du = SystemClock.elapsedRealtime();
        if (this.BSW.qQU()) {
            KZx kZx = this.FQ;
            if (kZx == null) {
                a_(106);
                return;
            } else {
                kZx.pA((com.bytedance.sdk.component.adexpress.Og.DX) this);
                this.FQ.pA();
                return;
            }
        }
        this.rB.pA();
        com.bytedance.sdk.component.adexpress.Og.SGo.pA pAVar = this.dmv;
        if (pAVar != null) {
            pAVar.pA(this);
        }
        try {
            this.dmv.pA();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b1  */
    public boolean safedk_yFO_dispatchTouchEvent_f7aef9e03a0f9faed506d5cf3359fa7e(MotionEvent p0) {
        int i;
        SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray;
        omh omhVar = this.JG;
        int i2 = 0;
        if (omhVar != null) {
            omhVar.Og(p0.getDeviceId());
            this.JG.pA(p0.getSource());
            this.JG.KZx(p0.getToolType(0));
        }
        Bzk bzk = this.SD;
        if (bzk != null) {
            bzk.Og(p0.getDeviceId());
            this.SD.pA(p0.getSource());
            this.SD.KZx(p0.getToolType(0));
        }
        int actionMasked = p0.getActionMasked();
        if (actionMasked == 0) {
            this.fw = p0.getRawX();
            this.gy = p0.getRawY();
            this.Wo = System.currentTimeMillis();
        } else {
            i2 = 3;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    i2 = actionMasked != 3 ? -1 : 4;
                } else {
                    this.nCO += Math.abs(p0.getX() - this.fw);
                    this.bU += Math.abs(p0.getY() - this.gy);
                    this.fw = p0.getX();
                    this.gy = p0.getY();
                    i = (System.currentTimeMillis() - this.Wo <= 200 || (this.nCO <= 8.0f && this.bU <= 8.0f)) ? 2 : 1;
                }
            }
            sparseArray = this.SXO;
            if (sparseArray != null) {
                sparseArray.put(p0.getActionMasked(), new com.bytedance.sdk.openadsdk.core.Og.KZx.pA(i, p0.getSize(), p0.getPressure(), System.currentTimeMillis()));
            }
            return super.dispatchTouchEvent(p0);
        }
        i = i2;
        sparseArray = this.SXO;
        if (sparseArray != null) {
            sparseArray.put(p0.getActionMasked(), new com.bytedance.sdk.openadsdk.core.Og.KZx.pA(i, p0.getSize(), p0.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(p0);
    }

    public void pA(View view, int i, com.bytedance.sdk.component.adexpress.KZx kZx) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.openadsdk.utils.TX.pA("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i));
        if (i == -1 || kZx == null) {
            return;
        }
        HashMap map = new HashMap();
        if (com.bytedance.sdk.openadsdk.core.model.WQf.KZx(this.BSW)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.Sn sn = (com.bytedance.sdk.openadsdk.core.model.Sn) kZx;
        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.BSW)) {
            try {
                JSONObject jSONObject2 = sn.aBv;
                if (jSONObject2 != null) {
                    int iOptInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", iOptInt);
                    map.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.Og(th.toString());
            }
        }
        omh omhVar = this.JG;
        if (omhVar != null) {
            omhVar.ZZv(getDynamicShowType());
            this.JG.pA(map);
        }
        Bzk bzk = this.SD;
        if (bzk != null) {
            bzk.ZZv(getDynamicShowType());
            this.SD.pA(map);
        }
        float f = sn.pA;
        float f2 = sn.Og;
        float f3 = sn.KZx;
        float f4 = sn.ZZv;
        boolean z = sn.DX;
        SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray = sn.Sn;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.SXO;
        }
        SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray2 = sparseArray;
        String str = sn.BSW;
        JSONObject jSONObjectPA = null;
        if (view == null) {
            view2 = this;
        } else {
            jSONObjectPA = view != this ? pA(view) : null;
            view2 = view;
        }
        if (sn != null) {
            sn.WV = i;
            if (jSONObjectPA != null && sn.Wx == null) {
                sn.Wx = jSONObjectPA;
            }
        }
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.WV;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
                if (yfo == null || yfo.yFO() != 1 || z) {
                    Bzk bzk2 = this.SD;
                    if (bzk2 != null) {
                        bzk2.pA(sn);
                        this.SD.pA(str);
                        this.SD.pA(view2, f, f2, f3, f4, sparseArray2, z);
                    }
                    if (this.ML != null && !sn.XT) {
                        this.ML.onAdClicked();
                        break;
                    }
                }
                break;
            case 2:
                if (sn.oX > 0) {
                    rB.pA(true);
                }
                omh omhVar2 = this.JG;
                if (omhVar2 != null) {
                    omhVar2.pA(sn);
                    this.JG.pA(str);
                    if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.BSW) && (jSONObject = sn.aBv) != null) {
                        this.JG.ZZv(jSONObject.optBoolean("is_ceiling_page", false));
                    }
                    this.JG.pA(view2, f, f2, f3, f4, sparseArray2, z);
                }
                if (this.ML != null && !sn.XT) {
                    this.ML.onAdClicked();
                }
                rB.pA(false);
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.BSW, 9);
                break;
            case 3:
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ZZv;
                if (tTDislikeDialogAbstract != null) {
                    tTDislikeDialogAbstract.show();
                } else {
                    com.bytedance.sdk.openadsdk.KZx.KZx kZx2 = this.KZx;
                    if (kZx2 != null) {
                        kZx2.pA();
                    } else {
                        TTDelegateActivity.pA(this.BSW, this.qmB);
                    }
                }
                break;
            case 4:
                FrameLayout frameLayout2 = this.WV;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.BSW;
                if (yfo2 == null || yfo2.yFO() != 1 || z) {
                    gbA.KZx(this.BSW);
                    if ("embeded_ad".equals(this.Bzk) && TX() && !this.Wx && gbA.KZx(this.BSW)) {
                        omh omhVar3 = this.JG;
                        if (omhVar3 != null) {
                            omhVar3.pA(sn);
                            this.JG.pA(str);
                            this.JG.pA(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                    } else {
                        Bzk bzk3 = this.SD;
                        if (bzk3 != null) {
                            bzk3.pA(sn);
                            this.SD.pA(str);
                            this.SD.pA(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                    }
                    if (this.ML != null && !sn.XT) {
                        this.ML.onAdClicked();
                        break;
                    }
                }
                break;
            case 5:
                pA(!this.TX);
                break;
            case 6:
                pA();
                break;
            case 7:
                TTWebsiteActivity.pA(this.omh, this.BSW, this.Bzk);
                break;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.KZx.SD sd = this.Itl;
        if (sd != null) {
            return sd.getVideoProgress();
        }
        return 0L;
    }

    public static JSONObject pA(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean TX() {
        return com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.BSW);
    }

    private int getAdSlotType() {
        String str = this.Bzk;
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Sd();
        BF();
        com.bytedance.sdk.component.utils.WV.pA("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.Gx);
        com.bytedance.sdk.openadsdk.core.Bzk.Og().pA(this.qmB, this.gbA);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Sd();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.WV.pA("webviewpool", "onFinishTemporaryDetach+++");
    }

    private void BF() {
        List<com.bytedance.sdk.component.adexpress.Og.SGo> list = this.fJy;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.Og.SGo> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void WQf() {
        List<com.bytedance.sdk.component.adexpress.Og.SGo> list = this.fJy;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.Og.SGo> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void SGo() {
        WQf wQf = this.fN;
        if (wQf == null || wQf.ML() == null) {
            return;
        }
        this.fN.JG();
    }

    public void BSW() {
        try {
            KZx kZx = this.FQ;
            if (kZx != null) {
                kZx.Og();
            }
            Sn();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.Og.SGo> list = this.fJy;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.Og.SGo> it = list.iterator();
                while (it.hasNext()) {
                    it.next().pA();
                }
            }
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.BSW);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(this.BSW);
            this.KZx = null;
            this.ZZv = null;
            this.SGo = null;
            this.BSW = null;
            this.ML = null;
            this.JG = null;
            this.DX = null;
            this.SD = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("NativeExpressView", "detach error", th);
        }
    }

    public void WV() {
        try {
            FrameLayout frameLayout = this.WV;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.WV);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.Gx);
        com.bytedance.sdk.openadsdk.core.Bzk.Og().JG(this.qmB);
        WQf();
        com.bytedance.sdk.component.utils.WV.pA("webviewpool", "onDetachedFromWindow===");
        pA(8, true, true);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.WV.pA("webviewpool", "onStartTemporaryDetach===");
    }

    public void pA(com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        this.SzT.set(true);
        this.roi = zZv;
        if (this.lx != getWindowVisibility()) {
            JG(getWindowVisibility());
        }
        new Object[]{"render type is  ", Integer.valueOf(zZv.KZx())};
        if (zZv.KZx() == 3 && (yfo = this.BSW) != null && yfo.aBv() == 1) {
            this.BSW.Og(0);
        }
        if (zZv.KZx() != 1) {
            View viewML = zZv.ML();
            if (viewML.getParent() != null) {
                ((ViewGroup) viewML.getParent()).removeView(viewML);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                arrayList.add(getChildAt(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) instanceof com.bytedance.sdk.component.Bzk.ZZv) {
                    removeView((View) arrayList.get(i2));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.BSW)) {
                addView(zZv.ML(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(zZv.ML());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.BSW;
        if (yfo2 != null) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA(yfo2.Og(), this.du, this.Bzk, zZv.KZx());
        }
        com.bytedance.sdk.component.adexpress.Og.Bzk bzk = this.PV;
        if (bzk != null) {
            ((Wx) bzk).BSW();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ML;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) sn.ZZv(), (float) sn.ML());
        }
        if (pA(sn)) {
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this, this.BSW, KZx(getDynamicShowType()));
        }
        TX tx = this.CIG;
        if (tx != null) {
            tx.pA(this.BSW, this.Bzk);
        }
    }

    protected com.bytedance.sdk.openadsdk.BF.Og.ML.pA KZx(int i) {
        return new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.DX
    public void a_(int i) {
        com.bytedance.sdk.component.adexpress.Og.Bzk bzk = this.PV;
        if (bzk != null) {
            if (!this.pA) {
                bzk.omh();
            }
            this.PV.Bzk();
            ((Wx) this.PV).BSW();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ML;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.omh.pA(i), i);
        }
        TX tx = this.CIG;
        if (tx != null) {
            tx.pA(this.BSW, this.Bzk);
        }
    }

    public boolean Wx() {
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        return zZv != null && (zZv instanceof vZF);
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv != null) {
            return zZv.KZx();
        }
        return 0;
    }

    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (!(this.roi instanceof WQf)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (yfo != null) {
                if (yfo.CIG() != null && yfo.CIG().Sn()) {
                    jSONObject.put("engine_version", yfo.CIG().Wx());
                } else if (yfo.FQ() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", "v1");
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public int getRenderEngineCacheType() {
        SGo sGoDX;
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (!(zZv instanceof WQf) || (sGoDX = ((WQf) zZv).DX()) == null) {
            return 0;
        }
        return sGoDX.pA();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.IG).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.lT).intValue();
    }

    public IG getJsObject() {
        WQf wQf = this.fN;
        if (wQf != null) {
            return wQf.oX();
        }
        return null;
    }

    private boolean TV() {
        return TextUtils.equals(this.Bzk, "fullscreen_interstitial_ad") || TextUtils.equals(this.Bzk, "rewarded_video") || TextUtils.equals("open_ad", this.Bzk) || WQf.Og(this.Bzk) || TextUtils.equals(this.Bzk, "embeded_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        Og(Integer.parseInt(String.valueOf(charSequence)), i);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setSoundMute(boolean z) {
        this.TX = z;
        com.bytedance.sdk.component.adexpress.Og.Og og = this.eG;
        if (og != null && og.Og() != null) {
            this.eG.Og().setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) {
            ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) zZv).setSoundMute(z);
        }
    }

    protected void Og(int i, int i2) {
        int iMin;
        if (TextUtils.equals(this.Bzk, "banner_ad")) {
            return;
        }
        int i3 = this.BF;
        int i4 = ((i2 < i3 || i3 < 0 || !(this.WQf || TextUtils.equals(this.Bzk, "open_ad"))) && !((i == 0 && TextUtils.equals(this.Bzk, "open_ad")) || ZZv() == 5)) ? 0 : 1;
        if (i2 <= this.BF) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
            if (yfo != null && yfo.Bf() != null) {
                iMin = (int) (Math.min(this.BF, this.BSW.Bf().JG() * ((double) this.BSW.Bf().TX())) - ((double) i2));
            } else {
                iMin = this.BF - i2;
            }
        } else {
            iMin = 0;
        }
        com.bytedance.sdk.component.adexpress.Og.Og og = this.eG;
        if (og != null && og.Og() != null) {
            this.eG.Og().setTime(String.valueOf(i), i4, iMin, false);
        }
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) {
            ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) zZv).setTime(String.valueOf(i), i4, iMin, false);
        }
    }

    public void Sn() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
        if (yfo == null || yfo.dGZ() == null || this.BSW.dGZ().pA() == null) {
            return;
        }
        this.BSW.dGZ().pA().ML(getVideoProgress());
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.KZx.SD sd) {
        this.Itl = sd;
    }

    public boolean DX() {
        return this.SzT.get();
    }

    public void Og(int i, String str) {
        IG igOX;
        com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv = this.roi;
        if (zZv == null || !(zZv instanceof WQf) || (igOX = ((WQf) zZv).oX()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            igOX.pA("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }
}
