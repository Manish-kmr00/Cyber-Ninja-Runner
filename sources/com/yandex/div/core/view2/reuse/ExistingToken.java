package com.yandex.div.core.view2.reuse;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.view2.divs.gallery.DivGalleryAdapter;
import com.yandex.div.core.view2.divs.pager.DivPagerAdapter;
import com.yandex.div.core.view2.divs.widgets.DivCustomWrapper;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div.core.view2.divs.widgets.DivStateLayout;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivGrid;
import com.yandex.div2.DivPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExistingToken.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0002R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/core/view2/reuse/ExistingToken;", "Lcom/yandex/div/core/view2/reuse/Token;", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "childIndex", "", "view", "Landroid/view/View;", "parentToken", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;ILandroid/view/View;Lcom/yandex/div/core/view2/reuse/ExistingToken;)V", "getParentToken", "()Lcom/yandex/div/core/view2/reuse/ExistingToken;", "getView", "()Landroid/view/View;", "getChildrenTokens", "", "simpleItemsToExistingTokenList", FirebaseAnalytics.Param.ITEMS, "stateToExistingTokenList", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "itemsToExistingTokenList", "Lcom/yandex/div2/DivContainer;", "Lcom/yandex/div2/DivCustom;", "Lcom/yandex/div2/DivGallery;", "Lcom/yandex/div2/DivGrid;", "Lcom/yandex/div2/DivPager;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExistingToken extends Token {
    private final ExistingToken parentToken;
    private final View view;

    public final View getView() {
        return this.view;
    }

    public final ExistingToken getParentToken() {
        return this.parentToken;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExistingToken(DivItemBuilderResult item, int i, View view, ExistingToken existingToken) {
        super(item, i);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.parentToken = existingToken;
    }

    public static /* synthetic */ List getChildrenTokens$default(ExistingToken existingToken, ExistingToken existingToken2, int i, Object obj) {
        if ((i & 1) != 0) {
            existingToken2 = null;
        }
        return existingToken.getChildrenTokens(existingToken2);
    }

    public final List<ExistingToken> getChildrenTokens(ExistingToken parentToken) {
        Div div = getDiv();
        if (!(div instanceof Div.Text) && !(div instanceof Div.Image) && !(div instanceof Div.GifImage) && !(div instanceof Div.Separator) && !(div instanceof Div.Indicator) && !(div instanceof Div.Slider) && !(div instanceof Div.Input) && !(div instanceof Div.Select) && !(div instanceof Div.Video) && !(div instanceof Div.Switch)) {
            if (div instanceof Div.Container) {
                return itemsToExistingTokenList(((Div.Container) getDiv()).getValue(), getItem().getExpressionResolver(), parentToken);
            }
            if (div instanceof Div.Custom) {
                return itemsToExistingTokenList(((Div.Custom) getDiv()).getValue(), getItem().getExpressionResolver(), parentToken);
            }
            if (div instanceof Div.Grid) {
                return itemsToExistingTokenList(((Div.Grid) getDiv()).getValue(), getItem().getExpressionResolver(), parentToken);
            }
            if (div instanceof Div.Gallery) {
                return itemsToExistingTokenList(((Div.Gallery) getDiv()).getValue(), getItem().getExpressionResolver(), parentToken);
            }
            if (div instanceof Div.Pager) {
                return itemsToExistingTokenList(((Div.Pager) getDiv()).getValue(), getItem().getExpressionResolver(), parentToken);
            }
            if (div instanceof Div.Tabs) {
                throw new RebindTask.UnsupportedElementException(getDiv().getClass());
            }
            if (div instanceof Div.State) {
                return stateToExistingTokenList(getItem().getExpressionResolver(), parentToken);
            }
            throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.emptyList();
    }

    private final List<ExistingToken> itemsToExistingTokenList(DivContainer divContainer, ExpressionResolver expressionResolver, ExistingToken existingToken) {
        return simpleItemsToExistingTokenList(DivCollectionExtensionsKt.buildItems(divContainer, expressionResolver), existingToken);
    }

    private final List<ExistingToken> itemsToExistingTokenList(DivCustom divCustom, ExpressionResolver expressionResolver, ExistingToken existingToken) {
        ArrayList arrayList = new ArrayList();
        View view = this.view;
        DivCustomWrapper divCustomWrapper = view instanceof DivCustomWrapper ? (DivCustomWrapper) view : null;
        View customView = divCustomWrapper != null ? divCustomWrapper.getCustomView() : null;
        ViewGroup viewGroup = customView instanceof ViewGroup ? (ViewGroup) customView : null;
        if (viewGroup == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        for (Object obj : DivCollectionExtensionsKt.getNonNullItems(divCustom)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult itemBuilderResult = DivCollectionExtensionsKt.toItemBuilderResult((Div) obj, expressionResolver);
            View childAt = viewGroup.getChildAt(i);
            if (childAt == null) {
                return CollectionsKt.emptyList();
            }
            Intrinsics.checkNotNullExpressionValue(childAt, "customView.getChildAt(index) ?: return emptyList()");
            arrayList.add(new ExistingToken(itemBuilderResult, i, childAt, existingToken == null ? this : existingToken));
            i = i2;
        }
        return arrayList;
    }

    private final List<ExistingToken> itemsToExistingTokenList(DivGrid divGrid, ExpressionResolver expressionResolver, ExistingToken existingToken) {
        return simpleItemsToExistingTokenList(DivCollectionExtensionsKt.itemsToDivItemBuilderResult(divGrid, expressionResolver), existingToken);
    }

    private final List<ExistingToken> stateToExistingTokenList(ExpressionResolver resolver, ExistingToken parentToken) {
        Div activeStateDiv$div_release;
        View view = this.view;
        DivStateLayout divStateLayout = view instanceof DivStateLayout ? (DivStateLayout) view : null;
        if (divStateLayout == null || (activeStateDiv$div_release = divStateLayout.getActiveStateDiv()) == null) {
            return CollectionsKt.emptyList();
        }
        return simpleItemsToExistingTokenList(DivCollectionExtensionsKt.toDivItemBuilderResult(CollectionsKt.listOf(activeStateDiv$div_release), resolver), parentToken);
    }

    private final List<ExistingToken> itemsToExistingTokenList(DivPager divPager, ExpressionResolver expressionResolver, ExistingToken existingToken) {
        ViewPager2 viewPager;
        ArrayList arrayList = new ArrayList();
        View view = this.view;
        DivPagerView divPagerView = view instanceof DivPagerView ? (DivPagerView) view : null;
        if (divPagerView == null || (viewPager = divPagerView.getViewPager()) == null) {
            return CollectionsKt.emptyList();
        }
        RecyclerView.Adapter adapter = viewPager.getAdapter();
        DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
        if (divPagerAdapter == null) {
            return CollectionsKt.emptyList();
        }
        AbstractList<DivItemBuilderResult> itemsToShow = divPagerAdapter.getItemsToShow();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(itemsToShow, 10));
        Iterator<DivItemBuilderResult> it = itemsToShow.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(it.next().getDiv().hash()));
        }
        ArrayList arrayList3 = arrayList2;
        int i = 0;
        for (Object obj : DivCollectionExtensionsKt.buildItems(divPager, expressionResolver)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            if (arrayList3.contains(Integer.valueOf(divItemBuilderResult.getDiv().hash()))) {
                View pageView = ((DivPagerView) this.view).getPageView(arrayList3.indexOf(Integer.valueOf(divItemBuilderResult.getDiv().hash())));
                if (pageView != null) {
                    arrayList.add(new ExistingToken(divItemBuilderResult, i, pageView, existingToken == null ? this : existingToken));
                }
            }
            i = i2;
        }
        return arrayList;
    }

    private final List<ExistingToken> itemsToExistingTokenList(DivGallery divGallery, ExpressionResolver expressionResolver, ExistingToken existingToken) {
        View itemView;
        ArrayList arrayList = new ArrayList();
        View view = this.view;
        DivRecyclerView divRecyclerView = view instanceof DivRecyclerView ? (DivRecyclerView) view : null;
        RecyclerView.Adapter adapter = divRecyclerView != null ? divRecyclerView.getAdapter() : null;
        DivGalleryAdapter divGalleryAdapter = adapter instanceof DivGalleryAdapter ? (DivGalleryAdapter) adapter : null;
        if (divGalleryAdapter == null) {
            return CollectionsKt.emptyList();
        }
        List<DivItemBuilderResult> visibleItems = divGalleryAdapter.getVisibleItems();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(visibleItems, 10));
        Iterator<T> it = visibleItems.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((DivItemBuilderResult) it.next()).getDiv().hash()));
        }
        ArrayList arrayList3 = arrayList2;
        int i = 0;
        for (Object obj : DivCollectionExtensionsKt.buildItems(divGallery, expressionResolver)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            if (arrayList3.contains(Integer.valueOf(divItemBuilderResult.getDiv().hash())) && (itemView = ((DivRecyclerView) this.view).getItemView(i)) != null) {
                arrayList.add(new ExistingToken(divItemBuilderResult, i, itemView, existingToken == null ? this : existingToken));
            }
            i = i2;
        }
        return arrayList;
    }

    private final List<ExistingToken> simpleItemsToExistingTokenList(List<DivItemBuilderResult> items, ExistingToken parentToken) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) obj;
            View view = this.view;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            View childAt = viewGroup != null ? viewGroup.getChildAt(i) : null;
            if (childAt == null) {
                return CollectionsKt.emptyList();
            }
            Intrinsics.checkNotNullExpressionValue(childAt, "(view as? ViewGroup)?.ge…ex) ?: return emptyList()");
            arrayList.add(new ExistingToken(divItemBuilderResult, i, childAt, parentToken == null ? this : parentToken));
            i = i2;
        }
        return arrayList;
    }
}
