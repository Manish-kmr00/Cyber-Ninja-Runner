package com.yandex.div.core.view2.divs;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.downloader.DivPatchApply;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.downloader.DivPatchMap;
import com.yandex.div.core.expression.ExpressionResolverImpl;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivVisibility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCollectionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\u0016\u0017B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivCollectionAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/yandex/div/core/view2/divs/VisibilityAwareAdapter;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "(Ljava/util/List;)V", "applyPatch", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getItemViewType", "", b9.h.L, "setItems", "", "newItems", "DiffUtilCallback", "UpdateCallBack", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivCollectionAdapter<VH extends RecyclerView.ViewHolder> extends VisibilityAwareAdapter<VH> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivCollectionAdapter(List<DivItemBuilderResult> items) {
        super(items);
        Intrinsics.checkNotNullParameter(items, "items");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) CollectionsKt.getOrNull(getVisibleItems(), position);
        if (divItemBuilderResult == null) {
            return 0;
        }
        Expression<String> reuseId = divItemBuilderResult.getDiv().value().getReuseId();
        String strEvaluate = reuseId != null ? reuseId.evaluate(divItemBuilderResult.getExpressionResolver()) : null;
        if (strEvaluate != null) {
            return strEvaluate.hashCode();
        }
        return 0;
    }

    public final boolean applyPatch(RecyclerView recyclerView, DivPatchCache divPatchCache, BindingContext bindingContext) {
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        DivPatchMap patch = divPatchCache.getPatch(bindingContext.getDivView().getDataTag());
        if (patch == null) {
            return false;
        }
        DivPatchApply divPatchApply = new DivPatchApply(patch);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = 0;
        while (size < getItems().size()) {
            String id = getItems().get(size).getDiv().value().getId();
            List<Div> patchDivListById = id != null ? divPatchCache.getPatchDivListById(bindingContext.getDivView().getDataTag(), id) : null;
            if (patchDivListById != null) {
                updateItemVisibility(size, DivVisibility.GONE);
                getItems().remove(size);
                List<DivItemBuilderResult> divItemBuilderResult = DivCollectionExtensionsKt.toDivItemBuilderResult(patchDivListById, bindingContext.getExpressionResolver());
                getItems().addAll(size, divItemBuilderResult);
                Iterator<Integer> it = CollectionsKt.getIndices(divItemBuilderResult).iterator();
                while (it.hasNext()) {
                    VisibilityAwareAdapter.updateItemVisibility$default(this, ((IntIterator) it).nextInt() + size, null, 2, null);
                }
                size += patchDivListById.size() - 1;
                linkedHashSet.add(id);
            }
            size++;
        }
        Set<String> setKeySet = patch.getPatches().keySet();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!linkedHashSet.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        for (String str : arrayList) {
            int size2 = getItems().size();
            for (int i = 0; i < size2; i++) {
                Div divPatchDivChild = divPatchApply.patchDivChild(recyclerView != null ? recyclerView : bindingContext.getDivView(), getItems().get(i).getDiv(), str, bindingContext.getExpressionResolver());
                if (divPatchDivChild != null) {
                    updateItemVisibility(i, DivVisibility.GONE);
                    getItems().set(i, new DivItemBuilderResult(divPatchDivChild, bindingContext.getExpressionResolver()));
                    VisibilityAwareAdapter.updateItemVisibility$default(this, i, null, 2, null);
                    break;
                }
            }
        }
        if (linkedHashSet.isEmpty()) {
            return false;
        }
        subscribeOnElements();
        return true;
    }

    public void setItems(List<DivItemBuilderResult> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        DiffUtilCallback diffUtilCallback = new DiffUtilCallback(getItems(), newItems);
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(new UpdateCallBack(this, newItems));
        subscribeOnElements();
    }

    /* JADX INFO: compiled from: DivCollectionAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivCollectionAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "newItems", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "suppressMissingVariableException", "", "suppress", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class DiffUtilCallback extends DiffUtil.Callback {
        private final List<DivItemBuilderResult> newItems;
        private final List<DivItemBuilderResult> oldItems;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return true;
        }

        public DiffUtilCallback(List<DivItemBuilderResult> oldItems, List<DivItemBuilderResult> newItems) {
            Intrinsics.checkNotNullParameter(oldItems, "oldItems");
            Intrinsics.checkNotNullParameter(newItems, "newItems");
            this.oldItems = oldItems;
            this.newItems = newItems;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) CollectionsKt.getOrNull(this.oldItems, oldItemPosition);
            DivItemBuilderResult divItemBuilderResult2 = (DivItemBuilderResult) CollectionsKt.getOrNull(this.newItems, newItemPosition);
            if (divItemBuilderResult2 == null) {
                return divItemBuilderResult == null;
            }
            if (divItemBuilderResult == null) {
                return false;
            }
            suppressMissingVariableException(divItemBuilderResult, true);
            suppressMissingVariableException(divItemBuilderResult2, true);
            boolean zEquals = divItemBuilderResult.getDiv().equals(divItemBuilderResult2.getDiv(), divItemBuilderResult.getExpressionResolver(), divItemBuilderResult2.getExpressionResolver());
            suppressMissingVariableException(divItemBuilderResult, false);
            suppressMissingVariableException(divItemBuilderResult2, false);
            return zEquals;
        }

        private final void suppressMissingVariableException(DivItemBuilderResult divItemBuilderResult, boolean z) {
            ExpressionResolver expressionResolver = divItemBuilderResult.getExpressionResolver();
            ExpressionResolverImpl expressionResolverImpl = expressionResolver instanceof ExpressionResolverImpl ? (ExpressionResolverImpl) expressionResolver : null;
            if (expressionResolverImpl == null) {
                return;
            }
            expressionResolverImpl.setSuppressMissingVariableException(z);
        }
    }

    /* JADX INFO: compiled from: DivCollectionAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivCollectionAdapter$UpdateCallBack;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "newItems", "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "(Lcom/yandex/div/core/view2/divs/DivCollectionAdapter;Ljava/util/List;)V", "onChanged", "", b9.h.L, "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class UpdateCallBack implements ListUpdateCallback {
        private final List<DivItemBuilderResult> newItems;
        final /* synthetic */ DivCollectionAdapter<VH> this$0;

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, Object payload) {
        }

        public UpdateCallBack(DivCollectionAdapter divCollectionAdapter, List<DivItemBuilderResult> newItems) {
            Intrinsics.checkNotNullParameter(newItems, "newItems");
            this.this$0 = divCollectionAdapter;
            this.newItems = newItems;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            int size = position + count > this.newItems.size() ? this.newItems.size() - count : position;
            for (int i = 0; i < count; i++) {
                int i2 = position + i;
                this.this$0.getItems().add(i2, this.newItems.get(size + i));
                VisibilityAwareAdapter.updateItemVisibility$default(this.this$0, i2, null, 2, null);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            for (int i = 0; i < count; i++) {
                this.this$0.updateItemVisibility(position, DivVisibility.GONE);
                this.this$0.getItems().remove(position);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            onRemoved(fromPosition, 1);
            onInserted(toPosition, 1);
        }
    }
}
