package sg.bigo.ads.core.b.b;

import android.content.ContentValues;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.pubnative.lite.sdk.analytics.Reporting;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.core.b.a.a f13520a;
    public Set<sg.bigo.ads.common.g.b.a> b;
    public Set<sg.bigo.ads.common.g.b.a> c;
    long d = 0;
    a e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13522a;
        int b;
        int c;
        int d;

        private a() {
        }

        static a a() {
            a aVar = new a();
            String strK = sg.bigo.ads.common.x.a.k();
            if (!q.a((CharSequence) strK)) {
                String[] strArrSplit = strK.split(StringUtils.COMMA);
                if (strArrSplit.length == 4) {
                    try {
                        aVar.f13522a = Integer.parseInt(strArrSplit[0]);
                        aVar.b = Integer.parseInt(strArrSplit[1]);
                        aVar.c = Integer.parseInt(strArrSplit[2]);
                        aVar.d = Integer.parseInt(strArrSplit[3]);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return aVar;
        }

        final boolean b() {
            return ((this.f13522a + this.b) + this.c) + this.d == 0;
        }

        final void c() {
            this.f13522a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            sg.bigo.ads.common.x.a.d(toString());
        }

        public final String toString() {
            return this.f13522a + StringUtils.COMMA + this.b + StringUtils.COMMA + this.c + StringUtils.COMMA + this.d;
        }
    }

    public b(sg.bigo.ads.core.b.a.a aVar) {
        this.f13520a = aVar;
        this.b = p.a(aVar.f13512a);
        this.c = p.a(aVar.f13512a);
        sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                long jCurrentTimeMillis = System.currentTimeMillis() - ((long) bVar.f13520a.c);
                sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "clearEventInfo");
                sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "clearEventInfo count = ".concat(String.valueOf(sg.bigo.ads.common.g.a.a.b("tb_event", "ctime < ".concat(String.valueOf(jCurrentTimeMillis)), null))));
                bVar.b.addAll(bVar.f());
                bVar.d = sg.bigo.ads.common.x.a.j();
                if (bVar.d == 0) {
                    bVar.d = System.currentTimeMillis();
                }
                bVar.e = a.a();
                bVar.a();
            }
        });
    }

    final void a() {
        a aVar = this.e;
        if (aVar == null || aVar.b()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.d;
        if (jCurrentTimeMillis - j >= 300000) {
            sg.bigo.ads.core.d.b.a(j, this.e.f13522a, this.e.b, this.e.c, this.e.d);
            this.d = jCurrentTimeMillis;
            sg.bigo.ads.common.x.a.d(jCurrentTimeMillis);
            this.e.c();
        }
    }

    final synchronized void a(List<sg.bigo.ads.common.g.b.a> list, boolean z) {
        this.c.removeAll(list);
        if (!z) {
            this.b.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<sg.bigo.ads.common.g.b.a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().f13186a));
        }
        sg.bigo.ads.common.g.c.a.a(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b3  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final synchronized void a(sg.bigo.ads.common.g.b.a aVar) {
        this.b.add(aVar);
        byte b = 0;
        sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "insertEventInfo:" + aVar.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_action", aVar.b);
        contentValues.put("event_info", aVar.c);
        contentValues.put("states", Integer.valueOf(aVar.d));
        contentValues.put("ext", aVar.e);
        contentValues.put("ctime", Long.valueOf(aVar.f == 0 ? System.currentTimeMillis() : aVar.f));
        contentValues.put("mtime", Long.valueOf(aVar.g == 0 ? System.currentTimeMillis() : aVar.g));
        aVar.f13186a = sg.bigo.ads.common.g.a.a.a("tb_event", contentValues);
        a();
        a aVar2 = this.e;
        String str = aVar.b;
        switch (str.hashCode()) {
            case -1274499742:
                if (!str.equals("filled")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 3327206:
                if (!str.equals("load")) {
                    b = -1;
                }
                break;
            case 120623625:
                if (!str.equals("impression")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 860524583:
                if (!str.equals(Reporting.EventType.VIDEO_AD_CLICKED)) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            aVar2.f13522a++;
        } else if (b == 1) {
            aVar2.b++;
        } else if (b == 2) {
            aVar2.c++;
        } else if (b == 3) {
            aVar2.d++;
        }
        sg.bigo.ads.common.x.a.d(aVar2.toString());
    }

    final synchronized List<sg.bigo.ads.common.g.b.a> b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.b);
        Iterator<sg.bigo.ads.common.g.b.a> it = this.c.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        this.b.clear();
        this.c.addAll(arrayList);
        return arrayList;
    }

    final synchronized int c() {
        return this.b.size();
    }

    final synchronized boolean d() {
        return this.b.isEmpty();
    }

    public final synchronized void e() {
        if (this.b.isEmpty()) {
            List<sg.bigo.ads.common.g.b.a> listF = f();
            Iterator<sg.bigo.ads.common.g.b.a> it = this.c.iterator();
            while (it.hasNext()) {
                listF.remove(it.next());
            }
            this.b.addAll(listF);
        }
    }

    final List<sg.bigo.ads.common.g.b.a> f() {
        return sg.bigo.ads.common.g.c.a.a(this.f13520a.a());
    }

    public final synchronized void g() {
        this.c.clear();
        this.b.clear();
    }
}
