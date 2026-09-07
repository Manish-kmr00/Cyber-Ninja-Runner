package com.ogury.ad.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.ogury.ad.internal.k1[], still in use, count: 1, list:
  (r0v1 com.ogury.ad.internal.k1[]) from 0x00be: INVOKE (r0v1 com.ogury.ad.internal.k1[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
/* JADX INFO: loaded from: classes2.dex */
public final class k1 {
    DEVICE_ID(0),
    AD_TRACKING_SETTING(1),
    INSTANCE_TOKEN(2),
    DEVICE_NAME(3),
    DEVICE_SIZE(4),
    DEVICE_ORIENTATION(5),
    LAYOUT_SIZE(6),
    UI_MODE(7),
    TIMEZONE(8),
    LOCALE_LANGUAGE(9),
    LOCALE_COUNTRY(10),
    MOBILE_COUNTRY(11),
    CONNECTIVITY(12),
    WEBVIEW_USER_AGENT(13),
    ARCHITECTURE(16),
    HPE_EXPERIENCE(17);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7335a;

    static {
        EnumEntriesKt.enumEntries(k1VarArr);
    }

    public k1(int i) {
        super(str, i);
        this.f7335a = i;
    }

    public static k1 valueOf(String str) {
        return (k1) Enum.valueOf(k1.class, str);
    }

    public static k1[] values() {
        return (k1[]) r.clone();
    }
}
