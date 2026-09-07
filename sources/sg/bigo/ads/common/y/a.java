package sg.bigo.ads.common.y;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f13363a = new AtomicInteger();

    public static int a() {
        return f13363a.incrementAndGet();
    }

    public static void a(int i) {
        f13363a.set(i);
    }
}
