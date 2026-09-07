package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.inmobi.media.x3[], still in use, count: 1, list:
  (r0v1 com.inmobi.media.x3[]) from 0x0018: INVOKE (r0v1 com.inmobi.media.x3[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: renamed from: com.inmobi.media.x3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class EnumC3621x3 {
    URL,
    /* JADX INFO: Fake field, exist only in values array */
    HTML;

    static {
        EnumEntriesKt.enumEntries(enumC3621x3Arr);
    }

    public EnumC3621x3() {
        super(str, i);
    }

    public static EnumC3621x3 valueOf(String str) {
        return (EnumC3621x3) Enum.valueOf(EnumC3621x3.class, str);
    }

    public static EnumC3621x3[] values() {
        return (EnumC3621x3[]) b.clone();
    }
}
