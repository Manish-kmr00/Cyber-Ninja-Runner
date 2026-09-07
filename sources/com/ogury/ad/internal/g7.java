package com.ogury.ad.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7307a;

    public g7(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f7307a = ((ViewGroup) decorView).getChildAt(0);
    }
}
