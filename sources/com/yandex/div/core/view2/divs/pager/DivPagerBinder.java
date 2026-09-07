package com.yandex.div.core.view2.divs.pager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.DivViewState;
import com.yandex.div.core.state.PagerState;
import com.yandex.div.core.state.UpdateStateChangePageCallback;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.DivBaseBinder;
import com.yandex.div.core.view2.divs.ReleasingViewPool;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.core.view2.divs.widgets.ParentScrollRestrictor;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivCollectionItemBuilder;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivPagerLayoutMode;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DivPagerBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001'\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BE\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J2\u0010\u001c\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#H\u0002J\u001c\u0010$\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010%\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u0011\u0010&\u001a\u00020'*\u00020\u0003H\u0002¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J7\u0010+\u001a\u00020,*\u00020-2\u0006\u0010\u0019\u001a\u00020\u00022!\u0010.\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00150/H\u0002J\f\u00104\u001a\u00020\u0015*\u00020-H\u0002J\u0014\u00105\u001a\u00020\u0015*\u00020-2\u0006\u00106\u001a\u000207H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivPager;", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "divBinder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivBinder;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "pagerIndicatorConnector", "Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivViewCreator;Ljavax/inject/Provider;Lcom/yandex/div/core/downloader/DivPatchCache;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;Lcom/yandex/div/core/util/AccessibilityStateProvider;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "applyDecorations", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "pageTranslations", "Landroid/util/SparseArray;", "", "adapter", "Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;", "bindInfiniteScroll", "bindItemBuilder", "createInfiniteScrollListener", "com/yandex/div/core/view2/divs/pager/DivPagerBinder$createInfiniteScrollListener$1", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;)Lcom/yandex/div/core/view2/divs/pager/DivPagerBinder$createInfiniteScrollListener$1;", "isHorizontal", "", "observeSizeChange", "Lcom/yandex/div/core/Disposable;", "Landroidx/viewpager2/widget/ViewPager2;", "observer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "_", "removeItemDecorations", "setItemDecoration", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivPagerBinder implements DivViewBinder<DivPager, DivPagerView> {
    private final AccessibilityStateProvider accessibilityStateProvider;
    private final DivBaseBinder baseBinder;
    private final DivActionBinder divActionBinder;
    private final Provider<DivBinder> divBinder;
    private final DivPatchCache divPatchCache;
    private final PagerIndicatorConnector pagerIndicatorConnector;
    private final DivViewCreator viewCreator;

    @Inject
    public DivPagerBinder(DivBaseBinder baseBinder, DivViewCreator viewCreator, Provider<DivBinder> divBinder, DivPatchCache divPatchCache, DivActionBinder divActionBinder, PagerIndicatorConnector pagerIndicatorConnector, AccessibilityStateProvider accessibilityStateProvider) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(pagerIndicatorConnector, "pagerIndicatorConnector");
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        this.baseBinder = baseBinder;
        this.viewCreator = viewCreator;
        this.divBinder = divBinder;
        this.divPatchCache = divPatchCache;
        this.divActionBinder = divActionBinder;
        this.pagerIndicatorConnector = pagerIndicatorConnector;
        this.accessibilityStateProvider = accessibilityStateProvider;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x028f  */
    /* JADX WARN: Code duplicated, block: B:92:0x02d7  */
    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, final DivPagerView view, final DivPager div, DivStatePath path) {
        long jLongValue;
        long j;
        int i;
        int position;
        Expression<Long> expression;
        Expression<Long> expression2;
        Expression<Long> expression3;
        Expression<Long> expression4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        String id = div.getId();
        if (id != null) {
            this.pagerIndicatorConnector.submitPager$div_release(id, view);
        }
        Div2View divView = context.getDivView();
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivPager div2 = view.getDiv();
        if (div == div2) {
            final ViewPager2 viewPager = view.getViewPager();
            RecyclerView.Adapter adapter = viewPager.getAdapter();
            DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
            if (divPagerAdapter == null) {
                return;
            }
            if (!divPagerAdapter.applyPatch(view.getRecyclerView(), this.divPatchCache, context)) {
                DivPagerView.OnItemsUpdatedCallback pagerOnItemsCountChange = view.getPagerOnItemsCountChange();
                if (pagerOnItemsCountChange != null) {
                    pagerOnItemsCountChange.onItemsUpdated();
                }
                viewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder$bindView$$inlined$doOnNextLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        view2.removeOnLayoutChangeListener(this);
                        viewPager.requestTransform();
                    }
                });
            }
            Div divRootDiv$div_release = divView.rootDiv$div_release();
            DivBinder divBinder = this.divBinder.get();
            Intrinsics.checkNotNullExpressionValue(divBinder, "divBinder.get()");
            BaseDivViewExtensionsKt.bindStates(view, divRootDiv$div_release, context, expressionResolver, divBinder);
            return;
        }
        if (div2 != null) {
            view.setChangePageCallbackForOffScreenPages$div_release(null);
            removeItemDecorations(view.getViewPager());
            view.setPageTransformer$div_release(null);
        }
        RecyclerView recyclerView = view.getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        this.baseBinder.bindView(context, view, div, div2);
        final SparseArray sparseArray = new SparseArray();
        AccessibilityStateProvider accessibilityStateProvider = this.accessibilityStateProvider;
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        boolean zIsAccessibilityEnabled = accessibilityStateProvider.isAccessibilityEnabled(context2);
        view.setRecycledViewPool(new ReleasingViewPool(divView.getReleaseViewVisitor$div_release()));
        List<DivItemBuilderResult> listBuildItems = DivCollectionExtensionsKt.buildItems(div, expressionResolver);
        DivBinder divBinder2 = this.divBinder.get();
        Intrinsics.checkNotNullExpressionValue(divBinder2, "divBinder.get()");
        final DivPagerAdapter divPagerAdapter2 = new DivPagerAdapter(listBuildItems, context, divBinder2, sparseArray, this.viewCreator, path, zIsAccessibilityEnabled, view);
        view.getViewPager().setAdapter(divPagerAdapter2);
        bindInfiniteScroll(view, div, expressionResolver);
        DivPagerView.OnItemsUpdatedCallback pagerOnItemsCountChange2 = view.getPagerOnItemsCountChange();
        if (pagerOnItemsCountChange2 != null) {
            pagerOnItemsCountChange2.onItemsUpdated();
        }
        view.setClipToPage$div_release(divView.getDiv2Component().isPagerPageClipEnabled());
        view.setOrientation(!isHorizontal(div, expressionResolver) ? 1 : 0);
        divPagerAdapter2.setCrossAxisAlignment(div.crossAxisAlignment.evaluate(expressionResolver));
        Function1<? super Long, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder$bindView$reusableObserver$1
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
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyDecorations(view, div, expressionResolver, sparseArray, divPagerAdapter2);
            }
        };
        DivEdgeInsets paddings = div.getPaddings();
        view.addSubscription((paddings == null || (expression4 = paddings.left) == null) ? null : expression4.observe(expressionResolver, function1));
        DivEdgeInsets paddings2 = div.getPaddings();
        view.addSubscription((paddings2 == null || (expression3 = paddings2.right) == null) ? null : expression3.observe(expressionResolver, function1));
        DivEdgeInsets paddings3 = div.getPaddings();
        view.addSubscription((paddings3 == null || (expression2 = paddings3.top) == null) ? null : expression2.observe(expressionResolver, function1));
        DivEdgeInsets paddings4 = div.getPaddings();
        view.addSubscription((paddings4 == null || (expression = paddings4.bottom) == null) ? null : expression.observe(expressionResolver, function1));
        view.addSubscription(div.itemSpacing.value.observe(expressionResolver, function1));
        view.addSubscription(div.itemSpacing.unit.observe(expressionResolver, function1));
        view.addSubscription(div.scrollAxisAlignment.observe(expressionResolver, function1));
        view.addSubscription(div.crossAxisAlignment.observe(expressionResolver, function1));
        view.addSubscription(div.orientation.observe(expressionResolver, function1));
        view.addSubscription(observeSizeChange(view.getViewPager(), div, function1));
        DivPagerLayoutMode divPagerLayoutMode = div.layoutMode;
        if (divPagerLayoutMode instanceof DivPagerLayoutMode.NeighbourPageSize) {
            DivPagerLayoutMode.NeighbourPageSize neighbourPageSize = (DivPagerLayoutMode.NeighbourPageSize) divPagerLayoutMode;
            view.addSubscription(neighbourPageSize.getValue().neighbourPageWidth.value.observe(expressionResolver, function1));
            view.addSubscription(neighbourPageSize.getValue().neighbourPageWidth.unit.observe(expressionResolver, function1));
        } else if (divPagerLayoutMode instanceof DivPagerLayoutMode.PageSize) {
            view.addSubscription(((DivPagerLayoutMode.PageSize) divPagerLayoutMode).getValue().pageWidth.value.observe(expressionResolver, function1));
        } else {
            boolean z = divPagerLayoutMode instanceof DivPagerLayoutMode.PageContentSize;
        }
        view.setPagerSelectedActionsDispatcher$div_release(new PagerSelectedActionsDispatcher(divView, divPagerAdapter2.getItemsToShow(), this.divActionBinder));
        view.setChangePageCallbackForLogger$div_release(new DivPagerPageChangeCallback(div, divPagerAdapter2.getItemsToShow(), context, recyclerView, view));
        DivViewState currentState = divView.getCurrentState();
        if (currentState != null) {
            String id2 = div.getId();
            if (id2 == null) {
                id2 = String.valueOf(div.hashCode());
            }
            DivViewState.BlockState blockState = currentState.getBlockState(id2);
            PagerState pagerState = blockState instanceof PagerState ? (PagerState) blockState : null;
            view.setChangePageCallbackForState$div_release(new UpdateStateChangePageCallback(id2, currentState));
            if (pagerState != null) {
                Integer numValueOf = Integer.valueOf(pagerState.getCurrentPageIndex());
                if (!Boolean.valueOf(numValueOf.intValue() < divPagerAdapter2.getRealPosition(divPagerAdapter2.getItemsToShow().size())).booleanValue()) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    position = numValueOf.intValue();
                } else {
                    jLongValue = div.defaultItem.evaluate(expressionResolver).longValue();
                    j = jLongValue >> 31;
                    if (j != 0 || j == -1) {
                        i = (int) jLongValue;
                    } else {
                        KAssert kAssert = KAssert.INSTANCE;
                        if (Assert.isEnabled()) {
                            Assert.fail("Unable convert '" + jLongValue + "' to Int");
                        }
                        i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    position = divPagerAdapter2.getPosition(i);
                }
            } else {
                jLongValue = div.defaultItem.evaluate(expressionResolver).longValue();
                j = jLongValue >> 31;
                if (j != 0) {
                    i = (int) jLongValue;
                } else {
                    i = (int) jLongValue;
                }
                position = divPagerAdapter2.getPosition(i);
            }
            view.setCurrentItem$div_release(position);
        }
        view.addSubscription(div.restrictParentScroll.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder.bindView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                view.setOnInterceptTouchEventListener(z2 ? ParentScrollRestrictor.INSTANCE : null);
            }
        }));
        bindItemBuilder(view, context, div);
        if (zIsAccessibilityEnabled) {
            view.enableAccessibility();
        }
    }

    private final void bindInfiniteScroll(final DivPagerView divPagerView, DivPager divPager, ExpressionResolver expressionResolver) {
        View childAt = divPagerView.getViewPager().getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        final RecyclerView recyclerView = (RecyclerView) childAt;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        divPager.infiniteScroll.observeAndGet(expressionResolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder.bindInfiniteScroll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v9, types: [T, com.yandex.div.core.view2.divs.pager.DivPagerBinder$createInfiniteScrollListener$1] */
            public final void invoke(boolean z) {
                RecyclerView.Adapter adapter = divPagerView.getViewPager().getAdapter();
                DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
                if (divPagerAdapter != null) {
                    divPagerAdapter.setInfiniteScrollEnabled(z);
                }
                if (z) {
                    RecyclerView.OnScrollListener onScrollListener = objectRef.element;
                    if (onScrollListener == null) {
                        ?? CreateInfiniteScrollListener = this.createInfiniteScrollListener(divPagerView);
                        objectRef.element = CreateInfiniteScrollListener;
                        onScrollListener = (RecyclerView.OnScrollListener) CreateInfiniteScrollListener;
                    }
                    recyclerView.addOnScrollListener(onScrollListener);
                    return;
                }
                RecyclerView.OnScrollListener onScrollListener2 = objectRef.element;
                if (onScrollListener2 != null) {
                    recyclerView.removeOnScrollListener(onScrollListener2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.yandex.div.core.view2.divs.pager.DivPagerBinder$createInfiniteScrollListener$1] */
    public final C39211 createInfiniteScrollListener(final DivPagerView divPagerView) {
        return new RecyclerView.OnScrollListener() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder.createInfiniteScrollListener.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                RecyclerView.Adapter adapter = divPagerView.getViewPager().getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (iFindFirstVisibleItemPosition == itemCount - 2 && dx > 0) {
                    recyclerView.scrollToPosition(2);
                } else {
                    if (iFindLastVisibleItemPosition != 1 || dx >= 0) {
                        return;
                    }
                    recyclerView.scrollToPosition(itemCount - 3);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f1  */
    public final void applyDecorations(DivPagerView divPagerView, DivPager divPager, ExpressionResolver expressionResolver, SparseArray<Float> sparseArray, DivPagerAdapter divPagerAdapter) {
        WrapContentPageSizeProvider wrapContentPageSizeProvider;
        DivPagerPageSizeProvider neighbourPageSizeProvider;
        DivPagerPageSizeProvider divPagerPageSizeProvider;
        DivPagerPaddingsHolder divPagerPaddingsHolder;
        DivPager.ItemAlignment itemAlignment;
        WrapContentPageSizeItemDecoration wrapContentPageSizeItemDecoration;
        RecyclerView recyclerView = divPagerView.getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        boolean zIsHorizontal = isHorizontal(divPager, expressionResolver);
        divPagerView.setOrientation(!zIsHorizontal ? 1 : 0);
        divPagerAdapter.setCrossAxisAlignment(divPager.crossAxisAlignment.evaluate(expressionResolver));
        DivPagerView divPagerView2 = divPagerView;
        if (ViewsKt.isActuallyLaidOut(divPagerView2)) {
            DisplayMetrics metrics = divPagerView.getResources().getDisplayMetrics();
            ViewPager2 viewPager = divPagerView.getViewPager();
            int width = zIsHorizontal ? viewPager.getWidth() : viewPager.getHeight();
            DivFixedSize divFixedSize = divPager.itemSpacing;
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            float pxF = BaseDivViewExtensionsKt.toPxF(divFixedSize, metrics, expressionResolver);
            boolean zBooleanValue = divPager.infiniteScroll.evaluate(expressionResolver).booleanValue();
            DivPager.ItemAlignment itemAlignmentEvaluate = divPager.scrollAxisAlignment.evaluate(expressionResolver);
            DivPagerPaddingsHolder divPagerPaddingsHolder2 = new DivPagerPaddingsHolder(divPager.getPaddings(), expressionResolver, divPagerView2, metrics, zIsHorizontal, itemAlignmentEvaluate);
            DivPagerLayoutMode divPagerLayoutMode = divPager.layoutMode;
            if (divPagerLayoutMode instanceof DivPagerLayoutMode.PageSize) {
                wrapContentPageSizeProvider = new PercentagePageSizeProvider(((DivPagerLayoutMode.PageSize) divPagerLayoutMode).getValue(), expressionResolver, width, divPagerPaddingsHolder2, itemAlignmentEvaluate);
            } else {
                if (divPagerLayoutMode instanceof DivPagerLayoutMode.NeighbourPageSize) {
                    neighbourPageSizeProvider = new NeighbourPageSizeProvider(((DivPagerLayoutMode.NeighbourPageSize) divPagerLayoutMode).getValue(), expressionResolver, metrics, width, pxF, divPagerPaddingsHolder2, itemAlignmentEvaluate);
                } else if (divPagerLayoutMode instanceof DivPagerLayoutMode.PageContentSize) {
                    wrapContentPageSizeProvider = new WrapContentPageSizeProvider(recyclerView, zIsHorizontal, width, divPagerPaddingsHolder2, itemAlignmentEvaluate);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (neighbourPageSizeProvider instanceof FixedPageSizeProvider) {
                    FixedPageSizeProvider fixedPageSizeProvider = (FixedPageSizeProvider) neighbourPageSizeProvider;
                    divPagerPageSizeProvider = neighbourPageSizeProvider;
                    new FixedPageSizeOffScreenPagesController(divPagerView, width, pxF, fixedPageSizeProvider, divPagerPaddingsHolder2, zBooleanValue, divPagerAdapter);
                    divPagerPaddingsHolder = divPagerPaddingsHolder2;
                    wrapContentPageSizeItemDecoration = new FixedPageSizeItemDecoration(divPagerPaddingsHolder, fixedPageSizeProvider);
                    itemAlignment = itemAlignmentEvaluate;
                } else {
                    divPagerPageSizeProvider = neighbourPageSizeProvider;
                    divPagerPaddingsHolder = divPagerPaddingsHolder2;
                    new WrapContentPageSizeOffScreenPagesController(divPagerView, pxF, divPagerPageSizeProvider, divPagerPaddingsHolder, divPagerAdapter);
                    itemAlignment = itemAlignmentEvaluate;
                    wrapContentPageSizeItemDecoration = new WrapContentPageSizeItemDecoration(width, divPagerPaddingsHolder, itemAlignment);
                }
                setItemDecoration(divPagerView.getViewPager(), wrapContentPageSizeItemDecoration);
                divPagerView.setPageTransformer$div_release(new DivPagerPageTransformer(recyclerView, expressionResolver, sparseArray, width, divPager.pageTransformation, new DivPagerPageOffsetProvider(width, pxF, divPagerPageSizeProvider, divPagerPaddingsHolder, zBooleanValue, divPagerAdapter, itemAlignment), zIsHorizontal));
            }
            neighbourPageSizeProvider = wrapContentPageSizeProvider;
            if (neighbourPageSizeProvider instanceof FixedPageSizeProvider) {
                FixedPageSizeProvider fixedPageSizeProvider2 = (FixedPageSizeProvider) neighbourPageSizeProvider;
                divPagerPageSizeProvider = neighbourPageSizeProvider;
                new FixedPageSizeOffScreenPagesController(divPagerView, width, pxF, fixedPageSizeProvider2, divPagerPaddingsHolder2, zBooleanValue, divPagerAdapter);
                divPagerPaddingsHolder = divPagerPaddingsHolder2;
                wrapContentPageSizeItemDecoration = new FixedPageSizeItemDecoration(divPagerPaddingsHolder, fixedPageSizeProvider2);
                itemAlignment = itemAlignmentEvaluate;
            } else {
                divPagerPageSizeProvider = neighbourPageSizeProvider;
                divPagerPaddingsHolder = divPagerPaddingsHolder2;
                new WrapContentPageSizeOffScreenPagesController(divPagerView, pxF, divPagerPageSizeProvider, divPagerPaddingsHolder, divPagerAdapter);
                itemAlignment = itemAlignmentEvaluate;
                wrapContentPageSizeItemDecoration = new WrapContentPageSizeItemDecoration(width, divPagerPaddingsHolder, itemAlignment);
            }
            setItemDecoration(divPagerView.getViewPager(), wrapContentPageSizeItemDecoration);
            divPagerView.setPageTransformer$div_release(new DivPagerPageTransformer(recyclerView, expressionResolver, sparseArray, width, divPager.pageTransformation, new DivPagerPageOffsetProvider(width, pxF, divPagerPageSizeProvider, divPagerPaddingsHolder, zBooleanValue, divPagerAdapter, itemAlignment), zIsHorizontal));
        }
    }

    private final boolean isHorizontal(DivPager divPager, ExpressionResolver expressionResolver) {
        return divPager.orientation.evaluate(expressionResolver) == DivPager.Orientation.HORIZONTAL;
    }

    /* JADX INFO: renamed from: com.yandex.div.core.view2.divs.pager.DivPagerBinder$observeSizeChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DivPagerBinder.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016JP\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/yandex/div/core/view2/divs/pager/DivPagerBinder$observeSizeChange$1", "Lcom/yandex/div/core/Disposable;", "Landroid/view/View$OnLayoutChangeListener;", "oldSize", "", "close", "", "onLayoutChange", "v", "Landroid/view/View;", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ViewOnLayoutChangeListenerC39221 implements Disposable, View.OnLayoutChangeListener {
        final /* synthetic */ DivPager $div;
        final /* synthetic */ Function1<Object, Unit> $observer;
        final /* synthetic */ ViewPager2 $this_observeSizeChange;
        private int oldSize;

        ViewOnLayoutChangeListenerC39221(ViewPager2 viewPager2, DivPager divPager, Function1<Object, Unit> function1) {
            this.$this_observeSizeChange = viewPager2;
            this.$div = divPager;
            this.$observer = function1;
            viewPager2.addOnLayoutChangeListener(this);
        }

        @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            this.$this_observeSizeChange.removeOnLayoutChangeListener(this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(v, "v");
            int width = this.$this_observeSizeChange.getOrientation() == 0 ? this.$this_observeSizeChange.getWidth() : this.$this_observeSizeChange.getHeight();
            if (this.oldSize == width) {
                if (this.$div.layoutMode instanceof DivPagerLayoutMode.PageContentSize) {
                    this.$this_observeSizeChange.requestTransform();
                }
            } else {
                this.oldSize = width;
                this.$observer.invoke(Integer.valueOf(width));
            }
        }
    }

    private final Disposable observeSizeChange(ViewPager2 viewPager2, DivPager divPager, Function1<Object, Unit> function1) {
        return new ViewOnLayoutChangeListenerC39221(viewPager2, divPager, function1);
    }

    private final void setItemDecoration(ViewPager2 viewPager2, RecyclerView.ItemDecoration itemDecoration) {
        removeItemDecorations(viewPager2);
        viewPager2.addItemDecoration(itemDecoration);
    }

    private final void removeItemDecorations(ViewPager2 viewPager2) {
        int itemDecorationCount = viewPager2.getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            viewPager2.removeItemDecorationAt(i);
        }
    }

    private final void bindItemBuilder(final DivPagerView divPagerView, final BindingContext bindingContext, DivPager divPager) {
        final DivCollectionItemBuilder divCollectionItemBuilder = divPager.itemBuilder;
        if (divCollectionItemBuilder == null) {
            return;
        }
        BaseDivViewExtensionsKt.bindItemBuilder(divCollectionItemBuilder, bindingContext.getExpressionResolver(), new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder.bindItemBuilder.1
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
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivPagerAdapter divPagerAdapter = (DivPagerAdapter) divPagerView.getViewPager().getAdapter();
                if (divPagerAdapter != null) {
                    divPagerAdapter.setItems(DivCollectionExtensionsKt.build(divCollectionItemBuilder, bindingContext.getExpressionResolver()));
                }
                DivPagerView.OnItemsUpdatedCallback pagerOnItemsCountChange = divPagerView.getPagerOnItemsCountChange();
                if (pagerOnItemsCountChange != null) {
                    pagerOnItemsCountChange.onItemsUpdated();
                }
                RecyclerView recyclerView = divPagerView.getRecyclerView();
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(divPagerView.getCurrentItem$div_release());
                }
                ViewPager2 viewPager = divPagerView.getViewPager();
                final DivPagerView divPagerView2 = divPagerView;
                viewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerBinder$bindItemBuilder$1$invoke$$inlined$doOnNextLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        view.removeOnLayoutChangeListener(this);
                        divPagerView2.getViewPager().requestTransform();
                    }
                });
            }
        });
    }
}
