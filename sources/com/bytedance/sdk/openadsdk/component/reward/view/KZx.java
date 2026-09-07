package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KZx extends com.bytedance.sdk.openadsdk.core.ML.ML {
    private com.bytedance.sdk.openadsdk.component.reward.pA.pA JG;
    private aBv KZx;
    private boolean ML;
    private TextView Og;
    private TextView ZZv;
    private oX pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ML, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context) {
        super(context);
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0 || this.ML) {
            return;
        }
        KZx();
    }

    private void KZx() {
        this.ML = true;
        if (this.JG.YkC == 1) {
            ML();
        } else {
            ZZv();
        }
        if (this.Og == null) {
            this.Og = (TextView) this.JG.CIG.findViewById(520093705);
        }
        yFO yfo = this.JG.Og;
        TextView textView = this.Og;
        if (textView != null) {
            textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.KZx.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int width = ((ViewGroup) KZx.this.Og.getParent()).getWidth();
                    if (width > 0) {
                        KZx.this.Og.setMaxWidth((int) (width * 0.45f));
                    }
                }
            });
            if (yfo.rjD()) {
                if (yfo.dGZ() != null && TextUtils.isEmpty(yfo.dGZ().JG())) {
                    Vgu.pA((View) this.Og, 8);
                }
            } else {
                this.Og.setText(yfo.IG() == 3 ? getButtonTextForNewStyleBar() : yfo.gy());
            }
        }
        if (this.KZx != null && yfo.fJy() != null && !TextUtils.isEmpty(yfo.fJy().pA())) {
            String strPA = yfo.fJy().pA();
            if (yfo.rjD()) {
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(yfo.fJy()).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, yfo.fJy().pA(), new pA(this.KZx, yfo, strPA, this.JG.ML)));
                if (yfo.dGZ() != null && yfo.dGZ().Og() != null) {
                    yfo.dGZ().Og().Og(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(yfo.fJy(), this.KZx, yfo);
            }
        }
        TextView textView2 = this.ZZv;
        if (textView2 != null) {
            textView2.setText(yfo.SXO());
        }
        oX oXVar = this.pA;
        if (oXVar != null) {
            Vgu.pA((TextView) null, oXVar, yfo);
        }
        if (this.JG.YkC == 2 && yfo.IG() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Og.getLayoutParams();
            layoutParams.height = Vgu.KZx(this.JG.Gx, 55.0f);
            layoutParams.topMargin = Vgu.KZx(this.JG.Gx, 20.0f);
            this.Og.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams2.bottomMargin = Vgu.KZx(this.JG.Gx, 12.0f);
            setLayoutParams(layoutParams2);
        }
        Og();
    }

    private void ZZv() {
        setOrientation(0);
        setGravity(16);
        Context context = getContext();
        setPadding(Vgu.KZx(context, 16.0f), Vgu.KZx(context, 12.0f), Vgu.KZx(context, 16.0f), Vgu.KZx(context, 12.0f));
        aBv abv = new aBv(context);
        this.KZx = abv;
        abv.setBackgroundColor(0);
        this.KZx.setId(Sn.Og);
        addView(this.KZx, new LinearLayout.LayoutParams(Vgu.KZx(context, 48.0f), Vgu.KZx(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = Vgu.KZx(context, 12.0f);
        layoutParams.weight = 1.0f;
        addView(ml, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.ZZv = omhVar;
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        this.ZZv.setGravity(16);
        this.ZZv.setSingleLine(true);
        this.ZZv.setTextSize(2, 17.0f);
        this.ZZv.setId(Sn.KZx);
        this.ZZv.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        ml.addView(this.ZZv, new LinearLayout.LayoutParams(-1, -2));
        oX oXVar = new oX(context);
        this.pA = oXVar;
        oXVar.setId(Sn.ML);
        ml.addView(this.pA, new LinearLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.Og = omhVar2;
        omhVar2.setGravity(17);
        this.Og.setEllipsize(TextUtils.TruncateAt.END);
        this.Og.setSingleLine(true);
        this.Og.setTextColor(-1);
        this.Og.setTextSize(2, 16.0f);
        this.Og.setId(520093705);
        this.Og.setBackground(pA(context));
        this.Og.setText(this.JG.Og.gy());
        addView(this.Og, new LinearLayout.LayoutParams(Vgu.KZx(context, 164.0f), Vgu.KZx(context, 36.0f)));
    }

    public void pA() {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.JG = pAVar;
        if (pAVar.Og.IG() == 1) {
            KZx();
        }
    }

    protected String getButtonTextForNewStyleBar() {
        boolean zEquals;
        String strGy;
        String strSD = gbA.SD(this.JG.Gx);
        if (strSD == null) {
            strSD = "";
        }
        try {
            zEquals = strSD.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            zEquals = false;
        }
        if (TextUtils.isEmpty(this.JG.Og.gy())) {
            strGy = this.JG.Og.JBA() != 4 ? "View" : "Install";
        } else {
            strGy = this.JG.Og.gy();
            if (strGy == null || !gbA.JG(strGy) || strGy.length() <= 2) {
                if (strGy != null && !gbA.JG(strGy) && strGy.length() > 7 && zEquals) {
                    strGy = getCnOrEnBtnText();
                }
            } else if (zEquals) {
                strGy = getCnOrEnBtnText();
            }
        }
        if (zEquals && !gbA.JG(strGy)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Og.getLayoutParams();
            layoutParams.bottomMargin = Vgu.KZx(this.JG.Gx, 4.0f);
            this.Og.setLayoutParams(layoutParams);
        }
        return strGy;
    }

    private String getCnOrEnBtnText() {
        if (this.JG.Og.JBA() != 4) {
            return "View";
        }
        return "Install";
    }

    public void Og() {
        com.bytedance.sdk.openadsdk.core.Og.ML ML = this.JG.roi.ML();
        final com.bytedance.sdk.openadsdk.core.Og.Og ogZZv = this.JG.roi.ZZv();
        final yFO yfo = this.JG.Og;
        if (yfo.lT() == null) {
            return;
        }
        if (yfo.IG() != 5 && this.Og != null) {
            if (yfo.lT().ML) {
                this.Og.setOnClickListener(ML);
                this.Og.setOnTouchListener(ML);
            } else {
                this.Og.setOnClickListener(ogZZv);
            }
        }
        if (yfo.IG() == 5) {
            String str = "VAST_ICON";
            if (yfo.lT().ML) {
                com.bytedance.sdk.openadsdk.core.Og.SD sd = new com.bytedance.sdk.openadsdk.core.Og.SD("VAST_ACTION_BUTTON", yfo.dGZ(), ML) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.KZx.2
                };
                com.bytedance.sdk.openadsdk.core.Og.SD sd2 = new com.bytedance.sdk.openadsdk.core.Og.SD(str, yfo.dGZ(), ML) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.KZx.3
                };
                TextView textView = this.Og;
                if (textView != null) {
                    textView.setOnClickListener(sd);
                    this.Og.setOnTouchListener(sd);
                }
                aBv abv = this.KZx;
                if (abv != null) {
                    abv.setOnClickListener(sd2);
                    this.KZx.setOnTouchListener(sd2);
                }
                TextView textView2 = this.ZZv;
                if (textView2 == null || TextUtils.isEmpty(textView2.getText())) {
                    return;
                }
                this.ZZv.setOnClickListener(sd);
                this.ZZv.setOnTouchListener(sd);
                return;
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.KZx.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/KZx$4;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_KZx$4_onClick_c91b84a2599908b7fed2b69fc0860186(view);
                }

                public void safedk_KZx$4_onClick_c91b84a2599908b7fed2b69fc0860186(View p0) {
                    View.OnClickListener onClickListener2 = ogZZv;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(p0);
                    }
                    if (p0 != null && "VAST_ICON".equals(p0.getTag(570425345))) {
                        if (yfo.dGZ() == null || yfo.dGZ().Og() == null) {
                            return;
                        }
                        yfo.dGZ().Og().pA(KZx.this.JG.BF.SD());
                        return;
                    }
                    if (yfo.dGZ() != null) {
                        yfo.dGZ().pA().SD(KZx.this.JG.BF.SD());
                    }
                }
            };
            TextView textView3 = this.Og;
            if (textView3 != null) {
                textView3.setOnClickListener(onClickListener);
            }
            TextView textView4 = this.ZZv;
            if (textView4 != null && !TextUtils.isEmpty(textView4.getText())) {
                this.ZZv.setOnClickListener(onClickListener);
            }
            aBv abv2 = this.KZx;
            if (abv2 != null) {
                abv2.setTag(570425345, "VAST_ICON");
                this.KZx.setOnClickListener(ogZZv);
                return;
            }
            return;
        }
        this.Og.setOnClickListener(ML);
        this.ZZv.setOnClickListener(ML);
        this.pA.setOnClickListener(ML);
        this.KZx.setOnClickListener(ML);
    }

    private void ML() {
        Context context = getContext();
        setPadding(Vgu.KZx(context, 16.0f), Vgu.KZx(context, 16.0f), Vgu.KZx(context, 16.0f), Vgu.KZx(context, 24.0f));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(0);
        ml.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = Vgu.KZx(context, 12.0f);
        addView(ml, layoutParams);
        aBv abv = new aBv(context);
        this.KZx = abv;
        abv.setBackgroundColor(0);
        this.KZx.setId(Sn.Og);
        ml.addView(this.KZx, new LinearLayout.LayoutParams(Vgu.KZx(context, 48.0f), Vgu.KZx(context, 48.0f)));
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = Vgu.KZx(context, 12.0f);
        ml.addView(ml2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.ZZv = omhVar;
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        this.ZZv.setGravity(16);
        this.ZZv.setSingleLine(true);
        this.ZZv.setTextSize(2, 17.0f);
        this.ZZv.setId(Sn.KZx);
        this.ZZv.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        ml2.addView(this.ZZv, new LinearLayout.LayoutParams(-1, -2));
        oX oXVar = new oX(context);
        this.pA = oXVar;
        oXVar.setId(Sn.ML);
        ml2.addView(this.pA, new LinearLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f)));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.Og = omhVar2;
        omhVar2.setGravity(17);
        this.Og.setEllipsize(TextUtils.TruncateAt.END);
        this.Og.setSingleLine(true);
        this.Og.setTextColor(-1);
        this.Og.setTextSize(2, 16.0f);
        this.Og.setId(520093705);
        this.Og.setBackground(pA(context));
        this.Og.setText(this.JG.Og.gy());
        addView(this.Og, new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 36.0f)));
    }

    private static Drawable pA(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1A73E8"));
        gradientDrawable.setCornerRadius(Vgu.KZx(context, 18.0f));
        return gradientDrawable;
    }

    private static class pA implements com.bytedance.sdk.component.ML.oX<Bitmap> {
        private final String KZx;
        private final String Og;
        private final WeakReference<ImageView> ZZv;
        private final yFO pA;

        public pA(ImageView imageView, yFO yfo, String str, String str2) {
            this.ZZv = new WeakReference<>(imageView);
            this.pA = yfo;
            this.Og = str;
            this.KZx = str2;
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
            if (bsw == null || bsw.Og() == null) {
                return;
            }
            ImageView imageView = this.ZZv.get();
            if (imageView != null) {
                imageView.setImageBitmap(bsw.Og());
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.pA, this.KZx, "load_vast_icon_success", (JSONObject) null);
        }

        @Override // com.bytedance.sdk.component.ML.oX
        public void pA(int i, String str, Throwable th) {
            pA(i, str, this.Og);
        }

        private void pA(final int i, final String str, final String str2) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(new com.bytedance.sdk.component.omh.omh("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.view.KZx.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("error_code", i);
                        jSONObject.put("description", i + ":" + str);
                        jSONObject.put("url", str2);
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(pA.this.pA, pA.this.KZx, "load_vast_icon_fail", jSONObject);
                }
            });
        }
    }
}
