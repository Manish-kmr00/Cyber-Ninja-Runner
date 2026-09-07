package com.moloco.sdk.internal.publisher.nativead;

import android.content.Context;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ortb.model.q;
import com.moloco.sdk.internal.publisher.o;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.s;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.internal.services.i0;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.smaato.sdk.video.vast.model.Ad;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final a k = new a(null);
    public static final String l = "NativeAdLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6218a;
    public final String b;
    public final o c;
    public final com.moloco.sdk.internal.publisher.nativead.parser.a d;
    public final com.moloco.sdk.internal.publisher.a e;
    public final AndroidClientMetrics f;
    public final i0 g;
    public final AdFormatType h;
    public final TimerEvent i;
    public final DispatcherProvider j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b {
        public static final int d = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.moloco.sdk.internal.ortb.model.c f6219a;
        public final com.moloco.sdk.internal.publisher.nativead.model.b b;
        public final com.moloco.sdk.internal.publisher.nativead.model.d c;

        public b(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            this.f6219a = bid;
            this.b = ortbResponse;
            this.c = preparedAssets;
        }

        public final com.moloco.sdk.internal.ortb.model.c a() {
            return this.f6219a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b b() {
            return this.b;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d c() {
            return this.c;
        }

        public final com.moloco.sdk.internal.ortb.model.c d() {
            return this.f6219a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f6219a, bVar.f6219a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d f() {
            return this.c;
        }

        public int hashCode() {
            return (((this.f6219a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "LoadedNativeAd(bid=" + this.f6219a + ", ortbResponse=" + this.b + ", preparedAssets=" + this.c + ')';
        }

        public final b a(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            return new b(bid, ortbResponse, preparedAssets);
        }

        public static /* synthetic */ b a(b bVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.internal.publisher.nativead.model.b bVar2, com.moloco.sdk.internal.publisher.nativead.model.d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = bVar.f6219a;
            }
            if ((i & 2) != 0) {
                bVar2 = bVar.b;
            }
            if ((i & 4) != 0) {
                dVar = bVar.c;
            }
            return bVar.a(cVar, bVar2, dVar);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.c$c, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0}, l = {239}, m = "fetchAssets-8Mi8wO0", n = {"this", Ad.AD_TYPE, "nativeAdPrepareTime"}, s = {"L$0", "L$1", "L$2"})
    public static final class C0546c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6220a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public C0546c(Continuation<? super C0546c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.a((com.moloco.sdk.internal.publisher.nativead.model.b) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$fireAdLoadFailedEventOnUiThread$2", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6221a;
        public final /* synthetic */ x b;
        public final /* synthetic */ s c;
        public final /* synthetic */ q d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar, s sVar, q qVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = xVar;
            this.c = sVar;
            this.d = qVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6221a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1, 2}, l = {189, 202, 209}, m = "handleAssetsFetching-yxL6bBk", n = {"this", "sdkEvents", "adLoadTracker", "timeoutError", "error"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6222a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object objA = c.this.a((q) null, (com.moloco.sdk.internal.publisher.nativead.model.b) null, (x) null, 0L, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$handleAssetsFetching$result$1", f = "NativeAdLoader.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6223a;
        public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.b c;
        public final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.moloco.sdk.internal.publisher.nativead.model.b bVar, long j, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = bVar;
            this.d = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6223a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar = c.this;
                com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
                long j = this.d;
                this.f6223a = 1;
                obj = cVar.a(bVar, j, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1}, l = {143, 159}, m = "handleBidParsing-BWLJW6A", n = {"this", "acmLoadTimerEvent", "adLoadTracker", "it"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6224a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object objA = c.this.a((String) null, (TimerEvent) null, (x) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0}, l = {175}, m = "handleOrtbParsing-BWLJW6A", n = {"result"}, s = {"L$0"})
    public static final class h extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6225a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = c.this.a((String) null, (q) null, (x) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {99}, m = "load-BWLJW6A", n = {}, s = {})
    public static final class i extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6226a;
        public int c;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f6226a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objB = c.this.b(null, null, null, this);
            return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Result.m7903boximpl(objB);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2", f = "NativeAdLoader.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {111, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 126, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE}, m = "invokeSuspend", n = {"adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "ortbResponse"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "L$1"})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6227a;
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ TimerEvent f;
        public final /* synthetic */ String g;
        public final /* synthetic */ x h;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2$1", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6228a;
            public final /* synthetic */ x b;
            public final /* synthetic */ c c;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x xVar, c cVar, com.moloco.sdk.internal.ortb.model.c cVar2, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = xVar;
                this.c = cVar;
                this.d = cVar2;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6228a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.a(MolocoAdKt.createAdInfo(this.c.b, Boxing.boxFloat(this.d.g())), this.e, this.d.e().g());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TimerEvent timerEvent, String str, x xVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.f = timerEvent;
            this.g = str;
            this.h = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<b>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new j(this.f, this.g, this.h, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0117 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x0118  */
        /* JADX WARN: Code duplicated, block: B:30:0x0121  */
        /* JADX WARN: Code duplicated, block: B:32:0x0141 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0142  */
        /* JADX WARN: Code duplicated, block: B:36:0x014a  */
        /* JADX WARN: Code duplicated, block: B:38:0x015c  */
        /* JADX WARN: Code duplicated, block: B:40:0x016b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            long j;
            com.moloco.sdk.internal.ortb.model.c cVar;
            long j2;
            Object objA2;
            com.moloco.sdk.internal.ortb.model.c cVar2;
            long j3;
            Object value;
            Throwable thM7907exceptionOrNullimpl;
            com.moloco.sdk.internal.publisher.nativead.model.b bVar;
            Object objA3;
            com.moloco.sdk.internal.ortb.model.c cVar3;
            com.moloco.sdk.internal.publisher.nativead.model.b bVar2;
            Throwable thM7907exceptionOrNullimpl2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i != 0) {
                if (i == 1) {
                    j = this.f6227a;
                    ResultKt.throwOnFailure(obj);
                    objA = ((Result) obj).getValue();
                } else if (i == 2) {
                    j2 = this.f6227a;
                    cVar = (com.moloco.sdk.internal.ortb.model.c) this.b;
                    ResultKt.throwOnFailure(obj);
                    c cVar4 = c.this;
                    String strA = cVar.a();
                    q qVarG = cVar.e().g();
                    x xVar = this.h;
                    this.b = cVar;
                    this.f6227a = j2;
                    this.d = 3;
                    objA2 = cVar4.a(strA, qVarG, xVar, this);
                    if (objA2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar2 = cVar;
                    j3 = j2;
                    value = objA2;
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(value);
                    if (thM7907exceptionOrNullimpl != null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl)));
                    }
                    bVar = (com.moloco.sdk.internal.publisher.nativead.model.b) value;
                    c cVar5 = c.this;
                    q qVarG2 = cVar2.e().g();
                    x xVar2 = this.h;
                    this.b = cVar2;
                    this.c = bVar;
                    this.d = 4;
                    objA3 = cVar5.a(qVarG2, bVar, xVar2, j3, this);
                    if (objA3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar3 = cVar2;
                    bVar2 = bVar;
                } else if (i == 3) {
                    long j4 = this.f6227a;
                    com.moloco.sdk.internal.ortb.model.c cVar6 = (com.moloco.sdk.internal.ortb.model.c) this.b;
                    ResultKt.throwOnFailure(obj);
                    value = ((Result) obj).getValue();
                    cVar2 = cVar6;
                    j3 = j4;
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(value);
                    if (thM7907exceptionOrNullimpl != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl)));
                    }
                    bVar = (com.moloco.sdk.internal.publisher.nativead.model.b) value;
                    c cVar7 = c.this;
                    q qVarG3 = cVar2.e().g();
                    x xVar3 = this.h;
                    this.b = cVar2;
                    this.c = bVar;
                    this.d = 4;
                    objA3 = cVar7.a(qVarG3, bVar, xVar3, j3, this);
                    if (objA3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar3 = cVar2;
                    bVar2 = bVar;
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar2 = (com.moloco.sdk.internal.publisher.nativead.model.b) this.c;
                    cVar3 = (com.moloco.sdk.internal.ortb.model.c) this.b;
                    ResultKt.throwOnFailure(obj);
                    objA3 = ((Result) obj).getValue();
                }
                thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(objA3);
                if (thM7907exceptionOrNullimpl2 == null) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m7903boximpl(Result.m7904constructorimpl(new b(cVar3, bVar2, (com.moloco.sdk.internal.publisher.nativead.model.d) objA3)));
                }
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl2)));
            }
            ResultKt.throwOnFailure(obj);
            long jA = c.this.g.a();
            this.f.startTimer();
            c.this.f.recordTimerEvent(c.this.i);
            AndroidClientMetrics androidClientMetrics = c.this.f;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdAttempt.b());
            String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
            String lowerCase = c.this.h.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase));
            c cVar8 = c.this;
            String str = this.g;
            TimerEvent timerEvent = this.f;
            x xVar4 = this.h;
            this.f6227a = jA;
            this.d = 1;
            objA = cVar8.a(str, timerEvent, xVar4, this);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jA;
            Throwable thM7907exceptionOrNullimpl3 = Result.m7907exceptionOrNullimpl(objA);
            if (thM7907exceptionOrNullimpl3 != null) {
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl3)));
            }
            cVar = (com.moloco.sdk.internal.ortb.model.c) objA;
            CoroutineContext main = c.this.j.getMain();
            a aVar = new a(this.h, c.this, cVar, j, null);
            this.b = cVar;
            this.f6227a = j;
            this.d = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j2 = j;
            c cVar9 = c.this;
            String strA2 = cVar.a();
            q qVarG4 = cVar.e().g();
            x xVar5 = this.h;
            this.b = cVar;
            this.f6227a = j2;
            this.d = 3;
            objA2 = cVar9.a(strA2, qVarG4, xVar5, this);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar2 = cVar;
            j3 = j2;
            value = objA2;
            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(value);
            if (thM7907exceptionOrNullimpl != null) {
                Result.Companion companion6 = Result.INSTANCE;
                return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl)));
            }
            bVar = (com.moloco.sdk.internal.publisher.nativead.model.b) value;
            c cVar10 = c.this;
            q qVarG5 = cVar2.e().g();
            x xVar6 = this.h;
            this.b = cVar2;
            this.c = bVar;
            this.d = 4;
            objA3 = cVar10.a(qVarG5, bVar, xVar6, j3, this);
            if (objA3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar3 = cVar2;
            bVar2 = bVar;
            thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(objA3);
            if (thM7907exceptionOrNullimpl2 == null) {
                Result.Companion companion7 = Result.INSTANCE;
                return Result.m7903boximpl(Result.m7904constructorimpl(new b(cVar3, bVar2, (com.moloco.sdk.internal.publisher.nativead.model.d) objA3)));
            }
            Result.Companion companion8 = Result.INSTANCE;
            return Result.m7903boximpl(Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl2)));
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {286}, m = "prepareAssets-8Mi8wO0", n = {}, s = {})
    public static final class k extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6229a;
        public int c;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6229a = obj;
            this.c |= Integer.MIN_VALUE;
            return c.this.a((List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a>) null, 0L, this);
        }
    }

    public c(Context context, String adUnitId, o bidLoader, com.moloco.sdk.internal.publisher.nativead.parser.a ortbResponseParser, com.moloco.sdk.internal.publisher.a createLoadTimeoutManager, AndroidClientMetrics acm, i0 timeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bidLoader, "bidLoader");
        Intrinsics.checkNotNullParameter(ortbResponseParser, "ortbResponseParser");
        Intrinsics.checkNotNullParameter(createLoadTimeoutManager, "createLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(acm, "acm");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f6218a = context;
        this.b = adUnitId;
        this.c = bidLoader;
        this.d = ortbResponseParser;
        this.e = createLoadTimeoutManager;
        this.f = acm;
        this.g = timeProvider;
        AdFormatType adFormatType = AdFormatType.NATIVE;
        this.h = adFormatType;
        TimerEvent timerEventStartTimerEvent = acm.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.CreateToLoad.b());
        String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.i = timerEventStartTimerEvent.withTag(strB, lowerCase);
        this.j = com.moloco.sdk.internal.scheduling.b.a();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(String str, TimerEvent timerEvent, x xVar, Continuation<? super Result<b>> continuation) throws Throwable {
        i iVar;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i2 = iVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                iVar.c = i2 - Integer.MIN_VALUE;
            } else {
                iVar = new i(continuation);
            }
        } else {
            iVar = new i(continuation);
        }
        Object objWithContext = iVar.f6226a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = iVar.c;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineContext coroutineContext = this.j.getDefault();
            j jVar = new j(timerEvent, str, xVar, null);
            iVar.c = 1;
            objWithContext = BuildersKt.withContext(coroutineContext, jVar, iVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, TimerEvent timerEvent, x xVar, Continuation<? super Result<com.moloco.sdk.internal.ortb.model.c>> continuation) throws Throwable {
        g gVar;
        c cVar;
        v vVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i2 = gVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.f = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object objA = gVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = gVar.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            o oVar = this.c;
            String str2 = this.b;
            gVar.f6224a = this;
            gVar.b = timerEvent;
            gVar.c = xVar;
            gVar.f = 1;
            objA = oVar.a(str2, str, gVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar = this;
        } else {
            if (i3 == 1) {
                xVar = (x) gVar.c;
                timerEvent = (TimerEvent) gVar.b;
                cVar = (c) gVar.f6224a;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                vVar = (v) gVar.f6224a;
                ResultKt.throwOnFailure(objA);
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(((s) ((v.a) vVar).a()).toString())));
        }
        v vVar2 = (v) objA;
        if (vVar2 instanceof v.a) {
            AndroidClientMetrics androidClientMetrics = cVar.f;
            TimerEvent timerEventWithTag = timerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            String strB = cVar2.b();
            MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
            TimerEvent timerEventWithTag2 = timerEventWithTag.withTag(strB, String.valueOf(errorType.getErrorCode()));
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.AdType;
            String strB2 = cVar3.b();
            String strName = cVar.h.name();
            Locale locale = Locale.ROOT;
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics.recordTimerEvent(timerEventWithTag2.withTag(strB2, lowerCase));
            AndroidClientMetrics androidClientMetrics2 = cVar.f;
            CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.LoadAdFailed.b()).withTag(cVar2.b(), String.valueOf(errorType.getErrorCode()));
            String strB3 = cVar3.b();
            String lowerCase2 = cVar.h.name().toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics2.recordCountEvent(countEventWithTag.withTag(strB3, lowerCase2));
            s sVar = (s) ((v.a) vVar2).a();
            gVar.f6224a = vVar2;
            gVar.b = null;
            gVar.c = null;
            gVar.f = 2;
            if (cVar.a(xVar, sVar, (q) null, gVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar = vVar2;
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(((s) ((v.a) vVar).a()).toString())));
        }
        if (!(vVar2 instanceof v.b)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m7904constructorimpl(((v.b) vVar2).a());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, q qVar, x xVar, Continuation<? super Result<com.moloco.sdk.internal.publisher.nativead.model.b>> continuation) throws Throwable {
        h hVar;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i2 = hVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                hVar.e = i2 - Integer.MIN_VALUE;
            } else {
                hVar = new h(continuation);
            }
        } else {
            hVar = new h(continuation);
        }
        Object obj = hVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = hVar.e;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = hVar.f6225a;
            ResultKt.throwOnFailure(obj);
            return obj2;
        }
        ResultKt.throwOnFailure(obj);
        Object objA = this.d.a(str);
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
        if (thM7907exceptionOrNullimpl == null) {
            return objA;
        }
        MolocoLogger.error$default(MolocoLogger.INSTANCE, l, "handleOrtbParsing", thM7907exceptionOrNullimpl, false, 8, null);
        s sVarA = t.a(this.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.NATIVE_AD_ORTB_RESPONSE_NULL_ERROR);
        hVar.f6225a = objA;
        hVar.b = objA;
        hVar.e = 1;
        return a(xVar, sVarA, qVar, hVar) == coroutine_suspended ? coroutine_suspended : objA;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(q qVar, com.moloco.sdk.internal.publisher.nativead.model.b bVar, x xVar, long j2, Continuation<? super Result<com.moloco.sdk.internal.publisher.nativead.model.d>> continuation) throws Throwable {
        e eVar;
        q qVar2;
        x xVar2;
        c cVar;
        s sVar;
        s sVar2;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.f = i2 - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        e eVar2 = eVar;
        Object objM9406withTimeoutOrNullKLykuaI = eVar2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = eVar2.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, l, "nativeAd load has " + j2 + " to load the ad", null, false, 12, null);
            long jA = this.e.a(j2);
            f fVar = new f(bVar, jA, null);
            eVar2.f6222a = this;
            qVar2 = qVar;
            eVar2.b = qVar2;
            xVar2 = xVar;
            eVar2.c = xVar2;
            eVar2.f = 1;
            objM9406withTimeoutOrNullKLykuaI = TimeoutKt.m9406withTimeoutOrNullKLykuaI(jA, fVar, eVar2);
            if (objM9406withTimeoutOrNullKLykuaI == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar = this;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    sVar2 = (s) eVar2.f6222a;
                    ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(sVar2.toString())));
                }
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sVar = (s) eVar2.f6222a;
                ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(sVar.toString())));
            }
            x xVar3 = (x) eVar2.c;
            q qVar3 = (q) eVar2.b;
            cVar = (c) eVar2.f6222a;
            ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
            xVar2 = xVar3;
            qVar2 = qVar3;
        }
        v vVar = (v) objM9406withTimeoutOrNullKLykuaI;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, l, "Handling native ad load result: " + vVar, null, false, 12, null);
        if (vVar == null) {
            MolocoLogger.warn$default(molocoLogger, l, "Native ad load timeout", null, false, 12, null);
            s sVarA = t.a(cVar.b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.NATIVE_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
            eVar2.f6222a = sVarA;
            eVar2.b = null;
            eVar2.c = null;
            eVar2.f = 2;
            if (cVar.a(xVar2, sVarA, qVar2, eVar2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sVar2 = sVarA;
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(sVar2.toString())));
        }
        if (vVar instanceof v.a) {
            s sVarA2 = t.a(cVar.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
            eVar2.f6222a = sVarA2;
            eVar2.b = null;
            eVar2.c = null;
            eVar2.f = 3;
            if (cVar.a(xVar2, sVarA2, qVar2, eVar2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sVar = sVarA2;
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Exception(sVar.toString())));
        }
        if (vVar instanceof v.b) {
            Result.Companion companion5 = Result.INSTANCE;
            return Result.m7904constructorimpl(((v.b) vVar).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object a(com.moloco.sdk.internal.publisher.nativead.model.b bVar, long j2, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) throws Throwable {
        C0546c c0546c;
        String str;
        TimerEvent timerEvent;
        c cVar;
        if (continuation instanceof C0546c) {
            c0546c = (C0546c) continuation;
            int i2 = c0546c.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0546c.f = i2 - Integer.MIN_VALUE;
            } else {
                c0546c = new C0546c(continuation);
            }
        } else {
            c0546c = new C0546c(continuation);
        }
        Object obj = c0546c.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c0546c.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            long duration = DurationKt.toDuration(RangesKt.coerceAtLeast(Duration.m9250getInWholeMillisecondsimpl(j2) - (this.g.a() - this.g.a()), 0L), DurationUnit.MILLISECONDS);
            List<com.moloco.sdk.internal.publisher.nativead.model.b.a> listA = bVar.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listA) {
                if (obj2 instanceof com.moloco.sdk.internal.publisher.nativead.model.b.a.d) {
                    arrayList.add(obj2);
                }
            }
            str = !arrayList.isEmpty() ? "video" : "image";
            TimerEvent timerEventStartTimerEvent = this.f.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.NativePrepareAd.b());
            AndroidClientMetrics androidClientMetrics = this.f;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.NativeAdLoadAdAttempted.b());
            String strB = com.moloco.sdk.internal.client_metrics_data.c.AdType.b();
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics.recordCountEvent(countEvent.withTag(strB, lowerCase));
            List<com.moloco.sdk.internal.publisher.nativead.model.b.a> listA2 = bVar.a();
            c0546c.f6220a = this;
            c0546c.b = str;
            c0546c.c = timerEventStartTimerEvent;
            c0546c.f = 1;
            Object objA = a(listA2, duration, c0546c);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            timerEvent = timerEventStartTimerEvent;
            obj = objA;
            cVar = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            timerEvent = (TimerEvent) c0546c.c;
            str = (String) c0546c.b;
            cVar = (c) c0546c.f6220a;
            ResultKt.throwOnFailure(obj);
        }
        v vVar = (v) obj;
        if (vVar instanceof v.a) {
            v.a aVar = (v.a) vVar;
            MolocoLogger.info$default(MolocoLogger.INSTANCE, l, "NativeAd load failed: " + ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b(), null, false, 12, null);
            AndroidClientMetrics androidClientMetrics2 = cVar.f;
            CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.NativeLoadAd.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            CountEvent countEventWithTag = countEvent2.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.AdType;
            String strB2 = cVar3.b();
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            CountEvent countEventWithTag2 = countEventWithTag.withTag(strB2, lowerCase2);
            com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.Reason;
            androidClientMetrics2.recordCountEvent(countEventWithTag2.withTag(cVar4.b(), ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b().a()).withTag("asset_id", String.valueOf(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).a())));
            AndroidClientMetrics androidClientMetrics3 = cVar.f;
            TimerEvent timerEventWithTag = timerEvent.withTag(cVar2.b(), LoginLogger.EVENT_EXTRAS_FAILURE);
            String strB3 = cVar3.b();
            String lowerCase3 = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics3.recordTimerEvent(timerEventWithTag.withTag(strB3, lowerCase3).withTag(cVar4.b(), ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b().a()).withTag("asset_id", String.valueOf(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).a())));
            return new v.a(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b());
        }
        if (vVar instanceof v.b) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, l, "NativeAd load successfully parsed and loaded all assets", null, false, 12, null);
            AndroidClientMetrics androidClientMetrics4 = cVar.f;
            CountEvent countEvent3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.NativeLoadAd.b());
            com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.Result;
            CountEvent countEventWithTag3 = countEvent3.withTag(cVar5.b(), "success");
            com.moloco.sdk.internal.client_metrics_data.c cVar6 = com.moloco.sdk.internal.client_metrics_data.c.AdType;
            String strB4 = cVar6.b();
            Locale locale2 = Locale.ROOT;
            String lowerCase4 = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics4.recordCountEvent(countEventWithTag3.withTag(strB4, lowerCase4));
            AndroidClientMetrics androidClientMetrics5 = cVar.f;
            TimerEvent timerEventWithTag2 = timerEvent.withTag(cVar5.b(), "success");
            String strB5 = cVar6.b();
            String lowerCase5 = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            androidClientMetrics5.recordTimerEvent(timerEventWithTag2.withTag(strB5, lowerCase5));
            return new v.b(((v.b) vVar).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> list, long j2, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> continuation) throws Throwable {
        k kVar;
        if (continuation instanceof k) {
            kVar = (k) continuation;
            int i2 = kVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kVar.c = i2 - Integer.MIN_VALUE;
            } else {
                kVar = new k(continuation);
            }
        } else {
            kVar = new k(continuation);
        }
        Object objA = kVar.f6229a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = kVar.c;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            Context context = this.f6218a;
            kVar.c = 1;
            objA = com.moloco.sdk.internal.publisher.nativead.parser.c.a(context, list, j2, kVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        v vVar = (v) objA;
        if (vVar instanceof v.b) {
            return new v.b(((v.b) vVar).a());
        }
        if (vVar instanceof v.a) {
            v.a aVar = (v.a) vVar;
            MolocoLogger.error$default(MolocoLogger.INSTANCE, l, "NativeAd prepareAssets failed", (Throwable) aVar.a(), false, 8, null);
            return new v.a(aVar.a());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object a(x xVar, s sVar, q qVar, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(this.j.getMain(), new d(xVar, sVar, qVar, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
