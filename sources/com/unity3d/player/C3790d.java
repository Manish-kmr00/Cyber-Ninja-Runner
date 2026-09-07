package com.unity3d.player;

import android.window.OnBackInvokedCallback;

/* JADX INFO: renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3790d implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unity3d.player.a.e f8271a;

    C3790d(com.unity3d.player.a.e eVar) {
        this.f8271a = eVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = ((D) this.f8271a).f8210a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
