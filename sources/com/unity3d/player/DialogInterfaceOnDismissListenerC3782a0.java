package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class DialogInterfaceOnDismissListenerC3782a0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3794e0 f8264a;

    DialogInterfaceOnDismissListenerC3782a0(C3794e0 c3794e0) {
        this.f8264a = c3794e0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f8264a.invokeOnClose();
    }
}
