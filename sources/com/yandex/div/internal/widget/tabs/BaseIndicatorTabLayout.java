package com.yandex.div.internal.widget.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.yandex.div.R;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.internal.Log;
import com.yandex.div.internal.util.NestedHorizontalScrollCompanion;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class BaseIndicatorTabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    private static final int DEFAULT_HEIGHT = 44;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    public static final int UNDEFINED_COLOR = -1;
    public static final float UNDEFINED_RADIUS = -1.0f;
    private long mAnimationDuration;
    private int mContentInsetEnd;
    private int mContentInsetStart;
    private InputFocusTracker mInputFocusTracker;
    private final boolean mIsTabEllipsizeEnabled;
    private int mMode;
    private final NestedHorizontalScrollCompanion mNestedScrollCompanion;
    private OnTabSelectedListener mOnTabSelectedListener;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private Tab mSelectedTab;
    private final OvalIndicators mTabIndicators;
    private int mTabMaxWidth;
    private int mTabPaddingBottom;
    private int mTabPaddingEnd;
    private int mTabPaddingStart;
    private int mTabPaddingTop;
    private final int mTabScrollPadding;
    private final boolean mTabScrollPaddingEnabled;
    private int mTabTextAppearance;
    private boolean mTabTextBoldOnSelection;
    private ColorStateList mTabTextColors;
    private final TabTitleDelimitersController mTabTitleDelimitersController;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<Tab> mTabs;
    private DivTypefaceProvider mTypefaceProvider;
    private ViewPager mViewPager;
    private static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final Pools.Pool<Tab> sTabPool = new Pools.SynchronizedPool(16);

    public enum AnimationType {
        SLIDE,
        FADE,
        NONE
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    protected void onTabViewCreated(TextView textView) {
    }

    protected void onTabViewUpdated(TextView textView) {
    }

    public BaseIndicatorTabLayout(Context context) {
        this(context, null);
    }

    public BaseIndicatorTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicatorTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.mAnimationDuration = 300L;
        this.mTypefaceProvider = DivTypefaceProvider.DEFAULT;
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mNestedScrollCompanion = new NestedHorizontalScrollCompanion(this);
        this.mTabViewPool = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i, R.style.Div_Tabs_IndicatorTabLayout);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.BaseIndicatorTabLayout, 0, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.BaseIndicatorTabLayout_tabIndicatorPaddingTop, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.BaseIndicatorTabLayout_tabIndicatorPaddingBottom, 0);
        this.mTabTextBoldOnSelection = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.BaseIndicatorTabLayout_tabTextBoldOnSelection, false);
        this.mContentInsetEnd = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.BaseIndicatorTabLayout_tabContentEnd, 0);
        this.mIsTabEllipsizeEnabled = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.BaseIndicatorTabLayout_tabEllipsizeEnabled, true);
        this.mTabScrollPaddingEnabled = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.BaseIndicatorTabLayout_tabScrollPaddingEnabled, false);
        this.mTabScrollPadding = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.BaseIndicatorTabLayout_tabScrollPadding, 0);
        typedArrayObtainStyledAttributes2.recycle();
        OvalIndicators ovalIndicators = new OvalIndicators(context, dimensionPixelSize, dimensionPixelSize2, null);
        this.mTabIndicators = ovalIndicators;
        super.addView(ovalIndicators, 0, new FrameLayout.LayoutParams(-2, -1));
        ovalIndicators.setIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        ovalIndicators.setSelectedIndicatorColor(typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        ovalIndicators.setIndicatorColor(typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabBackground, 0));
        this.mTabTitleDelimitersController = new TabTitleDelimitersController(getContext(), ovalIndicators);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.mTabPaddingBottom = dimensionPixelSize3;
        this.mTabPaddingEnd = dimensionPixelSize3;
        this.mTabPaddingTop = dimensionPixelSize3;
        this.mTabPaddingStart = dimensionPixelSize3;
        this.mTabPaddingStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
        this.mTabPaddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
        this.mTabPaddingEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
        this.mTabPaddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.Div_Tabs_IndicatorTabLayout_Text);
        this.mTabTextAppearance = resourceId;
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.mTabTextColors = typedArrayObtainStyledAttributes3.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes3.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.mTabTextColors = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.mRequestedTabMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.mRequestedTabMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.mContentInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mMode = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            typedArrayObtainStyledAttributes.recycle();
            this.mScrollableTabMinWidth = getResources().getDimensionPixelSize(R.dimen.tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes3.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.mTabIndicators.setSelectedIndicatorColor(i);
    }

    public void setTabBackgroundColor(int i) {
        this.mTabIndicators.setIndicatorColor(i);
    }

    public void setTabIndicatorCornersRadii(float[] fArr) {
        this.mTabIndicators.setIndicatorCornersRadii(fArr);
    }

    public void setTabItemSpacing(int i) {
        this.mTabIndicators.setItemSpacing(i);
    }

    public void setAnimationType(AnimationType animationType) {
        this.mTabIndicators.setAnimationType(animationType);
    }

    public void setAnimationDuration(long j) {
        this.mAnimationDuration = j;
    }

    public void setTabIndicatorHeight(int i) {
        this.mTabIndicators.setIndicatorHeight(i);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int iRound = Math.round(i + f);
        if (iRound < 0 || iRound >= this.mTabIndicators.getChildCount()) {
            return;
        }
        if (z2) {
            this.mTabIndicators.setSelectedIndicatorPositionFromTabPosition(i, f);
        }
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i, f), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void setTabPaddings(int i, int i2, int i3, int i4) {
        this.mTabPaddingStart = i;
        this.mTabPaddingTop = i2;
        this.mTabPaddingEnd = i3;
        this.mTabPaddingBottom = i4;
        requestLayout();
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        addTabView(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            tab.select();
        }
    }

    public void addTab(Tab tab, int i, boolean z) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        addTabView(tab, i, z);
        configureTab(tab, i);
        if (z) {
            tab.select();
        }
    }

    private void addTabFromItemView(TabItem tabItem) {
        Tab tabNewTab = newTab();
        if (tabItem.text != null) {
            tabNewTab.setText(tabItem.text);
        }
        addTab(tabNewTab);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
    }

    public Tab newTab() {
        Tab tabAcquire = sTabPool.acquire();
        if (tabAcquire == null) {
            tabAcquire = new Tab(null);
        }
        tabAcquire.mParent = this;
        tabAcquire.mView = getTabView(tabAcquire);
        return tabAcquire;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Tab getTabAt(int i) {
        return this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        Tab tab = this.mSelectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    public void removeTab(Tab tab) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        Tab tab = this.mSelectedTab;
        int position = tab != null ? tab.getPosition() : 0;
        removeTabViewAt(i);
        Tab tabRemove = this.mTabs.remove(i);
        if (tabRemove != null) {
            tabRemove.reset();
            sTabPool.release(tabRemove);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.mTabs.get(i2).setPosition(i2);
        }
        if (position == i) {
            selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1)));
        }
    }

    public void removeAllTabs() {
        for (int size = this.mTabs.size() - 1; size >= 0; size--) {
            removeTabViewAt(size);
        }
        Iterator<Tab> it = this.mTabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            sTabPool.release(next);
        }
        this.mSelectedTab = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            int size = this.mTabs.size();
            for (int i = 0; i < size; i++) {
                TabView tabView = this.mTabs.get(i).getTabView();
                if (tabView != null) {
                    tabView.setTextColorList(this.mTabTextColors);
                }
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public int getSelectedTabTextColor() {
        return this.mTabTextColors.getColorForState(SELECTED_STATE_SET, -1);
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setTabDelimiter(Bitmap bitmap, int i, int i2) {
        this.mTabTitleDelimitersController.updateTitleDelimiters(bitmap, i, i2);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener;
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null && (tabLayoutOnPageChangeListener = this.mPageChangeListener) != null) {
            viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
        }
        if (viewPager != null) {
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            setOnTabSelectedListener(new ViewPagerOnTabSelectedListener(viewPager));
            setPagerAdapter(adapter, true);
            return;
        }
        this.mViewPager = null;
        setOnTabSelectedListener(null);
        setPagerAdapter(null, true);
    }

    public TabLayoutOnPageChangeListener getPageChangeListener() {
        if (this.mPageChangeListener == null) {
            this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
        }
        return this.mPageChangeListener;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void setTabsEnabled(boolean z) {
        for (int i = 0; i < this.mTabs.size(); i++) {
            this.mTabs.get(i).mView.setEnabled(z);
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabIndicators.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setPagerAdapter(PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new PagerAdapterObserver(this, null);
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().setText(this.mPagerAdapter.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
            return;
        }
        removeAllTabs();
    }

    private TabView getTabView(Tab tab) {
        TabView tabViewAcquire = this.mTabViewPool.acquire();
        if (tabViewAcquire == null) {
            tabViewAcquire = createTabView(getContext());
            configureTabView(tabViewAcquire);
            onTabViewCreated(tabViewAcquire);
        }
        tabViewAcquire.setTab(tab);
        tabViewAcquire.setFocusable(true);
        tabViewAcquire.setMinimumWidth(getTabMinWidth());
        return tabViewAcquire;
    }

    protected TabView createTabView(Context context) {
        return new TabView(context);
    }

    private void configureTabView(TabView tabView) {
        tabView.setTabPadding(this.mTabPaddingStart, this.mTabPaddingTop, this.mTabPaddingEnd, this.mTabPaddingBottom);
        tabView.setTextTypeface(this.mTypefaceProvider, this.mTabTextAppearance);
        tabView.setInputFocusTracker(this.mInputFocusTracker);
        tabView.setTextColorList(this.mTabTextColors);
        tabView.setBoldTextOnSelection(this.mTabTextBoldOnSelection);
        tabView.setEllipsizeEnabled(this.mIsTabEllipsizeEnabled);
        tabView.setMaxWidthProvider(new TabView.MaxWidthProvider() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.widget.tabs.TabView.MaxWidthProvider
            public final int getMaxWidth() {
                return this.f$0.getTabMaxWidth();
            }
        });
        tabView.setOnUpdateListener(new TabView.OnUpdateListener() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.widget.tabs.TabView.OnUpdateListener
            public final void onUpdated(TabView tabView2) {
                this.f$0.onTabViewUpdated(tabView2);
            }
        });
    }

    private void configureTab(Tab tab, int i) {
        tab.setPosition(i);
        this.mTabs.add(i, tab);
        int size = this.mTabs.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.mTabs.get(i).setPosition(i);
            }
        }
    }

    private void addTabView(Tab tab, boolean z) {
        TabView tabView = tab.mView;
        this.mTabIndicators.addView(tabView, createLayoutParamsForTabs());
        this.mTabTitleDelimitersController.tabAdded(this.mTabIndicators.getChildCount() - 1);
        if (z) {
            tabView.setSelected(true);
        }
    }

    private void addTabView(Tab tab, int i, boolean z) {
        TabView tabView = tab.mView;
        int tabPositionInLayout = this.mTabIndicators.getTabPositionInLayout(i);
        this.mTabIndicators.addView(tabView, tabPositionInLayout, createLayoutParamsForTabs());
        this.mTabTitleDelimitersController.tabAdded(tabPositionInLayout);
        if (z) {
            tabView.setSelected(true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx(44, getResources().getDisplayMetrics()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(iDpToPx, View.MeasureSpec.getSize(i2)), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(iDpToPx, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int iDpToPx2 = this.mRequestedTabMaxWidth;
            if (iDpToPx2 <= 0) {
                iDpToPx2 = size - BaseDivViewExtensionsKt.dpToPx(56, getResources().getDisplayMetrics());
            }
            this.mTabMaxWidth = iDpToPx2;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            if (this.mMode == 1) {
                if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 == 0 || i3 == i) {
            return;
        }
        setScrollToSelectedTab();
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.mTabIndicators.getChildAt(i);
        int tabPositionInLayout = this.mTabIndicators.getTabPositionInLayout(i);
        this.mTabIndicators.removeViewAt(tabPositionInLayout);
        this.mTabTitleDelimitersController.tabRemoved(tabPositionInLayout);
        if (tabView != null) {
            tabView.reset();
            this.mTabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewsKt.isActuallyLaidOut(this) || this.mTabIndicators.childrenNeedLayout()) {
            setScrollPosition(i, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iCalculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
        if (scrollX != iCalculateScrollXForTab) {
            if (this.mScrollAnimator == null) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(new int[0]);
                this.mScrollAnimator = valueAnimatorOfInt;
                valueAnimatorOfInt.setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.mScrollAnimator.setDuration(this.mAnimationDuration);
                this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.m6246xa20563ed(valueAnimator);
                    }
                });
            }
            this.mScrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
            this.mScrollAnimator.start();
        }
        this.mTabIndicators.animateSelectedIndicatorToPosition(i, this.mAnimationDuration);
    }

    /* JADX INFO: renamed from: lambda$animateToTab$0$com-yandex-div-internal-widget-tabs-BaseIndicatorTabLayout, reason: not valid java name */
    /* synthetic */ void m6246xa20563ed(ValueAnimator valueAnimator) {
        scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.mTabIndicators.getChildCount();
        int tabPositionInLayout = this.mTabIndicators.getTabPositionInLayout(i);
        if (tabPositionInLayout >= childCount || this.mTabIndicators.getChildAt(tabPositionInLayout).isSelected()) {
            return;
        }
        int i2 = 0;
        while (i2 < childCount) {
            this.mTabIndicators.getChildAt(i2).setSelected(i2 == tabPositionInLayout);
            i2++;
        }
    }

    void selectTab(Tab tab) {
        selectTab(tab, true);
    }

    public void selectTab(int i) {
        Tab tabAt;
        if (getSelectedTabPosition() == i || (tabAt = getTabAt(i)) == null) {
            return;
        }
        tabAt.select();
    }

    void selectTab(Tab tab, boolean z) {
        OnTabSelectedListener onTabSelectedListener;
        OnTabSelectedListener onTabSelectedListener2;
        Tab tab2 = this.mSelectedTab;
        if (tab2 == tab) {
            if (tab2 != null) {
                OnTabSelectedListener onTabSelectedListener3 = this.mOnTabSelectedListener;
                if (onTabSelectedListener3 != null) {
                    onTabSelectedListener3.onTabReselected(tab2);
                }
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        if (z) {
            int position = tab != null ? tab.getPosition() : -1;
            if (position != -1) {
                setSelectedTabView(position);
            }
            Tab tab3 = this.mSelectedTab;
            if ((tab3 == null || tab3.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
        }
        Tab tab4 = this.mSelectedTab;
        if (tab4 != null && (onTabSelectedListener2 = this.mOnTabSelectedListener) != null) {
            onTabSelectedListener2.onTabUnselected(tab4);
        }
        this.mSelectedTab = tab;
        if (tab == null || (onTabSelectedListener = this.mOnTabSelectedListener) == null) {
            return;
        }
        onTabSelectedListener.onTabSelected(tab);
    }

    private void setScrollToSelectedTab() {
        int position;
        Tab tab = this.mSelectedTab;
        if (tab == null || (position = tab.getPosition()) == -1) {
            return;
        }
        setScrollPosition(position, 0.0f, true);
    }

    private int calculateScrollXForTab(int i, float f) {
        View tab;
        int left;
        int width;
        if (this.mMode != 0 || (tab = this.mTabIndicators.getTab(i)) == null) {
            return 0;
        }
        int width2 = tab.getWidth();
        if (this.mTabScrollPaddingEnabled) {
            left = tab.getLeft();
            width = this.mTabScrollPadding;
        } else {
            int i2 = i + 1;
            View childAt = i2 < this.mTabIndicators.getChildCount() ? this.mTabIndicators.getChildAt(i2) : null;
            left = tab.getLeft() + ((int) ((width2 + (childAt != null ? childAt.getWidth() : 0)) * f * 0.5f)) + (tab.getWidth() / 2);
            width = getWidth() / 2;
        }
        return left - width;
    }

    private void applyModeAndGravity() {
        int iMax;
        int iMax2;
        if (this.mMode == 0) {
            iMax = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
            iMax2 = Math.max(0, this.mContentInsetEnd - this.mTabPaddingEnd);
        } else {
            iMax = 0;
            iMax2 = 0;
        }
        ViewCompat.setPaddingRelative(this.mTabIndicators, iMax, 0, iMax2, 0);
        if (this.mMode == 1) {
            this.mTabIndicators.setGravity(1);
        } else {
            this.mTabIndicators.setGravity(GravityCompat.START);
        }
        updateTabViews(true);
    }

    private void updateTabViews(boolean z) {
        for (int i = 0; i < this.mTabIndicators.getChildCount(); i++) {
            View childAt = this.mTabIndicators.getChildAt(i);
            if (childAt instanceof TabView) {
                childAt.setMinimumWidth(getTabMinWidth());
                updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
            }
        }
    }

    public void bindTypefaceProvider(DivTypefaceProvider divTypefaceProvider) {
        this.mTypefaceProvider = divTypefaceProvider;
    }

    public void setFocusTracker(InputFocusTracker inputFocusTracker) {
        this.mInputFocusTracker = inputFocusTracker;
    }

    public static final class Tab {
        static final int INVALID_POSITION = -1;
        private BaseIndicatorTabLayout mParent;
        private int mPosition;
        private CharSequence mText;
        private TabView mView;

        /* synthetic */ Tab(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Tab() {
            this.mPosition = -1;
        }

        public int getPosition() {
            return this.mPosition;
        }

        void setPosition(int i) {
            this.mPosition = i;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            updateView();
            return this;
        }

        public Tab setText(int i) {
            BaseIndicatorTabLayout baseIndicatorTabLayout = this.mParent;
            if (baseIndicatorTabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setText(baseIndicatorTabLayout.getResources().getText(i));
        }

        public void select() {
            BaseIndicatorTabLayout baseIndicatorTabLayout = this.mParent;
            if (baseIndicatorTabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            baseIndicatorTabLayout.selectTab(this);
        }

        public TabView getTabView() {
            return this.mView;
        }

        public boolean isSelected() {
            BaseIndicatorTabLayout baseIndicatorTabLayout = this.mParent;
            if (baseIndicatorTabLayout != null) {
                return baseIndicatorTabLayout.getSelectedTabPosition() == this.mPosition;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        private void updateView() {
            TabView tabView = this.mView;
            if (tabView != null) {
                tabView.update();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mParent = null;
            this.mView = null;
            this.mText = null;
            this.mPosition = -1;
        }
    }

    static class OvalIndicators extends LinearLayout {
        private static final int UNDEFINED_COLOR = -1;
        private AnimationType mAnimationType;
        private final Path mClipPath;
        protected float[] mCornerRadii;
        private int mFutureSelectedPosition;
        private boolean mHasDelimiters;
        protected int mIndicatorHeight;
        private final Paint mIndicatorPaint;
        private final RectF mIndicatorRect;
        protected int[] mIndicatorsLeft;
        protected int[] mIndicatorsRight;
        protected int mItemSpacing;
        protected float mOffset;
        private float mOpacity;
        private final int mPaddingBottom;
        private final int mPaddingTop;
        protected int mSelectedColor;
        protected ValueAnimator mSelectedIndicatorAnimator;
        protected int mSelectedIndicatorLeft;
        protected int mSelectedIndicatorRight;
        protected int mSelectedPosition;
        private int mSize;
        protected int mUnselectedColor;

        private static boolean isTransparentColor(int i) {
            return (i >> 24) == 0;
        }

        /* synthetic */ OvalIndicators(Context context, int i, int i2, AnonymousClass1 anonymousClass1) {
            this(context, i, i2);
        }

        private OvalIndicators(Context context, int i, int i2) {
            super(context);
            this.mSelectedColor = -1;
            this.mUnselectedColor = -1;
            this.mSelectedPosition = -1;
            this.mItemSpacing = 0;
            this.mSelectedIndicatorLeft = -1;
            this.mSelectedIndicatorRight = -1;
            this.mOpacity = 1.0f;
            this.mFutureSelectedPosition = -1;
            this.mAnimationType = AnimationType.SLIDE;
            setId(R.id.tab_sliding_oval_indicator);
            setWillNotDraw(false);
            int childCount = getChildCount();
            this.mSize = childCount;
            if (this.mHasDelimiters) {
                this.mSize = (childCount + 1) / 2;
            }
            initIndicatorArrays(this.mSize);
            Paint paint = new Paint();
            this.mIndicatorPaint = paint;
            paint.setAntiAlias(true);
            this.mIndicatorRect = new RectF();
            this.mPaddingTop = i;
            this.mPaddingBottom = i2;
            this.mClipPath = new Path();
            this.mCornerRadii = new float[8];
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            updateIndicatorsPosition();
            ValueAnimator valueAnimator = this.mSelectedIndicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.mSelectedIndicatorAnimator.cancel();
            animateSelectedIndicatorToPosition(this.mFutureSelectedPosition, Math.round((1.0f - this.mSelectedIndicatorAnimator.getAnimatedFraction()) * this.mSelectedIndicatorAnimator.getDuration()));
        }

        @Override // android.view.ViewGroup
        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            int childCount = getChildCount();
            if (i < 0) {
                i = childCount;
            }
            if (i == 0) {
                if (childCount != 0) {
                    View childAt = getChildAt(0);
                    updateViewLayout(childAt, setLeftMargin(childAt.getLayoutParams(), this.mItemSpacing));
                }
                super.addView(view, i, setLeftMargin(layoutParams, 0));
                return;
            }
            super.addView(view, i, setLeftMargin(layoutParams, this.mItemSpacing));
        }

        private ViewGroup.MarginLayoutParams setLeftMargin(ViewGroup.LayoutParams layoutParams, int i) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = i;
            return marginLayoutParams;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            float height = getHeight();
            if (this.mUnselectedColor != -1) {
                int i = this.mSize;
                for (int i2 = 0; i2 < i; i2++) {
                    drawRoundRect(canvas, this.mIndicatorsLeft[i2], this.mIndicatorsRight[i2], height, this.mUnselectedColor, 1.0f);
                }
            }
            if (this.mSelectedColor != -1) {
                int tabPositionInLayout = getTabPositionInLayout(this.mSelectedPosition);
                int tabPositionInLayout2 = getTabPositionInLayout(this.mFutureSelectedPosition);
                int i3 = AnonymousClass1.$SwitchMap$com$yandex$div$internal$widget$tabs$BaseIndicatorTabLayout$AnimationType[this.mAnimationType.ordinal()];
                if (i3 == 1) {
                    drawRoundRect(canvas, this.mIndicatorsLeft[tabPositionInLayout], this.mIndicatorsRight[tabPositionInLayout], height, this.mSelectedColor, this.mOpacity);
                    if (this.mFutureSelectedPosition != -1) {
                        drawRoundRect(canvas, this.mIndicatorsLeft[tabPositionInLayout2], this.mIndicatorsRight[tabPositionInLayout2], height, this.mSelectedColor, 1.0f - this.mOpacity);
                    }
                } else if (i3 == 2) {
                    drawRoundRect(canvas, this.mSelectedIndicatorLeft, this.mSelectedIndicatorRight, height, this.mSelectedColor, 1.0f);
                } else {
                    drawRoundRect(canvas, this.mIndicatorsLeft[tabPositionInLayout], this.mIndicatorsRight[tabPositionInLayout], height, this.mSelectedColor, 1.0f);
                }
            }
            super.draw(canvas);
        }

        private void drawRoundRect(Canvas canvas, int i, int i2, float f, int i3, float f2) {
            if (i < 0 || i2 <= i) {
                return;
            }
            this.mIndicatorRect.set(i, this.mPaddingTop, i2, f - this.mPaddingBottom);
            float fWidth = this.mIndicatorRect.width();
            float fHeight = this.mIndicatorRect.height();
            float[] fArr = new float[8];
            for (int i4 = 0; i4 < 8; i4++) {
                fArr[i4] = clampCornerRadius(this.mCornerRadii[i4], fWidth, fHeight);
            }
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(this.mIndicatorRect, fArr, Path.Direction.CW);
            this.mClipPath.close();
            this.mIndicatorPaint.setColor(i3);
            this.mIndicatorPaint.setAlpha(Math.round(this.mIndicatorPaint.getAlpha() * f2));
            canvas.drawPath(this.mClipPath, this.mIndicatorPaint);
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void setSelectedIndicatorColor(int i) {
            if (this.mSelectedColor != i) {
                if (isTransparentColor(i)) {
                    this.mSelectedColor = -1;
                } else {
                    this.mSelectedColor = i;
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setAnimationType(AnimationType animationType) {
            if (this.mAnimationType != animationType) {
                this.mAnimationType = animationType;
                ValueAnimator valueAnimator = this.mSelectedIndicatorAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.mSelectedIndicatorAnimator.cancel();
            }
        }

        void setIndicatorColor(int i) {
            if (this.mUnselectedColor != i) {
                if (isTransparentColor(i)) {
                    this.mUnselectedColor = -1;
                } else {
                    this.mUnselectedColor = i;
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setIndicatorHeight(int i) {
            if (this.mIndicatorHeight != i) {
                this.mIndicatorHeight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setIndicatorCornersRadii(float[] fArr) {
            if (Arrays.equals(this.mCornerRadii, fArr)) {
                return;
            }
            this.mCornerRadii = fArr;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void setItemSpacing(int i) {
            if (i != this.mItemSpacing) {
                this.mItemSpacing = i;
                int childCount = getChildCount();
                for (int i2 = 1; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    updateViewLayout(childAt, setLeftMargin(childAt.getLayoutParams(), this.mItemSpacing));
                }
            }
        }

        void setContainsDelimiters(boolean z) {
            if (this.mHasDelimiters != z) {
                this.mHasDelimiters = z;
                updateOpacity();
                updateIndicatorsPosition();
            }
        }

        boolean hasDelimiters() {
            return this.mHasDelimiters;
        }

        View getTab(int i) {
            return getChildAt(getTabPositionInLayout(i));
        }

        void animateSelectedIndicatorToPosition(int i, long j) {
            ValueAnimator valueAnimator = this.mSelectedIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mSelectedIndicatorAnimator.cancel();
                j = Math.round((1.0f - this.mSelectedIndicatorAnimator.getAnimatedFraction()) * this.mSelectedIndicatorAnimator.getDuration());
            }
            long j2 = j;
            View tab = getTab(i);
            if (tab == null) {
                updateIndicatorsPosition();
                return;
            }
            int i2 = AnonymousClass1.$SwitchMap$com$yandex$div$internal$widget$tabs$BaseIndicatorTabLayout$AnimationType[this.mAnimationType.ordinal()];
            if (i2 == 1) {
                startSelectedIndicatorFadeAnimation(i, j2);
            } else if (i2 == 2) {
                startSelectedIndicatorSlideAnimation(i, j2, this.mSelectedIndicatorLeft, this.mSelectedIndicatorRight, tab.getLeft(), tab.getRight());
            } else {
                setSelectedIndicatorPositionFromTabPosition(i, 0.0f);
            }
        }

        void setSelectedIndicatorPositionFromTabPosition(int i, float f) {
            ValueAnimator valueAnimator = this.mSelectedIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mSelectedIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = i;
            this.mOffset = f;
            updateIndicatorsPosition();
            updateOpacity();
        }

        protected void updateIndicatorsPosition() {
            int i;
            int right;
            int i2;
            int i3;
            int childCount = getChildCount();
            if (childCount != this.mSize) {
                initIndicatorArrays(childCount);
            }
            int tabPositionInLayout = getTabPositionInLayout(this.mSelectedPosition);
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt instanceof TabView) {
                    if (childAt.getWidth() > 0) {
                        int left = childAt.getLeft();
                        right = childAt.getRight();
                        if (this.mAnimationType != AnimationType.SLIDE || i4 != tabPositionInLayout || this.mOffset <= 0.0f || i4 >= childCount - 1) {
                            i2 = left;
                            i3 = i2;
                            i = right;
                        } else {
                            View childAt2 = getChildAt(this.mHasDelimiters ? i4 + 2 : i4 + 1);
                            float left2 = this.mOffset * childAt2.getLeft();
                            float f = this.mOffset;
                            i3 = (int) (left2 + ((1.0f - f) * left));
                            int right2 = (int) ((f * childAt2.getRight()) + ((1.0f - this.mOffset) * right));
                            i2 = left;
                            i = right2;
                        }
                    } else {
                        i = -1;
                        right = -1;
                        i2 = -1;
                        i3 = -1;
                    }
                    setUnselectedIndicatorPosition(i4, i2, right);
                    if (i4 == tabPositionInLayout) {
                        setSelectedIndicatorPosition(i3, i);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTabPositionInLayout(int i) {
            return (!this.mHasDelimiters || i == -1) ? i : i * 2;
        }

        protected void updateOpacity() {
            float f = 1.0f - this.mOffset;
            if (f != this.mOpacity) {
                this.mOpacity = f;
                int i = this.mSelectedPosition + 1;
                if (i >= this.mSize) {
                    i = -1;
                }
                this.mFutureSelectedPosition = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        protected void setUnselectedIndicatorPosition(int i, int i2, int i3) {
            int[] iArr = this.mIndicatorsLeft;
            int i4 = iArr[i];
            int[] iArr2 = this.mIndicatorsRight;
            int i5 = iArr2[i];
            if (i2 == i4 && i3 == i5) {
                return;
            }
            iArr[i] = i2;
            iArr2[i] = i3;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        protected void setSelectedIndicatorPosition(int i, int i2) {
            if (i == this.mSelectedIndicatorLeft && i2 == this.mSelectedIndicatorRight) {
                return;
            }
            this.mSelectedIndicatorLeft = i;
            this.mSelectedIndicatorRight = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        protected void startSelectedIndicatorSlideAnimation(int i, long j, final int i2, final int i3, final int i4, final int i5) {
            if (i2 == i4 && i3 == i5) {
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(BaseIndicatorTabLayout.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimatorOfFloat.setDuration(j);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$OvalIndicators$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m6248x1a3e5919(i2, i4, i3, i5, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OvalIndicators.1
                private boolean mHasCancel = false;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.mHasCancel = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.mHasCancel) {
                        return;
                    }
                    OvalIndicators ovalIndicators = OvalIndicators.this;
                    ovalIndicators.mSelectedPosition = ovalIndicators.mFutureSelectedPosition;
                    OvalIndicators.this.mOffset = 0.0f;
                }
            });
            this.mFutureSelectedPosition = i;
            this.mSelectedIndicatorAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.start();
        }

        /* JADX INFO: renamed from: lambda$startSelectedIndicatorSlideAnimation$0$com-yandex-div-internal-widget-tabs-BaseIndicatorTabLayout$OvalIndicators, reason: not valid java name */
        /* synthetic */ void m6248x1a3e5919(int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            setSelectedIndicatorPosition(lerp(i, i2, animatedFraction), lerp(i3, i4, animatedFraction));
            ViewCompat.postInvalidateOnAnimation(this);
        }

        protected void startSelectedIndicatorFadeAnimation(int i, long j) {
            if (i != this.mSelectedPosition) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.setInterpolator(BaseIndicatorTabLayout.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimatorOfFloat.setDuration(j);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$OvalIndicators$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.m6247xb6bd6d71(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OvalIndicators.2
                    private boolean mHasCancel = false;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.mHasCancel = true;
                        OvalIndicators.this.mOpacity = 1.0f;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (this.mHasCancel) {
                            return;
                        }
                        OvalIndicators ovalIndicators = OvalIndicators.this;
                        ovalIndicators.mSelectedPosition = ovalIndicators.mFutureSelectedPosition;
                        OvalIndicators.this.mOffset = 0.0f;
                    }
                });
                this.mFutureSelectedPosition = i;
                this.mSelectedIndicatorAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
            }
        }

        /* JADX INFO: renamed from: lambda$startSelectedIndicatorFadeAnimation$1$com-yandex-div-internal-widget-tabs-BaseIndicatorTabLayout$OvalIndicators, reason: not valid java name */
        /* synthetic */ void m6247xb6bd6d71(ValueAnimator valueAnimator) {
            this.mOpacity = 1.0f - valueAnimator.getAnimatedFraction();
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void initIndicatorArrays(int i) {
            this.mSize = i;
            this.mIndicatorsLeft = new int[i];
            this.mIndicatorsRight = new int[i];
            for (int i2 = 0; i2 < this.mSize; i2++) {
                this.mIndicatorsLeft[i2] = -1;
                this.mIndicatorsRight[i2] = -1;
            }
        }

        private static int lerp(int i, int i2, float f) {
            return i + Math.round(f * (i2 - i));
        }

        private static float clampCornerRadius(float f, float f2, float f3) {
            if (f3 <= 0.0f || f2 <= 0.0f) {
                return 0.0f;
            }
            float fMin = Math.min(f3, f2) / 2.0f;
            if (f == -1.0f) {
                return fMin;
            }
            if (f > fMin) {
                Log.e("BaseIndicatorTabLayout", "Corner radius is too big");
            }
            return Math.min(f, fMin);
        }
    }

    /* JADX INFO: renamed from: com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yandex$div$internal$widget$tabs$BaseIndicatorTabLayout$AnimationType;

        static {
            int[] iArr = new int[AnimationType.values().length];
            $SwitchMap$com$yandex$div$internal$widget$tabs$BaseIndicatorTabLayout$AnimationType = iArr;
            try {
                iArr[AnimationType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yandex$div$internal$widget$tabs$BaseIndicatorTabLayout$AnimationType[AnimationType.SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getTabMinWidth() {
        int i = this.mRequestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        if (this.mMode == 0) {
            return this.mScrollableTabMinWidth;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mNestedScrollCompanion.dispatchOnScrollChanged();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        this.mNestedScrollCompanion.dispatchOnOverScrolled(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.mNestedScrollCompanion.dispatchTouchEventAfterSuperCall(motionEvent);
        return zDispatchTouchEvent;
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<BaseIndicatorTabLayout> mTabLayoutRef;

        TabLayoutOnPageChangeListener(BaseIndicatorTabLayout baseIndicatorTabLayout) {
            this.mTabLayoutRef = new WeakReference<>(baseIndicatorTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            BaseIndicatorTabLayout baseIndicatorTabLayout = this.mTabLayoutRef.get();
            if (baseIndicatorTabLayout != null) {
                if (this.mScrollState != 2 || this.mPreviousScrollState == 1) {
                    baseIndicatorTabLayout.setScrollPosition(i, f, true, true);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            BaseIndicatorTabLayout baseIndicatorTabLayout = this.mTabLayoutRef.get();
            if (baseIndicatorTabLayout == null || baseIndicatorTabLayout.getSelectedTabPosition() == i) {
                return;
            }
            int i2 = this.mScrollState;
            baseIndicatorTabLayout.selectTab(baseIndicatorTabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.mPreviousScrollState == 0));
        }

        public void reset() {
            this.mScrollState = 0;
            this.mPreviousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }

        @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }

        ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
        public void onTabSelected(Tab tab) {
            this.mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    private class PagerAdapterObserver extends DataSetObserver {
        private PagerAdapterObserver() {
        }

        /* synthetic */ PagerAdapterObserver(BaseIndicatorTabLayout baseIndicatorTabLayout, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            BaseIndicatorTabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            BaseIndicatorTabLayout.this.populateFromPagerAdapter();
        }
    }
}
