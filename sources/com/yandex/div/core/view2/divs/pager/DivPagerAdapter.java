package com.yandex.div.core.view2.divs.pager;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.DivCollectionAdapter;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div2.DivPager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPagerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GBQ\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u00103\u001a\u00020\u001dH\u0016J\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001dJ\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u001dJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001dH\u0014J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\u001dH\u0014J\u0010\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020\u001dH\u0014J\u0010\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020\u001dH\u0002J\u0018\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0018\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001dH\u0016J\u0016\u0010E\u001a\u0002092\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010 R\u001a\u0010.\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u00101R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;", "Lcom/yandex/div/core/view2/divs/DivCollectionAdapter;", "Lcom/yandex/div/core/view2/divs/pager/DivPagerViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "pageTranslations", "Landroid/util/SparseArray;", "", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "accessibilityEnabled", "", "pagerView", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "(Ljava/util/List;Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/DivBinder;Landroid/util/SparseArray;Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/core/state/DivStatePath;ZLcom/yandex/div/core/view2/divs/widgets/DivPagerView;)V", "crossAxisAlignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "getCrossAxisAlignment", "()Lcom/yandex/div2/DivPager$ItemAlignment;", "setCrossAxisAlignment", "(Lcom/yandex/div2/DivPager$ItemAlignment;)V", "currentItem", "", "currentRealItem", "getCurrentRealItem", "()I", "value", "infiniteScrollEnabled", "getInfiniteScrollEnabled", "()Z", "setInfiniteScrollEnabled", "(Z)V", "isHorizontal", "itemsToShow", "Lkotlin/collections/AbstractList;", "getItemsToShow", "()Lkotlin/collections/AbstractList;", "offsetToRealItem", "getOffsetToRealItem", "orientation", "getOrientation", "setOrientation", "(I)V", "removedItems", "getItemCount", "getPosition", "visibleItemIndex", "getRealPosition", "rawPosition", "notifyRawItemChanged", "", b9.h.L, "notifyRawItemInserted", "notifyRawItemRemoved", "notifyVirtualItemsChanged", "originalPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "newItems", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerAdapter extends DivCollectionAdapter<DivPagerViewHolder> {
    public static final int OFFSET_TO_REAL_ITEM = 2;
    private final boolean accessibilityEnabled;
    private final BindingContext bindingContext;
    private DivPager.ItemAlignment crossAxisAlignment;
    private int currentItem;
    private final DivBinder divBinder;
    private boolean infiniteScrollEnabled;
    private final AbstractList<DivItemBuilderResult> itemsToShow;
    private int orientation;
    private final SparseArray<Float> pageTranslations;
    private final DivPagerView pagerView;
    private final DivStatePath path;
    private int removedItems;
    private final DivViewCreator viewCreator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivPagerAdapter(List<DivItemBuilderResult> items, BindingContext bindingContext, DivBinder divBinder, SparseArray<Float> pageTranslations, DivViewCreator viewCreator, DivStatePath path, boolean z, DivPagerView pagerView) {
        super(items);
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(pageTranslations, "pageTranslations");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(pagerView, "pagerView");
        this.bindingContext = bindingContext;
        this.divBinder = divBinder;
        this.pageTranslations = pageTranslations;
        this.viewCreator = viewCreator;
        this.path = path;
        this.accessibilityEnabled = z;
        this.pagerView = pagerView;
        this.itemsToShow = new AbstractList<DivItemBuilderResult>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerAdapter$itemsToShow$1
            public /* bridge */ boolean contains(DivItemBuilderResult divItemBuilderResult) {
                return super.contains(divItemBuilderResult);
            }

            @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof DivItemBuilderResult) {
                    return contains((DivItemBuilderResult) obj);
                }
                return false;
            }

            public /* bridge */ int indexOf(DivItemBuilderResult divItemBuilderResult) {
                return super.indexOf(divItemBuilderResult);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof DivItemBuilderResult) {
                    return indexOf((DivItemBuilderResult) obj);
                }
                return -1;
            }

            public /* bridge */ int lastIndexOf(DivItemBuilderResult divItemBuilderResult) {
                return super.lastIndexOf(divItemBuilderResult);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof DivItemBuilderResult) {
                    return lastIndexOf((DivItemBuilderResult) obj);
                }
                return -1;
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            public int getSize() {
                return this.this$0.getVisibleItems().size() + (this.this$0.getInfiniteScrollEnabled() ? 4 : 0);
            }

            @Override // kotlin.collections.AbstractList, java.util.List
            public DivItemBuilderResult get(int index) {
                if (!this.this$0.getInfiniteScrollEnabled()) {
                    return this.this$0.getVisibleItems().get(index);
                }
                int size = (this.this$0.getVisibleItems().size() + index) - 2;
                int size2 = this.this$0.getVisibleItems().size();
                int i = size % size2;
                return this.this$0.getVisibleItems().get(i + (size2 & (((i ^ size2) & ((-i) | i)) >> 31)));
            }
        };
        this.crossAxisAlignment = DivPager.ItemAlignment.START;
        this.currentItem = -1;
    }

    public final AbstractList<DivItemBuilderResult> getItemsToShow() {
        return this.itemsToShow;
    }

    public final int getCurrentRealItem() {
        return this.pagerView.getCurrentItem$div_release() - getOffsetToRealItem();
    }

    private final int getOffsetToRealItem() {
        return this.infiniteScrollEnabled ? 2 : 0;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        this.orientation = i;
    }

    public final DivPager.ItemAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final void setCrossAxisAlignment(DivPager.ItemAlignment itemAlignment) {
        Intrinsics.checkNotNullParameter(itemAlignment, "<set-?>");
        this.crossAxisAlignment = itemAlignment;
    }

    public final boolean getInfiniteScrollEnabled() {
        return this.infiniteScrollEnabled;
    }

    public final void setInfiniteScrollEnabled(boolean z) {
        if (this.infiniteScrollEnabled == z) {
            return;
        }
        this.infiniteScrollEnabled = z;
        notifyItemRangeChanged(0, getItemCount());
        DivPagerView divPagerView = this.pagerView;
        divPagerView.setCurrentItem$div_release(divPagerView.getCurrentItem$div_release() + (z ? 2 : -2));
    }

    public final int getPosition(int visibleItemIndex) {
        return visibleItemIndex + getOffsetToRealItem();
    }

    public final int getRealPosition(int rawPosition) {
        return rawPosition - getOffsetToRealItem();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DivPagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new DivPagerViewHolder(this.bindingContext, new DivPagerPageLayout(this.bindingContext.getDivView().getContext(), new Function0<Boolean>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerAdapter$onCreateViewHolder$view$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.isHorizontal());
            }
        }), this.divBinder, this.viewCreator, this.path, this.accessibilityEnabled, new Function0<Boolean>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerAdapter.onCreateViewHolder.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(DivPagerAdapter.this.isHorizontal());
            }
        }, new Function0<DivPager.ItemAlignment>() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerAdapter.onCreateViewHolder.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DivPager.ItemAlignment invoke() {
                return DivPagerAdapter.this.getCrossAxisAlignment();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHorizontal() {
        return this.orientation == 0;
    }

    @Override // com.yandex.div.core.view2.divs.VisibilityAwareAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsToShow.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DivPagerViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DivItemBuilderResult divItemBuilderResult = this.itemsToShow.get(position);
        holder.bind(this.bindingContext.getFor(divItemBuilderResult.getExpressionResolver()), divItemBuilderResult.getDiv(), position);
        Float f = this.pageTranslations.get(position);
        if (f != null) {
            float fFloatValue = f.floatValue();
            if (isHorizontal()) {
                holder.itemView.setTranslationX(fFloatValue);
            } else {
                holder.itemView.setTranslationY(fFloatValue);
            }
        }
    }

    @Override // com.yandex.div.core.view2.divs.DivCollectionAdapter
    public void setItems(List<DivItemBuilderResult> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        int size = getItems().size();
        this.removedItems = 0;
        int currentItem$div_release = this.pagerView.getCurrentItem$div_release();
        this.currentItem = currentItem$div_release;
        super.setItems(newItems);
        DivPagerView divPagerView = this.pagerView;
        if (this.removedItems != size) {
            currentItem$div_release = this.currentItem;
        }
        divPagerView.setCurrentItem$div_release(currentItem$div_release);
    }

    @Override // com.yandex.div.core.view2.divs.VisibilityAwareAdapter
    protected void notifyRawItemRemoved(int position) {
        this.removedItems++;
        if (!this.infiniteScrollEnabled) {
            notifyItemRemoved(position);
            int i = this.currentItem;
            if (i > position) {
                this.currentItem = i - 1;
                return;
            }
            return;
        }
        int i2 = position + 2;
        notifyItemRemoved(i2);
        notifyVirtualItemsChanged(position);
        int i3 = this.currentItem;
        if (i3 > i2) {
            this.currentItem = i3 - 1;
        }
    }

    @Override // com.yandex.div.core.view2.divs.VisibilityAwareAdapter
    protected void notifyRawItemInserted(int position) {
        if (!this.infiniteScrollEnabled) {
            notifyItemInserted(position);
            int i = this.currentItem;
            if (i >= position) {
                this.currentItem = i + 1;
                return;
            }
            return;
        }
        int i2 = position + 2;
        notifyItemInserted(i2);
        notifyVirtualItemsChanged(position);
        int i3 = this.currentItem;
        if (i3 >= i2) {
            this.currentItem = i3 + 1;
        }
    }

    @Override // com.yandex.div.core.view2.divs.VisibilityAwareAdapter
    protected void notifyRawItemChanged(int position) {
        if (!this.infiniteScrollEnabled) {
            notifyItemChanged(position);
        } else {
            notifyItemChanged(position + 2);
            notifyVirtualItemsChanged(position);
        }
    }

    private final void notifyVirtualItemsChanged(int originalPosition) {
        if (originalPosition >= 0 && originalPosition < 2) {
            notifyItemRangeChanged(getVisibleItems().size() + originalPosition, 2 - originalPosition);
            return;
        }
        int size = getVisibleItems().size() - 2;
        if (originalPosition >= getVisibleItems().size() || size > originalPosition) {
            return;
        }
        notifyItemRangeChanged((originalPosition - getVisibleItems().size()) + 2, 2);
    }
}
