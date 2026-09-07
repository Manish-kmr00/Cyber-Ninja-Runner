package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.qs[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.qs[]) from 0x005a: INVOKE (r0v1 com.yandex.mobile.ads.impl.qs[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class qs {
    d("banner"),
    e("interstitial"),
    f("rewarded"),
    g("native"),
    h("instream"),
    i("appopenad"),
    j("feed");

    public static final a c;
    private final String b;

    static {
        EnumEntriesKt.enumEntries(qsVarArr);
        c = new a(0);
    }

    public static qs valueOf(String str) {
        return (qs) Enum.valueOf(qs.class, str);
    }

    public static qs[] values() {
        return (qs[]) k.clone();
    }

    private qs(String str) {
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
