package com.yandex.mobile.ads.impl;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f10158a;

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (this) {
            ArrayList arrayList = this.f10158a;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!Intrinsics.areEqual(((WeakReference) it.next()).get(), activity));
                Unit unit = Unit.INSTANCE;
            }
            this.f10158a.add(new WeakReference(activity));
            String str = "ActivityLifecycleObserver: Added " + activity;
            op0.a(new Object[0]);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public s0(Activity activity) {
        ArrayList arrayList = new ArrayList();
        this.f10158a = arrayList;
        if (activity != null) {
            arrayList.add(new WeakReference(activity));
        }
    }

    static final class a extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
        public static final a b = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(WeakReference<Activity> weakReference) {
            WeakReference<Activity> it = weakReference;
            Intrinsics.checkNotNullParameter(it, "it");
            Activity activity = it.get();
            return Boolean.valueOf(activity == null || activity.isFinishing() || activity.isDestroyed());
        }
    }

    static final class b extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
        public static final b b = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(WeakReference<Activity> weakReference) {
            WeakReference<Activity> it = weakReference;
            Intrinsics.checkNotNullParameter(it, "it");
            Activity activity = it.get();
            return Boolean.valueOf(activity == null || activity.isFinishing() || activity.isDestroyed());
        }
    }

    public final Activity b() {
        Activity activity;
        synchronized (this) {
            CollectionsKt.removeAll((List) this.f10158a, (Function1) b.b);
            WeakReference weakReference = (WeakReference) CollectionsKt.lastOrNull((List) this.f10158a);
            activity = weakReference != null ? (Activity) weakReference.get() : null;
        }
        return activity;
    }

    public final void b(Activity activity) {
        Object next;
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (this) {
            Iterator it = this.f10158a.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((WeakReference) next).get(), activity));
            WeakReference weakReference = (WeakReference) next;
            if (weakReference != null) {
                this.f10158a.remove(weakReference);
                String str = "ActivityLifecycleObserver: Removed " + activity;
                op0.a(new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Activity a() {
        Activity activity;
        synchronized (this) {
            CollectionsKt.removeAll((List) this.f10158a, (Function1) a.b);
            WeakReference weakReference = (WeakReference) CollectionsKt.firstOrNull((List) this.f10158a);
            activity = weakReference != null ? (Activity) weakReference.get() : null;
        }
        return activity;
    }
}
