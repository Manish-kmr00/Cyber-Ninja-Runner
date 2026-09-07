package com.inmobi.ads.viewsv2;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.inmobi.media.C3513p7;
import com.inmobi.media.C3625x7;
import com.inmobi.media.L7;
import com.inmobi.media.Q7;
import com.inmobi.media.T7;
import com.json.b9;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/inmobi/ads/viewsv2/NativeRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/inmobi/media/Q7;", "Lcom/inmobi/media/T7;", "Lcom/inmobi/media/x7;", "nativeDataModel", "Lcom/inmobi/media/L7;", "nativeLayoutInflater", "<init>", "(Lcom/inmobi/media/x7;Lcom/inmobi/media/L7;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/inmobi/media/Q7;", "holder", b9.h.L, "", "onBindViewHolder", "(Lcom/inmobi/media/Q7;I)V", "onViewRecycled", "(Lcom/inmobi/media/Q7;)V", "Lcom/inmobi/media/p7;", "pageContainerAsset", "buildScrollableView", "(ILandroid/view/ViewGroup;Lcom/inmobi/media/p7;)Landroid/view/ViewGroup;", "getItemCount", "()I", "destroy", "()V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NativeRecyclerViewAdapter extends RecyclerView.Adapter<Q7> implements T7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3625x7 f3024a;
    public L7 b;
    public final SparseArray c;

    public NativeRecyclerViewAdapter(C3625x7 nativeDataModel, L7 nativeLayoutInflater) {
        Intrinsics.checkNotNullParameter(nativeDataModel, "nativeDataModel");
        Intrinsics.checkNotNullParameter(nativeLayoutInflater, "nativeLayoutInflater");
        this.f3024a = nativeDataModel;
        this.b = nativeLayoutInflater;
        this.c = new SparseArray();
    }

    public ViewGroup buildScrollableView(int position, ViewGroup parent, C3513p7 pageContainerAsset) {
        L7 l7;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageContainerAsset, "pageContainerAsset");
        L7 l8 = this.b;
        ViewGroup container = l8 != null ? l8.a(parent, pageContainerAsset) : null;
        if (container != null && (l7 = this.b) != null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(pageContainerAsset, "root");
            l7.b(container, pageContainerAsset);
        }
        return container;
    }

    @Override // com.inmobi.media.T7
    public void destroy() {
        C3625x7 c3625x7 = this.f3024a;
        if (c3625x7 != null) {
            c3625x7.l = null;
            c3625x7.g = null;
        }
        this.f3024a = null;
        this.b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        C3625x7 c3625x7 = this.f3024a;
        if (c3625x7 != null) {
            return c3625x7.d();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Q7 holder, int position) {
        View viewBuildScrollableView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        C3625x7 c3625x7 = this.f3024a;
        C3513p7 c3513p7B = c3625x7 != null ? c3625x7.b(position) : null;
        WeakReference weakReference = (WeakReference) this.c.get(position);
        if (c3513p7B != null) {
            if (weakReference == null || (viewBuildScrollableView = (View) weakReference.get()) == null) {
                viewBuildScrollableView = buildScrollableView(position, holder.f3174a, c3513p7B);
            }
            if (viewBuildScrollableView != null) {
                if (position != getItemCount() - 1) {
                    holder.f3174a.setPadding(0, 0, 16, 0);
                }
                holder.f3174a.addView(viewBuildScrollableView);
                this.c.put(position, new WeakReference(viewBuildScrollableView));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Q7 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new Q7(new FrameLayout(parent.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(Q7 holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.f3174a.removeAllViews();
        super.onViewRecycled(holder);
    }
}
