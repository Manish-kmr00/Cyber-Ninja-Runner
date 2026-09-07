package sg.bigo.ads.core.player;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import sg.bigo.ads.common.u.a.e;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.core.f.a.n;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f13714a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final sg.bigo.ads.core.e.a.a e;
    public sg.bigo.ads.core.c.b f;
    public boolean g;
    public final Context h;
    public final List<Integer> j;
    public final List<Integer> k;
    private boolean l = false;
    public boolean i = false;

    public c(Context context, p pVar, sg.bigo.ads.core.e.a.a aVar) {
        ArrayList arrayList = new ArrayList(4);
        this.j = arrayList;
        ArrayList arrayList2 = new ArrayList(5);
        this.k = arrayList2;
        this.h = context;
        this.f13714a = pVar;
        this.e = aVar;
        arrayList.add(0);
        arrayList.add(25);
        arrayList.add(50);
        arrayList.add(75);
        arrayList2.add(2000);
        arrayList2.add(3000);
        arrayList2.add(5000);
        arrayList2.add(8000);
        arrayList2.add(10000);
    }

    public static String a(String str) {
        return q.a((CharSequence) str) ? "" : q.a(q.a(str, "[TIMESTAMP]", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()), true), "[CACHEBUSTING]", new StringBuilder().append(((int) (Math.random() * 9.0E7d)) + 10000000).toString(), true);
    }

    public static void a(Context context, List<n> list) {
        if (list != null) {
            for (n nVar : list) {
                if (nVar != null) {
                    String str = nVar.b;
                    if (q.a((CharSequence) str) || (nVar.c && !nVar.d)) {
                        sg.bigo.ads.common.t.a.a(0, "VASTController", "invalidate tracking url or is tracked");
                    } else {
                        sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(new sg.bigo.ads.common.u.b.d(str), context);
                        aVar.k = e.g();
                        g.a(aVar, null);
                    }
                }
            }
        }
    }

    public static void a(sg.bigo.ads.core.a.a aVar, int i) {
        sg.bigo.ads.core.d.b.a(aVar, i, aVar.aJ(), aVar.aL());
    }

    public final void a() {
        if (this.l) {
            return;
        }
        a(this.f13714a.j, "va_cli");
    }

    public final void a(n nVar, String str) {
        String str2 = nVar.b;
        if (q.a((CharSequence) str2) || (nVar.c && !nVar.d)) {
            sg.bigo.ads.common.t.a.a(0, "VASTController", "invalidate tracking url or is tracked");
            return;
        }
        String strA = a(str2);
        nVar.c = true;
        if (q.a((CharSequence) strA)) {
            return;
        }
        this.e.a(this.h, str, strA, "bigoad");
        sg.bigo.ads.common.t.a.a(0, 3, "VASTController", "Send track info, action: " + str + ", url: " + strA);
    }

    public final boolean a(List<? extends n> list, String str) {
        Iterator<? extends n> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (str.equals("va_cpn_cli")) {
                this.l = true;
            }
            a(it.next(), str);
            it.remove();
            z = true;
        }
        return z;
    }

    public final void b() {
        a(this.f13714a.y, "va_cpn_imp");
    }

    public final boolean c() {
        return a(this.f13714a.z, "va_cpn_cli");
    }
}
