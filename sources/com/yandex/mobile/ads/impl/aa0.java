package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes.dex */
public final class aa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v7 f8384a;
    private final u90 b;
    private final y90 c;
    private final v90 d;
    private final MutableStateFlow<List<k90>> e;
    private final MutableStateFlow f;

    @DebugMetadata(c = "com.monetization.ads.feed.data.FeedItemsRepository", f = "FeedItemsRepository.kt", i = {0, 1}, l = {34, 37}, m = "loadNewFeedItem", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class a extends ContinuationImpl {
        aa0 b;
        /* synthetic */ Object c;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return aa0.this.a(this);
        }
    }

    public aa0(v7 adRequestData, u90 loadDataSource, y90 preloadDataSource, v90 loadEnoughMemoryValidator) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(loadDataSource, "loadDataSource");
        Intrinsics.checkNotNullParameter(preloadDataSource, "preloadDataSource");
        Intrinsics.checkNotNullParameter(loadEnoughMemoryValidator, "loadEnoughMemoryValidator");
        this.f8384a = adRequestData;
        this.b = loadDataSource;
        this.c = preloadDataSource;
        this.d = loadEnoughMemoryValidator;
        MutableStateFlow<List<k90>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
    }

    public final MutableStateFlow a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:? A[LOOP:0: B:27:0x0076->B:37:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super vk1> continuation) throws Throwable {
        a aVar;
        aa0 aa0Var;
        aa0 aa0Var2;
        k90 k90Var;
        MutableStateFlow<List<k90>> mutableStateFlow;
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
        Object objA = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            u90 u90Var = this.b;
            v7 v7Var = this.f8384a;
            List<k90> list = (List) this.f.getValue();
            aVar.b = this;
            aVar.e = 1;
            objA = u90Var.a(v7Var, list, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            aa0Var = this;
        } else {
            if (i2 == 1) {
                aa0Var = aVar.b;
                ResultKt.throwOnFailure(objA);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aa0Var2 = aVar.b;
                ResultKt.throwOnFailure(objA);
            }
            k90Var = (k90) objA;
            mutableStateFlow = aa0Var2.e;
            while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CollectionsKt.plus((Collection<? extends k90>) aa0Var2.e.getValue(), k90Var))) {
            }
            return new vk1.b(k90Var);
        }
        x90 x90Var = (x90) objA;
        if (x90Var instanceof x90.b) {
            y90 y90Var = aa0Var.c;
            cs0 cs0VarA = ((x90.b) x90Var).a();
            aVar.b = aa0Var;
            aVar.e = 2;
            objA = y90Var.a(cs0VarA, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            aa0Var2 = aa0Var;
            k90Var = (k90) objA;
            mutableStateFlow = aa0Var2.e;
            while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CollectionsKt.plus((Collection<? extends k90>) aa0Var2.e.getValue(), k90Var))) {
            }
            return new vk1.b(k90Var);
        }
        if (x90Var instanceof x90.a) {
            return new vk1.a(((x90.a) x90Var).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object b(Continuation<? super vk1> continuation) {
        if (this.d.a()) {
            return a(continuation);
        }
        return new vk1.a(w7.o());
    }
}
