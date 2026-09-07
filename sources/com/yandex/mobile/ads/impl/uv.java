package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class uv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f10424a;
    public final long b;
    public final int c;
    public final byte[] d;
    public final Map<String, String> e;
    public final long f;
    public final long g;
    public final String h;
    public final int i;
    public final Object j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f10425a;
        private long b;
        private int c;
        private byte[] d;
        private Map<String, String> e;
        private long f;
        private long g;
        private String h;
        private int i;
        private Object j;

        public final a b() {
            this.c = 2;
            return this;
        }

        public a() {
            this.c = 1;
            this.e = Collections.emptyMap();
            this.g = -1L;
        }

        public final a c(long j) {
            this.b = j;
            return this;
        }

        private a(uv uvVar) {
            this.f10425a = uvVar.f10424a;
            this.b = uvVar.b;
            this.c = uvVar.c;
            this.d = uvVar.d;
            this.e = uvVar.e;
            this.f = uvVar.f;
            this.g = uvVar.g;
            this.h = uvVar.h;
            this.i = uvVar.i;
            this.j = uvVar.j;
        }

        public final a b(long j) {
            this.f = j;
            return this;
        }

        public final uv a() {
            if (this.f10425a != null) {
                return new uv(this.f10425a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            throw new IllegalStateException("The uri must be set.");
        }

        public final a b(String str) {
            this.f10425a = Uri.parse(str);
            return this;
        }

        public final a a(int i) {
            this.i = i;
            return this;
        }

        public final a a(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public final a a(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public final a a(String str) {
            this.h = str;
            return this;
        }

        public final a a(long j) {
            this.g = j;
            return this;
        }

        public final a a(Uri uri) {
            this.f10425a = uri;
            return this;
        }
    }

    static {
        r60.a("goog.exo.datasource");
    }

    public final String toString() {
        return "DataSpec[" + a(this.c) + " " + this.f10424a + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.i + com.ironsource.b9.i.e;
    }

    public static String a(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public final uv a(long j) {
        return this.g == j ? this : new uv(this.f10424a, this.b, this.c, this.d, this.e, this.f, j, this.h, this.i, this.j);
    }

    public final a a() {
        return new a();
    }

    private uv(Uri uri, long j, int i, byte[] bArr, Map<String, String> map, long j2, long j3, String str, int i2, Object obj) {
        byte[] bArr2 = bArr;
        boolean z = true;
        hg.a(j + j2 >= 0);
        hg.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        hg.a(z);
        this.f10424a = uri;
        this.b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i2;
        this.j = obj;
    }
}
