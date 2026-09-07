package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
final class C3824o0 extends V0 {
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ C3828q0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3824o0(C3828q0 c3828q0, UnityPlayer unityPlayer, int i, int i2) {
        super(unityPlayer);
        this.d = c3828q0;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        if (this.b == 4096) {
            UnityAccessibilityDelegate.onNodeIncremented(this.c);
        } else {
            UnityAccessibilityDelegate.onNodeDecremented(this.c);
        }
        this.d.f8297a.sendEventForVirtualViewId(this.c, 4);
    }
}
