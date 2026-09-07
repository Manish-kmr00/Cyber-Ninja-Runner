package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class mm implements zl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a80 f9654a;
    private w70 b;
    private tz c;

    public mm(a80 a80Var) {
        this.f9654a = a80Var;
    }

    public final void c() {
        w70 w70Var = this.b;
        if (w70Var != null) {
            w70Var.release();
            this.b = null;
        }
        this.c = null;
    }

    public final void a() {
        w70 w70Var = this.b;
        if (w70Var instanceof w11) {
            ((w11) w70Var).a();
        }
    }

    public final void a(qv qvVar, Uri uri, Map map, long j, long j2, y70 y70Var) throws IOException {
        tz tzVar = new tz(qvVar, j, j2);
        this.c = tzVar;
        if (this.b != null) {
            return;
        }
        w70[] w70VarArrA = this.f9654a.a(uri, map);
        if (w70VarArrA.length == 1) {
            this.b = w70VarArrA[0];
        } else {
            for (w70 w70Var : w70VarArrA) {
                try {
                    if (w70Var.a(tzVar)) {
                        this.b = w70Var;
                        tzVar.c();
                        break;
                    } else if (this.b == null && tzVar.a() != j) {
                        throw new IllegalStateException();
                    }
                } catch (EOFException unused) {
                    if (this.b != null) {
                        continue;
                    } else if (tzVar.a() != j) {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    if (this.b == null && tzVar.a() != j) {
                        throw new IllegalStateException();
                    }
                    tzVar.c();
                    throw th;
                }
                tzVar.c();
            }
            if (this.b == null) {
                StringBuilder sb = new StringBuilder("None of the available extractors (");
                int i = x82.f10629a;
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < w70VarArrA.length; i2++) {
                    sb2.append(w70VarArrA[i2].getClass().getSimpleName());
                    if (i2 < w70VarArrA.length - 1) {
                        sb2.append(", ");
                    }
                }
                String string = sb.append(sb2.toString()).append(") could read the stream.").toString();
                uri.getClass();
                throw new d82(string);
            }
        }
        this.b.a(y70Var);
    }

    public final long b() {
        tz tzVar = this.c;
        if (tzVar != null) {
            return tzVar.a();
        }
        return -1L;
    }

    public final int a(lj1 lj1Var) throws IOException {
        w70 w70Var = this.b;
        w70Var.getClass();
        tz tzVar = this.c;
        tzVar.getClass();
        return w70Var.a(tzVar, lj1Var);
    }

    public final void a(long j, long j2) {
        w70 w70Var = this.b;
        w70Var.getClass();
        w70Var.a(j, j2);
    }
}
