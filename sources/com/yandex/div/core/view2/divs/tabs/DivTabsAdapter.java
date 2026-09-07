package com.yandex.div.core.view2.divs.tabs;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.yandex.div.core.downloader.DivPatchApply;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.downloader.DivPatchMap;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.widgets.ReleaseUtils;
import com.yandex.div.internal.viewpool.ViewPool;
import com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi;
import com.yandex.div.internal.widget.tabs.HeightCalculatorFactory;
import com.yandex.div.internal.widget.tabs.ScrollableViewPager;
import com.yandex.div.internal.widget.tabs.TabTextStyleProvider;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivTabs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTabsAdapter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001Bm\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0018\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000209J \u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020(H\u0014J \u0010A\u001a\u00020\b2\u0006\u0010<\u001a\u00020B2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u00020(H\u0002J \u0010C\u001a\u00020D2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020(H\u0014J\u0018\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020(2\u0006\u0010<\u001a\u00020BH\u0002J\u0006\u0010G\u001a\u00020DJ\u001c\u0010H\u001a\u00020D2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020J2\u0006\u0010K\u001a\u00020(J\u0010\u0010L\u001a\u00020D2\u0006\u0010>\u001a\u00020\u0003H\u0014R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001c0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002070'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/DivTabsAdapter;", "Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi;", "Lcom/yandex/div/core/view2/divs/tabs/DivSimpleTab;", "Landroid/view/ViewGroup;", "Lcom/yandex/div2/DivAction;", "viewPool", "Lcom/yandex/div/internal/viewpool/ViewPool;", "view", "Landroid/view/View;", "tabbedCardConfig", "Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi$TabbedCardConfig;", "heightCalculatorFactory", "Lcom/yandex/div/internal/widget/tabs/HeightCalculatorFactory;", "isDynamicHeight", "", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "textStyleProvider", "Lcom/yandex/div/internal/widget/tabs/TabTextStyleProvider;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "divTabsEventManager", "Lcom/yandex/div/core/view2/divs/tabs/DivTabsEventManager;", "activeStateTracker", "Lcom/yandex/div/core/view2/divs/tabs/DivTabsActiveStateTracker;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "(Lcom/yandex/div/internal/viewpool/ViewPool;Landroid/view/View;Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi$TabbedCardConfig;Lcom/yandex/div/internal/widget/tabs/HeightCalculatorFactory;ZLcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/internal/widget/tabs/TabTextStyleProvider;Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/view2/divs/tabs/DivTabsEventManager;Lcom/yandex/div/core/view2/divs/tabs/DivTabsActiveStateTracker;Lcom/yandex/div/core/state/DivStatePath;Lcom/yandex/div/core/downloader/DivPatchCache;)V", "getActiveStateTracker", "()Lcom/yandex/div/core/view2/divs/tabs/DivTabsActiveStateTracker;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "childStates", "", "", "getDivTabsEventManager", "()Lcom/yandex/div/core/view2/divs/tabs/DivTabsEventManager;", "()Z", "pager", "Lcom/yandex/div/core/view2/divs/tabs/PagerController;", "getPager", "()Lcom/yandex/div/core/view2/divs/tabs/PagerController;", "value", "statePath", "getStatePath", "()Lcom/yandex/div/core/state/DivStatePath;", "setStatePath", "(Lcom/yandex/div/core/state/DivStatePath;)V", "tabModels", "Lcom/yandex/div/core/view2/divs/tabs/TabModel;", "applyPatch", "Lcom/yandex/div2/DivTabs;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div", "bindTabData", "tabView", "tab", "tabNumber", "createItemView", "Lcom/yandex/div2/Div;", "fillMeasuringTab", "", "getChildPath", "index", "notifyStateChanged", "setData", "data", "Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi$Input;", "selectedTab", "unbindTabData", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTabsAdapter extends BaseDivTabbedCardUi<DivSimpleTab, ViewGroup, DivAction> {
    private final DivTabsActiveStateTracker activeStateTracker;
    private BindingContext bindingContext;
    private final Map<Integer, DivStatePath> childStates;
    private final DivBinder divBinder;
    private final DivPatchCache divPatchCache;
    private final DivTabsEventManager divTabsEventManager;
    private final boolean isDynamicHeight;
    private final PagerController pager;
    private DivStatePath path;
    private final Map<ViewGroup, TabModel> tabModels;
    private final View view;
    private final DivViewCreator viewCreator;

    /* JADX INFO: Access modifiers changed from: private */
    public static final List applyPatch$lambda$4(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        return list;
    }

    /* JADX INFO: renamed from: isDynamicHeight, reason: from getter */
    public final boolean getIsDynamicHeight() {
        return this.isDynamicHeight;
    }

    public final BindingContext getBindingContext() {
        return this.bindingContext;
    }

    public final void setBindingContext(BindingContext bindingContext) {
        Intrinsics.checkNotNullParameter(bindingContext, "<set-?>");
        this.bindingContext = bindingContext;
    }

    public final DivTabsEventManager getDivTabsEventManager() {
        return this.divTabsEventManager;
    }

    public final DivTabsActiveStateTracker getActiveStateTracker() {
        return this.activeStateTracker;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivTabsAdapter(ViewPool viewPool, View view, BaseDivTabbedCardUi.TabbedCardConfig tabbedCardConfig, HeightCalculatorFactory heightCalculatorFactory, boolean z, BindingContext bindingContext, TabTextStyleProvider textStyleProvider, DivViewCreator viewCreator, DivBinder divBinder, DivTabsEventManager divTabsEventManager, DivTabsActiveStateTracker activeStateTracker, DivStatePath path, DivPatchCache divPatchCache) {
        super(viewPool, view, tabbedCardConfig, heightCalculatorFactory, textStyleProvider, divTabsEventManager, divTabsEventManager, activeStateTracker);
        Intrinsics.checkNotNullParameter(viewPool, "viewPool");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tabbedCardConfig, "tabbedCardConfig");
        Intrinsics.checkNotNullParameter(heightCalculatorFactory, "heightCalculatorFactory");
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(textStyleProvider, "textStyleProvider");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(divTabsEventManager, "divTabsEventManager");
        Intrinsics.checkNotNullParameter(activeStateTracker, "activeStateTracker");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        this.view = view;
        this.isDynamicHeight = z;
        this.bindingContext = bindingContext;
        this.viewCreator = viewCreator;
        this.divBinder = divBinder;
        this.divTabsEventManager = divTabsEventManager;
        this.activeStateTracker = activeStateTracker;
        this.path = path;
        this.divPatchCache = divPatchCache;
        this.tabModels = new LinkedHashMap();
        this.childStates = new LinkedHashMap();
        ScrollableViewPager mPager = this.mPager;
        Intrinsics.checkNotNullExpressionValue(mPager, "mPager");
        this.pager = new PagerController(mPager);
    }

    /* JADX INFO: renamed from: getStatePath, reason: from getter */
    public final DivStatePath getPath() {
        return this.path;
    }

    public final void setStatePath(DivStatePath value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.path = value;
        this.childStates.clear();
    }

    public final void setData(BaseDivTabbedCardUi.Input<DivSimpleTab> data, int selectedTab) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.setData(data, this.bindingContext.getExpressionResolver(), ReleasablesKt.getExpressionSubscriber(this.view));
        this.tabModels.clear();
        this.mPager.setCurrentItem(selectedTab, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi
    public ViewGroup bindTabData(ViewGroup tabView, DivSimpleTab tab, int tabNumber) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        Intrinsics.checkNotNullParameter(tab, "tab");
        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(tabView, this.bindingContext.getDivView());
        Div div = tab.getItem().div;
        View viewCreateItemView = createItemView(div, this.bindingContext.getExpressionResolver(), tabNumber);
        this.tabModels.put(tabView, new TabModel(tabNumber, div, viewCreateItemView));
        tabView.addView(viewCreateItemView);
        return tabView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi
    public void unbindTabData(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        this.tabModels.remove(tabView);
        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(tabView, this.bindingContext.getDivView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi
    public void fillMeasuringTab(ViewGroup tabView, DivSimpleTab tab, int tabNumber) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        Intrinsics.checkNotNullParameter(tab, "tab");
        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(tabView, this.bindingContext.getDivView());
        tabView.addView(createItemView(tab.getItem().div, this.bindingContext.getExpressionResolver(), tabNumber));
    }

    private final View createItemView(Div div, ExpressionResolver resolver, int tabNumber) {
        View viewCreate = this.viewCreator.create(div, resolver);
        viewCreate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.divBinder.bind(this.bindingContext, viewCreate, div, getChildPath(tabNumber, div));
        return viewCreate;
    }

    private final DivStatePath getChildPath(int index, Div div) {
        Map<Integer, DivStatePath> map = this.childStates;
        Integer numValueOf = Integer.valueOf(index);
        DivStatePath divStatePathResolvePath = map.get(numValueOf);
        if (divStatePathResolvePath == null) {
            divStatePathResolvePath = BaseDivViewExtensionsKt.resolvePath(div.value(), index, this.path);
            map.put(numValueOf, divStatePathResolvePath);
        }
        return divStatePathResolvePath;
    }

    public final void notifyStateChanged() {
        for (Map.Entry<ViewGroup, TabModel> entry : this.tabModels.entrySet()) {
            ViewGroup key = entry.getKey();
            TabModel value = entry.getValue();
            this.divBinder.bind(this.bindingContext, value.getView(), value.getDiv(), getChildPath(value.getIndex(), value.getDiv()));
            key.requestLayout();
        }
    }

    public final DivTabs applyPatch(ExpressionResolver resolver, DivTabs div) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(div, "div");
        DivPatchMap patch = this.divPatchCache.getPatch(this.bindingContext.getDivView().getDataTag());
        if (patch == null) {
            return null;
        }
        DivBase divBaseValue = new DivPatchApply(patch).applyPatchForDiv(new Div.Tabs(div), resolver).get(0).value();
        Intrinsics.checkNotNull(divBaseValue, "null cannot be cast to non-null type com.yandex.div2.DivTabs");
        DivTabs divTabs = (DivTabs) divBaseValue;
        DisplayMetrics displayMetrics = this.bindingContext.getDivView().getResources().getDisplayMetrics();
        List<DivTabs.Item> list = divTabs.items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DivTabs.Item item : list) {
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            arrayList.add(new DivSimpleTab(item, displayMetrics, resolver));
        }
        final ArrayList arrayList2 = arrayList;
        setData(new BaseDivTabbedCardUi.Input() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsAdapter$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.Input
            public final List getTabs() {
                return DivTabsAdapter.applyPatch$lambda$4(arrayList2);
            }
        }, this.mPager.getCurrentItem());
        return divTabs;
    }

    public final PagerController getPager() {
        return this.pager;
    }
}
