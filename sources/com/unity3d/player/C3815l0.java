package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3815l0 extends V0 {
    final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3815l0(UnityPlayer unityPlayer, int i) {
        super(unityPlayer);
        this.b = i;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        UnityAccessibilityDelegate.onNodeFocusChanged(this.b, true);
    }
}
