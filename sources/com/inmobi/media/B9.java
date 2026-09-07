package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.inmobi.media.B9[], still in use, count: 1, list:
  (r0v1 com.inmobi.media.B9[]) from 0x0032: INVOKE (r0v1 com.inmobi.media.B9[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes5.dex */
public final class B9 {
    b("HIGHEST"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("HIGH"),
    c("MEDIUM"),
    /* JADX INFO: Fake field, exist only in values array */
    EF33("LOW"),
    /* JADX INFO: Fake field, exist only in values array */
    EF41("LOWEST");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3034a;

    static {
        EnumEntriesKt.enumEntries(b9Arr);
    }

    public B9(String str) {
        super(str, i);
        this.f3034a = i;
    }

    public static B9 valueOf(String str) {
        return (B9) Enum.valueOf(B9.class, str);
    }

    public static B9[] values() {
        return (B9[]) d.clone();
    }
}
