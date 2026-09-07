package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.s62[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.s62[]) from 0x006a: INVOKE (r0v1 com.yandex.mobile.ads.impl.s62[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes8.dex */
public final class s62 {
    b,
    c,
    d,
    e,
    f,
    g,
    h,
    i,
    j,
    /* JADX INFO: Fake field, exist only in values array */
    EF97;

    static {
        EnumEntriesKt.enumEntries(s62VarArr);
    }

    public static s62 valueOf(String str) {
        return (s62) Enum.valueOf(s62.class, str);
    }

    public static s62[] values() {
        return (s62[]) k.clone();
    }

    private s62() {
        super(str, i);
    }
}
