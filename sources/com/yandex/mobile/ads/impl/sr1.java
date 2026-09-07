package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g52 f10233a;
    private final j42 b;

    public final void a(View timerView, long j, long j2) {
        Intrinsics.checkNotNullParameter(timerView, "timerView");
        timerView.setVisibility(0);
        TextView textViewA = this.f10233a.a(timerView);
        if (textViewA != null) {
            this.b.getClass();
            j42.a(textViewA, j, j2);
        }
    }

    public /* synthetic */ sr1(h52 h52Var) {
        this(h52Var, new j42());
    }

    public sr1(h52 timerViewProvider, j42 textDelayViewController) {
        Intrinsics.checkNotNullParameter(timerViewProvider, "timerViewProvider");
        Intrinsics.checkNotNullParameter(textDelayViewController, "textDelayViewController");
        this.f10233a = timerViewProvider;
        this.b = textDelayViewController;
    }
}
