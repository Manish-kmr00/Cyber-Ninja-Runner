package sg.bigo.ads.ad;

import android.content.Context;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: sg.bigo.ads.ad.a$a, reason: collision with other inner class name */
    static class C0807a implements AdBid {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f12479a;
        private final sg.bigo.ads.api.core.c b;
        private final sg.bigo.ads.core.e.a.a c;
        private boolean d = false;
        private boolean e = false;

        public C0807a(g gVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.e.a.a aVar) {
            this.f12479a = gVar;
            this.b = cVar;
            this.c = aVar;
        }

        @Override // sg.bigo.ads.api.AdBid
        public final double getPrice() {
            return this.b.ai();
        }

        @Override // sg.bigo.ads.api.AdBid
        public final void notifyLoss(Double d, String str, int i) {
            if (this.e) {
                return;
            }
            this.e = true;
            if (d != null) {
                this.c.b("first_price", String.valueOf(d));
            }
            if (str != null) {
                this.c.b("first_bidder", str);
            }
            this.c.b("loss_reason", String.valueOf(i));
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.a.4

                /* JADX INFO: renamed from: a */
                final /* synthetic */ Context f13557a;
                final /* synthetic */ boolean b = false;

                public AnonymousClass4() {
                    context = context;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.d(context, this.b);
                }
            });
            sg.bigo.ads.api.core.c cVar = this.b;
            sg.bigo.ads.core.d.b.a(cVar, cVar.aj(), d, str, i);
        }

        @Override // sg.bigo.ads.api.AdBid
        public final void notifyWin(Double d, String str) {
            if (this.d) {
                return;
            }
            this.d = true;
            if (d != null) {
                this.c.b("sec_price", String.valueOf(d));
            }
            if (str != null) {
                this.c.b("sec_bidder", str);
            }
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.a.3

                /* JADX INFO: renamed from: a */
                final /* synthetic */ Context f13556a;
                final /* synthetic */ boolean b = false;

                public AnonymousClass3() {
                    context = context;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(context, this.b);
                }
            });
            sg.bigo.ads.api.core.c cVar = this.b;
            sg.bigo.ads.core.d.b.a(cVar, cVar.aj(), d, str);
            g gVar = this.f12479a;
            sg.bigo.ads.core.b.b.a().a("win", sg.bigo.ads.core.b.a.a("win", gVar.b, gVar.c, gVar.f13106a, Integer.valueOf(this.b.aj()), d == null ? null : String.valueOf(d), str, null));
        }
    }
}
