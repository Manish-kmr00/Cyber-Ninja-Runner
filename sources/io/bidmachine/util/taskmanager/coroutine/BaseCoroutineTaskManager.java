package io.bidmachine.util.taskmanager.coroutine;

import io.bidmachine.util.taskmanager.BaseTaskManager;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BaseCoroutineTaskManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/bidmachine/util/taskmanager/coroutine/BaseCoroutineTaskManager;", "Lio/bidmachine/util/taskmanager/BaseTaskManager;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "jobMap", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Job;", "cancelTask", "", "task", "getScheduledTaskCount", "", "scheduleTask", "delayMs", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseCoroutineTaskManager extends BaseTaskManager {
    private final Map<Runnable, Job> jobMap = new ConcurrentHashMap();

    protected abstract CoroutineScope getCoroutineScope();

    /* JADX INFO: renamed from: io.bidmachine.util.taskmanager.coroutine.BaseCoroutineTaskManager$scheduleTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseCoroutineTaskManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.util.taskmanager.coroutine.BaseCoroutineTaskManager$scheduleTask$1", f = "BaseCoroutineTaskManager.kt", i = {0}, l = {22}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        final /* synthetic */ Runnable $task;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseCoroutineTaskManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, BaseCoroutineTaskManager baseCoroutineTaskManager, Runnable runnable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delayMs = j;
            this.this$0 = baseCoroutineTaskManager;
            this.$task = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delayMs, this.this$0, this.$task, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                long j = this.$delayMs;
                if (j > 0) {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(j, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            try {
                this.$task.run();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
            this.this$0.cancel(this.$task);
            return Unit.INSTANCE;
        }
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void scheduleTask(Runnable task, long delayMs) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.LAZY, new AnonymousClass1(delayMs, this, task, null), 1, null);
        this.jobMap.put(task, jobLaunch$default);
        jobLaunch$default.start();
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void cancelTask(Runnable task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        Job jobRemove = this.jobMap.remove(task);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, (CancellationException) null, 1, (Object) null);
        }
    }

    public final int getScheduledTaskCount() {
        return this.jobMap.size();
    }
}
