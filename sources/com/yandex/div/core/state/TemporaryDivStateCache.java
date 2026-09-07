package com.yandex.div.core.state;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.yandex.div.core.dagger.DivScope;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemporaryDivStateCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J \u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/state/TemporaryDivStateCache;", "", "()V", "temporaryCache", "", "", "clear", "", "getState", "cardId", "path", "putRootState", "stateId", "putState", "resetCard", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class TemporaryDivStateCache {
    private final Map<String, Map<String, String>> temporaryCache = new LinkedHashMap();

    @Inject
    public TemporaryDivStateCache() {
    }

    public final String getState(String cardId, String path) {
        String str;
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        synchronized (this.temporaryCache) {
            Map<String, String> map = this.temporaryCache.get(cardId);
            str = map != null ? map.get(path) : null;
        }
        return str;
    }

    public final Map<String, String> resetCard(String cardId) {
        Map<String, String> mapRemove;
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        synchronized (this.temporaryCache) {
            mapRemove = this.temporaryCache.remove(cardId);
        }
        return mapRemove;
    }

    public final void putState(String cardId, String path, String stateId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        synchronized (this.temporaryCache) {
            Map<String, Map<String, String>> map = this.temporaryCache;
            LinkedHashMap linkedHashMap = map.get(cardId);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                map.put(cardId, linkedHashMap);
            }
            linkedHashMap.put(path, stateId);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void putRootState(String cardId, String stateId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        putState(cardId, RemoteSettings.FORWARD_SLASH_STRING, stateId);
    }

    public final void clear() {
        this.temporaryCache.clear();
    }
}
