package sg.bigo.ads.ad.c;

import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12573a;
    int b;
    int c;

    public c(g gVar) {
        this.f12573a = 2;
        this.b = 0;
        this.c = 1;
        if (gVar == null) {
            return;
        }
        this.f12573a = gVar.f13106a.ao();
        this.b = gVar.f13106a.ap();
        this.c = gVar.f13106a.aq();
    }
}
