package com.yandex.mobile.ads.impl;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.pz1[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.pz1[]) from 0x001a: INVOKE (r0v1 com.yandex.mobile.ads.impl.pz1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes11.dex */
public final class pz1 {
    /* JADX INFO: Fake field, exist only in values array */
    EF7(VastAttributes.VISIBLE),
    /* JADX INFO: Fake field, exist only in values array */
    EF17("delayed");

    public static final /* synthetic */ int d = 0;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(pz1VarArr);
    }

    public static pz1 valueOf(String str) {
        return (pz1) Enum.valueOf(pz1.class, str);
    }

    public static pz1[] values() {
        return (pz1[]) c.clone();
    }

    private pz1(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
