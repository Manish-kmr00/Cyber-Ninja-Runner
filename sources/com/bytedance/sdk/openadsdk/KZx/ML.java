package com.bytedance.sdk.openadsdk.KZx;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ML extends com.bytedance.sdk.openadsdk.core.ML.ML implements View.OnClickListener, SGo.KZx {
    private FilterWord JG;
    private final SGo ML;
    private StateListDrawable SD;
    private final int omh;
    public static FilterWord pA = new FilterWord("100:1", "GOOD");
    public static FilterWord Og = new FilterWord("100:2", "NOT_BAD");
    public static FilterWord KZx = new FilterWord("100:3", "BAD");
    public static List<ML> ZZv = new ArrayList(3);

    @Override // com.bytedance.sdk.openadsdk.core.ML.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/KZx/ML;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(h.u, view);
        safedk_ML_onClick_b562d1920b13b0f80b4cc9bf9f20e0cb(view);
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

    public ML(Context context, int i, SGo sGo) {
        super(context);
        this.omh = i;
        this.ML = sGo;
        if (sGo != null) {
            sGo.pA(this);
        }
        pA(i);
        pA();
        Og();
        ZZv.add(this);
    }

    private void pA(int i) {
        if (i == 1) {
            this.JG = pA;
        } else if (i == 2) {
            this.JG = Og;
        } else {
            if (i != 3) {
                return;
            }
            this.JG = KZx;
        }
    }

    private void pA() {
        if (this.SD == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(Vgu.KZx(getContext(), 12.0f));
            gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(Vgu.KZx(getContext(), 2.0f), Color.parseColor("#FE2C55"));
            gradientDrawable2.setCornerRadius(Vgu.KZx(getContext(), 12.0f));
            gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.SD = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
            this.SD.addState(new int[0], gradientDrawable);
        }
        setBackground(this.SD);
        setSelected(false);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setOnClickListener(this);
    }

    private void Og() {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(getContext());
        omhVar.setTextSize(this.ML.Bzk() ? 40 : 30);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.setMargins(0, Vgu.KZx(getContext(), 12.0f), 0, Vgu.KZx(getContext(), this.ML.Bzk() ? 8.0f : 4.0f));
        addView(omhVar, layoutParams);
        pA pAVar = new pA(getContext());
        pAVar.setTextSize(this.ML.Bzk() ? 17 : 12);
        pAVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        pAVar.setMaxLines(1);
        pAVar.setSingleLine();
        pAVar.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.setMargins(0, 0, 0, Vgu.KZx(getContext(), 12.0f));
        addView(pAVar, layoutParams2);
        int i = this.omh;
        if (i == 1) {
            omhVar.setText("😍");
            pAVar.setText(yFO.pA(getContext(), "tt_good"));
        } else if (i == 2) {
            pAVar.setText(yFO.pA(getContext(), "tt_not_bad"));
            omhVar.setText("😐");
        } else {
            if (i != 3) {
                return;
            }
            pAVar.setText(yFO.pA(getContext(), "tt_bad"));
            omhVar.setText("😡");
        }
    }

    public void safedk_ML_onClick_b562d1920b13b0f80b4cc9bf9f20e0cb(View p0) {
        if (isSelected()) {
            this.ML.pA(SGo.pA);
        } else {
            this.ML.pA(this.JG);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.KZx
    public void pA(FilterWord filterWord) {
        FilterWord filterWord2;
        if (filterWord == null || (filterWord2 = this.JG) == null) {
            return;
        }
        setSelected(filterWord.equals(filterWord2));
    }
}
