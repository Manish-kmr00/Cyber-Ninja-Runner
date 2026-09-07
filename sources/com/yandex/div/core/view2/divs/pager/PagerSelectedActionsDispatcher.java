package com.yandex.div.core.view2.divs.pager;

import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagerSelectedActionsDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher;", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "(Lcom/yandex/div/core/view2/Div2View;Ljava/util/List;Lcom/yandex/div/core/view2/divs/DivActionBinder;)V", "<set-?>", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "pageSelectionTracker", "getPageSelectionTracker", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "attach", "", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "detach", "dispatchSelectedActions", "item", "PageSelectionTracker", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PagerSelectedActionsDispatcher {
    private final DivActionBinder divActionBinder;
    private final Div2View divView;
    private final List<DivItemBuilderResult> items;
    private ViewPager2.OnPageChangeCallback pageSelectionTracker;

    public PagerSelectedActionsDispatcher(Div2View divView, List<DivItemBuilderResult> items, DivActionBinder divActionBinder) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        this.divView = divView;
        this.items = items;
        this.divActionBinder = divActionBinder;
    }

    public final ViewPager2.OnPageChangeCallback getPageSelectionTracker() {
        return this.pageSelectionTracker;
    }

    public final void attach(ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        PageSelectionTracker pageSelectionTracker = new PageSelectionTracker();
        viewPager.registerOnPageChangeCallback(pageSelectionTracker);
        this.pageSelectionTracker = pageSelectionTracker;
    }

    public final void detach(ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.pageSelectionTracker;
        if (onPageChangeCallback != null) {
            viewPager.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        this.pageSelectionTracker = null;
    }

    /* JADX INFO: compiled from: PagerSelectedActionsDispatcher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher$PageSelectionTracker;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "(Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher;)V", "currentPage", "", "selectedPages", "Lkotlin/collections/ArrayDeque;", "onPageScrollStateChanged", "", "state", "onPageSelected", b9.h.L, "trackSelectedPages", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class PageSelectionTracker extends ViewPager2.OnPageChangeCallback {
        private int currentPage = -1;
        private final ArrayDeque<Integer> selectedPages = new ArrayDeque<>();

        public PageSelectionTracker() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.DEBUG)) {
                kLog.print(3, "Ya:PagerSelectedActionsTracker", "onPageSelected(" + position + ')');
            }
            if (this.currentPage == position) {
                return;
            }
            if (position != -1) {
                this.selectedPages.add(Integer.valueOf(position));
            }
            if (this.currentPage == -1) {
                trackSelectedPages();
            }
            this.currentPage = position;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                trackSelectedPages();
            }
        }

        private final void trackSelectedPages() {
            while (!this.selectedPages.isEmpty()) {
                int iIntValue = this.selectedPages.removeFirst().intValue();
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.DEBUG)) {
                    kLog.print(3, "Ya:PagerSelectedActionsTracker", "dispatch selected actions for page " + iIntValue);
                }
                PagerSelectedActionsDispatcher pagerSelectedActionsDispatcher = PagerSelectedActionsDispatcher.this;
                pagerSelectedActionsDispatcher.dispatchSelectedActions((DivItemBuilderResult) pagerSelectedActionsDispatcher.items.get(iIntValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchSelectedActions(final DivItemBuilderResult item) {
        final List<DivAction> selectedActions = item.getDiv().value().getSelectedActions();
        if (selectedActions != null) {
            this.divView.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.pager.PagerSelectedActionsDispatcher$dispatchSelectedActions$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DivActionBinder.handleActions$div_release$default(this.this$0.divActionBinder, this.this$0.divView, item.getExpressionResolver(), selectedActions, DivActionHandler.DivActionReason.SELECTION, null, 16, null);
                }
            });
        }
    }
}
