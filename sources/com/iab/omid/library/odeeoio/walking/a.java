package com.iab.omid.library.odeeoio.walking;

import android.view.View;
import com.iab.omid.library.odeeoio.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f2788a = new HashMap<>();
    private final HashMap<View, C0364a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final Map<View, Boolean> h = new WeakHashMap();
    private boolean i;

    /* JADX INFO: renamed from: com.iab.omid.library.odeeoio.walking.a$a, reason: collision with other inner class name */
    public static class C0364a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.iab.omid.library.odeeoio.b.c f2789a;
        private final ArrayList<String> b = new ArrayList<>();

        public C0364a(com.iab.omid.library.odeeoio.b.c cVar, String str) {
            this.f2789a = cVar;
            a(str);
        }

        public com.iab.omid.library.odeeoio.b.c a() {
            return this.f2789a;
        }

        public void a(String str) {
            this.b.add(str);
        }

        public ArrayList<String> b() {
            return this.b;
        }
    }

    private void a(com.iab.omid.library.odeeoio.adsession.a aVar) {
        Iterator<com.iab.omid.library.odeeoio.b.c> it = aVar.a().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(com.iab.omid.library.odeeoio.b.c cVar, com.iab.omid.library.odeeoio.adsession.a aVar) {
        View view = (View) cVar.a().get();
        if (view == null) {
            return;
        }
        C0364a c0364a = this.b.get(view);
        if (c0364a != null) {
            c0364a.a(aVar.getAdSessionId());
        } else {
            this.b.put(view, new C0364a(cVar, aVar.getAdSessionId()));
        }
    }

    private String e(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (f(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strE = f.e(view);
            if (strE != null) {
                return strE;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.d.addAll(hashSet);
        return null;
    }

    private Boolean f(View view) {
        if (view.hasWindowFocus()) {
            this.h.remove(view);
            return false;
        }
        if (this.h.containsKey(view)) {
            return this.h.get(view);
        }
        this.h.put(view, false);
        return false;
    }

    public String a(View view) {
        if (this.f2788a.size() == 0) {
            return null;
        }
        String str = this.f2788a.get(view);
        if (str != null) {
            this.f2788a.remove(view);
        }
        return str;
    }

    public String a(String str) {
        return this.g.get(str);
    }

    public HashSet<String> a() {
        return this.e;
    }

    public View b(String str) {
        return this.c.get(str);
    }

    public C0364a b(View view) {
        C0364a c0364a = this.b.get(view);
        if (c0364a != null) {
            this.b.remove(view);
        }
        return c0364a;
    }

    public HashSet<String> b() {
        return this.f;
    }

    public c c(View view) {
        if (this.d.contains(view)) {
            return c.PARENT_VIEW;
        }
        return this.i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void c() {
        com.iab.omid.library.odeeoio.b.a aVarA = com.iab.omid.library.odeeoio.b.a.a();
        if (aVarA != null) {
            for (com.iab.omid.library.odeeoio.adsession.a aVar : aVarA.c()) {
                View viewE = aVar.e();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewE != null) {
                        String strE = e(viewE);
                        if (strE == null) {
                            this.e.add(adSessionId);
                            this.f2788a.put(viewE, adSessionId);
                            a(aVar);
                        } else if (strE != "noWindowFocus") {
                            this.f.add(adSessionId);
                            this.c.put(adSessionId, viewE);
                            this.g.put(adSessionId, strE);
                        }
                    } else {
                        this.f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.f2788a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.i = false;
    }

    public boolean d(View view) {
        if (!this.h.containsKey(view)) {
            return true;
        }
        this.h.put(view, true);
        return false;
    }

    public void e() {
        this.i = true;
    }
}
