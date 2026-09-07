package com.yandex.mobile.ads.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.mobile.ads.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nw extends ListAdapter<fy, hy<fy>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zg2 f9758a;
    private final nh2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw(Function1<? super zx, Unit> onAction, ix imageLoader, zg2 viewHolderMapper, nh2 viewTypeMapper) {
        super(new dx());
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(viewHolderMapper, "viewHolderMapper");
        Intrinsics.checkNotNullParameter(viewTypeMapper, "viewTypeMapper");
        this.f9758a = viewHolderMapper;
        this.b = viewTypeMapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(i, parent, false);
        zg2 zg2Var = this.f9758a;
        Intrinsics.checkNotNull(viewInflate);
        return zg2Var.a(viewInflate, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        hy holder = (hy) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        fy item = getItem(i);
        Intrinsics.checkNotNull(item);
        holder.a(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        fy viewHolder = getItem(i);
        nh2 nh2Var = this.b;
        Intrinsics.checkNotNull(viewHolder);
        nh2Var.getClass();
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof fy.c) {
            return R.layout.debug_panel_item_action_button;
        }
        if (viewHolder instanceof fy.h) {
            return R.layout.debug_panel_item_switch;
        }
        if (viewHolder instanceof fy.d) {
            return R.layout.debug_panel_item_divider;
        }
        if (viewHolder instanceof fy.e) {
            return R.layout.deubg_panel_item_header;
        }
        if (viewHolder instanceof fy.f) {
            return R.layout.deubg_panel_item_key_value;
        }
        if (viewHolder instanceof fy.g) {
            return R.layout.debug_panel_item_mediation_adapter;
        }
        if (viewHolder instanceof fy.b) {
            return R.layout.debug_panel_item_ad_units;
        }
        if (viewHolder instanceof fy.a) {
            return R.layout.debug_panel_item_ad_unit;
        }
        throw new NoWhenBranchMatchedException();
    }
}
