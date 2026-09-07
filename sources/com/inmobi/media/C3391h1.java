package com.inmobi.media;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: com.inmobi.media.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3391h1 implements ReadOnlyProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f3328a;
    public final boolean b;
    public volatile Object c;
    public final AtomicBoolean d;
    public boolean e;

    public /* synthetic */ C3391h1(Integer num, Function0 function0, boolean z, int i) {
        this((Object) num, function0, (i & 4) != 0 ? false : z, false);
    }

    public final void a() {
        if (this.d.compareAndSet(false, true)) {
            this.e = true;
            int i = S3.f3188a;
            ((ScheduledThreadPoolExecutor) S3.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.h1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3391h1.a(this.f$0);
                }
            });
        }
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.b || !this.e) {
            a();
        }
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3391h1(Object obj, Function0 refreshLogic, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(refreshLogic, "refreshLogic");
        this.f3328a = (Lambda) refreshLogic;
        this.b = z;
        this.c = obj;
        this.d = new AtomicBoolean(false);
        if (z2) {
            a();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public static final void a(C3391h1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.c = this$0.f3328a.invoke();
        } catch (Exception unused) {
        } finally {
            this$0.d.set(false);
        }
    }
}
