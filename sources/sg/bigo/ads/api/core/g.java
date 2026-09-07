package sg.bigo.ads.api.core;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13106a;
    public final sg.bigo.ads.api.a.l b;
    public final sg.bigo.ads.api.b c;
    public sg.bigo.ads.common.g d;
    public final Context e;
    public final Context f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public sg.bigo.ads.common.g f13107a;
        private final c b;
        private final sg.bigo.ads.api.a.l c;
        private final sg.bigo.ads.api.b d;
        private final Context e;
        private final Context f;

        public a(c cVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.b bVar, Context context, Context context2) {
            this.b = cVar;
            this.c = lVar;
            this.d = bVar;
            this.e = context;
            this.f = context2;
        }

        public final g a() {
            g gVar = new g(this.b, this.c, this.d, this.e, this.f, (byte) 0);
            gVar.d = this.f13107a;
            return gVar;
        }
    }

    private g(c cVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.b bVar, Context context, Context context2) {
        this.f13106a = cVar;
        this.b = lVar;
        this.c = bVar;
        this.e = context;
        this.f = context2;
    }

    /* synthetic */ g(c cVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.b bVar, Context context, Context context2, byte b) {
        this(cVar, lVar, bVar, context, context2);
    }

    public final g a(c cVar) {
        g gVar = new g(cVar, this.b, this.c, this.e, this.f);
        gVar.d = this.d;
        return gVar;
    }
}
