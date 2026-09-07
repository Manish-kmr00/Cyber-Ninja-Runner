package com.mbridge.msdk.thrid.okhttp;

import com.android.volley.toolbox.HttpClientStack;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes7.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final q f5581a;
    final String b;
    final p c;

    @Nullable
    final x d;
    final Map<Class<?>, Object> e;

    @Nullable
    private volatile c f;

    /* JADX INFO: compiled from: Request.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        q f5582a;
        String b;
        p.a c;

        @Nullable
        x d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new p.a();
        }

        public a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f5582a = qVar;
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(q.b(str));
        }

        public a c() {
            return a("GET", (x) null);
        }

        public a d() {
            return a("HEAD", (x) null);
        }

        public a c(x xVar) {
            return a("POST", xVar);
        }

        public a d(x xVar) {
            return a(com.safedk.android.a.g.f, xVar);
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a a(String str) {
            this.c.b(str);
            return this;
        }

        public a a(p pVar) {
            this.c = pVar.a();
            return this;
        }

        public a a(c cVar) {
            String string = cVar.toString();
            return string.isEmpty() ? a("Cache-Control") : b("Cache-Control", string);
        }

        a(w wVar) {
            this.e = Collections.emptyMap();
            this.f5582a = wVar.f5581a;
            this.b = wVar.b;
            this.d = wVar.d;
            this.e = wVar.e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(wVar.e);
            this.c = wVar.c.a();
        }

        public a a(@Nullable x xVar) {
            return a("DELETE", xVar);
        }

        public a b(String str, String str2) {
            this.c.c(str, str2);
            return this;
        }

        public a a(String str, @Nullable x xVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (xVar != null && !com.mbridge.msdk.thrid.okhttp.internal.http.f.a(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (xVar == null && com.mbridge.msdk.thrid.okhttp.internal.http.f.d(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.b = str;
                    this.d = xVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public a b() {
            return a(com.mbridge.msdk.thrid.okhttp.internal.c.d);
        }

        public a b(x xVar) {
            return a(HttpClientStack.HttpPatch.METHOD_NAME, xVar);
        }

        public w a() {
            if (this.f5582a != null) {
                return new w(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    w(a aVar) {
        this.f5581a = aVar.f5582a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = com.mbridge.msdk.thrid.okhttp.internal.c.a(aVar.e);
    }

    @Nullable
    public String a(String str) {
        return this.c.b(str);
    }

    public c b() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar;
        }
        c cVarA = c.a(this.c);
        this.f = cVarA;
        return cVarA;
    }

    public p c() {
        return this.c;
    }

    public boolean d() {
        return this.f5581a.h();
    }

    public String e() {
        return this.b;
    }

    public a f() {
        return new a(this);
    }

    public q g() {
        return this.f5581a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.f5581a + ", tags=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    @Nullable
    public x a() {
        return this.d;
    }
}
