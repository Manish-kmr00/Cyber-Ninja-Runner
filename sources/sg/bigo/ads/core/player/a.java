package sg.bigo.ads.core.player;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f13674a;
    Map<String, b> b = new HashMap();
    Map<String, RunnableC0903a> c = new HashMap();

    /* JADX INFO: renamed from: sg.bigo.ads.core.player.a$a, reason: collision with other inner class name */
    class RunnableC0903a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<sg.bigo.ads.common.h.a> f13675a;

        public RunnableC0903a(sg.bigo.ads.common.h.a aVar) {
            this.f13675a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public final void run() {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (RunnableC0903a.this.f13675a == null || RunnableC0903a.this.f13675a.get() == null) {
                        return;
                    }
                    a.this.c.remove(RunnableC0903a.this.f13675a.get().f13189a);
                    a.this.f13674a.c(RunnableC0903a.this.f13675a.get());
                }
            });
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        sg.bigo.ads.common.h.a f13677a;

        public b(sg.bigo.ads.common.h.a aVar) {
            this.f13677a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    if (b.this.f13677a != null) {
                        a.this.b.remove(b.this.f13677a.f13189a);
                        a.this.f13674a.b(b.this.f13677a);
                        str = "call onDownloadFillTime";
                    } else {
                        str = "downloadInfo is null, not call onDownloadFillTime";
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public interface c {
        void b(sg.bigo.ads.common.h.a aVar);

        void c(sg.bigo.ads.common.h.a aVar);
    }

    public a(c cVar) {
        this.f13674a = cVar;
    }

    public final void a(sg.bigo.ads.common.h.a aVar) {
        if (aVar.c()) {
            if (aVar.e() > 0) {
                c(aVar);
            }
            if (aVar.f() > 0) {
                if (this.c.containsKey(aVar.f13189a)) {
                    sg.bigo.ads.common.n.d.a(this.c.remove(aVar.f13189a));
                }
                RunnableC0903a runnableC0903a = new RunnableC0903a(aVar);
                this.c.put(aVar.f13189a, runnableC0903a);
                sg.bigo.ads.common.n.d.a(3, runnableC0903a, ((long) aVar.f()) * 1000);
            }
        }
    }

    public final void b(sg.bigo.ads.common.h.a aVar) {
        if (this.c.containsKey(aVar.f13189a)) {
            sg.bigo.ads.common.n.d.a(this.c.get(aVar.f13189a));
            this.c.remove(aVar.f13189a);
        }
    }

    public final void c(sg.bigo.ads.common.h.a aVar) {
        if (this.b.containsKey(aVar.f13189a)) {
            sg.bigo.ads.common.n.d.a(this.b.remove(aVar.f13189a));
            sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", "fillTimeRunnableList.containsKey: " + aVar.f13189a);
        }
        b bVar = new b(aVar);
        this.b.put(aVar.f13189a, bVar);
        sg.bigo.ads.common.n.d.a(3, bVar, ((long) aVar.e()) * 1000);
        sg.bigo.ads.common.t.a.a(0, 3, "AdFillStrategyManager", "startFillTimeRunnable at: " + aVar.e());
    }
}
