package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    private static final c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, Long> f13453a;
    public final AtomicInteger b = new AtomicInteger(0);

    private c() {
    }

    public static c a() {
        return c;
    }

    static boolean a(Map<String, Long> map, String str) {
        Long l;
        return map == null || str == null || (l = map.get(str)) == null || SystemClock.elapsedRealtime() - l.longValue() > 600000;
    }

    public final boolean a(String str) {
        return a(this.f13453a, str);
    }

    public final void b() {
        Map<String, Long> map = this.f13453a;
        if (map != null) {
            map.clear();
        }
        this.b.set(1);
    }
}
