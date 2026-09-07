package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.inmobi.media.Ma[], still in use, count: 1, list:
  (r0v1 com.inmobi.media.Ma[]) from 0x0032: INVOKE (r0v1 com.inmobi.media.Ma[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes6.dex */
public final class Ma {
    GET,
    POST,
    /* JADX INFO: Fake field, exist only in values array */
    PUT,
    /* JADX INFO: Fake field, exist only in values array */
    DELETE,
    /* JADX INFO: Fake field, exist only in values array */
    PATCH;

    static {
        EnumEntriesKt.enumEntries(maArr);
    }

    public Ma() {
        super(str, i);
    }

    public static Ma valueOf(String str) {
        return (Ma) Enum.valueOf(Ma.class, str);
    }

    public static Ma[] values() {
        return (Ma[]) c.clone();
    }
}
