package com.yandex.mobile.ads.impl;

import java.util.Collection;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes12.dex */
@DebugMetadata(c = "com.monetization.ads.feed.ui.FeedAdapterInternal$observePagedData$1", f = "FeedAdapterInternal.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class e90 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ d90 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e90(d90 d90Var, Continuation<? super e90> continuation) {
        super(2, continuation);
        this.d = d90Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        e90 e90Var = new e90(this.d, continuation);
        e90Var.c = obj;
        return e90Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        e90 e90Var = new e90(this.d, continuation);
        e90Var.c = coroutineScope;
        return e90Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.c;
            StateFlow<ia0> stateFlowC = this.d.f8670a.c();
            a aVar = new a(this.d, coroutineScope);
            this.b = 1;
            if (stateFlowC.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d90 f8774a;
        final /* synthetic */ CoroutineScope b;

        a(d90 d90Var, CoroutineScope coroutineScope) {
            this.f8774a = d90Var;
            this.b = coroutineScope;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            ia0 ia0Var = (ia0) obj;
            ba0 ba0VarC = ia0Var.c();
            if (ba0VarC instanceof ba0.a) {
                w3 w3VarA = ((ba0.a) ia0Var.c()).a();
                this.f8774a.submitList(ia0Var.b());
                CoroutineScopeKt.cancel$default(this.b, w3VarA.d(), null, 2, null);
            } else if (ba0VarC instanceof ba0.c) {
                this.f8774a.submitList(CollectionsKt.plus((Collection<? extends ea0>) ia0Var.b(), ea0.f8778a));
            } else if (ba0VarC instanceof ba0.b) {
                this.f8774a.submitList(ia0Var.b());
            } else if (ba0VarC instanceof ba0.d) {
                if (ia0Var.b().isEmpty()) {
                    this.f8774a.submitList(ia0Var.b());
                } else {
                    this.f8774a.submitList(CollectionsKt.plus((Collection<? extends ea0>) ia0Var.b(), ea0.f8778a));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
