package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6325a = LazyKt.lazy(a.f6326a);

    public static final class a extends Lambda implements Function0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6326a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m invoke() {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "BidTokenService", "Creating BidTokenService instance", null, false, 12, null);
            return new m(y.f6348a.a(), q.f6340a.a());
        }
    }

    public static final l a() {
        return b();
    }

    public static final m b() {
        return (m) f6325a.getValue();
    }
}
