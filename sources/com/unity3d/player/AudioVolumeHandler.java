package com.unity3d.player;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class AudioVolumeHandler implements InterfaceC3825p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3827q f8203a;

    AudioVolumeHandler(Context context) {
        C3827q c3827q = new C3827q(context);
        this.f8203a = c3827q;
        c3827q.a(this);
    }

    public final void a() {
        this.f8203a.a();
        this.f8203a = null;
    }

    @Override // com.unity3d.player.InterfaceC3825p
    public final native void onAudioVolumeChanged(int i);
}
