package com.yandex.mobile.ads.impl;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class dx extends DiffUtil.ItemCallback<fy> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(fy fyVar, fy fyVar2) {
        fy prevItem = fyVar;
        fy newItem = fyVar2;
        Intrinsics.checkNotNullParameter(prevItem, "prevItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return prevItem.a(newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(fy fyVar, fy fyVar2) {
        fy prevItem = fyVar;
        fy newItem = fyVar2;
        Intrinsics.checkNotNullParameter(prevItem, "prevItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return prevItem.a(newItem);
    }
}
