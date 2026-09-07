package sg.bigo.ads.common.u.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.l;

/* JADX INFO: loaded from: classes12.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, sg.bigo.ads.common.n.e> f13270a = new HashMap();
    private static l b;
    private final Executor c;
    private final sg.bigo.ads.common.u.b.c d;
    private final sg.bigo.ads.common.u.b e;

    public e(Executor executor, sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b bVar) {
        this.c = executor == null ? a() : executor;
        this.d = cVar;
        this.e = bVar;
    }

    public static sg.bigo.ads.common.n.e a() {
        l lVar = b;
        return a("DefaultNet", 5, lVar != null ? lVar.p() : false);
    }

    private static synchronized sg.bigo.ads.common.n.e a(String str, int i, boolean z) {
        sg.bigo.ads.common.n.e eVar;
        if (TextUtils.isEmpty(str)) {
            str = "DefaultNet";
        }
        Map<String, sg.bigo.ads.common.n.e> map = f13270a;
        eVar = map.get(str);
        if (eVar == null) {
            eVar = new sg.bigo.ads.common.n.e(str, i, z);
            map.put(str, eVar);
        }
        return eVar;
    }

    public static void a(l lVar) {
        b = lVar;
    }

    public static sg.bigo.ads.common.n.e b() {
        int iA;
        boolean zB;
        l lVar = b;
        if (lVar != null) {
            iA = lVar.a();
            zB = lVar.b();
        } else {
            iA = 3;
            zB = false;
        }
        return a("ConfigNet", iA, zB);
    }

    public static sg.bigo.ads.common.n.e c() {
        int iC;
        boolean zD;
        l lVar = b;
        if (lVar != null) {
            iC = lVar.c();
            zD = lVar.d();
        } else {
            iC = 2;
            zD = false;
        }
        return a("ReportNet", iC, zD);
    }

    public static sg.bigo.ads.common.n.e d() {
        int iE;
        boolean zF;
        l lVar = b;
        if (lVar != null) {
            iE = lVar.e();
            zF = lVar.f();
        } else {
            iE = 12;
            zF = false;
        }
        return a("AdNet", iE, zF);
    }

    public static sg.bigo.ads.common.n.e e() {
        int iG;
        boolean zH;
        l lVar = b;
        if (lVar != null) {
            iG = lVar.g();
            zH = lVar.h();
        } else {
            iG = 3;
            zH = false;
        }
        return a("CallbackNet", iG, zH);
    }

    public static sg.bigo.ads.common.n.e f() {
        int i;
        boolean zJ;
        l lVar = b;
        if (lVar != null) {
            i = lVar.i();
            zJ = lVar.j();
        } else {
            i = 3;
            zJ = false;
        }
        return a("VastNet", i, zJ);
    }

    public static sg.bigo.ads.common.n.e g() {
        int iK;
        boolean zL;
        l lVar = b;
        if (lVar != null) {
            iK = lVar.k();
            zL = lVar.l();
        } else {
            iK = 10;
            zL = false;
        }
        return a("TrackerNet", iK, zL);
    }

    public static sg.bigo.ads.common.n.e h() {
        int iM;
        boolean zN;
        l lVar = b;
        if (lVar != null) {
            iM = lVar.m();
            zN = lVar.n();
        } else {
            iM = 5;
            zN = false;
        }
        return a("CreativeNet", iM, zN);
    }

    public static sg.bigo.ads.common.n.e i() {
        int i;
        boolean zO;
        l lVar = b;
        if (lVar != null) {
            zO = lVar.o();
            i = 40;
        } else {
            i = 5;
            zO = false;
        }
        return a("IconCreativeNet", i, zO);
    }

    public static sg.bigo.ads.common.n.e j() {
        return a("BannerIconCreativeNet", b != null ? 40 : 5, true);
    }

    public static void k() {
    }

    protected void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b bVar) {
    }

    public final void l() {
        this.c.execute(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg.bigo.ads.common.u.b bVar = this.e;
        if (bVar != null) {
            bVar.a(this.d);
        }
        a(this.d, this.e);
    }
}
