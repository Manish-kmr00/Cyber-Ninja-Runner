package com.yandex.div.core.state;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: DivStatePath.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"$\u0010\u0005\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"divId", "", "Lkotlin/Pair;", "getDivId", "(Lkotlin/Pair;)Ljava/lang/String;", "stateId", "getStateId", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivStatePathKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDivId(Pair<String, String> pair) {
        return pair.getFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getStateId(Pair<String, String> pair) {
        return pair.getSecond();
    }
}
