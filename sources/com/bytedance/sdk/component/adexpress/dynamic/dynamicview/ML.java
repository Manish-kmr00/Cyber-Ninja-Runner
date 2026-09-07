package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ML extends FrameLayout implements IAnimation, gbA, qmB {
    protected Context BSW;
    protected int Bzk;
    protected View DX;
    protected float JG;
    protected float KZx;
    protected float ML;
    private float Og;
    protected int SD;
    protected int SGo;
    private com.bytedance.sdk.component.utils.vZF Sd;
    protected DynamicRootView Sn;
    protected com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD WV;
    protected com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh Wx;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.KZx XT;
    protected float ZZv;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.pA.Og aBv;
    protected boolean oX;
    protected int omh;
    private float pA;
    private float vZF;
    private float yFO;
    private static final View.OnTouchListener TX = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener BF = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f) {
        this.Og = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f) {
        this.pA = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.yFO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f) {
        this.yFO = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.vZF;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f) {
        this.vZF = f;
        this.XT.pA(this, f);
    }

    public ML(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context);
        this.BSW = context;
        this.Sn = dynamicRootView;
        this.Wx = omhVar;
        this.KZx = omhVar.JG();
        this.ZZv = omhVar.SD();
        this.ML = omhVar.omh();
        this.JG = omhVar.Bzk();
        this.Bzk = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.KZx);
        this.SGo = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.ZZv);
        this.SD = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.ML);
        this.omh = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.JG);
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD(omhVar.SGo());
        this.WV = sd;
        if (sd.XT() > 0) {
            this.SD += this.WV.XT() * 2;
            this.omh += this.WV.XT() * 2;
            this.Bzk -= this.WV.XT();
            this.SGo -= this.WV.XT();
            List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW = omhVar.BSW();
            if (listBSW != null) {
                for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 : listBSW) {
                    omhVar2.KZx(omhVar2.JG() + com.bytedance.sdk.component.adexpress.ZZv.omh.Og(this.BSW, this.WV.XT()));
                    omhVar2.ZZv(omhVar2.SD() + com.bytedance.sdk.component.adexpress.ZZv.omh.Og(this.BSW, this.WV.XT()));
                    omhVar2.pA(com.bytedance.sdk.component.adexpress.ZZv.omh.Og(this.BSW, this.WV.XT()));
                    omhVar2.Og(com.bytedance.sdk.component.adexpress.ZZv.omh.Og(this.BSW, this.WV.XT()));
                }
            }
        }
        this.oX = this.WV.Sn() > 0.0d;
        this.XT = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.KZx();
    }

    public void setShouldInvisible(boolean z) {
        this.oX = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.oX;
    }

    public boolean KZx() {
        Bzk();
        JG();
        ZZv();
        return true;
    }

    public void pA(int i) {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd = this.WV;
        if (sd != null && sd.pA(i)) {
            Bzk();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof ML)) {
                    ((ML) childAt).pA(i);
                }
            }
        }
    }

    protected boolean ZZv() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.DX;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (ML()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = TX;
            onClickListener = BF;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iPA = com.bytedance.sdk.component.adexpress.dynamic.Og.pA.pA(this.WV);
            if (iPA == 2 || iPA == 3) {
                view2.setOnClickListener(BF);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        pA(view2);
        Og(view2);
        return true;
    }

    protected void pA(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.Wx.omh());
            jSONObject.put("height", this.Wx.Bzk());
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.vZF, this.WV.Vgu());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.Sd, this.Wx.SGo().Og());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.TX, this.Wx.KZx());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.BF, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.WV.Vgu());
            view.setTag(2097610715, this.Wx.SGo().Og());
            view.setTag(2097610714, this.Wx.KZx());
            view.setTag(2097610713, jSONObject.toString());
            int iPA = com.bytedance.sdk.component.adexpress.dynamic.Og.pA.pA(this.WV);
            if (iPA == 1) {
                view.setTag(2097610707, new Pair(this.WV.TV(), Long.valueOf(this.WV.du())));
                view.setTag(2097610708, Integer.valueOf(iPA));
            }
        } catch (JSONException unused) {
        }
    }

    protected void Og(View view) {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = this.Wx;
        if (omhVar == null || (jgML = omhVar.SGo().ML()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(jgML.sPI()));
    }

    public boolean ML() {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD sd = this.WV;
        return (sd == null || sd.eG() == 0) ? false : true;
    }

    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.SD, this.omh);
        layoutParams.topMargin = this.SGo;
        layoutParams.leftMargin = this.Bzk;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.WV.eG();
    }

    public String getImageObjectFit() {
        return this.WV.dC();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.JG.pA getDynamicClickListener() {
        return this.Sn.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        return pA(false, "");
    }

    protected Drawable pA(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iRoi;
        if (!TextUtils.isEmpty(this.WV.gbA())) {
            try {
                String strGbA = this.WV.gbA();
                String strSubstring = strGbA.substring(strGbA.indexOf("(") + 1, strGbA.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(StringUtils.COMMA)).trim(), strSubstring.substring(strSubstring.indexOf(StringUtils.COMMA) + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(strArrSplit[1]), com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(strArrSplit[1].substring(0, 7)), com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawablePA = pA(pA(strArrSplit[0]), iArr);
                gradientDrawablePA.setShape(0);
                gradientDrawablePA.setCornerRadius(com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.DX()));
                return gradientDrawablePA;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fPA = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.DX());
        drawable.setCornerRadius(fPA);
        if (fPA < 1.0f) {
            float fPA2 = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.IG());
            float fPA3 = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.lT());
            float fPA4 = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.rB());
            float fPA5 = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.xy());
            float[] fArr = new float[8];
            if (fPA2 > 0.0f) {
                fArr[0] = fPA2;
                fArr[1] = fPA2;
            }
            if (fPA3 > 0.0f) {
                fArr[2] = fPA3;
                fArr[3] = fPA3;
            }
            if (fPA4 > 0.0f) {
                fArr[4] = fPA4;
                fArr[5] = fPA4;
            }
            if (fPA5 > 0.0f) {
                fArr[6] = fPA5;
                fArr[7] = fPA5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iRoi = Color.parseColor(str);
        } else {
            iRoi = this.WV.roi();
        }
        drawable.setColor(iRoi);
        if (this.WV.aBv() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.aBv()), this.WV.oX());
            return drawable;
        }
        if (this.WV.XT() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.WV.XT(), this.WV.oX());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.Wx.SGo().Og(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new yFO((int) fPA, this.WV.XT());
    }

    protected Og pA(Bitmap bitmap) {
        return new pA(bitmap, null);
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(pA(Og(this.WV.gbA().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] pA(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD.pA(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawablePA = pA(pA(strArrSplit[0]), iArr);
                gradientDrawablePA.setShape(0);
                gradientDrawablePA.setCornerRadius(com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.DX()));
                drawableArr[(list.size() - 1) - i] = gradientDrawablePA;
            }
        }
        return drawableArr;
    }

    private List<String> Og(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && (i = i - 1) == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    protected GradientDrawable pA(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr[0]);
            return gradientDrawable;
        }
        return new GradientDrawable(orientation, iArr);
    }

    protected GradientDrawable.Orientation pA(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.XT.pA(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.KZx kZx = this.XT;
        View view = this.DX;
        if (view == null) {
            view = this;
        }
        kZx.pA(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SD();
        pA();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Og();
        super.onDetachedFromWindow();
    }

    public void SD() {
        if (omh()) {
            return;
        }
        View view = this.DX;
        if (view == null) {
            view = this;
        }
        this.aBv = new com.bytedance.sdk.component.adexpress.dynamic.animation.pA.Og(view, this.Wx.SGo().ML().dGZ());
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML.1
            @Override // java.lang.Runnable
            public void run() {
                if (ML.this.aBv != null) {
                    ML.this.aBv.pA();
                }
            }
        });
    }

    public void Og() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.pA.Og og = this.aBv;
        if (og != null) {
            og.Og();
        }
    }

    protected boolean omh() {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = this.Wx;
        return omhVar == null || omhVar.SGo() == null || this.Wx.SGo().ML() == null || this.Wx.SGo().ML().dGZ() == null;
    }

    public int getDynamicWidth() {
        return this.SD;
    }

    public int getDynamicHeight() {
        return this.omh;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML mlSGo;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = this.Wx;
        if (omhVar == null || (mlSGo = omhVar.SGo()) == null) {
            return null;
        }
        return mlSGo.ML();
    }

    private void pA() {
        if (isShown()) {
            int iPA = com.bytedance.sdk.component.adexpress.dynamic.Og.pA.pA(this.WV);
            if (iPA == 2) {
                if (this.Sd == null) {
                    this.Sd = new com.bytedance.sdk.component.utils.vZF(getContext().getApplicationContext(), 1);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML.4
                };
                com.bytedance.sdk.component.adexpress.Og.Wx renderRequest = this.Sn.getRenderRequest();
                if (renderRequest != null) {
                    renderRequest.DX();
                    renderRequest.Sd();
                    renderRequest.yFO();
                    return;
                }
                return;
            }
            if (iPA == 3) {
                if (this.Sd == null) {
                    this.Sd = new com.bytedance.sdk.component.utils.vZF(getContext().getApplicationContext(), 2);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML.5
                };
                com.bytedance.sdk.component.adexpress.Og.Wx renderRequest2 = this.Sn.getRenderRequest();
                if (renderRequest2 != null) {
                    renderRequest2.aBv();
                    renderRequest2.TX();
                    renderRequest2.XT();
                    renderRequest2.vZF();
                }
            }
        }
    }
}
