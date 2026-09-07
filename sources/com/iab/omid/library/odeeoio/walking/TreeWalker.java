package com.iab.omid.library.odeeoio.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.odeeoio.d.d;
import com.iab.omid.library.odeeoio.d.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class TreeWalker implements com.iab.omid.library.odeeoio.c.a.InterfaceC0363a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TreeWalker f2786a = new TreeWalker();
    private static Handler b = new Handler(Looper.getMainLooper());
    private static Handler c = null;
    private static final Runnable l = new Runnable() { // from class: com.iab.omid.library.odeeoio.walking.TreeWalker.2
        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().h();
        }
    };
    private static final Runnable m = new Runnable() { // from class: com.iab.omid.library.odeeoio.walking.TreeWalker.3
        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.c != null) {
                TreeWalker.c.post(TreeWalker.l);
                TreeWalker.c.postDelayed(TreeWalker.m, 200L);
            }
        }
    };
    private int e;
    private long k;
    private List<TreeWalkerTimeLogger> d = new ArrayList();
    private boolean f = false;
    private final List<com.iab.omid.library.odeeoio.e.a> g = new ArrayList();
    private a i = new a();
    private com.iab.omid.library.odeeoio.c.b h = new com.iab.omid.library.odeeoio.c.b();
    private b j = new b(new com.iab.omid.library.odeeoio.walking.a.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    private void a(long j) {
        if (this.d.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.d) {
                treeWalkerTimeLogger.onTreeProcessed(this.e, TimeUnit.NANOSECONDS.toMillis(j));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.e, j);
                }
            }
        }
    }

    private void a(View view, com.iab.omid.library.odeeoio.c.a aVar, JSONObject jSONObject, c cVar, boolean z) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.odeeoio.c.a aVarB = this.h.b();
        String strA = this.i.a(str);
        if (strA != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.odeeoio.d.b.a(jSONObjectA, str);
            com.iab.omid.library.odeeoio.d.b.b(jSONObjectA, strA);
            com.iab.omid.library.odeeoio.d.b.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String strA = this.i.a(view);
        if (strA == null) {
            return false;
        }
        com.iab.omid.library.odeeoio.d.b.a(jSONObject, strA);
        com.iab.omid.library.odeeoio.d.b.a(jSONObject, Boolean.valueOf(this.i.d(view)));
        this.i.e();
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        a.C0364a c0364aB = this.i.b(view);
        if (c0364aB == null) {
            return false;
        }
        com.iab.omid.library.odeeoio.d.b.a(jSONObject, c0364aB);
        return true;
    }

    public static TreeWalker getInstance() {
        return f2786a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        i();
        d();
        j();
    }

    private void i() {
        this.e = 0;
        this.g.clear();
        this.f = false;
        Iterator<com.iab.omid.library.odeeoio.adsession.a> it = com.iab.omid.library.odeeoio.b.a.a().c().iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                this.f = true;
                break;
            }
        }
        this.k = d.a();
    }

    private void j() {
        a(d.a() - this.k);
    }

    private void k() {
        if (c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            c = handler;
            handler.post(l);
            c.postDelayed(m, 200L);
        }
    }

    private void l() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(m);
            c = null;
        }
    }

    public void a() {
        k();
    }

    @Override // com.iab.omid.library.odeeoio.c.a.InterfaceC0363a
    public void a(View view, com.iab.omid.library.odeeoio.c.a aVar, JSONObject jSONObject, boolean z) {
        c cVarC;
        if (f.d(view) && (cVarC = this.i.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.odeeoio.d.b.a(jSONObject, jSONObjectA);
            if (!a(view, jSONObjectA)) {
                boolean z2 = z || b(view, jSONObjectA);
                if (this.f && cVarC == c.OBSTRUCTION_VIEW && !z2) {
                    this.g.add(new com.iab.omid.library.odeeoio.e.a(view));
                }
                a(view, aVar, jSONObjectA, cVarC, z2);
            }
            this.e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.d.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.d.add(treeWalkerTimeLogger);
    }

    public void b() {
        c();
        this.d.clear();
        b.post(new Runnable() { // from class: com.iab.omid.library.odeeoio.walking.TreeWalker.1
            @Override // java.lang.Runnable
            public void run() {
                TreeWalker.this.j.a();
            }
        });
    }

    public void c() {
        l();
    }

    void d() {
        this.i.c();
        long jA = d.a();
        com.iab.omid.library.odeeoio.c.a aVarA = this.h.a();
        if (this.i.b().size() > 0) {
            for (String str : this.i.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.i.b(str), jSONObjectA);
                com.iab.omid.library.odeeoio.d.b.a(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.j.b(jSONObjectA, hashSet, jA);
            }
        }
        if (this.i.a().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, c.PARENT_VIEW, false);
            com.iab.omid.library.odeeoio.d.b.a(jSONObjectA2);
            this.j.a(jSONObjectA2, this.i.a(), jA);
            if (this.f) {
                Iterator<com.iab.omid.library.odeeoio.adsession.a> it = com.iab.omid.library.odeeoio.b.a.a().c().iterator();
                while (it.hasNext()) {
                    it.next().a(this.g);
                }
            }
        } else {
            this.j.a();
        }
        this.i.d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.d.contains(treeWalkerTimeLogger)) {
            this.d.remove(treeWalkerTimeLogger);
        }
    }
}
