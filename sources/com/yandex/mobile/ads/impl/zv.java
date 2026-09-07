package com.yandex.mobile.ads.impl;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.zv[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.zv[]) from 0x0040: INVOKE (r0v1 com.yandex.mobile.ads.impl.zv[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class zv {
    c("cross_clicked"),
    d("cross_timer_start"),
    e("cross_timer_end"),
    f("failed_to_create_download_manager"),
    /* JADX INFO: Fake field, exist only in values array */
    EF55("listener_is_null_on_loading_finished");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(zvVarArr);
    }

    public static zv valueOf(String str) {
        return (zv) Enum.valueOf(zv.class, str);
    }

    public static zv[] values() {
        return (zv[]) g.clone();
    }

    private zv(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
