package com.inmobi.media;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3364f2 implements InterfaceC3564t2 {
    public static ThreadPoolExecutor b;
    public static X1 c;
    public static HandlerThread d;
    public static AdConfig.ImaiConfig g;
    public static final C3350e2 l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3364f2 f3308a = new C3364f2();
    public static List e = new ArrayList();
    public static final AtomicBoolean f = new AtomicBoolean(false);
    public static final AtomicBoolean h = new AtomicBoolean(true);
    public static final Object i = new Object();
    public static final LinkedHashMap j = new LinkedHashMap();
    public static final Lazy k = LazyKt.lazy(C3322c2.f3280a);

    public static final HashMap a(C3364f2 c3364f2, T1 t1) {
        c3364f2.getClass();
        HashMap map = new HashMap();
        try {
            AdConfig.ImaiConfig imaiConfig = g;
            int maxRetries = ((imaiConfig != null ? imaiConfig.getMaxRetries() : 0) - t1.f) + 1;
            if (maxRetries > 0) {
                map.put("X-im-retry-count", String.valueOf(maxRetries));
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
        }
        return map;
    }

    public static final /* synthetic */ String f() {
        return "f2";
    }

    public static void i() {
        try {
            AtomicBoolean atomicBoolean = f;
            atomicBoolean.set(false);
            synchronized (i) {
                if (!atomicBoolean.get()) {
                    HandlerThread handlerThread = d;
                    if (handlerThread != null) {
                        handlerThread.getLooper().quit();
                        handlerThread.interrupt();
                    }
                    d = null;
                    c = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
        }
    }

    public final boolean g() {
        return ((Boolean) k.getValue()).booleanValue();
    }

    public final void h() {
        HandlerThread handlerThread;
        try {
            boolean z = W8.f3228a;
            if (W8.a(false) != null) {
                return;
            }
            synchronized (i) {
                AtomicBoolean atomicBoolean = f;
                if (atomicBoolean.compareAndSet(false, true)) {
                    Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                    if (d == null) {
                        HandlerThread handlerThread2 = new HandlerThread("pingHandlerThread");
                        d = handlerThread2;
                        U3.a(handlerThread2, "pingHandlerThread");
                    }
                    if (c == null && (handlerThread = d) != null) {
                        Looper looper = handlerThread.getLooper();
                        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
                        c = new X1(looper);
                    }
                    U1 u1B = AbstractC3415ib.b();
                    if (u1B == null || D1.a((D1) u1B) == 0) {
                        Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                        atomicBoolean.set(false);
                        i();
                    } else {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 1;
                        X1 x1 = c;
                        if (x1 != null) {
                            x1.sendMessage(messageObtain);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
        }
    }

    public static final void b(C3364f2 c3364f2, T1 t1) {
        c3364f2.getClass();
        LinkedHashMap linkedHashMap = j;
        J1 j1 = (J1) linkedHashMap.get(Integer.valueOf(t1.f3198a));
        if (j1 != null) {
            j1.a(t1);
        }
        linkedHashMap.remove(Integer.valueOf(t1.f3198a));
    }

    public static final void c(C3364f2 c3364f2, T1 click) {
        c3364f2.getClass();
        int i2 = click.f;
        if (i2 > 0) {
            click.f = i2 - 1;
            click.g = System.currentTimeMillis();
            U1 u1B = AbstractC3415ib.b();
            u1B.getClass();
            Intrinsics.checkNotNullParameter(click, "click");
            u1B.b(click, "id = ?", new String[]{String.valueOf(click.f3198a)});
        }
    }

    public static /* synthetic */ void b(C3364f2 c3364f2, String str, boolean z, J1 j1, L4 l4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j1 = null;
        }
        c3364f2.b(str, z, j1, l4);
    }

    public final void b(final String url, final boolean z, final J1 j1, final L4 l4) {
        Intrinsics.checkNotNullParameter(url, "url");
        C9 c9 = AbstractC3378g2.f3322a;
        AbstractC3378g2.a(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3364f2.b(url, z, l4, j1);
            }
        }, B9.b);
    }

    public static final /* synthetic */ void a(C3364f2 c3364f2) {
        c3364f2.getClass();
        i();
    }

    static {
        Intrinsics.checkNotNullExpressionValue("f2", "TAG");
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C3364f2.a();
            }
        });
        l = new C3350e2();
    }

    public static final void a() {
        C3364f2 c3364f2 = f3308a;
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, timeUnit, linkedBlockingQueue, new V4("f2"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            b = threadPoolExecutor;
            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
            d = handlerThread;
            U3.a(handlerThread, "pingHandlerThread");
            HandlerThread handlerThread2 = d;
            Intrinsics.checkNotNull(handlerThread2);
            Looper looper = handlerThread2.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            c = new X1(looper);
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            Config configA = C3549s2.a("ads", C3517pb.b(), c3364f2);
            Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
            g = ((AdConfig) configA).getImai();
            C3517pb.f().a(new int[]{10, 11, 2, 1}, C3336d2.f3290a);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
        }
    }

    public static final void c(String url, boolean z, L4 l4) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f3308a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                T1 t1 = new T1(url, null, z, true, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                    ((M4) l4).c("f2", "Received click (" + url + ") for pinging in WebView");
                }
                a(t1, (J1) null, l4);
            }
        } catch (Exception e2) {
            if (l4 != null) {
                ((M4) l4).b("f2", ld.a(e2, O5.a("f2", "TAG", "SDK encountered unexpected error in pinging click over WebView; ")));
            }
        }
    }

    public static final void b(String url, boolean z, L4 l4, J1 j1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f3308a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                T1 t1 = new T1(url, null, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                    ((M4) l4).a("f2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(t1, j1, l4);
            }
        } catch (Exception e2) {
            if (l4 != null) {
                ((M4) l4).b("f2", ld.a(e2, O5.a("f2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
        }
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        AdConfig adConfig = config instanceof AdConfig ? (AdConfig) config : null;
        g = adConfig != null ? adConfig.getImai() : null;
    }

    public final void a(String url, boolean z, L4 l4) {
        Intrinsics.checkNotNullParameter(url, "url");
        a(url, z, (J1) null, l4);
    }

    public static /* synthetic */ void a(C3364f2 c3364f2, String str, boolean z, J1 j1, L4 l4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j1 = null;
        }
        c3364f2.a(str, z, j1, l4);
    }

    public final void a(final String url, final boolean z, final J1 j1, final L4 l4) {
        Intrinsics.checkNotNullParameter(url, "url");
        C9 c9 = AbstractC3378g2.f3322a;
        AbstractC3378g2.a(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C3364f2.a(url, z, l4, j1);
            }
        }, B9.c);
    }

    public static final void a(String url, boolean z, L4 l4, J1 j1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f3308a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                T1 t1 = new T1(url, null, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 197);
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                    ((M4) l4).a("f2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(t1, j1, l4);
            }
        } catch (Exception e2) {
            if (l4 != null) {
                ((M4) l4).b("f2", ld.a(e2, O5.a("f2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
        }
    }

    public final void b(final String url, final boolean z, final L4 l4) {
        Intrinsics.checkNotNullParameter(url, "url");
        C9 c9 = AbstractC3378g2.f3322a;
        AbstractC3378g2.a(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3364f2.c(url, z, l4);
            }
        }, B9.c);
    }

    public static /* synthetic */ void a(C3364f2 c3364f2, String str, Map map, boolean z, J1 j1, B9 b9, L4 l4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            j1 = null;
        }
        c3364f2.a(str, map, z, j1, b9, l4);
    }

    public final void a(final String url, final Map<String, String> map, final boolean z, final J1 j1, B9 priority, final L4 l4) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(priority, "priority");
        C9 c9 = AbstractC3378g2.f3322a;
        AbstractC3378g2.a(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3364f2.a(url, map, z, l4, j1);
            }
        }, priority);
    }

    public static final void a(String url, Map map, boolean z, L4 l4, J1 j1) {
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            if (f3308a.g()) {
                AdConfig.ImaiConfig imaiConfig = g;
                T1 t1 = new T1(url, map, z, false, (imaiConfig != null ? imaiConfig.getMaxRetries() : 0) + 1, 193);
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                    ((M4) l4).a("f2", "Received click (" + url + ") for pinging over HTTP");
                }
                a(t1, j1, l4);
            }
        } catch (Exception e2) {
            if (l4 != null) {
                ((M4) l4).b("f2", ld.a(e2, O5.a("f2", "TAG", "SDK encountered unexpected error in pinging click; ")));
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e2, "event"));
        }
    }

    public static void a(final T1 click, J1 j1, final L4 l4) {
        X1 x1 = c;
        if (x1 != null) {
            x1.f3232a = l4;
        }
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
            ((M4) l4).c("f2", "record Click");
        }
        AdConfig.ImaiConfig imaiConfig = g;
        if (imaiConfig != null) {
            U1 u1B = AbstractC3415ib.b();
            int maxDbEvents = imaiConfig.getMaxDbEvents();
            synchronized (u1B) {
                Intrinsics.checkNotNullParameter(click, "click");
                if (D1.a((D1) u1B) >= maxDbEvents) {
                    Intrinsics.checkNotNullExpressionValue("U1", "TAG");
                    T1 click2 = (T1) u1B.b("ts= (SELECT MIN(ts) FROM click LIMIT 1)", null);
                    if (click2 != null) {
                        Intrinsics.checkNotNullExpressionValue("U1", "TAG");
                        f3308a.a(click, "DB_OVERLOAD");
                        Intrinsics.checkNotNullParameter(click2, "click");
                        u1B.a("id = ?", new String[]{String.valueOf(click2.f3198a)});
                    }
                }
                u1B.a(click);
            }
            if (j1 != null) {
                j.put(Integer.valueOf(click.f3198a), j1);
            }
        }
        boolean z = W8.f3228a;
        if (W8.a(false) != null) {
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                ((M4) l4).b("f2", "No network available. Saving click for later processing ...");
            }
            f.set(false);
            i();
            return;
        }
        if (l4 != null) {
            ((M4) l4).a("f2", O5.a("f2", "TAG", "submit click - ").append(click.f3198a).toString());
        }
        ThreadPoolExecutor threadPoolExecutor = b;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.submit(new Runnable() { // from class: com.inmobi.media.f2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C3364f2.a(click, l4);
                }
            });
        }
    }

    public static final void a(T1 click, L4 l4) {
        Intrinsics.checkNotNullParameter(click, "$click");
        SystemClock.elapsedRealtime();
        if (click.e) {
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("f2", "TAG");
                ((M4) l4).c("f2", "ping in web view");
            }
            new Z1(l, l4).a(click);
            return;
        }
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("f2", "TAG");
            ((M4) l4).c("f2", "ping in http executor");
        }
        new C3293a2(l, l4).a(click);
    }

    public final void a(T1 click, String error) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(error, "error");
        LinkedHashMap linkedHashMap = j;
        J1 j1 = (J1) linkedHashMap.get(Integer.valueOf(click.f3198a));
        if (j1 != null) {
            j1.a(click, error);
        }
        linkedHashMap.remove(Integer.valueOf(click.f3198a));
    }
}
