package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.t80[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.t80[]) from 0x0048: INVOKE (r0v1 com.yandex.mobile.ads.impl.t80[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class t80 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("AdPodSkipFeatureToggle"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("InterstitialPreloading"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("RewardedPreloading"),
    c("FirstVideoPreloadingStrategyFeatureToggle"),
    d("TestingNewAdapterFeatureToggle"),
    e("FallbackForVideoFeatureToggle");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(t80VarArr);
    }

    public static t80 valueOf(String str) {
        return (t80) Enum.valueOf(t80.class, str);
    }

    public static t80[] values() {
        return (t80[]) f.clone();
    }

    private t80(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
