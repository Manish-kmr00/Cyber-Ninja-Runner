package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeWrapperVideoLoader$loadWrapperWithVideoAdsInfo$2", f = "NativeWrapperVideoLoader.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
final class kc1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends rb2<gb1>>>, Object> {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ List<rb2<gb1>> d;
    final /* synthetic */ lc1 e;

    @DebugMetadata(c = "com.monetization.ads.nativeads.creator.videowrapper.NativeWrapperVideoLoader$loadWrapperWithVideoAdsInfo$2$1$1", f = "NativeWrapperVideoLoader.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends rb2<gb1>>>, Object> {
        int b;
        final /* synthetic */ lc1 c;
        final /* synthetic */ rb2<gb1> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(lc1 lc1Var, rb2<gb1> rb2Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = lc1Var;
            this.d = rb2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends rb2<gb1>>> continuation) {
            return new a(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                lc1 lc1Var = this.c;
                List listListOf = CollectionsKt.listOf(this.d);
                this.b = 1;
                obj = lc1.a(lc1Var, listListOf, this);
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        kc1 kc1Var = new kc1(this.e, this.d, continuation);
        kc1Var.c = obj;
        return kc1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends rb2<gb1>>> continuation) {
        return ((kc1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.c;
            List<rb2<gb1>> list = this.d;
            lc1 lc1Var = this.e;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                rb2 rb2Var = (rb2) it.next();
                arrayList.add(rb2Var.g().o() ? BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a(lc1Var, rb2Var, null), 3, null) : CompletableDeferredKt.CompletableDeferred(CollectionsKt.listOf(rb2Var)));
            }
            this.b = 1;
            obj = AwaitKt.awaitAll(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return CollectionsKt.flatten((Iterable) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    kc1(lc1 lc1Var, List list, Continuation continuation) {
        super(2, continuation);
        this.d = list;
        this.e = lc1Var;
    }
}
