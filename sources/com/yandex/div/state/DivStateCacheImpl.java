package com.yandex.div.state;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.util.CompletedFuture;
import com.yandex.div.internal.util.SingleThreadExecutor;
import com.yandex.div.state.db.DivStateEntity;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: DivStateCacheImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\tH\u0017J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0017J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0017J*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u000bH\u0007J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0017J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0017J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0003J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0003R\u0097\u0001\u0010\u0007\u001a\u008a\u0001\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b \n*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u000b0\u000b \n*D\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b \n*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u000b0\u000b\u0018\u00010\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rn\u0010\r\u001ab\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t \n*\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b0\u000b \n*0\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t \n*\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b0\u000b\u0018\u00010\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/state/DivStateCacheImpl;", "Lcom/yandex/div/state/DivStateCache;", "divStateDatabase", "Lcom/yandex/div/state/DivStateDatabase;", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Lcom/yandex/div/state/DivStateDatabase;Ljava/util/concurrent/ExecutorService;)V", Reporting.EventType.CACHE, "", "", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/Future;", "", "rootState", "singleThreadExecutor", "Lcom/yandex/div/state/DivStateCacheImpl$WorkerThreadExecutor;", "clear", "", "getRootState", "cardId", "getState", "path", "putRootState", "future", "stateId", "putState", "resetCard", "resetCardRootState", "resetCardStates", "WorkerThreadExecutor", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStateCacheImpl implements DivStateCache {
    private final Map<String, Future<Map<String, String>>> cache;
    private final DivStateDatabase divStateDatabase;
    private final Map<String, Future<String>> rootState;
    private final WorkerThreadExecutor singleThreadExecutor;

    public DivStateCacheImpl(DivStateDatabase divStateDatabase, ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(divStateDatabase, "divStateDatabase");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.divStateDatabase = divStateDatabase;
        this.singleThreadExecutor = new WorkerThreadExecutor(executorService);
        this.cache = Collections.synchronizedMap(new LinkedHashMap());
        this.rootState = Collections.synchronizedMap(new LinkedHashMap());
    }

    public final void putState(String cardId, Future<Map<String, String>> future) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(future, "future");
        Map<String, Future<Map<String, String>>> cache = this.cache;
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        synchronized (cache) {
            if (!this.cache.containsKey(cardId)) {
                Map<String, Future<Map<String, String>>> cache2 = this.cache;
                Intrinsics.checkNotNullExpressionValue(cache2, "cache");
                cache2.put(cardId, future);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void putRootState(String cardId, Future<String> future) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(future, "future");
        Map<String, Future<String>> rootState = this.rootState;
        Intrinsics.checkNotNullExpressionValue(rootState, "rootState");
        synchronized (rootState) {
            if (!this.rootState.containsKey(cardId)) {
                Map<String, Future<String>> rootState2 = this.rootState;
                Intrinsics.checkNotNullExpressionValue(rootState2, "rootState");
                rootState2.put(cardId, future);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.div.state.DivStateCache
    public void putState(final String cardId, final String path, final String stateId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        Map<String, Future<Map<String, String>>> cache = this.cache;
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        synchronized (cache) {
            Map<String, Future<Map<String, String>>> cache2 = this.cache;
            Intrinsics.checkNotNullExpressionValue(cache2, "cache");
            CompletedFuture completedFuture = cache2.get(cardId);
            if (completedFuture == null) {
                completedFuture = new CompletedFuture(new LinkedHashMap());
                cache2.put(cardId, completedFuture);
            }
            Map<String, String> map = completedFuture.get();
            Intrinsics.checkNotNullExpressionValue(map, "cache.getOrPut(cardId) {…Of())\n            }.get()");
            map.put(path, stateId);
            this.singleThreadExecutor.post(new Runnable() { // from class: com.yandex.div.state.DivStateCacheImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    DivStateCacheImpl.putState$lambda$4$lambda$3(this.f$0, cardId, path, stateId);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putState$lambda$4$lambda$3(DivStateCacheImpl this$0, String cardId, String path, String stateId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(stateId, "$stateId");
        this$0.divStateDatabase.getDivStateDao$div_states_release().updateState(new DivStateEntity(0, cardId, path, stateId, System.currentTimeMillis()));
    }

    @Override // com.yandex.div.state.DivStateCache
    public void putRootState(final String cardId, final String stateId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        Map<String, Future<String>> rootState = this.rootState;
        Intrinsics.checkNotNullExpressionValue(rootState, "rootState");
        synchronized (rootState) {
            Map<String, Future<String>> rootState2 = this.rootState;
            Intrinsics.checkNotNullExpressionValue(rootState2, "rootState");
            rootState2.put(cardId, new CompletedFuture(stateId));
            this.singleThreadExecutor.post(new Runnable() { // from class: com.yandex.div.state.DivStateCacheImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DivStateCacheImpl.putRootState$lambda$6$lambda$5(this.f$0, cardId, stateId);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putRootState$lambda$6$lambda$5(DivStateCacheImpl this$0, String cardId, String stateId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        Intrinsics.checkNotNullParameter(stateId, "$stateId");
        this$0.divStateDatabase.getDivStateDao$div_states_release().deleteCardRootState(cardId);
        this$0.divStateDatabase.getDivStateDao$div_states_release().updateState(new DivStateEntity(0, cardId, RemoteSettings.FORWARD_SLASH_STRING, stateId, System.currentTimeMillis()));
    }

    @Override // com.yandex.div.state.DivStateCache
    public String getState(String cardId, String path) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            Future<Map<String, String>> future = this.cache.get(cardId);
            if (future == null || !future.isDone() || (map = future.get()) == null) {
                return null;
            }
            return map.get(path);
        } catch (ExecutionException e) {
            Assert.fail("", e);
        }
        return null;
    }

    @Override // com.yandex.div.state.DivStateCache
    public String getRootState(String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        try {
            Map<String, Future<String>> rootState = this.rootState;
            Intrinsics.checkNotNullExpressionValue(rootState, "rootState");
            synchronized (rootState) {
                Future<String> future = this.rootState.get(cardId);
                if (future != null && future.isDone()) {
                    String str = future.get();
                    if (str == null) {
                        Map<String, Future<String>> rootState2 = this.rootState;
                        Intrinsics.checkNotNullExpressionValue(rootState2, "rootState");
                        rootState2.put(cardId, null);
                    }
                    return str;
                }
                Unit unit = Unit.INSTANCE;
                return null;
            }
        } catch (ExecutionException e) {
            Assert.fail("", e);
        }
    }

    @Override // com.yandex.div.state.DivStateCache
    public void clear() {
        this.cache.clear();
        this.rootState.clear();
    }

    /* JADX INFO: compiled from: DivStateCacheImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0014¨\u0006\n"}, d2 = {"Lcom/yandex/div/state/DivStateCacheImpl$WorkerThreadExecutor;", "Lcom/yandex/div/internal/util/SingleThreadExecutor;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "handleError", "", "e", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class WorkerThreadExecutor extends SingleThreadExecutor {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WorkerThreadExecutor(Executor executor) {
            super(executor, "DivStateCache");
            Intrinsics.checkNotNullParameter(executor, "executor");
        }

        @Override // com.yandex.div.internal.util.SingleThreadExecutor
        protected void handleError(RuntimeException e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Assert.fail("", e);
        }
    }

    @Override // com.yandex.div.state.DivStateCache
    public void resetCard(String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        resetCardStates(cardId);
        resetCardRootState(cardId);
    }

    private final void resetCardStates(final String cardId) {
        Map<String, Future<Map<String, String>>> cache = this.cache;
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        synchronized (cache) {
            this.cache.remove(cardId);
            this.singleThreadExecutor.post(new Runnable() { // from class: com.yandex.div.state.DivStateCacheImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DivStateCacheImpl.resetCardStates$lambda$9$lambda$8(this.f$0, cardId);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetCardStates$lambda$9$lambda$8(DivStateCacheImpl this$0, String cardId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        this$0.divStateDatabase.getDivStateDao$div_states_release().deleteByCardId(cardId);
    }

    private final void resetCardRootState(final String cardId) {
        Map<String, Future<String>> rootState = this.rootState;
        Intrinsics.checkNotNullExpressionValue(rootState, "rootState");
        synchronized (rootState) {
            this.rootState.remove(cardId);
            this.singleThreadExecutor.post(new Runnable() { // from class: com.yandex.div.state.DivStateCacheImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DivStateCacheImpl.resetCardRootState$lambda$11$lambda$10(this.f$0, cardId);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetCardRootState$lambda$11$lambda$10(DivStateCacheImpl this$0, String cardId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        this$0.divStateDatabase.getDivStateDao$div_states_release().deleteCardRootState(cardId);
    }
}
