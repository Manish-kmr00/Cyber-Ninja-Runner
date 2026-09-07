package com.moloco.sdk.acm.eventprocessing;

import android.database.sqlite.SQLiteException;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.EventTag;
import com.moloco.sdk.acm.TimerEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements h {
    public static final a e = new a(null);
    public static final String f = "EventProcessor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.db.d f6025a;
    public final com.moloco.sdk.acm.services.g b;
    public final l c;
    public final com.moloco.sdk.acm.services.b d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processCountEvent$2", f = "EventProcessor.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6026a;
        public final /* synthetic */ CountEvent c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CountEvent countEvent, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = countEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6026a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                String name = this.c.getName();
                com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.COUNT;
                long countValue = this.c.getCountValue();
                List<EventTag> eventTags = this.c.getEventTags();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags, 10));
                Iterator<T> it = eventTags.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.moloco.sdk.acm.d.a((EventTag) it.next()));
                }
                this.f6026a = 1;
                if (iVar.a(name, cVar, countValue, arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processEvent$2", f = "EventProcessor.kt", i = {}, l = {79, 80}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6027a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i c;
        public final /* synthetic */ com.moloco.sdk.acm.db.c d;
        public final /* synthetic */ long e;
        public final /* synthetic */ List<String> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, i iVar, com.moloco.sdk.acm.db.c cVar, long j, List<String> list, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = iVar;
            this.d = cVar;
            this.e = j;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6027a;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.c.f6025a.a(new com.moloco.sdk.acm.db.b(0L, this.b, this.c.b.invoke(), this.d, Boxing.boxLong(this.e), this.f, 1, null));
                l lVar = this.c.c;
                this.f6027a = 1;
                if (lVar.b(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                com.moloco.sdk.acm.services.b bVar = this.c.d;
                this.f6027a = 2;
                if (bVar.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (SQLiteException e) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, i.f, "Database error: " + e.getMessage(), false, 4, null);
            } catch (Exception e2) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, i.f, "Unexpected error while processing event: " + e2.getMessage(), false, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processTimerEvent$2", f = "EventProcessor.kt", i = {}, l = {TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER, 60}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6028a;
        public final /* synthetic */ TimerEvent b;
        public final /* synthetic */ i c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TimerEvent timerEvent, i iVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = timerEvent;
            this.c = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6028a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b.getTimeInMillis() > 0) {
                    i iVar = this.c;
                    String name = this.b.getName();
                    com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.TIMER;
                    long timeInMillis = this.b.getTimeInMillis();
                    List<EventTag> eventTags = this.b.getEventTags();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags, 10));
                    Iterator<T> it = eventTags.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.moloco.sdk.acm.d.a((EventTag) it.next()));
                    }
                    this.f6028a = 1;
                    if (iVar.a(name, cVar, timeInMillis, arrayList, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    i iVar2 = this.c;
                    String str = "negative_time_" + this.b.getName();
                    com.moloco.sdk.acm.db.c cVar2 = com.moloco.sdk.acm.db.c.TIMER;
                    long timeInMillis2 = this.b.getTimeInMillis();
                    List<EventTag> eventTags2 = this.b.getEventTags();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags2, 10));
                    Iterator<T> it2 = eventTags2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(com.moloco.sdk.acm.d.a((EventTag) it2.next()));
                    }
                    this.f6028a = 2;
                    if (iVar2.a(str, cVar2, timeInMillis2, arrayList2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public i(com.moloco.sdk.acm.db.d metricsDAO, com.moloco.sdk.acm.services.g timeProviderService, l requestScheduler, com.moloco.sdk.acm.services.b applicationLifecycle) {
        Intrinsics.checkNotNullParameter(metricsDAO, "metricsDAO");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(requestScheduler, "requestScheduler");
        Intrinsics.checkNotNullParameter(applicationLifecycle, "applicationLifecycle");
        this.f6025a = metricsDAO;
        this.b = timeProviderService;
        this.c = requestScheduler;
        this.d = applicationLifecycle;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.h
    public Object a(CountEvent countEvent, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new b(countEvent, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.h
    public Object a(TimerEvent timerEvent, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new d(timerEvent, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final Object a(String str, com.moloco.sdk.acm.db.c cVar, long j, List<String> list, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new c(str, this, cVar, j, list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
