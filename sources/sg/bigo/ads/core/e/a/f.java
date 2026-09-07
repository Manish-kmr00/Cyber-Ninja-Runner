package sg.bigo.ads.core.e.a;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static f f13571a = new f(0);
    }

    private f() {
    }

    /* synthetic */ f(byte b) {
        this();
    }

    public static List<e> a(long j, r rVar) {
        sg.bigo.ads.common.g.c.c.b(System.currentTimeMillis() - 86400000);
        Cursor cursorA = sg.bigo.ads.common.g.c.c.a(j);
        ArrayList arrayList = new ArrayList();
        if (cursorA == null) {
            return arrayList;
        }
        while (cursorA.moveToNext()) {
            e eVar = new e(rVar, cursorA);
            arrayList.add(eVar);
            sg.bigo.ads.common.t.a.a(0, 3, "TrackerManager", "getList:" + eVar.toString());
        }
        cursorA.close();
        return arrayList;
    }

    public static void a(e eVar) {
        if (sg.bigo.ads.common.g.c.c.c(eVar)) {
            sg.bigo.ads.common.g.c.c.b(eVar);
        } else {
            eVar.f13188a = sg.bigo.ads.common.g.c.c.a(eVar);
        }
    }

    public static void b(e eVar) {
        if (eVar.g()) {
            c(eVar);
        } else {
            sg.bigo.ads.common.g.c.c.b(eVar);
        }
    }

    private static void c(e eVar) {
        sg.bigo.ads.common.g.c.c.a(String.valueOf(eVar.f13188a));
    }
}
