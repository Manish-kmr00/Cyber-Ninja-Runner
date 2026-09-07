package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3804h1 extends V0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ UnityPlayerForActivityOrService c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3804h1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        super(unityPlayerForActivityOrService);
        this.c = unityPlayerForActivityOrService;
        this.b = z;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.c.nativeSetKeyboardIsVisible(this.b);
    }
}
