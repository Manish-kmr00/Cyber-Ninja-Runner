package com.iab.omid.library.appodeal.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public class c {
    private static c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.appodeal.adsession.a> f2520a = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.appodeal.adsession.a> b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return c;
    }

    public Collection<com.iab.omid.library.appodeal.adsession.a> a() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void a(com.iab.omid.library.appodeal.adsession.a aVar) {
        this.f2520a.add(aVar);
    }

    public Collection<com.iab.omid.library.appodeal.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f2520a);
    }

    public void b(com.iab.omid.library.appodeal.adsession.a aVar) {
        boolean zD = d();
        this.f2520a.remove(aVar);
        this.b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.appodeal.adsession.a aVar) {
        boolean zD = d();
        this.b.add(aVar);
        if (zD) {
            return;
        }
        i.c().d();
    }

    public boolean d() {
        return this.b.size() > 0;
    }
}
