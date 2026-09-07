package sg.bigo.ads.controller.g;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends e<sg.bigo.ads.controller.a.f> {
    public f(Map<String, Object> map, sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, sg.bigo.ads.controller.b bVar2) {
        super(map, gVar, bVar, bVar2);
    }

    @Override // sg.bigo.ads.controller.g.e, sg.bigo.ads.controller.g.a
    protected final void a(a.b bVar) {
        super.a(bVar);
        bVar.a("token", this.b.P());
        bVar.a("req_status", Integer.valueOf(sg.bigo.ads.common.f.b.c()));
        bVar.a(CommonUrlParts.UUID, this.b.X());
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final sg.bigo.ads.common.n.e c() {
        return sg.bigo.ads.common.u.a.e.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final long e() {
        return this.c != null ? this.c.f13381a.l.c : super.e();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final /* synthetic */ sg.bigo.ads.common.u.a f() {
        return this.c.a("/Ad/UniCallback");
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final void i() {
        sg.bigo.ads.common.x.a.D();
    }

    @Override // sg.bigo.ads.controller.g.a
    protected final boolean j() {
        return sg.bigo.ads.api.a.i.f13093a.g() && sg.bigo.ads.common.x.a.C();
    }
}
