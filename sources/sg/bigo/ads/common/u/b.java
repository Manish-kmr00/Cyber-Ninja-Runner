package sg.bigo.ads.common.u;

import sg.bigo.ads.common.u.b.c;
import sg.bigo.ads.common.u.c.c;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b<Req extends sg.bigo.ads.common.u.b.c, Res extends sg.bigo.ads.common.u.c.c> {
    public static b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.a> d = new a();

    static class a<Req extends sg.bigo.ads.common.u.b.c> extends b<Req, sg.bigo.ads.common.u.c.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Req f13271a;
        sg.bigo.ads.common.u.c.a b;
        h c;

        a() {
        }

        @Override // sg.bigo.ads.common.u.b
        public final /* bridge */ /* synthetic */ sg.bigo.ads.common.u.c.c a(sg.bigo.ads.common.u.c.a aVar) {
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.u.b
        public final /* bridge */ /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.c.c cVar2) {
            this.f13271a = cVar;
            this.b = (sg.bigo.ads.common.u.c.a) cVar2;
        }

        @Override // sg.bigo.ads.common.u.b
        public final void a(Req req, h hVar) {
            this.f13271a = req;
            this.c = hVar;
        }
    }

    public abstract Res a(sg.bigo.ads.common.u.c.a aVar);

    public void a(Req req) {
    }

    public void a(Req req, String str, int i) {
    }

    public abstract void a(Req req, Res res);

    public abstract void a(Req req, h hVar);

    public boolean a(Req req, int i) {
        return i >= 200 && i < 300;
    }
}
