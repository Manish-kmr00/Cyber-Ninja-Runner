package com.yandex.div.internal.widget.tabs;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public interface HeightCalculatorFactory {

    public interface GetTabCountFn {
        int apply();
    }

    public interface MeasureTabHeightFn {
        int apply(ViewGroup viewGroup, int i, int i2, int i3);
    }

    ViewPagerFixedSizeLayout.HeightCalculator getCardHeightCalculator(ViewGroup viewGroup, MeasureTabHeightFn measureTabHeightFn, GetTabCountFn getTabCountFn);
}
