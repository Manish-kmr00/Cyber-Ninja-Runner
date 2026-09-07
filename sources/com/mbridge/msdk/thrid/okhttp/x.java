package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x {

    /* JADX INFO: compiled from: RequestBody.java */
    static class a extends x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5583a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ int c;

        a(s sVar, int i, byte[] bArr, int i2) {
            this.f5583a = i;
            this.b = bArr;
            this.c = i2;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.x
        public long a() {
            return this.f5583a;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.x
        @Nullable
        public s b() {
            return null;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.x
        public void a(com.mbridge.msdk.thrid.okio.d dVar) throws IOException {
            dVar.write(this.b, this.c, this.f5583a);
        }
    }

    public static x a(@Nullable s sVar, byte[] bArr) {
        return a(sVar, bArr, 0, bArr.length);
    }

    public abstract long a() throws IOException;

    public abstract void a(com.mbridge.msdk.thrid.okio.d dVar) throws IOException;

    @Nullable
    public abstract s b();

    public static x a(@Nullable s sVar, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(bArr.length, i, i2);
        return new a(sVar, i2, bArr, i);
    }
}
