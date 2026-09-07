package sg.bigo.ads.controller.g;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg.bigo.ads.controller.b.d f13471a;
    private final sg.bigo.ads.common.g b;
    private final sg.bigo.ads.api.b c;
    private final sg.bigo.ads.api.a.l d;
    private final sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> e;
    private final int f;

    public c(sg.bigo.ads.controller.b.d dVar, sg.bigo.ads.common.g gVar, sg.bigo.ads.api.b bVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar) {
        this.f13471a = dVar;
        this.b = gVar;
        this.c = bVar;
        this.d = lVar;
        this.e = eVar;
        bVar.a(gVar.Q(), gVar.R(), gVar.S());
        this.f = sg.bigo.ads.common.y.a.a();
    }

    private void a(int i, int i2, String str) {
        sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, sg.bigo.ads.api.a.l> eVar = this.e;
        if (eVar != null) {
            eVar.a(this.f, i, i2, str, this.d);
        }
    }

    @Override // sg.bigo.ads.controller.g.i
    public final int a() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0055  */
    @Override // sg.bigo.ads.controller.g.i
    public final void b() throws Throwable {
        String str;
        String strA;
        String str2 = this.c.b;
        if (TextUtils.isEmpty(str2)) {
            a(1018, 10200, "An adm show be passed when constructing an ad request if using a server bidding slot.");
            return;
        }
        this.c.c(sg.bigo.ads.common.f.b.c());
        sg.bigo.ads.common.g gVar = this.b;
        if (gVar != null) {
            this.c.b(gVar.X());
        }
        int[] iArr = new int[1];
        sg.bigo.ads.controller.h.a aVar = null;
        if (!TextUtils.isEmpty(str2)) {
            byte[] bArrB = sg.bigo.ads.common.j.a.b(str2, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            if (bArrB == null) {
                iArr[0] = 1;
            } else {
                strA = sg.bigo.ads.controller.c.c.a(bArrB);
                if (TextUtils.isEmpty(strA)) {
                    iArr[0] = 2;
                } else if (!TextUtils.isEmpty(strA)) {
                    aVar = new sg.bigo.ads.controller.h.a(strA);
                }
            }
            strA = null;
            if (!TextUtils.isEmpty(strA)) {
                aVar = new sg.bigo.ads.controller.h.a(strA);
            }
        }
        if (aVar == null || !aVar.a()) {
            if (aVar != null) {
                a(1005, aVar.f13472a, aVar.b);
                return;
            }
            int i = iArr[0];
            if (i == 1) {
                str = "Invalid payload response.";
            } else {
                str = i == 2 ? "Invalid payload data." : "Unknown payload error.";
            }
            a(1005, 10201, str);
            return;
        }
        String str3 = aVar.c;
        Map<String, Object> map = aVar.d;
        if (this.e != null) {
            Object obj = map.get("logid");
            sg.bigo.ads.controller.c.b bVarA = sg.bigo.ads.controller.c.b.a(obj instanceof Long ? ((Long) obj).longValue() : 0L, this.c.g, this.d, str3);
            if (bVarA == null) {
                a(1005, 0, "Empty ad data.");
            } else if (TextUtils.equals(bVarA.b(), bVarA.z)) {
                this.e.a(this.f, this.c, bVarA);
            } else {
                a(1005, 0, "Unmatched slot of ad data.");
            }
        }
    }

    @Override // sg.bigo.ads.controller.g.i
    public final sg.bigo.ads.api.b k() {
        return this.c;
    }

    @Override // sg.bigo.ads.controller.g.i
    public final sg.bigo.ads.api.a.l l() {
        return this.d;
    }
}
