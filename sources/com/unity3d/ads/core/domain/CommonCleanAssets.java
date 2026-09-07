package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: CommonCleanAssets.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonCleanAssets;", "Lcom/unity3d/ads/core/domain/CleanAssets;", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonCleanAssets implements CleanAssets {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonCleanAssets$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonCleanAssets.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.CommonCleanAssets", f = "CommonCleanAssets.kt", i = {0, 0, 1, 1, 1}, l = {18, 19}, m = "invoke", n = {"this", "startTime", "this", "startTime", "currentSize"}, s = {"L$0", "J$0", "L$0", "J$0", "J$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonCleanAssets.this.invoke(this);
        }
    }

    public CommonCleanAssets(CacheRepository cacheRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.domain.CleanAssets
    public Object invoke(Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        CommonCleanAssets commonCleanAssets;
        long j;
        CommonCleanAssets commonCleanAssets2;
        long j2;
        long j3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object cacheSize = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(cacheSize);
            long jM9371markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m9371markNowz9LOYto();
            CacheRepository cacheRepository = this.cacheRepository;
            anonymousClass1.L$0 = this;
            anonymousClass1.J$0 = jM9371markNowz9LOYto;
            anonymousClass1.label = 1;
            cacheSize = cacheRepository.getCacheSize(anonymousClass1);
            if (cacheSize == coroutine_suspended) {
                return coroutine_suspended;
            }
            commonCleanAssets = this;
            j = jM9371markNowz9LOYto;
        } else {
            if (i == 1) {
                j = anonymousClass1.J$0;
                commonCleanAssets = (CommonCleanAssets) anonymousClass1.L$0;
                ResultKt.throwOnFailure(cacheSize);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = anonymousClass1.J$1;
                j2 = anonymousClass1.J$0;
                commonCleanAssets2 = (CommonCleanAssets) anonymousClass1.L$0;
                ResultKt.throwOnFailure(cacheSize);
            }
            SendDiagnosticEvent.DefaultImpls.invoke$default(commonCleanAssets2.sendDiagnosticEvent, "native_clean_assets_task_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m9372boximpl(j2))), null, MapsKt.mapOf(TuplesKt.to("size_kb", Boxing.boxInt((int) (j3 / ((long) 1024))))), null, 20, null);
            return Unit.INSTANCE;
        }
        long jLongValue = ((Number) cacheSize).longValue();
        CacheRepository cacheRepository2 = commonCleanAssets.cacheRepository;
        anonymousClass1.L$0 = commonCleanAssets;
        anonymousClass1.J$0 = j;
        anonymousClass1.J$1 = jLongValue;
        anonymousClass1.label = 2;
        if (cacheRepository2.clearCache(anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        commonCleanAssets2 = commonCleanAssets;
        j2 = j;
        j3 = jLongValue;
        SendDiagnosticEvent.DefaultImpls.invoke$default(commonCleanAssets2.sendDiagnosticEvent, "native_clean_assets_task_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m9372boximpl(j2))), null, MapsKt.mapOf(TuplesKt.to("size_kb", Boxing.boxInt((int) (j3 / ((long) 1024))))), null, 20, null);
        return Unit.INSTANCE;
    }
}
