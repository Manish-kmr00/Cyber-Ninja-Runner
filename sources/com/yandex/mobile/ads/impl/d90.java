package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.mobile.ads.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d90 extends ListAdapter<fa0, ja0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka0 f8670a;
    private final y80 b;
    private final CoroutineScope c;
    private final LinkedHashMap d;
    private a e;
    private boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d90(ka0 feedViewModel, y80 feedAdItemVisibilityTracker) {
        super(new ga0());
        Intrinsics.checkNotNullParameter(feedViewModel, "feedViewModel");
        Intrinsics.checkNotNullParameter(feedAdItemVisibilityTracker, "feedAdItemVisibilityTracker");
        this.f8670a = feedViewModel;
        this.b = feedAdItemVisibilityTracker;
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.d = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d90 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f8670a.a(i);
    }

    protected abstract pt a();

    protected abstract ie2 b();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        a aVar = this.e;
        if (aVar == null) {
            aVar = new a();
        }
        this.e = aVar;
        recyclerView.removeOnAttachStateChangeListener(aVar);
        recyclerView.addOnAttachStateChangeListener(aVar);
        if (this.f8670a.d().get() < 0) {
            this.f8670a.f();
        }
        c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        a aVar = this.e;
        if (aVar != null) {
            recyclerView.removeOnAttachStateChangeListener(aVar);
        }
        this.b.a();
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        this.f = false;
    }

    public static final void access$bindHolder(d90 d90Var, ja0 ja0Var, int i) {
        fa0 fa0Var = d90Var.getCurrentList().get(i);
        if ((ja0Var instanceof z90) && (fa0Var instanceof k90)) {
            ((z90) ja0Var).a((k90) fa0Var);
        }
    }

    public static final void access$unregisterTrackers(d90 d90Var) {
        d90Var.b.a();
        CoroutineScopeKt.cancel$default(d90Var.c, null, 1, null);
        d90Var.f = false;
    }

    public static final void access$unbindHolder(d90 d90Var, ja0 ja0Var) {
        d90Var.getClass();
        z90 z90Var = ja0Var instanceof z90 ? (z90) ja0Var : null;
        if (z90Var != null) {
            z90Var.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ja0 holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.d.put(holder, Integer.valueOf(i));
        fa0 fa0Var = getCurrentList().get(i);
        if ((holder instanceof z90) && (fa0Var instanceof k90)) {
            ((z90) holder).a((k90) fa0Var);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ja0 onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        if (i == 0) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.monetization_ads_feed_item, parent, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            o3 o3VarA = this.f8670a.a();
            pt ptVarA = a();
            ie2 ie2VarB = b();
            return new z90(o3VarA, viewGroup, ptVarA, ie2VarB, new m90(o3VarA, viewGroup, ptVarA, ie2VarB));
        }
        View viewInflate2 = LayoutInflater.from(context).inflate(R.layout.monetization_ads_feed_progressbar, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new ca0(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(ja0 holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        if (holder instanceof z90) {
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            this.b.a(itemView, bindingAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(ja0 holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        y80 y80Var = this.b;
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        y80Var.a(itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ja0 holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        this.d.remove(holder);
        z90 z90Var = holder instanceof z90 ? (z90) holder : null;
        if (z90Var != null) {
            z90Var.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.a(new x80() { // from class: com.yandex.mobile.ads.impl.d90$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.x80
            public final void a(int i) {
                d90.a(this.f$0, i);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new e90(this, null), 3, null);
    }

    public /* synthetic */ d90(ka0 ka0Var, y80 y80Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ka0Var, (i & 2) != 0 ? new y80() : y80Var);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return Intrinsics.areEqual(getCurrentList().get(i), ea0.f8778a) ? 1 : 0;
    }

    private final class a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Map map = d90.this.d;
            d90 d90Var = d90.this;
            for (Map.Entry entry : map.entrySet()) {
                d90.access$bindHolder(d90Var, (ja0) entry.getKey(), ((Number) entry.getValue()).intValue());
            }
            d90.this.c();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            d90.access$unregisterTrackers(d90.this);
            Set setKeySet = d90.this.d.keySet();
            d90 d90Var = d90.this;
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                d90.access$unbindHolder(d90Var, (ja0) it.next());
            }
        }

        public a() {
        }
    }
}
