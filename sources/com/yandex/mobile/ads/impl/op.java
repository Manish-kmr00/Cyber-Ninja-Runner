package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class op implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uc0 f9844a;
    private final dd0 b;
    private final aw c;

    public op(uc0 fullScreenCloseButtonListener, dd0 fullScreenHtmlWebViewAdapter, aw debugEventsReporter) {
        Intrinsics.checkNotNullParameter(fullScreenCloseButtonListener, "fullScreenCloseButtonListener");
        Intrinsics.checkNotNullParameter(fullScreenHtmlWebViewAdapter, "fullScreenHtmlWebViewAdapter");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        this.f9844a = fullScreenCloseButtonListener;
        this.b = fullScreenHtmlWebViewAdapter;
        this.c = debugEventsReporter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.a();
        this.f9844a.c();
        this.c.a(zv.c);
    }
}
