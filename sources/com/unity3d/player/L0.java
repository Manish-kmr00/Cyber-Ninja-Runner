package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class L0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PermissionRequest f8232a;
    final /* synthetic */ String[] b;
    final /* synthetic */ int[] c;

    L0(PermissionRequest permissionRequest, String[] strArr, int[] iArr) {
        this.f8232a = permissionRequest;
        this.b = strArr;
        this.c = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8232a.permissionResponse(this.b, this.c);
    }
}
