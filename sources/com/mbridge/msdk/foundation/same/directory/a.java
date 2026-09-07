package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Directory.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f4962a;
    private String b;
    private a c;
    private c d;

    public void a(c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        a(aVar);
    }

    public String b() {
        return this.b;
    }

    public a c() {
        return this.c;
    }

    public c d() {
        return this.d;
    }

    public void b(a aVar) {
        this.c = aVar;
    }

    public void a(a aVar) {
        if (this.f4962a == null) {
            this.f4962a = new ArrayList();
        }
        aVar.b(this);
        this.f4962a.add(aVar);
    }

    public void a(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public List<a> a() {
        return this.f4962a;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(c cVar) {
        this.d = cVar;
    }
}
