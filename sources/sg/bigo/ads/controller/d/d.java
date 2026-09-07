package sg.bigo.ads.controller.d;

import sg.bigo.ads.common.k;
import sg.bigo.ads.controller.a.j;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final sg.bigo.ads.controller.a.b f13433a;

    static class a implements k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13434a;
        private final String b;
        private final boolean c;
        private final String d;

        public a(String str, j jVar) {
            this.f13434a = str;
            if (jVar != null) {
                boolean zC = jVar.c();
                this.c = zC;
                this.b = jVar.a();
                str = sg.bigo.ads.controller.a.d.a(str, zC ? jVar.b() : jVar.a());
            } else {
                this.c = false;
                this.b = "";
            }
            this.d = str;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String a() {
            return this.d;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String b() {
            return this.f13434a;
        }

        @Override // sg.bigo.ads.common.k.b
        public final String c() {
            return this.b;
        }

        @Override // sg.bigo.ads.common.k.b
        public final boolean d() {
            return this.c;
        }
    }

    public d(sg.bigo.ads.controller.a.b bVar) {
        this.f13433a = bVar;
    }

    @Override // sg.bigo.ads.common.k
    public final k.b a(String str) {
        sg.bigo.ads.controller.a.b bVar = this.f13433a;
        return new a(str, bVar != null ? bVar.f13381a.i.b : null);
    }
}
