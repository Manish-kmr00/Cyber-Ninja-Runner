package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v2 com.yandex.mobile.ads.impl.mn0[], still in use, count: 1, list:
  (r1v2 com.yandex.mobile.ads.impl.mn0[]) from 0x001a: INVOKE (r1v2 com.yandex.mobile.ads.impl.mn0[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes9.dex */
public final class mn0 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("design_v1"),
    /* JADX INFO: Fake field, exist only in values array */
    EF17("instream_design_v2");

    public static final a c;
    private static final mn0 d;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(mn0VarArr);
        c = new a(0);
        d = mn0Var;
    }

    public static mn0 valueOf(String str) {
        return (mn0) Enum.valueOf(mn0.class, str);
    }

    public static mn0[] values() {
        return (mn0[]) e.clone();
    }

    private mn0(String str) {
        super(str, i);
        this.b = str;
    }

    public final String b() {
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
