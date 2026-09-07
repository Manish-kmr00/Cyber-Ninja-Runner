package com.inmobi.media;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: renamed from: com.inmobi.media.q3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3523q3 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream[] f3403a;

    public C3523q3(InputStream[] inputStreamArr) {
        this.f3403a = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (InputStream inputStream : this.f3403a) {
            Dc.a(inputStream);
        }
    }
}
