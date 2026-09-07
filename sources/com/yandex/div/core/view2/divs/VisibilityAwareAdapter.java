package com.yandex.div.core.view2.divs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.billingclient.api.BillingClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.Disposable;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div2.DivVisibility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VisibilityAwareAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fH\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fH\u0014J\u0010\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fH\u0014J\u0006\u0010&\u001a\u00020!J\u001a\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001f2\b\b\u0002\u0010)\u001a\u00020\u001bH\u0004R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u001a\u001a\u00020\u001b*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/yandex/div/core/view2/divs/VisibilityAwareAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "(Ljava/util/List;)V", "_visibleItems", "", "Lkotlin/collections/IndexedValue;", "indexedItems", "", "getIndexedItems", "()Ljava/lang/Iterable;", "getItems", "()Ljava/util/List;", BillingClient.FeatureType.SUBSCRIPTIONS, "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "visibilityMap", "", "", "visibleItems", "getVisibleItems", "visibility", "Lcom/yandex/div2/DivVisibility;", "getVisibility", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;)Lcom/yandex/div2/DivVisibility;", "getItemCount", "", "initVisibleItems", "", "notifyRawItemChanged", b9.h.L, "notifyRawItemInserted", "notifyRawItemRemoved", "subscribeOnElements", "updateItemVisibility", "rawIndex", "newVisibility", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class VisibilityAwareAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements ExpressionSubscriber {
    private final List<IndexedValue<DivItemBuilderResult>> _visibleItems;
    private final List<DivItemBuilderResult> items;
    private final List<Disposable> subscriptions;
    private final Map<DivItemBuilderResult, Boolean> visibilityMap;
    private final List<DivItemBuilderResult> visibleItems;

    public VisibilityAwareAdapter(List<DivItemBuilderResult> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = CollectionsKt.toMutableList((Collection) items);
        this._visibleItems = new ArrayList();
        this.visibleItems = new AbstractList<DivItemBuilderResult>(this) { // from class: com.yandex.div.core.view2.divs.VisibilityAwareAdapter$visibleItems$1
            final /* synthetic */ VisibilityAwareAdapter<VH> this$0;

            {
                this.this$0 = this;
            }

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

            @Override // kotlin.collections.AbstractList, java.util.List
            public DivItemBuilderResult get(int index) {
                return (DivItemBuilderResult) ((IndexedValue) ((VisibilityAwareAdapter) this.this$0)._visibleItems.get(index)).getValue();
            }

            @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
            /* JADX INFO: renamed from: getSize */
            public int get_size() {
                return ((VisibilityAwareAdapter) this.this$0)._visibleItems.size();
            }
        };
        this.visibilityMap = new LinkedHashMap();
        this.subscriptions = new ArrayList();
        initVisibleItems();
        subscribeOnElements();
    }

    public final List<DivItemBuilderResult> getItems() {
        return this.items;
    }

    private final Iterable<IndexedValue<DivItemBuilderResult>> getIndexedItems() {
        return CollectionsKt.withIndex(this.items);
    }

    public final List<DivItemBuilderResult> getVisibleItems() {
        return this.visibleItems;
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.subscriptions;
    }

    private final void initVisibleItems() {
        for (IndexedValue<DivItemBuilderResult> indexedValue : getIndexedItems()) {
            boolean z = getVisibility(indexedValue.getValue()) != DivVisibility.GONE;
            this.visibilityMap.put(indexedValue.getValue(), Boolean.valueOf(z));
            if (z) {
                this._visibleItems.add(indexedValue);
            }
        }
    }

    private final DivVisibility getVisibility(DivItemBuilderResult divItemBuilderResult) {
        return divItemBuilderResult.getDiv().value().getVisibility().evaluate(divItemBuilderResult.getExpressionResolver());
    }

    public final void subscribeOnElements() {
        closeAllSubscription();
        for (final IndexedValue<DivItemBuilderResult> indexedValue : getIndexedItems()) {
            addSubscription(indexedValue.getValue().getDiv().value().getVisibility().observe(indexedValue.getValue().getExpressionResolver(), new Function1<DivVisibility, Unit>(this) { // from class: com.yandex.div.core.view2.divs.VisibilityAwareAdapter$subscribeOnElements$1$subscription$1
                final /* synthetic */ VisibilityAwareAdapter<VH> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DivVisibility divVisibility) {
                    invoke2(divVisibility);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DivVisibility it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.updateItemVisibility(indexedValue.getIndex(), it);
                }
            }));
        }
    }

    protected void notifyRawItemRemoved(int position) {
        notifyItemRemoved(position);
    }

    protected void notifyRawItemInserted(int position) {
        notifyItemInserted(position);
    }

    protected void notifyRawItemChanged(int position) {
        notifyItemChanged(position);
    }

    public static /* synthetic */ void updateItemVisibility$default(VisibilityAwareAdapter visibilityAwareAdapter, int i, DivVisibility divVisibility, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemVisibility");
        }
        if ((i2 & 2) != 0) {
            divVisibility = visibilityAwareAdapter.getVisibility(visibilityAwareAdapter.items.get(i));
        }
        visibilityAwareAdapter.updateItemVisibility(i, divVisibility);
    }

    protected final void updateItemVisibility(int rawIndex, DivVisibility newVisibility) {
        int size;
        Intrinsics.checkNotNullParameter(newVisibility, "newVisibility");
        DivItemBuilderResult divItemBuilderResult = this.items.get(rawIndex);
        Boolean bool = this.visibilityMap.get(divItemBuilderResult);
        int i = 0;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        boolean z = newVisibility != DivVisibility.GONE;
        int i2 = -1;
        if (!zBooleanValue && z) {
            Iterator<IndexedValue<DivItemBuilderResult>> it = this._visibleItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getIndex() > rawIndex) {
                    break;
                } else {
                    i++;
                }
            }
            Integer numValueOf = Integer.valueOf(i);
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                size = numValueOf.intValue();
            } else {
                size = this._visibleItems.size();
            }
            this._visibleItems.add(size, new IndexedValue<>(rawIndex, divItemBuilderResult));
            notifyRawItemInserted(size);
        } else if (zBooleanValue && !z) {
            Iterator<IndexedValue<DivItemBuilderResult>> it2 = this._visibleItems.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(it2.next().getValue(), divItemBuilderResult)) {
                    i2 = i;
                    break;
                }
                i++;
            }
            this._visibleItems.remove(i2);
            notifyRawItemRemoved(i2);
        }
        this.visibilityMap.put(divItemBuilderResult, Boolean.valueOf(z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.visibleItems.size();
    }
}
