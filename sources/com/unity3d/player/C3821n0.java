package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
final class C3821n0 extends V0 {
    final /* synthetic */ int b;
    final /* synthetic */ C3828q0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3821n0(C3828q0 c3828q0, UnityPlayer unityPlayer, int i) {
        super(unityPlayer);
        this.c = c3828q0;
        this.b = i;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        if (UnityAccessibilityDelegate.onNodeSelected(this.b)) {
            this.c.f8297a.sendEventForVirtualViewId(this.b, 1);
        }
    }
}
