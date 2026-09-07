package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
class E {
    protected Runnable b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.unity3d.player.a.e f8213a = null;
    protected boolean c = true;

    protected E(Runnable runnable) {
        this.b = runnable;
    }

    protected void registerOnBackPressedCallback() {
        if (this.f8213a != null) {
            return;
        }
        this.f8213a = new D(this.b);
    }

    protected void unregisterOnBackPressedCallback() {
        this.f8213a = null;
    }
}
