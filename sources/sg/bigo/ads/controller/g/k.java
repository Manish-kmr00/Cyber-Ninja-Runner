package sg.bigo.ads.controller.g;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends sg.bigo.ads.controller.g.a<sg.bigo.ads.controller.a.f> {
    private a i;

    public interface a {
        void a(String str, int i, int i2, int i3, String str2, Map<String, Object> map);

        void a(String str, int i, String str2, Map<String, Object> map);
    }

    public k(sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, a aVar) {
        super(gVar, bVar);
        this.i = aVar;
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(int i, int i2, String str) {
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(String str, int i, int i2, String str2, Map<String, Object> map) {
        super.a(str, i, i2, str2, map);
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(str, a(), i, i2, str2, map);
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(String str, String str2, Map<String, Object> map) {
        super.a(str, str2, map);
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(str, a(), str2, map);
        }
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(String str, Map<String, Object> map) {
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(sg.bigo.ads.controller.g.a.b bVar) {
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.b();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final sg.bigo.ads.common.u.f d() {
        return sg.bigo.ads.common.u.f.a("application/json");
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final long e() {
        return this.c != null ? this.c.f13381a.l.f13380a : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final /* synthetic */ sg.bigo.ads.common.u.a f() {
        return this.c.a("/Ad/GetSDKConfig");
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final boolean h() {
        return false;
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void i() {
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final boolean j() {
        return false;
    }
}
