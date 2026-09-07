package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class iz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zm0 f9274a;
    private final xm0 b;

    public iz1(zm0 viewHolderManager) {
        Intrinsics.checkNotNullParameter(viewHolderManager, "viewHolderManager");
        this.f9274a = viewHolderManager;
        this.b = new xm0();
    }

    public final void a() {
        gb2 adUiElements;
        gb2 adUiElements2;
        q70 instreamAdView;
        q70 instreamAdView2;
        ym0 ym0VarA = this.f9274a.a();
        if (ym0VarA == null || (instreamAdView2 = ym0VarA.b()) == null) {
            adUiElements = null;
        } else {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(instreamAdView2, "instreamAdView");
            adUiElements = instreamAdView2.getAdUiElements();
        }
        TextView textViewK = adUiElements != null ? adUiElements.k() : null;
        if (textViewK != null) {
            textViewK.setVisibility(8);
        }
        ym0 ym0VarA2 = this.f9274a.a();
        if (ym0VarA2 == null || (instreamAdView = ym0VarA2.b()) == null) {
            adUiElements2 = null;
        } else {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
            adUiElements2 = instreamAdView.getAdUiElements();
        }
        View viewL = adUiElements2 != null ? adUiElements2.l() : null;
        if (viewL != null) {
            viewL.setVisibility(0);
            viewL.setEnabled(true);
        }
    }

    public final void a(long j, long j2) {
        gb2 adUiElements;
        q70 instreamAdView;
        ym0 ym0VarA = this.f9274a.a();
        if (ym0VarA == null || (instreamAdView = ym0VarA.b()) == null) {
            adUiElements = null;
        } else {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
            adUiElements = instreamAdView.getAdUiElements();
        }
        TextView textViewK = adUiElements != null ? adUiElements.k() : null;
        int i = ((int) ((j - j2) / ((long) 1000))) + 1;
        if (textViewK != null) {
            textViewK.setText(String.valueOf(i));
            textViewK.setVisibility(0);
        }
    }
}
