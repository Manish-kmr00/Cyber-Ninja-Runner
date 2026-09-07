package com.yandex.div.core.view2.divs.tabs;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableKt;
import com.yandex.div.DivDataTag;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivIdLoggingImageDownloadCallback;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.Names;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.expression.local.DivRuntimeVisitor;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.TabsStateCache;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.DivBaseBinder;
import com.yandex.div.core.view2.divs.widgets.DivTabsLayout;
import com.yandex.div.core.view2.divs.widgets.ParentScrollRestrictor;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.util.UiThreadHandler;
import com.yandex.div.internal.viewpool.ViewFactory;
import com.yandex.div.internal.viewpool.ViewPool;
import com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi;
import com.yandex.div.internal.widget.tabs.BaseIndicatorTabLayout;
import com.yandex.div.internal.widget.tabs.DynamicCardHeightCalculator;
import com.yandex.div.internal.widget.tabs.HeightCalculatorFactory;
import com.yandex.div.internal.widget.tabs.MaxCardHeightCalculator;
import com.yandex.div.internal.widget.tabs.TabItemLayout;
import com.yandex.div.internal.widget.tabs.TabTextStyleProvider;
import com.yandex.div.internal.widget.tabs.TabTitlesLayoutView;
import com.yandex.div.internal.widget.tabs.ViewPagerFixedSizeLayout;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCornersRadius;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivTabs;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DivTabsBinder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 G2\u00020\u0001:\u0001GBi\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJB\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J.\u0010-\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!J0\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0002J(\u00108\u001a\u00020\u001f*\u0006\u0012\u0002\b\u0003092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010>\u001a\u00020\u001f*\u0006\u0012\u0002\b\u0003092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020?H\u0002J\u001c\u0010@\u001a\u00020A*\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010:\u001a\u00020;H\u0002J&\u0010D\u001a\u00020\u001f*\u00020%2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010E\u001a\u00020\u001f*\u0006\u0012\u0002\b\u0003092\u0006\u0010(\u001a\u00020'2\u0006\u0010:\u001a\u00020;H\u0002J\u001e\u0010F\u001a\u00020\u001f*\u00020%2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010?H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/DivTabsBinder;", "", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "viewPool", "Lcom/yandex/div/internal/viewpool/ViewPool;", "textStyleProvider", "Lcom/yandex/div/internal/widget/tabs/TabTextStyleProvider;", "actionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "div2Logger", "Lcom/yandex/div/core/Div2Logger;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "visibilityActionTracker", "Lcom/yandex/div/core/view2/DivVisibilityActionTracker;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "context", "Landroid/content/Context;", "runtimeVisitor", "Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "tabsStateCache", "Lcom/yandex/div/core/state/TabsStateCache;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/internal/viewpool/ViewPool;Lcom/yandex/div/internal/widget/tabs/TabTextStyleProvider;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/images/DivImageLoader;Lcom/yandex/div/core/view2/DivVisibilityActionTracker;Lcom/yandex/div/core/downloader/DivPatchCache;Landroid/content/Context;Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;Lcom/yandex/div/core/state/TabsStateCache;)V", "oldDivSelectedTab", "", "Ljava/lang/Long;", "bindAdapter", "", "path", "Lcom/yandex/div/core/state/DivStatePath;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivTabsLayout;", "oldDiv", "Lcom/yandex/div2/DivTabs;", "div", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "subscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "bindView", "createAdapter", "Lcom/yandex/div/core/view2/divs/tabs/DivTabsAdapter;", "getDisabledScrollPages", "", "", "lastPageNumber", "isSwipeEnabled", "", "getTabbedCardLayoutIds", "Lcom/yandex/div/internal/widget/tabs/BaseDivTabbedCardUi$TabbedCardConfig;", "applyDelimiterStyle", "Lcom/yandex/div/internal/widget/tabs/TabTitlesLayoutView;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "style", "Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "applyStyle", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "getCornerRadii", "", "metrics", "Landroid/util/DisplayMetrics;", "observeDividerStyle", "observeHeight", "observeStyle", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivTabsBinder {
    private static final float DEFAULT_LINE_HEIGHT_COEFFICIENT = 1.3f;
    private static final String TAG_TAB_HEADER = "DIV2.TAB_HEADER_VIEW";
    private static final String TAG_TAB_ITEM = "DIV2.TAB_ITEM_VIEW";
    private final DivActionBinder actionBinder;
    private final DivBaseBinder baseBinder;
    private final Context context;
    private final Div2Logger div2Logger;
    private final DivPatchCache divPatchCache;
    private final DivImageLoader imageLoader;
    private Long oldDivSelectedTab;
    private final DivRuntimeVisitor runtimeVisitor;
    private final TabsStateCache tabsStateCache;
    private final TabTextStyleProvider textStyleProvider;
    private final DivViewCreator viewCreator;
    private final ViewPool viewPool;
    private final DivVisibilityActionTracker visibilityActionTracker;
    private static final Companion Companion = new Companion(null);
    private static final DivTabs.TabTitleStyle DEFAULT_TAB_TITLE_STYLE = new DivTabs.TabTitleStyle(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);

    /* JADX INFO: compiled from: DivTabsBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivTabs.TabTitleStyle.AnimationType.values().length];
            try {
                iArr[DivTabs.TabTitleStyle.AnimationType.SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivTabs.TabTitleStyle.AnimationType.FADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivTabs.TabTitleStyle.AnimationType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List bindAdapter$lambda$5(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List bindAdapter$setupNewAdapter$lambda$4(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        return list;
    }

    @Inject
    public DivTabsBinder(DivBaseBinder baseBinder, DivViewCreator viewCreator, ViewPool viewPool, TabTextStyleProvider textStyleProvider, DivActionBinder actionBinder, Div2Logger div2Logger, DivImageLoader imageLoader, DivVisibilityActionTracker visibilityActionTracker, DivPatchCache divPatchCache, @Named(Names.THEMED_CONTEXT) Context context, DivRuntimeVisitor runtimeVisitor, TabsStateCache tabsStateCache) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(viewPool, "viewPool");
        Intrinsics.checkNotNullParameter(textStyleProvider, "textStyleProvider");
        Intrinsics.checkNotNullParameter(actionBinder, "actionBinder");
        Intrinsics.checkNotNullParameter(div2Logger, "div2Logger");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(visibilityActionTracker, "visibilityActionTracker");
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeVisitor, "runtimeVisitor");
        Intrinsics.checkNotNullParameter(tabsStateCache, "tabsStateCache");
        this.baseBinder = baseBinder;
        this.viewCreator = viewCreator;
        this.viewPool = viewPool;
        this.textStyleProvider = textStyleProvider;
        this.actionBinder = actionBinder;
        this.div2Logger = div2Logger;
        this.imageLoader = imageLoader;
        this.visibilityActionTracker = visibilityActionTracker;
        this.divPatchCache = divPatchCache;
        this.context = context;
        this.runtimeVisitor = runtimeVisitor;
        this.tabsStateCache = tabsStateCache;
        viewPool.register(TAG_TAB_HEADER, new TabTitlesLayoutView.TabViewFactory(context), 12);
        viewPool.register(TAG_TAB_ITEM, new ViewFactory() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda5
            @Override // com.yandex.div.internal.viewpool.ViewFactory
            public final View createView() {
                return DivTabsBinder._init_$lambda$0(this.f$0);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TabItemLayout _init_$lambda$0(DivTabsBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new TabItemLayout(this$0.context, null, 2, null);
    }

    public final void bindView(BindingContext context, final DivTabsLayout view, final DivTabs div, DivBinder divBinder, DivStatePath path) {
        DivTabsAdapter divTabsAdapter;
        DivTabs divTabsApplyPatch;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(path, "path");
        DivTabs div2 = view.getDiv();
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        if (div2 == div && (divTabsAdapter = view.getDivTabsAdapter()) != null && (divTabsApplyPatch = divTabsAdapter.applyPatch(expressionResolver, div)) != null) {
            view.setDiv(divTabsApplyPatch);
            return;
        }
        final Div2View divView = context.getDivView();
        this.baseBinder.bindView(context, view, div, div2);
        view.setClipToPadding(false);
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$bindView$applyPaddings$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                BaseDivViewExtensionsKt.applyPaddings(view.getTitleLayout(), div.titlePaddings, expressionResolver);
            }
        };
        function1.invoke(null);
        div.titlePaddings.left.observe(expressionResolver, function1);
        div.titlePaddings.right.observe(expressionResolver, function1);
        div.titlePaddings.top.observe(expressionResolver, function1);
        div.titlePaddings.bottom.observe(expressionResolver, function1);
        observeHeight(view.getTitleLayout(), div, expressionResolver);
        observeStyle(view, expressionResolver, div.tabTitleStyle);
        observeDividerStyle(view, expressionResolver, div.tabTitleDelimiter, context);
        view.getPagerLayout().setClipToPadding(false);
        DivTabsLayout divTabsLayout = view;
        DivTabsBinderKt.observe(div.separatorPaddings, expressionResolver, divTabsLayout, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                BaseDivViewExtensionsKt.applyMargins(view.getDivider(), div.separatorPaddings, expressionResolver);
            }
        });
        view.addSubscription(div.separatorColor.observeAndGet(expressionResolver, new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                view.getDivider().setBackgroundColor(i);
            }
        }));
        view.addSubscription(div.hasSeparator.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                view.getDivider().setVisibility(z ? 0 : 8);
            }
        }));
        view.getTitleLayout().setOnScrollChangedListener(new TabTitlesLayoutView.OnScrollChangedListener() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.widget.tabs.TabTitlesLayoutView.OnScrollChangedListener
            public final void onScrolled() {
                DivTabsBinder.bindView$lambda$2(this.f$0, divView);
            }
        });
        view.getTitleLayout().setFocusTracker(context.getDivView().getInputFocusTracker());
        bindAdapter(path, context, view, div2, div, divBinder, divTabsLayout);
        view.addSubscription(div.restrictParentScroll.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                view.getViewPager().setOnInterceptTouchEventListener(z ? ParentScrollRestrictor.INSTANCE : null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(DivTabsBinder this$0, Div2View divView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(divView, "$divView");
        this$0.div2Logger.logTabTitlesScroll(divView);
    }

    private final void bindAdapter(final DivStatePath path, final BindingContext bindingContext, final DivTabsLayout view, DivTabs oldDiv, final DivTabs div, final DivBinder divBinder, ExpressionSubscriber subscriber) {
        int i;
        Long l;
        final ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
        List<DivTabs.Item> list = div.items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DivTabs.Item item : list) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
            arrayList.add(new DivSimpleTab(item, displayMetrics, expressionResolver));
        }
        final ArrayList arrayList2 = arrayList;
        DivTabsAdapter divTabsAdapterTryReuse = DivTabsBinderKt.tryReuse(view.getDivTabsAdapter(), div, expressionResolver);
        if (divTabsAdapterTryReuse != null) {
            divTabsAdapterTryReuse.setBindingContext(bindingContext);
            divTabsAdapterTryReuse.setStatePath(path);
            divTabsAdapterTryReuse.getDivTabsEventManager().setDiv(div);
            divTabsAdapterTryReuse.getActiveStateTracker().setDiv(div);
            if (oldDiv == div) {
                divTabsAdapterTryReuse.notifyStateChanged();
            } else {
                divTabsAdapterTryReuse.setData(new BaseDivTabbedCardUi.Input() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda1
                    @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.Input
                    public final List getTabs() {
                        return DivTabsBinder.bindAdapter$lambda$5(arrayList2);
                    }
                }, expressionResolver, subscriber);
            }
        } else {
            long jLongValue = div.selectedTab.evaluate(expressionResolver).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            bindAdapter$setupNewAdapter(this, bindingContext, div, view, divBinder, path, arrayList2, i);
        }
        DivTabsBinderKt.observeFixedHeightChange(div.items, expressionResolver, subscriber, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindAdapter.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                DivTabsAdapter divTabsAdapter = view.getDivTabsAdapter();
                if (divTabsAdapter != null) {
                    divTabsAdapter.notifyStateChanged();
                }
            }
        });
        Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$bindAdapter$selectTab$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l2) {
                invoke(l2.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j2) {
                PagerController pager;
                int i2;
                this.this$0.oldDivSelectedTab = Long.valueOf(j2);
                DivTabsAdapter divTabsAdapter = view.getDivTabsAdapter();
                if (divTabsAdapter == null || (pager = divTabsAdapter.getPager()) == null) {
                    return;
                }
                long j3 = j2 >> 31;
                if (j3 == 0 || j3 == -1) {
                    i2 = (int) j2;
                } else {
                    KAssert kAssert2 = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + j2 + "' to Int");
                    }
                    i2 = j2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                if (pager.getCurrentItemIndex() != i2) {
                    pager.smoothScrollTo(i2);
                }
            }
        };
        subscriber.addSubscription(div.dynamicHeight.observe(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindAdapter.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                int currentItemIndex;
                PagerController pager;
                DivTabsAdapter divTabsAdapter = view.getDivTabsAdapter();
                if (divTabsAdapter == null || divTabsAdapter.getIsDynamicHeight() != z) {
                    DivTabsBinder divTabsBinder = this;
                    BindingContext bindingContext2 = bindingContext;
                    DivTabs divTabs = div;
                    DivTabsLayout divTabsLayout = view;
                    DivBinder divBinder2 = divBinder;
                    DivStatePath divStatePath = path;
                    List<DivSimpleTab> list2 = arrayList2;
                    DivTabsAdapter divTabsAdapter2 = divTabsLayout.getDivTabsAdapter();
                    if (divTabsAdapter2 == null || (pager = divTabsAdapter2.getPager()) == null) {
                        long jLongValue2 = div.selectedTab.evaluate(expressionResolver).longValue();
                        long j2 = jLongValue2 >> 31;
                        if (j2 == 0 || j2 == -1) {
                            currentItemIndex = (int) jLongValue2;
                        } else {
                            KAssert kAssert2 = KAssert.INSTANCE;
                            if (Assert.isEnabled()) {
                                Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                            }
                            currentItemIndex = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                    } else {
                        currentItemIndex = pager.getCurrentItemIndex();
                    }
                    DivTabsBinder.bindAdapter$setupNewAdapter(divTabsBinder, bindingContext2, divTabs, divTabsLayout, divBinder2, divStatePath, list2, currentItemIndex);
                }
            }
        }));
        subscriber.addSubscription(div.selectedTab.observe(expressionResolver, function1));
        Div2View divView = bindingContext.getDivView();
        boolean z = Intrinsics.areEqual(divView.getPrevDataTag(), DivDataTag.INVALID) || Intrinsics.areEqual(divView.getDataTag(), divView.getPrevDataTag());
        long jLongValue2 = div.selectedTab.evaluate(expressionResolver).longValue();
        if (!z || (l = this.oldDivSelectedTab) == null || l.longValue() != jLongValue2) {
            function1.invoke(Long.valueOf(jLongValue2));
        }
        subscriber.addSubscription(div.switchTabsByContentSwipeEnabled.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.bindAdapter.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                DivTabsAdapter divTabsAdapter = view.getDivTabsAdapter();
                if (divTabsAdapter != null) {
                    divTabsAdapter.setDisabledScrollPages(this.getDisabledScrollPages(div.items.size() - 1, z2));
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAdapter$setupNewAdapter(DivTabsBinder divTabsBinder, BindingContext bindingContext, DivTabs divTabs, DivTabsLayout divTabsLayout, DivBinder divBinder, DivStatePath divStatePath, final List<DivSimpleTab> list, int i) {
        DivTabsAdapter divTabsAdapterCreateAdapter = divTabsBinder.createAdapter(bindingContext, divTabs, divTabsLayout, divBinder, divStatePath);
        divTabsAdapterCreateAdapter.setData(new BaseDivTabbedCardUi.Input() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.widget.tabs.BaseDivTabbedCardUi.Input
            public final List getTabs() {
                return DivTabsBinder.bindAdapter$setupNewAdapter$lambda$4(list);
            }
        }, i);
        divTabsLayout.setDivTabsAdapter(divTabsAdapterCreateAdapter);
    }

    private final DivTabsAdapter createAdapter(BindingContext bindingContext, DivTabs div, DivTabsLayout view, DivBinder divBinder, DivStatePath path) {
        final DivTabsEventManager divTabsEventManager = new DivTabsEventManager(bindingContext, this.actionBinder, this.div2Logger, this.visibilityActionTracker, view, div);
        boolean zBooleanValue = div.dynamicHeight.evaluate(bindingContext.getExpressionResolver()).booleanValue();
        HeightCalculatorFactory heightCalculatorFactory = zBooleanValue ? new HeightCalculatorFactory() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.widget.tabs.HeightCalculatorFactory
            public final ViewPagerFixedSizeLayout.HeightCalculator getCardHeightCalculator(ViewGroup viewGroup, HeightCalculatorFactory.MeasureTabHeightFn measureTabHeightFn, HeightCalculatorFactory.GetTabCountFn getTabCountFn) {
                return new DynamicCardHeightCalculator(viewGroup, measureTabHeightFn, getTabCountFn);
            }
        } : new HeightCalculatorFactory() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$$ExternalSyntheticLambda4
            @Override // com.yandex.div.internal.widget.tabs.HeightCalculatorFactory
            public final ViewPagerFixedSizeLayout.HeightCalculator getCardHeightCalculator(ViewGroup viewGroup, HeightCalculatorFactory.MeasureTabHeightFn measureTabHeightFn, HeightCalculatorFactory.GetTabCountFn getTabCountFn) {
                return new MaxCardHeightCalculator(viewGroup, measureTabHeightFn, getTabCountFn);
            }
        };
        int currentItem = view.getViewPager().getCurrentItem();
        final int currentItem2 = view.getViewPager().getCurrentItem();
        if (currentItem2 == currentItem) {
            UiThreadHandler.INSTANCE.postOnMainThread(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder.createAdapter.1
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
                    divTabsEventManager.onPageDisplayed(currentItem2);
                }
            });
        }
        return new DivTabsAdapter(this.viewPool, view, getTabbedCardLayoutIds(), heightCalculatorFactory, zBooleanValue, bindingContext, this.textStyleProvider, this.viewCreator, divBinder, divTabsEventManager, new DivTabsActiveStateTracker(bindingContext, path, this.div2Logger, this.tabsStateCache, this.runtimeVisitor, div), path, this.divPatchCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Integer> getDisabledScrollPages(int lastPageNumber, boolean isSwipeEnabled) {
        return isSwipeEnabled ? new LinkedHashSet() : CollectionsKt.toMutableSet(new IntRange(0, lastPageNumber));
    }

    private final void observeHeight(final TabTitlesLayoutView<?> tabTitlesLayoutView, final DivTabs divTabs, final ExpressionResolver expressionResolver) {
        DivEdgeInsets divEdgeInsets;
        Expression<Long> expression;
        DivEdgeInsets divEdgeInsets2;
        Expression<Long> expression2;
        Expression<Long> expression3;
        Expression<Long> expression4;
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$observeHeight$applyHeight$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                DivTabs.TabTitleStyle tabTitleStyle = divTabs.tabTitleStyle;
                if (tabTitleStyle == null) {
                    tabTitleStyle = DivTabsBinder.DEFAULT_TAB_TITLE_STYLE;
                }
                DivEdgeInsets divEdgeInsets3 = tabTitleStyle.paddings;
                DivEdgeInsets divEdgeInsets4 = divTabs.titlePaddings;
                Expression<Long> expression5 = tabTitleStyle.lineHeight;
                long jLongValue = (expression5 != null ? expression5.evaluate(expressionResolver).longValue() : (long) (tabTitleStyle.fontSize.evaluate(expressionResolver).floatValue() * 1.3f)) + divEdgeInsets3.top.evaluate(expressionResolver).longValue() + divEdgeInsets3.bottom.evaluate(expressionResolver).longValue() + divEdgeInsets4.top.evaluate(expressionResolver).longValue() + divEdgeInsets4.bottom.evaluate(expressionResolver).longValue();
                DisplayMetrics metrics = tabTitlesLayoutView.getResources().getDisplayMetrics();
                ViewGroup.LayoutParams layoutParams = tabTitlesLayoutView.getLayoutParams();
                Long lValueOf = Long.valueOf(jLongValue);
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                layoutParams.height = BaseDivViewExtensionsKt.spToPx(lValueOf, metrics);
            }
        };
        Disposable disposableObserve = null;
        function1.invoke(null);
        ExpressionSubscriber expressionSubscriber = ReleasablesKt.getExpressionSubscriber(tabTitlesLayoutView);
        DivTabs.TabTitleStyle tabTitleStyle = divTabs.tabTitleStyle;
        expressionSubscriber.addSubscription((tabTitleStyle == null || (expression4 = tabTitleStyle.lineHeight) == null) ? null : expression4.observe(expressionResolver, function1));
        DivTabs.TabTitleStyle tabTitleStyle2 = divTabs.tabTitleStyle;
        expressionSubscriber.addSubscription((tabTitleStyle2 == null || (expression3 = tabTitleStyle2.fontSize) == null) ? null : expression3.observe(expressionResolver, function1));
        DivTabs.TabTitleStyle tabTitleStyle3 = divTabs.tabTitleStyle;
        expressionSubscriber.addSubscription((tabTitleStyle3 == null || (divEdgeInsets2 = tabTitleStyle3.paddings) == null || (expression2 = divEdgeInsets2.top) == null) ? null : expression2.observe(expressionResolver, function1));
        DivTabs.TabTitleStyle tabTitleStyle4 = divTabs.tabTitleStyle;
        if (tabTitleStyle4 != null && (divEdgeInsets = tabTitleStyle4.paddings) != null && (expression = divEdgeInsets.bottom) != null) {
            disposableObserve = expression.observe(expressionResolver, function1);
        }
        expressionSubscriber.addSubscription(disposableObserve);
        expressionSubscriber.addSubscription(divTabs.titlePaddings.top.observe(expressionResolver, function1));
        expressionSubscriber.addSubscription(divTabs.titlePaddings.bottom.observe(expressionResolver, function1));
    }

    private final void observeStyle(final DivTabsLayout divTabsLayout, final ExpressionResolver expressionResolver, final DivTabs.TabTitleStyle tabTitleStyle) {
        Expression<Long> expression;
        Expression<DivTabs.TabTitleStyle.AnimationType> expression2;
        Expression<Long> expression3;
        DivCornersRadius divCornersRadius;
        Expression<Long> expression4;
        DivCornersRadius divCornersRadius2;
        Expression<Long> expression5;
        DivCornersRadius divCornersRadius3;
        Expression<Long> expression6;
        DivCornersRadius divCornersRadius4;
        Expression<Long> expression7;
        Expression<Long> expression8;
        Expression<Integer> expression9;
        Expression<Integer> expression10;
        Expression<Integer> expression11;
        Expression<Integer> expression12;
        applyStyle(divTabsLayout.getTitleLayout(), expressionResolver, tabTitleStyle == null ? DEFAULT_TAB_TITLE_STYLE : tabTitleStyle);
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$observeStyle$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                DivTabsBinder divTabsBinder = this.this$0;
                TabTitlesLayoutView<?> titleLayout = divTabsLayout.getTitleLayout();
                ExpressionResolver expressionResolver2 = expressionResolver;
                DivTabs.TabTitleStyle tabTitleStyle2 = tabTitleStyle;
                if (tabTitleStyle2 == null) {
                    tabTitleStyle2 = DivTabsBinder.DEFAULT_TAB_TITLE_STYLE;
                }
                divTabsBinder.applyStyle(titleLayout, expressionResolver2, tabTitleStyle2);
            }
        };
        if (tabTitleStyle != null && (expression12 = tabTitleStyle.activeTextColor) != null) {
            expression12.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression11 = tabTitleStyle.activeBackgroundColor) != null) {
            expression11.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression10 = tabTitleStyle.inactiveTextColor) != null) {
            expression10.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression9 = tabTitleStyle.inactiveBackgroundColor) != null) {
            expression9.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression8 = tabTitleStyle.cornerRadius) != null) {
            expression8.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (divCornersRadius4 = tabTitleStyle.cornersRadius) != null && (expression7 = divCornersRadius4.topLeft) != null) {
            expression7.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (divCornersRadius3 = tabTitleStyle.cornersRadius) != null && (expression6 = divCornersRadius3.topRight) != null) {
            expression6.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (divCornersRadius2 = tabTitleStyle.cornersRadius) != null && (expression5 = divCornersRadius2.bottomRight) != null) {
            expression5.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (divCornersRadius = tabTitleStyle.cornersRadius) != null && (expression4 = divCornersRadius.bottomLeft) != null) {
            expression4.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression3 = tabTitleStyle.itemSpacing) != null) {
            expression3.observe(expressionResolver, function1);
        }
        if (tabTitleStyle != null && (expression2 = tabTitleStyle.animationType) != null) {
            expression2.observe(expressionResolver, function1);
        }
        if (tabTitleStyle == null || (expression = tabTitleStyle.animationDuration) == null) {
            return;
        }
        expression.observe(expressionResolver, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStyle(TabTitlesLayoutView<?> tabTitlesLayoutView, ExpressionResolver expressionResolver, DivTabs.TabTitleStyle tabTitleStyle) {
        BaseIndicatorTabLayout.AnimationType animationType;
        int iIntValue = tabTitleStyle.activeTextColor.evaluate(expressionResolver).intValue();
        int iIntValue2 = tabTitleStyle.activeBackgroundColor.evaluate(expressionResolver).intValue();
        int iIntValue3 = tabTitleStyle.inactiveTextColor.evaluate(expressionResolver).intValue();
        Expression<Integer> expression = tabTitleStyle.inactiveBackgroundColor;
        tabTitlesLayoutView.setTabColors(iIntValue, iIntValue2, iIntValue3, expression != null ? expression.evaluate(expressionResolver).intValue() : 0);
        DisplayMetrics metrics = tabTitlesLayoutView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        tabTitlesLayoutView.setTabIndicatorCornersRadii(getCornerRadii(tabTitleStyle, metrics, expressionResolver));
        tabTitlesLayoutView.setTabItemSpacing(BaseDivViewExtensionsKt.dpToPx(tabTitleStyle.itemSpacing.evaluate(expressionResolver), metrics));
        int i = WhenMappings.$EnumSwitchMapping$0[tabTitleStyle.animationType.evaluate(expressionResolver).ordinal()];
        if (i == 1) {
            animationType = BaseIndicatorTabLayout.AnimationType.SLIDE;
        } else if (i == 2) {
            animationType = BaseIndicatorTabLayout.AnimationType.FADE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            animationType = BaseIndicatorTabLayout.AnimationType.NONE;
        }
        tabTitlesLayoutView.setAnimationType(animationType);
        tabTitlesLayoutView.setAnimationDuration(tabTitleStyle.animationDuration.evaluate(expressionResolver).longValue());
        tabTitlesLayoutView.setTabTitleStyle(tabTitleStyle);
    }

    private final void observeDividerStyle(final DivTabsLayout divTabsLayout, final ExpressionResolver expressionResolver, final DivTabs.TabTitleDelimiter tabTitleDelimiter, final BindingContext bindingContext) {
        if (tabTitleDelimiter == null) {
            return;
        }
        applyDelimiterStyle(divTabsLayout.getTitleLayout(), expressionResolver, tabTitleDelimiter, bindingContext);
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$observeDividerStyle$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                this.this$0.applyDelimiterStyle(divTabsLayout.getTitleLayout(), expressionResolver, tabTitleDelimiter, bindingContext);
            }
        };
        tabTitleDelimiter.width.value.observe(expressionResolver, function1);
        tabTitleDelimiter.width.unit.observe(expressionResolver, function1);
        tabTitleDelimiter.height.value.observe(expressionResolver, function1);
        tabTitleDelimiter.height.unit.observe(expressionResolver, function1);
        tabTitleDelimiter.imageUrl.observe(expressionResolver, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDelimiterStyle(final TabTitlesLayoutView<?> tabTitlesLayoutView, ExpressionResolver expressionResolver, DivTabs.TabTitleDelimiter tabTitleDelimiter, BindingContext bindingContext) {
        DisplayMetrics metrics = tabTitlesLayoutView.getResources().getDisplayMetrics();
        DivFixedSize divFixedSize = tabTitleDelimiter.width;
        long jLongValue = divFixedSize.value.evaluate(expressionResolver).longValue();
        DivSizeUnit divSizeUnitEvaluate = divFixedSize.unit.evaluate(expressionResolver);
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        final int px = BaseDivViewExtensionsKt.toPx(jLongValue, divSizeUnitEvaluate, metrics);
        DivFixedSize divFixedSize2 = tabTitleDelimiter.height;
        final int px2 = BaseDivViewExtensionsKt.toPx(divFixedSize2.value.evaluate(expressionResolver).longValue(), divFixedSize2.unit.evaluate(expressionResolver), metrics);
        DivImageLoader divImageLoader = this.imageLoader;
        String string = tabTitleDelimiter.imageUrl.evaluate(expressionResolver).toString();
        final Div2View divView = bindingContext.getDivView();
        LoadReference loadReferenceLoadImage = divImageLoader.loadImage(string, new DivIdLoggingImageDownloadCallback(divView) { // from class: com.yandex.div.core.view2.divs.tabs.DivTabsBinder$applyDelimiterStyle$reference$1
            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(CachedBitmap cachedBitmap) {
                Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
                super.onSuccess(cachedBitmap);
                tabTitlesLayoutView.setTabDelimiter(cachedBitmap.getBitmap(), px, px2);
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(PictureDrawable pictureDrawable) {
                Intrinsics.checkNotNullParameter(pictureDrawable, "pictureDrawable");
                super.onSuccess(pictureDrawable);
                tabTitlesLayoutView.setTabDelimiter(DrawableKt.toBitmap$default(pictureDrawable, 0, 0, null, 7, null), px, px2);
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onError() {
                super.onError();
                tabTitlesLayoutView.setTabDelimiter(null, 0, 0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "TabTitlesLayoutView<*>.a…}\n            }\n        )");
        bindingContext.getDivView().addLoadReference(loadReferenceLoadImage, tabTitlesLayoutView);
    }

    private static final float getCornerRadii$toCornerRadii(Expression<Long> expression, ExpressionResolver expressionResolver, DisplayMetrics displayMetrics) {
        return BaseDivViewExtensionsKt.dpToPx(expression.evaluate(expressionResolver), displayMetrics);
    }

    private final float[] getCornerRadii(DivTabs.TabTitleStyle tabTitleStyle, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        float cornerRadii$toCornerRadii;
        Expression<Long> expression;
        Expression<Long> expression2;
        Expression<Long> expression3;
        Expression<Long> expression4;
        Expression<Long> expression5 = tabTitleStyle.cornerRadius;
        if (expression5 != null) {
            cornerRadii$toCornerRadii = getCornerRadii$toCornerRadii(expression5, expressionResolver, displayMetrics);
        } else {
            cornerRadii$toCornerRadii = tabTitleStyle.cornersRadius == null ? -1.0f : 0.0f;
        }
        DivCornersRadius divCornersRadius = tabTitleStyle.cornersRadius;
        float cornerRadii$toCornerRadii2 = (divCornersRadius == null || (expression4 = divCornersRadius.topLeft) == null) ? cornerRadii$toCornerRadii : getCornerRadii$toCornerRadii(expression4, expressionResolver, displayMetrics);
        DivCornersRadius divCornersRadius2 = tabTitleStyle.cornersRadius;
        float cornerRadii$toCornerRadii3 = (divCornersRadius2 == null || (expression3 = divCornersRadius2.topRight) == null) ? cornerRadii$toCornerRadii : getCornerRadii$toCornerRadii(expression3, expressionResolver, displayMetrics);
        DivCornersRadius divCornersRadius3 = tabTitleStyle.cornersRadius;
        float cornerRadii$toCornerRadii4 = (divCornersRadius3 == null || (expression2 = divCornersRadius3.bottomLeft) == null) ? cornerRadii$toCornerRadii : getCornerRadii$toCornerRadii(expression2, expressionResolver, displayMetrics);
        DivCornersRadius divCornersRadius4 = tabTitleStyle.cornersRadius;
        if (divCornersRadius4 != null && (expression = divCornersRadius4.bottomRight) != null) {
            cornerRadii$toCornerRadii = getCornerRadii$toCornerRadii(expression, expressionResolver, displayMetrics);
        }
        return new float[]{cornerRadii$toCornerRadii2, cornerRadii$toCornerRadii2, cornerRadii$toCornerRadii3, cornerRadii$toCornerRadii3, cornerRadii$toCornerRadii, cornerRadii$toCornerRadii, cornerRadii$toCornerRadii4, cornerRadii$toCornerRadii4};
    }

    private final BaseDivTabbedCardUi.TabbedCardConfig getTabbedCardLayoutIds() {
        return new BaseDivTabbedCardUi.TabbedCardConfig(R.id.base_tabbed_title_container_scroller, R.id.div_tabs_pager_container, R.id.div_tabs_container_helper, true, false, TAG_TAB_HEADER, TAG_TAB_ITEM);
    }

    /* JADX INFO: compiled from: DivTabsBinder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/DivTabsBinder$Companion;", "", "()V", "DEFAULT_LINE_HEIGHT_COEFFICIENT", "", "DEFAULT_TAB_TITLE_STYLE", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "TAG_TAB_HEADER", "", "TAG_TAB_ITEM", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
