package sg.bigo.ads.ad.banner;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<WeakReference<sg.bigo.ads.ad.c>> f12545a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f12546a = new f(0);
    }

    private f() {
        this.f12545a = new LinkedList();
    }

    /* synthetic */ f(byte b) {
        this();
    }

    public final boolean a(sg.bigo.ads.ad.c cVar) {
        if (cVar.isExpired() || cVar.n() || cVar.h) {
            return false;
        }
        synchronized (this.f12545a) {
            Iterator<WeakReference<sg.bigo.ads.ad.c>> it = this.f12545a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                sg.bigo.ads.ad.c cVar2 = it.next().get();
                if (cVar2 == cVar) {
                    z = true;
                } else if (cVar2 == null || cVar2.isExpired() || cVar2.n() || cVar2.h) {
                    it.remove();
                }
            }
            if (z || this.f12545a.size() >= 3) {
                return false;
            }
            this.f12545a.add(new WeakReference<>(cVar));
            return true;
        }
    }

    public final boolean b(sg.bigo.ads.ad.c cVar) {
        if (cVar == null) {
            return false;
        }
        synchronized (this.f12545a) {
            Iterator<WeakReference<sg.bigo.ads.ad.c>> it = this.f12545a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == cVar) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }
}
