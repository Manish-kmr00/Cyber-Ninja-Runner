package com.yandex.div.internal.widget.tabs;

import android.os.Bundle;

/* JADX INFO: loaded from: classes9.dex */
class TabMeasurement {
    private static final String FIRST_TAB_HEIGHT_PREFIX = "FIRST_TAB_HEIGHT_PREFIX";
    private static final String MAX_TAB_HEIGHT_PREFIX = "MAX_TAB_HEIGHT_PREFIX";
    private int mFirstTabHeight = -1;
    private int mMaxTabHeight = -1;
    private final int mTabCount;
    private int[] mTabHeight;
    private final TabMeasurementFunction mTabMeasurementFunction;

    interface TabMeasurementFunction {
        int getTabHeight(int i);
    }

    TabMeasurement(int i, TabMeasurementFunction tabMeasurementFunction) {
        this.mTabCount = i;
        this.mTabMeasurementFunction = tabMeasurementFunction;
        this.mTabHeight = new int[i];
    }

    int getFirstTabHeight() {
        if (this.mFirstTabHeight < 0) {
            this.mFirstTabHeight = this.mTabMeasurementFunction.getTabHeight(0);
        }
        return this.mFirstTabHeight;
    }

    int getTabHeight(int i) {
        int i2 = this.mTabCount;
        if (i2 == 0) {
            return 0;
        }
        if (i < 0) {
            return getTabHeight(0);
        }
        if (i >= i2) {
            return getTabHeight(i2);
        }
        int[] iArr = this.mTabHeight;
        if (iArr[i] <= 0) {
            iArr[i] = this.mTabMeasurementFunction.getTabHeight(i);
        }
        return this.mTabHeight[i];
    }

    int getMaxTabHeight() {
        if (this.mMaxTabHeight < 0) {
            int firstTabHeight = getFirstTabHeight();
            for (int i = 1; i < this.mTabCount; i++) {
                firstTabHeight = Math.max(firstTabHeight, this.mTabMeasurementFunction.getTabHeight(i));
            }
            this.mMaxTabHeight = firstTabHeight;
        }
        return this.mMaxTabHeight;
    }

    void saveState(Bundle bundle, int i) {
        if (this.mFirstTabHeight >= 0) {
            bundle.putInt(FIRST_TAB_HEIGHT_PREFIX + i, this.mFirstTabHeight);
        }
        if (this.mMaxTabHeight >= 0) {
            bundle.putInt(MAX_TAB_HEIGHT_PREFIX + i, this.mMaxTabHeight);
        }
    }

    void restoreState(Bundle bundle, int i) {
        this.mFirstTabHeight = bundle.getInt(FIRST_TAB_HEIGHT_PREFIX + i, -1);
        this.mMaxTabHeight = bundle.getInt(MAX_TAB_HEIGHT_PREFIX + i, -1);
    }

    void removeState(Bundle bundle, int i) {
        bundle.remove(FIRST_TAB_HEIGHT_PREFIX + i);
        bundle.remove(MAX_TAB_HEIGHT_PREFIX + i);
    }
}
