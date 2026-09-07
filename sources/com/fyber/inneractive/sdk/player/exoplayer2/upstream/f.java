package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.SystemClock;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f2160a;
    public final m b;
    public Uri c;
    public AssetFileDescriptor d;
    public FileInputStream e;
    public long f;
    public boolean g;

    public f(Context context, m mVar) {
        this.f2160a = context.getContentResolver();
        this.b = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) throws C3167e {
        try {
            Uri uri = kVar.f2163a;
            this.c = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f2160a.openAssetFileDescriptor(uri, "r");
            this.d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            if (this.e.skip(kVar.c + startOffset) - startOffset != kVar.c) {
                throw new EOFException();
            }
            long j = kVar.d;
            if (j != -1) {
                this.f = j;
            } else {
                long length = this.d.getLength();
                this.f = length;
                if (length == -1) {
                    long jAvailable = this.e.available();
                    this.f = jAvailable;
                    if (jAvailable == 0) {
                        this.f = -1L;
                    }
                }
            }
            this.g = true;
            m mVar = this.b;
            if (mVar != null) {
                synchronized (mVar) {
                    if (mVar.b == 0) {
                        mVar.c = SystemClock.elapsedRealtime();
                    }
                    mVar.b++;
                }
            }
            return this.f;
        } catch (IOException e) {
            throw new C3167e(e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003d */
    /* JADX WARN: Bottom block not found for handler: all -> 0x005f */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r4 = this;
            r0 = 0
            r4.c = r0
            r1 = 0
            java.io.FileInputStream r2 = r4.e     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
        Lb:
            r4.e = r0
            android.content.res.AssetFileDescriptor r2 = r4.d     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
        L14:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L23
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.m r0 = r4.b
            if (r0 == 0) goto L23
            r0.a()
        L23:
            return
        L24:
            r2 = move-exception
            goto L2d
        L26:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e     // Catch: java.lang.Throwable -> L24
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L24
            throw r3     // Catch: java.lang.Throwable -> L24
        L2d:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L3c
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.m r0 = r4.b
            if (r0 == 0) goto L3c
            r0.a()
        L3c:
            throw r2
        L3d:
            r2 = move-exception
            goto L46
        L3f:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            throw r3     // Catch: java.lang.Throwable -> L3d
        L46:
            r4.e = r0
            android.content.res.AssetFileDescriptor r3 = r4.d     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            if (r3 == 0) goto L4f
            r3.close()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
        L4f:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L5e
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.m r0 = r4.b
            if (r0 == 0) goto L5e
            r0.a()
        L5e:
            throw r2
        L5f:
            r2 = move-exception
            goto L68
        L61:
            r2 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.e r3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.e     // Catch: java.lang.Throwable -> L5f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L5f
            throw r3     // Catch: java.lang.Throwable -> L5f
        L68:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L77
            r4.g = r1
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.m r0 = r4.b
            if (r0 == 0) goto L77
            r0.a()
        L77:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.f.close():void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws C3167e {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new C3167e(e);
            }
        }
        int i3 = this.e.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new C3167e(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - ((long) i3);
        }
        m mVar = this.b;
        if (mVar != null) {
            synchronized (mVar) {
                mVar.d += (long) i3;
            }
        }
        return i3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.c;
    }
}
