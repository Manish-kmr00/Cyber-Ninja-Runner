package com.yandex.mobile.ads.impl;

import com.facebook.internal.AnalyticsEvents;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.o6[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.o6[]) from 0x001c: INVOKE (r0v1 com.yandex.mobile.ads.impl.o6[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
public final class o6 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC),
    c("manual");

    private final String b;

    static {
        EnumEntriesKt.enumEntries(o6VarArr);
    }

    public static o6 valueOf(String str) {
        return (o6) Enum.valueOf(o6.class, str);
    }

    public static o6[] values() {
        return (o6[]) d.clone();
    }

    private o6(String str) {
        super(str, i);
        this.b = str;
    }

    public final String a() {
        return this.b;
    }
}
