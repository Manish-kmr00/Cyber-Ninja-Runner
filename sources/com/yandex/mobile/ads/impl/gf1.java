package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.gf1[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.gf1[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.gf1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes13.dex */
public final class gf1 {
    c("LANDSCAPE"),
    d("PORTRAIT"),
    e("UNDEFINED");

    private final int b;

    static {
        EnumEntriesKt.enumEntries(gf1VarArr);
    }

    public static gf1 valueOf(String str) {
        return (gf1) Enum.valueOf(gf1.class, str);
    }

    public static gf1[] values() {
        return (gf1[]) f.clone();
    }

    private gf1(String str) {
        super(str, i);
        this.b = i;
    }

    public final int a() {
        return this.b;
    }
}
