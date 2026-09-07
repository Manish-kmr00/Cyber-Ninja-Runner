package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.lang.ref.WeakReference;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.q1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractRunnableC3521q1 implements Runnable {
    public final WeakReference b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3401a = "q1";
    public final Handler c = new Handler(Looper.getMainLooper());

    public AbstractRunnableC3521q1(Object obj) {
        this.b = new WeakReference(obj);
    }

    public static final void a(AbstractRunnableC3521q1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object obj = this$0.b.get();
        if (obj != null) {
            C3575u c3575u = C3575u.f3438a;
            int iHashCode = obj.hashCode();
            try {
                SparseArray sparseArray = C3575u.b;
                Queue queue = (Queue) sparseArray.get(iHashCode);
                if (queue != null) {
                    queue.poll();
                    AbstractRunnableC3521q1 abstractRunnableC3521q1 = (AbstractRunnableC3521q1) queue.peek();
                    if (queue.size() > 0 && abstractRunnableC3521q1 != null) {
                        try {
                            C3575u.c.execute(abstractRunnableC3521q1);
                        } catch (OutOfMemoryError unused) {
                            abstractRunnableC3521q1.c();
                        }
                    }
                    if (queue.size() == 0) {
                        sparseArray.remove(iHashCode);
                    }
                }
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }

    public abstract void a();

    public final void b() {
        this.c.post(new Runnable() { // from class: com.inmobi.media.q1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractRunnableC3521q1.a(this.f$0);
            }
        });
    }

    public void c() {
        String TAG = this.f3401a;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        AbstractC3498o6.a((byte) 1, TAG, "Could not execute runnable due to OutOfMemory.");
        Object obj = this.b.get();
        if (obj != null) {
            C3575u c3575u = C3575u.f3438a;
            int iHashCode = obj.hashCode();
            SparseArray sparseArray = C3575u.b;
            sparseArray.remove(iHashCode);
            Intrinsics.checkNotNullExpressionValue(ApsMetricsDataMap.APSMETRICS_FIELD_URL, "TAG");
            sparseArray.size();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
        b();
    }
}
