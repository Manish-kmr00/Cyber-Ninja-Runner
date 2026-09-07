package sg.bigo.ads.common.h.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, a> f13204a = new HashMap();

    protected static void a() {
        f13204a.clear();
    }

    public static void a(String str) {
        a aVarC = c(str);
        if (aVarC == null) {
            sg.bigo.ads.common.t.a.a(0, "TaskManager", "you add " + str + " to TaskQueue ?");
            return;
        }
        if (aVarC.e == h.d || aVarC.e == h.f) {
            sg.bigo.ads.common.t.a.a(0, 3, "TaskManager", "start downloadBean = ".concat(String.valueOf(aVarC)));
            return;
        }
        aVarC.e = h.b;
        f.a().a(aVarC.f13197a);
        g.f13202a.execute(aVarC.c);
    }

    protected static void a(a aVar) {
        aVar.f = "It's remove !!!";
        if (aVar.e != h.f) {
            aVar.e = h.g;
            f.a().a(aVar.f13197a);
        }
        f.a().b(aVar.f13197a);
        g.a(aVar.c);
    }

    protected static Collection<a> b() {
        return f13204a.values();
    }

    protected static void b(String str) {
        a aVarC = c(str);
        if (aVarC != null) {
            a(aVarC);
        } else {
            sg.bigo.ads.common.t.a.a(0, "TaskManager", "you add " + str + " to TaskQueue ?");
        }
        if (f13204a.containsKey(str)) {
            f13204a.remove(str);
        }
    }

    public static void b(a aVar) {
        if (f13204a.containsKey(aVar.f13197a)) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "TaskManager", " " + f13204a.keySet().size());
        f13204a.put(aVar.f13197a, aVar);
    }

    public static a c(String str) {
        if (f13204a.containsKey(str)) {
            return f13204a.get(str);
        }
        return null;
    }
}
