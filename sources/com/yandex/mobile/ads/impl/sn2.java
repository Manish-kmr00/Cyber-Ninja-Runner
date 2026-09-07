package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class sn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f10226a = new HashMap<>();
    private final HashMap<View, a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final WeakHashMap h = new WeakHashMap();
    private boolean i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final eo2 f10227a;
        private final ArrayList<String> b = new ArrayList<>();

        public a(eo2 eo2Var, String str) {
            this.f10227a = eo2Var;
            a(str);
        }

        public final eo2 a() {
            return this.f10227a;
        }

        public final ArrayList<String> b() {
            return this.b;
        }

        public final void a(String str) {
            this.b.add(str);
        }
    }

    public final String a(View view) {
        if (this.f10226a.size() == 0) {
            return null;
        }
        String str = this.f10226a.get(view);
        if (str != null) {
            this.f10226a.remove(view);
        }
        return str;
    }

    public final View b(String str) {
        return this.c.get(str);
    }

    public final void d() {
        this.f10226a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.i = false;
    }

    public final void e() {
        this.i = true;
    }

    public final String a(String str) {
        return this.g.get(str);
    }

    public final a b(View view) {
        a aVar = this.b.get(view);
        if (aVar != null) {
            this.b.remove(view);
        }
        return aVar;
    }

    public final int c(View view) {
        if (this.d.contains(view)) {
            return 1;
        }
        return this.i ? 2 : 3;
    }

    public final boolean d(View view) {
        if (!this.h.containsKey(view)) {
            return true;
        }
        this.h.put(view, Boolean.TRUE);
        return false;
    }

    public final HashSet<String> a() {
        return this.e;
    }

    public final HashSet<String> b() {
        return this.f;
    }

    public final void c() {
        Boolean bool;
        String str;
        nn2 nn2VarA = nn2.a();
        if (nn2VarA != null) {
            for (mn2 mn2Var : nn2VarA.c()) {
                View viewF = mn2Var.f();
                if (mn2Var.g()) {
                    String strI = mn2Var.i();
                    if (viewF != null) {
                        if (viewF.isAttachedToWindow()) {
                            if (viewF.hasWindowFocus()) {
                                this.h.remove(viewF);
                                bool = Boolean.FALSE;
                            } else if (this.h.containsKey(viewF)) {
                                bool = (Boolean) this.h.get(viewF);
                            } else {
                                WeakHashMap weakHashMap = this.h;
                                Boolean bool2 = Boolean.FALSE;
                                weakHashMap.put(viewF, bool2);
                                bool = bool2;
                            }
                            if (!bool.booleanValue()) {
                                HashSet hashSet = new HashSet();
                                View view = viewF;
                                while (true) {
                                    if (view == null) {
                                        this.d.addAll(hashSet);
                                        str = null;
                                        break;
                                    }
                                    String strC = ro2.c(view);
                                    if (strC != null) {
                                        str = strC;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        Object parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.e.add(strI);
                            this.f10226a.put(viewF, strI);
                            for (eo2 eo2Var : mn2Var.c()) {
                                View view2 = eo2Var.a().get();
                                if (view2 != null) {
                                    a aVar = this.b.get(view2);
                                    if (aVar != null) {
                                        aVar.a(mn2Var.i());
                                    } else {
                                        this.b.put(view2, new a(eo2Var, mn2Var.i()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.f.add(strI);
                            this.c.put(strI, viewF);
                            this.g.put(strI, str);
                        }
                    } else {
                        this.f.add(strI);
                        this.g.put(strI, "noAdView");
                    }
                }
            }
        }
    }
}
