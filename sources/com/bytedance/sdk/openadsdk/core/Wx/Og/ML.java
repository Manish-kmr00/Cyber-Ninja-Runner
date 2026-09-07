package com.bytedance.sdk.openadsdk.core.Wx.Og;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.ML.BSW;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.XT.pA.pA.SD;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.core.widget.XT;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ML implements com.bykv.vk.openvk.pA.pA.pA.JG.pA, com.bykv.vk.openvk.pA.pA.pA.ZZv.Og<yFO>, TV.pA, com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA, XT.pA, com.bytedance.sdk.openadsdk.core.widget.yFO.Og {
    int BF;
    ImageView BSW;
    View Bzk;
    private final String CIG;
    TextView DX;
    com.bytedance.sdk.openadsdk.XT.pA.pA.JG IG;
    View JG;
    ViewGroup KZx;
    ImageView ML;
    boolean Mc;
    protected final int Og;
    View SD;
    View SGo;
    boolean Sd;
    TextView Sn;
    yFO TV;
    boolean TX;
    private long Vgu;
    int WQf;
    View WV;
    com.bytedance.sdk.openadsdk.core.widget.pA Wx;
    int XT;
    com.bykv.vk.openvk.pA.pA.pA.JG.Og ZZv;
    int aBv;
    Context du;
    com.bytedance.sdk.openadsdk.core.widget.yFO eG;
    private JG.pA gbA;
    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx lT;
    TextView oX;
    ImageView omh;
    protected final int pA;
    boolean qmB;
    com.bytedance.sdk.openadsdk.core.Og.pA rB;
    pA roi;
    int vZF;
    com.bytedance.sdk.openadsdk.core.Og.pA xy;
    int yFO;

    public void JG() {
    }

    public void KZx(boolean z) {
    }

    public void ML() {
    }

    public void Og(ViewGroup viewGroup) {
    }

    public void Og(boolean z) {
    }

    public boolean Og(int i) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.yFO.Og
    public boolean SGo() {
        return false;
    }

    public void pA(int i) {
    }

    public void pA(long j) {
    }

    public void pA(long j, long j2) {
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.XT.pA
    public void pA(View view, boolean z) {
    }

    public void pA(ViewGroup viewGroup) {
    }

    public void pA(String str) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public /* bridge */ /* synthetic */ void pA(yFO yfo, WeakReference weakReference, boolean z) {
        pA2(yfo, (WeakReference<Context>) weakReference, z);
    }

    public ML(Context context, ViewGroup viewGroup, boolean z, int i, yFO yfo, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx, boolean z2) {
        this.pA = 228;
        this.Og = 160;
        this.Sd = true;
        this.Mc = true;
        this.qmB = true;
        this.CIG = Build.MODEL;
        if (this instanceof ZZv) {
            return;
        }
        this.du = aBv.pA().getApplicationContext();
        ZZv(z2);
        this.KZx = viewGroup;
        this.Sd = z;
        this.WQf = i;
        this.lT = kZx;
        this.TV = yfo;
        ZZv(8);
        pA(context, this.KZx);
        ZZv();
        WV();
    }

    public ML(Context context, ViewGroup viewGroup, boolean z, int i, yFO yfo, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx) {
        this(context, viewGroup, z, i, yfo, kZx, true);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    void WV() {
        String str;
        int i;
        String str2;
        int i2;
        com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg;
        com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg2;
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar;
        String str3 = this.Mc ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.TV.kK()) {
            str2 = "rewarded_video";
            i2 = 7;
        } else if (this.TV.EC()) {
            str2 = "fullscreen_interstitial_ad";
            i2 = 5;
        } else {
            if (this.TV.LhC()) {
                str2 = "banner_ad";
                i2 = 2;
            } else {
                str = str3;
                i = 1;
            }
            if (this.TV.JBA() == 4) {
                this.IG = SD.pA(this.du, this.TV, str);
            }
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.core.Og.pA(this.du, this.TV, str, i);
            this.rB = pAVar2;
            pAVar2.pA(this);
            this.rB.Og(true);
            if (this.Mc) {
                this.rB.pA(true);
            } else {
                this.rB.pA(false);
                this.rB.KZx(true);
            }
            this.rB.pA(this.lT);
            this.rB.ML(true);
            this.rB.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.1
                @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
                public void pA(View view, int i3) {
                    if (ML.this.gbA != null) {
                        ML.this.gbA.pA(view, i3);
                    }
                }
            });
            jg = this.IG;
            if (jg != null && (pAVar = this.rB) != null) {
                pAVar.pA(jg);
            }
            if (TV()) {
                com.bytedance.sdk.openadsdk.core.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.core.Og.pA(this.du, this.TV, str, i) { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.2
                    @Override // com.bytedance.sdk.openadsdk.core.Og.pA
                    public boolean Og() {
                        boolean zPA = ML.this.eG != null ? ML.this.eG.pA() : false;
                        ML.this.ML.getVisibility();
                        return zPA || ML.this.ML.getVisibility() == 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.Og.pA
                    public boolean KZx() {
                        if (ML.this.SGo != null && ML.this.SGo.getVisibility() == 0) {
                            return true;
                        }
                        if (ML.this.WV != null && ML.this.WV.getVisibility() == 0) {
                            return true;
                        }
                        if (ML.this.Wx == null || ML.this.Wx.getVisibility() != 0) {
                            return ML.this.Sn != null && ML.this.Sn.getVisibility() == 0;
                        }
                        return true;
                    }
                };
                this.xy = pAVar3;
                pAVar3.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.3
                    @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
                    public void pA(View view, int i3) {
                        if (ML.this.gbA != null) {
                            ML.this.gbA.pA(view, i3);
                        }
                    }
                });
                this.xy.Og(true);
                this.xy.pA(this.Mc);
                this.xy.pA(this.lT);
                this.xy.ML(true);
                jg2 = this.IG;
                if (jg2 != null) {
                    this.xy.pA(jg2);
                }
                this.xy.pA(this);
            }
        }
        str = str2;
        i = i2;
        if (this.TV.JBA() == 4) {
            this.IG = SD.pA(this.du, this.TV, str);
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar4 = new com.bytedance.sdk.openadsdk.core.Og.pA(this.du, this.TV, str, i);
        this.rB = pAVar4;
        pAVar4.pA(this);
        this.rB.Og(true);
        if (this.Mc) {
            this.rB.pA(true);
        } else {
            this.rB.pA(false);
            this.rB.KZx(true);
        }
        this.rB.pA(this.lT);
        this.rB.ML(true);
        this.rB.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.1
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i3) {
                if (ML.this.gbA != null) {
                    ML.this.gbA.pA(view, i3);
                }
            }
        });
        jg = this.IG;
        if (jg != null) {
            pAVar.pA(jg);
        }
        if (TV()) {
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar5 = new com.bytedance.sdk.openadsdk.core.Og.pA(this.du, this.TV, str, i) { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.2
                @Override // com.bytedance.sdk.openadsdk.core.Og.pA
                public boolean Og() {
                    boolean zPA = ML.this.eG != null ? ML.this.eG.pA() : false;
                    ML.this.ML.getVisibility();
                    return zPA || ML.this.ML.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.Og.pA
                public boolean KZx() {
                    if (ML.this.SGo != null && ML.this.SGo.getVisibility() == 0) {
                        return true;
                    }
                    if (ML.this.WV != null && ML.this.WV.getVisibility() == 0) {
                        return true;
                    }
                    if (ML.this.Wx == null || ML.this.Wx.getVisibility() != 0) {
                        return ML.this.Sn != null && ML.this.Sn.getVisibility() == 0;
                    }
                    return true;
                }
            };
            this.xy = pAVar5;
            pAVar5.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.3
                @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
                public void pA(View view, int i3) {
                    if (ML.this.gbA != null) {
                        ML.this.gbA.pA(view, i3);
                    }
                }
            });
            this.xy.Og(true);
            this.xy.pA(this.Mc);
            this.xy.pA(this.lT);
            this.xy.ML(true);
            jg2 = this.IG;
            if (jg2 != null) {
                this.xy.pA(jg2);
            }
            this.xy.pA(this);
        }
    }

    private boolean TV() {
        return yFO.ML(this.TV) && (!com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.TV.du()) ? this.TV.CIG() == null : this.TV.FQ() == null) && this.TV.TV() == 1;
    }

    public void pA(JG.pA pAVar) {
        this.gbA = pAVar;
    }

    public void pA(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = this.rB;
        if (pAVar != null) {
            pAVar.pA(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar2 = this.xy;
        if (pAVar2 != null) {
            pAVar2.pA(pAGNativeAd);
        }
    }

    public com.bykv.vk.openvk.pA.pA.pA.JG.Og Wx() {
        return this.ZZv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void pA(Context context, View view) {
        View kZx;
        System.currentTimeMillis();
        yFO yfo = this.TV;
        if ((yfo == null || ((!yfo.juv() && !this.TV.LhC()) || oX.vkV().rjD())) && view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx2 = this.lT;
        if (kZx2 != null && kZx2.aBv()) {
            kZx = new com.bykv.vk.openvk.pA.pA.pA.JG.ZZv(this.du);
        } else {
            kZx = new com.bykv.vk.openvk.pA.pA.pA.JG.KZx(this.du);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(kZx, 0, layoutParams);
        }
        Vgu.pA(kZx, 8);
        this.ZZv = (com.bykv.vk.openvk.pA.pA.pA.JG.Og) kZx;
        this.ML = (ImageView) view.findViewById(Sn.lgT);
        this.JG = view.findViewById(Sn.ka);
        this.SD = view.findViewById(Sn.bA);
        this.omh = (ImageView) view.findViewById(Sn.uhO);
        this.Bzk = view.findViewById(Sn.Xj);
        System.currentTimeMillis();
    }

    void pA(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.Bzk) == null || view2.getParent() == null || this.SGo != null) {
            return;
        }
        this.SGo = this.Bzk;
        this.BSW = (ImageView) view.findViewById(Sn.PU);
        this.WV = view.findViewById(Sn.vkV);
        this.Wx = (com.bytedance.sdk.openadsdk.core.widget.pA) view.findViewById(Sn.FQ);
        this.Sn = (TextView) view.findViewById(Sn.Gx);
        this.DX = (TextView) view.findViewById(Sn.Bf);
        this.oX = (TextView) view.findViewById(Sn.HSv);
    }

    void Sn() {
        if (this.roi == null || this.eG != null) {
            return;
        }
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.widget.yFO yfo = new com.bytedance.sdk.openadsdk.core.widget.yFO();
        this.eG = yfo;
        yfo.pA(this.du, this.KZx);
        this.eG.pA(this.roi, this);
        System.currentTimeMillis();
    }

    public boolean pA(int i, com.bykv.vk.openvk.pA.pA.pA.KZx.Og og, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.yFO yfo = this.eG;
        return yfo == null || yfo.pA(i, og, z);
    }

    public void DX() {
        com.bytedance.sdk.openadsdk.core.widget.yFO yfo = this.eG;
        if (yfo != null) {
            yfo.pA(false);
        }
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.pA pAVar) {
        if (pAVar instanceof pA) {
            this.roi = (pA) pAVar;
            Sn();
        }
    }

    boolean oX() {
        if (this.roi != null) {
            return true;
        }
        WV.pA("NewLiveViewLayout", "callback is null");
        return false;
    }

    void ZZv() {
        this.ZZv.pA(this);
        this.ML.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/ML$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_ML$4_onClick_0b015bf22d7c2e8dc26362edb0b56581(view);
            }

            public void safedk_ML$4_onClick_0b015bf22d7c2e8dc26362edb0b56581(View p0) {
                if (ML.this.oX()) {
                    if (ML.this.oX == null || ML.this.oX.getVisibility() != 0) {
                        ML.this.roi.pA(ML.this, p0);
                    }
                }
            }
        });
    }

    public void KZx(int i) {
        Vgu.pA((View) this.KZx, 0);
        com.bykv.vk.openvk.pA.pA.pA.JG.Og og = this.ZZv;
        if (og != null) {
            og.setVisibility(i);
        }
    }

    public void ZZv(boolean z) {
        this.Mc = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar = this.rB;
            if (pAVar != null) {
                pAVar.pA(true);
            }
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar2 = this.xy;
            if (pAVar2 != null) {
                pAVar2.pA(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar3 = this.rB;
        if (pAVar3 != null) {
            pAVar3.pA(false);
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar4 = this.xy;
        if (pAVar4 != null) {
            pAVar4.pA(false);
        }
    }

    public void pA(int i, int i2) {
        if (i == -1) {
            i = Vgu.KZx(this.du);
        }
        if (i <= 0) {
            return;
        }
        this.aBv = i;
        if (Sd() || SGo() || (this.WQf & 8) == 8) {
            this.XT = i2;
        } else {
            this.XT = ML(i);
        }
        Og(this.aBv, this.XT);
    }

    public void Og(boolean z, boolean z2) {
        ImageView imageView = this.ML;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(Bzk.pA(this.du, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(Bzk.pA(this.du, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void Og(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.KZx.getLayoutParams();
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.KZx.setLayoutParams(layoutParams);
    }

    private int ML(int i) {
        if (this.yFO <= 0 || this.vZF <= 0) {
            return 0;
        }
        int iKZx = Vgu.KZx(this.du, 228.0f);
        int iKZx2 = Vgu.KZx(this.du, 160.0f);
        int i2 = (int) (this.vZF * ((i * 1.0f) / this.yFO));
        if (i2 > iKZx) {
            return iKZx;
        }
        return i2 < iKZx2 ? iKZx2 : i2;
    }

    public void KZx(int i, int i2) {
        this.yFO = i;
        this.vZF = i2;
    }

    public void KZx(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.KZx.getParent() == null) {
            viewGroup.addView(this.KZx);
        }
        ZZv(0);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public View KZx() {
        return this.KZx;
    }

    public void SD() {
        yFO yfo;
        Vgu.JG(this.JG);
        Vgu.JG(this.SD);
        if (this.omh != null && (yfo = this.TV) != null && yfo.Bf() != null && this.TV.Bf().SGo() != null) {
            Vgu.JG(this.omh);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.Bf().SGo(), this.TV.Bf().KZx(), this.TV.Bf().Og(), this.omh, this.TV);
        }
        if (this.ML.getVisibility() == 0) {
            Vgu.pA((View) this.ML, 8);
        }
    }

    public void aBv() {
        Vgu.JG(this.JG);
        Vgu.JG(this.SD);
        if (this.ML.getVisibility() == 0) {
            Vgu.pA((View) this.ML, 8);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public void pA() {
        pA(false, this.Sd);
        yFO();
    }

    public void XT() {
        Vgu.pA((View) this.KZx, 0);
        com.bykv.vk.openvk.pA.pA.pA.JG.Og og = this.ZZv;
        if (og != null) {
            Vgu.pA(og.getView(), 0);
        }
    }

    void yFO() {
        try {
            Vgu.pA(this.SGo, 8);
            Vgu.pA((View) this.BSW, 8);
            Vgu.pA(this.WV, 8);
            Vgu.pA((View) this.Wx, 8);
            Vgu.pA((View) this.Sn, 8);
            Vgu.pA((View) this.DX, 8);
            Vgu.pA((View) this.oX, 8);
        } catch (Exception unused) {
        }
    }

    public void vZF() {
        ImageView imageView = this.BSW;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        com.bytedance.sdk.openadsdk.core.widget.pA pAVar = this.Wx;
        if (pAVar != null) {
            pAVar.setImageBitmap(null);
        }
    }

    private void JG(int i) {
        Vgu.pA(this.WV, i);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public void pA(boolean z) {
        this.qmB = z;
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0218  */
    /* JADX INFO: renamed from: pA, reason: avoid collision after fix types in other method */
    public void pA2(final yFO yfo, WeakReference<Context> weakReference, boolean z) {
        String strFw;
        yFO yfo2;
        yFO yfo3;
        if (yfo == null) {
            return;
        }
        pA(false, this.Sd);
        pA(this.KZx, aBv.pA());
        View view = this.SGo;
        if (view != null) {
            Vgu.pA(view, 0);
        }
        ImageView imageView = this.BSW;
        if (imageView != null) {
            Vgu.pA((View) imageView, 0);
        }
        Vgu.pA(this.WV, 0);
        if (this.BSW != null && (yfo3 = this.TV) != null && yfo3.Bf() != null && this.TV.Bf().SGo() != null) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.Bf().SGo(), this.TV.Bf().KZx(), this.TV.Bf().Og(), this.BSW, yfo);
        }
        if (!TextUtils.isEmpty(yfo.HSv())) {
            strFw = yfo.HSv();
        } else if (!TextUtils.isEmpty(yfo.SXO())) {
            strFw = yfo.SXO();
        } else if (TextUtils.isEmpty(yfo.fw())) {
            strFw = "";
        } else {
            strFw = yfo.fw();
        }
        if (this.Wx != null && (yfo2 = this.TV) != null && yfo2.fJy() != null && this.TV.fJy().pA() != null) {
            Vgu.pA((View) this.Wx, 0);
            Vgu.pA((View) this.Sn, 4);
            yFO yfo4 = this.TV;
            if (yfo4 != null && yfo4.rjD()) {
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(this.TV.fJy()).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, this.TV.fJy().pA(), new com.bytedance.sdk.component.ML.oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.5
                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(BSW<Bitmap> bsw) {
                        if (bsw == null || bsw.Og() == null) {
                            return;
                        }
                        if (ML.this.Wx != null) {
                            ML.this.Wx.setImageBitmap(bsw.Og());
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(ML.this.TV, ML.this.TV != null ? gbA.KZx(yfo.PKZ()) : null, "load_vast_icon_success", (JSONObject) null);
                    }

                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(int i, String str, Throwable th) {
                        ML.this.pA(i, str, yfo);
                    }
                }));
                if (this.TV.dGZ() != null && this.TV.dGZ().Og() != null) {
                    this.TV.dGZ().Og().Og(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.TV.fJy(), this.Wx, yfo);
            }
            yFO yfo5 = this.TV;
            if (yfo5 != null && yfo5.rjD()) {
                try {
                    this.Wx.setTag(570425345, "VAST_ICON");
                } catch (Throwable unused) {
                }
            }
            yFO yfo6 = this.TV;
            if (yfo6 != null && yfo6.dGZ() != null && this.TV.dGZ().Og() != null) {
                final com.bytedance.sdk.openadsdk.core.WV.Og Og = this.TV.dGZ().Og();
                com.bytedance.sdk.openadsdk.core.widget.pA pAVar = this.Wx;
                if (pAVar != null) {
                    pAVar.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.6
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.WV.Og og;
                            if (ML.this.Wx == null || !ML.this.Wx.isShown() || (og = Og) == null) {
                                return;
                            }
                            og.Og(ML.this.getVideoProgress());
                        }
                    });
                }
            }
            if (TV()) {
                this.Wx.setOnClickListener(this.xy);
                this.Wx.setOnTouchListener(this.xy);
            } else {
                this.Wx.setOnClickListener(this.rB);
                this.Wx.setOnTouchListener(this.rB);
            }
        } else if (!TextUtils.isEmpty(strFw)) {
            Vgu.pA((View) this.Wx, 4);
            Vgu.pA((View) this.Sn, 0);
            TextView textView = this.Sn;
            if (textView != null) {
                textView.setText(strFw.substring(0, 1));
                if (TV()) {
                    this.Sn.setOnClickListener(this.xy);
                    this.Sn.setOnTouchListener(this.xy);
                } else {
                    this.Sn.setOnClickListener(this.rB);
                    this.Sn.setOnTouchListener(this.rB);
                }
            }
        }
        if (this.DX != null && !TextUtils.isEmpty(strFw)) {
            this.DX.setText(strFw);
            this.DX.setTag(570425345, "VAST_TITLE");
        }
        Vgu.pA((View) this.DX, 0);
        Vgu.pA((View) this.oX, 0);
        String strGy = yfo.gy();
        if (TextUtils.isEmpty(strGy)) {
            int iJBA = yfo.JBA();
            if (iJBA == 2 || iJBA == 3) {
                strGy = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_mobile_go_detail");
            } else if (iJBA == 4) {
                strGy = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_download_apk");
            } else if (iJBA == 5) {
                strGy = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_dial_phone");
            } else if (iJBA == 8) {
                strGy = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_mobile_go_detail");
            } else {
                strGy = com.bytedance.sdk.component.utils.yFO.pA(this.du, "tt_video_mobile_go_detail");
            }
        }
        TextView textView2 = this.oX;
        if (textView2 != null) {
            textView2.setText(strGy);
            this.oX.setOnClickListener(this.rB);
            this.oX.setOnTouchListener(this.rB);
        }
        if (this.qmB) {
            return;
        }
        JG(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final int i, final String str, final yFO yfo) {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new omh("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.ML.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i);
                    jSONObject.put("description", i + ":" + str);
                    jSONObject.put("url", ML.this.TV.fJy().pA());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(ML.this.TV, ML.this.TV != null ? gbA.KZx(yfo.PKZ()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public void Og() {
        Vgu.ML(this.JG);
        Vgu.ML(this.SD);
        ImageView imageView = this.omh;
        if (imageView != null) {
            Vgu.ML(imageView);
        }
    }

    public void omh() {
        Vgu.ML(this.JG);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.pA
    public void pA(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.ZZv.getHolder()) {
            return;
        }
        this.TX = true;
        if (oX()) {
            this.roi.pA(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.pA
    public void pA(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.ZZv.getHolder()) {
            return;
        }
        oX();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.pA
    public void Og(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.ZZv.getHolder()) {
            return;
        }
        this.TX = false;
        if (oX()) {
            this.roi.Og(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.pA
    public void pA(SurfaceTexture surfaceTexture, int i, int i2) {
        this.TX = true;
        if (oX()) {
            this.roi.pA(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.pA
    public boolean pA(SurfaceTexture surfaceTexture) {
        this.TX = false;
        if (!oX()) {
            return true;
        }
        this.roi.Og(this, surfaceTexture);
        return true;
    }

    public void Bzk() {
        ZZv(8);
        if (WQf()) {
            this.ZZv.setVisibility(8);
        }
        ImageView imageView = this.omh;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ZZv(8);
        Vgu.pA(this.SGo, 8);
        Vgu.pA((View) this.BSW, 8);
        Vgu.pA(this.WV, 8);
        Vgu.pA((View) this.Wx, 8);
        Vgu.pA((View) this.Sn, 8);
        Vgu.pA((View) this.DX, 8);
        com.bytedance.sdk.openadsdk.core.widget.yFO yfo = this.eG;
        if (yfo != null) {
            yfo.pA(true);
        }
    }

    public boolean Sd() {
        return this.Sd;
    }

    public void pA(boolean z, boolean z2, boolean z3) {
        Vgu.pA((View) this.ML, (!z || this.JG.getVisibility() == 0) ? 8 : 0);
    }

    public void pA(boolean z, boolean z2) {
        Vgu.pA((View) this.ML, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.yFO.Og
    public void BSW() {
        pA(true, false);
    }

    public boolean TX() {
        return this.TX;
    }

    public void ZZv(int i) {
        this.BF = i;
        Vgu.pA((View) this.KZx, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.XT.pA
    public boolean BF() {
        com.bytedance.sdk.openadsdk.core.widget.yFO yfo = this.eG;
        return yfo != null && yfo.pA();
    }

    boolean WQf() {
        return (this.WQf & 4) != 4 || this.Sd;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.Og
    public void pA(Drawable drawable) {
        ViewGroup viewGroup = this.KZx;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA
    public long getVideoProgress() {
        if (this.Vgu <= 0) {
            yFO yfo = this.TV;
            if (yfo != null && yfo.Bf() != null) {
                this.Vgu = (long) (this.TV.Bf().JG() * 1000.0d);
            }
            com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.lT;
            if (kZx != null) {
                this.Vgu = kZx.omh();
            }
        }
        return this.Vgu;
    }
}
