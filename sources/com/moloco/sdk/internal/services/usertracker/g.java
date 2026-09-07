package com.moloco.sdk.internal.services.usertracker;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6429a;
    public final com.moloco.sdk.internal.services.usertracker.b b;
    public final Mutex c;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1}, l = {48, 29}, m = "clear", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6430a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1, 1, 2, 2}, l = {48, 33, 36}, m = "getIdentifier", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "currentId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6431a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g.this.b(this);
        }
    }

    public g(e idGenerator, com.moloco.sdk.internal.services.usertracker.b idRepository) {
        Intrinsics.checkNotNullParameter(idGenerator, "idGenerator");
        Intrinsics.checkNotNullParameter(idRepository, "idRepository");
        this.f6429a = idGenerator;
        this.b = idRepository;
        this.c = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    public Object a(Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        Mutex mutex;
        g gVar;
        Mutex mutex2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.c;
                aVar.f6430a = this;
                aVar.b = mutex;
                aVar.e = 1;
                if (mutex.lock(null, aVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                gVar = this;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) aVar.f6430a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit;
                    } catch (Throwable th) {
                        Mutex mutex3 = mutex2;
                        th = th;
                        mutex = mutex3;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                Mutex mutex4 = (Mutex) aVar.b;
                gVar = (g) aVar.f6430a;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
            }
            com.moloco.sdk.internal.services.usertracker.b bVar = gVar.b;
            aVar.f6430a = mutex;
            aVar.b = null;
            aVar.e = 2;
            if (bVar.a(aVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return unit2;
        } catch (Throwable th2) {
            th = th2;
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0089 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:21:0x004c, B:34:0x0085, B:36:0x0089), top: B:47:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    public Object b(Continuation<? super String> continuation) throws Throwable {
        b bVar;
        Mutex mutex;
        g gVar;
        Mutex mutex2;
        Throwable th;
        g gVar2;
        Mutex mutex3;
        String strA;
        String str;
        com.moloco.sdk.internal.services.usertracker.b bVar2;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.c;
                bVar.f6431a = this;
                bVar.b = mutex;
                bVar.e = 1;
                if (mutex.lock(null, bVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                gVar = this;
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        mutex3 = (Mutex) bVar.b;
                        gVar2 = (g) bVar.f6431a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            strA = (String) obj;
                            if (strA == null) {
                                strA = gVar2.f6429a.a();
                                bVar2 = gVar2.b;
                                bVar.f6431a = mutex3;
                                bVar.b = strA;
                                bVar.e = 3;
                                if (bVar2.a(strA, bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            str = strA;
                            mutex2 = mutex3;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex3.unlock(null);
                            throw th;
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) bVar.b;
                        mutex2 = (Mutex) bVar.f6431a;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th3) {
                            th = th3;
                            mutex3 = mutex2;
                            mutex3.unlock(null);
                            throw th;
                        }
                    }
                    mutex2.unlock(null);
                    return str;
                }
                Mutex mutex4 = (Mutex) bVar.b;
                gVar = (g) bVar.f6431a;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
            }
            com.moloco.sdk.internal.services.usertracker.b bVar3 = gVar.b;
            bVar.f6431a = gVar;
            bVar.b = mutex;
            bVar.e = 2;
            Object objB = bVar3.b(bVar);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            gVar2 = gVar;
            mutex3 = mutex;
            obj = objB;
            strA = (String) obj;
            if (strA == null) {
                strA = gVar2.f6429a.a();
                bVar2 = gVar2.b;
                bVar.f6431a = mutex3;
                bVar.b = strA;
                bVar.e = 3;
                if (bVar2.a(strA, bVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            str = strA;
            mutex2 = mutex3;
            mutex2.unlock(null);
            return str;
        } catch (Throwable th4) {
            mutex2 = mutex;
            th = th4;
            mutex3 = mutex2;
            mutex3.unlock(null);
            throw th;
        }
    }
}
