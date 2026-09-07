package com.yandex.mobile.ads.impl;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class rx implements qx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final js0 f10149a;
    private final hl0 b;
    private final jl0 c;
    private final CoroutineDispatcher d;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.data.repo.DebugPanelReportRepositoryImpl$getReport$2", f = "DebugPanelReportRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super il0>, Object> {
        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return rx.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super il0> continuation) {
            return rx.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            kx kxVarA = rx.this.f10149a.a();
            lx lxVarD = kxVarA.d();
            if (lxVarD == null) {
                return il0.b.f9238a;
            }
            return rx.this.c.a(rx.this.b.a(new px(kxVarA.a(), kxVarA.f(), kxVarA.e(), kxVarA.b(), lxVarD.b(), lxVarD.a())));
        }
    }

    public rx(js0 localDataSource, hl0 inspectorReportMapper, jl0 reportStorage, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(inspectorReportMapper, "inspectorReportMapper");
        Intrinsics.checkNotNullParameter(reportStorage, "reportStorage");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f10149a = localDataSource;
        this.b = inspectorReportMapper;
        this.c = reportStorage;
        this.d = ioDispatcher;
    }

    @Override // com.yandex.mobile.ads.impl.qx
    public final Object a(Continuation<? super il0> continuation) {
        return BuildersKt.withContext(this.d, new a(null), continuation);
    }
}
