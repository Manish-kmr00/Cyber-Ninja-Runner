package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.ReaderConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes12.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f12122a;
    private final l0 b;
    private final String c;
    private final CoroutineScope d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReaderConfig f12123a;
        private final String b;
        private final Struct c;
        private final g0.a d;

        public a(ReaderConfig readerConfig, String str, Struct struct, g0.a aVar) {
            this.f12123a = readerConfig;
            this.b = str;
            this.c = struct;
            this.d = aVar;
        }

        public final g0.a a() {
            return this.d;
        }

        public final Struct b() {
            return this.c;
        }

        public final ReaderConfig c() {
            return this.f12123a;
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12124a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object objA = n0.this.a((String) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12125a;
        /* synthetic */ Object b;
        int d;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return n0.this.a((List) null, this);
        }
    }

    static final class d extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12126a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return n0.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f12126a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g0 g0Var = new g0(n0.this.f12122a.c().getUrl(), n0.this.f12122a.c().getName(), n0.this.f12122a.b(), this.c, n0.this.f12122a.a(), null, 32, null);
                this.f12126a = 1;
                objA = g0Var.a(this);
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
            n0 n0Var = n0.this;
            List list = this.c;
            if (Result.m7911isSuccessimpl(objA)) {
                l0 l0Var = n0Var.b;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (((h0) obj2).b() != null) {
                        arrayList.add(obj2);
                    }
                }
                l0Var.b(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (((h0) obj3).b() == null) {
                        arrayList2.add(obj3);
                    }
                }
                n0Var.b.c(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    n0Var.a((h0) it.next());
                }
            }
            n0 n0Var2 = n0.this;
            List list2 = this.c;
            if (Result.m7907exceptionOrNullimpl(objA) != null) {
                n0Var2.b.c(list2);
            }
            return Result.m7903boximpl(objA);
        }
    }

    static final class e extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12127a;
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, List list, Continuation continuation) {
            super(2, continuation);
            this.d = str;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return n0.this.new e(this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            List arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    arrayList = (List) this.f12127a;
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
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList();
            n0 n0Var = n0.this;
            String str = this.d;
            List list = this.e;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                if (((h0) obj2).b() != null) {
                    arrayList2.add(obj2);
                }
            }
            n0Var.a(str, arrayList2);
            List<h0> list2 = this.e;
            n0 n0Var2 = n0.this;
            for (h0 h0Var : list2) {
                if (Result.m7910isFailureimpl(n0Var2.a(h0Var))) {
                    arrayList.add(h0Var);
                }
            }
            n0 n0Var3 = n0.this;
            String str2 = this.d;
            this.f12127a = arrayList;
            this.b = 1;
            if (n0Var3.a(str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!arrayList.isEmpty()) {
                n0 n0Var4 = n0.this;
                this.f12127a = null;
                this.b = 2;
                if (n0Var4.a(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public n0(p0 p0Var, a aVar, l0 l0Var) {
        this.f12122a = aVar;
        this.b = l0Var;
        this.c = aVar.c().getName();
        this.d = CoroutineScopeKt.CoroutineScope(new CoroutineName("AnalyticsMonitor: " + aVar.c().getName()).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(p0Var.c()));
    }

    public final void b(String str, List list) {
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new e(str, list, null), 3, null);
    }

    public final String a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(String str, List list) {
        try {
            Result.Companion companion = Result.INSTANCE;
            l0 l0Var = this.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((h0) it.next()).e());
            }
            return Result.m7904constructorimpl(Result.m7903boximpl(l0Var.a(str, arrayList)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(List list, Continuation continuation) throws Throwable {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Object objA = this.b.a(list);
            if (Result.m7911isSuccessimpl(objA)) {
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.d, null, null, new d(list, null), 3, null);
                cVar.f12125a = objA;
                cVar.d = 1;
                if (deferredAsync$default.await(cVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, Continuation continuation) throws Throwable {
        b bVar;
        Object objA;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                objA = this.b.a(str);
                if (Result.m7911isSuccessimpl(objA)) {
                    List list = (List) objA;
                    if (!list.isEmpty()) {
                        bVar.f12124a = objA;
                        bVar.d = 1;
                        if (a(list, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objA = bVar.f12124a;
                ResultKt.throwOnFailure(obj);
            }
            return Result.m7904constructorimpl(Result.m7903boximpl(objA));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(h0 h0Var) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (h0Var.b() == null) {
                Object objA = this.b.a(h0Var.d(), h0Var.e());
                if (Result.m7910isFailureimpl(objA)) {
                    objA = null;
                }
                h0 h0Var2 = (h0) objA;
                if (h0Var2 != null) {
                    return this.b.a(h0Var.a((62 & 1) != 0 ? h0Var.f12089a : h0Var2.c(), (62 & 2) != 0 ? h0Var.b : null, (62 & 4) != 0 ? h0Var.c : 0L, (62 & 8) != 0 ? h0Var.d : null, (62 & 16) != 0 ? h0Var.e : null, (62 & 32) != 0 ? h0Var.f : null, (62 & 64) != 0 ? h0Var.g : (this.f12122a.c().getUniqueOnly() && Intrinsics.areEqual(h0Var.a(), h0Var2.a())) ? false : true));
                }
            }
            return this.b.b(h0Var);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }
}
