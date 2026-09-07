package com.applovin.impl.sdk;

import com.applovin.impl.k1;
import com.applovin.impl.v2;
import com.json.m5;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f646a;
    private final Map b = new HashMap();
    private final Object c = new Object();
    private final Map d = new HashMap();
    private final Object e = new Object();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f647a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private long h;
        private final ArrayDeque i;

        public String b() {
            return this.d;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.e;
        }

        public String e() {
            return this.f;
        }

        public String f() {
            return this.g;
        }

        public String g() {
            return this.b;
        }

        public String h() {
            return this.f;
        }

        public c i() {
            return (c) this.i.getLast();
        }

        public String toString() {
            return "AdInfo{state='" + i() + "', adUnitId='" + this.f647a + "', format='" + this.b + "', adapterName='" + this.c + "', adapterClass='" + this.d + "', adapterVersion='" + this.e + "', bCode='" + this.f + "', creativeId='" + this.g + "', updated=" + this.h + AbstractJsonLexerKt.END_OBJ;
        }

        private b(v2 v2Var, c cVar) {
            this.i = new ArrayDeque();
            this.f647a = v2Var.getAdUnitId();
            this.b = v2Var.getFormat().getLabel();
            this.c = v2Var.c();
            this.d = v2Var.b();
            this.e = v2Var.z();
            this.f = v2Var.C();
            this.g = v2Var.getCreativeId();
            a(cVar);
        }

        public String a() {
            return this.f647a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.h = System.currentTimeMillis();
            this.i.add(cVar);
        }
    }

    public enum c {
        LOADING("loading"),
        LOAD("load"),
        SHOW(m5.v),
        HIDE("hide"),
        CLICK("click"),
        DESTROY("destroy"),
        SHOW_ERROR("show_error");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f648a;

        c(String str) {
            this.f648a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f648a;
        }
    }

    public interface d {
        void a(b bVar);
    }

    g(k kVar) {
        this.f646a = kVar;
        a();
    }

    public void a(v2 v2Var, c cVar) {
        synchronized (this.e) {
            String strC = v2Var.C();
            b bVar = (b) this.d.get(strC);
            if (bVar == null) {
                if (cVar == c.DESTROY) {
                    return;
                }
                bVar = new b(v2Var, cVar);
                this.d.put(strC, bVar);
            } else if (bVar.i() == cVar) {
                return;
            } else {
                bVar.a(cVar);
            }
            if (cVar == c.DESTROY) {
                this.d.remove(strC);
            }
            a(bVar, cVar);
        }
    }

    public void a() {
        synchronized (this.c) {
            for (c cVar : c.values()) {
                this.b.put(cVar, new HashSet());
            }
        }
    }

    public void a(d dVar, Set set) {
        synchronized (this.c) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                a((c) it.next()).add(dVar);
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.c) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                a((c) it.next()).remove(dVar);
            }
        }
    }

    private Set a(c cVar) {
        synchronized (this.c) {
            Set set = (Set) this.b.get(cVar);
            if (k1.a(set)) {
                return set;
            }
            return new HashSet();
        }
    }

    private void a(b bVar, c cVar) {
        synchronized (this.c) {
            Iterator it = a(cVar).iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(bVar);
            }
        }
    }
}
