package com.inmobi.media;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class Q7 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f3174a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q7(FrameLayout view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3174a = view;
    }
}
