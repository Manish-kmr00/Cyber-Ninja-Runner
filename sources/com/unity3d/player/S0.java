package com.unity3d.player;

/* JADX INFO: loaded from: classes9.dex */
final class S0 extends V0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ T0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    S0(T0 t0, boolean z) {
        super(t0.b);
        this.c = t0;
        this.b = z;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        UnityPlayer.permissionResponseToNative(this.c.f8249a, this.b);
    }
}
