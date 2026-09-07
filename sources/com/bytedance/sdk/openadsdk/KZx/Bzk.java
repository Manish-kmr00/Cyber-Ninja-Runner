package com.bytedance.sdk.openadsdk.KZx;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Bzk extends com.bytedance.sdk.openadsdk.core.ML.KZx implements SGo.KZx, SGo.Og, SGo.ZZv, SGo.pA {
    private com.bytedance.sdk.openadsdk.core.ML.omh BSW;
    private View Bzk;
    private TextView JG;
    private int KZx;
    private com.bytedance.sdk.openadsdk.core.ML.omh ML;
    private int Og;
    private BSW SD;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv SGo;
    private FilterWord Sn;
    private int WV;
    private int Wx;
    private final SGo ZZv;
    private View omh;
    JG pA;

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

    public Bzk(Context context, SGo sGo) {
        this(context, sGo, null);
    }

    public Bzk(Context context, SGo sGo, List<FilterWord> list) {
        super(context);
        this.ZZv = sGo;
        sGo.pA((SGo.KZx) this);
        sGo.pA((SGo.Og) this);
        sGo.pA((SGo.ZZv) this);
        sGo.pA((SGo.pA) this);
        KZx();
        pA(context);
        if (list == null || list.isEmpty()) {
            return;
        }
        Og(list);
    }

    private void KZx() {
        if (this.WV > 0) {
            return;
        }
        this.WV = Vgu.KZx(getContext());
        int iZZv = Vgu.ZZv(getContext());
        this.Wx = iZZv;
        this.ZZv.pA(this.WV, iZZv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            if (this.WV == 0) {
                KZx();
            }
            layoutParams.width = Math.min(this.WV, this.Wx) - (Vgu.KZx(getContext(), 16.0f) * 2);
        }
    }

    private void pA(Context context) {
        this.KZx = Vgu.KZx(context, 8.0f);
        this.Og = Vgu.KZx(context, 20.0f);
        int iKZx = Vgu.KZx(context, 56.0f);
        int iKZx2 = Vgu.KZx(context, 30.0f);
        int iKZx3 = Vgu.KZx(context, 12.0f);
        if (ZZv()) {
            iKZx3 = this.Og;
        }
        if (!ZZv()) {
            iKZx = iKZx2;
        }
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, Vgu.KZx(getContext(), 98.0f));
        view.setBackground(yFO.KZx(context, "tt_ad_bg_header_gradient"));
        addView(view, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.KZx);
        gradientDrawable.setColor(-1);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        int iKZx4 = Vgu.KZx(context, 24.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iKZx4, iKZx4);
        layoutParams3.setMargins(0, iKZx3, iKZx3, 0);
        layoutParams3.gravity = 8388661;
        zZv.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_titlebar_close_seletor"));
        addView(zZv, layoutParams3);
        zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.Bzk.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/Bzk$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view2);
                safedk_Bzk$1_onClick_296f0ff71b97dae55e46a8f2a2530d59(view2);
            }

            public void safedk_Bzk$1_onClick_296f0ff71b97dae55e46a8f2a2530d59(View p0) {
                Bzk.this.ZZv.ML();
            }
        });
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.SGo = zZv2;
        zZv2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.Bzk.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/Bzk$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view2);
                safedk_Bzk$2_onClick_1a7c7ece0f4d99bbd11dc9aa53a88fe6(view2);
            }

            public void safedk_Bzk$2_onClick_1a7c7ece0f4d99bbd11dc9aa53a88fe6(View p0) {
                Bzk.this.Og();
            }
        });
        this.SGo.setVisibility(8);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iKZx4, iKZx4);
        layoutParams4.setMargins(iKZx3, iKZx3, 0, 0);
        layoutParams4.gravity = 8388659;
        Drawable drawablePA = com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_leftbackicon_selector");
        drawablePA.setAutoMirrored(true);
        this.SGo.setImageDrawable(drawablePA);
        addView(this.SGo, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(iKZx3, iKZx, iKZx3, iKZx3);
        ml.setOrientation(1);
        addView(ml, layoutParams5);
        View viewKZx = KZx(context);
        this.omh = viewKZx;
        ml.addView(viewKZx);
        View viewZZv = ZZv(context);
        this.Bzk = viewZZv;
        ml.addView(viewZZv);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVarOg = Og(context);
        this.ML = omhVarOg;
        ml.addView(omhVarOg);
    }

    private com.bytedance.sdk.openadsdk.core.ML.omh Og(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ZZv() ? this.Og : Vgu.KZx(context, 12.0f);
        layoutParams.gravity = 80;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.KZx);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.KZx);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        int i = this.KZx;
        omhVar.setPadding(0, i, 0, i);
        omhVar.setGravity(17);
        omhVar.setBackground(stateListDrawable);
        omhVar.setTextColor(-1);
        omhVar.setTextSize(16.0f);
        omhVar.setText(yFO.pA(context, "tt_suggestion_commit"));
        omhVar.setEnabled(false);
        omhVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.Bzk.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/Bzk$3;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_Bzk$3_onClick_357fb2b3b4247b94ae4622fe247aa479(view);
            }

            public void safedk_Bzk$3_onClick_357fb2b3b4247b94ae4622fe247aa479(View p0) {
                Bzk.this.ZZv.ZZv();
            }
        });
        omhVar.setLayoutParams(layoutParams);
        return omhVar;
    }

    private View KZx(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ml.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(yFO.pA(context, "tt_like_this_ad"));
        textView.setTextSize(ZZv() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        ml.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText(yFO.pA(context, "tt_feel_hint"));
        textView2.setTextSize(ZZv() ? 14 : 10);
        textView2.setAlpha(0.5f);
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        if (ZZv()) {
            layoutParams2.topMargin = Vgu.KZx(context, 4.0f);
        }
        ml.addView(textView2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int iKZx = Vgu.KZx(context, 16.0f);
        int iKZx2 = Vgu.KZx(context, 12.0f);
        int iKZx3 = Vgu.KZx(context, 8.0f);
        if (ZZv()) {
            layoutParams3.topMargin = iKZx;
            layoutParams3.bottomMargin = iKZx;
        } else {
            layoutParams3.topMargin = iKZx2;
            layoutParams3.bottomMargin = iKZx3;
        }
        ml.addView(ml2, layoutParams3);
        ml2.addView(new ML(context, 1, this.ZZv));
        ML ml3 = new ML(context, 2, this.ZZv);
        ViewGroup.LayoutParams layoutParams4 = ml3.getLayoutParams();
        boolean z = layoutParams4 instanceof LinearLayout.LayoutParams;
        ViewGroup.LayoutParams layoutParams5 = layoutParams4;
        if (!z) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
            layoutParams6.weight = 1.0f;
            layoutParams5 = layoutParams6;
        }
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) layoutParams5;
        layoutParams7.leftMargin = iKZx;
        layoutParams7.rightMargin = iKZx;
        ml2.addView(ml3, layoutParams5);
        ml2.addView(new ML(context, 3, this.ZZv));
        BSW bsw = new BSW(context);
        this.SD = bsw;
        ml.addView(bsw);
        this.JG = new TextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        if (!ZZv()) {
            iKZx = iKZx3;
        }
        layoutParams8.topMargin = iKZx;
        this.JG.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.JG.setPadding(iKZx2, iKZx3, iKZx2, iKZx3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(iKZx3);
        gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
        this.JG.setBackground(gradientDrawable);
        this.JG.setText(yFO.pA(context, "tt_report_this_ad"));
        this.JG.setTextSize(ZZv() ? 14 : 12);
        Drawable drawableKZx = yFO.KZx(context, "tt_report_ad_arrow");
        drawableKZx.setBounds(0, 0, iKZx2, iKZx2);
        this.JG.setCompoundDrawables(null, null, drawableKZx, null);
        this.JG.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.Bzk.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/Bzk$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_Bzk$4_onClick_dfdfccb1c1c9de0fb60b2492fb978ada(view);
            }

            public void safedk_Bzk$4_onClick_dfdfccb1c1c9de0fb60b2492fb978ada(View p0) {
                Bzk.this.pA();
            }
        });
        ml.addView(this.JG, layoutParams8);
        return ml;
    }

    private boolean ZZv() {
        if (this.WV == 0) {
            KZx();
        }
        return this.WV < this.Wx;
    }

    private View ZZv(Context context) {
        int iKZx;
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(1);
        if (!ZZv()) {
            iKZx = Vgu.KZx(context, 200.0f);
        } else {
            iKZx = Vgu.KZx(context, 358.0f);
        }
        ml.setLayoutParams(new LinearLayout.LayoutParams(-1, iKZx));
        TextView textView = new TextView(context);
        textView.setText(yFO.pA(context, "tt_select_reason"));
        textView.setTextSize(ZZv() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = Vgu.KZx(context, ZZv() ? 24.0f : 4.0f);
        ml.addView(textView, layoutParams);
        JG jg = new JG(context, this.ZZv);
        this.pA = jg;
        ml.addView(jg);
        if (oX.vkV().agB()) {
            com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
            this.BSW = omhVar;
            omhVar.setId(Sn.GL);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = ZZv() ? this.Og : Vgu.KZx(context, 6.0f);
            layoutParams2.gravity = 17;
            this.BSW.setLayoutParams(layoutParams2);
            this.BSW.setFocusable(false);
            this.BSW.setHint(yFO.pA(context, "tt_add_bad_reason"));
            this.BSW.setHintTextColor(Color.parseColor("#57000000"));
            this.BSW.setTextColor(Color.rgb(22, 24, 35));
            this.BSW.setTextSize(15.0f);
            this.BSW.setGravity(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
            this.BSW.setVisibility(0);
            this.BSW.setPadding(0, Vgu.KZx(context, 15.0f), 0, Vgu.KZx(context, 14.0f));
            this.BSW.setEllipsize(TextUtils.TruncateAt.END);
            this.BSW.setSingleLine();
            this.BSW.setMaxLines(1);
            this.BSW.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.KZx.Bzk.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/Bzk$5;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_Bzk$5_onClick_2f61a416228a0f972b7ad63e0c945596(view);
                }

                public void safedk_Bzk$5_onClick_2f61a416228a0f972b7ad63e0c945596(View p0) {
                    Bzk.this.ZZv.JG();
                }
            });
            ml.addView(this.BSW, layoutParams2);
            ml.addView(new BSW(context, Color.argb(128, 0, 0, 0)));
        }
        ml.setVisibility(8);
        return ml;
    }

    private void Og(List<FilterWord> list) {
        this.pA.pA(list);
    }

    public void pA() {
        View view = this.Bzk;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.omh;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.SGo;
        if (zZv != null) {
            zZv.setVisibility(0);
        }
        SGo sGo = this.ZZv;
        if (sGo == null || !sGo.KZx()) {
            return;
        }
        this.Sn = this.ZZv.Og();
    }

    public void Og() {
        View view = this.Bzk;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.omh;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.SGo;
        if (zZv != null) {
            zZv.setVisibility(8);
        }
        SGo sGo = this.ZZv;
        if (sGo != null) {
            FilterWord filterWord = this.Sn;
            if (filterWord != null) {
                sGo.pA(filterWord);
            } else {
                sGo.pA(SGo.pA);
            }
            this.ZZv.KZx(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.KZx
    public void pA(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.ML != null && TextUtils.isEmpty(this.ZZv.SD())) {
            this.ML.setEnabled(!SGo.pA.equals(filterWord));
        }
        if (ML.pA.equals(filterWord) || ML.Og.equals(filterWord)) {
            this.JG.setVisibility(8);
            this.SD.setVisibility(8);
        }
        if (ML.KZx.equals(filterWord) || SGo.pA.equals(filterWord)) {
            this.JG.setVisibility(0);
            this.SD.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.Og
    public void pA(int i) {
        if (SGo.KZx == i) {
            this.Sn = null;
            Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.ZZv
    public void pA(String str) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar;
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = this.BSW;
        if (omhVar2 != null) {
            omhVar2.setText(str);
        }
        if (TextUtils.isEmpty(str)) {
            SGo sGo = this.ZZv;
            if (sGo == null || (omhVar = this.ML) == null) {
                return;
            }
            omhVar.setEnabled(sGo.KZx());
            return;
        }
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = this.ML;
        if (omhVar3 != null) {
            omhVar3.setEnabled(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.pA
    public void pA(List<FilterWord> list) {
        Og(list);
    }
}
