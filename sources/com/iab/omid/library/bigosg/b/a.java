package com.iab.omid.library.bigosg.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes12.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2556a = new a();
    private final ArrayList<com.iab.omid.library.bigosg.adsession.a> b = new ArrayList<>();
    private final ArrayList<com.iab.omid.library.bigosg.adsession.a> c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f2556a;
    }

    public void a(com.iab.omid.library.bigosg.adsession.a aVar) {
        this.b.add(aVar);
    }

    public Collection<com.iab.omid.library.bigosg.adsession.a> b() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void b(com.iab.omid.library.bigosg.adsession.a aVar) {
        boolean zD = d();
        this.c.add(aVar);
        if (zD) {
            return;
        }
        f.a().b();
    }

    public Collection<com.iab.omid.library.bigosg.adsession.a> c() {
        return Collections.unmodifiableCollection(this.c);
    }

    public void c(com.iab.omid.library.bigosg.adsession.a aVar) {
        boolean zD = d();
        this.b.remove(aVar);
        this.c.remove(aVar);
        if (!zD || d()) {
            return;
        }
        f.a().c();
    }

    public boolean d() {
        return this.c.size() > 0;
    }
}
