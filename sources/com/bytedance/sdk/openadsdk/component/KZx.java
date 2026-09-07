package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.ML.omh;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class KZx {
    private com.bytedance.sdk.openadsdk.component.omh.KZx BF;
    protected final com.bytedance.sdk.openadsdk.component.omh.pA BSW;
    protected View Bzk;
    private omh DX;
    protected final int JG;
    protected final boolean KZx;
    protected final com.bytedance.sdk.openadsdk.component.pA ML;
    protected final yFO Og;
    protected int SD;
    protected com.bytedance.sdk.openadsdk.core.ML.ZZv SGo;
    private float Sd;
    private PAGLogoView Sn;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv TV;
    private final com.bytedance.sdk.openadsdk.component.Bzk.omh TX = new com.bytedance.sdk.openadsdk.component.Bzk.omh();
    private omh WQf;
    private RelativeLayout WV;
    private ImageView Wx;
    private omh XT;
    protected final FrameLayout ZZv;
    private aBv aBv;
    private oX du;
    private View eG;
    private ImageView oX;
    protected FrameLayout omh;
    protected final Activity pA;
    private float vZF;
    private omh yFO;

    public void ML() {
    }

    public int ZZv() {
        return -1;
    }

    public JSONObject pA(JSONObject jSONObject) {
        return null;
    }

    public KZx(Activity activity, yFO yfo, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.pA pAVar, int i, boolean z, com.bytedance.sdk.openadsdk.component.omh.pA pAVar2) {
        this.pA = activity;
        this.Og = yfo;
        this.ZZv = frameLayout;
        this.SD = i;
        this.KZx = z;
        this.ML = pAVar;
        this.JG = yfo.Wf();
        this.BSW = pAVar2;
    }

    public void pA(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.component.Bzk.KZx zZv = new com.bytedance.sdk.openadsdk.component.Bzk.ZZv(this.pA);
        int iSn = this.Og.Sn();
        if (iSn == 5) {
            zZv = new com.bytedance.sdk.openadsdk.component.Bzk.JG(this.pA);
        } else if (iSn == 4) {
            zZv = new com.bytedance.sdk.openadsdk.component.Bzk.ML(this.pA, this.Og);
        }
        this.WV = zZv;
        viewGroup.addView(zZv);
        this.oX = zZv.getBackImage();
        this.omh = zZv.getVideoContainer();
        this.Wx = zZv.getImageView();
        this.DX = zZv.getClickButton();
        this.Sn = zZv.getAdLogo();
        this.WQf = zZv.getAdTitleTextView();
        this.TV = zZv.getAdIconView();
        this.du = zZv.getScoreBar();
        this.eG = zZv.getOverlayLayout();
        if (this.Og.zi()) {
            this.aBv = zZv.getIconOnlyView();
            this.XT = zZv.getTitle();
            this.yFO = zZv.getContent();
        }
        if (zZv.getDspAdChoice() != null) {
            zZv.getDspAdChoice().pA(14, this.Og);
        }
        if (!this.Og.qQU()) {
            this.TX.pA(zZv, this.Og, this.Sd, this.vZF, this.KZx);
        }
        this.Bzk = zZv.getTopDisLike();
        this.SGo = zZv.getTopSkip();
        if (zZv instanceof com.bytedance.sdk.openadsdk.component.Bzk.ML) {
            ((com.bytedance.sdk.openadsdk.component.Bzk.ML) zZv).setRenderListener(new com.bytedance.sdk.openadsdk.component.Bzk.ML.pA() { // from class: com.bytedance.sdk.openadsdk.component.KZx.1
                @Override // com.bytedance.sdk.openadsdk.component.Bzk.ML.pA
                public void pA(View view, int i) {
                    KZx.this.ML.ML();
                }
            });
        }
    }

    public void pA() {
        this.Sn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.KZx.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/KZx$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_KZx$2_onClick_062c401c4f7d541db85ba83e0c2c2d42(view);
            }

            public void safedk_KZx$2_onClick_062c401c4f7d541db85ba83e0c2c2d42(View p0) {
                try {
                    TTWebsiteActivity.pA(KZx.this.pA, KZx.this.Og, "open_ad");
                } catch (Throwable th) {
                    WV.pA("AppOpenAdNativeManager", th.getMessage());
                }
            }
        });
        JG();
        if (this.Og.qQU()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.pA.pA pAVarPA = com.bytedance.sdk.openadsdk.component.pA.Og.pA(this.Og, this.pA, this.BSW);
        pAVarPA.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.KZx.3
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                KZx.this.ML.ML();
            }
        });
        pAVarPA.pA(this.BF);
        if (this.Og.Wx() == 1) {
            this.WV.setOnClickListener(pAVarPA);
            this.WV.setOnTouchListener(pAVarPA);
        }
        this.DX.setOnClickListener(pAVarPA);
        this.DX.setOnTouchListener(pAVarPA);
    }

    protected void JG() {
        this.Bzk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.KZx.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/KZx$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_KZx$4_onClick_99489291a8857af29f0c552827682c3e(view);
            }

            public void safedk_KZx$4_onClick_99489291a8857af29f0c552827682c3e(View p0) {
                if (KZx.this.ML != null) {
                    KZx.this.ML.Og(p0);
                }
            }
        });
        this.SGo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.KZx.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/KZx$5;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_KZx$5_onClick_5721da2b41f2291336d0c36407f3177f(view);
            }

            public void safedk_KZx$5_onClick_5721da2b41f2291336d0c36407f3177f(View p0) {
                if (KZx.this.ML != null) {
                    KZx.this.ML.pA(p0);
                }
            }
        });
    }

    public void Og() {
        if (!this.Og.qQU()) {
            omh();
        } else {
            this.ML.KZx();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    private void omh() {
        boolean z;
        this.TX.pA();
        this.DX.setText(this.Og.gy());
        if (this.Og.zi()) {
            Bzk();
            return;
        }
        if (this.KZx) {
            Og(0);
            pA(8);
            if (pA(this.omh)) {
                this.ML.KZx();
            } else {
                this.ML.ZZv();
            }
            JG.pA(this.Og, new pA(this.pA), 25);
        } else {
            Og(8);
            pA(0);
            SGo();
            this.ML.KZx();
        }
        boolean z2 = true;
        if (this.WQf == null) {
            z = false;
        } else {
            if (!TextUtils.isEmpty(this.Og.HSv())) {
                this.WQf.setText(this.Og.HSv());
            } else if (this.Og.Wo() != null) {
                this.WQf.setText(this.Og.Wo().Og());
            } else {
                z = false;
            }
            z = true;
        }
        if (this.TV != null) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.Og.fJy(), this.TV, this.Og);
        }
        oX oXVar = this.du;
        if (oXVar != null) {
            Vgu.pA((TextView) null, oXVar, this.Og);
            if (this.Og.Wo() == null || this.Og.Wo().ZZv() < 0.0d) {
                this.du.setVisibility(8);
                z2 = z;
            }
        } else {
            z2 = z;
        }
        View view = this.eG;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    protected boolean pA(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx = new com.bytedance.sdk.openadsdk.component.omh.KZx(this.pA);
        this.BF = kZx;
        return kZx.pA(frameLayout, this.ML, this.Og);
    }

    private void Og(int i) {
        Vgu.pA((View) this.omh, i);
    }

    private void Bzk() {
        if (this.XT != null) {
            if (this.Og.Wo() != null && !TextUtils.isEmpty(this.Og.Wo().Og())) {
                this.XT.setText(this.Og.Wo().Og());
            } else if (!TextUtils.isEmpty(this.Og.HSv())) {
                this.XT.setText(this.Og.HSv());
            } else {
                this.XT.setVisibility(8);
            }
        }
        if (this.yFO != null) {
            if (!TextUtils.isEmpty(this.Og.SXO())) {
                this.yFO.setText(this.Og.SXO());
            } else {
                this.yFO.setVisibility(8);
            }
        }
        if (this.aBv != null && this.Og.fJy() != null && !TextUtils.isEmpty(this.Og.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.Og.fJy().pA(), this.Og.fJy().Og(), this.Og.fJy().KZx(), this.aBv, this.Og);
        }
        this.ML.KZx();
    }

    private void SGo() {
        DX dx = this.Og.IIF().get(0);
        com.bytedance.sdk.openadsdk.utils.DX.pA(new com.bytedance.sdk.openadsdk.aBv.pA(dx.pA(), dx.SD()), dx.Og(), dx.KZx(), new Og(this), com.bytedance.sdk.openadsdk.component.SD.pA.Og(TextUtils.isEmpty(dx.SD()) ? com.bytedance.sdk.component.utils.ML.pA(dx.pA()) : dx.SD()).getParent(), 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.oX.setImageDrawable(new BitmapDrawable(com.bytedance.sdk.openadsdk.core.aBv.pA().getResources(), bitmap));
            } catch (Throwable unused) {
                WV.pA("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
            }
        }
    }

    void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og) {
        if (og.Og() != null) {
            this.Wx.setImageBitmap(og.Og());
            return;
        }
        if (this.Og.IIF() == null || this.Og.IIF().get(0) == null) {
            return;
        }
        Drawable drawablePA = com.bytedance.sdk.openadsdk.utils.DX.pA(og.KZx(), this.Og.IIF().get(0).Og());
        this.Wx.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.Wx.setImageDrawable(drawablePA);
    }

    void pA(int i) {
        Vgu.pA((View) this.Wx, i);
    }

    public class pA implements JG.ZZv {
        WeakReference<Activity> pA;

        pA(Activity activity) {
            this.pA = new WeakReference<>(activity);
        }

        @Override // com.bytedance.sdk.openadsdk.component.JG.ZZv
        public void pA(Bitmap bitmap) {
            if (this.pA.get() == null || this.pA.get().isFinishing()) {
                return;
            }
            KZx.this.pA(bitmap);
        }
    }

    public void pA(float f, float f2) {
        this.Sd = f;
        this.vZF = f2;
    }

    public void pA(int i, int i2, boolean z) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.SGo;
        if (zZv == null) {
            return;
        }
        int i3 = z ? 0 : 8;
        if (zZv.getVisibility() != i3) {
            this.SGo.setVisibility(i3);
        }
    }

    public com.bytedance.sdk.openadsdk.component.omh.KZx SD() {
        return this.BF;
    }

    public void KZx() {
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx = this.BF;
        if (kZx != null) {
            kZx.BSW();
        }
    }

    public static class Og implements com.bytedance.sdk.openadsdk.utils.DX.pA {
        private final WeakReference<KZx> pA;

        @Override // com.bytedance.sdk.openadsdk.utils.DX.pA
        public void pA() {
        }

        public Og(KZx kZx) {
            this.pA = new WeakReference<>(kZx);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.DX.pA
        public void pA(com.bytedance.sdk.openadsdk.aBv.pA.Og og) {
            KZx kZx;
            if (!og.ZZv() || (kZx = this.pA.get()) == null) {
                return;
            }
            kZx.pA(og);
            if (og.Og() != null) {
                kZx.pA(og.pA());
            }
        }
    }
}
