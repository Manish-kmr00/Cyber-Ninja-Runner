package com.yandex.div.core.state;

import com.yandex.div.core.dagger.DivScope;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsStateCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/state/TabsStateCache;", "", "()V", "temporaryCache", "", "", "", "getSelectedTab", "cardId", "path", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "putSelectedTab", "", "index", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class TabsStateCache {
    private final Map<String, Map<String, Integer>> temporaryCache = new LinkedHashMap();

    @Inject
    public TabsStateCache() {
    }

    public final Integer getSelectedTab(String cardId, String path) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Map<String, Integer> map = this.temporaryCache.get(cardId);
        if (map != null) {
            return map.get(path);
        }
        return null;
    }

    public final void putSelectedTab(String cardId, String path, int index) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Map<String, Map<String, Integer>> map = this.temporaryCache;
        LinkedHashMap linkedHashMap = map.get(cardId);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            map.put(cardId, linkedHashMap);
        }
        linkedHashMap.put(path, Integer.valueOf(index));
    }
}
