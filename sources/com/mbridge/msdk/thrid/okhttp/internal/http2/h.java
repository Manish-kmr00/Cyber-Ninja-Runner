package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.s;
import com.mbridge.msdk.thrid.okio.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;

/* JADX INFO: compiled from: Http2Reader.java */
/* JADX INFO: loaded from: classes7.dex */
final class h implements Closeable {
    static final Logger e = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.e f5546a;
    private final a b;
    private final boolean c;
    final d.a d;

    /* JADX INFO: compiled from: Http2Reader.java */
    interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list) throws IOException;

        void a(int i, long j);

        void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar);

        void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okio.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, com.mbridge.msdk.thrid.okio.e eVar, int i2) throws IOException;

        void a(boolean z, m mVar);
    }

    h(com.mbridge.msdk.thrid.okio.e eVar, boolean z) {
        this.f5546a = eVar;
        this.c = z;
        a aVar = new a(eVar);
        this.b = aVar;
        this.d = new d.a(4096, aVar);
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i3 = this.f5546a.readInt();
        int i4 = this.f5546a.readInt();
        int i5 = i - 8;
        com.mbridge.msdk.thrid.okhttp.internal.http2.b bVarA = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(i4);
        if (bVarA == null) {
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
        }
        com.mbridge.msdk.thrid.okio.f fVarB = com.mbridge.msdk.thrid.okio.f.e;
        if (i5 > 0) {
            fVarB = this.f5546a.b(i5);
        }
        bVar.a(i3, bVarA, fVarB);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short s = (b2 & 8) != 0 ? (short) (this.f5546a.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, s), s, b2, i2));
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.f5546a.readInt(), this.f5546a.readInt());
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.f5546a.readByte() & 255) : (short) 0;
        bVar.a(i2, this.f5546a.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i3 = this.f5546a.readInt();
        com.mbridge.msdk.thrid.okhttp.internal.http2.b bVarA = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(i3);
        if (bVarA == null) {
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
        }
        bVar.a(i2, bVarA);
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        m mVar = new m();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.f5546a.readShort() & UShort.MAX_VALUE;
            int i5 = this.f5546a.readInt();
            if (i4 == 2) {
                if (i5 != 0 && i5 != 1) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i4 == 3) {
                i4 = 4;
            } else if (i4 != 4) {
                if (i4 == 5 && (i5 < 16384 || i5 > 16777215)) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                }
            } else {
                if (i5 < 0) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i4 = 7;
            }
            mVar.a(i4, i5);
        }
        bVar.a(false, mVar);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = ((long) this.f5546a.readInt()) & 2147483647L;
        if (j == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(j));
        }
        bVar.a(i2, j);
    }

    public void a(b bVar) throws IOException {
        if (this.c) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.mbridge.msdk.thrid.okio.e eVar = this.f5546a;
        com.mbridge.msdk.thrid.okio.f fVar = e.f5541a;
        com.mbridge.msdk.thrid.okio.f fVarB = eVar.b(fVar.e());
        Logger logger = e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.mbridge.msdk.thrid.okhttp.internal.c.a("<< CONNECTION %s", fVarB.b()));
        }
        if (!fVar.equals(fVarB)) {
            throw e.b("Expected a connection header but was %s", fVarB.h());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5546a.close();
    }

    /* JADX INFO: compiled from: Http2Reader.java */
    static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.e f5547a;
        int b;
        byte c;
        int d;
        int e;
        short f;

        a(com.mbridge.msdk.thrid.okio.e eVar) {
            this.f5547a = eVar;
        }

        private void d() throws IOException {
            int i = this.d;
            int iA = h.a(this.f5547a);
            this.e = iA;
            this.b = iA;
            byte b = (byte) (this.f5547a.readByte() & 255);
            this.c = (byte) (this.f5547a.readByte() & 255);
            Logger logger = h.e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.d, this.b, b, this.c));
            }
            int i2 = this.f5547a.readInt() & Integer.MAX_VALUE;
            this.d = i2;
            if (b != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(b));
            }
            if (i2 != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            while (true) {
                int i = this.e;
                if (i != 0) {
                    long jB = this.f5547a.b(cVar, Math.min(j, i));
                    if (jB == -1) {
                        return -1L;
                    }
                    this.e = (int) (((long) this.e) - jB);
                    return jB;
                }
                this.f5547a.skip(this.f);
                this.f = (short) 0;
                if ((this.c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return this.f5547a.b();
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f5546a.e(9L);
            int iA = a(this.f5546a);
            if (iA >= 0 && iA <= 16384) {
                byte b2 = (byte) (this.f5546a.readByte() & 255);
                if (z && b2 != 4) {
                    throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(b2));
                }
                byte b3 = (byte) (this.f5546a.readByte() & 255);
                int i = this.f5546a.readInt() & Integer.MAX_VALUE;
                Logger logger = e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.a(true, i, iA, b2, b3));
                }
                switch (b2) {
                    case 0:
                        a(bVar, iA, b3, i);
                        return true;
                    case 1:
                        c(bVar, iA, b3, i);
                        return true;
                    case 2:
                        e(bVar, iA, b3, i);
                        return true;
                    case 3:
                        g(bVar, iA, b3, i);
                        return true;
                    case 4:
                        h(bVar, iA, b3, i);
                        return true;
                    case 5:
                        f(bVar, iA, b3, i);
                        return true;
                    case 6:
                        d(bVar, iA, b3, i);
                        return true;
                    case 7:
                        b(bVar, iA, b3, i);
                        return true;
                    case 8:
                        i(bVar, iA, b3, i);
                        return true;
                    default:
                        this.f5546a.skip(iA);
                        return true;
                }
            }
            throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
        } catch (IOException unused) {
            return false;
        }
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.b;
        aVar.e = i;
        aVar.b = i;
        aVar.f = s;
        aVar.c = b2;
        aVar.d = i2;
        this.d.f();
        return this.d.c();
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) == 0) {
            short s = (b2 & 8) != 0 ? (short) (this.f5546a.readByte() & 255) : (short) 0;
            bVar.a(z, i2, this.f5546a, a(i, b2, s));
            this.f5546a.skip(s);
            return;
        }
        throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void a(b bVar, int i) throws IOException {
        int i2 = this.f5546a.readInt();
        bVar.a(i, i2 & Integer.MAX_VALUE, (this.f5546a.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    static int a(com.mbridge.msdk.thrid.okio.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
