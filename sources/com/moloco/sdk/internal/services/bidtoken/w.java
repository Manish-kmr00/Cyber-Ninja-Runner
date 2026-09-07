package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.i0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements v {
    public static final a e = new a(null);
    public static final String f = "ServerBidTokenCache";
    public static final long g = 15;
    public static final long h = 2;
    public final com.moloco.sdk.internal.bidtoken.b b;
    public final i0 c;
    public k d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0}, l = {62}, m = "tokenStatus", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6346a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return w.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0, 0, 1, 1, 1}, l = {95, 98}, m = "updateCache", n = {"this", "bidTokenComponents", "this", "bidTokenComponents", "newToken"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6347a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return w.this.a(null, this);
        }
    }

    public w(com.moloco.sdk.internal.bidtoken.b bidTokenParser, i0 timeProviderService) {
        Intrinsics.checkNotNullParameter(bidTokenParser, "bidTokenParser");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.b = bidTokenParser;
        this.c = timeProviderService;
        this.d = new k("", "", e.a());
    }

    public static /* synthetic */ void d() {
    }

    public final void a(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.d = kVar;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public void b() {
        this.d = new k("", "", e.a());
    }

    public final k c() {
        return this.d;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public k a() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public Object a(Continuation<? super b0> continuation) throws Throwable {
        b bVar;
        w wVar;
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
        Object objA = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (a().d().length() == 0) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] cached bidToken is empty, needs refresh", null, false, 12, null);
                return b0.NEEDS_REFRESH;
            }
            com.moloco.sdk.internal.bidtoken.b bVar2 = this.b;
            String strD = a().d();
            bVar.f6346a = this;
            bVar.d = 1;
            objA = bVar2.a(strD, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            wVar = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            wVar = (w) bVar.f6346a;
            ResultKt.throwOnFailure(objA);
        }
        com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) objA;
        if (vVar instanceof com.moloco.sdk.internal.v.a) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] Failed to parse cached token for expiration, needs refresh", null, false, 12, null);
            return b0.NEEDS_REFRESH;
        }
        if (vVar instanceof com.moloco.sdk.internal.v.b) {
            com.moloco.sdk.internal.bidtoken.a aVar = (com.moloco.sdk.internal.bidtoken.a) ((com.moloco.sdk.internal.v.b) vVar).a();
            long jA = wVar.c.a();
            if (x.a(aVar, jA)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] Bid token expired, needs refresh", null, false, 12, null);
                return b0.NEEDS_REFRESH;
            }
            if (x.b(aVar, jA)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] Bid token is near expiry. It will expire soon", null, false, 12, null);
                return b0.EXPIRING;
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] Bid token has not expired", null, false, 12, null);
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "] Bid token doesn't need refresh", null, false, 12, null);
        return b0.NO_REFRESH_NEEDED;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:35:0x0119  */
    /* JADX WARN: Code duplicated, block: B:36:0x0138  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public Object a(k kVar, Continuation<? super Unit> continuation) throws Throwable {
        c cVar;
        w wVar;
        k kVar2;
        com.moloco.sdk.internal.bidtoken.a aVar;
        w wVar2;
        com.moloco.sdk.internal.v vVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.f = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            a("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, checking for new token expiry");
            if (Intrinsics.areEqual(this.d.d(), "")) {
                this.d = kVar;
                a("[Thread: " + Thread.currentThread().getName() + "] Updated cache with new bidToken as existing token was empty");
                return Unit.INSTANCE;
            }
            com.moloco.sdk.internal.bidtoken.b bVar = this.b;
            String strD = kVar.d();
            cVar.f6347a = this;
            cVar.b = kVar;
            cVar.f = 1;
            objA = bVar.a(strD, cVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            wVar = this;
        } else {
            if (i2 == 1) {
                kVar = (k) cVar.b;
                wVar = (w) cVar.f6347a;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (com.moloco.sdk.internal.bidtoken.a) cVar.c;
                kVar2 = (k) cVar.b;
                wVar2 = (w) cVar.f6347a;
                ResultKt.throwOnFailure(objA);
            }
            vVar = (com.moloco.sdk.internal.v) objA;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                if (aVar.a() > ((com.moloco.sdk.internal.bidtoken.a) ((com.moloco.sdk.internal.v.b) vVar).a()).a()) {
                    wVar2.d = kVar2;
                    wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Updated cache with new bidToken");
                } else {
                    wVar2.a("[Thread: " + Thread.currentThread().getName() + "] New token's expiration is not greater than the existing token's expiration. Cache not updated.");
                }
            } else {
                wVar2.d = kVar2;
                wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Current token parsing failed. Updated cache with new bidToken");
            }
            return Unit.INSTANCE;
        }
        com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) objA;
        if (vVar2 instanceof com.moloco.sdk.internal.v.b) {
            com.moloco.sdk.internal.bidtoken.a aVar2 = (com.moloco.sdk.internal.bidtoken.a) ((com.moloco.sdk.internal.v.b) vVar2).a();
            com.moloco.sdk.internal.bidtoken.b bVar2 = wVar.b;
            String strD2 = wVar.d.d();
            cVar.f6347a = wVar;
            cVar.b = kVar;
            cVar.c = aVar2;
            cVar.f = 2;
            Object objA2 = bVar2.a(strD2, cVar);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            kVar2 = kVar;
            aVar = aVar2;
            objA = objA2;
            wVar2 = wVar;
            vVar = (com.moloco.sdk.internal.v) objA;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                if (aVar.a() > ((com.moloco.sdk.internal.bidtoken.a) ((com.moloco.sdk.internal.v.b) vVar).a()).a()) {
                    wVar2.d = kVar2;
                    wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Updated cache with new bidToken");
                } else {
                    wVar2.a("[Thread: " + Thread.currentThread().getName() + "] New token's expiration is not greater than the existing token's expiration. Cache not updated.");
                }
            } else {
                wVar2.d = kVar2;
                wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Current token parsing failed. Updated cache with new bidToken");
            }
        } else {
            wVar.a("[Thread: " + Thread.currentThread().getName() + "] New token parsing failed. Cache not updated.");
        }
        return Unit.INSTANCE;
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, false, 4, null);
    }
}
