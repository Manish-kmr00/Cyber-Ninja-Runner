package sg.bigo.ads.core.f.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class p {
    public sg.bigo.ads.core.f.a.a.a B;
    public List<sg.bigo.ads.core.c.a> C;
    public String m;
    public b n;
    public String o;
    public String p;
    public String q;
    String r;
    public long s;
    long t;
    long u;
    int v = -1;
    public int w = 0;
    public int x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<n> f13600a = new ArrayList<>();
    public final ArrayList<l> b = new ArrayList<>();
    public final ArrayList<c> c = new ArrayList<>();
    public final ArrayList<n> d = new ArrayList<>();
    public final ArrayList<n> f = new ArrayList<>();
    public final ArrayList<n> e = new ArrayList<>();
    public final ArrayList<j> g = new ArrayList<>();
    public final ArrayList<n> i = new ArrayList<>();
    public final ArrayList<n> h = new ArrayList<>();
    public final ArrayList<n> j = new ArrayList<>();
    public final ArrayList<n> k = new ArrayList<>();
    private final ArrayList<n> D = new ArrayList<>();
    public final ArrayList<n> l = new ArrayList<>();
    public final List<n> y = new ArrayList();
    public final List<n> z = new ArrayList();
    public final List<a> A = new ArrayList();

    public final void a(List<n> list) {
        this.f13600a.addAll(list);
    }

    public final void b(List<n> list) {
        this.D.addAll(list);
    }

    public final void c(List<n> list) {
        this.l.addAll(list);
    }

    public final void d(List<n> list) {
        this.d.addAll(list);
    }

    public final void e(List<n> list) {
        this.f.addAll(list);
    }

    public final void f(List<n> list) {
        this.e.addAll(list);
    }

    public final void g(List<j> list) {
        this.g.addAll(list);
    }

    public final void h(List<n> list) {
        this.i.addAll(list);
    }

    public final void i(List<n> list) {
        this.h.addAll(list);
    }

    public final void j(List<n> list) {
        this.j.addAll(list);
    }

    public final void k(List<l> list) {
        this.b.addAll(list);
        Collections.sort(this.b);
    }

    public final void l(List<c> list) {
        this.c.addAll(list);
        Collections.sort(this.c);
    }
}
