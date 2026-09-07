package sg.bigo.ads.controller.g;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends a<sg.bigo.ads.controller.a.f> {
    private final sg.bigo.ads.controller.b i;

    public h(sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, long j, sg.bigo.ads.controller.b bVar2) {
        super(gVar, bVar, j);
        this.i = bVar2;
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(int i, int i2, String str) {
        this.i.a(a(), i, i2, str, null);
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(String str, Map<String, Object> map) {
        this.i.a(a(), str);
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void a(a.b bVar) {
        bVar.a("req_status", Integer.valueOf(sg.bigo.ads.common.f.b.c()));
        sg.bigo.ads.common.b bVarAc = this.b.ac();
        bVar.a("bat_stat", bVarAc != null ? String.valueOf(bVarAc.c) : "");
        bVar.a("bat_num", bVarAc != null ? String.valueOf(bVarAc.f13130a) : "");
        bVar.a("bat_scale", bVarAc != null ? String.valueOf(bVarAc.b) : "");
        bVar.a("coppa", Integer.valueOf(sg.bigo.ads.common.x.a.o()));
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.d();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final long e() {
        return this.c != null ? this.c.f13381a.l.d : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final /* synthetic */ sg.bigo.ads.common.u.a f() {
        return this.c.a("/Ad/GetUniConfig");
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void i() {
        sg.bigo.ads.common.x.a.v();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final boolean j() {
        return sg.bigo.ads.api.a.i.f13093a.c() && sg.bigo.ads.common.x.a.u();
    }
}
