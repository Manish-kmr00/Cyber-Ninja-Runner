package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.services.i0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public interface v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6344a = a.f6345a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6345a = new a();

        public final v a(com.moloco.sdk.internal.bidtoken.b bidTokenParser, i0 timeProviderService) {
            Intrinsics.checkNotNullParameter(bidTokenParser, "bidTokenParser");
            Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
            return new w(bidTokenParser, timeProviderService);
        }
    }

    k a();

    Object a(k kVar, Continuation<? super Unit> continuation);

    Object a(Continuation<? super b0> continuation);

    void b();
}
