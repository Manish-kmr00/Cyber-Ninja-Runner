package com.yandex.div.state;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InMemoryDivStateCache.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016RN\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R~\u0010\b\u001ar\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\t\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*8\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\t\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/state/InMemoryDivStateCache;", "Lcom/yandex/div/state/DivStateCache;", "()V", "rootStates", "", "", "kotlin.jvm.PlatformType", "", "states", "Lkotlin/Pair;", "clear", "", "getRootState", "cardId", "getState", "path", "putRootState", "state", "putState", "resetCard", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InMemoryDivStateCache implements DivStateCache {
    private final Map<Pair<String, String>, String> states = Collections.synchronizedMap(new LinkedHashMap());
    private final Map<String, String> rootStates = Collections.synchronizedMap(new LinkedHashMap());

    @Override // com.yandex.div.state.DivStateCache
    public void putState(String cardId, String path, String state) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(state, "state");
        Map<Pair<String, String>, String> states = this.states;
        Intrinsics.checkNotNullExpressionValue(states, "states");
        states.put(TuplesKt.to(cardId, path), state);
    }

    @Override // com.yandex.div.state.DivStateCache
    public void putRootState(String cardId, String state) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(state, "state");
        Map<String, String> rootStates = this.rootStates;
        Intrinsics.checkNotNullExpressionValue(rootStates, "rootStates");
        rootStates.put(cardId, state);
    }

    @Override // com.yandex.div.state.DivStateCache
    public String getState(String cardId, String path) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(path, "path");
        return this.states.get(TuplesKt.to(cardId, path));
    }

    @Override // com.yandex.div.state.DivStateCache
    public String getRootState(String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        return this.rootStates.get(cardId);
    }

    @Override // com.yandex.div.state.DivStateCache
    public void clear() {
        this.states.clear();
        this.rootStates.clear();
    }

    @Override // com.yandex.div.state.DivStateCache
    public void resetCard(final String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        this.rootStates.remove(cardId);
        CollectionsKt.removeAll(this.states.keySet(), new Function1<Pair<? extends String, ? extends String>, Boolean>() { // from class: com.yandex.div.state.InMemoryDivStateCache.resetCard.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(Pair<String, String> pair) {
                return Boolean.valueOf(Intrinsics.areEqual(pair.getFirst(), cardId));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        });
    }
}
