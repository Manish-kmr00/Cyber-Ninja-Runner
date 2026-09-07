package com.unity3d.player;

/* JADX INFO: loaded from: classes9.dex */
final class T0 implements IPermissionRequestCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8249a;
    final /* synthetic */ UnityPlayer b;

    public T0(UnityPlayer unityPlayer, long j) {
        this.b = unityPlayer;
        this.f8249a = j;
    }

    @Override // com.unity3d.player.IPermissionRequestCallbacks
    public final void onPermissionResult(String[] strArr, int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        if (length != 0) {
            if (length != 1) {
                B.Log(6, "Only a single permission request is supported");
                return;
            } else if (iArr[0] == 1) {
                z = true;
            }
        }
        if (this.f8249a == 0) {
            return;
        }
        this.b.invokeOnMainThread((V0) new S0(this, z));
    }
}
