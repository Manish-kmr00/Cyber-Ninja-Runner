package com.yandex.div.core.state;

import androidx.collection.ArrayMap;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.state.DivStateCache;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: DivStateManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\tJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/core/state/DivStateManager;", "", Reporting.EventType.CACHE, "Lcom/yandex/div/state/DivStateCache;", "temporaryCache", "Lcom/yandex/div/core/state/TemporaryDivStateCache;", "(Lcom/yandex/div/state/DivStateCache;Lcom/yandex/div/core/state/TemporaryDivStateCache;)V", "states", "Landroidx/collection/ArrayMap;", "Lcom/yandex/div/DivDataTag;", "Lcom/yandex/div/core/state/DivViewState;", "getState", "tag", TimerController.RESET_COMMAND, "", "tags", "", "updateState", "stateId", "", "temporary", "", "updateStates", "cardId", "", "divStatePath", "Lcom/yandex/div/core/state/DivStatePath;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivStateManager {
    private final DivStateCache cache;
    private final ArrayMap<DivDataTag, DivViewState> states;
    private final TemporaryDivStateCache temporaryCache;

    @Inject
    public DivStateManager(DivStateCache cache, TemporaryDivStateCache temporaryCache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(temporaryCache, "temporaryCache");
        this.cache = cache;
        this.temporaryCache = temporaryCache;
        this.states = new ArrayMap<>();
    }

    public final DivViewState getState(DivDataTag tag) {
        DivViewState divViewState;
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.states) {
            divViewState = this.states.get(tag);
            if (divViewState == null) {
                String rootState = this.cache.getRootState(tag.getId());
                if (rootState != null) {
                    Intrinsics.checkNotNullExpressionValue(rootState, "getRootState(tag.id)");
                    divViewState = new DivViewState(Long.parseLong(rootState));
                } else {
                    divViewState = null;
                }
                this.states.put(tag, divViewState);
            }
        }
        return divViewState;
    }

    public final void updateState(DivDataTag tag, long stateId, boolean temporary) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(DivDataTag.INVALID, tag)) {
            return;
        }
        synchronized (this.states) {
            DivViewState state = getState(tag);
            this.states.put(tag, state == null ? new DivViewState(stateId) : new DivViewState(stateId, state.getBlockStates()));
            TemporaryDivStateCache temporaryDivStateCache = this.temporaryCache;
            String id = tag.getId();
            Intrinsics.checkNotNullExpressionValue(id, "tag.id");
            temporaryDivStateCache.putRootState(id, String.valueOf(stateId));
            if (!temporary) {
                this.cache.putRootState(tag.getId(), String.valueOf(stateId));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void updateStates(String cardId, DivStatePath divStatePath, boolean temporary) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        String pathToLastState = divStatePath.getPathToLastState();
        String lastStateId = divStatePath.getLastStateId();
        if (pathToLastState == null || lastStateId == null) {
            return;
        }
        synchronized (this.states) {
            this.temporaryCache.putState(cardId, pathToLastState, lastStateId);
            if (!temporary) {
                this.cache.putState(cardId, pathToLastState, lastStateId);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void reset(List<? extends DivDataTag> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (tags.isEmpty()) {
            this.states.clear();
            this.cache.clear();
            this.temporaryCache.clear();
            return;
        }
        for (DivDataTag divDataTag : tags) {
            this.states.remove(divDataTag);
            this.cache.resetCard(divDataTag.getId());
            TemporaryDivStateCache temporaryDivStateCache = this.temporaryCache;
            String id = divDataTag.getId();
            Intrinsics.checkNotNullExpressionValue(id, "tag.id");
            temporaryDivStateCache.resetCard(id);
        }
    }
}
