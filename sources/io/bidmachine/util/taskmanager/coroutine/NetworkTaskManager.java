package io.bidmachine.util.taskmanager.coroutine;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: NetworkTaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/bidmachine/util/taskmanager/coroutine/NetworkTaskManager;", "Lio/bidmachine/util/taskmanager/coroutine/BaseCoroutineTaskManager;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetworkTaskManager extends BaseCoroutineTaskManager {
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(new CoroutineName("NetworkTaskManager").plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(Dispatchers.getIO()));

    @Override // io.bidmachine.util.taskmanager.coroutine.BaseCoroutineTaskManager
    protected CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }
}
