package com.yandex.mobile.ads.impl;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class op1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final di0 f9846a;
    private final String b;
    private final nf0 c;
    private final rp1 d;
    private final Map<Class<?>, Object> e;
    private tm f;

    public op1(di0 url, String method, nf0 headers, rp1 rp1Var, Map<Class<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f9846a = url;
        this.b = method;
        this.c = headers;
        this.d = rp1Var;
        this.e = tags;
    }

    public final di0 g() {
        return this.f9846a;
    }

    public final String f() {
        return this.b;
    }

    public final nf0 d() {
        return this.c;
    }

    public final rp1 a() {
        return this.d;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.c.a(name);
    }

    public final Map<Class<?>, Object> c() {
        return this.e;
    }

    public final boolean e() {
        return this.f9846a.h();
    }

    public final tm b() {
        tm tmVar = this.f;
        if (tmVar != null) {
            return tmVar;
        }
        int i = tm.n;
        tm tmVarA = tm.b.a(this.c);
        this.f = tmVarA;
        return tmVarA;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.f9846a);
        if (this.c.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(strComponent1);
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(strComponent2);
                i = i2;
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        if (!this.e.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.e);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private di0 f9847a;
        private String b;
        private nf0.a c;
        private rp1 d;
        private Map<Class<?>, Object> e;

        public final void a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.a aVar = this.c;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.b.b(name);
            nf0.b.b(value, name);
            aVar.a(name, value);
        }

        public final a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.a aVar = this.c;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.b.b(name);
            nf0.b.b(value, name);
            aVar.a(name);
            aVar.a(name, value);
            return this;
        }

        public a() {
            this.e = new LinkedHashMap();
            this.b = "GET";
            this.c = new nf0.a();
        }

        public a(op1 request) {
            Map<Class<?>, Object> mutableMap;
            Intrinsics.checkNotNullParameter(request, "request");
            this.e = new LinkedHashMap();
            this.f9847a = request.g();
            this.b = request.f();
            this.d = request.a();
            if (request.c().isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = MapsKt.toMutableMap(request.c());
            }
            this.e = mutableMap;
            this.c = request.d().b();
        }

        public final op1 a() {
            Map mapUnmodifiableMap;
            di0 di0Var = this.f9847a;
            if (di0Var != null) {
                String str = this.b;
                nf0 nf0VarA = this.c.a();
                rp1 rp1Var = this.d;
                Map<Class<?>, Object> map = this.e;
                byte[] bArr = y82.f10712a;
                Intrinsics.checkNotNullParameter(map, "<this>");
                if (map.isEmpty()) {
                    mapUnmodifiableMap = MapsKt.emptyMap();
                } else {
                    mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
                    Intrinsics.checkNotNull(mapUnmodifiableMap);
                }
                return new op1(di0Var, str, nf0VarA, rp1Var, mapUnmodifiableMap);
            }
            throw new IllegalStateException("url == null".toString());
        }

        public final void a(tm cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String value = cacheControl.toString();
            if (value.length() == 0) {
                Intrinsics.checkNotNullParameter("Cache-Control", "name");
                this.c.a("Cache-Control");
                return;
            }
            Intrinsics.checkNotNullParameter("Cache-Control", "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.a aVar = this.c;
            aVar.getClass();
            Intrinsics.checkNotNullParameter("Cache-Control", "name");
            Intrinsics.checkNotNullParameter(value, "value");
            nf0.b.b("Cache-Control");
            nf0.b.b(value, "Cache-Control");
            aVar.a("Cache-Control");
            aVar.a("Cache-Control", value);
        }

        public final a a(nf0 headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.c = headers.b();
            return this;
        }

        public final a a(String method, rp1 rp1Var) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() > 0) {
                if (rp1Var == null) {
                    if (xh0.b(method)) {
                        throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                    }
                } else if (!xh0.a(method)) {
                    throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
                }
                this.b = method;
                this.d = rp1Var;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public final void a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.c.a(name);
        }

        public final a a(di0 url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.f9847a = url;
            return this;
        }

        public final a a(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Intrinsics.checkNotNullParameter(string, "<this>");
            di0 url2 = new di0.a().a(null, string).a();
            Intrinsics.checkNotNullParameter(url2, "url");
            this.f9847a = url2;
            return this;
        }
    }
}
