package com.unity3d.player;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.unity3d.player.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC3785b0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3794e0 f8266a;

    ViewTreeObserverOnGlobalLayoutListenerC3785b0(C3794e0 c3794e0) {
        this.f8266a = c3794e0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f8266a.reportSoftInputArea();
        this.f8266a.h.b();
    }
}
