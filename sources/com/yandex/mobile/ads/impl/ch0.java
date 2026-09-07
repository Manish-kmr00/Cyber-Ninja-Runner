package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes10.dex */
public final class ch0 implements z50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final be1 f8605a;
    private final tn1 b;
    private final BufferedSource c;
    private final BufferedSink d;
    private int e;
    private final of0 f;
    private nf0 g;

    private abstract class a implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f8606a;
        private boolean b;

        @Override // okio.Source
        public long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return ch0.this.c.read(sink, j);
            } catch (IOException e) {
                ch0.this.c().j();
                b();
                throw e;
            }
        }

        protected final void c() {
            this.b = true;
        }

        public a() {
            this.f8606a = new ForwardingTimeout(ch0.this.c.getTimeout());
        }

        protected final boolean a() {
            return this.b;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return this.f8606a;
        }

        public final void b() {
            if (ch0.this.e == 6) {
                return;
            }
            if (ch0.this.e != 5) {
                throw new IllegalStateException("state: " + ch0.this.e);
            }
            ch0.a(ch0.this, this.f8606a);
            ch0.this.e = 6;
        }
    }

    public ch0(be1 be1Var, tn1 connection, BufferedSource source, BufferedSink sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f8605a = be1Var;
        this.b = connection;
        this.c = source;
        this.d = sink;
        this.f = new of0(source);
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void cancel() {
        this.b.a();
    }

    public static final void a(ch0 ch0Var, ForwardingTimeout forwardingTimeout) {
        ch0Var.getClass();
        Timeout delegate = forwardingTimeout.getDelegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final tn1 c() {
        return this.b;
    }

    public final void c(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long jA = y82.a(response);
        if (jA == -1) {
            return;
        }
        Source sourceA = a(jA);
        y82.a(sourceA, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        ((d) sourceA).close();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void b() throws IOException {
        this.d.flush();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final long b(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!uh0.a(response)) {
            return 0L;
        }
        if (StringsKt.equals("chunked", oq1.a(response, HttpHeaders.TRANSFER_ENCODING), true)) {
            return -1L;
        }
        return y82.a(response);
    }

    private final class e implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f8608a;
        private boolean b;

        @Override // okio.Sink
        public final void write(Buffer source, long j) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.b) {
                throw new IllegalStateException("closed".toString());
            }
            long size = source.size();
            byte[] bArr = y82.f10712a;
            if (j < 0 || 0 > size || size < j) {
                throw new ArrayIndexOutOfBoundsException();
            }
            ch0.this.d.write(source, j);
        }

        public e() {
            this.f8608a = new ForwardingTimeout(ch0.this.d.getTimeout());
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return this.f8608a;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            if (this.b) {
                return;
            }
            ch0.this.d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            ch0.a(ch0.this, this.f8608a);
            ch0.this.e = 3;
        }
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final Sink a(op1 request, long j) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.a() != null) {
            request.a().getClass();
        }
        if (StringsKt.equals("chunked", request.a(HttpHeaders.TRANSFER_ENCODING), true)) {
            return d();
        }
        if (j != -1) {
            return e();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    private final Sink d() {
        int i = this.e;
        if (i == 1) {
            this.e = 2;
            return new b();
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    private final Sink e() {
        int i = this.e;
        if (i == 1) {
            this.e = 2;
            return new e();
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    private final class b implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f8607a;
        private boolean b;

        @Override // okio.Sink
        public final void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.b) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            ch0.this.d.writeHexadecimalUnsignedLong(j);
            ch0.this.d.writeUtf8("\r\n");
            ch0.this.d.write(source, j);
            ch0.this.d.writeUtf8("\r\n");
        }

        public b() {
            this.f8607a = new ForwardingTimeout(ch0.this.d.getTimeout());
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return this.f8607a;
        }

        @Override // okio.Sink, java.io.Flushable
        public final synchronized void flush() {
            if (this.b) {
                return;
            }
            ch0.this.d.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            ch0.this.d.writeUtf8("0\r\n\r\n");
            ch0.a(ch0.this, this.f8607a);
            ch0.this.e = 3;
        }
    }

    private final Source f() {
        int i = this.e;
        if (i == 4) {
            this.e = 5;
            this.b.j();
            return new f(this);
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    private final class d extends a {
        private long d;

        @Override // com.yandex.mobile.ads.impl.ch0.a, okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.d;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(sink, Math.min(j2, j));
            if (j3 == -1) {
                ch0.this.c().j();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j4 = this.d - j3;
            this.d = j4;
            if (j4 == 0) {
                b();
            }
            return j3;
        }

        public d(long j) {
            super();
            this.d = j;
            if (j == 0) {
                b();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (a()) {
                return;
            }
            if (this.d != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                byte[] bArr = y82.f10712a;
                Intrinsics.checkNotNullParameter(this, "<this>");
                Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
                try {
                    if (!y82.a(this, 100, timeUnit)) {
                        ch0.this.c().j();
                        b();
                    }
                } catch (IOException unused) {
                }
            }
            c();
        }
    }

    private final class c extends a {
        private final di0 d;
        private long e;
        private boolean f;
        final /* synthetic */ ch0 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ch0 ch0Var, di0 url) {
            super();
            Intrinsics.checkNotNullParameter(url, "url");
            this.g = ch0Var;
            this.d = url;
            this.e = -1L;
            this.f = true;
        }

        @Override // com.yandex.mobile.ads.impl.ch0.a, okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f) {
                return -1L;
            }
            long j2 = this.e;
            if (j2 == 0 || j2 == -1) {
                d();
                if (!this.f) {
                    return -1L;
                }
            }
            long j3 = super.read(sink, Math.min(j, this.e));
            if (j3 != -1) {
                this.e -= j3;
                return j3;
            }
            this.g.c().j();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }

        private final void d() throws IOException {
            if (this.e != -1) {
                this.g.c.readUtf8LineStrict();
            }
            try {
                this.e = this.g.c.readHexadecimalUnsignedLong();
                String string = StringsKt.trim((CharSequence) this.g.c.readUtf8LineStrict()).toString();
                if (this.e < 0 || (string.length() > 0 && !StringsKt.startsWith$default(string, ";", false, 2, (Object) null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + string + "\"");
                }
                if (this.e == 0) {
                    this.f = false;
                    ch0 ch0Var = this.g;
                    ch0Var.g = ch0Var.f.a();
                    be1 be1Var = this.g.f8605a;
                    Intrinsics.checkNotNull(be1Var);
                    ns nsVarH = be1Var.h();
                    di0 di0Var = this.d;
                    nf0 nf0Var = this.g.g;
                    Intrinsics.checkNotNull(nf0Var);
                    uh0.a(nsVarH, di0Var, nf0Var);
                    b();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (a()) {
                return;
            }
            if (this.f) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                byte[] bArr = y82.f10712a;
                Intrinsics.checkNotNullParameter(this, "<this>");
                Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
                try {
                    if (!y82.a(this, 100, timeUnit)) {
                        this.g.c().j();
                        b();
                    }
                } catch (IOException unused) {
                }
            }
            c();
        }
    }

    private final class f extends a {
        private boolean d;

        @Override // com.yandex.mobile.ads.impl.ch0.a, okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.d) {
                return -1L;
            }
            long j2 = super.read(sink, j);
            if (j2 != -1) {
                return j2;
            }
            this.d = true;
            b();
            return -1L;
        }

        public f(ch0 ch0Var) {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (a()) {
                return;
            }
            if (!this.d) {
                b();
            }
            c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void a() {
        this.d.flush();
    }

    private final Source a(di0 di0Var) {
        int i = this.e;
        if (i == 4) {
            this.e = 5;
            return new c(this, di0Var);
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    private final Source a(long j) {
        int i = this.e;
        if (i == 4) {
            this.e = 5;
            return new d(j);
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final Source a(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!uh0.a(response)) {
            return a(0L);
        }
        if (StringsKt.equals("chunked", oq1.a(response, HttpHeaders.TRANSFER_ENCODING), true)) {
            return a(response.o().g());
        }
        long jA = y82.a(response);
        if (jA != -1) {
            return a(jA);
        }
        return f();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final oq1.a a(boolean z) {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException(("state: " + i).toString());
        }
        try {
            m22 m22VarA = m22.a.a(this.f.b());
            oq1.a aVarA = new oq1.a().a(m22VarA.f9592a).a(m22VarA.b).a(m22VarA.c).a(this.f.a());
            if (z && m22VarA.b == 100) {
                return null;
            }
            if (m22VarA.b == 100) {
                this.e = 3;
                return aVarA;
            }
            this.e = 4;
            return aVarA;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + this.b.k().a().k().j(), e2);
        }
    }

    public final void a(nf0 headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        int i = this.e;
        if (i == 0) {
            this.d.writeUtf8(requestLine).writeUtf8("\r\n");
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.d.writeUtf8(headers.a(i2)).writeUtf8(": ").writeUtf8(headers.b(i2)).writeUtf8("\r\n");
            }
            this.d.writeUtf8("\r\n");
            this.e = 1;
            return;
        }
        throw new IllegalStateException(("state: " + i).toString());
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void a(op1 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Proxy.Type proxyType = this.b.k().b().type();
        Intrinsics.checkNotNullExpressionValue(proxyType, "type(...)");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.f());
        sb.append(' ');
        if (!request.e() && proxyType == Proxy.Type.HTTP) {
            sb.append(request.g());
        } else {
            sb.append(vp1.a(request.g()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        a(request.d(), string);
    }
}
