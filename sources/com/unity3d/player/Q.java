package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f8244a;
    final long b;

    public Q(long j, long j2) {
        this.f8244a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f8244a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}
