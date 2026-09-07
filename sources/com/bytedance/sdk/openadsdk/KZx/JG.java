package com.bytedance.sdk.openadsdk.KZx;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class JG extends ScrollView {
    private final com.bytedance.sdk.openadsdk.core.ML.ML Og;
    private final SGo pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public JG(Context context, SGo sGo) {
        super(context);
        this.pA = sGo;
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        this.Og = ml;
        ml.setOrientation(1);
        addView(ml, new FrameLayout.LayoutParams(-1, -2));
        if (sGo.omh() == 0) {
            pA();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
    }

    private void pA() {
        if (this.pA.omh() != 0) {
            return;
        }
        this.pA.pA(Vgu.KZx(getContext()), Vgu.ZZv(getContext()));
    }

    public void pA(List<FilterWord> list) {
        List<FilterWord> listKZx = KZx(list);
        if (listKZx == null) {
            return;
        }
        Og(listKZx);
    }

    private void Og(List<FilterWord> list) {
        this.Og.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            FilterWord filterWord = list.get(i);
            if (filterWord != null) {
                this.Og.addView(new SD(getContext(), filterWord, this.pA));
            }
            if (i < list.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int iKZx = Vgu.KZx(getContext(), this.pA.Bzk() ? 16.0f : 8.0f);
                layoutParams.topMargin = iKZx;
                layoutParams.bottomMargin = iKZx;
                this.Og.addView(new BSW(getContext()), layoutParams);
            }
        }
    }

    private static List<FilterWord> KZx(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).hasSecondOptions()) {
                i2 = i3;
            }
        }
        if (i2 != -1 && i2 <= list.size()) {
            i = i2;
        }
        FilterWord filterWord = list.get(i);
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            FilterWord next = it.next();
            if (!next.hasSecondOptions()) {
                filterWord.addOption(next);
                it.remove();
            }
        }
        return list;
    }
}
