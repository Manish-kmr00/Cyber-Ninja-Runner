package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes8.dex */
public final class mh0 implements Closeable {
    private static final Logger g = Logger.getLogger(dh0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f9639a;
    private final boolean b;
    private final Buffer c;
    private int d;
    private boolean e;
    private final ig0.b f;

    public mh0(BufferedSink sink, boolean z) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f9639a = sink;
        this.b = z;
        Buffer buffer = new Buffer();
        this.c = buffer;
        this.d = 16384;
        this.f = new ig0.b(buffer);
    }

    public final synchronized void a(sx1 peerSettings) throws IOException {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        if (this.e) {
            throw new IOException("closed");
        }
        this.d = peerSettings.b(this.d);
        if (peerSettings.a() != -1) {
            this.f.b(peerSettings.a());
        }
        a(0, 0, 4, 1);
        this.f9639a.flush();
    }

    public final synchronized void flush() throws IOException {
        if (!this.e) {
            this.f9639a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a() throws IOException {
        if (!this.e) {
            if (this.b) {
                Logger logger = g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(y82.a(">> CONNECTION " + dh0.b.hex(), new Object[0]));
                }
                this.f9639a.write(dh0.b);
                this.f9639a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public final int b() {
        return this.d;
    }

    public final synchronized void b(sx1 settings) throws IOException {
        int i;
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (!this.e) {
            int i2 = 0;
            a(0, settings.d() * 6, 4, 0);
            while (i2 < 10) {
                if (settings.c(i2)) {
                    if (i2 != 4) {
                        i = i2 != 7 ? i2 : 4;
                    } else {
                        i = 3;
                    }
                    this.f9639a.writeShort(i);
                    this.f9639a.writeInt(settings.a(i2));
                }
                i2++;
            }
            this.f9639a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.e = true;
        this.f9639a.close();
    }

    public final synchronized void a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (!this.e) {
            a(i, i2, 0, z ? 1 : 0);
            if (i2 > 0) {
                BufferedSink bufferedSink = this.f9639a;
                Intrinsics.checkNotNull(buffer);
                bufferedSink.write(buffer, i2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i, q50 errorCode, byte[] debugData) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (!this.e) {
            if (errorCode.a() != -1) {
                a(0, debugData.length + 8, 7, 0);
                this.f9639a.writeInt(i);
                this.f9639a.writeInt(errorCode.a());
                if (!(debugData.length == 0)) {
                    this.f9639a.write(debugData);
                }
                this.f9639a.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i, ArrayList headerBlock, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (!this.e) {
            this.f.a(headerBlock);
            long size = this.c.size();
            long jMin = Math.min(this.d, size);
            int i2 = size == jMin ? 4 : 0;
            if (z) {
                i2 |= 1;
            }
            a(i, (int) jMin, 1, i2);
            this.f9639a.write(this.c, jMin);
            if (size > jMin) {
                long j = size - jMin;
                while (j > 0) {
                    long jMin2 = Math.min(this.d, j);
                    j -= jMin2;
                    a(i, (int) jMin2, 9, j == 0 ? 4 : 0);
                    this.f9639a.write(this.c, jMin2);
                }
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i, int i2, boolean z) throws IOException {
        if (!this.e) {
            a(0, 8, 6, z ? 1 : 0);
            this.f9639a.writeInt(i);
            this.f9639a.writeInt(i2);
            this.f9639a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i, q50 errorCode) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.e) {
            if (errorCode.a() != -1) {
                a(i, 4, 3, 0);
                this.f9639a.writeInt(errorCode.a());
                this.f9639a.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i, long j) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i, 4, 8, 0);
            this.f9639a.writeInt((int) j);
            this.f9639a.flush();
        } else {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
    }

    public final void a(int i, int i2, int i3, int i4) throws IOException {
        Logger logger = g;
        if (logger.isLoggable(Level.FINE)) {
            dh0.f8694a.getClass();
            logger.fine(dh0.a(false, i, i2, i3, i4));
        }
        int i5 = this.d;
        if (i2 > i5) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + i5 + ": " + i2).toString());
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            y82.a(this.f9639a, i2);
            this.f9639a.writeByte(i3 & 255);
            this.f9639a.writeByte(i4 & 255);
            this.f9639a.writeInt(i & Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException(("reserved bit set: " + i).toString());
    }
}
