package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/ob;", "Lcom/chartboost/sdk/impl/nb;", "", "progressIntervalMillis", "", "a", "(J)V", "()V", "Lcom/chartboost/sdk/impl/q0;", "Lcom/chartboost/sdk/impl/q0;", "callback", "Lcom/chartboost/sdk/impl/nb$b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/nb$b;", "videoProgress", "Lkotlinx/coroutines/CoroutineDispatcher;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "progressJob", "<init>", "(Lcom/chartboost/sdk/impl/q0;Lcom/chartboost/sdk/impl/nb$b;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ob implements nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final q0 callback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final nb.b videoProgress;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Job progressJob;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.video.player.scheduler.VideoProgressSchedulerCoroutines$startProgressUpdate$1", f = "VideoProgressSchedulerCoroutines.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ob d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, ob obVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = obVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x002d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:12:0x0025). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r6)
                goto L25
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
            L1a:
                long r3 = r5.c
                r5.b = r2
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
                if (r6 != r0) goto L25
                return r0
            L25:
                com.chartboost.sdk.impl.ob r6 = r5.d
                com.chartboost.sdk.impl.q0 r6 = com.chartboost.sdk.impl.ob.a(r6)
                if (r6 == 0) goto L1a
                com.chartboost.sdk.impl.ob r1 = r5.d
                com.chartboost.sdk.impl.nb$b r1 = com.chartboost.sdk.impl.ob.b(r1)
                long r3 = r1.d()
                r6.a(r3)
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ob.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ob(q0 q0Var, nb.b videoProgress, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(videoProgress, "videoProgress");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.callback = q0Var;
        this.videoProgress = videoProgress;
        this.coroutineDispatcher = coroutineDispatcher;
    }

    public /* synthetic */ ob(q0 q0Var, nb.b bVar, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : q0Var, bVar, (i & 4) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    @Override // com.chartboost.sdk.impl.nb
    public void a(long progressIntervalMillis) {
        b7.a("startProgressUpdate()", (Throwable) null, 2, (Object) null);
        if (this.progressJob != null) {
            return;
        }
        this.progressJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new a(progressIntervalMillis, this, null), 3, null);
    }

    @Override // com.chartboost.sdk.impl.nb
    public void a() {
        b7.a("stopProgressUpdate()", (Throwable) null, 2, (Object) null);
        Job job = this.progressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.progressJob = null;
    }
}
