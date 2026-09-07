package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class np1<T> implements Comparable<np1<T>> {
    private final li2.a b;
    private final int c;
    private final String d;
    private final int e;
    private final Object f;
    private qq1.a g;
    private Integer h;
    private bq1 i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private gr1 o;
    private sm.a p;
    private Object q;
    private b r;

    interface b {
    }

    protected abstract qq1<T> a(tc1 tc1Var);

    protected abstract void a(T t);

    protected ki2 b(ki2 ki2Var) {
        return ki2Var;
    }

    public byte[] b() throws zh {
        return null;
    }

    public Map<String, String> e() throws zh {
        return Collections.emptyMap();
    }

    public int g() {
        return 2;
    }

    public final int j() {
        return this.o.a();
    }

    public final void q() {
        this.j = false;
    }

    public final void r() {
        this.n = true;
    }

    public final void s() {
        this.m = true;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        np1 np1Var = (np1) obj;
        int iG = g();
        int iG2 = np1Var.g();
        return iG == iG2 ? this.h.intValue() - np1Var.h.intValue() : f9.a(iG2) - f9.a(iG);
    }

    public np1(int i, String str, qq1.a aVar) {
        this.b = li2.a.c ? new li2.a() : null;
        this.f = new Object();
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.c = i;
        this.d = str;
        this.g = aVar;
        a(new j00());
        this.e = b(str);
    }

    public final int f() {
        return this.c;
    }

    public final Object i() {
        return this.q;
    }

    public final int k() {
        return this.e;
    }

    private static int b(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public final void b(int i) {
        this.h = Integer.valueOf(i);
    }

    public final void b(Object obj) {
        this.q = obj;
    }

    final void c(String str) {
        bq1 bq1Var = this.i;
        if (bq1Var != null) {
            bq1Var.b(this);
        }
        if (li2.a.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.b.a(str, id);
                this.b.a(toString());
            }
        }
    }

    final class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        a(String str, long j) {
            this.b = str;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            np1.this.b.a(this.b, this.c);
            np1 np1Var = np1.this;
            np1Var.b.a(np1Var.toString());
        }
    }

    public String l() {
        return this.d;
    }

    public final String d() {
        String strL = l();
        int i = this.c;
        return (i == 0 || i == -1) ? strL : Integer.toString(i) + '-' + strL;
    }

    public void a() {
        synchronized (this.f) {
            this.k = true;
            this.g = null;
        }
    }

    public final boolean n() {
        boolean z;
        synchronized (this.f) {
            z = this.k;
        }
        return z;
    }

    public final boolean t() {
        return this.j;
    }

    public final boolean v() {
        return this.m;
    }

    public final boolean u() {
        return this.n;
    }

    public final sm.a c() {
        return this.p;
    }

    public final gr1 h() {
        return this.o;
    }

    public final void o() {
        synchronized (this.f) {
            this.l = true;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.f) {
            z = this.l;
        }
        return z;
    }

    final void p() {
        b bVar;
        synchronized (this.f) {
            bVar = this.r;
        }
        if (bVar != null) {
            ((zi2) bVar).b(this);
        }
    }

    public final String toString() {
        return (n() ? "[X] " : "[ ] ") + l() + " " + ("0x" + Integer.toHexString(this.e)) + " " + pp1.a(g()) + " " + this.h;
    }

    public final void a(ki2 ki2Var) {
        qq1.a aVar;
        synchronized (this.f) {
            aVar = this.g;
        }
        if (aVar != null) {
            aVar.a(ki2Var);
        }
    }

    final void a(qq1<?> qq1Var) {
        b bVar;
        synchronized (this.f) {
            bVar = this.r;
        }
        if (bVar != null) {
            ((zi2) bVar).a(this, qq1Var);
        }
    }

    final void a(int i) {
        bq1 bq1Var = this.i;
        if (bq1Var != null) {
            bq1Var.a(this, i);
        }
    }

    public final void a(sm.a aVar) {
        this.p = aVar;
    }

    final void a(b bVar) {
        synchronized (this.f) {
            this.r = bVar;
        }
    }

    public final void a(bq1 bq1Var) {
        this.i = bq1Var;
    }

    public final void a(j00 j00Var) {
        this.o = j00Var;
    }

    public final void a(String str) {
        if (li2.a.c) {
            this.b.a(str, Thread.currentThread().getId());
        }
    }
}
