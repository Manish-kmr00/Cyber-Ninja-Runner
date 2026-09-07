package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.du;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public abstract class pA extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    protected boolean BSW;
    protected int Bzk;
    protected String JG;
    protected com.bytedance.sdk.openadsdk.core.model.yFO KZx;
    protected TTDislikeDialogAbstract ML;
    protected Context Og;
    protected int SD;
    protected boolean SGo;
    protected String WV;
    protected com.bytedance.sdk.openadsdk.KZx.KZx ZZv;
    protected int omh;
    private com.bytedance.sdk.openadsdk.ZZv.SD pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
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

    protected abstract void pA(View view, int i, com.bytedance.sdk.openadsdk.core.model.Sn sn);

    public pA(Context context) {
        super(context);
        this.JG = "embeded_ad";
        this.SGo = true;
        this.BSW = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    public pA(Context context, String str) {
        super(context);
        this.JG = "embeded_ad";
        this.SGo = true;
        this.BSW = true;
        this.WV = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(du duVar) {
        if (duVar instanceof com.bytedance.sdk.openadsdk.KZx.KZx) {
            this.ZZv = (com.bytedance.sdk.openadsdk.KZx.KZx) duVar;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        if (tTDislikeDialogAbstract != null && (yfo = this.KZx) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(yfo.tM(), this.KZx.QI());
        }
        this.ML = tTDislikeDialogAbstract;
    }

    public void pA() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ML;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.KZx.KZx kZx = this.ZZv;
        if (kZx != null) {
            kZx.pA();
        } else {
            TTDelegateActivity.pA(this.KZx, (String) null);
        }
    }

    protected String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.KZx;
        if (yfo == null) {
            return "";
        }
        if (yfo.Wo() == null || TextUtils.isEmpty(this.KZx.Wo().Og())) {
            return !TextUtils.isEmpty(this.KZx.HSv()) ? this.KZx.HSv() : "";
        }
        return this.KZx.Wo().Og();
    }

    protected String getTitle() {
        if (this.KZx.Wo() != null && !TextUtils.isEmpty(this.KZx.Wo().Og())) {
            return this.KZx.Wo().Og();
        }
        if (!TextUtils.isEmpty(this.KZx.HSv())) {
            return this.KZx.HSv();
        }
        if (!TextUtils.isEmpty(this.KZx.SXO())) {
            return this.KZx.SXO();
        }
        return "";
    }

    protected String getDescription() {
        if (!TextUtils.isEmpty(this.KZx.SXO())) {
            return this.KZx.SXO();
        }
        if (!TextUtils.isEmpty(this.KZx.fw())) {
            return this.KZx.fw();
        }
        return "";
    }

    public float getRealWidth() {
        return Vgu.ZZv(this.Og, this.SD);
    }

    public float getRealHeight() {
        return Vgu.ZZv(this.Og, this.omh);
    }

    protected void pA(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.Og.Og og;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.Og;
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.KZx;
            String str = this.JG;
            og = new com.bytedance.sdk.openadsdk.core.Og.pA(context, yfo, str, gbA.pA(str));
        } else {
            Context context2 = this.Og;
            com.bytedance.sdk.openadsdk.core.model.yFO yfo2 = this.KZx;
            String str2 = this.JG;
            og = new com.bytedance.sdk.openadsdk.core.Og.Og(context2, yfo2, str2, gbA.pA(str2));
        }
        view.setOnTouchListener(og);
        view.setOnClickListener(og);
        og.pA(new Og() { // from class: com.bytedance.sdk.openadsdk.core.omh.pA.1
            @Override // com.bytedance.sdk.openadsdk.core.omh.Og
            public void pA(View view2, int i, com.bytedance.sdk.openadsdk.core.model.Sn sn) {
                pA.this.pA(view2, i, sn);
            }
        });
    }

    protected com.bytedance.sdk.openadsdk.core.Wx.Og.JG getVideoView() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg;
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.KZx;
        if (yfo != null && this.Og != null) {
            if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo)) {
                try {
                    jg = new com.bytedance.sdk.openadsdk.core.Wx.Og.JG(this.Og, this.KZx, this.JG, true, false, this.pA);
                    jg.setVideoCacheUrl(this.WV);
                    jg.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og() { // from class: com.bytedance.sdk.openadsdk.core.omh.pA.2
                        @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og
                        public void pA(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    jg.setIsAutoPlay(this.SGo);
                    jg.setIsQuiet(this.BSW);
                } catch (Throwable unused) {
                    jg = null;
                }
            } else {
                jg = null;
            }
            if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.KZx) && jg != null && jg.pA(0L, true, false)) {
                return jg;
            }
        }
        return null;
    }

    protected void pA(int i) {
        this.BSW = com.bytedance.sdk.openadsdk.core.aBv.ZZv().KZx(String.valueOf(this.Bzk));
        int iOg = com.bytedance.sdk.openadsdk.core.aBv.ZZv().Og(i);
        if (3 == iOg) {
            this.SGo = false;
            return;
        }
        int iKZx = com.bytedance.sdk.component.utils.DX.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA());
        if (1 != iOg || !gbA.ZZv(iKZx)) {
            if (2 == iOg) {
                if (gbA.ML(iKZx) || gbA.ZZv(iKZx) || gbA.JG(iKZx)) {
                    this.SGo = true;
                    return;
                }
                return;
            }
            if (5 != iOg) {
                return;
            }
            if (!gbA.ZZv(iKZx) && !gbA.JG(iKZx)) {
                return;
            }
        }
        this.SGo = true;
    }

    protected void pA(View view) {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.KZx;
        if (yfo == null || yfo.Bf() == null || view == null) {
            return;
        }
        pA(view, this.KZx.TV() == 1 && this.SGo);
    }
}
