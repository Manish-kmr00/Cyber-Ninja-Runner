package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC4633i extends AbstractC4634j {
    private final Lazy d = LazyKt.lazy(d.f12094a);
    private Job e;
    private a f;

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.i$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12091a;
        private final List b;
        private final InterfaceC4632h c;

        public a(long j, List list, InterfaceC4632h interfaceC4632h) {
            this.f12091a = j;
            this.b = list;
            this.c = interfaceC4632h;
        }

        public final InterfaceC4632h a() {
            return this.c;
        }

        public final long b() {
            return this.f12091a;
        }

        public final List c() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.i$b */
    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12092a;
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ a f;
        final /* synthetic */ AbstractC4633i g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, AbstractC4633i abstractC4633i, Continuation continuation) {
            super(2, continuation);
            this.f = aVar;
            this.g = abstractC4633i;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            b bVar = new b(this.f, this.g, continuation);
            bVar.e = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0064  */
        /* JADX WARN: Code duplicated, block: B:18:0x007a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x007b  */
        /* JADX WARN: Code duplicated, block: B:22:0x0084  */
        /* JADX WARN: Code duplicated, block: B:25:0x0089  */
        /* JADX WARN: Code duplicated, block: B:26:0x008c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b0 -> B:11:0x0041). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.d
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L39
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r11.e
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L41
            L17:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1f:
                java.lang.Object r1 = r11.c
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r5 = r11.b
                java.util.Collection r5 = (java.util.Collection) r5
                java.lang.Object r6 = r11.f12092a
                io.bidmachine.analytics.internal.i r6 = (io.bidmachine.analytics.internal.AbstractC4633i) r6
                java.lang.Object r7 = r11.e
                kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                kotlin.ResultKt.throwOnFailure(r12)
                kotlin.Result r12 = (kotlin.Result) r12
                java.lang.Object r12 = r12.getValue()
                goto L7e
            L39:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.e
                r1 = r12
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            L41:
                boolean r12 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r12 == 0) goto Lb2
                io.bidmachine.analytics.internal.i$a r12 = r11.f
                java.util.List r12 = r12.c()
                io.bidmachine.analytics.internal.i r5 = r11.g
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Iterator r12 = r12.iterator()
                r9 = r1
                r1 = r12
                r12 = r9
                r10 = r6
                r6 = r5
                r5 = r10
            L5e:
                boolean r7 = r1.hasNext()
                if (r7 == 0) goto L8e
                java.lang.Object r7 = r1.next()
                io.bidmachine.analytics.ReaderConfig$Rule r7 = (io.bidmachine.analytics.ReaderConfig.Rule) r7
                r11.e = r12
                r11.f12092a = r6
                r11.b = r5
                r11.c = r1
                r11.d = r3
                java.lang.Object r7 = io.bidmachine.analytics.internal.AbstractC4633i.a(r6, r7, r11)
                if (r7 != r0) goto L7b
                return r0
            L7b:
                r9 = r7
                r7 = r12
                r12 = r9
            L7e:
                boolean r8 = kotlin.Result.m7910isFailureimpl(r12)
                if (r8 == 0) goto L85
                r12 = r4
            L85:
                io.bidmachine.analytics.internal.h$a r12 = (io.bidmachine.analytics.internal.InterfaceC4632h.a) r12
                if (r12 == 0) goto L8c
                r5.add(r12)
            L8c:
                r12 = r7
                goto L5e
            L8e:
                java.util.List r5 = (java.util.List) r5
                io.bidmachine.analytics.internal.i$a r1 = r11.f
                io.bidmachine.analytics.internal.h r1 = r1.a()
                r1.a(r5)
                io.bidmachine.analytics.internal.i$a r1 = r11.f
                long r5 = r1.b()
                r11.e = r12
                r11.f12092a = r4
                r11.b = r4
                r11.c = r4
                r11.d = r2
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r5, r11)
                if (r1 != r0) goto Lb0
                return r0
            Lb0:
                r1 = r12
                goto L41
            Lb2:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.bidmachine.analytics.internal.AbstractC4633i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.i$c */
    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12093a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objB = AbstractC4633i.this.b(null, this);
            return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Result.m7903boximpl(objB);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.i$d */
    static final class d extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12094a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(p0.g.a().c()));
        }
    }

    public abstract Object a(ReaderConfig.Rule rule, Continuation continuation);

    public final CoroutineScope b() {
        return (CoroutineScope) this.d.getValue();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void e(Context context) {
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        a aVar = this.f;
        if (aVar == null) {
            return;
        }
        this.e = BuildersKt__Builders_commonKt.launch$default(b(), null, null, new b(aVar, this, null), 3, null);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(a aVar) {
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(ReaderConfig.Rule rule, Continuation continuation) throws Throwable {
        c cVar;
        AbstractC4633i abstractC4633i;
        Object objM7904constructorimpl;
        q0.a aVar;
        String strA;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.e = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            try {
                Result.Companion companion = Result.INSTANCE;
                cVar.f12093a = this;
                cVar.b = rule;
                cVar.e = 1;
                objA = a(rule, cVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractC4633i = this;
            } catch (Throwable th) {
                th = th;
                abstractC4633i = this;
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rule = (ReaderConfig.Rule) cVar.b;
            abstractC4633i = (AbstractC4633i) cVar.f12093a;
            try {
                ResultKt.throwOnFailure(objA);
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        objM7904constructorimpl = Result.m7904constructorimpl((String) objA);
        ReaderConfig.Rule rule2 = rule;
        String str = (String) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
        if (str != null) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m7904constructorimpl(new InterfaceC4632h.a(rule2, str, null, 4, null));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl instanceof CancellationException) {
            throw thM7907exceptionOrNullimpl;
        }
        if (thM7907exceptionOrNullimpl instanceof FileNotFoundException) {
            aVar = q0.a.READER_NO_CONTENT;
        } else {
            aVar = thM7907exceptionOrNullimpl instanceof SecurityException ? q0.a.READER_NO_ACCESS : q0.a.READER_INVALID;
        }
        if (thM7907exceptionOrNullimpl == null || (strA = s0.a(thM7907exceptionOrNullimpl)) == null) {
            strA = "";
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m7904constructorimpl(new InterfaceC4632h.a(rule2, null, new q0(abstractC4633i.a(), aVar, strA), 2, null));
    }
}
