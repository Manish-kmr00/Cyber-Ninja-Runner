package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.q50[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.q50[]) from 0x0088: INVOKE (r0v1 com.yandex.mobile.ads.impl.q50[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class q50 {
    d("NO_ERROR"),
    e("PROTOCOL_ERROR"),
    f("INTERNAL_ERROR"),
    g("FLOW_CONTROL_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("SETTINGS_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF5("STREAM_CLOSED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("FRAME_SIZE_ERROR"),
    h("REFUSED_STREAM"),
    i("CANCEL"),
    /* JADX INFO: Fake field, exist only in values array */
    EF91("COMPRESSION_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF100("CONNECT_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF109("ENHANCE_YOUR_CALM"),
    /* JADX INFO: Fake field, exist only in values array */
    EF118("INADEQUATE_SECURITY"),
    /* JADX INFO: Fake field, exist only in values array */
    EF127("HTTP_1_1_REQUIRED");

    public static final a c;
    private final int b;

    static {
        EnumEntriesKt.enumEntries(q50VarArr);
        c = new a(0);
    }

    public static q50 valueOf(String str) {
        return (q50) Enum.valueOf(q50.class, str);
    }

    public static q50[] values() {
        return (q50[]) j.clone();
    }

    private q50(String str) {
        super(str, i);
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public static final class a {
        public static q50 a(int i) {
            for (q50 q50Var : q50.values()) {
                if (q50Var.a() == i) {
                    return q50Var;
                }
            }
            return null;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
