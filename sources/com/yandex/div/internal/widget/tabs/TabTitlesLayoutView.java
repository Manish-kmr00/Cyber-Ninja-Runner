package com.yandex.div.internal.widget.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.view2.divs.tabs.DivTabsBinderKt;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.viewpool.PseudoViewPool;
import com.yandex.div.internal.viewpool.ViewFactory;
import com.yandex.div.internal.viewpool.ViewPool;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivTabs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TabTitlesLayoutView<ACTION> extends BaseIndicatorTabLayout implements BaseDivTabbedCardUi.AbstractTabBar<ACTION> {
    private static final String FACTORY_TAG_TAB_HEADER = "TabTitlesLayoutView.TAB_HEADER";
    private List<? extends BaseDivTabbedCardUi.Input.TabBase<ACTION>> mDataList;
    private final PseudoViewPool mDefaultViewPool;
    private BaseDivTabbedCardUi.AbstractTabBar.Host<ACTION> mHost;
    private OnScrollChangedListener mOnScrollChangedListener;
    private boolean mShouldDispatchScroll;
    private String mTabHeaderTag;
    private DivTabs.TabTitleStyle mTabTitleStyle;
    private ViewPool mViewPool;

    public interface OnScrollChangedListener {
        void onScrolled();
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setIntermediateState(int i, float f) {
    }

    public TabTitlesLayoutView(Context context) {
        this(context, null, 0);
    }

    public TabTitlesLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTitlesLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldDispatchScroll = false;
        setTabMode(0);
        setTabIndicatorHeight(0);
        setOnTabSelectedListener(new BaseIndicatorTabLayout.OnTabSelectedListener() { // from class: com.yandex.div.internal.widget.tabs.TabTitlesLayoutView.1
            @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
            public void onTabUnselected(BaseIndicatorTabLayout.Tab tab) {
            }

            @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
            public void onTabSelected(BaseIndicatorTabLayout.Tab tab) {
                if (TabTitlesLayoutView.this.mHost == null) {
                    return;
                }
                TabTitlesLayoutView.this.mHost.setCurrentPage(tab.getPosition(), false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout.OnTabSelectedListener
            public void onTabReselected(BaseIndicatorTabLayout.Tab tab) {
                if (TabTitlesLayoutView.this.mHost == null) {
                    return;
                }
                int position = tab.getPosition();
                if (TabTitlesLayoutView.this.mDataList != null) {
                    BaseDivTabbedCardUi.Input.TabBase tabBase = (BaseDivTabbedCardUi.Input.TabBase) TabTitlesLayoutView.this.mDataList.get(position);
                    Object actionable = tabBase == null ? null : tabBase.getActionable();
                    if (actionable != null) {
                        TabTitlesLayoutView.this.mHost.onActiveTabClicked(actionable, position);
                    }
                }
            }
        });
        PseudoViewPool pseudoViewPool = new PseudoViewPool();
        this.mDefaultViewPool = pseudoViewPool;
        pseudoViewPool.register(FACTORY_TAG_TAB_HEADER, new TabViewFactory(getContext()), 0);
        this.mViewPool = pseudoViewPool;
        this.mTabHeaderTag = FACTORY_TAG_TAB_HEADER;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setViewPool(ViewPool viewPool, String str) {
        this.mViewPool = viewPool;
        this.mTabHeaderTag = str;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout
    protected TabView createTabView(Context context) {
        return (TabView) this.mViewPool.obtain(this.mTabHeaderTag);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setHost(BaseDivTabbedCardUi.AbstractTabBar.Host<ACTION> host) {
        this.mHost = host;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setData(List<? extends BaseDivTabbedCardUi.Input.TabBase<ACTION>> list, int i, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        this.mDataList = list;
        removeAllTabs();
        int size = list.size();
        if (i < 0 || i >= size) {
            i = 0;
        }
        int i2 = 0;
        while (i2 < size) {
            BaseIndicatorTabLayout.Tab text = newTab().setText(list.get(i2).getTitle());
            observeTabTitleStyle(text.getTabView(), expressionResolver, expressionSubscriber);
            addTab(text, i2 == i);
            i2++;
        }
    }

    private void observeTabTitleStyle(TabView tabView, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        DivTabs.TabTitleStyle tabTitleStyle = this.mTabTitleStyle;
        if (tabTitleStyle == null) {
            return;
        }
        DivTabsBinderKt.observeStyle(tabView, tabTitleStyle, expressionResolver, expressionSubscriber);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void manuallyScroll(int i) {
        selectTab(i);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void fixScrollPosition(int i) {
        selectTab(i);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setTabColors(int i, int i2, int i3, int i4) {
        setTabTextColors(i3, i);
        setSelectedTabIndicatorColor(i2);
        setTabBackgroundColor(i4);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public ViewPager.OnPageChangeListener getCustomPageChangeListener() {
        BaseIndicatorTabLayout.TabLayoutOnPageChangeListener pageChangeListener = getPageChangeListener();
        pageChangeListener.reset();
        return pageChangeListener;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void resetScroll() {
        scrollTo(0, 0);
        manuallyScroll(0);
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedListener onScrollChangedListener = this.mOnScrollChangedListener;
        if (onScrollChangedListener == null || !this.mShouldDispatchScroll) {
            return;
        }
        onScrollChangedListener.onScrolled();
        this.mShouldDispatchScroll = false;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.mShouldDispatchScroll = true;
        }
        return zDispatchTouchEvent;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.mOnScrollChangedListener = onScrollChangedListener;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.AbstractTabBar
    public void setTypefaceProvider(DivTypefaceProvider divTypefaceProvider) {
        bindTypefaceProvider(divTypefaceProvider);
    }

    public void setTabTitleStyle(DivTabs.TabTitleStyle tabTitleStyle) {
        this.mTabTitleStyle = tabTitleStyle;
    }

    public static class TabViewFactory implements ViewFactory<TabView> {
        private final Context mContext;

        public TabViewFactory(Context context) {
            this.mContext = context;
        }

        @Override // com.yandex.div.internal.viewpool.ViewFactory
        public TabView createView() {
            return new TabView(this.mContext);
        }
    }
}
