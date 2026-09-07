package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import android.os.SystemClock;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f2170a;
    public RandomAccessFile b;
    public Uri c;
    public long d;
    public boolean e;

    public s(m mVar) {
        this.f2170a = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) throws r {
        try {
            this.c = kVar.f2163a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(kVar.f2163a.getPath(), "r");
            this.b = randomAccessFile;
            randomAccessFile.seek(kVar.c);
            long length = kVar.d;
            if (length == -1) {
                length = this.b.length() - kVar.c;
            }
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            m mVar = this.f2170a;
            if (mVar != null) {
                synchronized (mVar) {
                    if (mVar.b == 0) {
                        mVar.c = SystemClock.elapsedRealtime();
                    }
                    mVar.b++;
                }
            }
            return this.d;
        } catch (IOException e) {
            throw new r(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        this.c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.b = null;
                if (this.e) {
                    this.e = false;
                    m mVar = this.f2170a;
                    if (mVar != null) {
                        mVar.a();
                    }
                }
            } catch (IOException e) {
                throw new r(e);
            }
        } catch (Throwable th) {
            this.b = null;
            if (this.e) {
                this.e = false;
                m mVar2 = this.f2170a;
                if (mVar2 != null) {
                    mVar2.a();
                }
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws r {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.b.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                long j2 = i3;
                this.d -= j2;
                m mVar = this.f2170a;
                if (mVar != null) {
                    synchronized (mVar) {
                        mVar.d += j2;
                    }
                }
            }
            return i3;
        } catch (IOException e) {
            throw new r(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.c;
    }
}
