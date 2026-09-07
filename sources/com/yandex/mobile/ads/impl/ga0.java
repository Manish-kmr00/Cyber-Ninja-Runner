package com.yandex.mobile.ads.impl;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ga0 extends DiffUtil.ItemCallback<fa0> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(fa0 fa0Var, fa0 fa0Var2) {
        fa0 oldItem = fa0Var;
        fa0 newItem = fa0Var2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(fa0 fa0Var, fa0 fa0Var2) {
        fa0 oldItem = fa0Var;
        fa0 newItem = fa0Var2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((oldItem instanceof k90) && (newItem instanceof k90)) {
            return Intrinsics.areEqual(((k90) oldItem).a(), ((k90) newItem).a());
        }
        ea0 ea0Var = ea0.f8778a;
        return Intrinsics.areEqual(oldItem, ea0Var) && Intrinsics.areEqual(newItem, ea0Var);
    }
}
