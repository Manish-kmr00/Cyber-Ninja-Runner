package com.yandex.div.internal.widget.tabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.ViewCompat;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.font.DivTypefaceType;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.internal.widget.SuperLineHeightTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class TabView extends SuperLineHeightTextView {
    private static final String ELLIPSIS_PLACEHOLDER_TO_MEASURE_WIDTH = "...";
    private DivTypefaceType mActiveTypefaceType;
    private boolean mBoldTextOnSelection;
    private boolean mEllipsizeEnabled;
    private DivTypefaceType mInactiveTypefaceType;
    private InputFocusTracker mInputFocusTracker;
    private boolean mIsActiveType;
    private MaxWidthProvider mMaxWidthProvider;
    private OnUpdateListener mOnUpdateListener;
    private BaseIndicatorTabLayout.Tab mTab;
    private int mTextAppearance;
    private DivTypefaceProvider mTypefaceProvider;

    interface MaxWidthProvider {
        int getMaxWidth();
    }

    interface OnUpdateListener {
        void onUpdated(TabView tabView);
    }

    static /* synthetic */ int lambda$new$0() {
        return Integer.MAX_VALUE;
    }

    static /* synthetic */ void lambda$new$1(View view) {
    }

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxWidthProvider = new MaxWidthProvider() { // from class: com.yandex.div.internal.widget.tabs.TabView$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.widget.tabs.TabView.MaxWidthProvider
            public final int getMaxWidth() {
                return TabView.lambda$new$0();
            }
        };
        setGravity(8388627);
        setClickable(true);
        setMaxLines(1);
        setSingleLine(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.yandex.div.internal.widget.tabs.TabView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabView.lambda$new$1(view);
            }
        });
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        ViewCompat.setPaddingRelative(this, i, i2, i3, i4);
    }

    void setTextTypeface(DivTypefaceProvider divTypefaceProvider, int i) {
        this.mTypefaceProvider = divTypefaceProvider;
        this.mTextAppearance = i;
        setupTypeface();
    }

    public void setInactiveTypefaceType(DivTypefaceType divTypefaceType) {
        this.mInactiveTypefaceType = divTypefaceType;
    }

    public void setActiveTypefaceType(DivTypefaceType divTypefaceType) {
        this.mActiveTypefaceType = divTypefaceType;
    }

    void setTextColorList(ColorStateList colorStateList) {
        if (colorStateList != null) {
            setTextColor(colorStateList);
        }
    }

    void setBoldTextOnSelection(boolean z) {
        this.mBoldTextOnSelection = z;
    }

    void setEllipsizeEnabled(boolean z) {
        this.mEllipsizeEnabled = z;
        setEllipsize(z ? TextUtils.TruncateAt.END : null);
    }

    public void setMaxWidthProvider(MaxWidthProvider maxWidthProvider) {
        this.mMaxWidthProvider = maxWidthProvider;
    }

    void setInputFocusTracker(InputFocusTracker inputFocusTracker) {
        this.mInputFocusTracker = inputFocusTracker;
    }

    void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        InputFocusTracker inputFocusTracker = this.mInputFocusTracker;
        if (inputFocusTracker != null) {
            BaseDivViewExtensionsKt.clearFocusOnClick(this, inputFocusTracker);
        }
        BaseIndicatorTabLayout.Tab tab = this.mTab;
        if (tab == null) {
            return zPerformClick;
        }
        tab.select();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        boolean z2 = isSelected() != z;
        super.setSelected(z);
        setTypefaceType(z);
        if (this.mBoldTextOnSelection && z2) {
            setupTypeface();
        }
        if (z2 && z) {
            sendAccessibilityEvent(4);
        }
    }

    private void setupTypeface() {
        if (isSelected()) {
            return;
        }
        setTextAppearance(getContext(), this.mTextAppearance);
    }

    private Typeface getDefaultTypeface() {
        DivTypefaceProvider divTypefaceProvider = this.mTypefaceProvider;
        if (divTypefaceProvider != null) {
            if (this.mIsActiveType) {
                DivTypefaceType divTypefaceType = this.mActiveTypefaceType;
                if (divTypefaceType != null) {
                    return divTypefaceType.getTypeface(divTypefaceProvider);
                }
            } else {
                DivTypefaceType divTypefaceType2 = this.mInactiveTypefaceType;
                if (divTypefaceType2 != null) {
                    return divTypefaceType2.getTypeface(divTypefaceProvider);
                }
            }
        }
        if (divTypefaceProvider != null) {
            return divTypefaceProvider.getMedium();
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }

    public void setTypefaceType(boolean z) {
        boolean z2 = this.mIsActiveType != z;
        this.mIsActiveType = z;
        if (z2) {
            requestLayout();
        }
    }

    @Override // com.yandex.div.internal.widget.SuperLineHeightTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Typeface defaultTypeface;
        TextPaint paint = getPaint();
        if (paint != null && (defaultTypeface = getDefaultTypeface()) != null) {
            paint.setTypeface(defaultTypeface);
        }
        if (!this.mEllipsizeEnabled) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int maxWidth = this.mMaxWidthProvider.getMaxWidth();
        if (maxWidth > 0 && (mode == 0 || size > maxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        fixTextEllipsis(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.2f);
    }

    private void fixTextEllipsis(int i, int i2) {
        BaseIndicatorTabLayout.Tab tab;
        CharSequence text;
        TextPaint paint;
        Layout layout = getLayout();
        if (layout == null || layout.getEllipsisCount(0) <= 0 || (tab = this.mTab) == null || (text = tab.getText()) == null || (paint = layout.getPaint()) == null) {
            return;
        }
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, this);
        }
        if (text == null) {
            return;
        }
        setText(TextUtils.ellipsize(text, paint, ((int) layout.getLineMax(0)) - paint.measureText("..."), TextUtils.TruncateAt.END));
        super.onMeasure(i, i2);
    }

    void setTab(BaseIndicatorTabLayout.Tab tab) {
        if (tab != this.mTab) {
            this.mTab = tab;
            update();
        }
    }

    void reset() {
        setTab(null);
        setSelected(false);
    }

    void update() {
        BaseIndicatorTabLayout.Tab tab = this.mTab;
        setText(tab == null ? null : tab.getText());
        OnUpdateListener onUpdateListener = this.mOnUpdateListener;
        if (onUpdateListener != null) {
            onUpdateListener.onUpdated(this);
        }
    }
}
