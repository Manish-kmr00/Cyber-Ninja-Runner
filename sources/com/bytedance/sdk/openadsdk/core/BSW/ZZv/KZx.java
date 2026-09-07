package com.bytedance.sdk.openadsdk.core.BSW.ZZv;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.Bzk;
import com.bytedance.adsdk.ugeno.core.SGo;
import com.bytedance.adsdk.ugeno.core.WV;
import com.bytedance.adsdk.ugeno.core.Wx;
import com.bytedance.sdk.component.adexpress.Og.SD;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.component.adexpress.Og.omh;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.core.widget.JG;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class KZx implements WV, Wx, com.bytedance.sdk.component.adexpress.Og.ZZv<View>, com.bytedance.sdk.component.adexpress.dynamic.ZZv {
    private static float IG = 0.0f;
    private static float Mc = 0.0f;
    private static long du = 0;
    private static float eG = 0.0f;
    private static float roi = 0.0f;
    protected static int yFO = 24;
    protected JSONObject BF;
    protected com.bytedance.adsdk.ugeno.Og.KZx BSW;
    protected Sn Bzk;
    protected float DX;
    protected pA JG;
    protected com.bytedance.adsdk.ugeno.Og.KZx<View> KZx;
    protected yFO ML;
    protected Context Og;
    protected FrameLayout SD;
    protected String Sd;
    protected float Sn;
    private final boolean TV;
    private SD WQf;
    protected float WV;
    protected float Wx;
    protected JSONObject ZZv;
    protected long aBv;
    private ZZv lT;
    protected long oX;
    protected omh omh;
    protected Bzk pA;
    private com.bytedance.sdk.openadsdk.core.omh.yFO rB;
    protected WeakReference<View> vZF;
    protected boolean XT = true;
    public SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> TX = new SparseArray<>();
    private String xy = "";
    private final com.bytedance.sdk.component.omh.omh qmB = new com.bytedance.sdk.component.omh.omh("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx.1
        @Override // java.lang.Runnable
        public void run() {
            KZx kZx = KZx.this;
            kZx.ZZv = kZx.pA();
            if (KZx.this.rB == null) {
                KZx.this.xy = "expressView is null";
            } else {
                KZx kZx2 = KZx.this;
                kZx2.xy = kZx2.rB.getUgenTemplateErrorReason();
            }
            com.bytedance.sdk.openadsdk.core.Sn.KZx().post(KZx.this.gbA);
        }
    };
    private final Runnable gbA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx.2
        @Override // java.lang.Runnable
        public void run() {
            if (KZx.this.WQf != null) {
                KZx kZx = KZx.this;
                kZx.Og(kZx.WQf);
            }
        }
    };
    private boolean Vgu = false;
    protected AtomicBoolean SGo = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void onvideoComplate() {
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTimeUpdate(int i) {
    }

    static {
        if (aBv.pA() != null) {
            yFO = aBv.Og();
        }
    }

    public KZx(Context context, yFO yfo, boolean z, pA pAVar, ViewGroup viewGroup) {
        this.Og = context;
        this.TV = z;
        this.pA = new Bzk(context);
        this.ML = yfo;
        this.JG = pAVar;
        this.SD = new FrameLayout(context);
        if (viewGroup instanceof com.bytedance.sdk.openadsdk.core.omh.yFO) {
            this.rB = (com.bytedance.sdk.openadsdk.core.omh.yFO) viewGroup;
        }
        this.Sd = pAVar.ZZv();
        this.BF = Og();
        this.lT = new ZZv(this.Og, this.ML, this.Sd, this.BF);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(SD sd) {
        this.WQf = sd;
        xy.Og(this.qmB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(SD sd) {
        this.JG.Mc().pA();
        if (this.ZZv == null) {
            sd.pA(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen template is null real reason is " + this.xy);
            return;
        }
        if (this.BF == null) {
            sd.pA(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen data is null");
            return;
        }
        int iZZv = ZZv();
        if (this.pA.pA()) {
            List<String> listOg = this.pA.Og();
            if (listOg == null) {
                sd.pA(138, "unknow widget");
                return;
            } else {
                sd.pA(138, "unknow widget;" + listOg.toString());
                return;
            }
        }
        if (iZZv != 0) {
            sd.pA(iZZv, "ugen render fail");
            return;
        }
        if (this.KZx != null) {
            Og og = new Og();
            this.Bzk = og;
            og.pA(true);
            this.Bzk.pA(KZx());
            setSoundMute(this.TV);
            omh();
            com.bytedance.adsdk.ugeno.Og.KZx kZxJG = JG();
            this.BSW = kZxJG;
            if (kZxJG != null && (kZxJG instanceof com.bytedance.sdk.openadsdk.core.BSW.Og.pA.Og)) {
                ((Og) this.Bzk).pA((FrameLayout) ((com.bytedance.sdk.openadsdk.core.BSW.Og.pA.Og) kZxJG).dmv());
            }
            com.bytedance.adsdk.ugeno.Og.KZx kZxSD = SD();
            ZZv zZv = this.lT;
            if (zZv != null) {
                zZv.pA();
            }
            if (kZxSD != null && kZxSD.Bzk() != null) {
                this.vZF = new WeakReference<>(kZxSD.Bzk());
            }
            this.SD.addView(this.KZx.Bzk(), new FrameLayout.LayoutParams(this.KZx.rB(), this.KZx.xy()));
            float fDu = this.JG.du();
            float fEG = this.JG.eG();
            float fKZx = Vgu.KZx(this.Og, fDu);
            float fKZx2 = Vgu.KZx(this.Og, fEG);
            if (KZx() != 7) {
                this.SD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else if (fEG <= 0.0f) {
                this.SD.setLayoutParams(new FrameLayout.LayoutParams((int) fKZx, -2));
            } else {
                this.SD.setLayoutParams(new FrameLayout.LayoutParams((int) fKZx, (int) fKZx2));
            }
            if (fEG <= 0.0f || fDu <= 0.0f) {
                this.SD.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iZZv2 = Vgu.ZZv(this.Og, this.SD.getMeasuredWidth());
                int iZZv3 = Vgu.ZZv(this.Og, this.SD.getMeasuredHeight());
                this.Bzk.pA(iZZv2);
                this.Bzk.Og(iZZv3);
            } else {
                this.Bzk.pA(fDu);
                this.Bzk.Og(fEG);
            }
            if (this.SGo.get()) {
                sd.pA(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "ugen render timeout");
                return;
            } else {
                sd.pA(this.SD, this.Bzk);
                return;
            }
        }
        sd.pA(138, "ugen render error");
    }

    protected JSONObject pA() {
        return this.JG.KZx();
    }

    protected JSONObject Og() {
        return this.JG.roi();
    }

    protected int ZZv() {
        this.pA.pA((WV) this);
        this.pA.pA((Wx) this);
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZxPA = this.pA.pA(this.ZZv);
        this.KZx = kZxPA;
        ZZv zZv = this.lT;
        if (zZv != null && kZxPA != null) {
            zZv.pA(kZxPA);
        }
        this.JG.Mc().Og();
        this.JG.Mc().KZx();
        this.pA.Og(this.BF);
        return 0;
    }

    public void pA(boolean z) {
        this.SGo.set(z);
    }

    public void pA(omh omhVar) {
        this.omh = omhVar;
    }

    public void pA(JG jg) {
        ZZv zZv = this.lT;
        if (zZv != null) {
            zZv.pA(jg);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.WV
    public void pA(SGo sGo, WV.Og og, WV.pA pAVar) {
        if (sGo == null) {
            return;
        }
        if (sGo.Og() == 1 || sGo.Og() == 4) {
            pA(sGo);
        }
        if (sGo.Og() == 10) {
            pA(sGo.KZx());
        }
        if (og == null || sGo.ZZv() == null) {
            return;
        }
        og.pA(sGo.ZZv());
    }

    private void pA(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx;
        if (this.KZx == null || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(strOptString2) || (KZx = this.KZx.KZx(strOptString2)) == 0) {
            return;
        }
        if (TextUtils.equals(strOptString, "onShow")) {
            KZx.KZx(0);
        } else if (TextUtils.equals(strOptString, "onDismiss")) {
            KZx.KZx(8);
        }
    }

    private void pA(SGo sGo) {
        JSONObject jSONObjectZZv;
        boolean zPA;
        int i;
        ZZv zZv;
        ZZv zZv2;
        ZZv zZv3;
        if (this.omh == null) {
            return;
        }
        String strOptString = sGo.KZx().optString("type");
        if ("swiperLeft".equals(strOptString) && (zZv3 = this.lT) != null) {
            zZv3.Og();
            return;
        }
        if ("swiperRight".equals(strOptString) && (zZv2 = this.lT) != null) {
            zZv2.KZx();
            return;
        }
        if (!"swiperClick".equals(strOptString) || (zZv = this.lT) == null) {
            jSONObjectZZv = null;
            zPA = false;
            i = 0;
        } else {
            zPA = zZv.pA(sGo);
            jSONObjectZZv = this.lT.ZZv();
            i = 2;
        }
        strOptString.hashCode();
        switch (strOptString) {
            case "privacy":
                i = 7;
                break;
            case "feedback":
                i = 3;
                break;
            case "mute":
                i = 5;
                break;
            case "skip":
                i = 6;
                break;
            case "video":
                i = 4;
                break;
            case "creative":
                i = 2;
                break;
        }
        com.bytedance.adsdk.ugeno.Og.KZx kZxPA = sGo.pA();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.vZF;
        if (weakReference != null) {
            int[] iArrPA = Vgu.pA(weakReference.get());
            if (iArrPA != null) {
                iArr = iArrPA;
            }
            int[] iArrKZx = Vgu.KZx(this.vZF.get());
            if (iArrKZx != null) {
                iArr2 = iArrKZx;
            }
        }
        this.omh.pA(sGo.pA().Bzk(), i, new com.bytedance.sdk.openadsdk.core.model.Sn.pA().ZZv(this.WV).KZx(this.Wx).Og(this.Sn).pA(this.DX).Og(this.oX).pA(this.aBv).KZx(iArr[0]).ZZv(iArr[1]).ML(iArr2[0]).JG(iArr2[1]).pA(this.TX).pA(sGo.Og() != 1 || this.XT).pA(kZxPA == null ? "" : kZxPA.lT() + "_" + kZxPA.IG()).Og(zPA).Og(jSONObjectZZv).pA());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x00af  */
    @Override // com.bytedance.adsdk.ugeno.core.Wx
    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        int i2 = 1;
        if (action != 0) {
            int i3 = -1;
            if (action == 1) {
                this.Sn = motionEvent.getRawX();
                this.DX = motionEvent.getRawY();
                if (Math.abs(this.Sn - this.WV) < yFO || Math.abs(this.DX - this.Wx) >= yFO) {
                    this.XT = false;
                }
                this.aBv = System.currentTimeMillis();
            } else if (action == 2) {
                Mc += Math.abs(motionEvent.getX() - eG);
                IG += Math.abs(motionEvent.getY() - roi);
                eG = motionEvent.getX();
                roi = motionEvent.getY();
                if (System.currentTimeMillis() - du > 200) {
                    float f = Mc;
                    int i4 = yFO;
                    if (f <= i4 && IG <= i4) {
                        i2 = 2;
                    }
                } else {
                    i2 = 2;
                }
                if (Math.abs(motionEvent.getRawX() - this.WV) >= yFO || Math.abs(motionEvent.getRawY() - this.Wx) >= yFO) {
                    this.XT = false;
                }
                i3 = i2;
                this.Sn = motionEvent.getRawX();
                this.DX = motionEvent.getRawY();
                if (Math.abs(this.Sn - this.WV) < yFO) {
                    this.XT = false;
                } else {
                    this.XT = false;
                }
                this.aBv = System.currentTimeMillis();
            }
            i = i3;
        } else {
            this.oX = System.currentTimeMillis();
            this.WV = motionEvent.getRawX();
            this.Wx = motionEvent.getRawY();
            this.XT = true;
            du = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(motionEvent);
            i = 0;
        }
        this.TX.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.Og.KZx.pA(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.KZx == null) {
            return;
        }
        boolean z2 = i == 1;
        pA(charSequence, z2, i2, z);
        Og(charSequence, z2, i2, z);
    }

    private void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx;
        int i2;
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZx = this.KZx;
        if (kZx == null || (KZx = kZx.KZx("countdown")) == 0) {
            return;
        }
        View viewBzk = KZx.Bzk();
        if (viewBzk instanceof TextView) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.WV.pA("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.Vgu) {
                viewBzk.setVisibility(8);
                return;
            }
            viewBzk.setVisibility(0);
            if (!z && this.JG.pA() && com.bytedance.sdk.component.adexpress.ZZv.SD.Og(this.JG.ZZv())) {
                ((TextView) viewBzk).setText(String.format(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip"), Integer.valueOf(i)));
            } else if (!"open_ad".equals(this.JG.ZZv()) && this.JG.pA()) {
                this.Vgu = true;
                viewBzk.setVisibility(8);
            } else {
                ((TextView) viewBzk).setText(((Object) charSequence) + "s");
            }
        }
    }

    private void Og(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx;
        View viewBzk;
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZx = this.KZx;
        if (kZx == null || (KZx = kZx.KZx(EventConstants.SKIP)) == 0 || (viewBzk = KZx.Bzk()) == null) {
            return;
        }
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        viewBzk.setVisibility(i2);
    }

    private void omh() {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx;
        if (this.KZx == null) {
            return;
        }
        if (this.ML.rX() && (KZx = this.KZx.KZx("tvskip")) != 0) {
            KZx.KZx(8);
        }
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx2 = this.KZx.KZx(EventConstants.SKIP);
        if (KZx2 != 0 && (KZx2 instanceof com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx)) {
            if (!oX.vkV().Sn(String.valueOf(this.ML.Wf())) || this.ML.aBv() == 5 || this.ML.aBv() == 6 || this.ML.FHA() == 3) {
                ((com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx) KZx2).omh("local://tt_close_btn");
                KZx2.Og();
            }
        }
    }

    protected com.bytedance.adsdk.ugeno.Og.KZx JG() {
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZx = this.KZx;
        if (kZx == null) {
            return null;
        }
        return kZx.KZx("video");
    }

    protected com.bytedance.adsdk.ugeno.Og.KZx SD() {
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZx = this.KZx;
        if (kZx == null) {
            return null;
        }
        return kZx.KZx("feedback");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.Og.KZx<T> KZx;
        com.bytedance.adsdk.ugeno.Og.KZx<View> kZx = this.KZx;
        if (kZx == null || (KZx = kZx.KZx("mute")) == 0) {
            return;
        }
        if (z) {
            ((com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx) KZx).omh("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.Bzk.ZZv.KZx) KZx).omh("local://tt_reward_full_unmute");
        }
        KZx.Og();
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public View ML() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public int KZx() {
        return this.ML.du();
    }
}
