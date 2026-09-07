package com.inmobi.media;

import android.os.Looper;
import android.util.SparseArray;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3575u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3575u f3438a = new C3575u();
    public static final SparseArray b = new SparseArray();
    public static final ThreadPoolExecutor c;

    public static void a(final int i, final AbstractRunnableC3521q1 task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            c(i, task);
            return;
        }
        ExecutorC3596v6 executorC3596v6 = (ExecutorC3596v6) S3.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.u$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3575u.b(i, task);
            }
        };
        executorC3596v6.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC3596v6.f3456a.post(runnable);
    }

    public static final void b(int i, AbstractRunnableC3521q1 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        c(i, task);
    }

    public static void c(int i, AbstractRunnableC3521q1 abstractRunnableC3521q1) {
        try {
            SparseArray sparseArray = b;
            Queue linkedList = (Queue) sparseArray.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList();
                sparseArray.put(i, linkedList);
            }
            linkedList.add(abstractRunnableC3521q1);
            AbstractRunnableC3521q1 abstractRunnableC3521q2 = (AbstractRunnableC3521q1) linkedList.peek();
            if (linkedList.size() != 1 || abstractRunnableC3521q2 == null) {
                return;
            }
            try {
                c.execute(abstractRunnableC3521q2);
            } catch (OutOfMemoryError unused) {
                abstractRunnableC3521q2.c();
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    static {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        AdConfig adConfig = (AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(adConfig.getMaxPoolSize(), adConfig.getMaxPoolSize(), 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new V4(ApsMetricsDataMap.APSMETRICS_FIELD_URL.concat("-AD")));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        c = threadPoolExecutor;
    }
}
