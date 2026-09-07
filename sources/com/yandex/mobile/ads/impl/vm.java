package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class vm implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rm f10492a;
    private final qv b;
    private final h42 c;
    private final qv d;
    private final dn e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private Uri i;
    private uv j;
    private uv k;
    private qv l;
    private long m;
    private long n;
    private long o;
    private en p;
    private boolean q;
    private boolean r;
    private long s;

    public static final class a implements qv.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private rm f10493a;
        private eb0.b b = new eb0.b();
        private dn c = dn.f8714a;
        private qv.a d;

        @Override // com.yandex.mobile.ads.impl.qv.a
        public final qv a() {
            qv.a aVar = this.d;
            qv qvVarA = aVar != null ? aVar.a() : null;
            rm rmVar = this.f10493a;
            rmVar.getClass();
            um umVarA = qvVarA != null ? new um.b().a(rmVar).a() : null;
            this.b.getClass();
            return new vm(rmVar, qvVarA, new eb0(), umVarA, this.c, 0, 0);
        }

        public final a a(rm rmVar) {
            this.f10493a = rmVar;
            return this;
        }

        public final a a(lz.a aVar) {
            this.d = aVar;
            return this;
        }

        public final vm b() {
            qv.a aVar = this.d;
            qv qvVarA = aVar != null ? aVar.a() : null;
            rm rmVar = this.f10493a;
            rmVar.getClass();
            um umVarA = qvVarA != null ? new um.b().a(rmVar).a() : null;
            this.b.getClass();
            return new vm(rmVar, qvVarA, new eb0(), umVarA, this.c, 1, -1000);
        }
    }

    private vm(rm rmVar, qv qvVar, eb0 eb0Var, um umVar, dn dnVar, int i, int i2) {
        this.f10492a = rmVar;
        this.b = eb0Var;
        this.e = dnVar == null ? dn.f8714a : dnVar;
        this.f = (i & 1) != 0;
        this.g = false;
        this.h = false;
        if (qvVar != null) {
            this.d = qvVar;
            this.c = umVar != null ? new h42(qvVar, umVar) : null;
        } else {
            this.d = ih1.f9220a;
            this.c = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        this.b.a(w62Var);
        this.d.a(w62Var);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        return !h() ? this.d.getResponseHeaders() : Collections.emptyMap();
    }

    public final rm f() {
        return this.f10492a;
    }

    public final dn g() {
        return this.e;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws IOException {
        try {
            String strA = this.e.a(uvVar);
            uv uvVarA = uvVar.a().a(strA).a();
            this.j = uvVarA;
            rm rmVar = this.f10492a;
            Uri uri = uvVarA.f10424a;
            String strC = rmVar.b(strA).c();
            Uri uri2 = strC == null ? null : Uri.parse(strC);
            if (uri2 != null) {
                uri = uri2;
            }
            this.i = uri;
            this.n = uvVar.f;
            boolean z = (this.g && this.q) || (this.h && uvVar.g == -1);
            this.r = z;
            if (z) {
                this.o = -1L;
            } else {
                long jB = this.f10492a.b(strA).b();
                this.o = jB;
                if (jB != -1) {
                    long j = jB - uvVar.f;
                    this.o = j;
                    if (j < 0) {
                        throw new rv(2008);
                    }
                }
            }
            long jMin = uvVar.g;
            if (jMin != -1) {
                long j2 = this.o;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.o = jMin;
            }
            long j3 = this.o;
            if (j3 > 0 || j3 == -1) {
                a(uvVarA, false);
            }
            long j4 = uvVar.g;
            return j4 != -1 ? j4 : this.o;
        } catch (Throwable th) {
            if (h() || (th instanceof rm.a)) {
                this.q = true;
            }
            throw th;
        }
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        uv uvVar = this.j;
        uvVar.getClass();
        uv uvVar2 = this.k;
        uvVar2.getClass();
        try {
            if (this.n >= this.s) {
                a(uvVar, true);
            }
            qv qvVar = this.l;
            qvVar.getClass();
            int i4 = qvVar.read(bArr, i, i2);
            if (i4 != -1) {
                long j = i4;
                this.n += j;
                this.m += j;
                long j2 = this.o;
                if (j2 != -1) {
                    this.o = j2 - j;
                }
                return i4;
            }
            if (!h()) {
                long j3 = uvVar2.g;
                if (j3 != -1) {
                    i3 = i4;
                    if (this.m < j3) {
                    }
                } else {
                    i3 = i4;
                }
                String str = uvVar.h;
                int i5 = x82.f10629a;
                this.o = 0L;
                if (this.l != this.c) {
                    return i3;
                }
                bs bsVar = new bs();
                bs.a(bsVar, this.n);
                this.f10492a.a(str, bsVar);
                return i3;
            }
            i3 = i4;
            long j4 = this.o;
            if (j4 <= 0 && j4 != -1) {
                return i3;
            }
            e();
            a(uvVar, false);
            return read(bArr, i, i2);
        } catch (Throwable th) {
            if (h() || (th instanceof rm.a)) {
                this.q = true;
            }
            throw th;
        }
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.i;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() throws IOException {
        this.j = null;
        this.i = null;
        this.n = 0L;
        try {
            e();
        } catch (Throwable th) {
            if (h() || (th instanceof rm.a)) {
                this.q = true;
            }
            throw th;
        }
    }

    private boolean h() {
        return this.l == this.b;
    }

    private void e() throws IOException {
        qv qvVar = this.l;
        if (qvVar == null) {
            return;
        }
        try {
            qvVar.close();
        } finally {
            this.k = null;
            this.l = null;
            en enVar = this.p;
            if (enVar != null) {
                this.f10492a.b(enVar);
                this.p = null;
            }
        }
    }

    private void a(uv uvVar, boolean z) throws IOException {
        en enVarE;
        uv uvVarA;
        qv qvVar;
        String str = uvVar.h;
        int i = x82.f10629a;
        if (this.r) {
            enVarE = null;
        } else if (this.f) {
            try {
                enVarE = this.f10492a.e(str, this.n, this.o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            enVarE = this.f10492a.c(str, this.n, this.o);
        }
        if (enVarE == null) {
            qvVar = this.d;
            uvVarA = uvVar.a().b(this.n).a(this.o).a();
        } else if (enVarE.e) {
            Uri uriFromFile = Uri.fromFile(enVarE.f);
            long j = enVarE.c;
            long j2 = this.n - j;
            long jMin = enVarE.d - j2;
            long j3 = this.o;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            uvVarA = uvVar.a().a(uriFromFile).c(j).b(j2).a(jMin).a();
            qvVar = this.b;
        } else {
            long jMin2 = enVarE.d;
            if (jMin2 == -1) {
                jMin2 = this.o;
            } else {
                long j4 = this.o;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            uvVarA = uvVar.a().b(this.n).a(jMin2).a();
            qvVar = this.c;
            if (qvVar == null) {
                qvVar = this.d;
                this.f10492a.b(enVarE);
                enVarE = null;
            }
        }
        this.s = (this.r || qvVar != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            qv qvVar2 = this.l;
            qv qvVar3 = this.d;
            if (qvVar2 != qvVar3) {
                throw new IllegalStateException();
            }
            if (qvVar == qvVar3) {
                return;
            }
            try {
                e();
            } catch (Throwable th) {
                if (!enVarE.e) {
                    this.f10492a.b(enVarE);
                    throw th;
                }
                throw th;
            }
        }
        if (enVarE != null && !enVarE.e) {
            this.p = enVarE;
        }
        this.l = qvVar;
        this.k = uvVarA;
        this.m = 0L;
        long jA = qvVar.a(uvVarA);
        bs bsVar = new bs();
        if (uvVarA.g == -1 && jA != -1) {
            this.o = jA;
            bs.a(bsVar, this.n + jA);
        }
        if (!h()) {
            Uri uri = qvVar.getUri();
            this.i = uri;
            bs.a(bsVar, uvVar.f10424a.equals(uri) ? null : this.i);
        }
        if (this.l == this.c) {
            this.f10492a.a(str, bsVar);
        }
    }
}
