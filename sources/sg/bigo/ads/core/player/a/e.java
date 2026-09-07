package sg.bigo.ads.core.player.a;

import android.os.SystemClock;
import com.json.b9;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import sg.bigo.ads.common.m;

/* JADX INFO: loaded from: classes12.dex */
final class e {
    volatile c b;
    volatile sg.bigo.ads.common.h.a c;
    private final String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicInteger f13685a = new AtomicInteger(0);
    volatile long d = 0;
    volatile long e = SystemClock.elapsedRealtime();
    final AtomicInteger f = new AtomicInteger(0);

    public e(String str) {
        this.g = (String) m.a(str);
    }

    final synchronized boolean a() {
        c cVar;
        if (this.b == null) {
            String str = this.g;
            HashMap map = new HashMap();
            for (String str2 : str.substring(str.indexOf("?") + 1).split(b9.i.c)) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            this.c = sg.bigo.ads.core.player.b.a().g.a((String) map.get("path"), (String) map.get("name"));
            if (this.c == null) {
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "downloadInfo = null");
                cVar = null;
            } else {
                cVar = new c(this.c);
            }
        } else {
            cVar = this.b;
        }
        this.b = cVar;
        return this.b != null;
    }

    final synchronized void b() {
        if (this.f13685a.decrementAndGet() <= 0) {
            c cVar = this.b;
            synchronized (cVar.c) {
                sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "Shutdown proxy for ");
                cVar.d = true;
                cVar.b.b();
            }
            this.b = null;
        }
    }
}
