package com.yandex.mobile.ads.impl;

import android.os.Looper;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class ce {
    private static final Object i = new Object();
    private static volatile ce j;
    public static final /* synthetic */ int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8592a;
    private final long b;
    private final Set<b60> c;
    private final CoroutineScope d;
    private final ae e;
    private final be f;
    private final r42 g;
    private final AtomicBoolean h;

    @DebugMetadata(c = "com.monetization.ads.core.anr.AnrTracker$startTracking$1", f = "AnrTracker.kt", i = {}, l = {26, 27}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ce.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ce.this.new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0032 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x003b  */
        /* JADX WARN: Code duplicated, block: B:18:0x0049 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0047 -> B:11:0x001e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x003b
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1b
            Lf:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L17:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L33
            L1b:
                kotlin.ResultKt.throwOnFailure(r7)
            L1e:
                com.yandex.mobile.ads.impl.ce r7 = com.yandex.mobile.ads.impl.ce.this
                com.yandex.mobile.ads.impl.ae r7 = com.yandex.mobile.ads.impl.ce.a(r7)
                com.yandex.mobile.ads.impl.ce r1 = com.yandex.mobile.ads.impl.ce.this
                long r4 = com.yandex.mobile.ads.impl.ce.c(r1)
                r6.b = r3
                java.lang.Object r7 = r7.a(r4, r6)
                if (r7 != r0) goto L33
                return r0
            L33:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L4a
                com.yandex.mobile.ads.impl.ce r7 = com.yandex.mobile.ads.impl.ce.this
                long r4 = com.yandex.mobile.ads.impl.ce.b(r7)
                r6.b = r2
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                if (r7 != r0) goto L1e
                return r0
            L4a:
                com.yandex.mobile.ads.impl.ce r7 = com.yandex.mobile.ads.impl.ce.this
                com.yandex.mobile.ads.impl.ce.f(r7)
                com.yandex.mobile.ads.impl.ce r7 = com.yandex.mobile.ads.impl.ce.this
                java.util.concurrent.atomic.AtomicBoolean r7 = com.yandex.mobile.ads.impl.ce.d(r7)
                r0 = 0
                r7.set(r0)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.ce.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void f(ce ceVar) {
        ceVar.g.getClass();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Intrinsics.checkNotNullExpressionValue(allStackTraces, "getAllStackTraces(...)");
        StackTraceElement[] stackTraceElementArr = allStackTraces.get(Looper.getMainLooper().getThread());
        if (stackTraceElementArr == null || !c22.a(stackTraceElementArr, ceVar.c)) {
            return;
        }
        ceVar.f.a(allStackTraces);
    }

    private ce(long j2, long j3, Set<b60> set, CoroutineScope coroutineScope, ae aeVar, be beVar, r42 r42Var) {
        this.f8592a = j2;
        this.b = j3;
        this.c = set;
        this.d = coroutineScope;
        this.e = aeVar;
        this.f = beVar;
        this.g = r42Var;
        this.h = new AtomicBoolean(false);
    }

    public /* synthetic */ ce(long j2, long j3, Set set, CoroutineScope coroutineScope, ae aeVar, be beVar, r42 r42Var, int i2) {
        this(j2, j3, set, coroutineScope, aeVar, beVar, r42Var);
    }

    public final void c() {
        if (this.h.getAndSet(true)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(null), 3, null);
    }
}
