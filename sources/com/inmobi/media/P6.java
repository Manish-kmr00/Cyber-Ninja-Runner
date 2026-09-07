package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class P6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3166a = new ConcurrentHashMap();
    public final ExecutorService b = Executors.newSingleThreadExecutor(new V4("MultiEventBus"));

    public static final void a(N1 event, P6 this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = event.f3141a;
        this$0.a(event);
    }

    public final void b(final N1 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.b.execute(new Runnable() { // from class: com.inmobi.media.P6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    P6.a(event, this);
                }
            });
        } catch (InternalError unused) {
            a(event);
        }
    }

    public final void a(int[] eventIds, Function1 subscriber) {
        Intrinsics.checkNotNullParameter(eventIds, "eventIds");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.f3166a.put(new O6(eventIds), new WeakReference(subscriber));
    }

    public final void a(Function1 subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Iterator it = this.f3166a.entrySet().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WeakReference) ((Map.Entry) it.next()).getValue()).get(), subscriber)) {
                it.remove();
            }
        }
    }

    public final void a(N1 n1) {
        Function1 function1;
        Set<Map.Entry> setEntrySet = this.f3166a.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        for (Map.Entry entry : setEntrySet) {
            if (((WeakReference) entry.getValue()).get() == null) {
                this.f3166a.remove(entry.getKey());
            }
        }
        Set<Map.Entry> setEntrySet2 = this.f3166a.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet2, "<get-entries>(...)");
        for (Map.Entry entry2 : setEntrySet2) {
            Intrinsics.checkNotNull(entry2);
            Function1 function2 = (Function1) entry2.getKey();
            WeakReference weakReference = (WeakReference) entry2.getValue();
            try {
                if (((Boolean) function2.invoke(n1)).booleanValue() && (function1 = (Function1) weakReference.get()) != null) {
                    function1.invoke(n1);
                }
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }
}
