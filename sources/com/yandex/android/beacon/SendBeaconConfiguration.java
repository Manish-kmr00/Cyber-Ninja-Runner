package com.yandex.android.beacon;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendBeaconConfiguration.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconConfiguration;", "", "executor", "Ljava/util/concurrent/Executor;", "requestExecutor", "Lcom/yandex/android/beacon/SendBeaconRequestExecutor;", "workerScheduler", "Lcom/yandex/android/beacon/SendBeaconWorkerScheduler;", "perWorkerLogger", "Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "databaseName", "", "(Ljava/util/concurrent/Executor;Lcom/yandex/android/beacon/SendBeaconRequestExecutor;Lcom/yandex/android/beacon/SendBeaconWorkerScheduler;Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;Ljava/lang/String;)V", "getDatabaseName", "()Ljava/lang/String;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getPerWorkerLogger", "()Lcom/yandex/android/beacon/SendBeaconPerWorkerLogger;", "getRequestExecutor", "()Lcom/yandex/android/beacon/SendBeaconRequestExecutor;", "getWorkerScheduler", "()Lcom/yandex/android/beacon/SendBeaconWorkerScheduler;", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SendBeaconConfiguration {
    private final String databaseName;
    private final Executor executor;
    private final SendBeaconPerWorkerLogger perWorkerLogger;
    private final SendBeaconRequestExecutor requestExecutor;
    private final SendBeaconWorkerScheduler workerScheduler;

    public SendBeaconConfiguration(Executor executor, SendBeaconRequestExecutor requestExecutor, SendBeaconWorkerScheduler workerScheduler, SendBeaconPerWorkerLogger perWorkerLogger, String databaseName) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(requestExecutor, "requestExecutor");
        Intrinsics.checkNotNullParameter(workerScheduler, "workerScheduler");
        Intrinsics.checkNotNullParameter(perWorkerLogger, "perWorkerLogger");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        this.executor = executor;
        this.requestExecutor = requestExecutor;
        this.workerScheduler = workerScheduler;
        this.perWorkerLogger = perWorkerLogger;
        this.databaseName = databaseName;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final SendBeaconRequestExecutor getRequestExecutor() {
        return this.requestExecutor;
    }

    public final SendBeaconWorkerScheduler getWorkerScheduler() {
        return this.workerScheduler;
    }

    public final SendBeaconPerWorkerLogger getPerWorkerLogger() {
        return this.perWorkerLogger;
    }

    public final String getDatabaseName() {
        return this.databaseName;
    }
}
