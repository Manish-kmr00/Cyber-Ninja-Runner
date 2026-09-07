package com.yandex.div.state;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.collection.ArrayMap;
import com.yandex.div.state.db.DivStateDao;
import com.yandex.div.state.db.DivStateDaoImpl;
import com.yandex.div.state.db.DivStateDbOpenHelper;
import com.yandex.div.state.db.PathToState;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: DivStateDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0017J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0017J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005H\u0017R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108PX\u0090\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/state/DivStateDatabase;", "Lcom/yandex/div/state/DivStateStorage;", "context", "Landroid/content/Context;", "databaseName", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/ExecutorService;)V", Reporting.EventType.CACHE, "Lcom/yandex/div/state/DivStateCache;", "getCache", "()Lcom/yandex/div/state/DivStateCache;", "cacheImpl", "Lcom/yandex/div/state/DivStateCacheImpl;", "divStateDao", "Lcom/yandex/div/state/db/DivStateDao;", "getDivStateDao$div_states_release", "()Lcom/yandex/div/state/db/DivStateDao;", "divStateDao$delegate", "Lkotlin/Lazy;", "deleteAllStates", "", "deleteStatesExceptGiven", "cardIds", "", "preloadState", "cardId", "Companion", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivStateDatabase implements DivStateStorage {
    private static final long STATE_MAX_AGE = TimeUnit.DAYS.toMillis(2);
    private final DivStateCacheImpl cacheImpl;

    /* JADX INFO: renamed from: divStateDao$delegate, reason: from kotlin metadata */
    private final Lazy divStateDao;
    private final ExecutorService executorService;

    public DivStateDatabase(final Context context, final String databaseName, ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorService = executorService;
        this.cacheImpl = new DivStateCacheImpl(this, executorService);
        this.divStateDao = LazyKt.lazy(new Function0<DivStateDaoImpl>() { // from class: com.yandex.div.state.DivStateDatabase$divStateDao$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DivStateDaoImpl invoke() {
                SQLiteDatabase writableDatabase = new DivStateDbOpenHelper(context, databaseName).getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "dbOpenHelper.writableDatabase");
                DivStateDaoImpl divStateDaoImpl = new DivStateDaoImpl(writableDatabase);
                divStateDaoImpl.deleteModifiedBefore(System.currentTimeMillis() - DivStateDatabase.STATE_MAX_AGE);
                return divStateDaoImpl;
            }
        });
    }

    public DivStateDao getDivStateDao$div_states_release() {
        return (DivStateDao) this.divStateDao.getValue();
    }

    @Override // com.yandex.div.state.DivStateStorage
    public DivStateCache getCache() {
        return this.cacheImpl;
    }

    @Override // com.yandex.div.state.DivStateStorage
    public void preloadState(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Future<Map<String, String>> future = this.executorService.submit(new Callable() { // from class: com.yandex.div.state.DivStateDatabase$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DivStateDatabase.preloadState$lambda$1(this.f$0, cardId);
            }
        });
        Future<String> rootStateFuture = this.executorService.submit(new Callable() { // from class: com.yandex.div.state.DivStateDatabase$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DivStateDatabase.preloadState$lambda$2(this.f$0, cardId);
            }
        });
        DivStateCacheImpl divStateCacheImpl = this.cacheImpl;
        Intrinsics.checkNotNullExpressionValue(rootStateFuture, "rootStateFuture");
        divStateCacheImpl.putRootState(cardId, rootStateFuture);
        DivStateCacheImpl divStateCacheImpl2 = this.cacheImpl;
        Intrinsics.checkNotNullExpressionValue(future, "future");
        divStateCacheImpl2.putState(cardId, future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map preloadState$lambda$1(DivStateDatabase this$0, String cardId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        ArrayMap arrayMap = new ArrayMap();
        for (PathToState pathToState : this$0.getDivStateDao$div_states_release().getStates(cardId)) {
            arrayMap.put(pathToState.getPath(), pathToState.getStateId());
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String preloadState$lambda$2(DivStateDatabase this$0, String cardId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardId, "$cardId");
        return this$0.getDivStateDao$div_states_release().getRootStateId(cardId);
    }

    @Override // com.yandex.div.state.DivStateStorage
    public void deleteAllStates() {
        getDivStateDao$div_states_release().deleteAll();
        this.cacheImpl.clear();
    }

    @Override // com.yandex.div.state.DivStateStorage
    public void deleteStatesExceptGiven(List<String> cardIds) {
        Intrinsics.checkNotNullParameter(cardIds, "cardIds");
        getDivStateDao$div_states_release().deleteAllExcept(cardIds);
    }
}
