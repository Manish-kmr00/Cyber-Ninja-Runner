package com.yandex.div.core.view2.divs.gallery;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.DivLinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.json.b9;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.DivViewState;
import com.yandex.div.core.state.GalleryState;
import com.yandex.div.core.state.UpdateStateScrollListener;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivBaseBinder;
import com.yandex.div.core.view2.divs.ReleasingViewPool;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div.core.view2.divs.widgets.ParentScrollRestrictor;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.widget.PaddingItemDecoration;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivCollectionItemBuilder;
import com.yandex.div2.DivGallery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivGalleryBinder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B5\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0019\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\f\u0010\u001a\u001a\u00020\u0011*\u00020\u0003H\u0002J\f\u0010\u001b\u001a\u00020\u0011*\u00020\u0003H\u0002J-\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u0011*\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivGallery;", "Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "divBinder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivBinder;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "scrollInterceptionAngle", "", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivViewCreator;Ljavax/inject/Provider;Lcom/yandex/div/core/downloader/DivPatchCache;F)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "updateDecorations", "bindItemBuilder", "removeItemDecorations", "resetAnimatorAndRestoreOnLayout", "scrollToPositionInternal", b9.h.L, "", "offset", "scrollPosition", "Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;", "(Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;ILjava/lang/Integer;Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;)V", "setItemDecoration", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivGalleryBinder implements DivViewBinder<DivGallery, DivRecyclerView> {
    private final DivBaseBinder baseBinder;
    private final Provider<DivBinder> divBinder;
    private final DivPatchCache divPatchCache;
    private final float scrollInterceptionAngle;
    private final DivViewCreator viewCreator;

    /* JADX INFO: compiled from: DivGalleryBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivGallery.ScrollMode.values().length];
            try {
                iArr[DivGallery.ScrollMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivGallery.ScrollMode.PAGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DivGalleryBinder(DivBaseBinder baseBinder, DivViewCreator viewCreator, Provider<DivBinder> divBinder, DivPatchCache divPatchCache, float f) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        this.baseBinder = baseBinder;
        this.viewCreator = viewCreator;
        this.divBinder = divBinder;
        this.divPatchCache = divPatchCache;
        this.scrollInterceptionAngle = f;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(final BindingContext context, final DivRecyclerView view, final DivGallery div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        final Div2View divView = context.getDivView();
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivGallery div2 = view != null ? view.getDiv() : null;
        if (div == div2) {
            RecyclerView.Adapter adapter = view.getAdapter();
            DivGalleryAdapter divGalleryAdapter = adapter instanceof DivGalleryAdapter ? (DivGalleryAdapter) adapter : null;
            if (divGalleryAdapter == null) {
                return;
            }
            divGalleryAdapter.applyPatch(view, this.divPatchCache, context);
            Div divRootDiv$div_release = divView.rootDiv$div_release();
            DivBinder divBinder = this.divBinder.get();
            Intrinsics.checkNotNullExpressionValue(divBinder, "divBinder.get()");
            BaseDivViewExtensionsKt.bindStates(view, divRootDiv$div_release, context, expressionResolver, divBinder);
            return;
        }
        this.baseBinder.bindView(context, view, div, div2);
        Function1<? super DivGallery.Orientation, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.gallery.DivGalleryBinder$bindView$reusableObserver$1
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
                this.this$0.updateDecorations(view, div, context);
            }
        };
        view.addSubscription(div.orientation.observe(expressionResolver, function1));
        view.addSubscription(div.scrollbar.observe(expressionResolver, function1));
        view.addSubscription(div.scrollMode.observe(expressionResolver, function1));
        view.addSubscription(div.itemSpacing.observe(expressionResolver, function1));
        view.addSubscription(div.restrictParentScroll.observe(expressionResolver, function1));
        Expression<Long> expression = div.columnCount;
        if (expression != null) {
            view.addSubscription(expression.observe(expressionResolver, function1));
        }
        view.setRecycledViewPool(new ReleasingViewPool(divView.getReleaseViewVisitor$div_release()));
        view.setScrollingTouchSlop(1);
        view.setClipToPadding(false);
        view.setOverScrollMode(2);
        Function2<View, Div, Unit> function2 = new Function2<View, Div, Unit>() { // from class: com.yandex.div.core.view2.divs.gallery.DivGalleryBinder$bindView$itemStateBinder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, Div div3) {
                invoke2(view2, div3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View itemView, Div div3) {
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                Intrinsics.checkNotNullParameter(div3, "<anonymous parameter 1>");
                Div divRootDiv$div_release2 = divView.rootDiv$div_release();
                BindingContext bindingContext = context;
                ExpressionResolver expressionResolver2 = expressionResolver;
                Object obj = this.divBinder.get();
                Intrinsics.checkNotNullExpressionValue(obj, "divBinder.get()");
                BaseDivViewExtensionsKt.bindStates(itemView, divRootDiv$div_release2, bindingContext, expressionResolver2, (DivBinder) obj);
            }
        };
        List<DivItemBuilderResult> listBuildItems = DivCollectionExtensionsKt.buildItems(div, expressionResolver);
        DivBinder divBinder2 = this.divBinder.get();
        Intrinsics.checkNotNullExpressionValue(divBinder2, "divBinder.get()");
        view.setAdapter(new DivGalleryAdapter(listBuildItems, context, divBinder2, this.viewCreator, function2, path));
        bindItemBuilder(view, context, div);
        resetAnimatorAndRestoreOnLayout(view);
        updateDecorations(view, div, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDecorations(DivRecyclerView view, DivGallery div, BindingContext context) {
        PaddingItemDecoration paddingItemDecoration;
        DivGridLayoutManager divGridLayoutManager;
        int visibleItemIndex;
        int paddingRight;
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        int i = div.orientation.evaluate(expressionResolver) == DivGallery.Orientation.HORIZONTAL ? 0 : 1;
        boolean z = div.scrollbar.evaluate(expressionResolver) == DivGallery.Scrollbar.AUTO;
        view.setVerticalScrollBarEnabled(z && i == 1);
        view.setHorizontalScrollBarEnabled(z && i == 0);
        view.setScrollbarFadingEnabled(false);
        Expression<Long> expression = div.columnCount;
        long jLongValue = expression != null ? expression.evaluate(expressionResolver).longValue() : 1L;
        view.setClipChildren(false);
        if (jLongValue == 1) {
            Long lEvaluate = div.itemSpacing.evaluate(expressionResolver);
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            paddingItemDecoration = new PaddingItemDecoration(0, BaseDivViewExtensionsKt.dpToPx(lEvaluate, metrics), 0, 0, 0, 0, i, 61, null);
        } else {
            Long lEvaluate2 = div.itemSpacing.evaluate(expressionResolver);
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            int iDpToPx = BaseDivViewExtensionsKt.dpToPx(lEvaluate2, metrics);
            Expression<Long> expression2 = div.crossSpacing;
            if (expression2 == null) {
                expression2 = div.itemSpacing;
            }
            paddingItemDecoration = new PaddingItemDecoration(0, iDpToPx, BaseDivViewExtensionsKt.dpToPx(expression2.evaluate(expressionResolver), metrics), 0, 0, 0, i, 57, null);
        }
        setItemDecoration(view, paddingItemDecoration);
        DivGallery.ScrollMode scrollModeEvaluate = div.scrollMode.evaluate(expressionResolver);
        view.setScrollMode(scrollModeEvaluate);
        int i2 = WhenMappings.$EnumSwitchMapping$0[scrollModeEvaluate.ordinal()];
        if (i2 == 1) {
            PagerSnapStartHelper pagerSnapStartHelper = view.getPagerSnapStartHelper();
            if (pagerSnapStartHelper != null) {
                pagerSnapStartHelper.attachToRecyclerView(null);
            }
        } else if (i2 == 2) {
            Long lEvaluate3 = div.itemSpacing.evaluate(expressionResolver);
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
            int iDpToPx2 = BaseDivViewExtensionsKt.dpToPx(lEvaluate3, displayMetrics);
            PagerSnapStartHelper pagerSnapStartHelper2 = view.getPagerSnapStartHelper();
            if (pagerSnapStartHelper2 != null) {
                pagerSnapStartHelper2.setItemSpacing(iDpToPx2);
            } else {
                pagerSnapStartHelper2 = new PagerSnapStartHelper(iDpToPx2);
                view.setPagerSnapStartHelper(pagerSnapStartHelper2);
            }
            pagerSnapStartHelper2.attachToRecyclerView(view);
        }
        if (jLongValue == 1) {
            divGridLayoutManager = new DivLinearLayoutManager(context, view, div, i);
        } else {
            divGridLayoutManager = new DivGridLayoutManager(context, view, div, i);
        }
        view.setLayoutManager(divGridLayoutManager.toLayoutManager());
        view.setScrollInterceptionAngle(this.scrollInterceptionAngle);
        view.clearOnScrollListeners();
        DivViewState currentState = context.getDivView().getCurrentState();
        if (currentState != null) {
            String id = div.getId();
            if (id == null) {
                id = String.valueOf(div.hashCode());
            }
            DivViewState.BlockState blockState = currentState.getBlockState(id);
            GalleryState galleryState = blockState instanceof GalleryState ? (GalleryState) blockState : null;
            if (galleryState != null) {
                visibleItemIndex = galleryState.getVisibleItemIndex();
            } else {
                long jLongValue2 = div.defaultItem.evaluate(expressionResolver).longValue();
                long j = jLongValue2 >> 31;
                if (j == 0 || j == -1) {
                    visibleItemIndex = (int) jLongValue2;
                } else {
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                    }
                    visibleItemIndex = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            if (galleryState != null) {
                paddingRight = galleryState.getScrollOffset();
            } else {
                paddingRight = ViewsKt.isLayoutRtl(view) ? view.getPaddingRight() : view.getPaddingLeft();
            }
            scrollToPositionInternal(view, visibleItemIndex, Integer.valueOf(paddingRight), ScrollPositionKt.toScrollPosition(scrollModeEvaluate));
            view.addOnScrollListener(new UpdateStateScrollListener(id, currentState, divGridLayoutManager));
        }
        view.addOnScrollListener(new DivGalleryScrollListener(context, view, divGridLayoutManager, div));
        view.setOnInterceptTouchEventListener(div.restrictParentScroll.evaluate(expressionResolver).booleanValue() ? ParentScrollRestrictor.INSTANCE : null);
    }

    private final void resetAnimatorAndRestoreOnLayout(final DivRecyclerView divRecyclerView) {
        final RecyclerView.ItemAnimator itemAnimator = divRecyclerView.getItemAnimator();
        divRecyclerView.setItemAnimator(null);
        DivRecyclerView divRecyclerView2 = divRecyclerView;
        if (ViewsKt.isActuallyLaidOut(divRecyclerView2) && !divRecyclerView2.isLayoutRequested()) {
            if (divRecyclerView.getItemAnimator() == null) {
                divRecyclerView.setItemAnimator(itemAnimator);
                return;
            }
            return;
        }
        divRecyclerView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.gallery.DivGalleryBinder$resetAnimatorAndRestoreOnLayout$$inlined$doOnActualLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view.removeOnLayoutChangeListener(this);
                if (divRecyclerView.getItemAnimator() == null) {
                    divRecyclerView.setItemAnimator(itemAnimator);
                }
            }
        });
    }

    static /* synthetic */ void scrollToPositionInternal$default(DivGalleryBinder divGalleryBinder, DivRecyclerView divRecyclerView, int i, Integer num, ScrollPosition scrollPosition, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        divGalleryBinder.scrollToPositionInternal(divRecyclerView, i, num, scrollPosition);
    }

    private final void scrollToPositionInternal(DivRecyclerView divRecyclerView, int i, Integer num, ScrollPosition scrollPosition) {
        Object layoutManager = divRecyclerView.getLayoutManager();
        DivGalleryItemHelper divGalleryItemHelper = layoutManager instanceof DivGalleryItemHelper ? (DivGalleryItemHelper) layoutManager : null;
        if (num == null && i == 0) {
            if (divGalleryItemHelper != null) {
                divGalleryItemHelper.instantScrollToPosition(i, scrollPosition);
            }
        } else if (num != null) {
            if (divGalleryItemHelper != null) {
                divGalleryItemHelper.instantScrollToPositionWithOffset(i, num.intValue(), scrollPosition);
            }
        } else if (divGalleryItemHelper != null) {
            divGalleryItemHelper.instantScrollToPosition(i, scrollPosition);
        }
    }

    private final void setItemDecoration(DivRecyclerView divRecyclerView, RecyclerView.ItemDecoration itemDecoration) {
        removeItemDecorations(divRecyclerView);
        divRecyclerView.addItemDecoration(itemDecoration);
    }

    private final void removeItemDecorations(DivRecyclerView divRecyclerView) {
        int itemDecorationCount = divRecyclerView.getItemDecorationCount();
        while (true) {
            itemDecorationCount--;
            if (-1 >= itemDecorationCount) {
                return;
            } else {
                divRecyclerView.removeItemDecorationAt(itemDecorationCount);
            }
        }
    }

    private final void bindItemBuilder(final DivRecyclerView divRecyclerView, final BindingContext bindingContext, DivGallery divGallery) {
        final DivCollectionItemBuilder divCollectionItemBuilder = divGallery.itemBuilder;
        if (divCollectionItemBuilder == null) {
            return;
        }
        BaseDivViewExtensionsKt.bindItemBuilder(divCollectionItemBuilder, bindingContext.getExpressionResolver(), new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.gallery.DivGalleryBinder.bindItemBuilder.1
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
                DivGalleryAdapter divGalleryAdapter = (DivGalleryAdapter) divRecyclerView.getAdapter();
                if (divGalleryAdapter != null) {
                    divGalleryAdapter.setItems(DivCollectionExtensionsKt.build(divCollectionItemBuilder, bindingContext.getExpressionResolver()));
                }
            }
        });
    }
}
