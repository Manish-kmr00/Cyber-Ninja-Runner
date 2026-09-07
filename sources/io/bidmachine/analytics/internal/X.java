package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.MonitorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes10.dex */
public final class X {
    public static final a g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f12065a;
    private final V b;
    private final String c;
    private final CoroutineScope d;
    private Job e;
    private final AtomicBoolean f = new AtomicBoolean(false);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MonitorConfig f12066a;
        private final String b;
        private final Struct c;

        public b(MonitorConfig monitorConfig, String str, Struct struct) {
            this.f12066a = monitorConfig;
            this.b = str;
            this.c = struct;
        }

        public final Struct a() {
            return this.c;
        }

        public final MonitorConfig b() {
            return this.f12066a;
        }

        public final String c() {
            return this.b;
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12067a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12067a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                X x = X.this;
                List list = this.c;
                this.f12067a = 1;
                if (x.a(list, this) == coroutine_suspended) {
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

    static final class d extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12068a;

        d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12068a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            long interval = X.this.f12065a.b().getInterval();
            this.f12068a = 1;
            if (DelayKt.delay(interval, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            X x = X.this;
            this.f12068a = 2;
            if (x.a(0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12069a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return X.this.a((List) null, this);
        }
    }

    static final class f extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12070a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12070a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                P p = new P(X.this.f12065a.b().getUrl(), X.this.f12065a.b().getName(), X.this.f12065a.a(), this.c, null, 16, null);
                this.f12070a = 1;
                objA = p.a(this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objA = ((Result) obj).getValue();
            }
            X x = X.this;
            List list = this.c;
            if (Result.m7911isSuccessimpl(objA)) {
                x.b.b(list);
            }
            X x2 = X.this;
            List list2 = this.c;
            if (Result.m7907exceptionOrNullimpl(objA) != null) {
                x2.b.c(list2);
            }
            return Result.m7903boximpl(objA);
        }
    }

    static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12071a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = X.this.a(0, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    static final class h extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12072a;
        final /* synthetic */ Q c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Q q, Continuation continuation) {
            super(2, continuation);
            this.c = q;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new h(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12072a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Result.m7911isSuccessimpl(X.this.a(this.c))) {
                    X x = X.this;
                    int batchSize = x.f12065a.b().getBatchSize();
                    this.f12072a = 1;
                    if (x.a(batchSize, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    X x2 = X.this;
                    List listListOf = CollectionsKt.listOf(this.c);
                    this.f12072a = 2;
                    if (x2.a(listListOf, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public X(p0 p0Var, b bVar, V v) {
        this.f12065a = bVar;
        this.b = v;
        this.c = bVar.b().getName();
        this.d = CoroutineScopeKt.CoroutineScope(new CoroutineName("AnalyticsMonitor: " + bVar.b().getName()).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(p0Var.c()));
    }

    public final String b() {
        return this.c;
    }

    public final void b(Q q) {
        if (this.f.get()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new h(q, null), 3, null);
    }

    public final void a() {
        if (this.f.compareAndSet(false, true)) {
            Object objA = this.b.a(this.f12065a.b().getName(), this.f12065a.c());
            if (Result.m7911isSuccessimpl(objA)) {
                BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new c((List) objA, null), 3, null);
            }
        }
    }

    private final void a(boolean z) {
        Job job;
        if (this.f.get()) {
            return;
        }
        if (z || (job = this.e) == null || !job.isActive()) {
            Job job2 = this.e;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.e = BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new d(null), 3, null);
        }
    }

    static /* synthetic */ void a(X x, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        x.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(List list, Continuation continuation) throws Throwable {
        e eVar;
        Object objA;
        X x;
        Object obj;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.e = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object obj2 = eVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            objA = this.b.a(list);
            if (Result.m7911isSuccessimpl(objA)) {
                List listChunked = CollectionsKt.chunked(list, this.f12065a.b().getBatchSize());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
                Iterator it = listChunked.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(this.d, null, null, new f((List) it.next(), null), 3, null));
                }
                eVar.f12069a = this;
                eVar.b = objA;
                eVar.e = 1;
                if (AwaitKt.awaitAll(arrayList, eVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                x = this;
                obj = objA;
            } else {
                x = this;
            }
            if (Result.m7907exceptionOrNullimpl(objA) != null) {
                x.a(true);
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj = eVar.b;
        x = (X) eVar.f12069a;
        ResultKt.throwOnFailure(obj2);
        x.a(true);
        objA = obj;
        if (Result.m7907exceptionOrNullimpl(objA) != null) {
            x.a(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(int i, Continuation continuation) throws Throwable {
        g gVar;
        X x;
        Object obj;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i2 = gVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.e = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object obj2 = gVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = gVar.e;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj2);
                Result.Companion companion = Result.INSTANCE;
                Object objA = this.b.a(this.f12065a.b().getName(), this.f12065a.c(), this.f12065a.b().getBatchSize());
                if (Result.m7911isSuccessimpl(objA)) {
                    List list = (List) objA;
                    if (list.isEmpty() || list.size() < i) {
                        a(this, false, 1, null);
                    } else {
                        gVar.f12071a = this;
                        gVar.b = objA;
                        gVar.e = 1;
                        if (a(list, gVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                x = this;
                obj = objA;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = gVar.b;
                x = (X) gVar.f12071a;
                ResultKt.throwOnFailure(obj2);
            }
            if (Result.m7907exceptionOrNullimpl(obj) != null) {
                a(x, false, 1, null);
            }
            return Result.m7904constructorimpl(Result.m7903boximpl(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Q q) {
        try {
            Result.Companion companion = Result.INSTANCE;
            return this.b.a(q);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }
}
