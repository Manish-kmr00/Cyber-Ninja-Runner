package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a31 implements od1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8359a;
    private final kd1 b;
    private final c62 c;
    private final String d;
    private final s9 e;
    private final a f;
    private final v9 g;
    private final iw1 h;
    private final k62 i;
    private final ArrayList j;
    private rk0 k;
    private boolean l;
    private boolean m;

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kd1 f8360a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, kd1 noticeReportController) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            Intrinsics.checkNotNullParameter(noticeReportController, "noticeReportController");
            this.f8360a = noticeReportController;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message msg) {
            long jElapsedRealtime;
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Pair<java.lang.ref.WeakReference<com.monetization.ads.base.impression.tracking.MrcNoticeTrackingManager>, com.monetization.ads.base.impression.tracking.model.TrackingNotice>");
                Pair pair = (Pair) obj;
                a31 a31Var = (a31) ((WeakReference) pair.getFirst()).get();
                if (a31Var != null) {
                    j62 j62Var = (j62) pair.getSecond();
                    op0.d(a31Var.d);
                    f92 f92VarA = a31.a(a31Var, j62Var);
                    a31Var.a(j62Var, f92VarA);
                    if (!a31.a(f92VarA)) {
                        j62Var.a(null);
                        a31Var.b();
                        return;
                    }
                    a31Var.j.remove(j62Var);
                    a31Var.e();
                    kd1 kd1Var = this.f8360a;
                    yx1 yx1VarC = j62Var.c();
                    ArrayList arrayList = a31Var.j;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((j62) it.next()).c());
                    }
                    kd1Var.a(yx1VarC, arrayList2);
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.ref.WeakReference<com.monetization.ads.base.impression.tracking.MrcNoticeTrackingManager?>");
            a31 a31Var2 = (a31) ((WeakReference) obj2).get();
            if (a31Var2 != null) {
                op0.d(Integer.valueOf(a31Var2.j.size()), a31Var2.d);
                for (j62 j62Var2 : a31Var2.j) {
                    f92 f92VarA2 = a31.a(a31Var2, j62Var2);
                    if (a31.a(f92VarA2)) {
                        Long lB = j62Var2.b();
                        if (lB != null) {
                            jElapsedRealtime = lB.longValue();
                        } else {
                            jElapsedRealtime = SystemClock.elapsedRealtime();
                            j62Var2.a(Long.valueOf(jElapsedRealtime));
                        }
                        if (SystemClock.elapsedRealtime() - jElapsedRealtime >= j62Var2.a()) {
                            a31Var2.f.sendMessage(Message.obtain(a31Var2.f, 1, TuplesKt.to(new WeakReference(a31Var2), j62Var2)));
                        }
                        a31Var2.f();
                        this.f8360a.a(j62Var2.c());
                    } else {
                        j62Var2.a(null);
                        this.f8360a.a(j62Var2.c(), f92VarA2);
                    }
                }
                if (a31Var2.d()) {
                    a31Var2.f.sendMessageDelayed(Message.obtain(a31Var2.f, 2, new WeakReference(a31Var2)), 200L);
                }
            }
        }
    }

    public a31(Context context, o3 adConfiguration, kd1 noticeReportController, c62 trackingChecker, String viewControllerDescription, s9 adStructureType, a handler, v9 adTracker, iw1 sdkSettings, k62 trackingNoticeBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(noticeReportController, "noticeReportController");
        Intrinsics.checkNotNullParameter(trackingChecker, "trackingChecker");
        Intrinsics.checkNotNullParameter(viewControllerDescription, "viewControllerDescription");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(trackingNoticeBuilder, "trackingNoticeBuilder");
        this.f8359a = context;
        this.b = noticeReportController;
        this.c = trackingChecker;
        this.d = viewControllerDescription;
        this.e = adStructureType;
        this.f = handler;
        this.g = adTracker;
        this.h = sdkSettings;
        this.i = trackingNoticeBuilder;
        this.j = new ArrayList();
    }

    public static final boolean a(f92 f92Var) {
        return f92Var.b() == f92.a.c;
    }

    public static final f92 a(a31 a31Var, j62 j62Var) {
        f92 f92VarB = a31Var.c.b(j62Var.e());
        op0.d(f92VarB.b().a());
        return f92VarB;
    }

    public final synchronized void a(List<xx1> showNotices) {
        yx1 yx1Var;
        yx1 yx1Var2;
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        this.j.clear();
        k62 k62Var = this.i;
        s9 adStructureType = this.e;
        k62Var.getClass();
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(showNotices, 10));
        Iterator<T> it = showNotices.iterator();
        while (it.hasNext()) {
            arrayList.add(((xx1) it.next()).b());
        }
        Set set = CollectionsKt.toSet(arrayList);
        int iOrdinal = adStructureType.ordinal();
        if (iOrdinal == 0) {
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((yx1) it2.next()) == yx1.c) {
                            yx1Var = null;
                            break;
                        }
                    }
                }
            }
            yx1Var = yx1.b;
            break;
        }
        if (iOrdinal == 1) {
            yx1Var = yx1.c;
        } else if (iOrdinal == 2) {
            yx1Var = yx1.b;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<xx1> arrayList3 = new ArrayList();
        for (Object obj : showNotices) {
            if (((xx1) obj).c() != null) {
                arrayList3.add(obj);
            }
        }
        for (xx1 xx1Var : arrayList3) {
            String strC = xx1Var.c();
            long jA = xx1Var.a();
            int iD = xx1Var.d();
            if (xx1Var.b() != yx1.d || yx1Var == null) {
                yx1 yx1VarB = xx1Var.b();
                yx1Var2 = yx1VarB;
            } else {
                yx1Var2 = yx1Var;
            }
            if (strC != null) {
                arrayList2.add(new j62(iD, jA, yx1Var2, strC));
            }
        }
        this.j.addAll(arrayList2);
    }

    @Override // com.yandex.mobile.ads.impl.od1
    public final synchronized void b() {
        String str = "startTrackingIfNeeded(), clazz = " + this.d;
        op0.d(new Object[0]);
        if (ch1.h.a(this.f8359a).b() && !this.j.isEmpty() && d() && !this.f.hasMessages(2)) {
            a aVar = this.f;
            aVar.sendMessage(Message.obtain(aVar, 2, new WeakReference(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean d() {
        return this.j.size() > 0;
    }

    @Override // com.yandex.mobile.ads.impl.od1
    public final synchronized void c() {
        f92 f92VarA;
        op0.d(Integer.valueOf(this.j.size()), this.d);
        a();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            j62 j62Var = (j62) it.next();
            cu1 cu1VarA = this.h.a(this.f8359a);
            if (cu1VarA != null && cu1VarA.f0()) {
                f92VarA = this.c.b(j62Var.e());
            } else {
                f92VarA = this.c.a(j62Var.e());
            }
            op0.d(f92VarA.b().a());
            a(j62Var, f92VarA);
            if (f92VarA.b() == f92.a.c) {
                it.remove();
                f();
                e();
                this.b.a(j62Var.c());
                kd1 kd1Var = this.b;
                yx1 yx1VarC = j62Var.c();
                ArrayList arrayList2 = this.j;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((j62) it2.next()).c());
                }
                kd1Var.a(yx1VarC, arrayList3);
            } else {
                arrayList.add(new qd1(j62Var, f92VarA));
            }
        }
        this.b.a(arrayList);
        b();
    }

    public final void f() {
        if (this.l) {
            return;
        }
        this.l = true;
        rk0 rk0Var = this.k;
        if (rk0Var != null) {
            rk0Var.c();
        }
    }

    public final void e() {
        if (this.m || !this.j.isEmpty()) {
            return;
        }
        this.m = true;
        rk0 rk0Var = this.k;
        if (rk0Var != null) {
            rk0Var.g();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x0043 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:11:0x003d, B:13:0x0043), top: B:19:0x0003 }] */
    public final synchronized void a(zg1 phoneState, boolean z) {
        Intrinsics.checkNotNullParameter(phoneState, "phoneState");
        String str = "handleIntent(), phoneState = " + phoneState + ", isAdVisible = " + z + ", clazz = " + this.d;
        op0.d(new Object[0]);
        int iOrdinal = phoneState.ordinal();
        if (iOrdinal == 0) {
            if (z) {
                b();
            }
        } else if (iOrdinal == 1) {
            a();
        } else if (iOrdinal == 2) {
            if (z) {
                b();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.od1
    public final void a(rk0 impressionTrackingListener) {
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        this.k = impressionTrackingListener;
    }

    @Override // com.yandex.mobile.ads.impl.od1
    public final synchronized void a() {
        String str = "stopTracking(), clazz = " + this.d;
        op0.d(new Object[0]);
        this.f.removeMessages(2);
        this.f.removeMessages(1);
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((j62) it.next()).a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void a(j62 j62Var, f92 f92Var) {
        if (f92Var.b() == f92.a.c) {
            this.g.a(j62Var.d(), s62.h);
        } else {
            this.b.a(j62Var.c(), f92Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.od1
    public final synchronized void a(o8<?> adResponse, List<xx1> showNotices) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        String str = "updateNotices(), clazz = " + this.d;
        op0.d(new Object[0]);
        this.b.a(adResponse);
        this.j.clear();
        this.b.invalidate();
        this.m = false;
        a();
        a(showNotices);
    }
}
