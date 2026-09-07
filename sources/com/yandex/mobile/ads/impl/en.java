package com.yandex.mobile.ads.impl;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class en implements Comparable<en> {
    public final String b;
    public final long c;
    public final long d;
    public final boolean e;
    public final File f;
    public final long g;

    public final String toString() {
        return com.ironsource.b9.i.d + this.c + ", " + this.d + com.ironsource.b9.i.e;
    }

    @Override // java.lang.Comparable
    public final int compareTo(en enVar) {
        en enVar2 = enVar;
        if (!this.b.equals(enVar2.b)) {
            return this.b.compareTo(enVar2.b);
        }
        long j = this.c - enVar2.c;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public en(String str, long j, long j2, long j3, File file) {
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = file != null;
        this.f = file;
        this.g = j3;
    }
}
