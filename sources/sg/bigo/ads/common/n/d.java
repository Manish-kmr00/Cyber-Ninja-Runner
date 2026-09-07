package sg.bigo.ads.common.n;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<sg.bigo.ads.common.n.a> f13220a;
    private static HandlerThread b;
    private static b c;
    private static HandlerThread d;
    private static b e;
    private static HandlerThread f;
    private static b g;
    private static b h;
    private static b i;
    private static final WeakHashMap<Object, a> j = new WeakHashMap<>();
    private static boolean k = false;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f13227a;
        final Integer b;

        public a(Runnable runnable, Integer num) {
            this.f13227a = runnable;
            this.b = num;
        }
    }

    static {
        t.a();
    }

    public static void a(int i2, Runnable runnable) {
        b(i2, runnable, 0L);
    }

    public static void a(int i2, Runnable runnable, long j2) {
        b(i2, runnable, j2);
    }

    public static synchronized void a(Runnable runnable) {
        b bVar;
        if (runnable == null) {
            return;
        }
        WeakHashMap<Object, a> weakHashMap = j;
        a aVar = weakHashMap.get(runnable);
        if (aVar == null) {
            return;
        }
        Runnable runnable2 = aVar.f13227a;
        if (runnable2 != null) {
            int iIntValue = aVar.b.intValue();
            if (iIntValue == 0) {
                bVar = c;
                if (bVar != null) {
                    bVar.removeCallbacks(runnable2);
                }
                throw th;
            }
            if (iIntValue == 1) {
                bVar = e;
                if (bVar != null) {
                    bVar.removeCallbacks(runnable2);
                }
                throw th;
            }
            if (iIntValue == 2) {
                bVar = h;
                if (bVar != null) {
                    bVar.removeCallbacks(runnable2);
                }
                throw th;
            }
            if (iIntValue == 3) {
                bVar = g;
                if (bVar != null) {
                    bVar.removeCallbacks(runnable2);
                }
            } else if (iIntValue == 1024) {
                runnable2.run();
            }
            synchronized (weakHashMap) {
                weakHashMap.remove(runnable);
            }
        }
    }

    public static synchronized void a(sg.bigo.ads.common.n.a aVar) {
        if (f13220a == null) {
            f13220a = new ArrayList();
        }
        f13220a.add(aVar);
    }

    public static boolean a() {
        return d == Thread.currentThread();
    }

    private static synchronized void b(int i2, final Runnable runnable, long j2) {
        final b bVar;
        if (runnable == null) {
            return;
        }
        if (h == null) {
            j();
        }
        if (i2 == 0) {
            if (b == null) {
                g();
            }
            bVar = c;
        } else if (i2 == 1) {
            if (d == null) {
                h();
            }
            bVar = e;
        } else if (i2 != 3) {
            bVar = h;
        } else {
            if (f == null) {
                i();
            }
            bVar = g;
        }
        if (bVar == null) {
            return;
        }
        final Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = h.getLooper();
        }
        final Runnable runnable2 = new Runnable() { // from class: sg.bigo.ads.common.n.d.1
            final /* synthetic */ Runnable b = null;
            final /* synthetic */ boolean c = false;

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable3 = d.i != null ? new Runnable() { // from class: sg.bigo.ads.common.n.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.h.post(new Runnable() { // from class: sg.bigo.ads.common.n.d.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                sg.bigo.ads.common.t.a.a(0, "ThreadManager", "这里使用了ThreadManager.post函数运行了一个超过30s的任务");
                            }
                        });
                    }
                } : null;
                if (d.i != null) {
                    d.i.postDelayed(runnable3, 30000L);
                }
                synchronized (d.j) {
                    d.j.remove(runnable);
                }
                if (d.k) {
                    runnable.run();
                } else {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        sg.bigo.ads.common.t.a.a(2, "ThreadManager", "An error occurred while running a task: \n" + Log.getStackTraceString(th));
                        if (d.f13220a != null) {
                            Iterator<sg.bigo.ads.common.n.a> it = d.f13220a.iterator();
                            while (it.hasNext()) {
                                it.next().a(th);
                            }
                        }
                    }
                }
                if (d.i != null) {
                    d.i.removeCallbacks(runnable3);
                }
                if (this.b != null) {
                    if (this.c || looperMyLooper == d.h.getLooper()) {
                        d.h.post(this.b);
                    } else {
                        new Handler(looperMyLooper).post(this.b);
                    }
                }
            }
        };
        Runnable runnable3 = new Runnable() { // from class: sg.bigo.ads.common.n.d.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f13224a = null;
            final /* synthetic */ boolean b = false;

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f13224a == null) {
                    runnable2.run();
                } else if (this.b || looperMyLooper == d.h.getLooper()) {
                    d.h.post(new Runnable() { // from class: sg.bigo.ads.common.n.d.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2.this.f13224a.run();
                            bVar.post(runnable2);
                        }
                    });
                } else {
                    new Handler(looperMyLooper).post(new Runnable() { // from class: sg.bigo.ads.common.n.d.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2.this.f13224a.run();
                            bVar.post(runnable2);
                        }
                    });
                }
            }
        };
        WeakHashMap<Object, a> weakHashMap = j;
        synchronized (weakHashMap) {
            weakHashMap.put(runnable, new a(runnable3, Integer.valueOf(i2)));
        }
        bVar.postDelayed(runnable3, j2);
    }

    public static void b(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            b(2, runnable, 0L);
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static synchronized void g() {
        if (b == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Background", 10);
            b = handlerThread;
            handlerThread.start();
            c = new b("BGAd-Background", b.getLooper());
        }
    }

    private static synchronized void h() {
        if (d == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Work", 5);
            d = handlerThread;
            handlerThread.start();
            e = new b("BGAd-Work", d.getLooper());
        }
    }

    private static synchronized void i() {
        if (f == null) {
            HandlerThread handlerThread = new HandlerThread("BGAd-Normal", 0);
            f = handlerThread;
            handlerThread.start();
            g = new b("BGAd-Normal", f.getLooper());
        }
    }

    private static synchronized void j() {
        if (h == null) {
            h = new b("BGAd-Background.Main + 38", Looper.getMainLooper());
        }
    }
}
