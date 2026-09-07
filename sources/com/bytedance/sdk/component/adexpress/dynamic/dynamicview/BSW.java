package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class BSW extends JG {
    private String pA;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public BSW(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        if (!TextUtils.isEmpty(this.WV.Wo()) && omhVar.yFO()) {
            com.bytedance.sdk.component.adexpress.JG.SGo sGo = new com.bytedance.sdk.component.adexpress.JG.SGo(context);
            sGo.setAnimationsLoop(this.WV.Itl());
            sGo.setImageLottieTosPath(this.WV.Wo());
            sGo.setLottieAppNameMaxLength(this.WV.QI());
            sGo.setLottieAdTitleMaxLength(this.WV.RS());
            sGo.setLottieAdDescMaxLength(this.WV.tM());
            sGo.setData(omhVar.vZF());
            this.DX = sGo;
        } else if (this.WV.DX() > 0.0f) {
            this.DX = new com.bytedance.sdk.component.adexpress.JG.du(context);
            ((com.bytedance.sdk.component.adexpress.JG.du) this.DX).setXRound((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, this.WV.DX()));
            ((com.bytedance.sdk.component.adexpress.JG.du) this.DX).setYRound((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, this.WV.DX()));
        } else if (!omh() && "arrowButton".equals(omhVar.SGo().Og())) {
            com.bytedance.sdk.component.adexpress.dynamic.animation.view.Og og = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.Og(context);
            og.setBrickNativeValue(this.WV);
            this.DX = og;
        } else if (com.bytedance.sdk.component.adexpress.ZZv.SGo.Og(this.WV.BSW())) {
            this.DX = new com.bytedance.sdk.component.adexpress.JG.Wx(context);
        } else {
            this.DX = new ImageView(context);
        }
        this.pA = getImageKey();
        this.DX.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(omhVar.SGo().Og())) {
            if (this.WV.Og() > 0 || this.WV.pA() > 0) {
                this.SD = Math.min(this.SD, this.omh);
                this.omh = Math.min(this.SD, this.omh);
                this.Bzk = (int) (this.Bzk + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, this.WV.Og() + (this.WV.pA() / 2) + 0.5f));
            } else {
                this.SD = Math.max(this.SD, this.omh);
                this.omh = Math.max(this.SD, this.omh);
            }
            this.WV.pA(this.SD / 2);
        }
        addView(this.DX, new FrameLayout.LayoutParams(this.SD, this.omh));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.DX).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).start();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.DX).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        int iOX;
        super.Bzk();
        if (!TextUtils.isEmpty(this.WV.Wo())) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        int iDX = 0;
        if ("arrowButton".equals(this.Wx.SGo().Og())) {
            ((ImageView) this.DX).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.BSW, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.DX).getDrawable() != null) {
                ((ImageView) this.DX).getDrawable().setAutoMirrored(true);
            }
            this.DX.setPadding(0, 0, 0, 0);
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.DX.setBackgroundColor(this.WV.roi());
        String strKZx = this.Wx.SGo().KZx();
        if (POBConstants.KEY_USER.equals(strKZx)) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.DX).setColorFilter(this.WV.SD());
            ((ImageView) this.DX).setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_user"));
            ((ImageView) this.DX).setPadding(this.SD / 10, this.omh / 5, this.SD / 10, 0);
        } else if (strKZx != null && strKZx.startsWith("@")) {
            try {
                ((ImageView) this.DX).setImageResource(Integer.parseInt(strKZx.substring(1)));
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.ML.DX dxML = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ML();
        String strBSW = this.WV.BSW();
        if (!TextUtils.isEmpty(strBSW) && !strBSW.startsWith("http:") && !strBSW.startsWith("https:")) {
            strBSW = com.bytedance.sdk.component.adexpress.dynamic.ML.Bzk.Og(strBSW, (this.Sn == null || this.Sn.getRenderRequest() == null) ? null : this.Sn.getRenderRequest().WQf());
        }
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        if (KZx != null) {
            iDX = KZx.DX();
            iOX = KZx.oX();
        } else {
            iOX = 0;
        }
        com.bytedance.sdk.component.ML.SGo sGoML = dxML.pA(strBSW).pA(this.pA).pA(this.SD).Og(this.omh).ZZv(iDX).ML(iOX);
        String strSn = this.Sn.getRenderRequest().Sn();
        if (!TextUtils.isEmpty(strSn)) {
            sGoML.Og(strSn);
        }
        if (pA()) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.FIT_CENTER);
            sGoML.pA(Bitmap.Config.ARGB_4444).KZx(2).pA(new pA(this.BSW)).pA(new Og(this.DX, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                sGoML.pA((ImageView) this.DX);
            }
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.DX instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            pA(sGoML);
        }
        return true;
    }

    private static class pA implements com.bytedance.sdk.component.ML.omh {
        private final WeakReference<Context> pA;

        public pA(Context context) {
            this.pA = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.ML.omh
        public Bitmap pA(Bitmap bitmap) {
            Context context = this.pA.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.ZZv.pA.pA(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class Og implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private Resources Og;
        private WeakReference<View> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public Og(View view, Resources resources) {
            this.pA = new WeakReference<>(view);
            this.Og = resources;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            Bitmap bitmapOg;
            View view = this.pA.get();
            if (view == null || (bitmapOg = bsw.Og()) == null || bsw.KZx() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.Og, bitmapOg));
        }
    }

    private boolean pA() {
        String strWV = this.WV.WV();
        if (this.WV.vZF()) {
            return true;
        }
        if (TextUtils.isEmpty(strWV)) {
            return false;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strWV);
            return Math.abs((((float) this.SD) / (((float) this.omh) * 1.0f)) - (((float) jSONObjectJsonObjectInit.optInt("width")) / (((float) jSONObjectJsonObjectInit.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> mapBSW = this.Sn.getRenderRequest().BSW();
        if (mapBSW == null || mapBSW.size() <= 0) {
            return null;
        }
        return mapBSW.get(this.WV.BSW());
    }

    private void pA(com.bytedance.sdk.component.ML.SGo sGo) {
        sGo.KZx(3).pA(new com.bytedance.sdk.component.ML.oX() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BSW.1
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(com.bytedance.sdk.component.ML.BSW bsw) {
                Object objOg = bsw.Og();
                if ((objOg instanceof byte[]) && (BSW.this.DX instanceof ImageView)) {
                    com.bytedance.sdk.component.adexpress.ZZv.JG.Og((ImageView) BSW.this.DX, (byte[]) objOg, BSW.this.SD, BSW.this.omh);
                }
            }
        });
    }
}
