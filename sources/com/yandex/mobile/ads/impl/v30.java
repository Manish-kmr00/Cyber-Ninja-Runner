package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes13.dex */
public final class v30 {
    public static final kq1 h = new kq1(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10444a;
    private final CopyOnWriteArraySet<c> b;
    private int c;
    private boolean d;
    private int e;
    private boolean f;
    private List<t30> g;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t30 f10445a;
        public final boolean b;
        public final List<t30> c;

        public a(t30 t30Var, boolean z, ArrayList arrayList, Exception exc) {
            this.f10445a = t30Var;
            this.b = z;
            this.c = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HandlerThread f10446a;
        private final sk2 b;
        private final z30 c;
        private final Handler d;
        private final ArrayList<t30> e;
        private final HashMap<String, d> f;
        private int g;
        private boolean h;
        private int i;
        private int j;
        private int k;

        public b(HandlerThread handlerThread, mz mzVar, nz nzVar, Handler handler, boolean z) {
            super(handlerThread.getLooper());
            this.f10446a = handlerThread;
            this.b = mzVar;
            this.c = nzVar;
            this.d = handler;
            this.i = 3;
            this.j = 5;
            this.h = z;
            this.e = new ArrayList<>();
            this.f = new HashMap<>();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            u30 u30VarA = null;
            i = 0;
            int i = 0;
            switch (message.what) {
                case 0:
                    this.g = message.arg1;
                    try {
                        ((mz) this.b).b();
                        u30VarA = ((mz) this.b).a(0, 1, 2, 5, 7);
                        while (true) {
                            mz.a aVar = (mz.a) u30VarA;
                            if (aVar.a(aVar.b() + 1)) {
                                this.e.add(((mz.a) u30VarA).a());
                            } else {
                                this.d.obtainMessage(0, new ArrayList(this.e)).sendToTarget();
                                b();
                                i = 1;
                                this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                                return;
                            }
                        }
                    } catch (IOException e) {
                        at0.a("DownloadManager", "Failed to load index.", e);
                        this.e.clear();
                    } finally {
                        x82.a((Closeable) u30VarA);
                    }
                    break;
                case 1:
                    this.h = message.arg1 != 0;
                    b();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 2:
                    this.g = message.arg1;
                    b();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 3:
                    String str = (String) message.obj;
                    int i2 = message.arg1;
                    if (str == null) {
                        for (int i3 = 0; i3 < this.e.size(); i3++) {
                            a(this.e.get(i3), i2);
                        }
                        try {
                            ((mz) this.b).a(i2);
                        } catch (IOException e2) {
                            at0.a("DownloadManager", "Failed to set manual stop reason", e2);
                        }
                        break;
                    } else {
                        t30 t30VarA = a(str, false);
                        if (t30VarA != null) {
                            a(t30VarA, i2);
                        } else {
                            try {
                                ((mz) this.b).a(i2, str);
                            } catch (IOException e3) {
                                at0.a("DownloadManager", "Failed to set manual stop reason: ".concat(str), e3);
                            }
                        }
                        break;
                    }
                    b();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 4:
                    this.i = message.arg1;
                    b();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 5:
                    this.j = message.arg1;
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 6:
                    x30 x30Var = (x30) message.obj;
                    int i4 = message.arg1;
                    t30 t30VarA2 = a(x30Var.b, true);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (t30VarA2 != null) {
                        int i5 = t30VarA2.b;
                        long j = (i5 == 5 || i5 == 3 || i5 == 4) ? jCurrentTimeMillis : t30VarA2.c;
                        a(new t30(t30VarA2.f10264a.a(x30Var), (i5 == 5 || i5 == 7) ? 7 : i4 != 0 ? 1 : 0, j, jCurrentTimeMillis, -1L, i4, 0, new w30()));
                    } else {
                        a(new t30(x30Var, i4 != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i4, 0, new w30()));
                    }
                    b();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 7:
                    String str2 = (String) message.obj;
                    t30 t30VarA3 = a(str2, true);
                    if (t30VarA3 == null) {
                        at0.b("DownloadManager", "Failed to remove nonexistent download: " + str2);
                    } else {
                        a(t30VarA3, 5, 0);
                        b();
                    }
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 8:
                    a();
                    i = 1;
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 9:
                    d dVar = (d) message.obj;
                    String str3 = dVar.b.b;
                    this.f.remove(str3);
                    boolean z = dVar.e;
                    if (!z) {
                        int i6 = this.k - 1;
                        this.k = i6;
                        if (i6 == 0) {
                            removeMessages(11);
                        }
                    }
                    if (dVar.h) {
                        b();
                    } else {
                        Exception exc = dVar.i;
                        if (exc != null) {
                            at0.a("DownloadManager", "Task failed: " + dVar.b + ", " + z, exc);
                        }
                        t30 t30VarA4 = a(str3, false);
                        t30VarA4.getClass();
                        int i7 = t30VarA4.b;
                        if (i7 != 2) {
                            if (i7 != 5 && i7 != 7) {
                                throw new IllegalStateException();
                            }
                            if (!z) {
                                throw new IllegalStateException();
                            }
                            if (i7 == 7) {
                                int i8 = t30VarA4.f;
                                a(t30VarA4, i8 == 0 ? 0 : 1, i8);
                                b();
                            } else {
                                this.e.remove(a(t30VarA4.f10264a.b));
                                try {
                                    ((mz) this.b).c(t30VarA4.f10264a.b);
                                } catch (IOException unused) {
                                    at0.b("DownloadManager", "Failed to remove from database");
                                }
                                this.d.obtainMessage(2, new a(t30VarA4, true, new ArrayList(this.e), null)).sendToTarget();
                            }
                        } else if (!z) {
                            t30 t30Var = new t30(t30VarA4.f10264a, exc == null ? 3 : 4, t30VarA4.c, System.currentTimeMillis(), t30VarA4.e, t30VarA4.f, exc == null ? 0 : 1, t30VarA4.h);
                            this.e.remove(a(t30Var.f10264a.b));
                            try {
                                ((mz) this.b).a(t30Var);
                            } catch (IOException e4) {
                                at0.a("DownloadManager", "Failed to update index.", e4);
                            }
                            this.d.obtainMessage(2, new a(t30Var, false, new ArrayList(this.e), exc)).sendToTarget();
                        } else {
                            throw new IllegalStateException();
                        }
                        b();
                        break;
                    }
                    this.d.obtainMessage(1, i, this.f.size()).sendToTarget();
                    return;
                case 10:
                    d dVar2 = (d) message.obj;
                    int i9 = message.arg1;
                    int i10 = message.arg2;
                    int i11 = x82.f10629a;
                    long j2 = ((((long) i9) & 4294967295L) << 32) | (4294967295L & ((long) i10));
                    t30 t30VarA5 = a(dVar2.b.b, false);
                    t30VarA5.getClass();
                    if (j2 == t30VarA5.e || j2 == -1) {
                        return;
                    }
                    a(new t30(t30VarA5.f10264a, t30VarA5.b, t30VarA5.c, System.currentTimeMillis(), j2, t30VarA5.f, t30VarA5.g, t30VarA5.h));
                    return;
                case 11:
                    for (int i12 = 0; i12 < this.e.size(); i12++) {
                        t30 t30Var2 = this.e.get(i12);
                        if (t30Var2.b == 2) {
                            try {
                                ((mz) this.b).a(t30Var2);
                            } catch (IOException e5) {
                                at0.a("DownloadManager", "Failed to update index.", e5);
                            }
                        }
                    }
                    sendEmptyMessageDelayed(11, 5000L);
                    return;
                case 12:
                    Iterator<d> it = this.f.values().iterator();
                    while (it.hasNext()) {
                        it.next().a(true);
                    }
                    try {
                        ((mz) this.b).b();
                        break;
                    } catch (IOException e6) {
                        at0.a("DownloadManager", "Failed to update index.", e6);
                    }
                    this.e.clear();
                    this.f10446a.quit();
                    synchronized (this) {
                        notifyAll();
                        break;
                    }
                    return;
                default:
                    throw new IllegalStateException();
            }
        }

        private void b() {
            int i = 0;
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                t30 t30Var = this.e.get(i2);
                d dVar = this.f.get(t30Var.f10264a.b);
                int i3 = t30Var.b;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            dVar.getClass();
                            if (!dVar.e) {
                                if (this.h || this.g != 0 || i >= this.i) {
                                    a(t30Var, 0, 0);
                                    dVar.a(false);
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            if (i3 != 5 && i3 != 7) {
                                throw new IllegalStateException();
                            }
                            if (dVar != null) {
                                if (!dVar.e) {
                                    dVar.a(false);
                                }
                            } else {
                                d dVar2 = new d(t30Var.f10264a, ((nz) this.c).a(t30Var.f10264a), t30Var.h, true, this.j, this);
                                this.f.put(t30Var.f10264a.b, dVar2);
                                dVar2.start();
                            }
                        }
                    } else if (dVar != null) {
                        if (!dVar.e) {
                            dVar.a(false);
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                } else if (dVar != null) {
                    if (!dVar.e) {
                        dVar.a(false);
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (this.h || this.g != 0 || this.k >= this.i) {
                    dVar = null;
                } else {
                    t30 t30VarA = a(t30Var, 2, 0);
                    dVar = new d(t30VarA.f10264a, ((nz) this.c).a(t30VarA.f10264a), t30VarA.h, false, this.j, this);
                    this.f.put(t30VarA.f10264a.b, dVar);
                    int i4 = this.k;
                    this.k = i4 + 1;
                    if (i4 == 0) {
                        sendEmptyMessageDelayed(11, 5000L);
                    }
                    dVar.start();
                }
                if (dVar != null && !dVar.e) {
                    i++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int a(t30 t30Var, t30 t30Var2) {
            long j = t30Var.c;
            long j2 = t30Var2.c;
            int i = x82.f10629a;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private t30 a(String str, boolean z) {
            int iA = a(str);
            if (iA != -1) {
                return this.e.get(iA);
            }
            if (!z) {
                return null;
            }
            try {
                return ((mz) this.b).b(str);
            } catch (IOException e) {
                at0.a("DownloadManager", "Failed to load download: " + str, e);
                return null;
            }
        }

        private int a(String str) {
            for (int i = 0; i < this.e.size(); i++) {
                if (this.e.get(i).f10264a.b.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        private t30 a(t30 t30Var) {
            int i = t30Var.b;
            if (i != 3 && i != 4) {
                int iA = a(t30Var.f10264a.b);
                if (iA == -1) {
                    this.e.add(t30Var);
                    Collections.sort(this.e, new v30$b$$ExternalSyntheticLambda0());
                } else {
                    boolean z = t30Var.c != this.e.get(iA).c;
                    this.e.set(iA, t30Var);
                    if (z) {
                        Collections.sort(this.e, new v30$b$$ExternalSyntheticLambda0());
                    }
                }
                try {
                    ((mz) this.b).a(t30Var);
                } catch (IOException e) {
                    at0.a("DownloadManager", "Failed to update index.", e);
                }
                this.d.obtainMessage(2, new a(t30Var, false, new ArrayList(this.e), null)).sendToTarget();
                return t30Var;
            }
            throw new IllegalStateException();
        }

        private t30 a(t30 t30Var, int i, int i2) {
            if (i != 3 && i != 4) {
                return a(new t30(t30Var.f10264a, i, t30Var.c, System.currentTimeMillis(), t30Var.e, i2, 0, t30Var.h));
            }
            throw new IllegalStateException();
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0052 A[LOOP:1: B:19:0x004a->B:21:0x0052, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:25:0x0089 A[LOOP:2: B:23:0x0083->B:25:0x0089, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:34:0x00de A[LOOP:3: B:32:0x00d6->B:34:0x00de, LOOP_END] */
        private void a() {
            int i;
            int i2;
            ArrayList arrayList;
            int i3;
            u30 u30VarA;
            ArrayList arrayList2 = new ArrayList();
            try {
                u30VarA = ((mz) this.b).a(3, 4);
                ((mz.a) u30VarA).close();
            } catch (IOException unused) {
                at0.b("DownloadManager", "Failed to load downloads.");
            }
            try {
                while (true) {
                    try {
                        mz.a aVar = (mz.a) u30VarA;
                        if (!aVar.a(aVar.b() + 1)) {
                            break;
                        } else {
                            arrayList2.add(((mz.a) u30VarA).a());
                        }
                        for (i = 0; i < this.e.size(); i++) {
                            ArrayList<t30> arrayList3 = this.e;
                            t30 t30Var = arrayList3.get(i);
                            arrayList3.set(i, new t30(t30Var.f10264a, 5, t30Var.c, System.currentTimeMillis(), t30Var.e, 0, 0, t30Var.h));
                        }
                        for (i2 = 0; i2 < arrayList2.size(); i2++) {
                            ArrayList<t30> arrayList4 = this.e;
                            t30 t30Var2 = (t30) arrayList2.get(i2);
                            arrayList4.add(new t30(t30Var2.f10264a, 5, t30Var2.c, System.currentTimeMillis(), t30Var2.e, 0, 0, t30Var2.h));
                        }
                        Collections.sort(this.e, new v30$b$$ExternalSyntheticLambda0());
                        ((mz) this.b).c();
                        arrayList = new ArrayList(this.e);
                        for (i3 = 0; i3 < this.e.size(); i3++) {
                            this.d.obtainMessage(2, new a(this.e.get(i3), false, arrayList, null)).sendToTarget();
                        }
                        b();
                    } catch (Throwable th) {
                        try {
                            ((mz.a) u30VarA).close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                    at0.b("DownloadManager", "Failed to load downloads.");
                }
                ((mz) this.b).c();
            } catch (IOException e) {
                at0.a("DownloadManager", "Failed to update index.", e);
            }
            while (i < this.e.size()) {
                ArrayList<t30> arrayList5 = this.e;
                t30 t30Var3 = arrayList5.get(i);
                arrayList5.set(i, new t30(t30Var3.f10264a, 5, t30Var3.c, System.currentTimeMillis(), t30Var3.e, 0, 0, t30Var3.h));
            }
            while (i2 < arrayList2.size()) {
                ArrayList<t30> arrayList6 = this.e;
                t30 t30Var4 = (t30) arrayList2.get(i2);
                arrayList6.add(new t30(t30Var4.f10264a, 5, t30Var4.c, System.currentTimeMillis(), t30Var4.e, 0, 0, t30Var4.h));
            }
            Collections.sort(this.e, new v30$b$$ExternalSyntheticLambda0());
            arrayList = new ArrayList(this.e);
            while (i3 < this.e.size()) {
                this.d.obtainMessage(2, new a(this.e.get(i3), false, arrayList, null)).sendToTarget();
            }
            b();
        }

        private void a(t30 t30Var, int i) {
            if (i == 0) {
                if (t30Var.b == 1) {
                    a(t30Var, 0, 0);
                }
            } else if (i != t30Var.f) {
                int i2 = t30Var.b;
                if (i2 == 0 || i2 == 2) {
                    i2 = 1;
                }
                a(new t30(t30Var.f10264a, i2, t30Var.c, System.currentTimeMillis(), t30Var.e, i, 0, t30Var.h));
            }
        }
    }

    public interface c {
        default void a(v30 v30Var, t30 t30Var) {
        }
    }

    public v30(Context context, mz mzVar, nz nzVar) {
        context.getApplicationContext();
        this.d = true;
        this.g = Collections.emptyList();
        this.b = new CopyOnWriteArraySet<>();
        Handler handlerB = x82.b(new Handler.Callback() { // from class: com.yandex.mobile.ads.impl.v30$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f$0.a(message);
            }
        });
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        b bVar = new b(handlerThread, mzVar, nzVar, handlerB, this.d);
        this.f10444a = bVar;
        int iA = new lq1(context, new lq1.b() { // from class: com.yandex.mobile.ads.impl.v30$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.lq1.b
            public final void a(lq1 lq1Var, int i) {
                this.f$0.a(lq1Var, i);
            }
        }).a();
        this.e = iA;
        this.c = 1;
        bVar.obtainMessage(0, iA, 0).sendToTarget();
    }

    public final void a(x30 x30Var) {
        this.c++;
        this.f10444a.obtainMessage(6, 0, 0, x30Var).sendToTarget();
    }

    public final void a(ij2 ij2Var) {
        this.b.add(ij2Var);
    }

    private boolean b() {
        boolean z;
        if (!this.d && this.e != 0) {
            int i = 0;
            while (true) {
                if (i >= this.g.size()) {
                    z = false;
                    break;
                }
                if (this.g.get(i).b == 0) {
                    z = true;
                    break;
                }
                i++;
            }
        } else {
            z = false;
            break;
        }
        boolean z2 = this.f != z;
        this.f = z;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Message message) {
        int i = message.what;
        if (i == 0) {
            this.g = Collections.unmodifiableList((List) message.obj);
            boolean zB = b();
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
            if (zB) {
                Iterator<c> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    it2.next().getClass();
                }
            }
        } else if (i == 1) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            int i4 = this.c - i2;
            this.c = i4;
            if (i3 == 0 && i4 == 0) {
                Iterator<c> it3 = this.b.iterator();
                while (it3.hasNext()) {
                    it3.next().getClass();
                }
            }
        } else if (i == 2) {
            a aVar = (a) message.obj;
            this.g = Collections.unmodifiableList(aVar.c);
            t30 t30Var = aVar.f10445a;
            boolean zB2 = b();
            if (aVar.b) {
                Iterator<c> it4 = this.b.iterator();
                while (it4.hasNext()) {
                    it4.next().getClass();
                }
            } else {
                Iterator<c> it5 = this.b.iterator();
                while (it5.hasNext()) {
                    it5.next().a(this, t30Var);
                }
            }
            if (zB2) {
                Iterator<c> it6 = this.b.iterator();
                while (it6.hasNext()) {
                    it6.next().getClass();
                }
            }
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(lq1 lq1Var, int i) {
        lq1Var.getClass();
        if (this.e != i) {
            this.e = i;
            this.c++;
            this.f10444a.obtainMessage(2, i, 0).sendToTarget();
        }
        boolean zB = b();
        Iterator<c> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        if (zB) {
            Iterator<c> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next().getClass();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends Thread implements y30.a {
        private final x30 b;
        private final y30 c;
        private final w30 d;
        private final boolean e;
        private final int f;
        private volatile b g;
        private volatile boolean h;
        private Exception i;
        private long j;

        private d(x30 x30Var, y30 y30Var, w30 w30Var, boolean z, int i, b bVar) {
            this.b = x30Var;
            this.c = y30Var;
            this.d = w30Var;
            this.e = z;
            this.f = i;
            this.g = bVar;
            this.j = -1L;
        }

        public final void a(boolean z) {
            if (z) {
                this.g = null;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            this.c.cancel();
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.e) {
                    this.c.remove();
                } else {
                    long j = -1;
                    int i = 0;
                    while (!this.h) {
                        try {
                            this.c.a(this);
                            break;
                        } catch (IOException e) {
                            if (!this.h) {
                                long j2 = this.d.f10531a;
                                if (j2 != j) {
                                    i = 0;
                                    j = j2;
                                }
                                int i2 = i + 1;
                                if (i2 <= this.f) {
                                    Thread.sleep(Math.min(i * 1000, 5000));
                                    i = i2;
                                } else {
                                    throw e;
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e2) {
                this.i = e2;
            }
            b bVar = this.g;
            if (bVar != null) {
                bVar.obtainMessage(9, this).sendToTarget();
            }
        }

        public final void a(long j, long j2, float f) {
            this.d.f10531a = j2;
            this.d.b = f;
            if (j != this.j) {
                this.j = j;
                b bVar = this.g;
                if (bVar != null) {
                    bVar.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }
    }

    public final void a(String str) {
        this.c++;
        this.f10444a.obtainMessage(7, str).sendToTarget();
    }

    public final void a(c cVar) {
        this.b.remove(cVar);
    }

    public final void a() {
        if (this.d) {
            this.d = false;
            this.c++;
            this.f10444a.obtainMessage(1, 0, 0).sendToTarget();
            boolean zB = b();
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
            if (zB) {
                Iterator<c> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    it2.next().getClass();
                }
            }
        }
    }
}
