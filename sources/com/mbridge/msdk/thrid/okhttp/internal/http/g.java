package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: RealInterceptorChain.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements r.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<r> f5528a;
    private final com.mbridge.msdk.thrid.okhttp.internal.connection.g b;
    private final c c;
    private final com.mbridge.msdk.thrid.okhttp.internal.connection.c d;
    private final int e;
    private final w f;
    private final com.mbridge.msdk.thrid.okhttp.d g;
    private final n h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<r> list, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, c cVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2, int i, w wVar, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar, int i2, int i3, int i4) {
        this.f5528a = list;
        this.d = cVar2;
        this.b = gVar;
        this.c = cVar;
        this.e = i;
        this.f = wVar;
        this.g = dVar;
        this.h = nVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int a() {
        return this.i;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int b() {
        return this.j;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int c() {
        return this.k;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public w d() {
        return this.f;
    }

    public com.mbridge.msdk.thrid.okhttp.d e() {
        return this.g;
    }

    public com.mbridge.msdk.thrid.okhttp.g f() {
        return this.d;
    }

    public n g() {
        return this.h;
    }

    public c h() {
        return this.c;
    }

    public com.mbridge.msdk.thrid.okhttp.internal.connection.g i() {
        return this.b;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public y a(w wVar) throws IOException {
        return a(wVar, this.b, this.c, this.d);
    }

    public y a(w wVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, c cVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2) throws IOException {
        if (this.e < this.f5528a.size()) {
            this.l++;
            if (this.c != null && !this.d.a(wVar.g())) {
                throw new IllegalStateException("network interceptor " + this.f5528a.get(this.e - 1) + " must retain the same host and port");
            }
            if (this.c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f5528a.get(this.e - 1) + " must call proceed() exactly once");
            }
            g gVar2 = new g(this.f5528a, gVar, cVar, cVar2, this.e + 1, wVar, this.g, this.h, this.i, this.j, this.k);
            r rVar = this.f5528a.get(this.e);
            y yVarA = rVar.a(gVar2);
            if (cVar != null && this.e + 1 < this.f5528a.size() && gVar2.l != 1) {
                throw new IllegalStateException("network interceptor " + rVar + " must call proceed() exactly once");
            }
            if (yVarA != null) {
                if (yVarA.d() != null) {
                    return yVarA;
                }
                throw new IllegalStateException("interceptor " + rVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        throw new AssertionError();
    }
}
