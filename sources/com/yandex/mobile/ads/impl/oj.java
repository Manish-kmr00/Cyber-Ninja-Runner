package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.oj[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.oj[]) from 0x003a: INVOKE (r0v1 com.yandex.mobile.ads.impl.oj[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class oj {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("constant"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("ratio"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("screen_based"),
    d("screen_orientation_based"),
    /* JADX INFO: Fake field, exist only in values array */
    EF49("mediation");

    public static final a c;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(ojVarArr);
        c = new a(0);
    }

    public static oj valueOf(String str) {
        return (oj) Enum.valueOf(oj.class, str);
    }

    public static oj[] values() {
        return (oj[]) e.clone();
    }

    private oj(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
