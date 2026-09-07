package com.yandex.div.internal.widget.tabs;

import android.os.Parcelable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes5.dex */
public class FixedHeightCalculator implements ViewPagerFixedSizeLayout.HeightCalculator {
    private final int mTabHeight;

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void dropMeasureCache() {
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void restoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void saveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void setPositionAndOffsetForMeasure(int i, float f) {
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public boolean shouldRequestLayoutOnScroll(int i, float f) {
        return false;
    }

    public FixedHeightCalculator(int i) {
        this.mTabHeight = i;
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public int measureHeight(int i, int i2) {
        return this.mTabHeight;
    }
}
