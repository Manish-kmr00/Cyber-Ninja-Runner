package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0096\u0001\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012U\b\u0002\u0010,\u001aO\u0012\u0013\u0012\u00110\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b('\u0012\u0006\u0012\u0004\u0018\u00010\u00150(j\u0002`+¢\u0006\u0004\b-\u0010.J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/chartboost/sdk/impl/ib;", "", "", "a", "()V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "totalVideoDuration", "(I)V", "e", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/ib$b;", "Lcom/chartboost/sdk/impl/ib$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "F", "bufferUnlockThreshold", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/chartboost/sdk/impl/u8;", "d", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/u8;", "randomAccessVideoFile", "", "J", "expectedVideoSize", "sizeOnBuffer", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "calculateBufferStatusJob", "Lcom/chartboost/sdk/impl/gb;", "videoAsset", "Lcom/chartboost/sdk/impl/z9;", "tempHelper", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/chartboost/sdk/internal/video/player/mediaplayer/RandomAccessFileFactory;", "randomAccessFileFactory", "<init>", "(Lcom/chartboost/sdk/impl/gb;Lcom/chartboost/sdk/impl/ib$b;FLcom/chartboost/sdk/impl/z9;Lcom/chartboost/sdk/impl/f5;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function3;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b listener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float bufferUnlockThreshold;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy randomAccessVideoFile;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public long expectedVideoSize;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public long sizeOnBuffer;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public Job calculateBufferStatusJob;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<gb, z9, f5, u8> {
        public static final a b = new a();

        public a() {
            super(3, jb.class, "createRandomAccessFile", "createRandomAccessFile(Lcom/chartboost/sdk/internal/video/VideoAsset;Lcom/chartboost/sdk/internal/video/TempFileDownloadHelper;Lcom/chartboost/sdk/internal/Libraries/FileCache;)Lcom/chartboost/sdk/internal/utils/RandomAccessFileWrapper;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u8 invoke(gb p0, z9 p1, f5 f5Var) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return jb.b(p0, p1, f5Var);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/ib$b;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface b {
        void b();
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.video.player.mediaplayer.VideoBuffer$checkBufferDownload$1", f = "VideoBuffer.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ib.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b = 1;
                if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ib.this.b();
            return Unit.INSTANCE;
        }
    }

    public ib(gb videoAsset, b listener, float f, z9 tempHelper, f5 f5Var, CoroutineDispatcher coroutineDispatcher, Function3<? super gb, ? super z9, ? super f5, u8> randomAccessFileFactory) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tempHelper, "tempHelper");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(randomAccessFileFactory, "randomAccessFileFactory");
        this.listener = listener;
        this.bufferUnlockThreshold = f;
        this.coroutineDispatcher = coroutineDispatcher;
        this.randomAccessVideoFile = LazyKt.lazy(new d(randomAccessFileFactory, videoAsset, tempHelper, f5Var));
        this.expectedVideoSize = videoAsset.getExpectedFileSize();
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/chartboost/sdk/impl/u8;", "a", "()Lcom/chartboost/sdk/impl/u8;"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<u8> {
        public final /* synthetic */ Function3<gb, z9, f5, u8> b;
        public final /* synthetic */ gb c;
        public final /* synthetic */ z9 d;
        public final /* synthetic */ f5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function3<? super gb, ? super z9, ? super f5, u8> function3, gb gbVar, z9 z9Var, f5 f5Var) {
            super(0);
            this.b = function3;
            this.c = gbVar;
            this.d = z9Var;
            this.e = f5Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u8 invoke() {
            return this.b.invoke(this.c, this.d, this.e);
        }
    }

    public final u8 d() {
        return (u8) this.randomAccessVideoFile.getValue();
    }

    public final void c() {
        this.calculateBufferStatusJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new c(null), 3, null);
    }

    public final void b() {
        u8 u8VarD = d();
        long jC = u8VarD != null ? u8VarD.c() : 0L;
        long j = this.expectedVideoSize;
        if (jC == j) {
            f();
        } else if ((jC - this.sizeOnBuffer) / j > this.bufferUnlockThreshold) {
            f();
        } else {
            c();
        }
    }

    public /* synthetic */ ib(gb gbVar, b bVar, float f, z9 z9Var, f5 f5Var, CoroutineDispatcher coroutineDispatcher, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gbVar, bVar, (i & 4) != 0 ? 0.01f : f, (i & 8) != 0 ? new z9() : z9Var, f5Var, (i & 32) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 64) != 0 ? a.b : function3);
    }

    public final void f() {
        this.sizeOnBuffer = 0L;
        e();
        this.listener.b();
    }

    public final void a() {
        if (this.sizeOnBuffer == 0) {
            u8 u8VarD = d();
            this.sizeOnBuffer = u8VarD != null ? u8VarD.c() : 0L;
        }
    }

    public final void e() {
        Job job = this.calculateBufferStatusJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.calculateBufferStatusJob = null;
    }

    public final void a(int totalVideoDuration) {
        long j = this.expectedVideoSize;
        if (j <= 0 || totalVideoDuration <= 0) {
            return;
        }
        float f = j / 1000000.0f;
        this.bufferUnlockThreshold = ((f / 1000.0f) / ((totalVideoDuration / 60000.0f) * 0.0075f)) / (f * 8);
    }
}
