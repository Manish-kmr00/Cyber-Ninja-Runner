package com.yandex.div.internal.widget.tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.yandex.div.R;
import com.yandex.div.internal.Log;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseCardHeightCalculator implements ViewPagerFixedSizeLayout.HeightCalculator {
    private static final String KEY_FONT_SCALE = "FONT_SCALE";
    private static final String TAG = "[Y:BaseCardHeightCalculator]";
    private final ViewGroup mChannelGroup;
    private final HeightCalculatorFactory.GetTabCountFn mGetTabCountFn;
    private final HeightCalculatorFactory.MeasureTabHeightFn mMeasureTabHeightFn;
    private Bundle mPendingState;
    protected final SparseArray<TabMeasurement> mTabsHeightCache = new SparseArray<>();
    private int mPosition = 0;
    private float mPositionOffset = 0.0f;

    protected abstract int getOptimalHeight(TabMeasurement tabMeasurement, int i, float f);

    protected BaseCardHeightCalculator(ViewGroup viewGroup, HeightCalculatorFactory.MeasureTabHeightFn measureTabHeightFn, HeightCalculatorFactory.GetTabCountFn getTabCountFn) {
        this.mChannelGroup = viewGroup;
        this.mMeasureTabHeightFn = measureTabHeightFn;
        this.mGetTabCountFn = getTabCountFn;
    }

    private float getFontScale() {
        return this.mChannelGroup.getContext().getResources().getConfiguration().fontScale;
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void saveInstanceState(SparseArray<Parcelable> sparseArray) {
        Bundle bundle = new Bundle();
        int size = this.mTabsHeightCache.size();
        for (int i = 0; i < size; i++) {
            this.mTabsHeightCache.valueAt(i).saveState(bundle, this.mTabsHeightCache.keyAt(i));
        }
        bundle.putFloat(KEY_FONT_SCALE, getFontScale());
        sparseArray.put(R.id.tab_height_cache, bundle);
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void restoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.mTabsHeightCache.clear();
        Bundle bundle = (Bundle) sparseArray.get(R.id.tab_height_cache);
        this.mPendingState = bundle;
        Float fValueOf = bundle == null ? null : Float.valueOf(bundle.getFloat(KEY_FONT_SCALE));
        if (fValueOf == null || fValueOf.floatValue() == getFontScale()) {
            return;
        }
        this.mPendingState = null;
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public int measureHeight(int i, final int i2) {
        TabMeasurement tabMeasurement = this.mTabsHeightCache.get(i);
        if (tabMeasurement == null) {
            int iApply = this.mGetTabCountFn.apply();
            if (iApply == 0) {
                return 0;
            }
            final int size = View.MeasureSpec.getSize(i);
            TabMeasurement tabMeasurement2 = new TabMeasurement(iApply, new TabMeasurement.TabMeasurementFunction() { // from class: com.yandex.div.internal.widget.tabs.BaseCardHeightCalculator$$ExternalSyntheticLambda0
                @Override // com.yandex.div.internal.widget.tabs.TabMeasurement.TabMeasurementFunction
                public final int getTabHeight(int i3) {
                    return this.f$0.m6243x5ac7dfc4(size, i2, i3);
                }
            });
            Bundle bundle = this.mPendingState;
            if (bundle != null) {
                tabMeasurement2.restoreState(bundle, i);
                tabMeasurement2.removeState(this.mPendingState, i);
                if (this.mPendingState.isEmpty()) {
                    this.mPendingState = null;
                }
            }
            this.mTabsHeightCache.put(i, tabMeasurement2);
            tabMeasurement = tabMeasurement2;
        }
        return logAndReturnHeight(getOptimalHeight(tabMeasurement, this.mPosition, this.mPositionOffset), this.mPosition, this.mPositionOffset);
    }

    /* JADX INFO: renamed from: lambda$measureHeight$0$com-yandex-div-internal-widget-tabs-BaseCardHeightCalculator, reason: not valid java name */
    /* synthetic */ int m6243x5ac7dfc4(int i, int i2, int i3) {
        return this.mMeasureTabHeightFn.apply(this.mChannelGroup, i, i2, i3);
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void setPositionAndOffsetForMeasure(int i, float f) {
        Log.d(TAG, "request layout for tab " + i + " with position offset " + f);
        this.mPosition = i;
        this.mPositionOffset = f;
    }

    @Override // com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout.HeightCalculator
    public void dropMeasureCache() {
        Log.d(TAG, "reseting layout...");
        this.mPendingState = null;
        this.mTabsHeightCache.clear();
    }

    protected boolean isTabsHeightsIsUnknown() {
        return this.mTabsHeightCache.size() == 0;
    }

    private static int logAndReturnHeight(int i, int i2, float f) {
        Log.d(TAG, "New optimal height for tab " + i2 + " with position offset " + f + " is " + i);
        return i;
    }
}
