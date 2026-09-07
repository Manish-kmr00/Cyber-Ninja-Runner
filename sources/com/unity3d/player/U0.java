package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* JADX INFO: loaded from: classes8.dex */
final class U0 extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8251a;

    private U0(UnityPlayer unityPlayer) {
        this.f8251a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        this.f8251a.nativeMuteMasterAudio(i == 1);
    }
}
