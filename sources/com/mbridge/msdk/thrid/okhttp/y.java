package com.mbridge.msdk.thrid.okhttp;

import java.io.Closeable;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w f5584a;
    final u b;
    final int c;
    final String d;

    @Nullable
    final o e;
    final p f;

    @Nullable
    final z g;

    @Nullable
    final y h;

    @Nullable
    final y i;

    @Nullable
    final y j;
    final long k;
    final long l;

    @Nullable
    private volatile c m;

    /* JADX INFO: compiled from: Response.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        w f5585a;

        @Nullable
        u b;
        int c;
        String d;

        @Nullable
        o e;
        p.a f;

        @Nullable
        z g;

        @Nullable
        y h;

        @Nullable
        y i;

        @Nullable
        y j;
        long k;
        long l;

        public a() {
            this.c = -1;
            this.f = new p.a();
        }

        public a a(w wVar) {
            this.f5585a = wVar;
            return this;
        }

        public a b(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        public a c(@Nullable y yVar) {
            if (yVar != null) {
                a("networkResponse", yVar);
            }
            this.h = yVar;
            return this;
        }

        public a d(@Nullable y yVar) {
            if (yVar != null) {
                b(yVar);
            }
            this.j = yVar;
            return this;
        }

        private void b(y yVar) {
            if (yVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(u uVar) {
            this.b = uVar;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a a(@Nullable o oVar) {
            this.e = oVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(p pVar) {
            this.f = pVar.a();
            return this;
        }

        public a a(@Nullable z zVar) {
            this.g = zVar;
            return this;
        }

        public a a(@Nullable y yVar) {
            if (yVar != null) {
                a("cacheResponse", yVar);
            }
            this.i = yVar;
            return this;
        }

        private void a(String str, y yVar) {
            if (yVar.g == null) {
                if (yVar.h == null) {
                    if (yVar.i == null) {
                        if (yVar.j != null) {
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        return;
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        a(y yVar) {
            this.c = -1;
            this.f5585a = yVar.f5584a;
            this.b = yVar.b;
            this.c = yVar.c;
            this.d = yVar.d;
            this.e = yVar.e;
            this.f = yVar.f.a();
            this.g = yVar.g;
            this.h = yVar.h;
            this.i = yVar.i;
            this.j = yVar.j;
            this.k = yVar.k;
            this.l = yVar.l;
        }

        public a a(long j) {
            this.l = j;
            return this;
        }

        public y a() {
            if (this.f5585a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.d != null) {
                            return new y(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    y(a aVar) {
        this.f5584a = aVar.f5585a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String strB = this.f.b(str);
        return strB != null ? strB : str2;
    }

    @Nullable
    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.g;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    @Nullable
    public z d() {
        return this.g;
    }

    public c h() {
        c cVar = this.m;
        if (cVar != null) {
            return cVar;
        }
        c cVarA = c.a(this.f);
        this.m = cVarA;
        return cVarA;
    }

    public int k() {
        return this.c;
    }

    @Nullable
    public o l() {
        return this.e;
    }

    public p m() {
        return this.f;
    }

    public boolean n() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public a o() {
        return new a(this);
    }

    @Nullable
    public y p() {
        return this.j;
    }

    public long q() {
        return this.l;
    }

    public w r() {
        return this.f5584a;
    }

    public long s() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.f5584a.g() + AbstractJsonLexerKt.END_OBJ;
    }
}
