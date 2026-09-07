package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class JG extends ML {
    private static String vZF = "";
    private Runnable Og;
    private volatile boolean Sd;
    private ImageView TX;
    private Runnable pA;
    protected com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk yFO;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public JG(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.Sd = true;
        setTag(Integer.valueOf(getClickArea()));
        String strOg = omhVar.SGo().Og();
        if ("logo-union".equals(strOg)) {
            dynamicRootView.setLogoUnionHeight(this.omh - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, this.WV.Og() + this.WV.pA())));
        } else if ("scoreCountWithIcon".equals(strOg)) {
            dynamicRootView.setScoreCountWithIcon(this.omh - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, this.WV.Og() + this.WV.pA())));
        }
    }

    private String Og(String str) {
        try {
            Map<String, String> mapBSW = this.Sn.getRenderRequest().BSW();
            if (mapBSW != null && mapBSW.size() > 0) {
                return mapBSW.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.SD, this.omh);
    }

    public boolean Bzk() {
        int iDX;
        int iOX;
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.DX == null ? this : this.DX;
        setContentDescription(this.Wx.pA(this.WV.eG()));
        String strQj = this.WV.Qj();
        String strWQf = null;
        String strPA = (TextUtils.isEmpty(strQj) || this.Sn == null || this.Sn.getRenderRequest() == null || this.Sn.getRenderRequest().KZx() == null || (jSONObjectOptJSONObject = this.Sn.getRenderRequest().KZx().optJSONObject(Reporting.Key.CREATIVE)) == null) ? null : pA(jSONObjectOptJSONObject.opt(strQj));
        if (TextUtils.isEmpty(strPA)) {
            strPA = this.WV.Sd();
        }
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx2 = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        if (KZx2 != null) {
            iDX = KZx2.DX();
            iOX = KZx2.oX();
        } else {
            iDX = 0;
            iOX = 0;
        }
        if (this.WV.vZF()) {
            int iYFO = this.WV.yFO();
            String str = this.WV.Og;
            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ML().pA(str).pA(this.SD).Og(this.omh).ZZv(iDX).ML(iOX).pA(Og(str)).KZx(2).pA(new KZx(this.BSW, iYFO)).pA(new Og(view, this));
        } else if (!TextUtils.isEmpty(strPA)) {
            if (!strPA.startsWith("http:") && !strPA.startsWith("https:")) {
                if (this.Sn != null && this.Sn.getRenderRequest() != null) {
                    strWQf = this.Sn.getRenderRequest().WQf();
                }
                strPA = com.bytedance.sdk.component.adexpress.dynamic.ML.Bzk.Og(strPA, strWQf);
            }
            com.bytedance.sdk.component.ML.SGo sGoKZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().ML().pA(strPA).pA(this.SD).Og(this.omh).ZZv(iDX).ML(iOX).pA(Og(strPA)).KZx(2);
            pA(sGoKZx);
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.Wx.SGo().Og(), "vessel")) {
                    if (com.bytedance.sdk.component.adexpress.ZZv.SGo.Og(strPA)) {
                        this.TX = new com.bytedance.sdk.component.adexpress.JG.Wx(this.BSW);
                    } else {
                        this.TX = new ImageView(this.BSW);
                    }
                    ((FrameLayout) view).addView(this.TX, new FrameLayout.LayoutParams(-1, -1));
                    sGoKZx.KZx(3).pA(new com.bytedance.sdk.component.ML.oX() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.1
                        @Override // com.bytedance.sdk.component.ML.oX
                        public void pA(int i, String str2, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.ML.oX
                        public void pA(com.bytedance.sdk.component.ML.BSW bsw) {
                            Object objOg = bsw.Og();
                            if (objOg instanceof byte[]) {
                                com.bytedance.sdk.component.adexpress.ZZv.JG.Og(JG.this.TX, (byte[]) objOg, JG.this.SD, JG.this.omh);
                            }
                        }
                    });
                } else {
                    pA(sGoKZx, view);
                }
            } else {
                sGoKZx.pA(new pA(view, this.Sn, this.Wx));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.WV.Mc() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (JG.this.WV.qmB() > 0) {
                            JG jg = JG.this;
                            Drawable drawableKZx = jg.KZx(jg.Sn.getBgMaterialCenterCalcColor().get(Integer.valueOf(JG.this.WV.qmB())));
                            if (drawableKZx == null) {
                                JG jg2 = JG.this;
                                drawableKZx = jg2.pA(true, jg2.Sn.getBgMaterialCenterCalcColor().get(Integer.valueOf(JG.this.WV.qmB())));
                            }
                            if (drawableKZx != null) {
                                view.setBackground(drawableKZx);
                                return;
                            }
                            View view2 = view;
                            JG jg3 = JG.this;
                            view2.setBackground(jg3.pA(true, jg3.Sn.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.WV.Mc() * 1000.0d));
        }
        if (this.DX != null) {
            this.DX.setPadding((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.KZx()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.Og()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.ZZv()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.pA()));
        }
        if (this.oX || this.WV.Sn() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class KZx implements com.bytedance.sdk.component.ML.omh {
        private final int Og;
        private final WeakReference<Context> pA;

        public KZx(Context context, int i) {
            this.pA = new WeakReference<>(context);
            this.Og = i;
        }

        @Override // com.bytedance.sdk.component.ML.omh
        public Bitmap pA(Bitmap bitmap) {
            Context context = this.pA.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.ZZv.pA.pA(context, bitmap, this.Og);
            }
            return null;
        }
    }

    private static class Og implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private final WeakReference<ML> Og;
        private final WeakReference<View> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public Og(View view, ML ml) {
            this.pA = new WeakReference<>(view);
            this.Og = new WeakReference<>(ml);
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            Bitmap bitmapOg;
            ML ml;
            View view = this.pA.get();
            if (view == null || (bitmapOg = bsw.Og()) == null || bsw.KZx() == null || (ml = this.Og.get()) == null) {
                return;
            }
            view.setBackground(ml.pA(bitmapOg));
        }
    }

    private static class pA implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private final com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh KZx;
        private final WeakReference<DynamicRootView> Og;
        private final WeakReference<View> pA;

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
        }

        public pA(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
            this.pA = new WeakReference<>(view);
            this.Og = new WeakReference<>(dynamicRootView);
            this.KZx = omhVar;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            View view = this.pA.get();
            if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                DynamicRootView dynamicRootView = this.Og.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().ZZv()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().ZZv())) {
                    view.setBackground(new BitmapDrawable(bsw.Og()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(bsw.Og()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(bsw.Og()));
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = this.KZx;
            if (omhVar == null || omhVar.SGo() == null || 6 != this.KZx.SGo().pA() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String pA(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return pA(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return pA((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void pA(com.bytedance.sdk.component.ML.SGo sGo, final View view) {
        sGo.pA(new com.bytedance.sdk.component.ML.oX<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.3
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
                if (JG.this.Sn == null) {
                    return;
                }
                if (!"open_ad".equals(JG.this.Sn.getRenderRequest().ZZv()) && !"splash_ad".equals(JG.this.Sn.getRenderRequest().ZZv())) {
                    view.setBackground(new BitmapDrawable(bsw.Og()));
                } else {
                    if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                        view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pA(bsw.Og(), ((XT) JG.this.Sn.getChildAt(0)).pA));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(bsw.Og()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable KZx(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawablePA = pA(pA(string), iArr);
            gradientDrawablePA.setShape(0);
            gradientDrawablePA.setCornerRadius(com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.DX()));
            return gradientDrawablePA;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void pA(com.bytedance.sdk.component.ML.SGo sGo) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            sGo.pA(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            vZF = com.bytedance.sdk.component.utils.TX.pA();
        } catch (Throwable unused) {
            vZF = Build.MODEL;
        }
        if (TextUtils.isEmpty(vZF)) {
            vZF = Build.MODEL;
        }
        return vZF;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.DX == null ? this : this.DX;
        double dVZF = this.Wx.SGo().ML().vZF();
        if (dVZF < 90.0d && dVZF > 0.0d) {
            com.bytedance.sdk.component.utils.SD.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.4
                @Override // java.lang.Runnable
                public void run() {
                    JG.this.setVisibility(8);
                }
            }, (long) (dVZF * 1000.0d));
        }
        pA(this.Wx.SGo().ML().yFO(), view);
        if (!TextUtils.isEmpty(this.WV.Gx())) {
            pA();
        }
        super.onAttachedToWindow();
    }

    private void pA(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.SD.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.5
                @Override // java.lang.Runnable
                public void run() {
                    if (JG.this.Wx.SGo().ML().dGZ() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    JG.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.pA);
            removeCallbacks(this.Og);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void pA() {
        if (this.Sd) {
            int iFN = this.WV.fN();
            int iDmv = this.WV.dmv();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.6
                @Override // java.lang.Runnable
                public void run() {
                    if (JG.this.Sn != null && JG.this.Sn.getRenderRequest() != null) {
                        com.bytedance.sdk.component.adexpress.Og.Wx renderRequest = JG.this.Sn.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo();
                        sGo.pA(renderRequest.DX());
                        sGo.Og(renderRequest.oX());
                        sGo.KZx(renderRequest.aBv());
                        sGo.pA(renderRequest.XT());
                        sGo.Og(renderRequest.yFO());
                        sGo.KZx(renderRequest.vZF());
                        sGo.ZZv(renderRequest.Sd());
                        sGo.ML(renderRequest.TX());
                        JG jg = JG.this;
                        Context context = JG.this.BSW;
                        JG jg2 = JG.this;
                        jg.yFO = new com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk(context, jg2, jg2.WV, sGo, renderRequest);
                    } else {
                        JG jg3 = JG.this;
                        Context context2 = JG.this.BSW;
                        JG jg4 = JG.this;
                        jg3.yFO = new com.bytedance.sdk.component.adexpress.dynamic.KZx.Bzk(context2, jg4, jg4.WV);
                    }
                    JG jg5 = JG.this;
                    jg5.Og(jg5.yFO);
                    if (JG.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) JG.this.getParent()).setClipChildren(false);
                    }
                    JG.this.setClipChildren(false);
                    JG.this.yFO.setTag(2);
                    JG jg6 = JG.this;
                    jg6.pA((ViewGroup) jg6);
                    JG jg7 = JG.this;
                    jg7.addView(jg7.yFO, new FrameLayout.LayoutParams(-1, -1));
                    JG.this.yFO.KZx();
                }
            };
            this.pA = runnable;
            postDelayed(runnable, ((long) iFN) * 1000);
            if (this.WV.fJy() || iDmv >= Integer.MAX_VALUE || iFN >= iDmv) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG.7
                @Override // java.lang.Runnable
                public void run() {
                    if (JG.this.yFO != null) {
                        JG.this.Sd = false;
                        JG.this.yFO.ZZv();
                        JG.this.yFO.setVisibility(4);
                        JG jg = JG.this;
                        jg.removeView(jg.yFO);
                    }
                }
            };
            this.Og = runnable2;
            postDelayed(runnable2, ((long) iDmv) * 1000);
        }
    }
}
