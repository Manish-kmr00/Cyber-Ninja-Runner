package com.chartboost.sdk.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<View, String> f1018a = new HashMap<>();
    public final HashMap<View, a> b = new HashMap<>();
    public final HashMap<String, View> c = new HashMap<>();
    public final HashSet<View> d = new HashSet<>();
    public final HashSet<String> e = new HashSet<>();
    public final HashSet<String> f = new HashSet<>();
    public final HashMap<String, String> g = new HashMap<>();
    public final HashSet<String> h = new HashSet<>();
    public final Map<View, Boolean> i = new WeakHashMap();
    public boolean j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fd f1019a;
        public final ArrayList<String> b = new ArrayList<>();

        public a(fd fdVar, String str) {
            this.f1019a = fdVar;
            a(str);
        }

        public fd a() {
            return this.f1019a;
        }

        public ArrayList<String> b() {
            return this.b;
        }

        public void a(String str) {
            this.b.add(str);
        }
    }

    public View a(String str) {
        return this.c.get(str);
    }

    public a b(View view) {
        a aVar = this.b.get(view);
        if (aVar != null) {
            this.b.remove(view);
        }
        return aVar;
    }

    public String c(View view) {
        if (this.f1018a.size() == 0) {
            return null;
        }
        String str = this.f1018a.get(view);
        if (str != null) {
            this.f1018a.remove(view);
        }
        return str;
    }

    public wc d(View view) {
        if (this.d.contains(view)) {
            return wc.PARENT_VIEW;
        }
        return this.j ? wc.OBSTRUCTION_VIEW : wc.UNDERLYING_VIEW;
    }

    public void e() {
        tc tcVarC = tc.c();
        if (tcVarC != null) {
            for (zb zbVar : tcVarC.a()) {
                View viewG = zbVar.g();
                if (zbVar.j()) {
                    String strE = zbVar.e();
                    if (viewG != null) {
                        boolean zE = od.e(viewG);
                        if (zE) {
                            this.h.add(strE);
                        }
                        String strA = a(viewG, zE);
                        if (strA == null) {
                            this.e.add(strE);
                            this.f1018a.put(viewG, strE);
                            a(zbVar);
                        } else if (strA != "noWindowFocus") {
                            this.f.add(strE);
                            this.c.put(strE, viewG);
                            this.g.put(strE, strA);
                        }
                    } else {
                        this.f.add(strE);
                        this.g.put(strE, "noAdView");
                    }
                }
            }
        }
    }

    public final Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.i.remove(view);
            return Boolean.FALSE;
        }
        if (this.i.containsKey(view)) {
            return this.i.get(view);
        }
        Map<View, Boolean> map = this.i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String b(String str) {
        return this.g.get(str);
    }

    public HashSet<String> c() {
        return this.e;
    }

    public void d() {
        this.j = true;
    }

    public boolean e(View view) {
        if (!this.i.containsKey(view)) {
            return true;
        }
        this.i.put(view, Boolean.TRUE);
        return false;
    }

    public final String a(View view, boolean z) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (a(view).booleanValue() && !z) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = od.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f;
    }

    public boolean c(String str) {
        return this.h.contains(str);
    }

    public void a() {
        this.f1018a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.j = false;
        this.h.clear();
    }

    public final void a(zb zbVar) {
        Iterator<fd> it = zbVar.h().iterator();
        while (it.hasNext()) {
            a(it.next(), zbVar);
        }
    }

    public final void a(fd fdVar, zb zbVar) {
        View view = fdVar.c().get();
        if (view == null) {
            return;
        }
        a aVar = this.b.get(view);
        if (aVar != null) {
            aVar.a(zbVar.e());
        } else {
            this.b.put(view, new a(fdVar, zbVar.e()));
        }
    }
}
