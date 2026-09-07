package com.yandex.div.internal.widget.tabs;

import android.view.ViewGroup;
import com.yandex.div.internal.Assert;

/* JADX INFO: loaded from: classes10.dex */
public class MaxCardHeightCalculator extends BaseCardHeightCalculator {
    public MaxCardHeightCalculator(ViewGroup viewGroup, HeightCalculatorFactory.MeasureTabHeightFn measureTabHeightFn, HeightCalculatorFactory.GetTabCountFn getTabCountFn) {
        super(viewGroup, measureTabHeightFn, getTabCountFn);
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public boolean shouldRequestLayoutOnScroll(int i, float f) {
        if (isTabsHeightsIsUnknown()) {
            return true;
        }
        return (i == 0 || (i == 1 && f <= 0.0f)) && firstTabDiffers();
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseCardHeightCalculator
    protected int getOptimalHeight(TabMeasurement tabMeasurement, int i, float f) {
        if (i > 0) {
            return tabMeasurement.getMaxTabHeight();
        }
        if (f < 0.01f) {
            return tabMeasurement.getFirstTabHeight();
        }
        int firstTabHeight = tabMeasurement.getFirstTabHeight();
        return Math.round(firstTabHeight + ((tabMeasurement.getMaxTabHeight() - firstTabHeight) * f));
    }

    private boolean firstTabDiffers() {
        Assert.assertTrue(this.mTabsHeightCache.size() > 0);
        TabMeasurement tabMeasurementValueAt = this.mTabsHeightCache.valueAt(this.mTabsHeightCache.size() - 1);
        return tabMeasurementValueAt.getFirstTabHeight() != tabMeasurementValueAt.getMaxTabHeight();
    }
}
