package sg.bigo.ads.controller.e;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public final class g {
    private static final g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<String, a> f13460a = new ConcurrentHashMap();
    private boolean c = false;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicInteger f13461a = new AtomicInteger(0);
        final AtomicInteger b = new AtomicInteger(0);
        final AtomicInteger c = new AtomicInteger(0);

        public a() {
        }
    }

    public static g a() {
        return b;
    }

    public final a a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        a aVar = this.f13460a.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.f13460a.put(str, aVar2);
        return aVar2;
    }

    public final void a(boolean z) {
        this.c = z;
        if (z) {
            Iterator<Map.Entry<String, a>> it = this.f13460a.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    value.c.set(0);
                }
            }
        }
    }
}
