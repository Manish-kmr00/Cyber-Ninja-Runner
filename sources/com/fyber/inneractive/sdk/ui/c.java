package com.fyber.inneractive.sdk.ui;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifierLocal f2335a;

    public c(FyberAdIdentifierLocal fyberAdIdentifierLocal) {
        this.f2335a = fyberAdIdentifierLocal;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        FyberAdIdentifierLocal fyberAdIdentifierLocal = this.f2335a;
        fyberAdIdentifierLocal.q = this.f2335a.n.getWidth() + fyberAdIdentifierLocal.n.getWidth();
        FyberAdIdentifierLocal fyberAdIdentifierLocal2 = this.f2335a;
        IFyberAdIdentifier.Corner corner = fyberAdIdentifierLocal2.k;
        if (corner == IFyberAdIdentifier.Corner.TOP_LEFT || corner == IFyberAdIdentifier.Corner.BOTTOM_LEFT) {
            fyberAdIdentifierLocal2.q *= -1.0f;
        }
        fyberAdIdentifierLocal2.n.setTranslationX(fyberAdIdentifierLocal2.q);
        FyberAdIdentifierLocal fyberAdIdentifierLocal3 = this.f2335a;
        if (fyberAdIdentifierLocal3.o) {
            fyberAdIdentifierLocal3.a();
        }
    }
}
