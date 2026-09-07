package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends sg.bigo.ads.common.g.b.c {
    public int i;
    public long j;
    public int k;
    public long l;
    public int m;
    public long n;
    public int o;
    public long p;
    final r q;
    int r;
    public CopyOnWriteArrayList<d> s;
    public CopyOnWriteArrayList<d> t;
    public CopyOnWriteArrayList<d> u;
    public CopyOnWriteArrayList<d> v;

    public e(r rVar, Cursor cursor) {
        super(cursor);
        this.i = 0;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.m = 0;
        this.n = 0L;
        this.o = 0;
        this.p = 0L;
        this.q = rVar;
        this.c = 1;
    }

    public e(r rVar, Map<String, String> map) {
        super(map);
        this.i = 0;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.m = 0;
        this.n = 0L;
        this.o = 0;
        this.p = 0L;
        this.q = rVar;
        this.c = 1;
    }

    private void a(Context context, final String str, final d dVar) {
        String str2 = dVar.b;
        if (!dVar.b()) {
            int i = this.i;
            if ("click_track".equals(str)) {
                i = this.k;
            } else if ("nurl_track".equals(str)) {
                i = this.m;
            } else if ("lurl_track".equals(str)) {
                i = this.o;
            }
            int i2 = i;
            sg.bigo.ads.common.u.a aVarD = dVar.d();
            dVar.a();
            sg.bigo.ads.core.e.b.a(context, str, aVarD, str2, this.r, this.b, i2, this.h, new sg.bigo.ads.core.e.b.a() { // from class: sg.bigo.ads.core.e.a.e.1
                @Override // sg.bigo.ads.core.e.b.a
                public final void a() {
                    c.a().b(e.this);
                }

                @Override // sg.bigo.ads.core.e.b.a
                public final boolean a(int i3) {
                    return e.this.q.a(i3);
                }

                @Override // sg.bigo.ads.core.e.b.a
                public final void b() {
                    CopyOnWriteArrayList<d> copyOnWriteArrayList;
                    if ("impl_track".equals(str)) {
                        copyOnWriteArrayList = e.this.s;
                    } else if ("click_track".equals(str)) {
                        copyOnWriteArrayList = e.this.t;
                    } else {
                        if (!"nurl_track".equals(str)) {
                            if ("lurl_track".equals(str)) {
                                copyOnWriteArrayList = e.this.v;
                            }
                            c.a().b(e.this);
                        }
                        copyOnWriteArrayList = e.this.u;
                    }
                    copyOnWriteArrayList.remove(dVar);
                    c.a().b(e.this);
                }
            });
            return;
        }
        if ("impl_track".equals(str)) {
            this.s.remove(dVar);
            return;
        }
        if ("click_track".equals(str)) {
            this.t.remove(dVar);
        } else if ("nurl_track".equals(str)) {
            this.u.remove(dVar);
        } else if ("lurl_track".equals(str)) {
            this.v.remove(dVar);
        }
    }

    private static boolean a(List<d> list) {
        return list != null && list.size() == 0;
    }

    final void a(Context context) {
        Iterator<d> it = this.s.iterator();
        while (it.hasNext()) {
            a(context, "impl_track", it.next());
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void a(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.s = new CopyOnWriteArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.s.add(new d(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
    }

    final boolean a(int i) {
        return this.q.b(i);
    }

    final boolean a(List<d> list, int i) {
        return list == null || list.size() == 0 || !a(i);
    }

    final int b(Context context) {
        Iterator<d> it = this.t.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            a(context, "click_track", it.next());
        }
        return i;
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final String b() {
        if (this.s == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.s.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void b(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.t = new CopyOnWriteArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.t.add(new d(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
    }

    final int c(Context context) {
        Iterator<d> it = this.u.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            a(context, "nurl_track", it.next());
        }
        return i;
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final String c() {
        if (this.t == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.t.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void c(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.u = new CopyOnWriteArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.u.add(new d(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
    }

    final int d(Context context) {
        Iterator<d> it = this.v.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            a(context, "lurl_track", it.next());
        }
        return i;
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final String d() {
        if (this.u == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.u.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void d(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.v = new CopyOnWriteArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.v.add(new d(jSONArray.getJSONObject(i)));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final String e() {
        if (this.v == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<d> it = this.v.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final long f() {
        return Math.max(Math.max(this.j, this.l), this.d);
    }

    public final boolean g() {
        return a(this.s) && a(this.t) && a(this.u) && a(this.v);
    }
}
