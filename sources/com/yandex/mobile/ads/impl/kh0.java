package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class kh0 implements Closeable {
    private static final Logger e;
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f9419a;
    private final boolean b;
    private final b c;
    private final ig0.a d;

    public static final class a {
        public static int a(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }

        public static Logger a() {
            return kh0.e;
        }
    }

    public interface c {
        void a(int i, int i2, BufferedSource bufferedSource, boolean z) throws IOException;

        void a(int i, int i2, boolean z);

        void a(int i, long j);

        void a(int i, q50 q50Var);

        void a(int i, q50 q50Var, ByteString byteString);

        void a(int i, List list) throws IOException;

        void a(sx1 sx1Var);

        void a(boolean z, int i, List list);
    }

    static {
        Logger logger = Logger.getLogger(dh0.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        e = logger;
    }

    public kh0(BufferedSource source, boolean z) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f9419a = source;
        this.b = z;
        b bVar = new b(source);
        this.c = bVar;
        this.d = new ig0.a(bVar);
    }

    public final boolean a(boolean z, c handler) throws IOException {
        int i;
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.f9419a.require(9L);
            int iA = y82.a(this.f9419a);
            if (iA > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iA);
            }
            int iA2 = y82.a(this.f9419a.readByte());
            int iA3 = y82.a(this.f9419a.readByte());
            int i2 = this.f9419a.readInt() & Integer.MAX_VALUE;
            Logger logger = e;
            if (logger.isLoggable(Level.FINE)) {
                dh0.f8694a.getClass();
                logger.fine(dh0.a(true, i2, iA, iA2, iA3));
            }
            if (z && iA2 != 4) {
                dh0.f8694a.getClass();
                throw new IOException("Expected a SETTINGS frame but was " + dh0.a(iA2));
            }
            switch (iA2) {
                case 0:
                    if (i2 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                    }
                    boolean z2 = (iA3 & 1) != 0;
                    if ((iA3 & 32) != 0) {
                        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                    }
                    i = (iA3 & 8) != 0 ? this.f9419a.readByte() & 255 : 0;
                    handler.a(i2, a.a(iA, iA3, i), this.f9419a, z2);
                    this.f9419a.skip(i);
                    return true;
                case 1:
                    if (i2 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    }
                    boolean z3 = (iA3 & 1) != 0;
                    i = (iA3 & 8) != 0 ? this.f9419a.readByte() & 255 : 0;
                    if ((iA3 & 32) != 0) {
                        this.f9419a.readInt();
                        this.f9419a.readByte();
                        handler.getClass();
                        iA -= 5;
                    }
                    this.c.b(a.a(iA, iA3, i));
                    b bVar = this.c;
                    bVar.c(bVar.a());
                    this.c.d(i);
                    this.c.a(iA3);
                    this.c.e(i2);
                    this.d.c();
                    handler.a(z3, i2, this.d.a());
                    return true;
                case 2:
                    b(handler, iA, i2);
                    return true;
                case 3:
                    c(handler, iA, i2);
                    return true;
                case 4:
                    b(handler, iA, iA3, i2);
                    return true;
                case 5:
                    if (i2 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    }
                    i = (iA3 & 8) != 0 ? this.f9419a.readByte() & 255 : 0;
                    int i3 = this.f9419a.readInt() & Integer.MAX_VALUE;
                    this.c.b(a.a(iA - 4, iA3, i));
                    b bVar2 = this.c;
                    bVar2.c(bVar2.a());
                    this.c.d(i);
                    this.c.a(iA3);
                    this.c.e(i2);
                    this.d.c();
                    handler.a(i3, this.d.a());
                    return true;
                case 6:
                    a(handler, iA, iA3, i2);
                    return true;
                case 7:
                    a(handler, iA, i2);
                    return true;
                case 8:
                    d(handler, iA, i2);
                    return true;
                default:
                    this.f9419a.skip(iA);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    private final void b(c cVar, int i, int i2) throws IOException {
        if (i != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
        if (i2 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        this.f9419a.readInt();
        this.f9419a.readByte();
        byte[] bArr = y82.f10712a;
        cVar.getClass();
    }

    private final void c(c cVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i2 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i3 = this.f9419a.readInt();
        q50.c.getClass();
        q50 q50VarA = q50.a.a(i3);
        if (q50VarA == null) {
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + i3);
        }
        cVar.a(i2, q50VarA);
    }

    private final void d(c cVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
        }
        long jA = y82.a(this.f9419a.readInt());
        if (jA == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.a(i2, jA);
    }

    public final void a(c handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.b) {
            if (!a(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.f9419a;
        ByteString byteString = dh0.b;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger = e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(y82.a("<< CONNECTION " + byteString2.hex(), new Object[0]));
        }
        if (Intrinsics.areEqual(byteString, byteString2)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + byteString2.utf8());
    }

    private final void b(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i2 & 1) != 0) {
            if (i == 0) {
                cVar.getClass();
                return;
            }
            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
        }
        if (i % 6 == 0) {
            sx1 sx1Var = new sx1();
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, i), 6);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int iA = y82.a(this.f9419a.readShort());
                    int i4 = this.f9419a.readInt();
                    if (iA != 2) {
                        if (iA == 3) {
                            iA = 4;
                        } else if (iA != 4) {
                            if (iA == 5 && (i4 < 16384 || i4 > 16777215)) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i4);
                            }
                        } else {
                            if (i4 < 0) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                            }
                            iA = 7;
                        }
                    } else if (i4 != 0 && i4 != 1) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    sx1Var.a(iA, i4);
                    if (first != last) {
                        first += step;
                    }
                }
            }
            cVar.a(sx1Var);
            return;
        }
        throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
    }

    private final void a(c cVar, int i, int i2) throws IOException {
        if (i < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i);
        }
        if (i2 == 0) {
            int i3 = this.f9419a.readInt();
            int i4 = this.f9419a.readInt();
            int i5 = i - 8;
            q50.c.getClass();
            q50 q50VarA = q50.a.a(i4);
            if (q50VarA != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i5 > 0) {
                    byteString = this.f9419a.readByteString(i5);
                }
                cVar.a(i3, q50VarA, byteString);
                return;
            }
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i4);
        }
        throw new IOException("TYPE_GOAWAY streamId != 0");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9419a.close();
    }

    public static final class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f9420a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;

        public b(BufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f9420a = source;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (true) {
                int i = this.e;
                if (i != 0) {
                    long j2 = this.f9420a.read(sink, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.e -= (int) j2;
                    return j2;
                }
                this.f9420a.skip(this.f);
                this.f = 0;
                if ((this.c & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        public final void c(int i) {
            this.b = i;
        }

        public final void e(int i) {
            this.d = i;
        }

        public final int a() {
            return this.e;
        }

        public final void d(int i) {
            this.f = i;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return this.f9420a.getTimeout();
        }

        private final void b() throws IOException {
            int i = this.d;
            int iA = y82.a(this.f9420a);
            this.e = iA;
            this.b = iA;
            int iA2 = y82.a(this.f9420a.readByte());
            this.c = y82.a(this.f9420a.readByte());
            int i2 = kh0.f;
            if (a.a().isLoggable(Level.FINE)) {
                Logger loggerA = a.a();
                dh0 dh0Var = dh0.f8694a;
                int i3 = this.d;
                int i4 = this.b;
                int i5 = this.c;
                dh0Var.getClass();
                loggerA.fine(dh0.a(true, i3, i4, iA2, i5));
            }
            int i6 = this.f9420a.readInt() & Integer.MAX_VALUE;
            this.d = i6;
            if (iA2 != 9) {
                throw new IOException(iA2 + " != TYPE_CONTINUATION");
            }
            if (i6 != i) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public final void a(int i) {
            this.c = i;
        }

        public final void b(int i) {
            this.e = i;
        }
    }

    private final void a(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException("TYPE_PING length != 8: " + i);
        }
        if (i3 == 0) {
            cVar.a(this.f9419a.readInt(), this.f9419a.readInt(), (i2 & 1) != 0);
            return;
        }
        throw new IOException("TYPE_PING streamId != 0");
    }
}
