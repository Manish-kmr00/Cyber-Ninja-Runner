package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3798f1 extends V0 {
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ UnityPlayerForActivityOrService d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3798f1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        super(unityPlayerForActivityOrService);
        this.d = unityPlayerForActivityOrService;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        this.d.nativeSetInputSelection(this.b, this.c);
    }
}
