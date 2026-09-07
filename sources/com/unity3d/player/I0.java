package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes12.dex */
final class I0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8223a;

    I0(UnityPlayer unityPlayer) {
        this.f8223a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f8223a.finish();
    }
}
