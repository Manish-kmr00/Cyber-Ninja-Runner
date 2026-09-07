package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3795e1 extends V0 {
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ UnityPlayerForActivityOrService e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3795e1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z, String str, int i) {
        super(unityPlayerForActivityOrService);
        this.e = unityPlayerForActivityOrService;
        this.b = z;
        this.c = str;
        this.d = i;
    }

    @Override // com.unity3d.player.V0
    public final void a() {
        if (this.b) {
            this.e.nativeSoftInputCanceled();
        } else {
            String str = this.c;
            if (str != null) {
                this.e.nativeSetInputString(str);
            }
        }
        if (this.d == 1) {
            this.e.nativeSoftInputClosed();
        }
    }
}
