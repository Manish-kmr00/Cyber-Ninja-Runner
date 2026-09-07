package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class DialogInterfaceOnCancelListenerC3788c0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3794e0 f8269a;

    DialogInterfaceOnCancelListenerC3788c0(C3794e0 c3794e0) {
        this.f8269a = c3794e0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        H h = this.f8269a.f;
        if (h != null) {
            ((t1) h).a();
        }
    }
}
