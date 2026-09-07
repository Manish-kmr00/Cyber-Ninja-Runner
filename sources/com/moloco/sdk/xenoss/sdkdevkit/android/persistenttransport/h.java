package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7200a = "NonPersistentRequest";
    public static final Lazy b = LazyKt.lazy(a.f7201a);
    public static final long c = 10000;

    public static final class a extends Lambda implements Function0<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7201a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            return new g(com.moloco.sdk.service_locator.a.i.f6483a.a());
        }
    }

    public static final f a() {
        return b();
    }

    public static final g b() {
        return (g) b.getValue();
    }
}
