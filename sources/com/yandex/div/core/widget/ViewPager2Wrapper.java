package com.yandex.div.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.yandex.div.core.view2.divs.pager.DivPagerAdapter;
import com.yandex.div.core.view2.divs.pager.DivPagerPageTransformer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ViewPager2Wrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ'\u0010\u001d\u001a\u00020\u00072\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u001f¢\u0006\u0002\b!H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010#J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,J!\u0010-\u001a\u00020\u001a2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0/¢\u0006\u0002\b!H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/yandex/div/core/widget/ViewPager2Wrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "orientation", "getOrientation", "()I", "setOrientation", "(I)V", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPageTransformer;", "pageTransformer", "getPageTransformer$div_release", "()Lcom/yandex/div/core/view2/divs/pager/DivPagerPageTransformer;", "setPageTransformer$div_release", "(Lcom/yandex/div/core/view2/divs/pager/DivPagerPageTransformer;)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "addView", "", "child", "Landroid/view/View;", "findMaxChildDimension", "decoratedDimensionGetter", "Lkotlin/Function2;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lkotlin/ExtensionFunctionType;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isWrapContentAlongCrossAxis", "", "isWrapContentAlongCrossAxis$div_release", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setRecycledViewPool", "viewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "withRecyclerView", "block", "Lkotlin/Function1;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ViewPager2Wrapper extends FrameLayout {
    private DivPagerPageTransformer pageTransformer;
    private final ViewPager2 viewPager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Wrapper(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Wrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ViewPager2Wrapper(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Wrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewPager = new ViewPager2(context);
        addView(getViewPager());
    }

    public ViewPager2 getViewPager() {
        return this.viewPager;
    }

    /* JADX INFO: renamed from: getPageTransformer$div_release, reason: from getter */
    public final DivPagerPageTransformer getPageTransformer() {
        return this.pageTransformer;
    }

    public final void setPageTransformer$div_release(DivPagerPageTransformer divPagerPageTransformer) {
        this.pageTransformer = divPagerPageTransformer;
        getViewPager().setPageTransformer(divPagerPageTransformer);
    }

    @Override // android.view.ViewGroup
    public final void addView(View child) {
        super.addView(child);
    }

    public final void setRecycledViewPool(final RecyclerView.RecycledViewPool viewPool) {
        Intrinsics.checkNotNullParameter(viewPool, "viewPool");
        withRecyclerView(new Function1<RecyclerView, Unit>() { // from class: com.yandex.div.core.widget.ViewPager2Wrapper.setRecycledViewPool.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecyclerView withRecyclerView) {
                Intrinsics.checkNotNullParameter(withRecyclerView, "$this$withRecyclerView");
                withRecyclerView.setRecycledViewPool(viewPool);
            }
        });
    }

    public final RecyclerView getRecyclerView() {
        View childAt = getViewPager().getChildAt(0);
        if (childAt instanceof RecyclerView) {
            return (RecyclerView) childAt;
        }
        return null;
    }

    private final void withRecyclerView(Function1<? super RecyclerView, Unit> block) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        block.invoke(recyclerView);
    }

    public final void setOrientation(int i) {
        DivPagerAdapter divPagerAdapter = (DivPagerAdapter) getViewPager().getAdapter();
        if (getViewPager().getOrientation() == i && divPagerAdapter != null && divPagerAdapter.getOrientation() == i) {
            return;
        }
        getViewPager().setOrientation(i);
        if (divPagerAdapter != null) {
            divPagerAdapter.setOrientation(i);
        }
        withRecyclerView(new Function1<RecyclerView, Unit>() { // from class: com.yandex.div.core.widget.ViewPager2Wrapper$orientation$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecyclerView withRecyclerView) {
                Intrinsics.checkNotNullParameter(withRecyclerView, "$this$withRecyclerView");
                withRecyclerView.getRecycledViewPool().clear();
                for (View view : ViewGroupKt.getChildren(withRecyclerView)) {
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                }
            }
        });
    }

    public final int getOrientation() {
        return getViewPager().getOrientation();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isWrapContentAlongCrossAxis$div_release()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        measureChild(getViewPager(), widthMeasureSpec, heightMeasureSpec);
        int orientation = getOrientation();
        if (orientation == 0) {
            super.onMeasure(widthMeasureSpec, ViewsKt.makeExactSpec(findMaxChildDimension(ViewPager2Wrapper$onMeasure$maxHeight$1.INSTANCE)));
        } else {
            if (orientation != 1) {
                return;
            }
            super.onMeasure(ViewsKt.makeExactSpec(findMaxChildDimension(ViewPager2Wrapper$onMeasure$maxWidth$1.INSTANCE)), heightMeasureSpec);
        }
    }

    public final boolean isWrapContentAlongCrossAxis$div_release() {
        if (getOrientation() == 0 && getLayoutParams().height == -2) {
            return true;
        }
        return getOrientation() == 1 && getLayoutParams().width == -2;
    }

    private final int findMaxChildDimension(final Function2<? super RecyclerView.LayoutManager, ? super View, Integer> decoratedDimensionGetter) {
        final Ref.IntRef intRef = new Ref.IntRef();
        withRecyclerView(new Function1<RecyclerView, Unit>() { // from class: com.yandex.div.core.widget.ViewPager2Wrapper.findMaxChildDimension.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecyclerView withRecyclerView) {
                Intrinsics.checkNotNullParameter(withRecyclerView, "$this$withRecyclerView");
                Sequence<View> children = ViewGroupKt.getChildren(withRecyclerView);
                Ref.IntRef intRef2 = intRef;
                Function2<RecyclerView.LayoutManager, View, Integer> function2 = decoratedDimensionGetter;
                for (View view : children) {
                    RecyclerView.LayoutManager it = withRecyclerView.getLayoutManager();
                    if (it != null) {
                        int i = intRef2.element;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        intRef2.element = Math.max(i, function2.invoke(it, view).intValue());
                    }
                }
            }
        });
        return intRef.element;
    }
}
