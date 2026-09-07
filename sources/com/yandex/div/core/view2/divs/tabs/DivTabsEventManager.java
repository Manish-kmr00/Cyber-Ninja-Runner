package com.yandex.div.core.view2.divs.tabs;

import androidx.viewpager.widget.ViewPager;
import com.json.b9;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.widgets.DivTabsLayout;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivTabs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTabsEventManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001$B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/DivTabsEventManager;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi$ActiveTabClickListener;", "Lcom/yandex/div2/DivAction;", "context", "Lcom/yandex/div/core/view2/BindingContext;", "actionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "div2Logger", "Lcom/yandex/div/core/Div2Logger;", "visibilityActionTracker", "Lcom/yandex/div/core/view2/DivVisibilityActionTracker;", "tabLayout", "Lcom/yandex/div/core/view2/divs/widgets/DivTabsLayout;", "div", "Lcom/yandex/div2/DivTabs;", "(Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/DivVisibilityActionTracker;Lcom/yandex/div/core/view2/divs/widgets/DivTabsLayout;Lcom/yandex/div2/DivTabs;)V", "currentPagePosition", "", "getDiv", "()Lcom/yandex/div2/DivTabs;", "setDiv", "(Lcom/yandex/div2/DivTabs;)V", "onActiveTabClicked", "", "action", "tabPosition", "onPageDisplayed", b9.h.L, "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTabsEventManager implements ViewPager.OnPageChangeListener, BaseDivTabbedCardUi.ActiveTabClickListener<DivAction> {
    private static final Companion Companion = new Companion(null);
    private static final int NO_POSITION = -1;
    private static final String TAG = "DivTabsEventManager";
    private final DivActionBinder actionBinder;
    private final BindingContext context;
    private int currentPagePosition;
    private DivTabs div;
    private final Div2Logger div2Logger;
    private final DivTabsLayout tabLayout;
    private final DivVisibilityActionTracker visibilityActionTracker;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public DivTabsEventManager(BindingContext context, DivActionBinder actionBinder, Div2Logger div2Logger, DivVisibilityActionTracker visibilityActionTracker, DivTabsLayout tabLayout, DivTabs div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionBinder, "actionBinder");
        Intrinsics.checkNotNullParameter(div2Logger, "div2Logger");
        Intrinsics.checkNotNullParameter(visibilityActionTracker, "visibilityActionTracker");
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        Intrinsics.checkNotNullParameter(div, "div");
        this.context = context;
        this.actionBinder = actionBinder;
        this.div2Logger = div2Logger;
        this.visibilityActionTracker = visibilityActionTracker;
        this.tabLayout = tabLayout;
        this.div = div;
        this.currentPagePosition = -1;
    }

    public final DivTabs getDiv() {
        return this.div;
    }

    public final void setDiv(DivTabs divTabs) {
        Intrinsics.checkNotNullParameter(divTabs, "<set-?>");
        this.div = divTabs;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        this.div2Logger.logTabPageChanged(this.context.getDivView(), position);
        onPageDisplayed(position);
    }

    public final void onPageDisplayed(int position) {
        int i = this.currentPagePosition;
        if (position == i) {
            return;
        }
        if (i != -1) {
            this.visibilityActionTracker.cancelTrackingViewsHierarchy(this.context, this.tabLayout, this.div.items.get(this.currentPagePosition).div);
            this.context.getDivView().unbindViewFromDiv$div_release(this.tabLayout);
        }
        DivTabs.Item item = this.div.items.get(position);
        this.visibilityActionTracker.startTrackingViewsHierarchy(this.context, this.tabLayout, item.div);
        this.context.getDivView().bindViewToDiv$div_release(this.tabLayout, item.div);
        this.currentPagePosition = position;
    }

    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.ActiveTabClickListener
    public void onActiveTabClicked(DivAction action, int tabPosition) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.menuItems != null) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.WARNING)) {
                kLog.print(5, TAG, "non-null menuItems ignored in title click action");
            }
        }
        this.div2Logger.logActiveTabTitleClick(this.context.getDivView(), this.context.getExpressionResolver(), tabPosition, action);
        DivActionBinder.handleAction$div_release$default(this.actionBinder, this.context.getDivView(), this.context.getExpressionResolver(), action, "click", null, null, 48, null);
    }

    /* JADX INFO: compiled from: DivTabsEventManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/DivTabsEventManager$Companion;", "", "()V", "NO_POSITION", "", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
