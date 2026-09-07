package com.unity3d.player;

import android.view.WindowManager;

/* JADX INFO: loaded from: classes9.dex */
final class Q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f8245a;
    final /* synthetic */ UnityPlayer b;

    Q0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.f8245a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.b.m_Window.getAttributes();
        attributes.screenBrightness = this.f8245a;
        this.b.m_Window.setAttributes(attributes);
    }
}
