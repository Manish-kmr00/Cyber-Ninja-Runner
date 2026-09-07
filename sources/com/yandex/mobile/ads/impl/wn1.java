package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sn1 f10579a;
    private final List<ip0> b;
    private final int c;
    private final y50 d;
    private final op1 e;
    private final int f;
    private final int g;
    private final int h;
    private int i;

    /* JADX WARN: Multi-variable type inference failed */
    public wn1(sn1 call, List<? extends ip0> interceptors, int i, y50 y50Var, op1 request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f10579a = call;
        this.b = interceptors;
        this.c = i;
        this.d = y50Var;
        this.e = request;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public final sn1 a() {
        return this.f10579a;
    }

    public static wn1 a(wn1 wn1Var, int i, y50 y50Var, op1 op1Var, int i2) {
        if ((i2 & 1) != 0) {
            i = wn1Var.c;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            y50Var = wn1Var.d;
        }
        y50 y50Var2 = y50Var;
        if ((i2 & 4) != 0) {
            op1Var = wn1Var.e;
        }
        op1 request = op1Var;
        int i4 = wn1Var.f;
        int i5 = wn1Var.g;
        int i6 = wn1Var.h;
        wn1Var.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        return new wn1(wn1Var.f10579a, wn1Var.b, i3, y50Var2, request, i4, i5, i6);
    }

    public final sn1 b() {
        return this.f10579a;
    }

    public final y50 d() {
        return this.d;
    }

    public final op1 f() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final oq1 a(op1 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.c < this.b.size()) {
            this.i++;
            y50 y50Var = this.d;
            if (y50Var != null) {
                if (y50Var.h().a(request.g())) {
                    if (this.i != 1) {
                        throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must retain the same host and port").toString());
                }
            }
            wn1 wn1VarA = a(this, this.c + 1, null, request, 58);
            ip0 ip0Var = this.b.get(this.c);
            oq1 oq1VarA = ip0Var.a(wn1VarA);
            if (oq1VarA != null) {
                if (this.d != null && this.c + 1 < this.b.size() && wn1VarA.i != 1) {
                    throw new IllegalStateException(("network interceptor " + ip0Var + " must call proceed() exactly once").toString());
                }
                if (oq1VarA.a() != null) {
                    return oq1VarA;
                }
                throw new IllegalStateException(("interceptor " + ip0Var + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + ip0Var + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int h() {
        return this.g;
    }

    public final op1 i() {
        return this.e;
    }
}
