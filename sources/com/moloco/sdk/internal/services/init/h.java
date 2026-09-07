package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import android.util.Base64;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements g {
    public static final a e = new a(null);
    public static final String f = "InitCacheImpl";
    public final SharedPreferences b;
    public final CoroutineContext c;
    public final AndroidClientMetrics d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearAll$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6403a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6403a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            h.this.b.edit().clear().commit();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearCache$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6404a;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6404a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = h.this.d.startTimerEvent("SDKInitCacheClear");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Clearing cache for mediation: " + this.c.d(), null, false, 12, null);
                SharedPreferences.Editor editor = h.this.b.edit();
                h hVar = h.this;
                com.moloco.sdk.internal.services.init.a aVar = this.c;
                Intrinsics.checkNotNullExpressionValue(editor, "editor");
                hVar.a(aVar, editor);
                editor.remove(this.c.e());
                if (editor.commit()) {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully cleared cache for mediation: " + this.c.d(), null, false, 12, null);
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheClear").withTag("Result", "success"));
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                } else {
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to clear cache for mediation: " + this.c.d(), null, false, 12, null);
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheClear").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "commit_failure"));
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "commit_failure"));
                }
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to clear cache for mediation: " + this.c.d() + " with exception", e, false, 8, null);
                AndroidClientMetrics androidClientMetrics = h.this.d;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheClear").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "e.javaClass.simpleName");
                androidClientMetrics.recordCountEvent(countEventWithTag.withTag("Reason", simpleName));
                AndroidClientMetrics androidClientMetrics2 = h.this.d;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "e.javaClass.simpleName");
                androidClientMetrics2.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName2));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$get$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Init.SDKInitResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6405a;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Init.SDKInitResponse> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6405a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = h.this.d.startTimerEvent("SDKInitCacheRead");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Reading cache for mediation: " + this.c.d(), null, false, 12, null);
                String string = h.this.b.getString(this.c.e(), null);
                Init.SDKInitResponse from = string != null ? Init.SDKInitResponse.parseFrom(Base64.decode(string, 0)) : null;
                if (from != null) {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully read cache for mediation: " + this.c.d(), null, false, 12, null);
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheRead").withTag("Result", "success"));
                } else {
                    MolocoLogger.info$default(molocoLogger, h.f, "Failed to read from cache (cache_miss) for mediation: " + this.c.d(), null, false, 12, null);
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "cache_miss"));
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheRead").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", "cache_miss"));
                }
                return from;
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to read cache for mediation: " + this.c.d() + " with exception", e, false, 8, null);
                AndroidClientMetrics androidClientMetrics = h.this.d;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "e.javaClass.simpleName");
                androidClientMetrics.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName));
                AndroidClientMetrics androidClientMetrics2 = h.this.d;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheRead").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "e.javaClass.simpleName");
                androidClientMetrics2.recordCountEvent(countEventWithTag.withTag("Reason", simpleName2));
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$updateCache$2", f = "InitCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6406a;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a c;
        public final /* synthetic */ Init.SDKInitResponse d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.internal.services.init.a aVar, Init.SDKInitResponse sDKInitResponse, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = aVar;
            this.d = sDKInitResponse;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new e(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6406a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimerEvent timerEventStartTimerEvent = h.this.d.startTimerEvent("SDKInitCacheWrite");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, h.f, "Updating cache for mediation: " + this.c.d(), null, false, 12, null);
                boolean z = false;
                String strEncodeToString = Base64.encodeToString(this.d.toByteArray(), 0);
                if (strEncodeToString == null || strEncodeToString.length() == 0) {
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to encode SDKInitResponse for mediation: " + this.c.d(), null, false, 12, null);
                    z = true;
                }
                if (z || !h.this.b.edit().putString(this.c.e(), strEncodeToString).commit()) {
                    String str = z ? "encoding_failure" : "commit_failure";
                    MolocoLogger.warn$default(molocoLogger, h.f, "Failed to update cache for mediation: " + this.c.d() + " with error: " + str, null, false, 12, null);
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", str));
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheWrite").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE).withTag("Reason", str));
                } else {
                    MolocoLogger.info$default(molocoLogger, h.f, "Successfully updated cache for mediation: " + this.c.d(), null, false, 12, null);
                    h.this.d.recordTimerEvent(timerEventStartTimerEvent.withTag("Result", "success"));
                    h.this.d.recordCountEvent(new CountEvent("SDKInitCacheWrite").withTag("Result", "success"));
                }
            } catch (Exception e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, h.f, "Failed to update cache for mediation: " + this.c.d() + " with exception", e, false, 8, null);
                AndroidClientMetrics androidClientMetrics = h.this.d;
                TimerEvent timerEventWithTag = timerEventStartTimerEvent.withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "e.javaClass.simpleName");
                androidClientMetrics.recordTimerEvent(timerEventWithTag.withTag("Reason", simpleName));
                AndroidClientMetrics androidClientMetrics2 = h.this.d;
                CountEvent countEventWithTag = new CountEvent("SDKInitCacheWrite").withTag("Result", LoginLogger.EVENT_EXTRAS_FAILURE);
                String simpleName2 = e.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "e.javaClass.simpleName");
                androidClientMetrics2.recordCountEvent(countEventWithTag.withTag("Reason", simpleName2));
            }
            return Unit.INSTANCE;
        }
    }

    public h(SharedPreferences sharedPreferences, CoroutineContext ioDispatcherContext, AndroidClientMetrics acm) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(ioDispatcherContext, "ioDispatcherContext");
        Intrinsics.checkNotNullParameter(acm, "acm");
        this.b = sharedPreferences;
        this.c = ioDispatcherContext;
        this.d = acm;
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object b(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(this.c, new c(aVar, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(com.moloco.sdk.internal.services.init.a aVar, Init.SDKInitResponse sDKInitResponse, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(this.c, new e(aVar, sDKInitResponse, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(com.moloco.sdk.internal.services.init.a aVar, Continuation<? super Init.SDKInitResponse> continuation) {
        return BuildersKt.withContext(this.c, new d(aVar, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.init.g
    public Object a(Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(this.c, new b(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void a(com.moloco.sdk.internal.services.init.a aVar, SharedPreferences.Editor editor) {
        Iterator<String> it = aVar.f().iterator();
        while (it.hasNext()) {
            editor.remove(it.next());
        }
    }
}
