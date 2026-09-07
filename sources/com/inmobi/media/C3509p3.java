package com.inmobi.media;

import java.io.File;

/* JADX INFO: renamed from: com.inmobi.media.p3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3509p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3397a;
    public final long[] b;
    public boolean c;
    public C3495o3 d;
    public final /* synthetic */ C3536r3 e;

    public C3509p3(C3536r3 c3536r3, String str) {
        this.e = c3536r3;
        this.f3397a = str;
        this.b = new long[c3536r3.h];
    }

    public final File a(int i) {
        return new File(this.e.f3414a, this.f3397a + "." + i);
    }

    public final File b(int i) {
        return new File(this.e.f3414a, this.f3397a + "." + i + ".tmp");
    }
}
