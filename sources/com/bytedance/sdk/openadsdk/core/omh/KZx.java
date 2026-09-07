package com.bytedance.sdk.openadsdk.core.omh;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.du;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class KZx {
    private int Bzk;
    private int JG;
    private pA KZx;
    private yFO ML;
    private final Context Og;
    private int SD;
    private com.bytedance.sdk.component.adexpress.Og.DX ZZv;
    private ScheduledFuture<?> omh;
    com.bytedance.sdk.openadsdk.core.model.yFO pA;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.omh.KZx$KZx, reason: collision with other inner class name */
    interface InterfaceC0246KZx {
        void Og(String str);

        void pA();

        void pA(int i, int i2);

        void pA(String str);
    }

    public KZx(Context context, yFO yfo, com.bytedance.sdk.openadsdk.core.model.yFO yfo2, String str) {
        this.pA = yfo2;
        this.Og = context;
        this.ML = yfo;
        pA(yfo);
        this.KZx = new pA(context, yfo2, this.JG, this.SD, str, this.Bzk);
    }

    private void pA(yFO yfo) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.pA;
        if (yfo2 != null && yfo2.qH()) {
            this.JG = -1;
            this.SD = -1;
            return;
        }
        aBv abvPA = com.bytedance.sdk.openadsdk.core.KZx.pA.pA(yfo.getExpectExpressWidth(), yfo.getExpectExpressHeight());
        this.Bzk = abvPA.pA;
        if (yfo.getExpectExpressWidth() > 0 && yfo.getExpectExpressHeight() > 0) {
            this.JG = Vgu.KZx(this.Og, yfo.getExpectExpressWidth());
            this.SD = Vgu.KZx(this.Og, yfo.getExpectExpressHeight());
        } else {
            int iKZx = Vgu.KZx(this.Og);
            this.JG = iKZx;
            this.SD = Float.valueOf(iKZx / abvPA.Og).intValue();
        }
        int i = this.JG;
        if (i <= 0 || i <= Vgu.KZx(this.Og)) {
            return;
        }
        float fKZx = Vgu.KZx(this.Og) / this.JG;
        this.JG = Vgu.KZx(this.Og);
        this.SD = Float.valueOf(this.SD * fKZx).intValue();
    }

    public void pA(com.bytedance.sdk.component.adexpress.Og.DX dx) {
        this.ZZv = dx;
    }

    public void pA() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo != null && yfo.qH()) {
            this.omh = xy.pA().schedule(new Og(this.KZx.WV), com.bytedance.sdk.openadsdk.core.aBv.ZZv().eG(), TimeUnit.MILLISECONDS);
        }
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(new com.bytedance.sdk.component.adexpress.Og.SD() { // from class: com.bytedance.sdk.openadsdk.core.omh.KZx.1
                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(View view, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
                    if (KZx.this.ML == null || view == null) {
                        if (KZx.this.ZZv != null) {
                            KZx.this.ZZv.a_(106);
                        }
                    } else if (KZx.this.ZZv != null) {
                        KZx.this.ZZv.pA(KZx.this.KZx, sn);
                    }
                    KZx.this.KZx();
                }

                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(int i, String str) {
                    if (KZx.this.ZZv != null) {
                        KZx.this.ZZv.a_(106);
                    }
                    KZx.this.KZx();
                }
            });
            View viewML = this.KZx.ML();
            this.ML.removeView(viewML);
            if (viewML.getParent() != null) {
                ((ViewGroup) viewML.getParent()).removeView(viewML);
            }
            this.ML.addView(viewML, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        com.bytedance.sdk.component.adexpress.Og.DX dx = this.ZZv;
        if (dx != null) {
            dx.a_(106);
        }
    }

    public void Og() {
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.ZZv();
            this.KZx = null;
        }
        KZx();
        this.ZZv = null;
        this.ML = null;
    }

    public void pA(du duVar) {
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(duVar);
        }
    }

    public void pA(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(tTDislikeDialogAbstract);
        }
    }

    public void pA(String str) {
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(str);
        }
    }

    public void pA(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(pAGExpressAdWrapperListener);
        }
    }

    public static class pA implements com.bytedance.sdk.component.adexpress.Og.ZZv<View>, ML.Og {
        private String BSW;
        private com.bytedance.sdk.openadsdk.core.model.yFO Bzk;
        private PAGExpressAdWrapperListener DX;
        private final int JG;
        private TTDislikeDialogAbstract KZx;
        private final Context ML;
        private com.bytedance.sdk.openadsdk.KZx.KZx Og;
        private final int SD;
        private final int SGo;
        private com.bytedance.sdk.component.adexpress.Og.SD Sn;
        private ML WV;
        private int Wx;
        private String ZZv;
        private FrameLayout omh;
        AtomicBoolean pA = new AtomicBoolean(false);

        @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
        public int KZx() {
            return 5;
        }

        @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
        public View pA() {
            return null;
        }

        public pA(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, int i2, String str, int i3) {
            this.BSW = str;
            if (yfo != null && yfo.qH()) {
                this.BSW = "fullscreen_interstitial_ad";
            }
            this.ML = context;
            this.JG = i;
            this.SD = i2;
            this.Bzk = yfo;
            this.SGo = Vgu.KZx(context, 3.0f);
            this.Wx = i3;
            JG();
        }

        private void JG() {
            FrameLayout frameLayout = new FrameLayout(this.ML);
            this.omh = frameLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.JG, this.SD);
            }
            layoutParams.width = this.JG;
            layoutParams.height = this.SD;
            layoutParams.gravity = 17;
            this.omh.setLayoutParams(layoutParams);
            ML mlOmh = omh();
            this.omh.addView(mlOmh);
            View viewSD = SD();
            this.omh.addView(viewSD);
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.Bzk;
            if (yfo != null && yfo.qH()) {
                mlOmh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                mlOmh.pA(((Activity) this.ML).findViewById(com.bytedance.sdk.openadsdk.utils.Sn.gl), FriendlyObstructionPurpose.OTHER);
            }
            mlOmh.pA(viewSD, FriendlyObstructionPurpose.OTHER);
            Context context = this.ML;
            if (context == null || !(context instanceof Activity)) {
                return;
            }
            View viewFindViewById = ((Activity) context).findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Mx);
            if (viewFindViewById != null) {
                mlOmh.pA(viewFindViewById, FriendlyObstructionPurpose.OTHER);
            }
            View viewFindViewById2 = ((Activity) this.ML).findViewById(com.bytedance.sdk.openadsdk.utils.Sn.jK);
            if (viewFindViewById2 != null) {
                mlOmh.pA(viewFindViewById2, FriendlyObstructionPurpose.OTHER);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
        public void pA(com.bytedance.sdk.component.adexpress.Og.SD sd) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo;
            if (this.pA.get()) {
                return;
            }
            if (this.ML == null || (yfo = this.Bzk) == null) {
                sd.pA(106, "material null");
                return;
            }
            this.Sn = sd;
            if (TextUtils.isEmpty(yfo.Xj())) {
                sd.pA(106, "dsp data is null");
            } else {
                this.WV.oX();
            }
        }

        private View SD() {
            PAGLogoView pAGLogoView = new PAGLogoView(this.ML);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.Bzk;
            if (yfo != null && yfo.qH()) {
                layoutParams.leftMargin = Vgu.KZx(this.ML, 20.0f);
                layoutParams.bottomMargin = Vgu.KZx(this.ML, 20.0f);
                layoutParams.gravity = 8388691;
            } else {
                layoutParams.topMargin = this.SGo;
                layoutParams.leftMargin = this.SGo;
            }
            pAGLogoView.setLayoutParams(layoutParams);
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.omh.KZx.pA.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/KZx$pA$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_KZx$pA$1_onClick_854a3ea0fbe229c91faad642eaf1ea4e(view);
                }

                public void safedk_KZx$pA$1_onClick_854a3ea0fbe229c91faad642eaf1ea4e(View p0) {
                    TTWebsiteActivity.pA(pA.this.ML, pA.this.Bzk, pA.this.BSW);
                }
            });
            return pAGLogoView;
        }

        private ML omh() {
            ML mlOg = ZZv.pA().Og();
            this.WV = mlOg;
            if (mlOg == null) {
                this.WV = new ML(this.ML);
            }
            ZZv.pA().KZx(this.WV);
            this.WV.pA(this.Bzk, this, this.BSW);
            this.WV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.WV;
        }

        @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
        public View ML() {
            return this.omh;
        }

        public void ZZv() {
            this.omh = null;
            this.Og = null;
            this.KZx = null;
            this.Sn = null;
            this.Bzk = null;
            ML ml = this.WV;
            if (ml != null) {
                ml.WV();
                ZZv.pA().pA(this.WV);
            }
            this.pA.set(true);
        }

        public void pA(du duVar) {
            if (duVar instanceof com.bytedance.sdk.openadsdk.KZx.KZx) {
                this.Og = (com.bytedance.sdk.openadsdk.KZx.KZx) duVar;
            }
        }

        public void pA(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo;
            if (tTDislikeDialogAbstract != null && (yfo = this.Bzk) != null) {
                tTDislikeDialogAbstract.setMaterialMeta(yfo.tM(), this.Bzk.QI());
            }
            this.KZx = tTDislikeDialogAbstract;
        }

        public void pA(String str) {
            this.ZZv = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
        public View Og() {
            FrameLayout frameLayout = this.omh;
            if (frameLayout == null) {
                return null;
            }
            return (View) frameLayout.getParent();
        }

        @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
        public void pA(View view, int i) {
            PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.DX;
            if (pAGExpressAdWrapperListener != null) {
                pAGExpressAdWrapperListener.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
        public void e_() {
            if (this.Sn != null) {
                com.bytedance.sdk.component.adexpress.Og.Sn sn = new com.bytedance.sdk.component.adexpress.Og.Sn();
                sn.pA(true);
                sn.pA(Vgu.ZZv(this.ML, this.JG));
                sn.Og(Vgu.ZZv(this.ML, this.SD));
                this.Sn.pA(this.omh, sn);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
        public void pA(int i, int i2) {
            com.bytedance.sdk.component.adexpress.Og.SD sd = this.Sn;
            if (sd != null) {
                sd.pA(i, "render fail");
            }
        }

        public void pA(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
            this.DX = pAGExpressAdWrapperListener;
        }
    }

    private static class Og implements Runnable {
        InterfaceC0246KZx pA;

        public Og(InterfaceC0246KZx interfaceC0246KZx) {
            this.pA = interfaceC0246KZx;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0246KZx interfaceC0246KZx = this.pA;
            if (interfaceC0246KZx != null) {
                interfaceC0246KZx.pA(107, 107);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        try {
            ScheduledFuture<?> scheduledFuture = this.omh;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.omh.cancel(false);
            this.omh = null;
        } catch (Throwable unused) {
        }
    }
}
