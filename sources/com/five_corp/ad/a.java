package com.five_corp.ad;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f1256a;

    public a(Window window) {
        this.f1256a = window;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        this.f1256a.getDecorView().setSystemUiVisibility(2822);
    }
}
