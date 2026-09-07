package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class P4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f3165a = new CopyOnWriteArrayList();
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final O4 c = new O4();

    public static void a(C3468m6 finishListener) {
        Intrinsics.checkNotNullParameter(finishListener, "finishListener");
        if (!b.getAndSet(true)) {
            b();
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = f3165a;
        copyOnWriteArrayList.add(new WeakReference(finishListener));
        try {
            for (WeakReference weakReference : copyOnWriteArrayList) {
                if (weakReference.get() == null) {
                    f3165a.remove(weakReference);
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static void b() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.P4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                P4.c();
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ec.f3062a.execute(runnable);
    }

    public static final void c() {
        C3382g6 c3382g6D = AbstractC3415ib.d();
        O4 listener = c;
        c3382g6D.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        c3382g6D.b = listener;
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator it = AbstractC3526q6.f3406a.iterator();
            while (it.hasNext()) {
                C3414ia c3414ia = (C3414ia) ((WeakReference) it.next()).get();
                if (c3414ia != null) {
                    arrayList2.add(c3414ia);
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = AbstractC3526q6.f3406a;
        arrayList2.toString();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList.add(new C3302ab((C3414ia) it2.next()));
        }
        return arrayList;
    }
}
