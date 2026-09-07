package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l31 extends RecyclerView.Adapter<h31> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<uj0> f9474a;
    private final i31 b;

    public l31(pj0 imageProvider, List<uj0> imageValues, o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9474a = imageValues;
        this.b = new i31(imageProvider, adResponse);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.b.a(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        h31 holderImage = (h31) viewHolder;
        Intrinsics.checkNotNullParameter(holderImage, "holderImage");
        holderImage.a(this.f9474a.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f9474a.size();
    }
}
