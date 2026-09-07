package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes11.dex */
public final class ch2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f8610a;

    public ch2(TextView textView) {
        this.f8610a = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2 = this.f8610a;
        if (view2 != null) {
            view2.performClick();
        }
    }
}
