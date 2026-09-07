package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: GeckoConfig.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static IThreadPoolCallback q;
    private static ThreadPoolExecutor r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f920a;
    private final com.bykv.vk.openvk.preload.geckox.a.a.c b;
    private final IStatisticMonitor c;
    private final INetWork d;
    private final List<String> e;
    private final List<String> f;
    private final com.bykv.vk.openvk.preload.geckox.a.a.a g;
    private final Long h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final File n;
    private final boolean o;
    private JSONObject p;

    /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        Context context = aVar.d;
        this.f920a = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        List<String> list = aVar.b;
        this.e = list;
        this.f = aVar.c;
        this.b = null;
        this.g = aVar.g;
        Long l = aVar.h;
        this.h = l;
        if (TextUtils.isEmpty(aVar.i)) {
            this.i = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
        } else {
            this.i = aVar.i;
        }
        String str = aVar.j;
        this.j = str;
        this.l = null;
        this.m = null;
        if (aVar.l == null) {
            this.n = new File(context.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.n = aVar.l;
        }
        String str2 = aVar.k;
        this.k = str2;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("host == null");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (l == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        this.d = aVar.f921a;
        this.c = aVar.e;
        this.o = aVar.f;
    }

    public final Context a() {
        return this.f920a;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.a b() {
        return this.g;
    }

    public final boolean c() {
        return this.o;
    }

    public final List<String> d() {
        return this.f;
    }

    public final List<String> e() {
        return this.e;
    }

    public final JSONObject f() {
        return this.p;
    }

    public final void a(JSONObject jSONObject) {
        this.p = jSONObject;
    }

    public static Executor g() {
        return p();
    }

    public static Executor h() {
        return p();
    }

    public final INetWork i() {
        return this.d;
    }

    public final String j() {
        return this.k;
    }

    public final long k() {
        return this.h.longValue();
    }

    public final File l() {
        return this.n;
    }

    public final String m() {
        return this.i;
    }

    public final IStatisticMonitor n() {
        return this.c;
    }

    public final String o() {
        return this.j;
    }

    public static ExecutorService p() {
        IThreadPoolCallback iThreadPoolCallback = q;
        ExecutorService threadPool = iThreadPoolCallback != null ? iThreadPoolCallback.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (r == null) {
            synchronized (b.class) {
                if (r == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    r = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return r;
    }

    public static void a(IThreadPoolCallback iThreadPoolCallback) {
        q = iThreadPoolCallback;
    }

    /* JADX INFO: compiled from: GeckoConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INetWork f921a;
        private List<String> b;
        private List<String> c;
        private Context d;
        private IStatisticMonitor e;
        private boolean f = true;
        private com.bykv.vk.openvk.preload.geckox.a.a.a g;
        private Long h;
        private String i;
        private String j;
        private String k;
        private File l;

        public a(Context context) {
            this.d = context.getApplicationContext();
        }

        public final a a(String... strArr) {
            this.c = Arrays.asList(strArr);
            return this;
        }

        public final a b(String... strArr) {
            this.b = Arrays.asList(strArr);
            return this;
        }

        public final a a(INetWork iNetWork) {
            this.f921a = iNetWork;
            return this;
        }

        public final a a(IStatisticMonitor iStatisticMonitor) {
            this.e = iStatisticMonitor;
            return this;
        }

        public final a a() {
            this.f = false;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.geckox.a.a.a aVar) {
            this.g = aVar;
            return this;
        }

        public final a b() {
            this.h = 38L;
            return this;
        }

        public final a a(String str) {
            this.i = str;
            return this;
        }

        public final a b(String str) {
            this.j = str;
            return this;
        }

        public final a c(String str) {
            this.k = str;
            return this;
        }

        public final a a(File file) {
            this.l = file;
            return this;
        }
    }
}
