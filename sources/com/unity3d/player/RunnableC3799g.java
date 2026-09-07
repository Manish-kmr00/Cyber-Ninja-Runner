package com.unity3d.player;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class RunnableC3799g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set f8275a;
    private String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;

    RunnableC3799g(Set set, String str, int i, long j, long j2, int i2, int i3) {
        this.f8275a = set;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = j2;
        this.f = i2;
        this.g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f8275a.iterator();
        while (it.hasNext()) {
            ((IAssetPackManagerDownloadStatusCallback) it.next()).onStatusUpdate(this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }
}
