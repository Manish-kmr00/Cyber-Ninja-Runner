package com.inmobi.media;

import android.content.Context;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3468m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3374a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final WeakReference f;
    public final AtomicBoolean g;

    public C3468m6(Context context, String url, long j, long j2, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f3374a = url;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = i2;
        this.f = new WeakReference(context);
        this.g = new AtomicBoolean(false);
        a();
    }

    public final void a() {
        final Context context = (Context) this.f.get();
        if (context != null) {
            ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3468m6.a(this.f$0, context);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC3554s6.f3426a.submit(runnable);
        }
    }

    public static final void a(C3468m6 this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (this$0.g.get()) {
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this$0.g.get()) {
            int iA = D1.a((D1) AbstractC3415ib.d());
            C3382g6 c3382g6D = AbstractC3415ib.d();
            c3382g6D.getClass();
            ArrayList arrayListA = D1.a(c3382g6D, "hasLoggerFinished=1", null, null, null, null, Integer.valueOf(iA), 30);
            C3454l6 action = new C3454l6(this$0, context);
            Intrinsics.checkNotNullParameter(arrayListA, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            Iterator it = CollectionsKt.filterNotNull(arrayListA).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
        }
        ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
        AbstractC3539r6.a(AbstractC3415ib.d(), Calendar.getInstance().getTimeInMillis() - this$0.c, this$0.e);
    }

    public final void a(final Context context, final String str, C3368f6 c3368f6) {
        List<String> listEmptyList;
        String[] list;
        int i;
        if (this.g.get()) {
            return;
        }
        if (c3368f6.d == 0 || System.currentTimeMillis() - c3368f6.d >= this.b) {
            T8 t8B = new C3484n6(str, c3368f6).b();
            if (t8B.b() && (i = c3368f6.c + 1) < this.d) {
                P8 p8 = t8B.c;
                if ((p8 != null ? p8.f3168a : null) != I3.s) {
                    final C3368f6 c3368f7 = new C3368f6(c3368f6.f3312a, c3368f6.b, i, System.currentTimeMillis(), false, 0, 48);
                    AbstractC3415ib.d().b(c3368f7);
                    ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
                    long j = this.b;
                    Runnable runnable = new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3468m6.a(this.f$0, context, str, c3368f7);
                        }
                    };
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    AbstractC3554s6.f3426a.schedule(runnable, j, TimeUnit.MILLISECONDS);
                    return;
                }
            }
            AbstractC3568t6.a(c3368f6.f3312a);
            AbstractC3415ib.d().a(c3368f6);
            Context context2 = (Context) this.f.get();
            if (context2 != null) {
                ScheduledExecutorService scheduledExecutorService2 = AbstractC3554s6.f3426a;
                Intrinsics.checkNotNullParameter(context2, "context");
                String directoryPath = context2.getFilesDir() + "/logging";
                Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
                File file = new File(directoryPath);
                if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || (listEmptyList = ArraysKt.toList(list)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                for (String fileName : listEmptyList) {
                    C3382g6 c3382g6D = AbstractC3415ib.d();
                    c3382g6D.getClass();
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    if (D1.a(c3382g6D, "filename=\"" + fileName + '\"', null, null, null, null, null, 62).isEmpty()) {
                        AbstractC3568t6.a(fileName);
                    }
                }
            }
        }
    }

    public static final void a(C3468m6 this$0, Context context, String url, C3368f6 updatedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(updatedData, "$updatedData");
        this$0.a(context, url, updatedData);
    }
}
