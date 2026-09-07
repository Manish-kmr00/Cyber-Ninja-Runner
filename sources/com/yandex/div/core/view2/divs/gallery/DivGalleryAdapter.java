package com.yandex.div.core.view2.divs.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.divs.DivCollectionAdapter;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div2.Div;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivGalleryAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bk\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\r\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryAdapter;", "Lcom/yandex/div/core/view2/divs/DivCollectionAdapter;", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "divBinder", "Lcom/yandex/div/core/view2/DivBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "itemStateBinder", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "itemView", "Lcom/yandex/div2/Div;", "div", "", "path", "Lcom/yandex/div/core/state/DivStatePath;", "(Ljava/util/List;Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/view2/DivViewCreator;Lkotlin/jvm/functions/Function2;Lcom/yandex/div/core/state/DivStatePath;)V", "ids", "Ljava/util/WeakHashMap;", "", "lastItemId", "getItemId", b9.h.L, "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGalleryAdapter extends DivCollectionAdapter<DivGalleryViewHolder> {
    private final BindingContext bindingContext;
    private final DivBinder divBinder;
    private final WeakHashMap<DivItemBuilderResult, Long> ids;
    private final Function2<View, Div, Unit> itemStateBinder;
    private long lastItemId;
    private final DivStatePath path;
    private final DivViewCreator viewCreator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DivGalleryAdapter(List<DivItemBuilderResult> items, BindingContext bindingContext, DivBinder divBinder, DivViewCreator viewCreator, Function2<? super View, ? super Div, Unit> itemStateBinder, DivStatePath path) {
        super(items);
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(divBinder, "divBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(itemStateBinder, "itemStateBinder");
        Intrinsics.checkNotNullParameter(path, "path");
        this.bindingContext = bindingContext;
        this.divBinder = divBinder;
        this.viewCreator = viewCreator;
        this.itemStateBinder = itemStateBinder;
        this.path = path;
        this.ids = new WeakHashMap<>();
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(DivGalleryViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.updateState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DivGalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new DivGalleryViewHolder(this.bindingContext, new DivGalleryItemLayout(this.bindingContext.getDivView().getContext()), this.divBinder, this.viewCreator, this.itemStateBinder, this.path);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        DivItemBuilderResult divItemBuilderResult = getVisibleItems().get(position);
        Long l = this.ids.get(divItemBuilderResult);
        if (l != null) {
            return l.longValue();
        }
        long j = this.lastItemId;
        this.lastItemId = 1 + j;
        this.ids.put(divItemBuilderResult, Long.valueOf(j));
        return j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DivGalleryViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DivItemBuilderResult divItemBuilderResult = getVisibleItems().get(position);
        holder.bind(this.bindingContext.getFor(divItemBuilderResult.getExpressionResolver()), divItemBuilderResult.getDiv(), position);
    }
}
