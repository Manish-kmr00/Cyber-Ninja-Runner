package com.mbridge.msdk.tracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.unity3d.services.UnityAdsConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ReportManager.java */
/* JADX INFO: loaded from: classes7.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5661a;
    private final int b;
    private final int c;
    private final int d;
    private final k e;
    private Handler i;
    private final AtomicInteger f = new AtomicInteger(0);
    private final AtomicInteger g = new AtomicInteger(0);
    private final Object h = new Object();
    private boolean j = true;
    private long k = 0;
    private volatile boolean l = false;
    private volatile boolean m = false;

    /* JADX INFO: compiled from: ReportManager.java */
    private static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s f5663a;

        public b(Looper looper, s sVar) {
            super(looper);
            this.f5663a = sVar;
        }

        private void a(String str) {
            Log.d("TrackManager", this.f5663a.e.v() + " " + str + this.f5663a.g.addAndGet(0) + " 数据库记录数：" + this.f5663a.f5661a.b());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    Log.e("TrackManager", this.f5663a.e.v() + " removeMessages failed ", e);
                }
            }
            if (this.f5663a.g()) {
                return;
            }
            try {
                sendMessageDelayed(Message.obtain(this, 1), y.a(this.f5663a.f.get(), this.f5663a.k, this.f5663a.c));
            } catch (Exception e2) {
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    Log.e("TrackManager", this.f5663a.e.v() + " sendMessageDelayed failed ", e2);
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i = message.what;
            if (i == 2 || i == 3) {
                b();
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
                return;
            }
            if (i == 5) {
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    a("触发删除 当前 Event 数量：");
                }
                this.f5663a.a();
                sendMessageDelayed(Message.obtain(this, 5), UnityAdsConstants.Timeout.INIT_TIMEOUT_MS);
                return;
            }
            if (i != 6) {
                if (i != 7) {
                    b();
                    if (com.mbridge.msdk.tracker.a.f5612a) {
                        a("触发上报（timer）当前 Event 数量：");
                    }
                    a();
                    return;
                }
                this.f5663a.k();
                b();
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
                return;
            }
            Object obj = message.obj;
            e eVar = obj instanceof e ? (e) obj : null;
            if (com.mbridge.msdk.tracker.a.f5612a && !y.b(eVar)) {
                a(String.format("收到 Event( %s )，当前 Event 数量：", eVar.b()));
            }
            if (y.a(eVar) || this.f5663a.f()) {
                b();
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    a("触发上报（notice check）当前 Event 数量：");
                }
                a();
            }
        }

        private synchronized void a() {
            try {
                this.f5663a.h();
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5612a) {
                    Log.e("TrackManager", this.f5663a.e.v() + " report failed ", e);
                }
            }
        }
    }

    public s(k kVar) {
        this.f5661a = kVar.d();
        this.b = kVar.i();
        this.c = kVar.l();
        this.d = kVar.j();
        this.e = kVar;
    }

    private void l() {
        this.f5661a.c();
    }

    public void k() {
        synchronized (this.h) {
            if (!this.l) {
                this.l = true;
                l();
            }
            if (!this.m) {
                this.m = true;
                this.g.addAndGet(this.f5661a.b());
            }
        }
    }

    private List<i> c() {
        return this.f5661a.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        return this.f.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<i> listC = c();
        if (y.b((List<?>) listC)) {
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.d("TrackManager", this.e.v() + " report: 没有可以上报的数据");
                return;
            }
            return;
        }
        a(listC);
        int size = listC.size();
        this.g.addAndGet(-size);
        boolean zA = false;
        if (com.mbridge.msdk.tracker.a.f5612a) {
            Log.d("TrackManager", this.e.v() + " report: 上报的数量 = " + size + " 当前剩余事件数 = " + this.g.addAndGet(0) + " 数据库中剩余事件数 = " + this.f5661a.b());
        }
        try {
            zA = this.e.a();
        } catch (IllegalStateException e) {
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", this.e.v() + " report environment check failed ", e);
            }
        }
        if (!zA) {
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", this.e.v() + " report 失败，请检查 TrackConfig 配置是否正确");
                return;
            }
            return;
        }
        o oVarM = this.e.m();
        oVarM.a(new a(this.i, this));
        Map<String, String> map = new HashMap<>();
        try {
            map = this.e.f().a(this.e.u(), listC, this.e.o());
        } catch (Exception e2) {
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.e("TrackManager", this.e.v() + " report decorate request params failed ", e2);
            }
        }
        oVarM.b(new t(listC), map, y.a(listC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f.set(0);
    }

    public void b() {
        this.i.removeMessages(1);
        Handler handler = this.i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public void e() {
        this.g.incrementAndGet();
    }

    protected boolean f() {
        return this.g.addAndGet(0) >= this.b;
    }

    boolean g() {
        return this.j;
    }

    public void j() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000L);
        Handler handler = this.i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), this.c);
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<i> list) {
        if (y.b((List<?>) list)) {
            return;
        }
        this.f5661a.c(list);
    }

    public void a(e eVar) {
        if (this.i.hasMessages(6)) {
            return;
        }
        long jA = y.a(this.f.get(), this.k, this.c);
        if (jA > this.c) {
            Handler handler = this.i;
            handler.sendMessageDelayed(Message.obtain(handler, 6, eVar), (long) (jA * 0.1f));
        } else {
            Handler handler2 = this.i;
            handler2.sendMessage(Message.obtain(handler2, 6, eVar));
        }
    }

    /* JADX INFO: compiled from: ReportManager.java */
    private static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f5662a;
        private final s b;

        public a(Handler handler, s sVar) {
            this.f5662a = handler;
            this.b = sVar;
        }

        @Override // com.mbridge.msdk.tracker.r
        public void a(t tVar) {
            this.b.b(tVar.a());
            this.b.i();
            this.b.k = 0L;
            if (this.b.f()) {
                Handler handler = this.f5662a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.d("TrackManager", this.b.e.v() + " report success " + tVar.a().size() + " 剩余事件数：" + this.b.g.addAndGet(0) + " 个，数据库记录数：" + this.b.f5661a.b() + " 个");
            }
        }

        @Override // com.mbridge.msdk.tracker.r
        public void a(t tVar, int i, String str) {
            this.b.a(tVar.a(), str);
            this.b.k = System.currentTimeMillis();
            int iD = this.b.d();
            if (iD <= 10) {
                this.f5662a.removeMessages(3);
                Handler handler = this.f5662a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) iD) * 1000);
            }
            if (com.mbridge.msdk.tracker.a.f5612a) {
                Log.d("TrackManager", this.b.e.v() + " report failed " + tVar.a().size() + " 剩余事件数：" + this.b.g.addAndGet(0) + " 个，数据库记录数：" + this.b.f5661a.b() + " 个 连续失败次数： " + iD);
            }
        }
    }

    private void a(List<i> list) {
        this.f5661a.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (com.mbridge.msdk.tracker.a.f5612a) {
            return;
        }
        int iA = this.f5661a.a();
        if (com.mbridge.msdk.tracker.a.f5612a) {
            Log.d("TrackManager", this.e.v() + " 删除无效数据的数量 = " + iA + " 当前剩余事件数 = " + this.g.addAndGet(0) + " 数据库中剩余事件数 = " + this.f5661a.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<i> list, String str) {
        if (y.b((List<?>) list)) {
            return;
        }
        int i = 0;
        for (i iVar : list) {
            if (!y.b(iVar)) {
                boolean z = !iVar.g() && iVar.c() >= this.d;
                boolean z2 = !iVar.h() && iVar.b() < System.currentTimeMillis();
                if (!z && !z2) {
                    iVar.a(iVar.c() + 1);
                    iVar.b(3);
                    iVar.a(str);
                    i++;
                } else {
                    iVar.b(-1);
                }
            }
        }
        this.f5661a.a(list);
        this.g.addAndGet(i);
    }
}
