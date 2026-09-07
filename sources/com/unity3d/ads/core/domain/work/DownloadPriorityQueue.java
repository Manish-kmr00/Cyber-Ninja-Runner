package com.unity3d.ads.core.domain.work;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: DownloadPriorityQueue.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue;", "", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "nextTurn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;", "queue", "Ljava/util/PriorityQueue;", "invoke", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "downloadAction", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PriorityItem", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DownloadPriorityQueue {
    private final Mutex mutex = MutexKt.Mutex(false);
    private final MutableStateFlow<PriorityItem> nextTurn = StateFlowKt.MutableStateFlow(null);
    private final PriorityQueue<PriorityItem> queue = new PriorityQueue<>(50, new Comparator() { // from class: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$special$$inlined$compareBy$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t).getPriority()), Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t2).getPriority()));
        }
    });

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPriorityQueue.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue", f = "DownloadPriorityQueue.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 3}, l = {47, 28, 31, 57}, m = "invoke", n = {"this", "downloadAction", "priorityItem", "$this$withLock_u24default$iv", "this", "downloadAction", "priorityItem", "this", "priorityItem", "this", "priorityItem", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadPriorityQueue.this.invoke(0, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        DownloadPriorityQueue downloadPriorityQueue;
        Function1<? super Continuation<? super Unit>, ? extends Object> function2;
        Mutex mutex;
        PriorityItem priorityItem;
        Function1<? super Continuation<? super Unit>, ? extends Object> function3;
        DownloadPriorityQueue downloadPriorityQueue2;
        PriorityItem priorityItem2;
        Mutex mutex2;
        DownloadPriorityQueue downloadPriorityQueue3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                PriorityItem priorityItem3 = new PriorityItem(i);
                Mutex mutex3 = this.mutex;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = function1;
                anonymousClass1.L$2 = priorityItem3;
                anonymousClass1.L$3 = mutex3;
                anonymousClass1.label = 1;
                if (mutex3.lock(null, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloadPriorityQueue = this;
                function2 = function1;
                mutex = mutex3;
                priorityItem = priorityItem3;
            } else {
                if (i2 == 1) {
                    Mutex mutex4 = (Mutex) anonymousClass1.L$3;
                    PriorityItem priorityItem4 = (PriorityItem) anonymousClass1.L$2;
                    function2 = (Function1) anonymousClass1.L$1;
                    downloadPriorityQueue = (DownloadPriorityQueue) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex4;
                    priorityItem = priorityItem4;
                } else if (i2 == 2) {
                    priorityItem = (PriorityItem) anonymousClass1.L$2;
                    function3 = (Function1) anonymousClass1.L$1;
                    downloadPriorityQueue2 = (DownloadPriorityQueue) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1.L$0 = downloadPriorityQueue2;
                    anonymousClass1.L$1 = priorityItem;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.label = 3;
                    if (function3.invoke(anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    priorityItem2 = priorityItem;
                    mutex2 = downloadPriorityQueue2.mutex;
                    anonymousClass1.L$0 = downloadPriorityQueue2;
                    anonymousClass1.L$1 = priorityItem2;
                    anonymousClass1.L$2 = mutex2;
                    anonymousClass1.label = 4;
                    if (mutex2.lock(null, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadPriorityQueue3 = downloadPriorityQueue2;
                } else if (i2 == 3) {
                    priorityItem = (PriorityItem) anonymousClass1.L$1;
                    DownloadPriorityQueue downloadPriorityQueue4 = (DownloadPriorityQueue) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    downloadPriorityQueue2 = downloadPriorityQueue4;
                    priorityItem2 = priorityItem;
                    mutex2 = downloadPriorityQueue2.mutex;
                    anonymousClass1.L$0 = downloadPriorityQueue2;
                    anonymousClass1.L$1 = priorityItem2;
                    anonymousClass1.L$2 = mutex2;
                    anonymousClass1.label = 4;
                    if (mutex2.lock(null, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadPriorityQueue3 = downloadPriorityQueue2;
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) anonymousClass1.L$2;
                    priorityItem2 = (PriorityItem) anonymousClass1.L$1;
                    downloadPriorityQueue3 = (DownloadPriorityQueue) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                try {
                    downloadPriorityQueue3.queue.remove(priorityItem2);
                    downloadPriorityQueue3.nextTurn.setValue(downloadPriorityQueue3.queue.peek());
                    Unit unit = Unit.INSTANCE;
                    return Unit.INSTANCE;
                } finally {
                    mutex2.unlock(null);
                }
            }
            downloadPriorityQueue.queue.offer(priorityItem);
            downloadPriorityQueue.nextTurn.setValue(downloadPriorityQueue.queue.peek());
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            MutableStateFlow<PriorityItem> mutableStateFlow = downloadPriorityQueue.nextTurn;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(priorityItem, null);
            anonymousClass1.L$0 = downloadPriorityQueue;
            anonymousClass1.L$1 = function2;
            anonymousClass1.L$2 = priorityItem;
            anonymousClass1.L$3 = null;
            anonymousClass1.label = 2;
            if (FlowKt.first(mutableStateFlow, anonymousClass3, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            function3 = function2;
            downloadPriorityQueue2 = downloadPriorityQueue;
            anonymousClass1.L$0 = downloadPriorityQueue2;
            anonymousClass1.L$1 = priorityItem;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 3;
            if (function3.invoke(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            priorityItem2 = priorityItem;
            mutex2 = downloadPriorityQueue2.mutex;
            anonymousClass1.L$0 = downloadPriorityQueue2;
            anonymousClass1.L$1 = priorityItem2;
            anonymousClass1.L$2 = mutex2;
            anonymousClass1.label = 4;
            if (mutex2.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            downloadPriorityQueue3 = downloadPriorityQueue2;
            downloadPriorityQueue3.queue.remove(priorityItem2);
            downloadPriorityQueue3.nextTurn.setValue(downloadPriorityQueue3.queue.peek());
            Unit unit3 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$3", f = "DownloadPriorityQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<PriorityItem, Continuation<? super Boolean>, Object> {
        final /* synthetic */ PriorityItem $priorityItem;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PriorityItem priorityItem, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$priorityItem = priorityItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$priorityItem, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PriorityItem priorityItem, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(priorityItem, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((PriorityItem) this.L$0) == this.$priorityItem);
        }
    }

    /* JADX INFO: compiled from: DownloadPriorityQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/ads/core/domain/work/DownloadPriorityQueue$PriorityItem;", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(I)V", "getPriority", "()I", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PriorityItem {
        private final int priority;

        public PriorityItem(int i) {
            this.priority = i;
        }

        public final int getPriority() {
            return this.priority;
        }
    }
}
