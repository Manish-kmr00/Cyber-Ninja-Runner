package com.unity3d.player;

/* JADX INFO: loaded from: classes3.dex */
final class x1 extends V0 {
    final /* synthetic */ UnityPlayerForGameActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x1(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        super(unityPlayerForGameActivity);
        this.b = unityPlayerForGameActivity;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.b.nativeUnityPlayerSetRunning(false);
    }
}
