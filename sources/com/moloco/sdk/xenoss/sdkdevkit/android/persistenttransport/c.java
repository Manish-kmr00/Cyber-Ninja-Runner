package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7191a = LazyKt.lazy(a.f7192a);

    public static final class a extends Lambda implements Function0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7192a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return c.c();
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a a() {
        return b();
    }

    public static final b b() {
        return (b) f7191a.getValue();
    }

    public static final b c() {
        d dVarA;
        try {
            dVarA = com.moloco.sdk.service_locator.a.i.f6483a.c();
        } catch (Exception e) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "BestAttemptHttpRequest", "Failed to create PersistentHttpRequest, invoking NonPersistendHttpRequest", e, false, 8, null);
            dVarA = h.a();
        }
        return new b(dVarA);
    }
}
