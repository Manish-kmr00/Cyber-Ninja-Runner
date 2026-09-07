package com.yandex.div.internal.widget.tabs;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public class DynamicCardHeightCalculator extends BaseCardHeightCalculator {
    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public boolean shouldRequestLayoutOnScroll(int i, float f) {
        return true;
    }

    public DynamicCardHeightCalculator(ViewGroup viewGroup, HeightCalculatorFactory.MeasureTabHeightFn measureTabHeightFn, HeightCalculatorFactory.GetTabCountFn getTabCountFn) {
        super(viewGroup, measureTabHeightFn, getTabCountFn);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseCardHeightCalculator, com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public int measureHeight(int i, int i2) {
        dropMeasureCache();
        return super.measureHeight(i, i2);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseCardHeightCalculator
    protected int getOptimalHeight(TabMeasurement tabMeasurement, int i, float f) {
        if (f < 0.01f) {
            return tabMeasurement.getTabHeight(i);
        }
        int tabHeight = tabMeasurement.getTabHeight(i);
        return Math.round(tabHeight + ((tabMeasurement.getTabHeight(i + 1) - tabHeight) * f));
    }
}
